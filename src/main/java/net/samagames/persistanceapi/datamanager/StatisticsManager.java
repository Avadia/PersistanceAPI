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
    public UHCStatisticsManager uhcStatsManager;
    public UHCRunStatisticsManager uhcRunStatsManager;
    public DoubleRunnerStatisticsManager doubleRunnerStatsManager;
    public UHCRandomStatisticsManager uhcRandomStatsManager;
    public RandomRunStatisticsManager randomRunStatsManager;
    public UltraFlagKeeperStatisticsManager ultraFlagKeeperStatsManager;
    public UpperVoidStatisticsManager upperVoidStatsManager;

    // Constructor
    public StatisticsManager()
    {
        this.dimensionStatsManager = new DimensionStatisticsManager();
        this.heroBattleStatsManager = new HeroBattleStatisticsManager();
        this.jukeBoxStatsManager = new JukeBoxStatisticsManager();
        this.quakeStatsManager = new QuakeStatisticsManager();
        this.uhcStatsManager = new UHCStatisticsManager();
        this.uhcRunStatsManager = new UHCRunStatisticsManager();
        this.doubleRunnerStatsManager = new DoubleRunnerStatisticsManager();
        this.uhcRandomStatsManager = new UHCRandomStatisticsManager();
        this.randomRunStatsManager = new RandomRunStatisticsManager();
        this.ultraFlagKeeperStatsManager = new UltraFlagKeeperStatisticsManager();
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
        UHCStatisticsBean uhcStats;
        UHCRunStatisticsBean uhcRunStats;
        DoubleRunnerStatisticsBean doubleRunnerStats;
        UHCRandomStatisticsBean uhcRandomStats;
        RandomRunStatisticsBean randomRunStats;
        UltraFlagKeeperStatisticsBean ultraFlagKeeperStats;
        UppervoidStatisticsBean upperVoidStats;

        // Get the different statistics bean
        try
        {
            dimensionStats = this.dimensionStatsManager.getDimensionStatistics(player, dataSource);
            heroBattleStats = this.heroBattleStatsManager.getHeroBattleStatistics(player, dataSource);
            jukeBoxStats = this.jukeBoxStatsManager.getJukeBoxStatistics(player, dataSource);
            quakeStats = this.quakeStatsManager.getQuakeStatistics(player, dataSource);
            uhcStats = this.uhcStatsManager.getUHCStatistics(player, dataSource);
            uhcRunStats = this.uhcRunStatsManager.getUHCRunStatistics(player, dataSource);
            doubleRunnerStats = this.doubleRunnerStatsManager.getDoubleRunnerStatistics(player, dataSource);
            uhcRandomStats = this.uhcRandomStatsManager.getUHCRandomStatistics(player, dataSource);
            randomRunStats = this.randomRunStatsManager.getRandomRunStatistics(player, dataSource);
            ultraFlagKeeperStats = this.ultraFlagKeeperStatsManager.getUltraFlagKeeperStatistics(player, dataSource);
            upperVoidStats = this.upperVoidStatsManager.getUppervoidStatistics(player, dataSource);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }

        // Create the aggregation of different statistics bean
        PlayerStatisticsBean playerStatisticsBean = new PlayerStatisticsBean(dimensionStats, heroBattleStats, jukeBoxStats, quakeStats, uhcStats, uhcRunStats, doubleRunnerStats, uhcRandomStats, randomRunStats, ultraFlagKeeperStats, upperVoidStats);
        return playerStatisticsBean;
    }

    // Update all player statistics
    public void updateAllPlayerStatistics(PlayerBean player, PlayerStatisticsBean datas, DataSource dataSource) throws Exception
    {
        // Update the different statistics bean
        try
        {
            this.dimensionStatsManager.updateDimensionStatistics(player, datas.getDimensionStats(),dataSource);
            this.heroBattleStatsManager.updateHeroBattleStatistics(player, datas.getHeroBattleStats(), dataSource);
            this.jukeBoxStatsManager.updateJukeBoxStatistics(player, datas.getJukeBoxStats(), dataSource);
            this.quakeStatsManager.updateQuakeStatistics(player, datas.getQuakeStats(), dataSource);
            this.uhcStatsManager.updateUHCStatistics(player, datas.getUHCStats(), dataSource);
            this.uhcRunStatsManager.updateUHCRunStatistics(player, datas.getUHCRunStats(), dataSource);
            this.doubleRunnerStatsManager.updateDoubleRunnerStatistics(player, datas.getDoubleRunnerStats(), dataSource);
            this.uhcRandomStatsManager.updateUHCRandomStatistics(player, datas.getUHCRandomStats(), dataSource);
            this.randomRunStatsManager.updateRandomRunStatistics(player, datas.getRandomRunStats(), dataSource);
            this.ultraFlagKeeperStatsManager.updateUltraFlagKeeperStatistics(player, datas.getUltraFlagKeeperStats(), dataSource);
            this.upperVoidStatsManager.updateUppervoidStatistics(player, datas.getUppervoidStats(), dataSource);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }

    }

}
