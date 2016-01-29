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
    +-------------+------------------+------+-----+---------------------+----------------+
    */

    // Define attributes
    public UUID uuid;
    public String name;
    public int coins;
    public int stars;
    public Timestamp lastLogin;
    public Timestamp firstLogin;

    // Constructor
    public PlayerBean(UUID uuid, String name, int coins, int stars, Timestamp lastLogin, Timestamp firstLogin)
    {
        this.uuid = uuid;
        this.name = name;
        this.coins = coins;
        this.stars = stars;
        this.lastLogin = lastLogin;
        this.firstLogin = firstLogin;
    }

    // UUID getter
    public UUID getUuid()
    {
        // Return the UUID
        return this.uuid;
    }

    // Name getter
    public String getName()
    {
        // Return the name
        return this.name;
    }

    // Coins getter
    public int getCoins()
    {
        // Return the coins
        return this.coins;
    }

    // Stars getter
    public int getStars()
    {
        // Return the stars
        return this.stars;
    }

    // LastLogin getter
    public Timestamp getLastLogin()
    {
        // Return the last login
        return this.lastLogin;
    }

    // FirstLogin getter
    public Timestamp getFirstLogin()
    {
        // Return the first login
        return this.firstLogin;
    }

    // Coins setter
    public void setCoins(int coins)
    {
        // Set coins
        this.coins=coins;
    }

    // Stars setter
    public void setStars(int stars)
    {
        // set stars
        this.stars=stars;
    }
}
