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

public class StaffPermissionsBean
{
    /* Database Structure

    Table : staff_permissions
    +----------------+------------+------+-----+---------+----------------+
    | Field          | Type       | Null | Key | Default | Extra          |
    +----------------+------------+------+-----+---------+----------------+
    | groups_id      | bigint(20) | NO   | PRI | NULL    | auto_increment |
    | staff_member   | tinyint(1) | NO   |     | NULL    |                |
    | netjoin_closed | tinyint(1) | NO   |     | NULL    |                |
    | netjoin_vip    | tinyint(1) | NO   |     | NULL    |                |
    | netjoin_full   | tinyint(1) | NO   |     | NULL    |                |
    | tracker_famous | tinyint(1) | NO   |     | NULL    |                |
    +----------------+------------+------+-----+---------+----------------+
    */

    // Defines
    private long groupsId;
    private boolean staffMember;
    private boolean netjoinClosed;
    private boolean netjoinVip;
    private boolean netjoinFull;
    private boolean trackerFamous;

    // Getters
    public long getGroupsId() { return this.groupsId; }
    public boolean isStaffMember() { return this.staffMember; }
    public boolean isNetjoinClosed() { return this.netjoinClosed; }
    public boolean isNetjoinVip() { return this.netjoinVip; }
    public boolean isNetjoinFull() { return this.netjoinFull; }
    public boolean isTrackerFamous() { return this.trackerFamous; }

    // Setters
    public void setStaffMember(boolean staffMember) { this.staffMember = staffMember; }
    public void setNetjoinClosed(boolean netjoinClosed) { this.netjoinClosed = netjoinClosed; }
    public void setNetjoinVip(boolean netjoinVip) { this.netjoinVip = netjoinVip; }
    public void setNetjoinFull(boolean netjoinFull) { this.netjoinFull = netjoinFull; }
    public void setTrackerFamous(boolean trackerFamous) { this.trackerFamous = trackerFamous; }
}
