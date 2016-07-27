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
import java.sql.Timestamp;
import java.util.UUID;

public class AchievementProgressBean
{
    /* Database structure

    Table : achievements_progress
    +----------------+------------+------+-----+---------------------+----------------+
    | Field          | Type       | Null | Key | Default             | Extra          |
    +----------------+------------+------+-----+---------------------+----------------+
    | progress_id    | bigint(20) | NO   | PRI | NULL                | auto_increment |
    | achievement_id | int(11)    | YES  | MUL | NULL                |                |
    | progress       | int(11)    | YES  |     | NULL                |                |
    | start_date     | timestamp  | NO   |     | 0000-00-00 00:00:00 |                |
    | unlock_date    | timestamp  | YES  |     | NULL                |                |
    | uuid_player    | binary(16) | NO   |     | NULL                |                |
    +----------------+------------+------+-----+---------------------+----------------+
    */

    // Defines
    private long progressId;
    private int achievementId;
    private int progress;
    private Timestamp startDate;
    private Timestamp unlockDate;
    private UUID uuidPlayer;

    // Constructor
    @ConstructorProperties({"progressId", "achievementId", "progress", "startDate", "unlockDate", "uuidPlayer"})
    public AchievementProgressBean(long progressId, int achievementId, int progress, Timestamp startDate, Timestamp unlockDate, UUID uuidPlayer)
    {
        this.progressId = progressId;
        this.achievementId = achievementId;
        this.progress = progress;
        this.startDate = startDate;
        this.unlockDate = unlockDate;
        this.uuidPlayer = uuidPlayer;
    }

    // Getters
    public long getProgressId() { return this.progressId; }
    public int getAchievementId() { return this.achievementId; }
    public int getProgress() { return this.progress; }
    public Timestamp getStartDate() { return this.startDate; }
    public Timestamp getUnlockDate() { return this.unlockDate; }
    public UUID getUuidPlayer() { return this.uuidPlayer; }

    // Setters

    public void setProgressId(long progressId) {
        this.progressId = progressId;
    }
    public void setAchievementId(int achievementId) { this.achievementId = achievementId; }
    public void setProgress(int progress) { this.progress = progress; }
    public void setStartDate(Timestamp startDate) { this.startDate = startDate; }
    public void setUnlockDate(Timestamp unlockDate) { this.unlockDate = unlockDate; }
    public void setUuidPlayer(UUID uuidPlayer) { this.uuidPlayer = uuidPlayer; }
}
