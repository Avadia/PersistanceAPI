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

package com.samagames.persistanceapi.beans.statistics;

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
    | played_time   | bigint(20)       | NO   |     | NULL                |                |
    +---------------+------------------+------+-----+---------------------+----------------+
    */

    // Defines
    private UUID uuid;
    private int blocks;
    private int grenades;
    private int kills;
    private int playedGames;
    private int tntLaunched;
    private int wins;
    private Timestamp creationDate;
    private Timestamp updateDate;
    private long playedTime;

    // Constructor
    public UppervoidStatistics(UUID uuid, int blocks, int grenades, int kills, int playedGames, int tntLaunched, int wins, Timestamp creationDate, Timestamp updateDate, long playedTime)
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
        this.playedTime = playedTime;
    }

    // Getters
    public int getBlocks()
    {
        return this.blocks;
    }
    public int getGrenades()
    {
        return this.grenades;
    }
    public int getKills()
    {
        return this.kills;
    }
    public int getPlayedGames()
    {
        return this.playedGames;
    }
    public int getTntLaunched()
    {
        return this.tntLaunched;
    }
    public int getWins()
    {
        return this.wins;
    }
    public Timestamp getCreationDate()
    {
        return this.creationDate;
    }
    public Timestamp getUpdateDate()
    {
        return this.updateDate;
    }
    public long getPlayedTime() { return playedTime; }

    // Setters
    public void setBlocks(int blocks)
    {
        this.blocks = blocks;
    }
    public void setGrenades(int grenades)
    {
        this.grenades = grenades;
    }
    public void setKills(int kills)
    {
        this.kills = kills;
    }
    public void setPlayedGames(int playedGames)
    {
        this.playedGames = playedGames;
    }
    public void setTntLaunched(int tntLaunched)
    {
        this.tntLaunched = tntLaunched;
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
    public void setPlayedTime(long playedTime) { this.playedTime = playedTime; }
}
