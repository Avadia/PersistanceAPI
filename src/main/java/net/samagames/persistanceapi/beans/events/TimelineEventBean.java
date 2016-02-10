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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class TimelineEventBean
{
    // Defines mini games type
    public final static int DIMENSIONS = 1;
    public final static int JUKE_BOX = 3;
    public final static int QUAKE = 4;
    public final static int UHC_RUN = 5;
    public final static int UPPERVOID = 6;

    // Defines
    UUID timelineID;
    int gameType;
    long startTime;
    long dammageStartTime;
    long prepartionEndTime;
    long pvpActivationTime;
    long endTime;
    int teamCount;
    int teamRatio;
    List eventsList;

    // Super constructor
    public TimelineEventBean(int gameType)
    {
        this.timelineID = UUID.randomUUID();
        this.eventsList = Collections.synchronizedList(new ArrayList());
        this.startTime = System.currentTimeMillis();
        this.gameType = gameType;
    }

    // Add an event to the timeline
    public void addEvent(EventBean event)
    {
        // Add the event
        this.eventsList.add(event);
    }

    // Add the dammage start time
    public void dammageStartTime()
    {
        long deltaTime = System.currentTimeMillis() - this.startTime;
        this.dammageStartTime = deltaTime;
    }

    // Add preparation end time
    public void preparationEndTime()
    {
        long deltaTime = System.currentTimeMillis() - this.startTime;
        this.prepartionEndTime = deltaTime;
    }

    // Add pvp activation time
    public void pvpActivationTime()
    {
        long deltaTime = System.currentTimeMillis() - this.startTime;
        this.pvpActivationTime = deltaTime;
    }


    // Close the timeline
    public void closeTimeline()
    {
        long deltaTime = System.currentTimeMillis() - this.startTime;
        this.endTime = deltaTime;
    }

}
