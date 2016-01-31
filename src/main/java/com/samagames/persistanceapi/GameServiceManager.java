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

package com.samagames.persistanceapi;

import com.samagames.persistanceapi.beans.PlayerBean;
import com.samagames.persistanceapi.beans.PlayerStatisticsBean;
import com.samagames.persistanceapi.beans.aggregationbean.*;
import com.samagames.persistanceapi.datamanager.DatabaseManager;
import com.samagames.persistanceapi.datamanager.PlayerManager;
import com.samagames.persistanceapi.datamanager.SamaritanManager;
import com.samagames.persistanceapi.datamanager.StatisticsManager;
import java.util.UUID;

public class GameServiceManager
{
    // Defines attributes
    public DatabaseManager databaseManager;
    public PlayerManager playerManager;
    public SamaritanManager samaritanManager;
    public StatisticsManager statisticsManager;

    // Super constructor
    public GameServiceManager()
    {
        // Singleton of DatabaseManager
        this.databaseManager = DatabaseManager.getInstance();
        this.playerManager = new PlayerManager();
        this.statisticsManager = new StatisticsManager();
    }


    /*============================================
      Part of player manager
    ============================================*/

    // Get the player by UUID
    public PlayerBean getPlayer(UUID uuid)
    {
       // Get the PlayerBean
        PlayerBean player = this.playerManager.getPlayer(uuid, this.databaseManager.getDataSource());

        // Return the player
        return player;
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
      Part of samaritan manager
    ============================================*/

    // Ban a player
    public void banPlayer(PlayerBean player)
    {
        // Do the ban
        this.samaritanManager.banPlayer(player, this.databaseManager.getDataSource());
    }

    // Check if a player is banned
    public boolean isPlayerBanned(PlayerBean player)
    {
        // Check the ban status
        return this.samaritanManager.isPlayerBanned(player, this.databaseManager.getDataSource());
    }

    // Remove ban from player
    public void removeBan(PlayerBean player)
    {
        // Remove the ban
        this.samaritanManager.removeBan(player, this.databaseManager.getDataSource());
    }

    // Mute a player
    public void mutePlayer(PlayerBean player)
    {
        // Do the mute
        this.samaritanManager.mutePlayer(player, this.databaseManager.getDataSource());
    }

    // Check if a player is muted
    public boolean isPlayerMuted(PlayerBean player)
    {
        // Check the mute status
        return this.samaritanManager.isPlayerMuted(player, this.databaseManager.getDataSource());
    }

    // Remove mute from player
    public void removeMute(PlayerBean player)
    {
        // Remove the mute
        this.samaritanManager.removeMute(player, this.databaseManager.getDataSource());
    }

    // Kick a player
    public void kickPlayer(PlayerBean player)
    {
        // Do the kick
        this.samaritanManager.kickPlayer(player, this.databaseManager.getDataSource());
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
    public UppervoidStatistics getUpperVoidStatistics(PlayerBean player)
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

}
