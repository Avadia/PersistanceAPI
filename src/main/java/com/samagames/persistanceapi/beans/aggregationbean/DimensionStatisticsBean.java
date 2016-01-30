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

public class DimensionStatisticsBean
{
    /* Database Structure
    +---------------+------------------+------+-----+---------------------+----------------+
    | Field         | Type             | Null | Key | Default             | Extra          |
    +---------------+------------------+------+-----+---------------------+----------------+
    | uuid          | binary(16)       | NO   | PRI | NULL                |                |
    | deaths        | int(11)          | NO   |     | NULL                |                |
    | kills         | int(11)          | NO   |     | NULL                |                |
    | played_games  | int(11)          | NO   |     | NULL                |                |
    | wins          | int(11)          | NO   |     | NULL                |                |
    | creation_date | timestamp        | NO   |     | 0000-00-00 00:00:00 |                |
    | update_date   | timestamp        | NO   |     | 0000-00-00 00:00:00 |                |
    +---------------+------------------+------+-----+---------------------+----------------+
    */

    // Defines
    private UUID uuid;
    private int deaths;
    private int kills;
    private int playedGames;
    private int wins;
    private Timestamp creationDate;
    private Timestamp updateDate;

    // Constructor
    public DimensionStatisticsBean(UUID uuid, int deaths, int kills, int playedGames, int wins, Timestamp creationDate, Timestamp updateDate)
    {
        this.uuid = uuid;
        this.deaths = deaths;
        this.kills = kills;
        this.playedGames = playedGames;
        this.wins = wins;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    // Getters
    public int getDeaths()
    {
        return this.deaths;
    }
    public int getKills()
    {
        return this.kills;
    }
    public int getPlayedGames()
    {
        return this.playedGames;
    }
    public int getWins()
    {
        return this.wins;
    }
    public Timestamp getCreationDate() { return this.creationDate; }
    public Timestamp getUpdateDate() { return this.updateDate; }

    // Setters
    public void setDeaths(int deaths)
    {
        this.deaths = deaths;
    }
    public void setKills(int kills)
    {
        this.kills = kills;
    }
    public void setPlayedGames(int playedGames)
    {
        this.playedGames = playedGames;
    }
    public void setWins(int wins)
    {
        this.wins = wins;
    }
    public void setCreationDate(Timestamp creationDate)
    {
        this.creationDate = creationDate;
    }
    public void setUpdateDate(Timestamp updateDate)
    {
        this.updateDate = updateDate;
    }
}
