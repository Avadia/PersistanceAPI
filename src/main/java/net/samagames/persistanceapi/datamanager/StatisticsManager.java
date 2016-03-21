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

package net.samagames.persistanceapi.datamanager;

import net.samagames.persistanceapi.beans.PlayerBean;
import net.samagames.persistanceapi.beans.statistics.PlayerStatisticsBean;
import net.samagames.persistanceapi.beans.statistics.*;
import net.samagames.persistanceapi.datamanager.aggregationmanager.statistics.*;

import javax.sql.DataSource;

public class StatisticsManager
{
    // Defines
    public DimensionStatisticsManager dimensionStatsManager;
    public HeroBattleStatisticsManager heroBattleStatsManager;
    public JukeBoxStatisticsManager jukeBoxStatsManager;
    public QuakeStatisticsManager quakeStatsManager;
    public UHCRunStatisticsManager uhcRunStatsManager;
    public UpperVoidStatisticsManager upperVoidStatsManager;

    // Constructor
    public StatisticsManager()
    {
        this.dimensionStatsManager = new DimensionStatisticsManager();
        this.heroBattleStatsManager = new HeroBattleStatisticsManager();
        this.jukeBoxStatsManager = new JukeBoxStatisticsManager();
        this.quakeStatsManager = new QuakeStatisticsManager();
        this.uhcRunStatsManager = new UHCRunStatisticsManager();
        this.upperVoidStatsManager = new UpperVoidStatisticsManager();
    }

    // Get all player statistics
    public PlayerStatisticsBean getAllPlayerStatistics(PlayerBean player, DataSource dataSource)
    {
        // Get the different statistics bean
        DimensionStatisticsBean dimensionStats = this.dimensionStatsManager.getDimensionStatistics(player, dataSource);
        HeroBattleStatisticsBean heroBattleStats = this.heroBattleStatsManager.getHeroBattleStatistics(player, dataSource);
        JukeBoxStatisticsBean jukeBoxStats = this.jukeBoxStatsManager.getJukeBoxStatistics(player, dataSource);
        QuakeStatisticsBean quakeStats = this.quakeStatsManager.getQuakeStatistics(player, dataSource);
        UHCRunStatisticsBean uhcRunStatcs = this.uhcRunStatsManager.getUHCRunStatistics(player, dataSource);
        UppervoidStatisticsBean upperVoidStats = this.upperVoidStatsManager.getUpperVoidStatistics(player, dataSource);

        // Create the aggregation of different statistics bean
        PlayerStatisticsBean playerStatisticsBean = new PlayerStatisticsBean(dimensionStats, heroBattleStats, jukeBoxStats, quakeStats, uhcRunStatcs, upperVoidStats);
        return playerStatisticsBean;
    }

    // Update all player statistics
    public void updateAllPlayerStatistics(PlayerBean player, PlayerStatisticsBean datas, DataSource dataSource)
    {
        // Update the different statistics bean
        this.dimensionStatsManager.updateDimensionStatistics(player, datas.getDimmensionStats(),dataSource);
        this.heroBattleStatsManager.updateHeroBattleStatistics(player, datas.getHeroBatleStats(), dataSource);
        this.jukeBoxStatsManager.updateJukeBoxStatistics(player, datas.getJukeBoxStats(), dataSource);
        this.quakeStatsManager.updateQuakeStatistics(player, datas.getQuakeStats(), dataSource);
        this.uhcRunStatsManager.updateUHCRunStatistics(player, datas.getUhcRunStats(), dataSource);
        this.upperVoidStatsManager.updateUpperVoidStatistics(player, datas.getUppervoidStats(), dataSource);
    }

}
