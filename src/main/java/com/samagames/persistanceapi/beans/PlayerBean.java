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

package com.samagames.persistanceapi.beans;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

public class PlayerBean
{
    /* Database Structure
    +-------------+------------------+------+-----+---------------------+----------------+
    | Field       | Type             | Null | Key | Default             | Extra          |
    +-------------+------------------+------+-----+---------------------+----------------+
    | uuid        | binary(16)       | NO   | PRI | NULL                |                |
    | name        | varchar(255)     | NO   |     | NULL                |                |
    | coins       | int(11)          | NO   |     | NULL                |                |
    | stars       | int(11)          | NO   |     | NULL                |                |
    | last_Login  | timestamp        | NO   |     | 0000-00-00 00:00:00 |                |
    | first_Login | timestamp        | NO   |     | 0000-00-00 00:00:00 |                |
    | last_ip     | varchar(15)      | NO   |     | NULL                |                |
    +-------------+------------------+------+-----+---------------------+----------------+
    */

    // Define attributes
    private UUID uuid;
    private String name;
    private int coins;
    private int stars;
    private Timestamp lastLogin;
    private Timestamp firstLogin;
    private String lastIP;
    // Non persistent attributes
    private long startTime;
    private long stopTime;

    // Constructor
    public PlayerBean(UUID uuid, String name, int coins, int stars, Timestamp lastLogin, Timestamp firstLogin, String lastIP)
    {
        this.uuid = uuid;
        this.name = name;
        this.coins = coins;
        this.stars = stars;
        this.lastLogin = lastLogin;
        this.firstLogin = firstLogin;
        this.lastIP = lastIP;
    }

    // Getters
    public UUID getUuid() {
        return this.uuid;
    }
    public String getName() {
        return this.name;
    }
    public int getCoins() {
        return this.coins;
    }
    public int getStars() {
        return this.stars;
    }
    public Timestamp getLastLogin() {
        return this.lastLogin;
    }
    public Timestamp getFirstLogin() {
        return this.firstLogin;
    }
    public long getStartTime() { return startTime; }
    public long getStopTime() { return stopTime; }
    public String getLastIP() { return lastIP; }

    // Setters
    public void setUuid(UUID uuid)
    {
        this.uuid = uuid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCoins(int coins) {
        this.coins = coins;
    }
    public void setStars(int stars) {
        this.stars = stars;
    }
    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }
    public void setFirstLogin(Timestamp firstLogin) {
        this.firstLogin = firstLogin;
    }
    public void setStartTime(long startTime) { this.startTime = startTime; }
    public void setStopTime(long stopTime) { this.stopTime = stopTime; }
    public void setLastIP(String lastIP) { this.lastIP = lastIP; }

    // Get played time
    public long getPlayedTime()
    {
        return (this.getStopTime() - this.getStartTime());
    }
}
