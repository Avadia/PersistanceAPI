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

public class SanctionBean
{
    /* Database Structure
    +-----------------+------------------+------+-----+---------------------+----------------+
    | Field           | Type             | Null | Key | Default             | Extra          |
    +-----------------+------------------+------+-----+---------------------+----------------+
    | player_uuid     | binary(16)       | NO   | PRI | NULL                |                |
    | type_id         | int(11)          | NO   |     | NULL                |                |
    | reason          | varchar(25       | NO   |     | NULL                |                |
    | punisher_uuid   | binary(16)       | NO   |     | NULL                |                |
    | expiration_time | timestamp        | NO   |     | 0000-00-00 00:00:00 |                |
    | is_deleted      | tinyint(1)       | NO   |     | NULL                |                |
    | creation_date   | timestamp        | NO   |     | 0000-00-00 00:00:00 |                |
    | update_date     | timestamp        | NO   |     | 0000-00-00 00:00:00 |                |
    +-----------------+------------------+------+-----+---------------------+----------------+
    */

    // Defines sanctions types
    public static int AVERTISSEMENT = 1;
    public static int BAN = 2;
    public static int KICK = 3;
    public static int MUTE = 4;
    public static int TEXT = 5;

    // Define attributes
    public String playerUuid;
    public int typeId;
    public String reason;
    public String punisherUuid;
    public Timestamp expirationTime;
    public boolean isDeleted;
    public Timestamp creationDate;
    public Timestamp updateDate;



}
