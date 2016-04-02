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

    Table : groups
    +-------------+--------------+------+-----+---------+----------------+
    | Field       | Type         | Null | Key | Default | Extra          |
    +-------------+--------------+------+-----+---------+----------------+
    | group_id    | bigint(20)   | NO   | PRI | NULL    | auto_increment |
    | player_name | varchar(255) | NO   |     | NULL    |                |
    | rank        | int(11)      | NO   |     | NULL    |                |
    | tag         | varchar(255) | NO   |     | NULL    |                |
    | prefix      | varchar(255) | NO   |     | NULL    |                |
    | suffix      | varchar(255) | NO   |     | NULL    |                |
    | multiplier  | int(11)      | NO   |     | NULL    |                |
    +-------------+--------------+------+-----+---------+----------------+
    */

    // Defines
    private long groupId;
    private String playerName;
    private int rank;
    private String tag;
    private String prefix;
    private String suffix;
    private int multiplier;

    //Empty constructor because we fill it when needed
    public GroupsBean()
    {
        super();
    }

    // Constructor
    public GroupsBean(long groupId, String playerName, int rank, String tag, String prefix, String suffix, int multiplier)
    {
        this.groupId = groupId;
        this.playerName = playerName;
        this.rank = rank;
        this.tag = tag;
        this.prefix = prefix;
        this.suffix = suffix;
        this.multiplier = multiplier;
    }

    // Getters
    public long getGroupId() { return this.groupId; }
    public String getPlayerName() { return this.playerName; }
    public int getRank() { return this.rank; }
    public String getTag() { return this.tag; }
    public String getPrefix() { return this.prefix; }
    public String getSuffix() { return this.suffix; }
    public int getMultiplier() { return this.multiplier; }

    // Setters
    public void setName(String playerName) { this.playerName = playerName; }
    public void setRank(int rank) { this.rank = rank; }
    public void setTag(String tag) { this.tag = tag; }
    public void setPrefix(String prefix) { this.prefix = prefix; }
    public void setSuffix(String suffix) { this.suffix = suffix; }
    public void setMultiplier(int multiplier) { this.multiplier = multiplier; }

}
