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

package com.samagames.persistanceapi.beans.statistics;

import com.samagames.persistanceapi.beans.statistics.*;

public class PlayerStatisticsBean
{
    // Defines aggregation of statistics
    private DimensionStatisticsBean dimmensionStats;
    private HeroBattleStatisticsBean heroBatleStats;
    private JukeBoxStatisticsBean jukeBoxStats;
    private QuakeStatisticsBean quakeStats;
    private UHCRunStatisticsBean uhcRunStats;
    private UppervoidStatistics uppervoidStats;

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

    // Getters
    public DimensionStatisticsBean getDimmensionStats() {
        return dimmensionStats;
    }
    public HeroBattleStatisticsBean getHeroBatleStats() {
        return heroBatleStats;
    }
    public JukeBoxStatisticsBean getJukeBoxStats() {
        return jukeBoxStats;
    }
    public QuakeStatisticsBean getQuakeStats() {
        return quakeStats;
    }
    public UHCRunStatisticsBean getUhcRunStats() {
        return uhcRunStats;
    }
    public UppervoidStatistics getUppervoidStats() {
        return uppervoidStats;
    }

    // Setters
    public void setDimmensionStats(DimensionStatisticsBean dimmensionStats) {
        this.dimmensionStats = dimmensionStats;
    }
    public void setHeroBatleStats(HeroBattleStatisticsBean heroBatleStats) {
        this.heroBatleStats = heroBatleStats;
    }
    public void setJukeBoxStats(JukeBoxStatisticsBean jukeBoxStats) {
        this.jukeBoxStats = jukeBoxStats;
    }
    public void setQuakeStats(QuakeStatisticsBean quakeStats) {
        this.quakeStats = quakeStats;
    }
    public void setUhcRunStats(UHCRunStatisticsBean uhcRunStats) {
        this.uhcRunStats = uhcRunStats;
    }
    public void setUppervoidStats(UppervoidStatistics uppervoidStats) {
        this.uppervoidStats = uppervoidStats;
    }

}
