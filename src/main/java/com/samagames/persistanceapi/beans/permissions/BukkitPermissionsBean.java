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

public class BukkitPermissionsBean
{
    /* Database Structure
    +------------------------+------------+------+-----+---------+-------+
    | Field                  | Type       | Null | Key | Default | Extra |
    +------------------------+------------+------+-----+---------+-------+
    | bukkit_permission_id   | bigint(20) | NO   | PRI | NULL    |       |
    | minecraft_command_op   | tinyint(1) | NO   |     | NULL    |       |
    | bukkit_command_op_give | tinyint(1) | NO   |     | NULL    |       |
    | bukkit_command_plugins | tinyint(1) | NO   |     | NULL    |       |
    +------------------------+------------+------+-----+---------+-------+
    */

    // Defines
    private long bukkitPermissionId;
    private boolean minecraftCommandOp;
    private boolean bukkitCommandOpGive;
    private boolean bukkitCommandPlugins;

    // Getters
    public long getBukkitPermissionId() { return bukkitPermissionId; }
    public boolean isMinecraftCommandOp() { return minecraftCommandOp; }
    public boolean isBukkitCommandOpGive() { return bukkitCommandOpGive; }
    public boolean isBukkitCommandPlugins() { return bukkitCommandPlugins; }

    // Setters
    public void setMinecraftCommandOp(boolean minecraftCommandOp) { this.minecraftCommandOp = minecraftCommandOp; }
    public void setBukkitCommandOpGive(boolean bukkitCommandOpGive) { this.bukkitCommandOpGive = bukkitCommandOpGive; }
    public void setBukkitCommandPlugins(boolean bukkitCommandPlugins) { this.bukkitCommandPlugins = bukkitCommandPlugins; }

}
