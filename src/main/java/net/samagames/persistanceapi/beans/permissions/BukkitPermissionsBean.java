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

public class BukkitPermissionsBean
{
    /* Database Structure

    Table : bukkit_permissions
    +------------------------+------------+------+-----+---------+----------------+
    | Field                  | Type       | Null | Key | Default | Extra          |
    +------------------------+------------+------+-----+---------+----------------+
    | groups_id              | bigint(20) | NO   | PRI | NULL    | auto_increment |
    | minecraft_command_op   | tinyint(1) | NO   |     | NULL    |                |
    | bukkit_command_op_give | tinyint(1) | NO   |     | NULL    |                |
    | bukkit_command_plugins | tinyint(1) | NO   |     | NULL    |                |
    +------------------------+------------+------+-----+---------+----------------+
    */

    // Defines
    private long groupsId;
    private boolean minecraftCommandOp;
    private boolean bukkitCommandOpGive;
    private boolean bukkitCommandPlugins;

    // Constructor
    public BukkitPermissionsBean(long groupsId, boolean minecraftCommandOp, boolean bukkitCommandOpGive, boolean bukkitCommandPlugins)
    {
        this.groupsId = groupsId;
        this.minecraftCommandOp = minecraftCommandOp;
        this.bukkitCommandOpGive = bukkitCommandOpGive;
        this.bukkitCommandPlugins = bukkitCommandPlugins;
    }

    // Getters
    public long getGroupsId() { return groupsId; }
    public boolean isMinecraftCommandOp() { return this.minecraftCommandOp; }
    public boolean isBukkitCommandOpGive() { return this.bukkitCommandOpGive; }
    public boolean isBukkitCommandPlugins() { return this.bukkitCommandPlugins; }

    // Setters
    public void setMinecraftCommandOp(boolean minecraftCommandOp) { this.minecraftCommandOp = minecraftCommandOp; }
    public void setBukkitCommandOpGive(boolean bukkitCommandOpGive) { this.bukkitCommandOpGive = bukkitCommandOpGive; }
    public void setBukkitCommandPlugins(boolean bukkitCommandPlugins) { this.bukkitCommandPlugins = bukkitCommandPlugins; }

}
