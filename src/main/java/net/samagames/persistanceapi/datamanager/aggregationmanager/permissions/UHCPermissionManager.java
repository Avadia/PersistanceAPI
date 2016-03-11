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
import net.samagames.persistanceapi.beans.permissions.UHCPermissionsBean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UHCPermissionManager
{
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
    UHCPermissionsBean uhcPermissionsBean = null;

    public UHCPermissionsBean getUHCPermission(PlayerBean player, DataSource dataSource)
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "select groups_id, uhc_team_lock, uhc_team_name, uhc_team_invite";
            sql += " from uhc_permissions where group_id=" + player.getGroupId();

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if(resultset.next())
            {
                // There's a result
                long groupId = resultset.getLong("group_id");
                boolean uhcTeamLock = resultset.getBoolean("uhc_team_lock");
                boolean uhcTeamName = resultset.getBoolean("uhc_team_name");
                boolean uhcTeamInvite = resultset.getBoolean("uhc_team_invite");
                uhcPermissionsBean = new UHCPermissionsBean(groupId, uhcTeamLock, uhcTeamName, uhcTeamInvite);
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
        return uhcPermissionsBean;
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
