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
  By MisterSatch & Silvanosky, January 2016
===============================================================
*/

package net.samagames.persistanceapi.beans.permissions;

import net.samagames.persistanceapi.utils.Perm;
import net.samagames.persistanceapi.utils.Transcoder;
import java.util.Map;

public class StaffPermissionsBean
{
    /* Database Structure

    Table : staff_permissions
    +----------------+------------+------+-----+---------+----------------+
    | Field          | Type       | Null | Key | Default | Extra          |
    +----------------+------------+------+-----+---------+----------------+
    | groups_id      | tinyint(4) | NO   | PRI | NULL    | auto_increment |
    | staff_member   | bit(1)     | NO   |     | NULL    |                |
    | netjoin_closed | bit(1)     | NO   |     | NULL    |                |
    | netjoin_vip    | bit(1)     | NO   |     | NULL    |                |
    | netjoin_full   | bit(1)     | NO   |     | NULL    |                |
    | tracker_famous | bit(1)     | NO   |     | NULL    |                |
    +----------------+------------+------+-----+---------+----------------+
    */

    // Defines
    private long groupsId;
    @Perm("staff.member")
    private boolean staffMember;
    @Perm("netjoin.closed")
    private boolean netjoinClosed;
    @Perm("netjoin.vip")
    private boolean netjoinVip;
    @Perm("netjoin.full")
    private boolean netjoinFull;
    @Perm("tracker.famous")
    private boolean trackerFamous;

    // Constructor
    public StaffPermissionsBean(long groupsId, boolean staffMember, boolean netjoinClosed, boolean netjoinVip, boolean netjoinFull, boolean trackerFamous)
    {
        this.groupsId = groupsId;
        this.staffMember = staffMember;
        this.netjoinClosed = netjoinClosed;
        this.netjoinVip = netjoinVip;
        this.netjoinFull = netjoinFull;
        this.trackerFamous = trackerFamous;
    }

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

    // Reverse the bean to HashMap
    public Map<String, Boolean> getHashMap()
    {
        return Transcoder.getHashMapPerm(this);
    }

    // Set a value into the HashMap
    public void set(String key, Boolean value)
    {
        Transcoder.setAnnotationValue(this, key, value);
    }
}
