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

public class UHCPermissionsBean
{
    /* Database Structure
    +-------------+------------------+------+-----+---------------------+----------------+
    | Field       | Type             | Null | Key | Default             | Extra          |
    +-------------+------------------+------+-----+---------------------+----------------+
    | uuid        | binary(16)       | NO   | PRI | NULL                |                |
    +-------------+------------------+------+-----+---------------------+----------------+
    */

    // Defines
    private long uhcPermissionId;
    private boolean uhcTeamlock;
    private boolean uhcTeamName;
    private boolean uhcTeaminvite;

    // Getters
    public long getUhcPermissionId() { return uhcPermissionId; }
    public boolean isUhcTeamlock() { return uhcTeamlock; }
    public boolean isUhcTeamName() { return uhcTeamName; }
    public boolean isUhcTeaminvite() { return uhcTeaminvite; }

    // Setters
    public void setUhcTeamlock(boolean uhcTeamlock) { this.uhcTeamlock = uhcTeamlock; }
    public void setUhcTeamName(boolean uhcTeamName) { this.uhcTeamName = uhcTeamName; }
    public void setUhcTeaminvite(boolean uhcTeaminvite) { this.uhcTeaminvite = uhcTeaminvite; }

}
