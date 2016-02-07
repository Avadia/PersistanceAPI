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

package com.samagames.persistanceapi.datamanager.aggregationmanager;

import com.samagames.persistanceapi.beans.PlayerBean;
import com.samagames.persistanceapi.beans.aggregationbean.HeroBattleStatisticsBean;
import com.samagames.persistanceapi.utils.Transcoder;
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
    boolean nestedQuery = false;

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
            // Set flag for nested query
            this.nestedQuery = true;

            // Check if a record exists
            if (this.getHeroBattleStatistics(player, dataSource) == null)
            {
                // Set connection
                connection = dataSource.getConnection();
                statement = connection.createStatement();

                // Query construction for create
                String sql = "";
                sql += "";

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

                // Execute the query
                statement.executeUpdate(sql);
            }

            // Set flag for nested query
            this.nestedQuery = false;
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            // Set flag for nested query
            this.nestedQuery = false;

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
            if (connection != null && this.nestedQuery == false)
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
