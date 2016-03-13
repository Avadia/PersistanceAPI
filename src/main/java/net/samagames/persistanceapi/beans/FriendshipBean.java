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

import java.sql.Timestamp;
import java.util.UUID;

public class FriendshipBean
{
    /*

    Table :friendship
    +------------------+--------------+------+-----+---------+----------------+
    | Field            | Type         | Null | Key | Default | Extra          |
    +------------------+--------------+------+-----+---------+----------------+
    | friendship_id    | bigint(20)   | NO   | PRI | NULL    | auto_increment |
    | requester_uuid   | binary(16)   | NO   | MUL | NULL    |                |
    | requester_name   | varchar(255) | NO   |     | NULL    |                |
    | recipient_uuid   | binary(16)   | NO   | MUL | NULL    |                |
    | recipient_name   | varchar(255) | NO   |     | NULL    |                |
    | demand_date      | timestamp    | YES  |     | NULL    |                |
    | acceptation_date | timestamp    | YES  |     | NULL    |                |
    | active_status    | tinyint(1)   | NO   | MUL | NULL    |                |
    +------------------+--------------+------+-----+---------+----------------+
     */

    // Define attributes
    private long friendshipId;
    private UUID requesterUUID;
    private String requesterName;
    private UUID recipientUUID;
    private String recipientName;
    private Timestamp demandDate;
    private Timestamp acceptationDate;
    private boolean activeStatus;

    // Constructor
    public FriendshipBean(long friendshipId, UUID requesterUUID, String requesterName, UUID recipientUUID, String recipientName, Timestamp demandDate, Timestamp acceptationDate, boolean activeStatus)
    {
        this.friendshipId = friendshipId;
        this.requesterUUID = requesterUUID;
        this.requesterName = requesterName;
        this.recipientUUID = recipientUUID;
        this.recipientName = recipientName;
        this.demandDate = demandDate;
        this.acceptationDate = acceptationDate;
        this.activeStatus = activeStatus;
    }

    // Constructor without id
    public FriendshipBean(UUID requesterUUID, String requesterName, UUID recipientUUID, String recipientName, Timestamp demandDate, Timestamp acceptationDate, boolean activeStatus)
    {
        this.requesterUUID = requesterUUID;
        this.requesterName = requesterName;
        this.recipientUUID = recipientUUID;
        this.recipientName = recipientName;
        this.demandDate = demandDate;
        this.acceptationDate = acceptationDate;
        this.activeStatus = activeStatus;
    }

    // Getters
    public long getFriendshipId() { return this.friendshipId; }
    public UUID getRequesterUUID() { return this.requesterUUID; }
    public String getRequesterName() { return this.requesterName; }
    public UUID getRecipientUUID() { return this.recipientUUID; }
    public String getRecipientName() { return this.recipientName; }
    public Timestamp getDemandDate() { return this.demandDate; }
    public Timestamp getAcceptationDate() { return this.acceptationDate; }
    public boolean isActiveStatus() { return this.activeStatus; }

    // Setters
    public void setRequesterUUID(UUID requesterUUID) { this.requesterUUID = requesterUUID; }
    public void setRequesterName(String requesterName) { this.requesterName = requesterName; }
    public void setRecipientUUID(UUID recipientUUID) { this.recipientUUID = recipientUUID; }
    public void setRecipientName(String recipientName) { this.recipientName = recipientName; }
    public void setDemandDate(Timestamp demandDate) { this.demandDate = demandDate; }
    public void setAcceptationDate(Timestamp acceptationDate) { this.acceptationDate = acceptationDate; }
    public void setActiveStatus(boolean activeStatus) { this.activeStatus = activeStatus; }
}
