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


import net.samagames.persistanceapi.beans.players.FriendshipBean;
import net.samagames.persistanceapi.beans.players.PlayerBean;
import net.samagames.persistanceapi.utils.Transcoder;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FriendshipManager
{
    // Defines
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null;

    // Make a friendship demand
    public void postFriendshipDemand(FriendshipBean friendship, DataSource dataSource) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "insert into friendship(requester_uuid, recipient_uuid, demand_date, active_status)";
            sql += " values (UNHEX('"+ Transcoder.Encode(friendship.getRequesterUUID().toString())+"')";
            sql += ", UNHEX('"+ Transcoder.Encode(friendship.getRecipientUUID().toString())+"')";
            sql += ", now(), false)";

            // Execute the query
            statement.executeUpdate(sql);
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
    }

    // Accept a friendship demand
    public void acceptFriendshipDemand(FriendshipBean friendship, DataSource dataSource) throws Exception
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
    }

    // Refuse a firendship demand
    public void refuseFriendshipDemand(FriendshipBean friendship, DataSource dataSource) throws Exception
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
    }

    // Get friendship demand list
    public List<FriendshipBean> getFriendshipDemandList(PlayerBean player, DataSource dataSource) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            List<FriendshipBean> friendshipList = new ArrayList<>();

            // Query construction
            String sql = "select friendship_id, HEX(requester_uuid) as requester, HEX(recipient_uuid) as recipient, demand_date, acceptation_date, active_status";
            sql += " from friendship where recipient_uuid=(UNHEX('" + Transcoder.Encode(player.getUuid().toString()) + "'))";
            sql += " or requester_uuid=(UNHEX('" + Transcoder.Encode(player.getUuid().toString()) + "'))";
            sql += " and active_status=false";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a list of bean
            while(resultset.next())
            {
                long friendshipId = resultset.getLong("friendship_id");
                String requester = Transcoder.Decode(resultset.getString("requester"));
                UUID requesterUuid = UUID.fromString(requester);
                String recipient = Transcoder.Decode(resultset.getString("recipient"));
                UUID recipientUuid = UUID.fromString(recipient);
                Timestamp demandDate = resultset.getTimestamp("demand_date");
                Timestamp acceptationDate = resultset.getTimestamp("acceptation_date");
                boolean activeStatus = resultset.getBoolean("active_status");
                FriendshipBean friendshipBean = new FriendshipBean(friendshipId, requesterUuid, recipientUuid, demandDate, acceptationDate, activeStatus);
                friendshipList.add(friendshipBean);
            }
            return friendshipList;
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
    }

    // Get friendship list for a player
    public List<FriendshipBean>  getFriendshipList(PlayerBean player, DataSource dataSource) throws Exception // FIXME Make it bidirectionnal !
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            List<FriendshipBean> friendshipList = new ArrayList<>();

            // Query construction
            String sql = "select friendship_id, HEX(requester_uuid) as requester, HEX(recipient_uuid) as recipient, demand_date, acceptation_date, active_status";
            sql += " from friendship where recipient_uuid=(UNHEX('" + Transcoder.Encode(player.getUuid().toString()) + "'))";
            sql += " or requester_uuid=(UNHEX('" + Transcoder.Encode(player.getUuid().toString()) + "'))";
            sql += " and active_status=true";
            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a list of bean
            while(resultset.next())
            {
                long friendshipId = resultset.getLong("friendship_id");
                String requester = Transcoder.Decode(resultset.getString("requester"));
                UUID requesterUuid = UUID.fromString(requester);
                String recipient = Transcoder.Decode(resultset.getString("recipient"));
                UUID recipientUuid = UUID.fromString(recipient);
                Timestamp demandDate = resultset.getTimestamp("demand_date");
                Timestamp acceptationDate = resultset.getTimestamp("acceptation_date");
                boolean activeStatus = resultset.getBoolean("active_status");
                FriendshipBean friendshipBean = new FriendshipBean(friendshipId, requesterUuid, recipientUuid, demandDate, acceptationDate, activeStatus);
                friendshipList.add(friendshipBean);
            }
            return friendshipList;
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
    }

    // Get friendship demand list
    public FriendshipBean getFriendshipNamedList(PlayerBean requester, PlayerBean recipient, DataSource dataSource) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            FriendshipBean friendshipBean = null;

            // Query construction
            String sql = "select friendship_id, HEX(requester_uuid) as requester, HEX(recipient_uuid) as recipient, demand_date, acceptation_date, active_status";
            sql += " from friendship where recipient_uuid=(UNHEX('" + Transcoder.Encode(recipient.getUuid().toString()) + "'))";
            sql += " and requester_uuid=(UNHEX('" + Transcoder.Encode(requester.getUuid().toString()) + "'))";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a list of bean
            if(resultset.next())
            {
                long friendshipId = resultset.getLong("friendship_id");
                String requesterName = Transcoder.Decode(resultset.getString("requester"));
                UUID requesterUuid = UUID.fromString(requesterName);
                String recipientName = Transcoder.Decode(resultset.getString("recipient"));
                UUID recipientUuid = UUID.fromString(recipientName);
                Timestamp demandDate = resultset.getTimestamp("demand_date");
                Timestamp acceptationDate = resultset.getTimestamp("acceptation_date");
                boolean activeStatus = resultset.getBoolean("active_status");
                friendshipBean = new FriendshipBean(friendshipId, requesterUuid, recipientUuid, demandDate, acceptationDate, activeStatus);
            }
            return friendshipBean;
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
