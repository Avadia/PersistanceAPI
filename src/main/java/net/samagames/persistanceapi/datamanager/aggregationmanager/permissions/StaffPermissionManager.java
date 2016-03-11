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
import net.samagames.persistanceapi.beans.permissions.StaffPermissionsBean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaffPermissionManager
{
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
    StaffPermissionsBean staffPermissionsBean = null;

    // Get the permissions for staff
    public StaffPermissionsBean getStaffPermission(PlayerBean player, DataSource dataSource)
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "select groups_id, staff_member, netjoin_closed, netjoin_vip, netjoin_full, tracker_famous";
            sql += " from staff_permissions where groups_id=" + player.getGroupId();

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if(resultset.next())
            {
                // There's a result
                long groupId = resultset.getLong("groups_id");
                boolean staffMember = resultset.getBoolean("staff_member");
                boolean netjoinClosed = resultset.getBoolean("netjoin_closed");
                boolean netjoinVip = resultset.getBoolean("netjoin_vip");
                boolean netjoinFull = resultset.getBoolean("netjoin_full");
                boolean trackerFamous = resultset.getBoolean("tracker_famous");
                staffPermissionsBean = new StaffPermissionsBean(groupId, staffMember, netjoinClosed, netjoinVip, netjoinFull, trackerFamous);
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
        return staffPermissionsBean;
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
