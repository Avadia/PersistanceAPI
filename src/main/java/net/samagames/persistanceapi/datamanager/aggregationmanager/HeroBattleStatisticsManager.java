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

package net.samagames.persistanceapi.datamanager.aggregationmanager;

import net.samagames.persistanceapi.beans.PlayerBean;
import net.samagames.persistanceapi.beans.statistics.HeroBattleStatisticsBean;
import net.samagames.persistanceapi.utils.Transcoder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.UUID;

public class HeroBattleStatisticsManager
{
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
    HeroBattleStatisticsBean heroBattleStats = null;

    // Get HeroBattle player statistics
    public HeroBattleStatisticsBean getHeroBattleStatistics(PlayerBean player, DataSource dataSource)
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
                // If there no HeroBattle stats int the database
                return null;
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
        return heroBattleStats;
    }

    // Update Dimension player statistics
    public void updateHeroBattleStatistics(PlayerBean player, HeroBattleStatisticsBean dimensionStats, DataSource dataSource)
    {
        try
        {
            // Check if a record exists
            if (this.getHeroBattleStatistics(player, dataSource) == null)
            {
                // Set connection
                connection = dataSource.getConnection();
                statement = connection.createStatement();

                // Query construction for create
                String sql = "";
                sql += "insert into herobattle_stats (uuid, deaths, elo, kills, played_games, powerup_taken, wins, creation_date, update_date, played_time)";
                sql += " values (UNHEX('"+ Transcoder.Encode(player.getUuid().toString())+"')";
                sql += ", " + dimensionStats.getDeaths();
                sql += ", " + dimensionStats.getElo();
                sql += ", " + dimensionStats.getKills();
                sql += ", " + dimensionStats.getPlayedGames();
                sql += ", " + dimensionStats.getPowerUpTaken();
                sql += ", " + dimensionStats.getWins();
                sql += ", now()";
                sql += ", now()";
                sql += ", " + dimensionStats.getPlayedGames() + ")";

                // Execute the query
                statement.executeUpdate(sql);
            }
            else
            {
                // Set connection
                connection = dataSource.getConnection();
                statement = connection.createStatement();

                // Query construction for update
                String sql = "";
                sql += "update herobattle_stats set deaths=" + dimensionStats.getDeaths();
                sql += ", elo=" + dimensionStats.getElo();
                sql += ", kills=" + dimensionStats.getKills();
                sql += ", played_games=" + dimensionStats.getPlayedGames();
                sql += ", powerup_taken=" + dimensionStats.getPowerUpTaken();
                sql += ", wins=" + dimensionStats.getWins();
                sql += ", update_date=now()";
                sql += ", played_time=" + dimensionStats.getPlayedGames();
                sql += " where uuid=(UNHEX('"+ Transcoder.Encode(player.getUuid().toString())+"'))";

                // Execute the query
                statement.executeUpdate(sql);
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
    }

    // Close all connection
    public void close()
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
        }
    }
}
