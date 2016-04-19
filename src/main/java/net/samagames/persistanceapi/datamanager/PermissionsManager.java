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

package net.samagames.persistanceapi.datamanager;

import net.samagames.persistanceapi.beans.players.PlayerBean;
import net.samagames.persistanceapi.beans.permissions.*;
import net.samagames.persistanceapi.datamanager.aggregationmanager.permissions.*;
import javax.sql.DataSource;

public class PermissionsManager
{
    // Defines
    public APIPermissionManager apiPermissionManager;
    public BukkitPermissionManager bukkitPermissionManager;
    public BungeeRedisPermissionManager bungeeRedisPermissionManager;
    public HubPermissionManager hubPermissionManager;
    public ModerationPermissionManager moderationPermissionManager;
    public ProxiesPermissionManager proxiesPermissionManager;
    public StaffPermissionManager staffPermissionManager;
    public UHCPermissionManager uhcPermissionManager;

    // Constructor
    public PermissionsManager()
    {
        this.apiPermissionManager =  new APIPermissionManager();
        this.bukkitPermissionManager = new BukkitPermissionManager();
        this.bungeeRedisPermissionManager = new BungeeRedisPermissionManager();
        this.hubPermissionManager = new HubPermissionManager();
        this.moderationPermissionManager = new ModerationPermissionManager();
        this.proxiesPermissionManager = new ProxiesPermissionManager();
        this.staffPermissionManager = new StaffPermissionManager();
        this.uhcPermissionManager = new UHCPermissionManager();
    }

    // Get all player permissions
    public PlayerPermissionBean getAllPlayerPermission(PlayerBean player, DataSource dataSource) throws Exception
    {
        // Declared bean
        APIPermissionsBean apiPermissions;
        BukkitPermissionsBean bukkitPermissions;
        BungeeRedisPermissionsBean bungeeRedisPermisions;
        HubPermissionsBean hubPermissions;
        ModerationPermissionsBean moderationPermissions;
        ProxiesPermissionsBean proxiesPermissions;
        StaffPermissionsBean staffPermissions;
        UHCPermissionsBean uhcPermissions;

        // Get the different permissions bean
        try
        {
            apiPermissions = this.apiPermissionManager.getAPIPermission(player, dataSource);
            bukkitPermissions = this.bukkitPermissionManager.getBukkitPermission(player, dataSource);
            bungeeRedisPermisions = this.bungeeRedisPermissionManager.getBungeeRedisPemission(player, dataSource);
            hubPermissions = this.hubPermissionManager.getHubPermission(player, dataSource);
            moderationPermissions = this.moderationPermissionManager.getModerationPermission(player, dataSource);
            proxiesPermissions = this.proxiesPermissionManager.getProxiesPermission(player, dataSource);
            staffPermissions = this.staffPermissionManager.getStaffPermission(player, dataSource);
            uhcPermissions = this.uhcPermissionManager.getUHCPermission(player, dataSource);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }

        // Create the aggregation of different permissions bean
        PlayerPermissionBean playerPermissionBean = new PlayerPermissionBean(apiPermissions, bukkitPermissions, bungeeRedisPermisions, hubPermissions, moderationPermissions, proxiesPermissions,
                staffPermissions, uhcPermissions);
        return playerPermissionBean;
    }
}
