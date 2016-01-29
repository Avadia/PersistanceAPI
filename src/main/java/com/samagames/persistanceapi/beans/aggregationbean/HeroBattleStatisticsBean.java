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

public class HeroBattleStatisticsBean
{
    /* Database Structure
    +---------------+------------------+------+-----+---------------------+----------------+
    | Field         | Type             | Null | Key | Default             | Extra          |
    +---------------+------------------+------+-----+---------------------+----------------+
    | uuid          | binary(16)       | NO   | PRI | NULL                |                |
    | deaths        | int(11)          | NO   |     | NULL                |                |
    | elo           | int(11)          | NO   |     | NULL                |                |
    | kills         | int(11)          | NO   |     | NULL                |                |
    | played_games  | int(11)          | NO   |     | NULL                |                |
    | powerup_taken | int(11)          | NO   |     | NULL                |                |
    | wins          | int(11)          | NO   |     | NULL                |                |
    | creation_date | timestamp        | NO   |     | 0000-00-00 00:00:00 |                |
    | update_date   | timestamp        | NO   |     | 0000-00-00 00:00:00 |                |
    +---------------+------------------+------+-----+---------------------+----------------+
    */

    // Defines
    public UUID uuid;
    public int deaths;
    public int elo;
    public int kills;
    public int playedGames;
    public int powerUpTaken;
    public int wins;
    public Timestamp creationDate;
    public Timestamp updateDate;

    // Constructor
    public HeroBattleStatisticsBean(UUID uuid, int deaths, int elo, int kills, int playedGames, int powerUpTaken, int wins, Timestamp creationDate, Timestamp updateDate)
    {
        this.uuid = uuid;
        this.deaths = deaths;
        this.elo = elo;
        this.kills = kills;
        this.playedGames = playedGames;
        this.powerUpTaken = powerUpTaken;
        this.wins = wins;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }
}
