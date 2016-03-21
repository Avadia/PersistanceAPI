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

import net.samagames.persistanceapi.beans.BungeeConfigBean;
import javax.sql.DataSource;
import java.sql.*;


public class ConfigurationManager
{
    // Defines
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null;

    // Get the bungee config
    public BungeeConfigBean getConfig(DataSource dataSource)
    {
        // Make the research of player by UUID
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select slots, motd, close_type, server_line, max_players from configuration";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if (resultset.next())
            {
                // There's a result
                int slots = resultset.getInt("slots");
                String motd = resultset.getString("motd");
                String closeType = resultset.getString("close_type");
                String serverLine = resultset.getString("server_line");
                int maxPlayers = resultset.getInt("max_players");
                BungeeConfigBean config = new BungeeConfigBean(slots, motd, closeType, serverLine, maxPlayers);
                return config;
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
        return null;
    }

    // Update the bungee config
    public void updateConfig(BungeeConfigBean config, DataSource dataSource)
    {
        // Update the config
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "update configuration set slots=" + config.getSlots();
            sql += ", motd='" + config.getMotd() + "'";
            sql += ", close_type='" + config.getCloseType() + "'";
            sql += ", server_line='" + config.getServerLine() + "'";
            sql += ", max_players=" + config.getMaxPlayers();

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
