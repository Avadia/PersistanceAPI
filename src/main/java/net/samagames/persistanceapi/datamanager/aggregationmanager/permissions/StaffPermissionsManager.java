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
import net.samagames.persistanceapi.beans.permissions.StaffPermissionsBean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StaffPermissionsManager
{
    // Defines
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultset = null;

    // Get the permissions for staff
    public StaffPermissionsBean getStaffPermissions(PlayerBean player, DataSource dataSource) throws Exception
    {
        StaffPermissionsBean staffPermissionsBean = null;

        try
        {
            // Set connection
            connection = dataSource.getConnection();

            // Query construction
            String sql = "select groups_id, netjoin_closed, netjoin_vip, netjoin_full, tracker_famous, network_vip, network_vip_plus, network_staff, network_admin";
            sql += " from staff_permissions where groups_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setLong(1, player.getGroupId());

            // Execute the query
            resultset = statement.executeQuery();

            // Manage the result in a bean
            if(resultset.next())
            {
                // There's a result
                long groupsId = resultset.getLong("groups_id");
                boolean netjoinClosed = resultset.getBoolean("netjoin_closed");
                boolean netjoinVip = resultset.getBoolean("netjoin_vip");
                boolean netjoinFull = resultset.getBoolean("netjoin_full");
                boolean trackerFamous = resultset.getBoolean("tracker_famous");
                boolean networkVip = resultset.getBoolean("network_vip");
                boolean networkVipplus = resultset.getBoolean("network_vip_plus");
                boolean networkStaff = resultset.getBoolean("network_staff");
                boolean networkAdmin = resultset.getBoolean("network_admin");
                staffPermissionsBean = new StaffPermissionsBean(groupsId, netjoinClosed, netjoinVip, netjoinFull, trackerFamous, networkVip, networkVipplus, networkStaff, networkAdmin);
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

        return staffPermissionsBean;
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
