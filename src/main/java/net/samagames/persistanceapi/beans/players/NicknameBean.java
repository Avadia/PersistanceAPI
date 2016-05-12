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

package net.samagames.persistanceapi.beans.players;

public class NicknameBean
{
    /* Database Structure

    Table : Nickname
    +-------------+-------------+------+-----+---------+----------------+
    | Field       | Type        | Null | Key | Default | Extra          |
    +-------------+-------------+------+-----+---------+----------------+
    | nick_id     | int(11)     | NO   | PRI | NULL    | auto_increment |
    | nickname    | varchar(16) | NO   |     | NULL    |                |
    | blacklisted | bit(1)      | NO   |     | NULL    |                |
    | used        | bit(1)      | NO   |     | NULL    |                |
    +-------------+-------------+------+-----+---------+----------------+
    */

    // Defines
    private long nickId;
    private String nickname;
    private boolean blackListed;
    private boolean used;

    //Empty constructor because we fill it when needed
    public NicknameBean()
    {
        super();
    }

    // Constructor
    public NicknameBean(long nickId, String nickname, boolean blackListed, boolean used)
    {
        this.nickId = nickId;
        this.nickname = nickname;
        this.blackListed = blackListed;
        this.used = used;
    }

    // Getters
    public long getNickId() { return this.nickId; }
    public String getNickname() { return this.nickname; }
    public boolean isBlackListed() { return this.blackListed; }
    public boolean isUsed() { return this.used; }

    // Setters
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setBlackListed(boolean blackListed) { this.blackListed = blackListed; }
    public void setUsed(boolean used) { this.used = used; }
}
