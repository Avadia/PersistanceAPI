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

package net.samagames.persistanceapi.beans;

import java.util.UUID;

public class PlayerSettingsBean
{
    /* Database structure

    Table : player_settings
    +---------------------------+------------+------+-----+---------+-------+
    | Field                     | Type       | Null | Key | Default | Extra |
    +---------------------------+------------+------+-----+---------+-------+
    | player_uuid               | binary(16) | NO   | PRI | NULL    |       |
    | jukebox_listen            | tinyint(1) | NO   |     | NULL    |       |
    | group_demand_receive      | tinyint(1) | NO   |     | NULL    |       |
    | friendship_demand_receive | tinyint(1) | NO   |     | NULL    |       |
    | notification_receive      | tinyint(1) | NO   |     | NULL    |       |
    | private_message_receive   | tinyint(1) | NO   |     | NULL    |       |
    | chat_visible              | tinyint(1) | NO   |     | NULL    |       |
    | player_visible            | tinyint(1) | NO   |     | NULL    |       |
    | waiting_line_notification | tinyint(1) | NO   |     | NULL    |       |
    | other_player_interaction  | tinyint(1) | NO   |     | NULL    |       |
    | click_on_me_activation    | tinyint(1) | NO   |     | NULL    |       |
    | allow_statistic_onclick   | tinyint(1) | NO   |     | NULL    |       |
    | allow_coins_onclick       | tinyint(1) | NO   |     | NULL    |       |
    | allow_stars_onclick       | tinyint(1) | NO   |     | NULL    |       |
    | allow_click_on_other      | tinyint(1) | NO   |     | NULL    |       |
    +---------------------------+------------+------+-----+---------+-------+
     */

    // Defines attributes
    private UUID uuid;
    private boolean jukeboxListen;
    private boolean groupDemandReceive;
    private boolean friendshipDemandReceive;
    private boolean notificationReceive;
    private boolean privateMessageReceive;
    private boolean chatVisible;
    private boolean playerVisible;
    private boolean waitingLineNotification;
    private boolean otherPlayerInteraction;
    private boolean clickOnMeActivation;
    private boolean allowStatisticOnClick;
    private boolean allowCoinsOnClick;
    private boolean allowStarsOnclick;
    private boolean allowClickOnOther;

    // Constructor
    public PlayerSettingsBean(UUID uuid, boolean jukeboxListen, boolean groupDemandReceive, boolean friendshipDemandReceive, boolean notificationReceive, boolean privateMessageReceive,
                              boolean chatVisible, boolean playerVisible, boolean waitingLineNotification, boolean otherPlayerInteraction, boolean clickOnMeActivation,
                              boolean allowStatisticOnClick, boolean allowCoinsOnClick, boolean allowStarsOnclick, boolean allowClickOnOther)
    {
        this.uuid = uuid;
        this.jukeboxListen = jukeboxListen;
        this.groupDemandReceive = groupDemandReceive;
        this.friendshipDemandReceive = friendshipDemandReceive;
        this.notificationReceive = notificationReceive;
        this.privateMessageReceive = privateMessageReceive;
        this.chatVisible = chatVisible;
        this.playerVisible = playerVisible;
        this.waitingLineNotification = waitingLineNotification;
        this.otherPlayerInteraction = otherPlayerInteraction;
        this.clickOnMeActivation = clickOnMeActivation;
        this.allowStatisticOnClick = allowStatisticOnClick;
        this.allowCoinsOnClick = allowCoinsOnClick;
        this.allowStarsOnclick = allowStarsOnclick;
        this.allowClickOnOther = allowClickOnOther;
    }

    // Getters
    public UUID getUuid() { return this.uuid; }
    public boolean isJukeboxListen() { return this.jukeboxListen; }
    public boolean isGroupDemandReceive() { return this.groupDemandReceive; }
    public boolean isFriendshipDemandReceive() { return this.friendshipDemandReceive; }
    public boolean isNotificationReceive() { return this.notificationReceive; }
    public boolean isPrivateMessageReceive() { return this.privateMessageReceive; }
    public boolean isChatVisible() { return this.chatVisible; }
    public boolean isPlayerVisible() { return this.playerVisible; }
    public boolean isWaitingLineNotification() { return this.waitingLineNotification; }
    public boolean isOtherPlayerInteraction() { return this.otherPlayerInteraction; }
    public boolean isClickOnMeActivation() { return this.clickOnMeActivation; }
    public boolean isAllowStatisticOnClick() { return this.allowStatisticOnClick; }
    public boolean isAllowCoinsOnClick() { return this.allowCoinsOnClick; }
    public boolean isAllowStarsOnclick() { return this.allowStarsOnclick; }
    public boolean isAllowClickOnOther() { return this.allowClickOnOther; }

    // Setters
    public void setJukeboxListen(boolean jukeboxListen) { this.jukeboxListen = jukeboxListen; }
    public void setGroupDemandReceive(boolean groupDemandReceive) { this.groupDemandReceive = groupDemandReceive; }
    public void setFriendshipDemandReceive(boolean friendshipDemandReceive) { this.friendshipDemandReceive = friendshipDemandReceive; }
    public void setNotificationReceive(boolean notificationReceive) { this.notificationReceive = notificationReceive; }
    public void setPrivateMessageReceive(boolean privateMessageReceive) { this.privateMessageReceive = privateMessageReceive; }
    public void setChatVisible(boolean chatVisible) { this.chatVisible = chatVisible; }
    public void setPlayerVisible(boolean playerVisible) { this.playerVisible = playerVisible; }
    public void setWaitingLineNotification(boolean waitingLineNotification) { this.waitingLineNotification = waitingLineNotification; }
    public void setOtherPlayerInteraction(boolean otherPlayerInteraction) { this.otherPlayerInteraction = otherPlayerInteraction; }
    public void setClickOnMeActivation(boolean clickOnMeActivation) { this.clickOnMeActivation = clickOnMeActivation; }
    public void setAllowStatisticOnClick(boolean allowStatisticOnClick) { this.allowStatisticOnClick = allowStatisticOnClick; }
    public void setAllowCoinsOnClick(boolean allowCoinsOnClick) { this.allowCoinsOnClick = allowCoinsOnClick; }
    public void setAllowStarsOnclick(boolean allowStarsOnclick) { this.allowStarsOnclick = allowStarsOnclick; }
    public void setAllowClickOnOther(boolean allowClickOnOther) { this.allowClickOnOther = allowClickOnOther; }
}
