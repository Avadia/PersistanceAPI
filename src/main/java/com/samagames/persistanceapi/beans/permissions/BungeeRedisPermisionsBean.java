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

package com.samagames.persistanceapi.beans.permissions;

public class BungeeRedisPermisionsBean
{
    /* Database Structure
    +-------------+------------------+------+-----+---------------------+----------------+
    | Field       | Type             | Null | Key | Default             | Extra          |
    +-------------+------------------+------+-----+---------------------+----------------+
    | uuid        | binary(16)       | NO   | PRI | NULL                |                |
    +-------------+------------------+------+-----+---------------------+----------------+
    */

    // Defines
    private long bungeeRedisPermissionId;
    private boolean bungeecordCommandList;
    private boolean bungeecordCommandFind;
    private boolean redisbungeeCommandLastSeen;
    private boolean redisbungeeCommandSendtoAll;
    private boolean redisbungeeCommandServerId;
    private boolean redisbungeCommandServerIds;
    private boolean redisbungeeCommandPproxy; // FIXME vraiment PProxy ?
    private boolean redisbungeeCommandPlist;
    private boolean bungeecordCommandServer;
    private boolean bungeecordCommandSend;
    private boolean bungeecordCommandEnd;
    private boolean bungeecordCommandAlert;

    // Getters
    public long getBungeeRedisPermissionId() { return bungeeRedisPermissionId; }
    public boolean isBungeecordCommandList() { return bungeecordCommandList; }
    public boolean isBungeecordCommandFind() { return bungeecordCommandFind; }
    public boolean isRedisbungeeCommandLastSeen() { return redisbungeeCommandLastSeen; }
    public boolean isRedisbungeeCommandSendtoAll() { return redisbungeeCommandSendtoAll; }
    public boolean isRedisbungeeCommandServerId() { return redisbungeeCommandServerId; }
    public boolean isRedisbungeCommandServerIds() { return redisbungeCommandServerIds; }
    public boolean isRedisbungeeCommandPproxy() { return redisbungeeCommandPproxy; }
    public boolean isRedisbungeeCommandPlist() { return redisbungeeCommandPlist; }
    public boolean isBungeecordCommandServer() { return bungeecordCommandServer; }
    public boolean isBungeecordCommandSend() { return bungeecordCommandSend; }
    public boolean isBungeecordCommandEnd() { return bungeecordCommandEnd; }
    public boolean isBungeecordCommandAlert() { return bungeecordCommandAlert; }

    // Setters
    public void setBungeecordCommandList(boolean bungeecordCommandList) { this.bungeecordCommandList = bungeecordCommandList; }
    public void setBungeecordCommandFind(boolean bungeecordCommandFind) { this.bungeecordCommandFind = bungeecordCommandFind; }
    public void setRedisbungeeCommandLastSeen(boolean redisbungeeCommandLastSeen) { this.redisbungeeCommandLastSeen = redisbungeeCommandLastSeen; }
    public void setRedisbungeeCommandSendtoAll(boolean redisbungeeCommandSendtoAll) { this.redisbungeeCommandSendtoAll = redisbungeeCommandSendtoAll; }
    public void setRedisbungeeCommandServerId(boolean redisbungeeCommandServerId) { this.redisbungeeCommandServerId = redisbungeeCommandServerId; }
    public void setRedisbungeCommandServerIds(boolean redisbungeCommandServerIds) { this.redisbungeCommandServerIds = redisbungeCommandServerIds; }
    public void setRedisbungeeCommandPproxy(boolean redisbungeeCommandPproxy) { this.redisbungeeCommandPproxy = redisbungeeCommandPproxy; }
    public void setRedisbungeeCommandPlist(boolean redisbungeeCommandPlist) { this.redisbungeeCommandPlist = redisbungeeCommandPlist; }
    public void setBungeecordCommandServer(boolean bungeecordCommandServer) { this.bungeecordCommandServer = bungeecordCommandServer; }
    public void setBungeecordCommandSend(boolean bungeecordCommandSend) { this.bungeecordCommandSend = bungeecordCommandSend; }
    public void setBungeecordCommandEnd(boolean bungeecordCommandEnd) { this.bungeecordCommandEnd = bungeecordCommandEnd; }
    public void setBungeecordCommandAlert(boolean bungeecordCommandAlert) { this.bungeecordCommandAlert = bungeecordCommandAlert; }
}
