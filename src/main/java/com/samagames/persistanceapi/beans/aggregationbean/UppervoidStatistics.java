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

import java.sql.Timestamp;
import java.util.UUID;

public class UppervoidStatistics
{
    /* Database Structure
    +---------------+------------------+------+-----+---------------------+----------------+
    | Field         | Type             | Null | Key | Default             | Extra          |
    +---------------+------------------+------+-----+---------------------+----------------+
    | uuid          | binary(16)       | NO   | PRI | NULL                |                |
    | blocks        | int(11)          | NO   |     | NULL                |                |
    | grenades      | int(11)          | NO   |     | NULL                |                |
    | kills         | int(11)          | NO   |     | NULL                |                |
    | played_games  | int(11)          | NO   |     | NULL                |                |
    | tnt_launched  | int(11)          | NO   |     | NULL                |                |
    | wins          | int(11)          | NO   |     | NULL                |                |
    | creation_date | timestamp        | NO   |     | 0000-00-00 00:00:00 |                |
    | update_date   | timestamp        | NO   |     | 0000-00-00 00:00:00 |                |
    +---------------+------------------+------+-----+---------------------+----------------+
    */

    // Defines
    public UUID uuid;
    public int blocks;
    public int grenades;
    public int kills;
    public int playedGames;
    public int tntLaunched;
    public int wins;
    public Timestamp creationDate;
    public Timestamp updateDate;

    // Constructor
    public UppervoidStatistics(UUID uuid, int blocks, int grenades, int kills, int playedGames, int tntLaunched, int wins, Timestamp creationDate, Timestamp updateDate)
    {
        this.uuid = uuid;
        this.blocks = blocks;
        this.grenades = grenades;
        this.kills = kills;
        this.playedGames = playedGames;
        this.tntLaunched = tntLaunched;
        this.wins = wins;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }
}
