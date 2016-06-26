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

package net.samagames.persistanceapi.beans.statistics;

import java.util.UUID;

public class HostStatisticsBean
{
    /* Database Structure

    Table : host_stats
    +-------------+--------------+------+-----+---------+----------------+
    | Field       | Type         | Null | Key | Default | Extra          |
    +-------------+--------------+------+-----+---------+----------------+
    | id          | double       | NO   | PRI | NULL    | auto_increment |
    | host_id     | varchar(255) | NO   |     | NULL    |                |
    | ip_address  | varchar(15)  | NO   | MUL | NULL    |                |
    | player_uuid | binary(16)   | NO   | MUL | NULL    |                |
    | played_time | bigint(20)   | NO   |     | NULL    |                |
    +-------------+--------------+------+-----+---------+----------------+
    */

    // Defines
    private long id;
    private String hostId;
    private String IpAddress;
    private UUID playerUuid;
    private long playedTime;

    // Cosntructor
    public HostStatisticsBean(String hostId, String ipAddress, UUID playerUuid, long playedTime)
    {
        this.hostId = hostId;
        IpAddress = ipAddress;
        this.playerUuid = playerUuid;
        this.playedTime = playedTime;
    }

    // Getter
    public long getId() { return id; }
    public String getHostId() { return hostId; }
    public String getIpAddress() { return IpAddress; }
    public UUID getPlayerUuid() { return playerUuid; }
    public long getPlayedTime() { return playedTime; }

    // Setter
    public void setHostId(String hostId) { this.hostId = hostId; }
    public void setIpAddress(String ipAddress) { IpAddress = ipAddress; }
    public void setPlayerUuid(UUID playerUuid) { this.playerUuid = playerUuid; }
    public void setPlayedTime(long playedTime) { this.playedTime = playedTime; }
}
