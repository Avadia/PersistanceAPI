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
    +-------------+--------------+------+-----+---------+-------+
    | Field       | Type         | Null | Key | Default | Extra |
    +-------------+--------------+------+-----+---------+-------+
    | slots       | int(11)      | NO   |     | NULL    |       |
    | motd        | varchar(255) | NO   |     | NULL    |       |
    | close_type  | varchar(255) | NO   |     | NULL    |       |
    | server_line | varchar(255) | NO   |     | NULL    |       |
    | max_players | int(11)      | NO   |     | NULL    |       |
    +-------------+--------------+------+-----+---------+-------+
    */

    // Define attributes
    private int slots;
    private String motd;
    private String closeType;
    private String serverLine;
    private int maxPlayers;

    // Constructor
    public BungeeConfigBean(int slots, String motd, String closeType, String serverLine, int maxPlayers)
    {
        this.slots = slots;
        this.motd = motd;
        this.closeType = closeType;
        this.serverLine = serverLine;
        this.maxPlayers = maxPlayers;
    }

    // Getters
    public int getSlots() { return slots; }
    public String getMotd() { return motd; }
    public String getCloseType() { return closeType; }
    public String getServerLine() { return serverLine; }
    public int getMaxPlayers() { return maxPlayers; }

    // Setters
    public void setSlots(int slots) { this.slots = slots; }
    public void setMotd(String motd) { this.motd = motd; }
    public void setCloseType(String closeType) { this.closeType = closeType; }
    public void setServerLine(String serverLine) { this.serverLine = serverLine; }
    public void setMaxPlayers(int maxPlayers) { this.maxPlayers = maxPlayers; }
}
