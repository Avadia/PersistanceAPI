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

package net.samagames.persistanceapi.beans.utils;

public class BungeeConfigBean
{
    /* Database Structure

    Table : configuration
    +-----------------+--------------+------+-----+---------+-------+
    | Field           | Type         | Null | Key | Default | Extra |
    +-----------------+--------------+------+-----+---------+-------+
    | slots           | int(11)      | NO   |     | NULL    |       |
    | motd            | varchar(255) | NO   |     | NULL    |       |
    | close_type      | varchar(255) | NO   |     | NULL    |       |
    | server_line     | varchar(255) | NO   |     | NULL    |       |
    | max_players     | int(11)      | NO   |     | NULL    |       |
    | priority_title  | varchar(255) | NO   |     | NULL    |       |
    | welcome_message | varchar(255) | NO   |     | NULL    |       |
    +-----------------+--------------+------+-----+---------+-------+
    */

    // Define attributes
    private int slots;
    private String motd;
    private String closeType;
    private String serverLine;
    private int maxPlayers;
    private String priorityTitle;
    private String welcomeMessage;

    // Constructor
    public BungeeConfigBean(int slots, String motd, String closeType, String serverLine, int maxPlayers, String priorityTitle, String welcomeMessage)
    {
        this.slots = slots;
        this.motd = motd;
        this.closeType = closeType;
        this.serverLine = serverLine;
        this.maxPlayers = maxPlayers;
        this.priorityTitle = priorityTitle;
        this.welcomeMessage = welcomeMessage;
    }

    // Getters
    public int getSlots() { return slots; }
    public String getMotd() { return motd; }
    public String getCloseType() { return closeType; }
    public String getServerLine() { return serverLine; }
    public int getMaxPlayers() { return maxPlayers; }
    public String getPriorityTitle() { return priorityTitle; }
    public String getWelcomeMessage() { return welcomeMessage; }

    // Setters
    public void setSlots(int slots) { this.slots = slots; }
    public void setMotd(String motd) { this.motd = motd; }
    public void setCloseType(String closeType) { this.closeType = closeType; }
    public void setServerLine(String serverLine) { this.serverLine = serverLine; }
    public void setMaxPlayers(int maxPlayers) { this.maxPlayers = maxPlayers; }
    public void setPriorityTitle(String priorityTitle) { this.priorityTitle = priorityTitle; }
    public void setWelcomeMessage(String welcomeMessage) { this.welcomeMessage = welcomeMessage; }
}
