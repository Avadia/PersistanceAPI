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

import net.samagames.persistanceapi.beans.FriendshipBean;
import net.samagames.persistanceapi.beans.PlayerBean;
import net.samagames.persistanceapi.utils.Transcoder;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class FriendshipManager
{
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
    ArrayList<FriendshipBean> friendshipList = new ArrayList<>(); // Fixme see for concurrency !
    //List friendshipList = Collections.synchronizedList(new ArrayList<FriendshipBean>);

    // Make a friendship demand
    public void postFriendshipDemand(FriendshipBean friendship, DataSource dataSource)
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "insert into friendship(requester_uuid, requester_name, recipient_uuid, recipient_name, demand_date, active_status)";
            sql += " values (UNHEX('"+ Transcoder.Encode(friendship.getRequesterUUID().toString())+"')";
            sql += ", '" + friendship.getRequesterName() + "'";
            sql += ", UNHEX('"+ Transcoder.Encode(friendship.getRecipientUUID().toString())+"')";
            sql += ", '" + friendship.getRecipientName() + "'";
            sql += ", now(), false)";

            // Execute the query
            statement.executeUpdate(sql);
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
    }

    // Accept a friendship demand
    public void acceptFriendshipDemand(FriendshipBean friendship, DataSource dataSource)
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "update friendship set active_status=true, acceptation_date=now()";
            sql += "where friendship_id=" + friendship.getFriendshipId();

            // Execute the query
            statement.executeUpdate(sql);
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
    }

    // Refuse a firendship demand
    public void refuseFriendshipDemand(FriendshipBean friendship, DataSource dataSource)
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "delete from friendship where friendship_id=" + friendship.getFriendshipId();

            // Execute the query
            statement.executeUpdate(sql);
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
    }

    // Get friendship demand list
    public ArrayList<FriendshipBean> getFriendshipDemandList(PlayerBean player, DataSource dataSource)
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "select friendship_id, HEX(requester_uuid) as requester, requester_name, HEX(recipient_uuid) as recipient, recipient_name, demand_date, acceptation_date, active_status";
            sql += " from friendship where recipient_uuid=(UNHEX('" + Transcoder.Encode(player.getUuid().toString()) + "'))";
            sql += " and active_status=false";
            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a list of bean
            while(resultset.next())
            {
                long friendshipId = resultset.getLong("friendship_id");
                String requester = Transcoder.Decode(resultset.getString("requester"));
                UUID requesterUuid = UUID.fromString(requester);
                String requesterName = resultset.getString("requester_name");
                String recipient = Transcoder.Decode(resultset.getString("recipient"));
                UUID recipientUuid = UUID.fromString(recipient);
                String recipientName = resultset.getString("recipient_name");
                Timestamp demandDate = resultset.getTimestamp("demand_date");
                Timestamp acceptationDate = resultset.getTimestamp("acceptation_date");
                boolean activeStatus = resultset.getBoolean("active_status");
                FriendshipBean friendshipBean = new FriendshipBean(friendshipId, requesterUuid, requesterName, recipientUuid, recipientName, demandDate, acceptationDate, activeStatus);
                friendshipList.add(friendshipBean);
            }
            return friendshipList;
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
        return friendshipList;
    }

    // Get friendship list for a player
    public ArrayList<FriendshipBean>  getFriendshipList(PlayerBean player, DataSource dataSource)
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "select friendship_id, HEX(requester_uuid) as requester, requester_name, HEX(recipient_uuid) as recipient, recipient_name, demand_date, acceptation_date, active_status";
            sql += " from friendship where recipient_uuid=(UNHEX('" + Transcoder.Encode(player.getUuid().toString()) + "'))";
            sql += " and active_status=true";
            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a list of bean
            while(resultset.next())
            {
                long friendshipId = resultset.getLong("friendship_id");
                String requester = Transcoder.Decode(resultset.getString("requester"));
                UUID requesterUuid = UUID.fromString(requester);
                String requesterName = resultset.getString("requester_name");
                String recipient = Transcoder.Decode(resultset.getString("recipient"));
                UUID recipientUuid = UUID.fromString(recipient);
                String recipientName = resultset.getString("recipient_name");
                Timestamp demandDate = resultset.getTimestamp("demand_date");
                Timestamp acceptationDate = resultset.getTimestamp("acceptation_date");
                boolean activeStatus = resultset.getBoolean("active_status");
                FriendshipBean friendshipBean = new FriendshipBean(friendshipId, requesterUuid, requesterName, recipientUuid, recipientName, demandDate, acceptationDate, activeStatus);
                friendshipList.add(friendshipBean);
            }
            return friendshipList;
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
        return friendshipList;
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
