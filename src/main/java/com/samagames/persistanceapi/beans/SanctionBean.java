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

package com.samagames.persistanceapi.beans;

import java.sql.Timestamp;
import java.util.UUID;

public class SanctionBean
{
    /* Database Structure
    +-----------------+------------------+------+-----+---------------------+----------------+
    | Field           | Type             | Null | Key | Default             | Extra          |
    +-----------------+------------------+------+-----+---------------------+----------------+
    | player_uuid     | binary(16)       | NO   | PRI | NULL                |                |
    | type_id         | int(11)          | NO   |     | NULL                |                |
    | reason          | varchar(25       | NO   |     | NULL                |                |
    | punisher_uuid   | binary(16)       | NO   |     | NULL                |                |
    | expiration_time | timestamp        | NO   |     | 0000-00-00 00:00:00 |                |
    | is_deleted      | tinyint(1)       | NO   |     | NULL                |                |
    | creation_date   | timestamp        | NO   |     | 0000-00-00 00:00:00 |                |
    | update_date     | timestamp        | NO   |     | 0000-00-00 00:00:00 |                |
    +-----------------+------------------+------+-----+---------------------+----------------+
    */

    // Defines sanctions types
    public static int AVERTISSEMENT = 1;
    public static int BAN = 2;
    public static int KICK = 3;
    public static int MUTE = 4;
    public static int TEXT = 5;

    // Defines
    private UUID playerUuid;
    private int typeId;
    private String reason;
    private String punisherUuid;
    private Timestamp expirationTime;
    private boolean isDeleted;
    private Timestamp creationDate;
    private Timestamp updateDate;

    // Constructor
    public SanctionBean(UUID playerUuid, int typeId, String reason, String punisherUuid, Timestamp expirationTime, boolean isDeleted, Timestamp creationDate, Timestamp updateDate)
    {
        this.playerUuid = playerUuid;
        this.typeId = typeId;
        this.reason = reason;
        this.punisherUuid = punisherUuid;
        this.expirationTime = expirationTime;
        this.isDeleted = isDeleted;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    // Getters
    public UUID getPlayerUuid() {
        return this.playerUuid;
    }
    public int getTypeId() {
        return this.typeId;
    }
    public String getReason() {
        return this.reason;
    }
    public String getPunisherUuid() {
        return this.punisherUuid;
    }
    public Timestamp getExpirationTime() {
        return this.expirationTime;
    }
    public boolean isDeleted() {
        return this.isDeleted;
    }
    public Timestamp getCreationDate() {
        return this.creationDate;
    }
    public Timestamp getUpdateDate() {
        return this.updateDate;
    }

    // Setters
    public void setPlayerUuid(UUID playerUuid) {
        this.playerUuid = playerUuid;
    }
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public void setPunisherUuid(String punisherUuid) {
        this.punisherUuid = punisherUuid;
    }
    public void setExpirationTime(Timestamp expirationTime) {
        this.expirationTime = expirationTime;
    }
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
}
