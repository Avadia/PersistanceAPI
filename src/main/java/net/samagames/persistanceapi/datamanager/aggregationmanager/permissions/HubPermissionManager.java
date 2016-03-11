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
import net.samagames.persistanceapi.beans.permissions.HubPermissionsBean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HubPermissionManager
{
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
    HubPermissionsBean hubPermissionsBean = null;

    public HubPermissionsBean getPermission(PlayerBean player, DataSource dataSource)
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "select group_id, hub_jukebox_lock, hub_jukebox_next, hub_jukebox_clear, hub_mod_slow, hub_mod_shutup, hub_admin_npc, hub_admin_sign, hub_anguille," +
                    " hub_jukebox_nbs, hub_admin_evacuate, hub_announce, hub_gadgets_cooldownbypass, hub_gadgets_nuke, hub_jukebox_limitbypass, hub_jukebox_limitstaff," +
                    " hub_bypassmute, hub_fly, hub_debug_sign";
            sql += " from hub_permissions where group_id=" + player.getGroupId();

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if(resultset.next())
            {
                // There's a result
                long groupId = resultset.getLong("group_id");
                boolean hubJukeboxLock = resultset.getBoolean("");
                boolean hubJukeboxNext = resultset.getBoolean("");
                boolean hubJukeBoxClear = resultset.getBoolean("");
                boolean hubModSlow = resultset.getBoolean("");
                boolean hubModShutup = resultset.getBoolean("");
                boolean hubAdminNpc = resultset.getBoolean("");
                boolean hubAdminSign = resultset.getBoolean("");
                boolean hubAnguille = resultset.getBoolean("");
                boolean hubJukeboxNbs = resultset.getBoolean("");
                boolean hubAdminEvacuate = resultset.getBoolean("");
                boolean hubAnnounce = resultset.getBoolean("");
                boolean hubGadgetsCooldownbypass = resultset.getBoolean("");
                boolean hubGadgetsNuke = resultset.getBoolean("");
                boolean hubJukeboxLimitbypass = resultset.getBoolean("");
                boolean hubJukeboxLimitstaff = resultset.getBoolean("");
                boolean hubBypassmute = resultset.getBoolean("");
                boolean hubFly = resultset.getBoolean("");
                boolean hubDebugSign = resultset.getBoolean("");
                hubPermissionsBean = new HubPermissionsBean(groupId, hubJukeboxLock, hubJukeboxNext, hubJukeBoxClear, hubModSlow, hubModShutup, hubAdminNpc, hubAdminSign, hubAnguille,
                        hubJukeboxNbs, hubAdminEvacuate, hubAnnounce, hubGadgetsCooldownbypass, hubGadgetsNuke, hubJukeboxLimitbypass, hubJukeboxLimitstaff, hubBypassmute, hubFly,
                        hubDebugSign);
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
        return hubPermissionsBean;
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
