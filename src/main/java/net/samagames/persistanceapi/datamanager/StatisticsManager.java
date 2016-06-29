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

import net.samagames.persistanceapi.beans.players.PlayerBean;
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
    public PlayerStatisticsBean getAllPlayerStatistics(PlayerBean player, DataSource dataSource) throws Exception
    {
        // Declared bean
        DimensionStatisticsBean dimensionStats;
        HeroBattleStatisticsBean heroBattleStats;
        JukeBoxStatisticsBean jukeBoxStats;
        QuakeStatisticsBean quakeStats;
        UHCRunStatisticsBean uhcRunStatcs;
        UppervoidStatisticsBean upperVoidStats;

        // Get the different statistics bean
        try
        {
            dimensionStats = this.dimensionStatsManager.getDimensionStatistics(player, dataSource);
            heroBattleStats = this.heroBattleStatsManager.getHeroBattleStatistics(player, dataSource);
            jukeBoxStats = this.jukeBoxStatsManager.getJukeBoxStatistics(player, dataSource);
            quakeStats = this.quakeStatsManager.getQuakeStatistics(player, dataSource);
            uhcRunStatcs = this.uhcRunStatsManager.getUHCRunStatistics(player, dataSource);
            upperVoidStats = this.upperVoidStatsManager.getUppervoidStatistics(player, dataSource);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }

        // Create the aggregation of different statistics bean
        PlayerStatisticsBean playerStatisticsBean = new PlayerStatisticsBean(dimensionStats, heroBattleStats, jukeBoxStats, quakeStats, uhcRunStatcs, upperVoidStats);
        return playerStatisticsBean;
    }

    // Update all player statistics
    public void updateAllPlayerStatistics(PlayerBean player, PlayerStatisticsBean datas, DataSource dataSource) throws Exception
    {
        // Update the different statistics bean
        try
        {
            this.dimensionStatsManager.updateDimensionStatistics(player, datas.getDimmensionStats(),dataSource);
            this.heroBattleStatsManager.updateHeroBattleStatistics(player, datas.getHeroBatleStats(), dataSource);
            this.jukeBoxStatsManager.updateJukeBoxStatistics(player, datas.getJukeBoxStats(), dataSource);
            this.quakeStatsManager.updateQuakeStatistics(player, datas.getQuakeStats(), dataSource);
            this.uhcRunStatsManager.updateUHCRunStatistics(player, datas.getUhcRunStats(), dataSource);
            this.upperVoidStatsManager.updateUppervoidStatistics(player, datas.getUppervoidStats(), dataSource);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }

    }

}
