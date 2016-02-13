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

package net.samagames.persistanceapi.datamanager;

import net.samagames.persistanceapi.beans.PlayerBean;
import net.samagames.persistanceapi.utils.Transcoder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.UUID;


public class PlayerManager
{
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
    boolean nestedQuery = false;

    // Get player by UUID, create if unknown
    public PlayerBean getPlayer(UUID uuid, PlayerBean player, DataSource dataSource)
    {
        // Make the research of player by UUID
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Set flag for nested query
            this.nestedQuery = true;

            // Query construction
            String sql = "";
            sql += "select (HEX(uuid)) as uuid, name, coins, stars, last_login, first_login, last_ip, toptp_key from players where uuid=(UNHEX('"+ Transcoder.Encode(uuid.toString())+"'))";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if (resultset.next())
            {
                // There's a result
                String playerUuid = Transcoder.Decode(resultset.getString("uuid"));
                String name = resultset.getString("name");
                int coins = resultset.getInt("coins");
                int stars = resultset.getInt("stars");
                Timestamp lastLogin = resultset.getTimestamp("last_login");
                Timestamp firsLogin = resultset.getTimestamp("first_login");
                String lastIP = resultset.getString("last_ip");
                String toptpKey = resultset.getString("toptp_key");
                player = new PlayerBean(UUID.fromString(playerUuid), name, coins, stars, lastLogin, firsLogin, lastIP, toptpKey);
                return player;
            }
            else
            {
                // If there no player for the uuid in database create a new player
                this.createPlayer(player, dataSource);
                PlayerBean newPlayer = this.getPlayer(uuid, player, dataSource);
                return newPlayer;
            }
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
        return player;
    }

    // Try to recover a suspect UUID by name
    public UUID recoverSuspect(String suspectName, DataSource dataSource)
    {
        // Defines
        PlayerBean player = null;
        UUID suspectUUID = null;

        // Try to find the player
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select (HEX(uuid)) as uuid from players where name='" + suspectName + "'";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if (resultset.next())
            {
                // There's a result
                String playerUuid = Transcoder.Decode(resultset.getString("uuid"));
                suspectUUID = UUID.fromString(playerUuid);
                return suspectUUID;
            }
            else
            {
                // If there no player for the uuid in database
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
        return suspectUUID;
    }

    // Update the player data
    public void updatePlayer(PlayerBean player, DataSource dataSource)
    {
        // Update the players data
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "update players set coins=" + player.getCoins();
            sql += ", stars=" + player.getStars();
            sql += ", last_login='" + player.getLastLogin() +"'";
            sql += ", last_ip='" + player.getLastIP() +"'";
            sql += ", toptp_key='" + player.getToptpKey() +"'";
            sql += " where uuid=(UNHEX('" + Transcoder.Encode(player.getUuid().toString()) + "'))";

            // Execute the query
            statement.executeUpdate(sql);
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
    }

    // Create the player
    public void createPlayer(PlayerBean player, DataSource dataSource)
    {
        // Create the player
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "insert into players (uuid, name, coins, stars, last_login, first_login, last_ip, toptp_key)";
            sql += " values (UNHEX('"+ Transcoder.Encode(player.getUuid().toString())+"')";
            sql += ", '" + player.getName() + "'";
            sql += ", " + player.getCoins();
            sql += ", " + player.getStars();
            sql += ", now(), now()";
            sql += ", '" + player.getLastIP() + "'";
            sql +=", '" + player.getToptpKey() + "')";

            // Execute the query
            statement.executeUpdate(sql);
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
    }

    // Close the connection
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
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
    }
}
