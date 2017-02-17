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


package net.samagames.persistanceapi.datamanager.aggregationmanager.permissions;

import net.samagames.persistanceapi.beans.players.PlayerBean;
import net.samagames.persistanceapi.beans.permissions.BukkitPermissionsBean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BukkitPermissionsManager
{
    // Defines
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultset = null;

    // Get the permissions for Bukkit
    public BukkitPermissionsBean getBukkitPermissions(PlayerBean player, DataSource dataSource) throws Exception
    {
        BukkitPermissionsBean bukkitPermissionsBean = null;

        try
        {
            // Set connection
            connection = dataSource.getConnection();

            // Query construction
            String sql = "select groups_id, minecraft_command_op, bukkit_command_op_give, bukkit_command_effect, bukkit_command_gamemode, bukkit_command_teleport";
            sql += " from bukkit_permissions where groups_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setLong(1, player.getGroupId());

            // Execute the query
            resultset = statement.executeQuery();

            // Manage the result in a bean
            if(resultset.next())
            {
                // There's a result
                long groupId = resultset.getLong("groups_id");
                boolean minecraftCommandOp = resultset.getBoolean("minecraft_command_op");
                boolean bukkitCommandOpGive = resultset.getBoolean("bukkit_command_op_give");
                boolean bukkitCommandEffect = resultset.getBoolean("bukkit_command_effect");
                boolean bukkitCommandGamemode = resultset.getBoolean("bukkit_command_gamemode");
                boolean bukkitCommandTeleport = resultset.getBoolean("bukkit_command_teleport");

                bukkitPermissionsBean = new BukkitPermissionsBean(groupId,
                        minecraftCommandOp, bukkitCommandOpGive, bukkitCommandEffect, bukkitCommandGamemode,
                        bukkitCommandTeleport);
            }
            else
            {
                // If there no dimension stats int the database
                return null;
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

        return bukkitPermissionsBean;
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