package net.samagames.persistanceapi.beans.events;

import java.beans.ConstructorProperties;
import java.util.UUID;

/**
 *                )\._.,--....,'``.
 * .b--.        /;   _.. \   _\  (`._ ,.
 * `=,-,-'~~~   `----(,_..'--(,_..'`-.;.'
 *
 * Created by Jérémy L. (BlueSlime) on 17/02/2017
 */
public class EventWinnerBean
{
    /* Database Structure

    Table : event_winners
    +-------------------------+--------------+------+-----+---------------------+----------------+
    | Field                   | Type         | Null | Key | Default             | Extra          |
    +-------------------------+--------------+------+-----+---------------------+----------------+
    | win_id                  | bigint(20)   | NO   | PRI | NULL                | auto_increment |
    | event_id                | bigint(20)   | NO   |     | NULL                |                |
    | event_winner            | binary(16)   | NO   |     | Non définie         |                |
    +-------------------------+--------------+------+-----+---------------------+----------------+
    */

    // Defines
    private long winId;
    private long eventId;
    private UUID eventWinner;

    // Constructor
    @ConstructorProperties({"winId", "eventId", "eventWinner"})
    public EventWinnerBean(long winId, long eventId, UUID eventWinner)
    {
        this.winId = winId;
        this.eventId = eventId;
        this.eventWinner = eventWinner;
    }

    // Getters
    public long getWinId() { return this.winId; }
    public long getEventId() { return this.eventId; }
    public UUID getEventWinner() { return this.eventWinner; }

    // Setters
    public void setEventId(long eventId) { this.eventId = eventId; }
    public void setEventWinner(UUID eventWinner) { this.eventWinner = eventWinner; }
}
