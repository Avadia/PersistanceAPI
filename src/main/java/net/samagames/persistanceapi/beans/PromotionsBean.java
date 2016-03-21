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

import java.sql.Time;
import java.sql.Timestamp;

public class PromotionsBean
{
    /* Database structure

    Table : promotions
    +----------------+--------------+------+-----+---------+----------------+
    | Field          | Type         | Null | Key | Default | Extra          |
    +----------------+--------------+------+-----+---------+----------------+
    | promotion_id   | bigint(20)   | NO   | PRI | NULL    | auto_increment |
    | type_promotion | int(11)      | NO   |     | NULL    |                |
    | game           | int(11)      | NO   |     | NULL    |                |
    | multiplier     | int(11)      | NO   |     | NULL    |                |
    | message        | varchar(255) | NO   |     | NULL    |                |
    | start_date     | timestamp    | YES  |     | NULL    |                |
    | end_date       | timestamp    | YES  |     | NULL    |                |
    +----------------+--------------+------+-----+---------+----------------+
    */

    // Defines promotions types // TODO make enum
    public static int GLOBAL = 0;
    public static int COINS = 1;
    public static int STARS = 2;

    // Defines games types // TODO make enum
    //public static int GLOBAL = 0; // TODO add in enum
    public static int HEROBATTLE = 1;
    public static int JUKEBOX = 2;
    public static int QUAKE = 3;
    public static int UHCRUN = 4;
    public static int UPPERVOID = 5;
    public static int DIMENSIONS = 6;

    // Defines
    private long promitionId;
    private int typePromotion;
    private int game;
    private int multiplier;
    private String message;
    private Timestamp startDate;
    private Timestamp endDate;

    // Constructor
    public PromotionsBean(long promitionId, int typePromotion, int game, int multiplier, String message, Timestamp startDate, Timestamp endDate)
    {
        this.promitionId = promitionId;
        this.typePromotion = typePromotion;
        this.game = game;
        this.multiplier = multiplier;
        this.message = message;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Constructor without id
    public PromotionsBean(int typePromotion, int game, int multiplier, String message, Timestamp startDate, Timestamp endDate)
    {
        this.typePromotion = typePromotion;
        this.game = game;
        this.multiplier = multiplier;
        this.message = message;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters
    public long getPromotionId() { return this.promitionId; }
    public int getTypePromotion() { return this.typePromotion; }
    public int getGame() { return this.game; }
    public int getMultiplier() { return this.multiplier; }
    public String getMessage() { return this.message; }
    public Timestamp getStartDate() { return this.startDate; }
    public Timestamp getEndDate() { return this.endDate; }

    // Setters
    public void setPromotionId(long promitionId) { this.promitionId = promitionId; }
    public void setTypePromotion(int typePromotion) { this.typePromotion = typePromotion; }
    public void setGame(int game) { this.game = game; }
    public void setMultiplier(int multiplier) { this.multiplier = multiplier; }
    public void setMessage(String message) { this.message = message; }
    public void setStartDate(Timestamp startDate) { this.startDate = startDate; }
    public void setEndDate(Timestamp endDate) { this.endDate = endDate; }
}
