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

package net.samagames.persistanceapi.beans;

public class GroupsBean
{
    /* Database Structure
    +-------------+--------------+------+-----+---------------------+-------+
    | Field       | Type         | Null | Key | Default             | Extra |
    +-------------+--------------+------+-----+---------------------+-------+

    +-------------+--------------+------+-----+---------------------+-------+
    */

    // Defines
    private long groupId;
    private String name;
    private int rank;
    private String tag;
    private String prefix;
    private String suffix;
    private int multiplier;

    // Getters
    public long getGroupId() { return groupId; }
    public String getName() { return name; }
    public int getRank() { return rank; }
    public String getTag() { return tag; }
    public String getPrefix() { return prefix; }
    public String getSuffix() { return suffix; }
    public int getMultiplier() { return multiplier; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setRank(int rank) { this.rank = rank; }
    public void setTag(String tag) { this.tag = tag; }
    public void setPrefix(String prefix) { this.prefix = prefix; }
    public void setSuffix(String suffix) { this.suffix = suffix; }
    public void setMultiplier(int multiplier) { this.multiplier = multiplier; }

}
