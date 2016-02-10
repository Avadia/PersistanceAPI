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
    PlayerBean player = null;

    // Get player by UUID
    public PlayerBean getPlayer(UUID uuid, DataSource dataSource)
    {
        // Make the research of player by UUID
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

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
        return player;
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
            if (connection != null)
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
