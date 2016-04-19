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
import net.samagames.persistanceapi.beans.statistics.HeroBattleStatisticsBean;
import net.samagames.persistanceapi.beans.statistics.LeaderboardBean;
import net.samagames.persistanceapi.utils.Transcoder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HeroBattleStatisticsManager
{
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
    HeroBattleStatisticsBean heroBattleStats = null;

    // Get HeroBattle player statistics
    public HeroBattleStatisticsBean getHeroBattleStatistics(PlayerBean player, DataSource dataSource) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select (HEX(uuid)) as uuid, deaths, elo, kills, played_games, powerup_taken, wins, creation_date, update_date, played_time from herobattle_stats";
            sql += " where uuid=(UNHEX('"+ Transcoder.Encode(player.getUuid().toString())+"'))";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if (resultset.next())
            {
                // There's a result
                String playerUuid = Transcoder.Decode(resultset.getString("uuid"));
                UUID uuid = UUID.fromString(playerUuid);
                int deaths = resultset.getInt("deaths");
                int elo = resultset.getInt("elo");
                int kills = resultset.getInt("kills");
                int playedGames = resultset.getInt("played_games");
                int powerupTaken = resultset.getInt("powerup_taken");
                int wins = resultset.getInt("wins");
                Timestamp creationDate = resultset.getTimestamp("creation_date");
                Timestamp updateDate = resultset.getTimestamp("update_date");
                long playedTime = resultset.getLong("played_time");
                heroBattleStats = new HeroBattleStatisticsBean(uuid, deaths, elo, kills, playedGames, powerupTaken, wins, creationDate, updateDate, playedTime);
            }
            else
            {
                // If there no HeroBattle stats int the database create empty one
                this.close();
                this.createEmptyHeroBattleStatistics(player, dataSource);
                this.close();
                HeroBattleStatisticsBean newHeroBattleStats = this.getHeroBattleStatistics(player,dataSource);
                this.close();
                return newHeroBattleStats;
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
        return heroBattleStats;
    }

    // Create an empty herobattle statistics
    private void createEmptyHeroBattleStatistics(PlayerBean player, DataSource dataSource) throws Exception
    {
        try
        {
            HeroBattleStatisticsBean heroBattleStats = new HeroBattleStatisticsBean(player.getUuid(), 0, 0, 0, 0, 0, 0, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 0);
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction for create
            String sql = "";
            sql += "insert into herobattle_stats (uuid, deaths, elo, kills, played_games, powerup_taken, wins, creation_date, update_date, played_time)";
            sql += " values (UNHEX('"+ Transcoder.Encode(player.getUuid().toString())+"')";
            sql += ", " + heroBattleStats.getDeaths();
            sql += ", " + heroBattleStats.getElo();
            sql += ", " + heroBattleStats.getKills();
            sql += ", " + heroBattleStats.getPlayedGames();
            sql += ", " + heroBattleStats.getPowerUpTaken();
            sql += ", " + heroBattleStats.getWins();
            sql += ", now()";
            sql += ", now()";
            sql += ", " + heroBattleStats.getPlayedGames() + ")";

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

    // Update Dimension player statistics
    public void updateHeroBattleStatistics(PlayerBean player, HeroBattleStatisticsBean heroBattleStats, DataSource dataSource) throws Exception
    {
        try
        {
            // Check if a record exists
            if (this.getHeroBattleStatistics(player, dataSource) == null)
            {
                // Create an empty herobatle statistics
                this.createEmptyHeroBattleStatistics(player, dataSource);
            }
            else
            {
                // Set connection
                connection = dataSource.getConnection();
                statement = connection.createStatement();

                // Query construction for update
                String sql = "";
                sql += "update herobattle_stats set deaths=" + heroBattleStats.getDeaths();
                sql += ", elo=" + heroBattleStats.getElo();
                sql += ", kills=" + heroBattleStats.getKills();
                sql += ", played_games=" + heroBattleStats.getPlayedGames();
                sql += ", powerup_taken=" + heroBattleStats.getPowerUpTaken();
                sql += ", wins=" + heroBattleStats.getWins();
                sql += ", update_date=now()";
                sql += ", played_time=" + heroBattleStats.getPlayedGames();
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
            this.close();
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
            String sql = "select p.name as name, d." + category + " as score from players as p, herobattle_stats as d where p.uuid=d.uuid order by d." + category + " desc limit 3";

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
            this.close();
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
