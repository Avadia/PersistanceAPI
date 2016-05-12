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

package net.samagames.persistanceapi.beans.statistics;

import java.beans.ConstructorProperties;
import java.sql.Timestamp;
import java.util.UUID;

public class HeroBattleStatisticsBean
{
    /* Database Structure

    Table : herobattle_stats
    +---------------+------------+------+-----+---------------------+-------+
    | Field         | Type       | Null | Key | Default             | Extra |
    +---------------+------------+------+-----+---------------------+-------+
    | uuid          | binary(16) | NO   | PRI | NULL                |       |
    | deaths        | int(11)    | NO   |     | NULL                |       |
    | elo           | int(11)    | NO   |     | NULL                |       |
    | kills         | int(11)    | NO   |     | NULL                |       |
    | played_games  | int(11)    | NO   |     | NULL                |       |
    | powerup_taken | int(11)    | NO   |     | NULL                |       |
    | wins          | int(11)    | NO   |     | NULL                |       |
    | creation_date | timestamp  | NO   |     | 0000-00-00 00:00:00 |       |
    | update_date   | timestamp  | NO   |     | 0000-00-00 00:00:00 |       |
    | played_time   | bigint(20) | NO   |     | NULL                |       |
    +---------------+------------+------+-----+---------------------+-------+
    */

    // Defines
    private UUID uuid;
    private int deaths;
    private int elo;
    private int kills;
    private int playedGames;
    private int powerUpTaken;
    private int wins;
    private Timestamp creationDate;
    private Timestamp updateDate;
    private long playedTime;

    // Constructor
    @ConstructorProperties({"uuid", "deaths", "elo", "kills", "playedGames", "powerUpTaken", "wins", "creationDate", "updateDate", "playedTime"})
    public HeroBattleStatisticsBean(UUID uuid, int deaths, int elo, int kills, int playedGames, int powerUpTaken, int wins, Timestamp creationDate, Timestamp updateDate, long playedTime)
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
        this.playedTime = playedTime;
    }

    // Getters
    public int getDeaths() { return this.deaths; }
    public int getElo()
    {
        return this.elo;
    }
    public int getKills()
    {
        return this.kills;
    }
    public int getPlayedGames()
    {
        return this.playedGames;
    }
    public int getPowerUpTaken()
    {
        return this.powerUpTaken;
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
    public void setDeaths(int deaths)
    {
        this.deaths = deaths;
    }
    public void setElo(int elo)
    {
        this.elo = elo;
    }
    public void setKills(int kills) {
        this.kills = kills;
    }
    public void setPlayedGames(int playedGames)
    {
        this.playedGames = playedGames;
    }
    public void setPowerUpTaken(int powerUpTaken) {
        this.powerUpTaken = powerUpTaken;
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
