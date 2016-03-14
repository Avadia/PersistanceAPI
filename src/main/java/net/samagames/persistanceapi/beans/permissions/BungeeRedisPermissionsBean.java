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

package net.samagames.persistanceapi.beans.permissions;

import net.samagames.persistanceapi.utils.Transcoder;

import java.util.HashMap;

public class BungeeRedisPermissionsBean
{
    /* Database Structure

    Table : bungee_redis_permissions
    +-------------------------------+------------+------+-----+---------+----------------+
    | Field                         | Type       | Null | Key | Default | Extra          |
    +-------------------------------+------------+------+-----+---------+----------------+
    | groups_id                     | bigint(20) | NO   | PRI | NULL    | auto_increment |
    | bungeecord_command_list       | tinyint(1) | NO   |     | NULL    |                |
    | bungeecord_command_find       | tinyint(1) | NO   |     | NULL    |                |
    | redisbungee_command_lastseen  | tinyint(1) | NO   |     | NULL    |                |
    | bungeecord_command_ip         | tinyint(1) | NO   |     | NULL    |                |
    | redisbungee_command_sendtoall | tinyint(1) | NO   |     | NULL    |                |
    | redisbungee_command_serverid  | tinyint(1) | NO   |     | NULL    |                |
    | redisbunge_command_serverids  | tinyint(1) | NO   |     | NULL    |                |
    | redisbungee_command_pproxy    | tinyint(1) | NO   |     | NULL    |                |
    | redisbungee_command_plist     | tinyint(1) | NO   |     | NULL    |                |
    | bungeecord_command_server     | tinyint(1) | NO   |     | NULL    |                |
    | bungeecord_command_send       | tinyint(1) | NO   |     | NULL    |                |
    | bungeecord_command_end        | tinyint(1) | NO   |     | NULL    |                |
    | bungeecord_command_alert      | tinyint(1) | NO   |     | NULL    |                |
    +-------------------------------+------------+------+-----+---------+----------------+
    */

    // Defines
    private long groupsId;
    private boolean bungeecordCommandList;
    private boolean bungeecordCommandFind;
    private boolean redisbungeeCommandLastSeen;
    private boolean redisbungeeCommandSendtoAll;
    private boolean bungeecordCommandIp;
    private boolean redisbungeeCommandServerId;
    private boolean redisbungeCommandServerIds;
    private boolean redisbungeeCommandPproxy;
    private boolean redisbungeeCommandPlist;
    private boolean bungeecordCommandServer;
    private boolean bungeecordCommandSend;
    private boolean bungeecordCommandEnd;
    private boolean bungeecordCommandAlert;

    // Constructor
    public BungeeRedisPermissionsBean(long groupsId, boolean bungeecordCommandList, boolean bungeecordCommandFind, boolean redisbungeeCommandLastSeen, boolean redisbungeeCommandSendtoAll,
                                      boolean bungeecordCommandIp, boolean redisbungeeCommandServerId, boolean redisbungeCommandServerIds, boolean redisbungeeCommandPproxy,
                                      boolean redisbungeeCommandPlist, boolean bungeecordCommandServer, boolean bungeecordCommandSend, boolean bungeecordCommandEnd, boolean bungeecordCommandAlert)
    {
        this.groupsId = groupsId;
        this.bungeecordCommandList = bungeecordCommandList;
        this.bungeecordCommandFind = bungeecordCommandFind;
        this.redisbungeeCommandLastSeen = redisbungeeCommandLastSeen;
        this.redisbungeeCommandSendtoAll = redisbungeeCommandSendtoAll;
        this.bungeecordCommandIp = bungeecordCommandIp;
        this.redisbungeeCommandServerId = redisbungeeCommandServerId;
        this.redisbungeCommandServerIds = redisbungeCommandServerIds;
        this.redisbungeeCommandPproxy = redisbungeeCommandPproxy;
        this.redisbungeeCommandPlist = redisbungeeCommandPlist;
        this.bungeecordCommandServer = bungeecordCommandServer;
        this.bungeecordCommandSend = bungeecordCommandSend;
        this.bungeecordCommandEnd = bungeecordCommandEnd;
        this.bungeecordCommandAlert = bungeecordCommandAlert;
    }

    // Getters
    public long getGroupsId() { return this.groupsId; }
    public boolean isBungeecordCommandList() { return this.bungeecordCommandList; }
    public boolean isBungeecordCommandFind() { return this.bungeecordCommandFind; }
    public boolean isRedisbungeeCommandLastSeen() { return this.redisbungeeCommandLastSeen; }
    public boolean isRedisbungeeCommandSendtoAll() { return this.redisbungeeCommandSendtoAll; }
    public boolean isBungeecordCommandIp() { return this.bungeecordCommandIp; }
    public boolean isRedisbungeeCommandServerId() { return this.redisbungeeCommandServerId; }
    public boolean isRedisbungeCommandServerIds() { return this.redisbungeCommandServerIds; }
    public boolean isRedisbungeeCommandPproxy() { return this.redisbungeeCommandPproxy; }
    public boolean isRedisbungeeCommandPlist() { return this.redisbungeeCommandPlist; }
    public boolean isBungeecordCommandServer() { return this.bungeecordCommandServer; }
    public boolean isBungeecordCommandSend() { return this.bungeecordCommandSend; }
    public boolean isBungeecordCommandEnd() { return this.bungeecordCommandEnd; }
    public boolean isBungeecordCommandAlert() { return this.bungeecordCommandAlert; }

    // Setters
    public void setBungeecordCommandList(boolean bungeecordCommandList) { this.bungeecordCommandList = bungeecordCommandList; }
    public void setBungeecordCommandFind(boolean bungeecordCommandFind) { this.bungeecordCommandFind = bungeecordCommandFind; }
    public void setRedisbungeeCommandLastSeen(boolean redisbungeeCommandLastSeen) { this.redisbungeeCommandLastSeen = redisbungeeCommandLastSeen; }
    public void setRedisbungeeCommandSendtoAll(boolean redisbungeeCommandSendtoAll) { this.redisbungeeCommandSendtoAll = redisbungeeCommandSendtoAll; }
    public void setBungeecordCommandIp(boolean bungeecordCommandIp) { this.bungeecordCommandIp = bungeecordCommandIp; }
    public void setRedisbungeeCommandServerId(boolean redisbungeeCommandServerId) { this.redisbungeeCommandServerId = redisbungeeCommandServerId; }
    public void setRedisbungeCommandServerIds(boolean redisbungeCommandServerIds) { this.redisbungeCommandServerIds = redisbungeCommandServerIds; }
    public void setRedisbungeeCommandPproxy(boolean redisbungeeCommandPproxy) { this.redisbungeeCommandPproxy = redisbungeeCommandPproxy; }
    public void setRedisbungeeCommandPlist(boolean redisbungeeCommandPlist) { this.redisbungeeCommandPlist = redisbungeeCommandPlist; }
    public void setBungeecordCommandServer(boolean bungeecordCommandServer) { this.bungeecordCommandServer = bungeecordCommandServer; }
    public void setBungeecordCommandSend(boolean bungeecordCommandSend) { this.bungeecordCommandSend = bungeecordCommandSend; }
    public void setBungeecordCommandEnd(boolean bungeecordCommandEnd) { this.bungeecordCommandEnd = bungeecordCommandEnd; }
    public void setBungeecordCommandAlert(boolean bungeecordCommandAlert) { this.bungeecordCommandAlert = bungeecordCommandAlert; }

    // Reverse the bean to HashMap
    public HashMap getHashMap()
    {
        return Transcoder.getHashMap(this);
    }
}
