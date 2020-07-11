package net.samagames.persistanceapi.datamanager;

import net.samagames.persistanceapi.beans.players.PlayerBean;
import net.samagames.persistanceapi.beans.statistics.*;
import net.samagames.persistanceapi.datamanager.aggregationmanager.statistics.*;
import net.samagames.persistanceapi.datamanager.database.DatabaseAccess;

/*
 * This file is part of PersistanceAPI.
 *
 * PersistanceAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PersistanceAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PersistanceAPI.  If not, see <http://www.gnu.org/licenses/>.
 */
public class StatisticsManager {
    // Defines
    public DimensionsStatisticsManager dimensionsStatsManager;
    public JukeBoxStatisticsManager jukeBoxStatsManager;
    public QuakeStatisticsManager quakeStatsManager;
    public UHCOriginalStatisticsManager uhcOriginalStatsManager;
    public UHCRunStatisticsManager uhcRunStatsManager;
    public DoubleRunnerStatisticsManager doubleRunnerStatsManager;
    public UHCRandomStatisticsManager uhcRandomStatsManager;
    public RandomRunStatisticsManager randomRunStatsManager;
    public UltraFlagKeeperStatisticsManager ultraFlagKeeperStatsManager;
    public UppervoidStatisticsManager uppervoidStatsManager;
    public ChunkWarsStatisticsManager chunkWarsStatisticsManager;
    public TheDropperStatisticsManager theDropperStatisticsManager;
    public NetworkStatisticsManager networkStatisticsManager;

    // Constructor
    public StatisticsManager() {
        this.dimensionsStatsManager = new DimensionsStatisticsManager();
        this.jukeBoxStatsManager = new JukeBoxStatisticsManager();
        this.quakeStatsManager = new QuakeStatisticsManager();
        this.uhcOriginalStatsManager = new UHCOriginalStatisticsManager();
        this.uhcRunStatsManager = new UHCRunStatisticsManager();
        this.doubleRunnerStatsManager = new DoubleRunnerStatisticsManager();
        this.uhcRandomStatsManager = new UHCRandomStatisticsManager();
        this.randomRunStatsManager = new RandomRunStatisticsManager();
        this.ultraFlagKeeperStatsManager = new UltraFlagKeeperStatisticsManager();
        this.uppervoidStatsManager = new UppervoidStatisticsManager();
        this.chunkWarsStatisticsManager = new ChunkWarsStatisticsManager();
        this.theDropperStatisticsManager = new TheDropperStatisticsManager();
        this.networkStatisticsManager = new NetworkStatisticsManager();
    }

    // Get all player statistics
    public PlayerStatisticsBean getAllPlayerStatistics(PlayerBean player, DatabaseAccess databaseAccess) throws Exception {
        // Declared bean
        DimensionsStatisticsBean dimensionsStats;
        JukeBoxStatisticsBean jukeBoxStats;
        QuakeStatisticsBean quakeStats;
        UHCOriginalStatisticsBean uhcOriginalStats;
        UHCRunStatisticsBean uhcRunStats;
        DoubleRunnerStatisticsBean doubleRunnerStats;
        UHCRandomStatisticsBean uhcRandomStats;
        RandomRunStatisticsBean randomRunStats;
        UltraFlagKeeperStatisticsBean ultraFlagKeeperStats;
        UppervoidStatisticsBean upperVoidStats;
        ChunkWarsStatisticsBean chunkWarsStats;
        TheDropperStatisticsBean theDropperStats;

        // Get the different statistics bean
        try {
            dimensionsStats = this.dimensionsStatsManager.getDimensionsStatistics(player, databaseAccess);
            jukeBoxStats = this.jukeBoxStatsManager.getJukeBoxStatistics(player, databaseAccess);
            quakeStats = this.quakeStatsManager.getQuakeStatistics(player, databaseAccess);
            uhcOriginalStats = this.uhcOriginalStatsManager.getUHCOriginalStatistics(player, databaseAccess);
            uhcRunStats = this.uhcRunStatsManager.getUHCRunStatistics(player, databaseAccess);
            doubleRunnerStats = this.doubleRunnerStatsManager.getDoubleRunnerStatistics(player, databaseAccess);
            uhcRandomStats = this.uhcRandomStatsManager.getUHCRandomStatistics(player, databaseAccess);
            randomRunStats = this.randomRunStatsManager.getRandomRunStatistics(player, databaseAccess);
            ultraFlagKeeperStats = this.ultraFlagKeeperStatsManager.getUltraFlagKeeperStatistics(player, databaseAccess);
            upperVoidStats = this.uppervoidStatsManager.getUppervoidStatistics(player, databaseAccess);
            chunkWarsStats = this.chunkWarsStatisticsManager.getChunkWarsStatistics(player, databaseAccess);
            theDropperStats = this.theDropperStatisticsManager.getTheDropperStatistics(player, databaseAccess);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }

        // Create the aggregation of different statistics bean
        return new PlayerStatisticsBean(dimensionsStats, jukeBoxStats, quakeStats, uhcOriginalStats, uhcRunStats, doubleRunnerStats, uhcRandomStats, randomRunStats, ultraFlagKeeperStats, upperVoidStats, chunkWarsStats, theDropperStats);
    }

    // Update all player statistics
    public void updateAllPlayerStatistics(PlayerBean player, PlayerStatisticsBean data, DatabaseAccess databaseAccess) throws Exception {
        // Update the different statistics bean
        try {
            this.dimensionsStatsManager.updateDimensionsStatistics(player, data.getDimensionsStats(), databaseAccess);
            this.jukeBoxStatsManager.updateJukeBoxStatistics(player, data.getJukeBoxStats(), databaseAccess);
            this.quakeStatsManager.updateQuakeStatistics(player, data.getQuakeStats(), databaseAccess);
            this.uhcOriginalStatsManager.updateUHCOriginalStatistics(player, data.getUHCOriginalStats(), databaseAccess);
            this.uhcRunStatsManager.updateUHCRunStatistics(player, data.getUHCRunStats(), databaseAccess);
            this.doubleRunnerStatsManager.updateDoubleRunnerStatistics(player, data.getDoubleRunnerStats(), databaseAccess);
            this.uhcRandomStatsManager.updateUHCRandomStatistics(player, data.getUHCRandomStats(), databaseAccess);
            this.randomRunStatsManager.updateRandomRunStatistics(player, data.getRandomRunStats(), databaseAccess);
            this.ultraFlagKeeperStatsManager.updateUltraFlagKeeperStatistics(player, data.getUltraFlagKeeperStats(), databaseAccess);
            this.uppervoidStatsManager.updateUppervoidStatistics(player, data.getUppervoidStats(), databaseAccess);
            this.chunkWarsStatisticsManager.updateChunkWarsStatistics(player, data.getChunkWarsStats(), databaseAccess);
            this.theDropperStatisticsManager.updateTheDropperStatistics(player, data.getTheDropperStats(), databaseAccess);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }
}
