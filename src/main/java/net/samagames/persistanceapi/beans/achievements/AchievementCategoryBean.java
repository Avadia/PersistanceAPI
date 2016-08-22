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
  By MisterSatch, July 2016
===============================================================
*/

package net.samagames.persistanceapi.beans.achievements;

import java.beans.ConstructorProperties;

public class AchievementCategoryBean
{
    /* Database Structure

    Table : achievements_categories
    +----------------------+--------------+------+-----+--------------+----------------+
    | Field                | Type         | Null | Key | Default      | Extra          |
    +----------------------+--------------+------+-----+--------------+----------------+
    | category_id          | int(11)      | NO   | PRI | NULL         | auto_increment |
    | category_name        | varchar(45)  | NO   |     | Non définie  |                |
    | category_description | varchar(255) | NO   |     | Non définie  |                |
    | item_minecraft_id    | varchar(45)  | NO   |     | NULL         |                |
    | parent_id            | int(11)      | NO   |     | Non définie  |                |
    +----------------------+--------------+------+-----+--------------+----------------+
    */

    // Defines
    private int categoryId;
    private String categoryName;
    private String categoryDescription;
    private String itemMinecraftId;
    private int parentId;

    // Constructor
    @ConstructorProperties({"categoryId", "categoryName", "categoryDescription", "itemMinecraftId", "parentId"})
    public AchievementCategoryBean(int categoryId, String categoryName, String categoryDescription, String itemMinecraftId, int parentId)
    {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.itemMinecraftId = itemMinecraftId;
        this.parentId = parentId;
    }

    // Getters
    public int getCategoryId() { return this.categoryId; }
    public String getCategoryName() { return this.categoryName; }
    public String getCategoryDescription() { return this.categoryDescription; }
    public String getItemMinecraftId() { return this.itemMinecraftId; }
    public int getParentId() { return this.parentId; }

    // Setters
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public void setCategoryDescription(String categoryDescription) { this.categoryDescription = categoryDescription; }
    public void setItemMinecraftId(String itemMinecraftId) { this.itemMinecraftId = itemMinecraftId; }
    public void setParentId(int parentId) { this.parentId = parentId; }
}
