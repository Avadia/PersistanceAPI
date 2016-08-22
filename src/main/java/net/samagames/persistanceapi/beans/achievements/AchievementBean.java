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

public class AchievementBean
{
    /* Database Structure

    Table : achievements
    +-------------------------+--------------+------+-----+--------------+----------------+
    | Field                   | Type         | Null | Key | Default      | Extra          |
    +-------------------------+--------------+------+-----+--------------+----------------+
    | achievement_id          | int(11)      | NO   | PRI | NULL         | auto_increment |
    | achievement_name        | varchar(45)  | NO   |     | Non définie  |                |
    | achievement_description | varchar(255) | NO   |     | Non définie  |                |
    | progress_target         | int(11)      | NO   |     | Non définie  |                |
    | category_id             | int(11)      | NO   |     | Non définie  |                |
    +-------------------------+--------------+------+-----+--------------+----------------+
    */

    // Defines
    private int achievementId;
    private String achievementName;
    private String achievementDescription;
    private int progressTarget;
    private int categoryId;

    // Constructor
    @ConstructorProperties({"achievementId", "achievementName", "achievementDescription", "progressTarget", "categoryId"})
    public AchievementBean(int achievementId, String achievementName, String achievementDescription, int progressTarget, int categoryId)
    {
        this.achievementId = achievementId;
        this.achievementName = achievementName;
        this.achievementDescription = achievementDescription;
        this.progressTarget = progressTarget;
        this.categoryId = categoryId;
    }

    // Getters
    public int getAchievementId() { return this.achievementId; }
    public String getAchievementName() { return this.achievementName; }
    public String getAchievementDescription() { return this.achievementDescription; }
    public int getProgressTarget() { return this.progressTarget; }
    public int getCategoryId() { return this.categoryId; }

    // Setters
    public void setAchievementName(String achievementName) { this.achievementName = achievementName; }
    public void setAchievementDescription(String achievementDescription) { this.achievementDescription = achievementDescription; }
    public void setProgressTarget(int progressTarget) { this.progressTarget = progressTarget; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
}
