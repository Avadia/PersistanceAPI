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

public class TheDropperMapStatisticsBean
{
    /* Database Structure

    Table: thedropper_maps_stats
    +---------------+--------------+------+-----+---------------------+-------+
    | Field         | Type         | Null | Key | Default             | Extra |
    +---------------+--------------+------+-----+---------------------+-------+
    | uuid          | binary(16)   | NO   | PRI | NULL                |       |
    | map_name      | varchar(255) | NO   |     | NULL                |       |
    | tries         | int(11)      | NO   |     | NULL                |       |
    | wins          | int(11)      | NO   |     | NULL                |       |
    | best_time     | bigint(20)   | NO   |     | NULL                |       |
    +---------------+--------------+------+-----+---------------------+-------+
    */

    // Defines
    private UUID uuid;
    private String mapName;
    private int tries;
    private int wins;
    private long bestTime;

    // Constructor
    @ConstructorProperties({"uuid", "mapName", "tries", "wins", "bestTime"})
    public TheDropperMapStatisticsBean(UUID uuid, String mapName, int tries, int wins, long bestTime)
    {
        this.uuid = uuid;
        this.mapName = mapName;
        this.tries = tries;
        this.wins = wins;
        this.bestTime = bestTime;
    }

    // Getters
    public String getMapName()
    {
        return this.mapName;
    }
    public int getTries()
    {
        return this.tries;
    }
    public int getWins()
    {
        return wins;
    }
    public long getBestTime()
    {
        return bestTime;
    }

    // Setters
    public void setMapName(String mapName)
    {
        this.mapName = mapName;
    }
    public void setTries(int tries)
    {
        this.tries = tries;
    }
    public void setWins(int wins)
    {
        this.wins = wins;
    }
    public void setBestTime(long bestTime)
    {
        this.bestTime = bestTime;
    }
}
