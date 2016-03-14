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

import java.lang.annotation.Target;
import java.util.HashMap;

public class PlayerPermissionBean
{
    // Defines aggregation of permissions
    private APIPermissionsBean apiPermissions;
    private BukkitPermissionsBean bukkitPermissions;
    private BungeeRedisPermissionsBean bungeeRedisPermisions;
    private HubPermissionsBean hubPermissions;
    private ModerationPermissionsBean moderationPermissions;
    private ProxiesPermissionsBean proxiesPermissions;
    private StaffPermissionsBean staffPermissions;
    private UHCPermissionsBean uhcPermissions;

    // Constructor
    public PlayerPermissionBean(APIPermissionsBean apiPermissions, BukkitPermissionsBean bukkitPermissions, BungeeRedisPermissionsBean bungeeRedisPermisions, HubPermissionsBean hubPermissions,
                                ModerationPermissionsBean moderationPermissions, ProxiesPermissionsBean proxiesPermissions, StaffPermissionsBean staffPermissions, UHCPermissionsBean uhcPermissions)
    {
        this.apiPermissions = apiPermissions;
        this.bukkitPermissions = bukkitPermissions;
        this.bungeeRedisPermisions = bungeeRedisPermisions;
        this.hubPermissions = hubPermissions;
        this.moderationPermissions = moderationPermissions;
        this.proxiesPermissions = proxiesPermissions;
        this.staffPermissions = staffPermissions;
        this.uhcPermissions = uhcPermissions;
    }

    // Getters
    public APIPermissionsBean getApiPermissions() { return apiPermissions; }
    public BukkitPermissionsBean getBukkitPermissions() { return bukkitPermissions; }
    public BungeeRedisPermissionsBean getBungeeRedisPermisions() { return bungeeRedisPermisions; }
    public HubPermissionsBean getHubPermissions() { return hubPermissions; }
    public ModerationPermissionsBean getModerationPermissions() { return moderationPermissions; }
    public ProxiesPermissionsBean getProxiesPermissions() { return proxiesPermissions; }
    public StaffPermissionsBean getStaffPermissions() { return staffPermissions; }
    public UHCPermissionsBean getUhcPermissions() { return uhcPermissions; }

    // Setters
    public void setApiPermissions(APIPermissionsBean apiPermissions) { this.apiPermissions = apiPermissions; }
    public void setBukkitPermissions(BukkitPermissionsBean bukkitPermissions) { this.bukkitPermissions = bukkitPermissions; }
    public void setBungeeRedisPermisions(BungeeRedisPermissionsBean bungeeRedisPermisions) { this.bungeeRedisPermisions = bungeeRedisPermisions; }
    public void setHubPermissions(HubPermissionsBean hubPermissions) { this.hubPermissions = hubPermissions; }
    public void setModerationPermissions(ModerationPermissionsBean moderationPermissions) { this.moderationPermissions = moderationPermissions; }
    public void setProxiesPermissions(ProxiesPermissionsBean proxiesPermissions) { this.proxiesPermissions = proxiesPermissions; }
    public void setStaffPermissions(StaffPermissionsBean staffPermissions) { this.staffPermissions = staffPermissions; }
    public void setUhcPermissions(UHCPermissionsBean uhcPermissions) { this.uhcPermissions = uhcPermissions; }

    // Reverse the bean to HashMap
    public HashMap<String, Boolean> getHashMap()
    {
        HashMap<String, Boolean> permissionHashMap = new HashMap<>();
        permissionHashMap.putAll(this.apiPermissions.getHashMap());
        permissionHashMap.putAll(this.bukkitPermissions.getHashMap());
        permissionHashMap.putAll(this.bungeeRedisPermisions.getHashMap());
        permissionHashMap.putAll(this.hubPermissions.getHashMap());
        permissionHashMap.putAll(this.moderationPermissions.getHashMap());
        permissionHashMap.putAll(this.proxiesPermissions.getHashMap());
        permissionHashMap.putAll(this.staffPermissions.getHashMap());
        permissionHashMap.putAll(this.uhcPermissions.getHashMap());
        return permissionHashMap;
    }
}
