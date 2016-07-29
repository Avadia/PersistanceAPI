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
    private HeroBattleStatisticsBean heroBatleStats;
    private JukeBoxStatisticsBean jukeBoxStats;
    private QuakeStatisticsBean quakeStats;
    private UHCStatisticsBean uhcStats;
    private UHCRunStatisticsBean uhcRunStats;
    private DoubleRunnerStatisticsBean doubleRunnerStats;
    private UHCRandomStatisticsBean uhcRandomStats;
    private RandomRunStatisticsBean randomRunStats;
    private UltraFlagKeeperStatisticsBean ultraFlagKeeperStats;
    private UppervoidStatisticsBean uppervoidStats;

    // Empty constructor for reflection creation
    public PlayerStatisticsBean()
    {
        super();
    }

    // Constructor
    public PlayerStatisticsBean(DimensionStatisticsBean dimensionStats, HeroBattleStatisticsBean heroBatleStats, JukeBoxStatisticsBean jukeBoxStats, QuakeStatisticsBean quakeStats, UHCStatisticsBean uhcStats, UHCRunStatisticsBean uhcRunStats, DoubleRunnerStatisticsBean doubleRunnerStats, UHCRandomStatisticsBean uhcRandomStats, RandomRunStatisticsBean randomRunStats, UltraFlagKeeperStatisticsBean ultraFlagKeeperStats, UppervoidStatisticsBean uppervoidStatisticsBean)
    {
        this.dimensionStats = dimensionStats;
        this.heroBatleStats = heroBatleStats;
        this.jukeBoxStats = jukeBoxStats;
        this.quakeStats = quakeStats;
        this.uhcStats = uhcStats;
        this.uhcRunStats = uhcRunStats;
        this.doubleRunnerStats = doubleRunnerStats;
        this.uhcRandomStats = uhcRandomStats;
        this.randomRunStats = randomRunStats;
        this.ultraFlagKeeperStats = ultraFlagKeeperStats;
        this.uppervoidStats = uppervoidStatisticsBean;
    }

    // Getters
    public DimensionStatisticsBean getDimensionStats() {
        return dimensionStats;
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
    public UHCStatisticsBean getUHCStats() {
        return uhcStats;
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

    // Setters
    public void setDimmensionStats(DimensionStatisticsBean dimensionStats) {
        this.dimensionStats = dimensionStats;
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
    public void setUHCStats(UHCStatisticsBean uhcStats) {
        this.uhcStats = uhcStats;
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

}
