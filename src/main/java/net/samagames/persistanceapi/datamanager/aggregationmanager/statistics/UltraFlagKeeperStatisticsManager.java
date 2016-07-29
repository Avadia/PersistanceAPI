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
import net.samagames.persistanceapi.beans.statistics.UltraFlagKeeperStatisticsBean;
import net.samagames.persistanceapi.utils.Transcoder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UltraFlagKeeperStatisticsManager
{
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
    UltraFlagKeeperStatisticsBean ultraFlagKeeperStats = null;

    // Get UltraFlagKeeper player statistics
    public UltraFlagKeeperStatisticsBean getUltraFlagKeeperStatistics(PlayerBean player, DataSource dataSource) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select (HEX(uuid)) as uuid, damages, deaths, kills, max_damages, played_games, wins, flags_captured, flags_returned, creation_date, update_date, played_time from ultraflagkeeper_stats";
            sql += " where uuid=(UNHEX('"+ Transcoder.Encode(player.getUuid().toString())+"'))";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if (resultset.next())
            {
                // There's a result
                String playerUuid = Transcoder.Decode(resultset.getString("uuid"));
                UUID uuid = UUID.fromString(playerUuid);
                int damages = resultset.getInt("damages");
                int deaths = resultset.getInt("deaths");
                int kills = resultset.getInt("kills");
                int maxDamages = resultset.getInt("max_damages");
                int playedGames = resultset.getInt("played_games");
                int wins = resultset.getInt("wins");
                int flagsCaptured = resultset.getInt("flags_captured");
                int flagsReturned = resultset.getInt("flags_returned");
                Timestamp creationDate = resultset.getTimestamp("creation_date");
                Timestamp updateDate = resultset.getTimestamp("update_date");
                long playedTime = resultset.getLong("played_time");
                ultraFlagKeeperStats = new UltraFlagKeeperStatisticsBean(uuid, damages, deaths, kills, maxDamages, playedGames, wins, flagsCaptured, flagsReturned, creationDate, updateDate, playedTime);
            }
            else
            {
                // If there no UltraFlagKeeper stats in the database create empty one
                this.close();
                this.createEmptyUltraFlagKeeperStatistics(player, dataSource);
                this.close();
                UltraFlagKeeperStatisticsBean newUltraFlagKeeperStats = this.getUltraFlagKeeperStatistics(player,dataSource);
                this.close();
                return newUltraFlagKeeperStats;
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
        return ultraFlagKeeperStats;
    }

    // Create an empty jukebox statistics
    private void createEmptyUltraFlagKeeperStatistics(PlayerBean player, DataSource dataSource) throws Exception
    {
        try
        {
            // Create an empty bean
            UltraFlagKeeperStatisticsBean ultraFlagKeeperStats = new UltraFlagKeeperStatisticsBean(player.getUuid(), 0, 0, 0, 0, 0, 0, 0, 0, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 0);

            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction for create
            String sql = "insert into ultraflagkeeper_stats (uuid, damages, deaths, kills, max_damages, played_games, wins, flags_captured, flags_returned, creation_date, update_date, played_time)";
            sql += " values (UNHEX('"+ Transcoder.Encode(player.getUuid().toString())+"')";
            sql += ", " + ultraFlagKeeperStats.getDamages();
            sql += ", " + ultraFlagKeeperStats.getDeaths();
            sql += ", " + ultraFlagKeeperStats.getKills();
            sql += ", " + ultraFlagKeeperStats.getMaxDamages();
            sql += ", " + ultraFlagKeeperStats.getPlayedGames();
            sql += ", " + ultraFlagKeeperStats.getWins();
            sql += ", " + ultraFlagKeeperStats.getFlagsCaptured();
            sql += ", " + ultraFlagKeeperStats.getFlagsReturned();
            sql += ", now(), now()";
            sql += ", " + ultraFlagKeeperStats.getPlayedTime() + ")";

            // Execute the query
            statement.executeUpdate(sql);
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

    // Update UltraFlagKeeper player statistics
    public void updateUltraFlagKeeperStatistics(PlayerBean player, UltraFlagKeeperStatisticsBean ultraFlagKeeperStats, DataSource dataSource) throws Exception
    {
        try
        {
            // Check if a record exists
            if (this.getUltraFlagKeeperStatistics(player, dataSource) == null)
            {
                // Create an empty uHC statistics
                this.createEmptyUltraFlagKeeperStatistics(player, dataSource);
            }
            else
            {
                // Set connection
                connection = dataSource.getConnection();
                statement = connection.createStatement();

                // Query construction for update
                String sql = "update ultraflagkeeper_stats set damages=" + ultraFlagKeeperStats.getDamages();
                sql += ", deaths=" + ultraFlagKeeperStats.getDeaths();
                sql += ", kills=" + ultraFlagKeeperStats.getKills();
                sql += ", max_damages=" + ultraFlagKeeperStats.getMaxDamages();
                sql += ", played_games=" + ultraFlagKeeperStats.getPlayedGames();
                sql += ", wins=" + ultraFlagKeeperStats.getWins();
                sql += ", flags_captured=" + ultraFlagKeeperStats.getFlagsCaptured();
                sql += ", flags_returned=" + ultraFlagKeeperStats.getFlagsReturned();
                sql += ", update_date=now()";
                sql += ", played_time=" + ultraFlagKeeperStats.getPlayedTime();
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
            String sql = "select p.name as name, d." + category + " as score from players as p, ultraflagkeeper_stats as d where p.uuid=d.uuid order by d." + category + " desc limit 3";

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
