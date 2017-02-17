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

package net.samagames.persistanceapi.beans.events;

import java.beans.ConstructorProperties;
import java.sql.Timestamp;
import java.util.UUID;

public class EventBean
{
    /* Database Structure

    Table : events
    +-------------------------+--------------+------+-----+---------------------+----------------+
    | Field                   | Type         | Null | Key | Default             | Extra          |
    +-------------------------+--------------+------+-----+---------------------+----------------+
    | event_id                | bigint(20)   | NO   | PRI | NULL                | auto_increment |
    | event_organizer         | binary(16)   | NO   |     | Non définie         |                |
    | event_template          | varchar(255) | NO   |     | Non définie         |                |
    | reward_coins            | int(11)      | NO   |     | Non définie         |                |
    | reward_pearls           | int(11)      | NO   |     | Non définie         |                |
    | event_date              | timestamp    | NO   |     | 0000-00-00 00:00:00 |                |
    +-------------------------+--------------+------+-----+---------------------+----------------+
    */

    // Defines
    private long eventId;
    private UUID eventOrganizer;
    private String eventTemplate;
    private int rewardCoins;
    private int rewardPearls;
    private Timestamp eventDate;

    // Constructor
    @ConstructorProperties({"eventId", "eventOrganizer", "eventTemplate", "rewardCoins", "rewardPearls", "eventDate"})
    public EventBean(long eventId, UUID eventOrganizer, String eventTemplate, int rewardCoins, int rewardPearls, Timestamp eventDate)
    {
        this.eventId = eventId;
        this.eventOrganizer = eventOrganizer;
        this.eventTemplate = eventTemplate;
        this.rewardCoins = rewardCoins;
        this.rewardPearls = rewardPearls;
        this.eventDate = eventDate;
    }

    // Getters
    public long getEventId() { return this.eventId; }
    public UUID getEventOrganizer() { return this.eventOrganizer; }
    public String getEventTemplate() { return this.eventTemplate; }
    public int getRewardCoins() { return this.rewardCoins; }
    public int getRewardPearls() { return this.rewardPearls; }
    public Timestamp getEventDate() { return this.eventDate; }

    // Setters
    public void setEventOrganizer(UUID eventOrganizer) { this.eventOrganizer = eventOrganizer; }
    public void setEventTemplate(String eventTemplate) { this.eventTemplate = eventTemplate; }
    public void setRewardCoins(int rewardCoins) { this.rewardCoins = rewardCoins; }
    public void setRewardPearls(int rewardPearls) { this.rewardPearls = rewardPearls; }
    public void setEventDate(Timestamp eventDate) { this.eventDate = eventDate; }
}
