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

import net.samagames.persistanceapi.beans.PlayerBean;
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
    public PlayerPermissionBean getPlayerPermission(PlayerBean player, DataSource dataSource)
    {
        // Get the different permissions bean
        APIPermissionsBean apiPermissions = this.apiPermissionManager.getPermission(player, dataSource);
        BukkitPermissionsBean bukkitPermissions = this.bukkitPermissionManager.getPermission(player, dataSource);
        BungeeRedisPermissionsBean bungeeRedisPermisions = this.bungeeRedisPermissionManager.getPemission(player, dataSource);
        HubPermissionsBean hubPermissions = this.hubPermissionManager.getPermission(player, dataSource);
        ModerationPermissionsBean moderationPermissions = this.moderationPermissionManager.getPermission(player, dataSource);
        ProxiesPermissionsBean proxiesPermissions = this.proxiesPermissionManager.getPermission(player, dataSource);
        StaffPermissionsBean staffPermissions = this.staffPermissionManager.getPermission(player, dataSource);
        UHCPermissionsBean uhcPermissions = this.uhcPermissionManager.getPermission(player, dataSource);

        // Create the aggregation of different permissions bean
        PlayerPermissionBean playerPermissionBean = new PlayerPermissionBean(apiPermissions, bukkitPermissions, bungeeRedisPermisions, hubPermissions, moderationPermissions, proxiesPermissions,
                staffPermissions, uhcPermissions);
        return playerPermissionBean;
    }
}
