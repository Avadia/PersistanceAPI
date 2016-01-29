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
    public HeroBatleStatisticsBean heroBatleStats;
    public JukeBoxStatisticsBean jukeBoxStats;
    public QuakeStatisticsBean quakeStats;
    public UHCRunStatisticsBean uhcRunStats;
    public UppervoidStatistics uppervoidStats;
}
