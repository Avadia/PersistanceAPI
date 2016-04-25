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
    +-----------------+------------+------+-----+---------+----------------+
    | Field           | Type       | Null | Key | Default | Extra          |
    +-----------------+------------+------+-----+---------+----------------+
    | groups_id       | tinyint(4) | NO   | PRI | NULL    | auto_increment |
    | netjoin_closed  | bit(1)     | NO   |     | NULL    |                |
    | netjoin_vip     | bit(1)     | NO   |     | NULL    |                |
    | netjoin_full    | bit(1)     | NO   |     | NULL    |                |
    | tracker_famous  | bit(1)     | NO   |     | NULL    |                |
    | network_vip     | bit(1)     | NO   |     | NULL    |                |
    | network_vipplus | bit(1)     | NO   |     | NULL    |                |
    | network_staff   | bit(1)     | NO   |     | NULL    |                |
    | network_admin   | bit(1)     | NO   |     | NULL    |                |
    +-----------------+------------+------+-----+---------+----------------+
    */

    // Defines
    private long groupsId;
    @Perm("netjoin.closed")
    private boolean netjoinClosed;
    @Perm("netjoin.vip")
    private boolean netjoinVip;
    @Perm("netjoin.full")
    private boolean netjoinFull;
    @Perm("tracker.famous")
    private boolean trackerFamous;
    @Perm("network.vip")
    private boolean networkVip;
    @Perm("network.vipplus")
    private boolean networkVipplus;
    @Perm("network.staff")
    private boolean networkStaff;
    @Perm("network.admin")
    private boolean networkAdmin;


    // Constructor
    public StaffPermissionsBean(long groupsId, boolean netjoinClosed, boolean netjoinVip,
                                boolean netjoinFull, boolean trackerFamous, boolean networkVip, boolean networkVipplus,
                                boolean networkStaff, boolean networkAdmin)
    {
        this.groupsId = groupsId;
        this.netjoinClosed = netjoinClosed;
        this.netjoinVip = netjoinVip;
        this.netjoinFull = netjoinFull;
        this.trackerFamous = trackerFamous;
        this.networkVip = networkVip;
        this.networkVipplus = networkVipplus;
        this.networkStaff = networkStaff;
        this.networkAdmin = networkAdmin;
    }

    // Getters
    public long getGroupsId() { return this.groupsId; }
    public boolean isNetjoinClosed() { return this.netjoinClosed; }
    public boolean isNetjoinVip() { return this.netjoinVip; }
    public boolean isNetjoinFull() { return this.netjoinFull; }
    public boolean isTrackerFamous() { return this.trackerFamous; }
    public boolean isNetworkVip() { return networkVip; }
    public boolean isNetworkVipplus() { return networkVipplus; }
    public boolean isNetworkStaff() { return networkStaff; }
    public boolean isNetworkAdmin() { return networkAdmin; }

    // Setters
    public void setNetjoinClosed(boolean netjoinClosed) { this.netjoinClosed = netjoinClosed; }
    public void setNetjoinVip(boolean netjoinVip) { this.netjoinVip = netjoinVip; }
    public void setNetjoinFull(boolean netjoinFull) { this.netjoinFull = netjoinFull; }
    public void setTrackerFamous(boolean trackerFamous) { this.trackerFamous = trackerFamous; }
    public void setNetworkVip(boolean networkVip) { this.networkVip = networkVip; }
    public void setNetworkVipplus(boolean networkVipplus) { this.networkVipplus = networkVipplus; }
    public void setNetworkStaff(boolean networkStaff) { this.networkStaff = networkStaff; }
    public void setNetworkAdmin(boolean networkAdmin) { this.networkAdmin = networkAdmin; }

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
