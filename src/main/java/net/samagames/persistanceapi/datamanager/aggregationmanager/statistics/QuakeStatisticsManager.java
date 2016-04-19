/*
===============================================================
   _____                       ______
  / ___/____ _____ ___  ____ _/ ____/___ _____ ___  ___  _____
  \__ \/ __ `/ __ `__ \/ __ `/ / __/ __ `/ __ `__ \/ _ \/ ___/
 ___/ / /_/ / / / / / / /_/ / /_/ / /_/ / / / / / /  __(__  )
/____/\__,_/_/ /_/ /_/\__,_/\____/\__,_/_/ /_/ /_/\___/____/

===============================================================
  Persistance API
  Copyright (c) for SamaGames, all right reserved
  By MisterSatch, January 2016
===============================================================
*/

package net.samagames.persistanceapi.datamanager.aggregationmanager.statistics;

import net.samagames.persistanceapi.beans.players.PlayerBean;
import net.samagames.persistanceapi.beans.statistics.LeaderboardBean;
import net.samagames.persistanceapi.beans.statistics.QuakeStatisticsBean;
import net.samagames.persistanceapi.utils.Transcoder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuakeStatisticsManager
{
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
    QuakeStatisticsBean quakeStats = null;

    // Get Quake player statistics
    public QuakeStatisticsBean getQuakeStatistics(PlayerBean player, DataSource dataSource) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select (HEX(uuid)) as uuid, deaths, kills, played_games, wins, creation_date, update_date, played_time from quake_stats";
            sql +=" where uuid=(UNHEX('"+ Transcoder.Encode(player.getUuid().toString())+"'))";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if (resultset.next())
            {
                // There's a result
                String playerUuid = Transcoder.Decode(resultset.getString("uuid"));
                UUID uuid = UUID.fromString(playerUuid);
                int deaths = resultset.getInt("deaths");
                int kills = resultset.getInt("kills");
                int playedGames = resultset.getInt("played_games");
                int wins = resultset.getInt("wins");
                Timestamp creationDate = resultset.getTimestamp("creation_date");
                Timestamp updateDate = resultset.getTimestamp("update_date");
                long playedTime = resultset.getLong("played_time");
                quakeStats = new QuakeStatisticsBean(uuid, deaths, kills, playedGames, wins, creationDate, updateDate, playedTime);
            }
            else
            {
                // If there no HeroBattle stats int the database create empty one
                this.close();
                this.createEmptyQuakeStatistics(player, dataSource);
                this.close();
                QuakeStatisticsBean newQuakeStats = this.getQuakeStatistics(player,dataSource);
                this.close();
                return newQuakeStats;
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            this.close();
        }
        return quakeStats;
    }

    // Create an empty quake statistics
    private void createEmptyQuakeStatistics(PlayerBean player, DataSource dataSource) throws Exception
    {
        try
        {
            // Create empty bean
            quakeStats = new QuakeStatisticsBean(player.getUuid(), 0, 0, 0, 0, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 0);

            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction for create
            String sql = "";
            sql += "insert into quake_stats (uuid, deaths, kills, played_games, wins, creation_date, update_date, played_time)";
            sql += " values (UNHEX('"+ Transcoder.Encode(player.getUuid().toString())+"')";
            sql += ", " + quakeStats.getDeaths();
            sql += ", " + quakeStats.getKills();
            sql += ", " + quakeStats.getPlayedGames();
            sql += ", " + quakeStats.getWins();
            sql += ", now()";
            sql += ", now()";
            sql += ", " + quakeStats.getPlayedTime() +")";

            // Execute the query
            statement.executeUpdate(sql);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            this.close();
        }
    }

    // Update Quake player statistics
    public void updateQuakeStatistics(PlayerBean player, QuakeStatisticsBean quakeStats, DataSource dataSource) throws Exception
    {
        try
        {
            // Check if a record exists
            if (this.getQuakeStatistics(player, dataSource) == null)
            {
                // Create an empty quake statistics
                this.createEmptyQuakeStatistics(player, dataSource);
            }
            else
            {

                // Set connection
                connection = dataSource.getConnection();
                statement = connection.createStatement();

                // Query construction for update
                String sql = "";
                sql += "update quake_stats set deaths=" + quakeStats.getDeaths();
                sql += ", kills=" + quakeStats.getKills();
                sql += ", played_games=" + quakeStats.getPlayedGames();
                sql += ", wins=" + quakeStats.getWins();
                sql += ", update_date=now()";
                sql += ", played_time=" + quakeStats.getPlayedTime();
                sql += " where uuid=(UNHEX('"+ Transcoder.Encode(player.getUuid().toString())+"'))";

                // Execute the query
                statement.executeUpdate(sql);
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
    }

    // Get the board for this game
    public List<LeaderboardBean> getLeaderBoard(String category, DataSource dataSource) throws Exception
    {
        List<LeaderboardBean> leaderBoard = new ArrayList<>();
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "select p.name as name, d." + category + " as score from players as p, quake_stats as d where p.uuid=d.uuid order by d." + category + " desc limit 3";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while(resultset.next())
            {
                LeaderboardBean bean = new LeaderboardBean(resultset.getString("name"), resultset.getInt("score"));
                leaderBoard.add(bean);
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
        return leaderBoard;
    }

    // Close all connection
    public void close() throws Exception
    {
        // Close the query environment in order to prevent leaks
        try
        {
            if (resultset != null)
            {
                // Close the resulset
                resultset.close();
            }
            if (statement != null)
            {
                // Close the statement
                statement.close();
            }
            if (connection != null)
            {
                // Close the connection
                connection.close();
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
    }
}
