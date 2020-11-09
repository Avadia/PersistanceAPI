package net.samagames.persistanceapi.beans.shop;

import java.beans.ConstructorProperties;

/*
 * This file is part of PersistanceAPI.
 *
 * PersistanceAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PersistanceAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PersistanceAPI.  If not, see <http://www.gnu.org/licenses/>.
 */
public class ItemDescriptionBean {
    /* Database structure

    Table : item_description
    +-------------------+--------------+------+-----+--------------+-------+
    | Field             | Type         | Null | Key | Default      | Extra |
    +-------------------+--------------+------+-----+--------------+-------+
    | item_id           | int(11)      | NO   | PRI | NULL         |       |
    | item_name         | varchar(45)  | NO   |     | Non définie  |       |
    | item_desc         | varchar(255) | NO   |     | Non définie  |       |
    | price_coins       | int(11)      | NO   |     | 42424242     |       |
    | price_stars       | int(11)      | NO   |     | 42424242     |       |
    | game_category     | tinyint(4)   | NO   |     | NULL         |       |
    | item_minecraft_id | varchar(45)  | NO   |     | NULL         |       |
    | item_rarity       | varchar(45)  | YES  |     | NULL         |       |
    | rank_accessibility| varchar(45)  | YES  |     | NULL         |       |
    +-------------------+--------------+------+-----+--------------+-------+
    */

    // Defines
    private int itemId;
    private String itemName;
    private String itemDesc;
    private int priceCoins;
    private int priceStars;
    private int gameCategory;
    private String itemMinecraftId;
    private String itemRarity;
    private String rankAccessibility;

    // Constructor
    @ConstructorProperties({"itemId", "itemName", "itemDesc", "priceCoins", "priceStars", "gameCategory", "itemMinecraftId", "itemRarity", "rankAccessibility"})
    public ItemDescriptionBean(int itemId, String itemName, String itemDesc, int priceCoins, int priceStars, int gameCategory, String itemMinecraftId, String itemRarity, String rankAccessibility) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.priceCoins = priceCoins;
        this.priceStars = priceStars;
        this.gameCategory = gameCategory;
        this.itemMinecraftId = itemMinecraftId;
        this.itemRarity = itemRarity;
        this.rankAccessibility = rankAccessibility;
    }

    // Getters
    public int getItemId() {
        return this.itemId;
    }

    // Setters
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return this.itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public int getPriceCoins() {
        return this.priceCoins;
    }

    public void setPriceCoins(int priceCoins) {
        this.priceCoins = priceCoins;
    }

    public int getPriceStars() {
        return this.priceStars;
    }

    public void setPriceStars(int priceStars) {
        this.priceStars = priceStars;
    }

    public int getGameCategory() {
        return this.gameCategory;
    }

    public void setGameCategory(int gameCategory) {
        this.gameCategory = gameCategory;
    }

    public String getItemMinecraftId() {
        return this.itemMinecraftId;
    }

    public void setItemMinecraftId(String itemMinecraftId) {
        this.itemMinecraftId = itemMinecraftId;
    }

    public String getItemRarity() {
        return this.itemRarity;
    }

    public void setItemRarity(String itemRarity) {
        this.itemRarity = itemRarity;
    }

    public String getRankAccessibility() {
        return this.rankAccessibility;
    }

    public void setRankAccessibility(String rankAccessibility) {
        this.rankAccessibility = rankAccessibility;
    }
}
