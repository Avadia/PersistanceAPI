package net.samagames.persistanceapi.datamanager;

import net.samagames.persistanceapi.beans.permissions.*;
import net.samagames.persistanceapi.beans.players.PlayerBean;
import net.samagames.persistanceapi.datamanager.aggregationmanager.permissions.*;
import net.samagames.persistanceapi.datamanager.database.DatabaseAccess;

/*
 * This file is part of PersistanceAPI.
 *
 * PersistanceAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PersistanceAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PersistanceAPI.  If not, see <http://www.gnu.org/licenses/>.
 */
public class PermissionsManager {
    // Defines
    public APIPermissionsManager apiPermissionsManager;
    public BukkitPermissionsManager bukkitPermissionsManager;
    public BungeeRedisPermissionsManager bungeeRedisPermissionsManager;
    public HubPermissionsManager hubPermissionsManager;
    public ModerationPermissionsManager moderationPermissionsManager;
    public ProxiesPermissionsManager proxiesPermissionsManager;
    public StaffPermissionsManager staffPermissionsManager;

    // Constructor
    public PermissionsManager() {
        this.apiPermissionsManager = new APIPermissionsManager();
        this.bukkitPermissionsManager = new BukkitPermissionsManager();
        this.bungeeRedisPermissionsManager = new BungeeRedisPermissionsManager();
        this.hubPermissionsManager = new HubPermissionsManager();
        this.moderationPermissionsManager = new ModerationPermissionsManager();
        this.proxiesPermissionsManager = new ProxiesPermissionsManager();
        this.staffPermissionsManager = new StaffPermissionsManager();
    }

    // Get all player permissions
    public PlayerPermissionsBean getAllPlayerPermissions(PlayerBean player, DatabaseAccess databaseAccess) throws Exception {
        // Declared bean
        APIPermissionsBean apiPermissions;
        BukkitPermissionsBean bukkitPermissions;
        BungeeRedisPermissionsBean bungeeRedisPermissions;
        HubPermissionsBean hubPermissions;
        ModerationPermissionsBean moderationPermissions;
        ProxiesPermissionsBean proxiesPermissions;
        StaffPermissionsBean staffPermissions;

        // Get the different permissions bean
        try {
            apiPermissions = this.apiPermissionsManager.getAPIPermissions(player, databaseAccess);
            bukkitPermissions = this.bukkitPermissionsManager.getBukkitPermissions(player, databaseAccess);
            bungeeRedisPermissions = this.bungeeRedisPermissionsManager.getBungeeRedisPermissions(player, databaseAccess);
            hubPermissions = this.hubPermissionsManager.getHubPermissions(player, databaseAccess);
            moderationPermissions = this.moderationPermissionsManager.getModerationPermissions(player, databaseAccess);
            proxiesPermissions = this.proxiesPermissionsManager.getProxiesPermissions(player, databaseAccess);
            staffPermissions = this.staffPermissionsManager.getStaffPermissions(player, databaseAccess);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }

        // Create the aggregation of different permissions bean
        return new PlayerPermissionsBean(apiPermissions, bukkitPermissions, bungeeRedisPermissions, hubPermissions, moderationPermissions, proxiesPermissions, staffPermissions);
    }
}
