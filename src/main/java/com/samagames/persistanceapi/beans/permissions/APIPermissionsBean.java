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

public class APIPermissionsBean
{
    /* Database Structure
    +-------------------------+------------+------+-----+---------+-------+
    | Field                   | Type       | Null | Key | Default | Extra |
    +-------------------------+------------+------+-----+---------+-------+
    | api_permission_id       | bigint(20) | NO   | PRI | NULL    |       |
    | api_servers_debug       | tinyint(1) | NO   |     | NULL    |       |
    | api_permissions_refresh | tinyint(1) | NO   |     | NULL    |       |
    | api_coins_get_other     | tinyint(1) | NO   |     | NULL    |       |
    | api_coins_credit        | tinyint(1) | NO   |     | NULL    |       |
    | api_coins_withdraw      | tinyint(1) | NO   |     | NULL    |       |
    | api_inventory_show      | tinyint(1) | NO   |     | NULL    |       |
    | api_player_data_set     | tinyint(1) | NO   |     | NULL    |       |
    | api_player_data_del     | tinyint(1) | NO   |     | NULL    |       |
    | api_modo_speakup        | tinyint(1) | NO   |     | NULL    |       |
    | api_stars_getother      | tinyint(1) | NO   |     | NULL    |       |
    | api_stars_credit        | tinyint(1) | NO   |     | NULL    |       |
    | api_stars_withdraw      | tinyint(1) | NO   |     | NULL    |       |
    | api_game_start          | tinyint(1) | NO   |     | NULL    |       |
    +-------------------------+------------+------+-----+---------+-------+
    */

    // Defines
    private long apiPermissionId;
    private boolean apiServersDebug;
    private boolean apiPermissionsRefresh;
    private boolean apiCoinsGetOther;
    private boolean apiCoinsCredit;
    private boolean apiCoinsWithdraw;
    private boolean apiInventoryShow;
    private boolean apiPlayerdataSet;
    private boolean apiPlayerdataDel;
    private boolean apiModoSpeakup;
    private boolean apiStarsGetother;
    private boolean apiStarsCredit;
    private boolean apiStarsWithdraw;
    private boolean apiGameStart;

    // Getters
    public boolean isApiServersDebug() { return apiServersDebug; }
    public boolean isApiPermissionsRefresh() { return apiPermissionsRefresh; }
    public boolean isApiCoinsGetother() { return apiCoinsGetOther; }
    public boolean isApiCoinsCredit() { return apiCoinsCredit; }
    public boolean isApiCoinsWithdraw() { return apiCoinsWithdraw; }
    public boolean isApiInventoryShow() { return apiInventoryShow; }
    public boolean isApiPlayerdataSet() { return apiPlayerdataSet; }
    public boolean isApiPlayerdataDel() { return apiPlayerdataDel; }
    public boolean isApiModoSpeakup() { return apiModoSpeakup; }
    public boolean isApiStarsGetother() { return apiStarsGetother; }
    public boolean isApiStarsCredit() { return apiStarsCredit; }
    public boolean isApiStarsWithdraw() { return apiStarsWithdraw; }
    public boolean isApiGameStart() { return apiGameStart; }
    public long getApiPermissionId() { return apiPermissionId; }

    // Setters
    public void setApiServersDebug(boolean apiServersDebug) { this.apiServersDebug = apiServersDebug; }
    public void setApiPermissionsRefresh(boolean apiPermissionsRefresh) { this.apiPermissionsRefresh = apiPermissionsRefresh; }
    public void setApiCoinsGetother(boolean apiCoinsGetother) { this.apiCoinsGetOther = apiCoinsGetother; }
    public void setApiCoinsCredit(boolean apiCoinsCredit) { this.apiCoinsCredit = apiCoinsCredit; }
    public void setApiCoinsWithdraw(boolean apiCoinsWithdraw) { this.apiCoinsWithdraw = apiCoinsWithdraw; }
    public void setApiInventoryShow(boolean apiInventoryShow) { this.apiInventoryShow = apiInventoryShow; }
    public void setApiPlayerdataSet(boolean apiPlayerdataSet) { this.apiPlayerdataSet = apiPlayerdataSet; }
    public void setApiPlayerdataDel(boolean apiPlayerdataDel) { this.apiPlayerdataDel = apiPlayerdataDel; }
    public void setApiModoSpeakup(boolean apiModoSpeakup) { this.apiModoSpeakup = apiModoSpeakup; }
    public void setApiStarsGetother(boolean apiStarsGetother) { this.apiStarsGetother = apiStarsGetother; }
    public void setApiStarsCredit(boolean apiStarsCredit) { this.apiStarsCredit = apiStarsCredit; }
    public void setApiStarsWithdraw(boolean apiStarsWithdraw) { this.apiStarsWithdraw = apiStarsWithdraw; }
    public void setApiGameStart(boolean apiGameStart) { this.apiGameStart = apiGameStart; }

}
