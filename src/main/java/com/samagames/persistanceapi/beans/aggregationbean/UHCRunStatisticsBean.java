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

package com.samagames.persistanceapi.beans.aggregationbean;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

public class UHCRunStatisticsBean
{
    /* Database Structure
    +---------------+------------------+------+-----+---------------------+----------------+
    | Field         | Type             | Null | Key | Default             | Extra          |
    +---------------+------------------+------+-----+---------------------+----------------+
    | uuid          | binary(16)       | NO   | PRI | NULL                |                |
    | dammages      | int(11)          | NO   |     | NULL                |                |
    | deaths        | int(11)          | NO   |     | NULL                |                |
    | kills         | int(11)          | NO   |     | NULL                |                |
    | max_dammages  | int(11)          | NO   |     | NULL                |                |
    | played_games  | int(11)          | NO   |     | NULL                |                |
    | wins          | int(11)          | NO   |     | NULL                |                |
    | creation_date | timestamp        | NO   |     | 0000-00-00 00:00:00 |                |
    | update_date   | timestamp        | NO   |     | 0000-00-00 00:00:00 |                |
    +---------------+------------------+------+-----+---------------------+----------------+
    */

    // Defines
    public UUID uuid;
    public int dammages;
    public int deaths;
    public int kills;
    public int maxDammages;
    public int playedGames;
    public int wins;
    public Timestamp creationDate;
    public Timestamp updateDate;
}
