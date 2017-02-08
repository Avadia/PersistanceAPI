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
import net.samagames.persistanceapi.beans.permissions.HubPermissionsBean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HubPermissionManager
{
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
    HubPermissionsBean hubPermissionsBean = null;

    // Get the permissions for the hub
    public HubPermissionsBean getHubPermission(PlayerBean player, DataSource dataSource) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "select groups_id, hub_jukebox_lock, hub_jukebox_next, hub_jukebox_clear, hub_mod_slow, hub_mod_shutup, hub_admin_npc, hub_admin_sign, hub_anguille,";
            sql += " hub_jukebox_nbs, hub_admin_evacuate, hub_announce, hub_gadgets_cooldownbypass, hub_gadgets_nuke, hub_jukebox_limitbypass, hub_jukebox_limitstaff,";
            sql += " hub_bypassmute, hub_fly, hub_debug_sign, hub_sign_selection, hub_beta_vip, hub_admin_pearl, hub_animating_event";
            sql += " from hub_permissions where groups_id=" + player.getGroupId();

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if(resultset.next())
            {
                // There's a result
                long groupId = resultset.getLong("groups_id");
                boolean hubJukeboxLock = resultset.getBoolean("hub_jukebox_lock");
                boolean hubJukeboxNext = resultset.getBoolean("hub_jukebox_next");
                boolean hubJukeBoxClear = resultset.getBoolean("hub_jukebox_clear");
                boolean hubModSlow = resultset.getBoolean("hub_mod_slow");
                boolean hubModShutup = resultset.getBoolean("hub_mod_shutup");
                boolean hubAdminNpc = resultset.getBoolean("hub_admin_npc");
                boolean hubAdminSign = resultset.getBoolean("hub_admin_sign");
                boolean hubAnguille = resultset.getBoolean("hub_anguille");
                boolean hubJukeboxNbs = resultset.getBoolean("hub_jukebox_nbs");
                boolean hubAdminEvacuate = resultset.getBoolean("hub_admin_evacuate");
                boolean hubAnnounce = resultset.getBoolean("hub_announce");
                boolean hubGadgetsCooldownbypass = resultset.getBoolean("hub_gadgets_cooldownbypass");
                boolean hubGadgetsNuke = resultset.getBoolean("hub_gadgets_nuke");
                boolean hubJukeboxLimitbypass = resultset.getBoolean("hub_jukebox_limitbypass");
                boolean hubJukeboxLimitstaff = resultset.getBoolean("hub_jukebox_limitstaff");
                boolean hubBypassmute = resultset.getBoolean("hub_bypassmute");
                boolean hubFly = resultset.getBoolean("hub_fly");
                boolean hubDebugSign = resultset.getBoolean("hub_debug_sign");
                boolean hubSignSelection = resultset.getBoolean("hub_sign_selection");
                boolean hubBetaVIP = resultset.getBoolean("hub_beta_vip");
                boolean hubAdminPearl = resultset.getBoolean("hub_admin_pearl");
                boolean hubAnimatingEvent = resultset.getBoolean("hub_animating_event");
                hubPermissionsBean = new HubPermissionsBean(groupId, hubJukeboxLock, hubJukeboxNext, hubJukeBoxClear, hubModSlow, hubModShutup, hubAdminNpc, hubAdminSign, hubAnguille,
                        hubJukeboxNbs, hubAdminEvacuate, hubAnnounce, hubGadgetsCooldownbypass, hubGadgetsNuke, hubJukeboxLimitbypass, hubJukeboxLimitstaff, hubBypassmute, hubFly,
                        hubDebugSign, hubSignSelection, hubBetaVIP, hubAdminPearl, hubAnimatingEvent);
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
        return hubPermissionsBean;
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
