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
    public APIPermissionsManager apiPermissionsManager;
    public BukkitPermissionsManager bukkitPermissionsManager;
    public BungeeRedisPermissionsManager bungeeRedisPermissionsManager;
    public HubPermissionsManager hubPermissionsManager;
    public ModerationPermissionsManager moderationPermissionsManager;
    public ProxiesPermissionsManager proxiesPermissionsManager;
    public StaffPermissionsManager staffPermissionsManager;

    // Constructor
    public PermissionsManager()
    {
        this.apiPermissionsManager =  new APIPermissionsManager();
        this.bukkitPermissionsManager = new BukkitPermissionsManager();
        this.bungeeRedisPermissionsManager = new BungeeRedisPermissionsManager();
        this.hubPermissionsManager = new HubPermissionsManager();
        this.moderationPermissionsManager = new ModerationPermissionsManager();
        this.proxiesPermissionsManager = new ProxiesPermissionsManager();
        this.staffPermissionsManager = new StaffPermissionsManager();
    }

    // Get all player permissions
    public PlayerPermissionsBean getAllPlayerPermissions(PlayerBean player, DataSource dataSource) throws Exception
    {
        // Declared bean
        APIPermissionsBean apiPermissions;
        BukkitPermissionsBean bukkitPermissions;
        BungeeRedisPermissionsBean bungeeRedisPermissions;
        HubPermissionsBean hubPermissions;
        ModerationPermissionsBean moderationPermissions;
        ProxiesPermissionsBean proxiesPermissions;
        StaffPermissionsBean staffPermissions;

        // Get the different permissions bean
        try
        {
            apiPermissions = this.apiPermissionsManager.getAPIPermissions(player, dataSource);
            bukkitPermissions = this.bukkitPermissionsManager.getBukkitPermissions(player, dataSource);
            bungeeRedisPermissions = this.bungeeRedisPermissionsManager.getBungeeRedisPermissions(player, dataSource);
            hubPermissions = this.hubPermissionsManager.getHubPermissions(player, dataSource);
            moderationPermissions = this.moderationPermissionsManager.getModerationPermissions(player, dataSource);
            proxiesPermissions = this.proxiesPermissionsManager.getProxiesPermissions(player, dataSource);
            staffPermissions = this.staffPermissionsManager.getStaffPermissions(player, dataSource);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }

        // Create the aggregation of different permissions bean
        PlayerPermissionsBean playerPermissionBean = new PlayerPermissionsBean(apiPermissions, bukkitPermissions, bungeeRedisPermissions, hubPermissions, moderationPermissions, proxiesPermissions, staffPermissions);

        return playerPermissionBean;
    }
}
