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

public class ModerationPermissionsBean
{
    /* Database Structure
    +--------------------------+------------+------+-----+---------+-------+
    | Field                    | Type       | Null | Key | Default | Extra |
    +--------------------------+------------+------+-----+---------+-------+
    | moderation_permission_id | bigint(20) | NO   | PRI | NULL    |       |
    | mod_ban                  | tinyint(1) | NO   |     | NULL    |       |
    | mod_tp                   | tinyint(1) | NO   |     | NULL    |       |
    | mod_kick                 | tinyint(1) | NO   |     | NULL    |       |
    | mod_pardon               | tinyint(1) | NO   |     | NULL    |       |
    | mod_mute_longtime        | tinyint(1) | NO   |     | NULL    |       |
    | mod_mute                 | tinyint(1) | NO   |     | NULL    |       |
    | mod_channel              | tinyint(1) | NO   |     | NULL    |       |
    +--------------------------+------------+------+-----+---------+-------+
    */

    // Defines
    private long moderationPermissionId;
    private boolean modBan;
    private boolean modTp;
    private boolean modKick;
    private boolean modPardon;
    private boolean modMuteLongtime;
    private boolean modMute;
    private boolean modChannel;

    // Getters
    public long getModerationPermissionId() { return moderationPermissionId; }
    public boolean isModBan() { return modBan; }
    public boolean isModTp() { return modTp; }
    public boolean isModKick() { return modKick; }
    public boolean isModPardon() { return modPardon; }
    public boolean isModMuteLongtime() { return modMuteLongtime; }
    public boolean isModMute() { return modMute; }
    public boolean isModChannel() { return modChannel; }

    // Setters
    public void setModBan(boolean modBan) { this.modBan = modBan; }
    public void setModTp(boolean modTp) { this.modTp = modTp; }
    public void setModKick(boolean modKick) { this.modKick = modKick; }
    public void setModPardon(boolean modPardon) { this.modPardon = modPardon; }
    public void setModMuteLongtime(boolean modMuteLongtime) { this.modMuteLongtime = modMuteLongtime; }
    public void setModMute(boolean modMute) { this.modMute = modMute; }
    public void setModChannel(boolean modChannel) { this.modChannel = modChannel; }

}
