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

public class ProxiesPermissionsBean
{
    /* Database Structure
    +-----------------------+------------+------+-----+---------+-------+
    | Field                 | Type       | Null | Key | Default | Extra |
    +-----------------------+------------+------+-----+---------+-------+
    | proxies_permission_id | bigint(20) | NO   | PRI | NULL    |       |
    | proxies_dispatch      | tinyint(1) | NO   |     | NULL    |       |
    | proxies_global        | tinyint(1) | NO   |     | NULL    |       |
    | proxies_debug         | tinyint(1) | NO   |     | NULL    |       |
    | proxies_set_option    | tinyint(1) | NO   |     | NULL    |       |
    +-----------------------+------------+------+-----+---------+-------+
    */

    // Defines
    private long proxiesPermissionId;
    private boolean proxiesDispatch;
    private boolean proxiesGlobal;
    private boolean proxiesDebug;
    private boolean proxiesSetOption;

    // Getters
    public long getProxiesPermissionId() { return proxiesPermissionId; }
    public boolean isProxiesDispatch() { return proxiesDispatch; }
    public boolean isProxiesGlobal() { return proxiesGlobal; }
    public boolean isProxiesDebug() { return proxiesDebug; }
    public boolean isProxiesSetOption() { return proxiesSetOption; }

    // Setters
    public void setProxiesDispatch(boolean proxiesDispatch) { this.proxiesDispatch = proxiesDispatch; }
    public void setProxiesGlobal(boolean proxiesGlobal) { this.proxiesGlobal = proxiesGlobal; }
    public void setProxiesDebug(boolean proxiesDebug) { this.proxiesDebug = proxiesDebug; }
    public void setProxiesSetOption(boolean proxiesSetOption) { this.proxiesSetOption = proxiesSetOption; }

}
