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

public class StaffPermissionsBean
{
    /* Database Structure
    +-------------+------------------+------+-----+---------------------+----------------+
    | Field       | Type             | Null | Key | Default             | Extra          |
    +-------------+------------------+------+-----+---------------------+----------------+
    | uuid        | binary(16)       | NO   | PRI | NULL                |                |
    +-------------+------------------+------+-----+---------------------+----------------+
    */

    // Defines
    private long staffPermissionId;
    private boolean staffMember;
    private boolean  netjoinClosed;
    private boolean netjoinVip;
    private boolean netjoinFull;
    private boolean trackerFamous;

    // Getters
    public long getStaffPermissionId() { return staffPermissionId; }
    public boolean isStaffMember() { return staffMember; }
    public boolean isNetjoinClosed() { return netjoinClosed; }
    public boolean isNetjoinVip() { return netjoinVip; }
    public boolean isNetjoinFull() { return netjoinFull; }
    public boolean isTrackerFamous() { return trackerFamous; }

    // Setters
    public void setStaffMember(boolean staffMember) { this.staffMember = staffMember; }
    public void setNetjoinClosed(boolean netjoinClosed) { this.netjoinClosed = netjoinClosed; }
    public void setNetjoinVip(boolean netjoinVip) { this.netjoinVip = netjoinVip; }
    public void setNetjoinFull(boolean netjoinFull) { this.netjoinFull = netjoinFull; }
    public void setTrackerFamous(boolean trackerFamous) { this.trackerFamous = trackerFamous; }
}
