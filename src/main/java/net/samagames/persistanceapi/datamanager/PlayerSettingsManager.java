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

import net.samagames.persistanceapi.beans.PlayerBean;
import net.samagames.persistanceapi.beans.PlayerSettingsBean;
import net.samagames.persistanceapi.utils.Transcoder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.UUID;

public class PlayerSettingsManager
{
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;

    // Get the player ingame settings
    public PlayerSettingsBean getPlayerSettings(PlayerBean player, DataSource dataSource)
    {
        // Defines
        PlayerSettingsBean playerSettingsBean = null;

        // Make the research of player by UUID
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if (resultset.next())
            {
                // There's a result
                String playerUuid = Transcoder.Decode(resultset.getString("uuid"));
                boolean jukeboxListen = resultset.getBoolean("");
                boolean groupDemandReceive = resultset.getBoolean("");
                boolean friendshipDemandReceive =  resultset.getBoolean("");
                boolean notificationReceive = resultset.getBoolean("");
                boolean privateMessageReceive = resultset.getBoolean("");
                boolean chatVisible = resultset.getBoolean("");
                boolean playerVisible = resultset.getBoolean("");
                boolean waitingLineNotification = resultset.getBoolean("");
                boolean otherPlayerInteraction = resultset.getBoolean("");
                boolean clickOnMeActivation = resultset.getBoolean("");
                boolean allowStatisticOnClick = resultset.getBoolean("");
                boolean allowCoinsOnClick = resultset.getBoolean("");
                boolean allowStarsOnclick = resultset.getBoolean("");
                boolean allowClickOnOther = resultset.getBoolean("");
                //playerSettingsBean = new PlayerSettingsBean();
                return playerSettingsBean;
            }
            else
            {
                return playerSettingsBean;
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
        return playerSettingsBean;
    }

    // Set player ingame settings
    public void setPlayerSettings(PlayerSettingsBean player, PlayerSettingsBean settingsBeans, DataSource dataSource)
    {
        // Update the players data
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "update player_settings set (jukeboxListen, groupDemandReceive, friendshipDemandReceive, notificationReceive, privateMessageReceive, chatVisible, playerVisible ";
            sql += ", waitingLineNotification, otherPlayerInteraction, clickOnMeActivation, allowStatisticOnClick, allowCoinsOnClick, allowStarsOnclick, allowClickOnOther) set values(";
            sql += ", " + settingsBeans.isJukeboxListen();
            sql += ", " + settingsBeans.isGroupDemandReceive();
            sql += ", " + settingsBeans.isFriendshipDemandReceive();
            sql += ", " + settingsBeans.isNotificationReceive();
            sql += ", " + settingsBeans.isPrivateMessageReceive();
            sql += ", " + settingsBeans.isChatVisible();
            sql += ", " + settingsBeans.isPlayerVisible();
            sql += ", " + settingsBeans.isWaitingLineNotification();
            sql += ", " + settingsBeans.isOtherPlayerInteraction();
            sql += ", " + settingsBeans.isClickOnMeActivation();
            sql += ", " + settingsBeans.isAllowStatisticOnClick();
            sql += ", " + settingsBeans.isAllowCoinsOnClick();
            sql += ", " + settingsBeans.isAllowStarsOnclick();
            sql += ", " + settingsBeans.isAllowClickOnOther();
            sql += " where uuid=(UNHEX('" + Transcoder.Encode(player.getUuid().toString()) + "'))";

            // Execute the query
            statement.executeUpdate(sql);
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
    }


    // Close the connection
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
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
    }
}
