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

import net.samagames.persistanceapi.beans.players.GroupsBean;
import net.samagames.persistanceapi.beans.players.PlayerBean;
import javax.sql.DataSource;
import java.sql.*;

public class GroupsManager
{
    // Defines
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultset = null;
    private GroupsBean groupsBean = null;

    // Get the permission group for a player
    public GroupsBean getPlayerGroup(PlayerBean player, DataSource dataSource) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();

            // Query construction
            String sql = "select group_id, group_name, rank, tag, prefix, suffix, multiplier from groups where group_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setLong(1, player.getGroupId());

            // Execute the query
            resultset = statement.executeQuery();

            // Manage the result in a bean
            if(resultset.next())
            {
                // There's a result
                long groupId = resultset.getLong("group_id");
                String playerName = resultset.getString("group_name");
                int rank = resultset.getInt("rank");
                String tag = resultset.getString("tag");
                String prefix = resultset.getString("prefix");
                String suffix = resultset.getString("suffix");
                int multiplier = resultset.getInt("multiplier");
                groupsBean = new GroupsBean(groupId, playerName, rank, tag, prefix, suffix, multiplier);
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
        return groupsBean;
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
