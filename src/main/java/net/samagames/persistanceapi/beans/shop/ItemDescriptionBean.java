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
package net.samagames.persistanceapi.beans.shop;

public class ItemDescriptionBean
{
    /* Database structure

    Table : item_description
    +-------------------+--------------+------+-----+---------+-------+
    | Field             | Type         | Null | Key | Default | Extra |
    +-------------------+--------------+------+-----+---------+-------+
    | item_id           | int(11)      | NO   | PRI | NULL    |       |
    | item_name         | tinytext     | YES  |     | NULL    |       |
    | item_desc         | text         | YES  |     | NULL    |       |
    | price_coins       | int(11)      | YES  |     | NULL    |       |
    | price_stars       | int(11)      | YES  |     | NULL    |       |
    | game_category     | tinyint(4)   | YES  |     | NULL    |       |
    | item_minecraft_id | varchar(255) | YES  |     | NULL    |       |
    +-------------------+--------------+------+-----+---------+-------+
    */

    // Defines
    private int itemId;
    private String itemName;
    private String itemDesc;
    private int priceCoins;
    private int priceStars;
    private int gameCategory;
    private String itemMinecraftId;

    // Constructor
    public ItemDescriptionBean(String itemName, String itemDesc, int priceCoins, int priceStars, int gameCategory, String itemMinecraftId)
    {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.priceCoins = priceCoins;
        this.priceStars = priceStars;
        this.gameCategory = gameCategory;
        this.itemMinecraftId = itemMinecraftId;
    }

    // Getters
    public int getItemId() { return this.itemId; }
    public String getItemName() { return this.itemName; }
    public String getItemDesc() { return this.itemDesc; }
    public int getPriceCoins() { return priceCoins; }
    public int getPriceStars() { return priceStars; }
    public int getGameCategory() { return gameCategory; }
    public String getItemMinecraftId() { return itemMinecraftId; }

    // Setters
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setItemDesc(String itemDesc) { this.itemDesc = itemDesc; }
    public void setPriceCoins(int priceCoins) { this.priceCoins = priceCoins; }
    public void setPriceStars(int priceStars) { this.priceStars = priceStars; }
    public void setGameCategory(int gameCategory) { this.gameCategory = gameCategory; }
    public void setItemMinecraftId(String itemMinecraftId) { this.itemMinecraftId = itemMinecraftId; }
}
