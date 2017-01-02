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

package net.samagames.persistanceapi.beans.statistics;

public class PlayerStatisticsBean
{
    // Defines aggregation of statistics
    private DimensionStatisticsBean dimensionStats;
    private HeroBattleStatisticsBean heroBattleStats;
    private JukeBoxStatisticsBean jukeBoxStats;
    private QuakeStatisticsBean quakeStats;
    private UHCOriginalStatisticsBean uhcOriginalStats;
    private UHCRunStatisticsBean uhcRunStats;
    private DoubleRunnerStatisticsBean doubleRunnerStats;
    private UHCRandomStatisticsBean uhcRandomStats;
    private RandomRunStatisticsBean randomRunStats;
    private UltraFlagKeeperStatisticsBean ultraFlagKeeperStats;
    private UppervoidStatisticsBean uppervoidStats;
    private ChunkWarsStatisticsBean chunkWarsStats;

    // Empty constructor for reflection creation
    public PlayerStatisticsBean()
    {
        super();
    }

    // Constructor
    public PlayerStatisticsBean(DimensionStatisticsBean dimensionStats,
                                HeroBattleStatisticsBean heroBattleStats,
                                JukeBoxStatisticsBean jukeBoxStats,
                                QuakeStatisticsBean quakeStats,
                                UHCOriginalStatisticsBean uhcOriginalStats,
                                UHCRunStatisticsBean uhcRunStats,
                                DoubleRunnerStatisticsBean doubleRunnerStats,
                                UHCRandomStatisticsBean uhcRandomStats,
                                RandomRunStatisticsBean randomRunStats,
                                UltraFlagKeeperStatisticsBean ultraFlagKeeperStats,
                                UppervoidStatisticsBean uppervoidStatisticsBean,
                                ChunkWarsStatisticsBean chunkWarsStatisticsBean)
    {
        this.dimensionStats = dimensionStats;
        this.heroBattleStats = heroBattleStats;
        this.jukeBoxStats = jukeBoxStats;
        this.quakeStats = quakeStats;
        this.uhcOriginalStats = uhcOriginalStats;
        this.uhcRunStats = uhcRunStats;
        this.doubleRunnerStats = doubleRunnerStats;
        this.uhcRandomStats = uhcRandomStats;
        this.randomRunStats = randomRunStats;
        this.ultraFlagKeeperStats = ultraFlagKeeperStats;
        this.uppervoidStats = uppervoidStatisticsBean;
        this.chunkWarsStats = chunkWarsStatisticsBean;
    }

    // Getters
    public DimensionStatisticsBean getDimensionStats() {
        return dimensionStats;
    }
    public HeroBattleStatisticsBean getHeroBattleStats() {
        return heroBattleStats;
    }
    public JukeBoxStatisticsBean getJukeBoxStats() {
        return jukeBoxStats;
    }
    public QuakeStatisticsBean getQuakeStats() {
        return quakeStats;
    }
    public UHCOriginalStatisticsBean getUHCOriginalStats() {
        return uhcOriginalStats;
    }
    public UHCRunStatisticsBean getUHCRunStats() {
        return uhcRunStats;
    }
    public DoubleRunnerStatisticsBean getDoubleRunnerStats() {
        return doubleRunnerStats;
    }
    public UHCRandomStatisticsBean getUHCRandomStats() {
        return uhcRandomStats;
    }
    public RandomRunStatisticsBean getRandomRunStats() {
        return randomRunStats;
    }
    public UltraFlagKeeperStatisticsBean getUltraFlagKeeperStats() {
        return ultraFlagKeeperStats;
    }
    public UppervoidStatisticsBean getUppervoidStats() {
        return uppervoidStats;
    }
    public ChunkWarsStatisticsBean getChunkWarsStats() {
        return chunkWarsStats;
    }

    // Setters
    public void setDimmensionStats(DimensionStatisticsBean dimensionStats) {
        this.dimensionStats = dimensionStats;
    }
    public void setHeroBattleStats(HeroBattleStatisticsBean heroBattleStats) {
        this.heroBattleStats = heroBattleStats;
    }
    public void setJukeBoxStats(JukeBoxStatisticsBean jukeBoxStats) {
        this.jukeBoxStats = jukeBoxStats;
    }
    public void setQuakeStats(QuakeStatisticsBean quakeStats) {
        this.quakeStats = quakeStats;
    }
    public void setUHCOriginalStats(UHCOriginalStatisticsBean uhcOriginalStats) {
        this.uhcOriginalStats = uhcOriginalStats;
    }
    public void setUHCRunStats(UHCRunStatisticsBean uhcRunStats) {
        this.uhcRunStats = uhcRunStats;
    }
    public void setDoubleRunnerStats(DoubleRunnerStatisticsBean doubleRunnerStats) {
        this.doubleRunnerStats = doubleRunnerStats;
    }
    public void setUHCRandomStats(UHCRandomStatisticsBean uhcRandomStats) {
        this.uhcRandomStats = uhcRandomStats;
    }
    public void setRandomRunStats(RandomRunStatisticsBean randomRunStats) {
        this.randomRunStats = randomRunStats;
    }
    public void setUltraFlagKeeperStats(UltraFlagKeeperStatisticsBean ultraFlagKeeperStats) {
        this.ultraFlagKeeperStats = ultraFlagKeeperStats;
    }
    public void setUppervoidStats(UppervoidStatisticsBean uppervoidStats) {
        this.uppervoidStats = uppervoidStats;
    }
    public void setChunkWarsStats(ChunkWarsStatisticsBean chunkWarsStats) {
        this.chunkWarsStats = chunkWarsStats;
    }
}
