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

    Table : hub_permissions
    +----------------------------+------------+------+-----+---------+----------------+
    | Field                      | Type       | Null | Key | Default | Extra          |
    +----------------------------+------------+------+-----+---------+----------------+
    | groups_id                  | bigint(20) | NO   | PRI | NULL    | auto_increment |
    | hub_jukebox_lock           | tinyint(1) | NO   |     | NULL    |                |
    | hub_jukebox_next           | tinyint(1) | NO   |     | NULL    |                |
    | hub_jukebox_clear          | tinyint(1) | NO   |     | NULL    |                |
    | hub_mod_slow               | tinyint(1) | NO   |     | NULL    |                |
    | hub_mod_shutup             | tinyint(1) | NO   |     | NULL    |                |
    | hub_admin_npc              | tinyint(1) | NO   |     | NULL    |                |
    | hub_admin_sign             | tinyint(1) | NO   |     | NULL    |                |
    | hub_anguille               | tinyint(1) | NO   |     | NULL    |                |
    | hub_jukebox_nbs            | tinyint(1) | NO   |     | NULL    |                |
    | hub_admin_evacuate         | tinyint(1) | NO   |     | NULL    |                |
    | hub_announce               | tinyint(1) | NO   |     | NULL    |                |
    | hub_gadgets_cooldownbypass | tinyint(1) | NO   |     | NULL    |                |
    | hub_gadgets_nuke           | tinyint(1) | NO   |     | NULL    |                |
    | hub_jukebox_limitbypass    | tinyint(1) | NO   |     | NULL    |                |
    | hub_jukebox_limitstaff     | tinyint(1) | NO   |     | NULL    |                |
    | hub_bypassmute             | tinyint(1) | NO   |     | NULL    |                |
    | hub_fly                    | tinyint(1) | NO   |     | NULL    |                |
    | hub_debug_sign             | tinyint(1) | NO   |     | NULL    |                |
    +----------------------------+------------+------+-----+---------+----------------+
    */

    // Defines
    private long groupsId;
    private boolean hubJukeboxLock;
    private boolean hubJukeboxNext;
    private boolean hubJukeBoxClear;
    private boolean hubModSlow;
    private boolean hubModShutup;
    private boolean hubAdminNpc;
    private boolean hubAdminSign;
    private boolean hubAnguille;
    private boolean hubJukeboxNbs;
    private boolean hubAdminEvacuate;
    private boolean hubAnnounce;
    private boolean hubGadgetsCooldownbypass;
    private boolean hubGadgetsNuke;
    private boolean hubJukeboxLimitbypass;
    private boolean hubJukeboxLimitstaff;
    private boolean hubBypassmute;
    private boolean hubFly;
    private boolean hubDebugSign;

    // Constructor
    public HubPermissionsBean(long groupsId, boolean hubJukeboxLock, boolean hubJukeboxNext, boolean hubJukeBoxClear, boolean hubModSlow, boolean hubModShutup, boolean hubAdminNpc,
                              boolean hubAdminSign, boolean hubAnguille, boolean hubJukeboxNbs, boolean hubAdminEvacuate, boolean hubAnnounce, boolean hubGadgetsCooldownbypass,
                              boolean hubGadgetsNuke, boolean hubJukeboxLimitbypass, boolean hubJukeboxLimitstaff, boolean hubBypassmute, boolean hubFly, boolean hubDebugSign)
    {
        this.groupsId = groupsId;
        this.hubJukeboxLock = hubJukeboxLock;
        this.hubJukeboxNext = hubJukeboxNext;
        this.hubJukeBoxClear = hubJukeBoxClear;
        this.hubModSlow = hubModSlow;
        this.hubModShutup = hubModShutup;
        this.hubAdminNpc = hubAdminNpc;
        this.hubAdminSign = hubAdminSign;
        this.hubAnguille = hubAnguille;
        this.hubJukeboxNbs = hubJukeboxNbs;
        this.hubAdminEvacuate = hubAdminEvacuate;
        this.hubAnnounce = hubAnnounce;
        this.hubGadgetsCooldownbypass = hubGadgetsCooldownbypass;
        this.hubGadgetsNuke = hubGadgetsNuke;
        this.hubJukeboxLimitbypass = hubJukeboxLimitbypass;
        this.hubJukeboxLimitstaff = hubJukeboxLimitstaff;
        this.hubBypassmute = hubBypassmute;
        this.hubFly = hubFly;
        this.hubDebugSign = hubDebugSign;
    }

    // Getters
    public long getGroupsId() { return this.groupsId; }
    public boolean isHubJukeboxLock() { return this.hubJukeboxLock; }
    public boolean isHubJukeboxNext() { return this.hubJukeboxNext; }
    public boolean isHubJukeBoxClear() { return this.hubJukeBoxClear; }
    public boolean isHubModSlow() { return this.hubModSlow; }
    public boolean isHubModShutup() { return this.hubModShutup; }
    public boolean isHubAdminSign() { return this.hubAdminSign; }
    public boolean isHubAdminNpc() { return this.hubAdminNpc; }
    public boolean isHubAnguille() { return this.hubAnguille; }
    public boolean isHubJukeboxNbs() { return this.hubJukeboxNbs; }
    public boolean isHubAdminEvacuate() { return this.hubAdminEvacuate; }
    public boolean isHubAnnounce() { return this.hubAnnounce; }
    public boolean isHubGadgetsCooldownbypass() { return this.hubGadgetsCooldownbypass; }
    public boolean isHubGadgetsNuke() { return this.hubGadgetsNuke; }
    public boolean isHubJukeboxLimitbypass() { return this.hubJukeboxLimitbypass; }
    public boolean isHubJukeboxLimitstaff() { return this.hubJukeboxLimitstaff; }
    public boolean isHubBypassmute() { return this.hubBypassmute; }
    public boolean isHubFly() { return this. hubFly; }
    public boolean isHubDebugSign() { return this.hubDebugSign; }

    // Setters
    public void setHubJukeboxLock(boolean hubJukeboxLock) { this.hubJukeboxLock = hubJukeboxLock; }
    public void setHubJukeboxNext(boolean hubJukeboxNext) { this.hubJukeboxNext = hubJukeboxNext; }
    public void setHubjukeboxClear(boolean hubJukeBoxClear) { this.hubJukeBoxClear = hubJukeBoxClear; }
    public void setHubModSlow(boolean hubModSlow) { this.hubModSlow = hubModSlow; }
    public void setHubModShutup(boolean hubModShutup) { this.hubModShutup = hubModShutup; }
    public void setHubAdminSign(boolean hubAdminSign) { this.hubAdminSign = hubAdminSign; }
    public void setHubAdminNpc(boolean hubAdminNpc) { this.hubAdminNpc = hubAdminNpc; }
    public void setHubAnguille(boolean hubAnguille) { this.hubAnguille = hubAnguille; }
    public void setHubJukeboxNbs(boolean hubJukeboxNbs) { this.hubJukeboxNbs = hubJukeboxNbs; }
    public void setHubAdminEvacuate(boolean hubAdminEvacuate) { this.hubAdminEvacuate = hubAdminEvacuate; }
    public void setHubAnnounce(boolean hubAnnounce) { this.hubAnnounce = hubAnnounce; }
    public void setHubGadgetsCooldownbypass(boolean hubGadgetsCooldownbypass) { this.hubGadgetsCooldownbypass = hubGadgetsCooldownbypass; }
    public void setHubGadgetsNuke(boolean hubGadgetsNuke) { this.hubGadgetsNuke = hubGadgetsNuke; }
    public void setHubJukeboxLimitbypass(boolean hubJukeboxLimitbypass) { this.hubJukeboxLimitbypass = hubJukeboxLimitbypass; }
    public void setHubJukeboxLimitstaff(boolean hubJukeboxLimitstaff) { this.hubJukeboxLimitstaff = hubJukeboxLimitstaff; }
    public void setHubBypassmute(boolean hubBypassmute) { this.hubBypassmute = hubBypassmute; }
    public void setHubFly(boolean hubFly) { this.hubFly = hubFly; }
    public void setHubDebugSign(boolean hubDebugSign) { this.hubDebugSign = hubDebugSign; }

}
