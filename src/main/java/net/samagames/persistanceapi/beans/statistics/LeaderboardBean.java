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

public class LeaderboardBean
{
    // Defines
    private String name;
    private int score;

    // Constructor
    public LeaderboardBean(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    // Getters
    public String getName() { return name; }
    public Integer getScore() { return score; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setScore(Integer score) { this.score = score; }
}
