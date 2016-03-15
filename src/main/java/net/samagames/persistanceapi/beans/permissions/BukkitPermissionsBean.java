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
    @Perm("minecraft.command.op")
    private boolean minecraftCommandOp;
    @Perm("bukkit.command.op.give")
    private boolean bukkitCommandOpGive;
    @Perm("bukkit.command.plugins")
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
