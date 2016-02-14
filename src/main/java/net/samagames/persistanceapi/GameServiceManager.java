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

package net.samagames.persistanceapi;

import net.samagames.persistanceapi.beans.BungeeConfigBean;
import net.samagames.persistanceapi.beans.DenunciationBean;
import net.samagames.persistanceapi.beans.PlayerBean;
import net.samagames.persistanceapi.beans.SanctionBean;
import net.samagames.persistanceapi.beans.statistics.PlayerStatisticsBean;
import net.samagames.persistanceapi.beans.statistics.*;
import net.samagames.persistanceapi.datamanager.*;

import javax.sql.DataSource;
import java.util.UUID;

public class GameServiceManager
{
    // Defines attributes
    public DatabaseManager databaseManager;
    public PlayerManager playerManager;
    public SanctionManager sanctionManager;
    public StatisticsManager statisticsManager;
    public ConfigurationManager configurationManager;
    public DenunciationManager denunciationManager;

    // Super constructor
    public GameServiceManager(String url, String name, String password, int minPoolSize, int maxPoolSize)
    {
        // Singleton of DatabaseManager
        this.databaseManager = DatabaseManager.getInstance(url, name, password, minPoolSize, maxPoolSize);
        this.playerManager = new PlayerManager();
        this.sanctionManager = new SanctionManager();
        this.statisticsManager = new StatisticsManager();
        this.configurationManager = new ConfigurationManager();
        this.denunciationManager = new DenunciationManager();
    }


    /*============================================
      Part of denunciation manager
    ============================================*/

    // Make a denunciation
    public void denouncePlayer(PlayerBean player, DenunciationBean denunciation)
    {
        this.denunciationManager.denouncePlayer(player, denunciation, this.databaseManager.getDataSource(), this.playerManager);
    }



    /*============================================
      Part of config manager
    ============================================*/

    // Get the bungee config
    public BungeeConfigBean getBungeeConfig()
    {
        BungeeConfigBean config = this.configurationManager.getConfig(this.databaseManager.getDataSource());
        return config;
    }

    // Update the bungee config
    public void updateBungeeConfig(BungeeConfigBean config)
    {
        this.configurationManager.updateConfig(config, this.databaseManager.getDataSource());
    }


    /*============================================
      Part of player manager
    ============================================*/

    // Get the player by UUID
    public PlayerBean getPlayer(UUID uuid, PlayerBean player)
    {
       // Get the PlayerBean
        PlayerBean newPlayer = this.playerManager.getPlayer(uuid, player, this.databaseManager.getDataSource());

        // Return the player
        return newPlayer;
    }

    // Update the player
    public void updatePlayer(PlayerBean player)
    {
        // Update datas of player
        this.playerManager.updatePlayer(player, this.databaseManager.getDataSource());
    }

    // Create the player
    public void createPlayer(PlayerBean player)
    {
        // Create the player
        this.playerManager.createPlayer(player, this.databaseManager.getDataSource());
    }


    /*============================================
      Part of sanction manager
    ============================================*/

    // Apply a sanction to a player
    public void applySanction(int sanctionType, SanctionBean sanction)
    {
        // Do the sanction
        this.sanctionManager.applySanction(sanctionType, sanction, this.databaseManager.getDataSource());
    }

    public void removeSanction(int sanctionType, PlayerBean player)
    {
        // Remove the sanction
        this.sanctionManager.removeSanction(sanctionType, player, this.databaseManager.getDataSource());
    }

    // Check if a player is banned
    public boolean isPlayerBanned(PlayerBean player)
    {
        // Check the ban status
        return this.sanctionManager.isPlayerBanned(player, this.databaseManager.getDataSource());
    }

    // Check if a player is muted
    public boolean isPlayerMuted(PlayerBean player)
    {
        // Check the mute status
        return this.sanctionManager.isPlayerMuted(player, this.databaseManager.getDataSource());
    }


    /*============================================
      Part of statistics manager
    ============================================*/

    // Get Dimension player statistics
    public DimensionStatisticsBean getDimensionStatistics(PlayerBean player)
    {
        // Get the statistics
        return this.statisticsManager.dimensionStatsManager.getDimensionStatistics(player, this.databaseManager.getDataSource());
    }

    // Get HeroBattle player statistics
    public HeroBattleStatisticsBean getHeroBattleStatistics(PlayerBean player)
    {
        // Get the statistics
        return this.statisticsManager.heroBattleStatsManager.getHeroBattleStatistics(player, this.databaseManager.getDataSource());
    }

    // Get JukeBox player statistics
    public JukeBoxStatisticsBean getJukeBoxStatistics(PlayerBean player)
    {
        // Get the statistics
        return this.statisticsManager.jukeBoxStatsManager.getJukeBoxStatistics(player, this.databaseManager.getDataSource());
    }

    // Get Quake player statistics
    public QuakeStatisticsBean getQuakeStatistics(PlayerBean player)
    {
        // Get the statistics
        return this.statisticsManager.quakeStatsManager.getQuakeStatistics(player, this.databaseManager.getDataSource());
    }

    // Get UHCRun player statistics
    public UHCRunStatisticsBean getUHCRunStatistics(PlayerBean player)
    {
        // Get the statistics
        return this.statisticsManager.uhcRunStatsManager.getUHCRunStatistics(player, this.databaseManager.getDataSource());
    }

    // Get UpperVoid player statistics
    public UppervoidStatisticsBean getUpperVoidStatistics(PlayerBean player)
    {
        // Get the statistics
        return this.statisticsManager.upperVoidStatsManager.getUpperVoidStatistics(player, this.databaseManager.getDataSource());
    }

    // Get all player statistics
    public PlayerStatisticsBean getAllStatistics(PlayerBean player)
    {
        // Get all the statistics
        return this.statisticsManager.getAllPlayerStatistics(player, this.databaseManager.getDataSource());
    }

    // Update Dimension statistics
    public void updateDimensionStatistics(PlayerBean player, DimensionStatisticsBean dimensionStats)
    {
        // Update statistics
        this.statisticsManager.dimensionStatsManager.updateDimensionStatistics(player, dimensionStats, this.databaseManager.getDataSource());
    }

    // Update HeroBattle statistics
    public void updateHeroBattleStatistics(PlayerBean player, HeroBattleStatisticsBean heroBattleStats)
    {
        // Update statistics
        this.statisticsManager.heroBattleStatsManager.updateHeroBattleStatistics(player, heroBattleStats, this.databaseManager.getDataSource());
    }

    // Update JukeBox statistics
    public void updateJukeBoxStatistics(PlayerBean player, JukeBoxStatisticsBean jukeBoxStats)
    {
        // Update statistics
        this.statisticsManager.jukeBoxStatsManager.updateJukeBoxStatistics(player, jukeBoxStats, this.databaseManager.getDataSource());
    }

    // Update Quake statistics
    public void updateQuakeStatistics(PlayerBean player, QuakeStatisticsBean quakeStats)
    {
        // Update statistics
        this.statisticsManager.quakeStatsManager.updateQuakeStatistics(player, quakeStats, this.databaseManager.getDataSource());
    }
}
