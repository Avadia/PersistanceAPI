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

public class HubPermissionsBean
{
    /* Database Structure
    +-----------------------------+------------+------+-----+---------+-------+
    | Field                       | Type       | Null | Key | Default | Extra |
    +-----------------------------+------------+------+-----+---------+-------+
    | hub_permission_id           | bigint(20) | NO   | PRI | NULL    |       |
    | hub_jukebox_lock            | tinyint(1) | NO   |     | NULL    |       |
    | hub_jukebox_next            | tinyint(1) | NO   |     | NULL    |       |
    | hub_mod_slow                | tinyint(1) | NO   |     | NULL    |       |
    | hub_mod_shutup              | tinyint(1) | NO   |     | NULL    |       |
    | hub_admin_sign              | tinyint(1) | NO   |     | NULL    |       |
    | hub_anguille                | tinyint(1) | NO   |     | NULL    |       |
    | hub_jukebox_nbs             | tinyint(1) | NO   |     | NULL    |       |
    | hub_announce                | tinyint(1) | NO   |     | NULL    |       |
    | hub_gadgets_cooldown_bypass | tinyint(1) | NO   |     | NULL    |       |
    | hub_jukebox_limit_bypass    | tinyint(1) | NO   |     | NULL    |       |
    | hub_bypass_mute             | tinyint(1) | NO   |     | NULL    |       |
    | hub_fly                     | tinyint(1) | NO   |     | NULL    |       |
    | hub_debug_sign              | tinyint(1) | NO   |     | NULL    |       |
    +-----------------------------+------------+------+-----+---------+-------+
    */

    // Defines
    private long hubPermissionId;
    private boolean hubJukeboxLock;
    private boolean hubJukeboxNext;
    private boolean hubModSlow;
    private boolean hubModShutup;
    private boolean hubAdminSign;
    private boolean hubAnguille;
    private boolean hubJukeboxNbs;
    private boolean hubAnnounce;
    private boolean hubGadgetsCooldownbypass;
    private boolean hubJukeboxLimitbypass;
    private boolean hubBypassmute;
    private boolean hubFly;
    private boolean hubDebugSign;

    // Getters
    public long getHubPermissionId() { return hubPermissionId; }
    public boolean isHubJukeboxLock() { return hubJukeboxLock; }
    public boolean isHubJukeboxNext() { return hubJukeboxNext; }
    public boolean isHubModSlow() { return hubModSlow; }
    public boolean isHubModShutup() { return hubModShutup; }
    public boolean isHubAdminSign() { return hubAdminSign; }
    public boolean isHubAnguille() { return hubAnguille; }
    public boolean isHubJukeboxNbs() { return hubJukeboxNbs; }
    public boolean isHubAnnounce() { return hubAnnounce; }
    public boolean isHubGadgetsCooldownbypass() { return hubGadgetsCooldownbypass; }
    public boolean isHubJukeboxLimitbypass() { return hubJukeboxLimitbypass; }
    public boolean isHubBypassmute() { return hubBypassmute; }
    public boolean isHubFly() { return hubFly; }
    public boolean isHubDebugSign() { return hubDebugSign; }

    // Setters
    public void setHubJukeboxLock(boolean hubJukeboxLock) { this.hubJukeboxLock = hubJukeboxLock; }
    public void setHubJukeboxNext(boolean hubJukeboxNext) { this.hubJukeboxNext = hubJukeboxNext; }
    public void setHubModSlow(boolean hubModSlow) { this.hubModSlow = hubModSlow; }
    public void setHubModShutup(boolean hubModShutup) { this.hubModShutup = hubModShutup; }
    public void setHubAdminSign(boolean hubAdminSign) { this.hubAdminSign = hubAdminSign; }
    public void setHubAnguille(boolean hubAnguille) { this.hubAnguille = hubAnguille; }
    public void setHubJukeboxNbs(boolean hubJukeboxNbs) { this.hubJukeboxNbs = hubJukeboxNbs; }
    public void setHubAnnounce(boolean hubAnnounce) { this.hubAnnounce = hubAnnounce; }
    public void setHubGadgetsCooldownbypass(boolean hubGadgetsCooldownbypass) { this.hubGadgetsCooldownbypass = hubGadgetsCooldownbypass; }
    public void setHubJukeboxLimitbypass(boolean hubJukeboxLimitbypass) { this.hubJukeboxLimitbypass = hubJukeboxLimitbypass; }
    public void setHubBypassmute(boolean hubBypassmute) { this.hubBypassmute = hubBypassmute; }
    public void setHubFly(boolean hubFly) { this.hubFly = hubFly; }
    public void setHubDebugSign(boolean hubDebugSign) { this.hubDebugSign = hubDebugSign; }

}
