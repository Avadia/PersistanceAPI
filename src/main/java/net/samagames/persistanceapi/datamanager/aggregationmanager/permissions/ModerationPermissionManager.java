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

import net.samagames.persistanceapi.beans.PlayerBean;
import net.samagames.persistanceapi.beans.permissions.APIPermissionsBean;
import net.samagames.persistanceapi.beans.permissions.ModerationPermissionsBean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModerationPermissionManager
{
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
    ModerationPermissionsBean moderationPermissionsBean = null;

    // Get the permissions for moderation
    public ModerationPermissionsBean getPermission(PlayerBean player, DataSource dataSource)
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "select groups_id, mod_ban, mod_tp, mod_kick, mod_pardon, mod_mute_longtime, mod_mute, mod_channel";
            sql += " from moderation_permissions where group_id=" + player.getGroupId();

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if(resultset.next())
            {
                // There's a result
                long groupId = resultset.getLong("group_id");
                boolean modBan = resultset.getBoolean("mod_ban");
                boolean modTp = resultset.getBoolean("mod_tp");
                boolean modKick = resultset.getBoolean("mod_kick");
                boolean modPardon = resultset.getBoolean("mod_pardon");
                boolean modMuteLongtime = resultset.getBoolean("mod_mute_longtime");
                boolean modMute = resultset.getBoolean("mod_mute");
                boolean modChannel = resultset.getBoolean("mod_channel");
                moderationPermissionsBean = new ModerationPermissionsBean(groupId, modBan, modTp, modKick, modPardon, modMuteLongtime, modMute, modChannel);
            }
            else
            {
                // If there no dimension stats int the database
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
        return moderationPermissionsBean;
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
