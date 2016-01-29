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

import com.samagames.persistanceapi.beans.aggregationbean.*;

public class PlayerStatisticsBean
{
    // Defines aggregation of statistics
    public DimensionStatisticsBean dimmensionStats;
    public HeroBattleStatisticsBean heroBatleStats;
    public JukeBoxStatisticsBean jukeBoxStats;
    public QuakeStatisticsBean quakeStats;
    public UHCRunStatisticsBean uhcRunStats;
    public UppervoidStatistics uppervoidStats;

    // Constructor
    public PlayerStatisticsBean(DimensionStatisticsBean dimmensionStats, HeroBattleStatisticsBean heroBatleStats, JukeBoxStatisticsBean jukeBoxStats, QuakeStatisticsBean quakeStats, UHCRunStatisticsBean uhcRunStats, UppervoidStatistics uppervoidStatistics)
    {
        this.dimmensionStats = dimmensionStats;
        this.heroBatleStats = heroBatleStats;
        this.jukeBoxStats = jukeBoxStats;
        this.quakeStats = quakeStats;
        this.uhcRunStats = uhcRunStats;
        this.uppervoidStats = uppervoidStatistics;
    }
}
