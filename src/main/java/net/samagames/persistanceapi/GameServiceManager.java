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

import net.samagames.persistanceapi.beans.*;
import net.samagames.persistanceapi.beans.permissions.*;
import net.samagames.persistanceapi.beans.statistics.PlayerStatisticsBean;
import net.samagames.persistanceapi.beans.statistics.*;
import net.samagames.persistanceapi.datamanager.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GameServiceManager
{
    // Defines attributes
    private DatabaseManager databaseManager;
    private PlayerManager playerManager;
    private SanctionManager sanctionManager;
    private StatisticsManager statisticsManager;
    private ConfigurationManager configurationManager;
    private DenunciationManager denunciationManager;
    private PermissionsManager permissionsManager;
    private GroupsManager groupsManager;
    private FriendshipManager friendshipManager;
    private PromotionsManager promotionsManager;
    private PlayerSettingsManager playerSettingsManager;

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
        this.permissionsManager = new PermissionsManager();
        this.groupsManager = new GroupsManager();
        this.friendshipManager = new FriendshipManager();
        this.promotionsManager = new PromotionsManager();
        this.playerSettingsManager = new PlayerSettingsManager();
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
        return this.configurationManager.getConfig(this.databaseManager.getDataSource());
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
        return this.playerManager.getPlayer(uuid, player, this.databaseManager.getDataSource());
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
    public SanctionBean getPlayerBanned(PlayerBean player)
    {
        // Check the ban status
        return this.sanctionManager.getPlayerBanned(player, this.databaseManager.getDataSource());
    }

    // Check if a player is muted
    public SanctionBean getPlayerMuted(PlayerBean player)
    {
        // Check the mute status
        return this.sanctionManager.getPlayerMuted(player, this.databaseManager.getDataSource());
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

    // Update all player statistics
    public void updateAllStatistics(PlayerBean player, PlayerStatisticsBean stats)
    {
        // Update statistics
        this.statisticsManager.updateAllPlayerStatistics(player, stats, this.databaseManager.getDataSource());
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

    // Update UHCRun statistics
    public void updateUHCRunStatistics(PlayerBean player, UHCRunStatisticsBean uhcRunStats)
    {
        // Update statistics
        this.statisticsManager.uhcRunStatsManager.updateUHCRunStatistics(player, uhcRunStats,this.databaseManager.getDataSource());
    }

    // Update UpperVoid statistics
    public void updateUpperVoidStatistics(PlayerBean player, UppervoidStatisticsBean upperVoidStats)
    {
        // Update statistics
        this.statisticsManager.upperVoidStatsManager.updateUpperVoidStatistics(player, upperVoidStats,this.databaseManager.getDataSource());
    }

    // Get the dimensions leaderboard
    public List<LeaderboardBean> getDimmensionLeaderBoard(String category)
    {
        // Get the leaderboard
        return this.statisticsManager.dimensionStatsManager.getLeaderBoard(category, this.databaseManager.getDataSource());
    }

    // Get the herobattle leaderboard
    public List<LeaderboardBean> getHeroBattleLeaderBoard(String category)
    {
        // Get the leaderboard
        return this.statisticsManager.heroBattleStatsManager.getLeaderBoard(category, this.databaseManager.getDataSource());
    }

    // Get the jukebox leaderboard
    public List<LeaderboardBean> getJukeBoxLeaderBoard(String category)
    {
        // Get the leaderboard
        return this.statisticsManager.jukeBoxStatsManager.getLeaderBoard(category, this.databaseManager.getDataSource());
    }

    // Get the quake leaderboard
    public List<LeaderboardBean> getQuakeLeaderBoard(String category)
    {
        // Get the leaderboard
        return this.statisticsManager.quakeStatsManager.getLeaderBoard(category, this.databaseManager.getDataSource());
    }

    // Get the uhcrun leaderboard
    public List<LeaderboardBean> getUhcLeaderBoard(String category)
    {
        // Get the leaderboard
        return this.statisticsManager.uhcRunStatsManager.getLeaderBoard(category, this.databaseManager.getDataSource());
    }

    // Get the uppervoid leaderboard
    public List<LeaderboardBean> getUpperVoidLeaderBoard(String category)
    {
        // Get the leaderboard
        return this.statisticsManager.upperVoidStatsManager.getLeaderBoard(category, this.databaseManager.getDataSource());
    }


    /*============================================
      Part of permissions manager
    ============================================*/

    // Get API permissions
    public APIPermissionsBean getAPIPermission(PlayerBean player)
    {
        // Get the permissions
        return this.permissionsManager.apiPermissionManager.getAPIPermission(player, this.databaseManager.getDataSource());
    }

    // Get Bukkit permissions
    public BukkitPermissionsBean getBukkitPermission(PlayerBean player)
    {
        // Get the permissions
        return this.permissionsManager.bukkitPermissionManager.getBukkitPermission(player, this.databaseManager.getDataSource());
    }

    // Get Bungee & Redis permissions
    public BungeeRedisPermissionsBean getBungeeRedisPemission(PlayerBean player)
    {
        // Get the permissions
        return this.permissionsManager.bungeeRedisPermissionManager.getBungeeRedisPemission(player, this.databaseManager.getDataSource());
    }

    // Get Hub permissions
    public HubPermissionsBean getHubPermission(PlayerBean player)
    {
        // Get the permissions
        return this.permissionsManager.hubPermissionManager.getHubPermission(player, this.databaseManager.getDataSource());
    }

    // Get Moderation permissions
    public ModerationPermissionsBean getModerationPermission(PlayerBean player)
    {
        // Get the permissions
        return this.permissionsManager.moderationPermissionManager.getModerationPermission(player, this.databaseManager.getDataSource());
    }

    // Get Proxies permissions
    public ProxiesPermissionsBean getProxiesPermission(PlayerBean player)
    {
        // Get the permissions
        return this.permissionsManager.proxiesPermissionManager.getProxiesPermission(player, this.databaseManager.getDataSource());
    }

    // Get Staff permissions
    public StaffPermissionsBean getStaffPermission(PlayerBean player)
    {
        // Get the permissions
        return this.permissionsManager.staffPermissionManager.getStaffPermission(player, this.databaseManager.getDataSource());
    }

    // Get UHC permissions
    public UHCPermissionsBean getUHCPermission(PlayerBean player)
    {
        // Get the permissions
        return this.permissionsManager.uhcPermissionManager.getUHCPermission(player, this.databaseManager.getDataSource());
    }

    // Get all player permissions
    public PlayerPermissionBean getAllPlayerPermission(PlayerBean player)
    {
        // Get all the statistics
        return this.permissionsManager.getAllPlayerPermission(player, this.databaseManager.getDataSource());
    }

    /*============================================
      Part of groups manager
    ============================================*/

    public GroupsBean getGroupPlayer(PlayerBean player)
    {
        // Get the groups permision for a player
        return this.groupsManager.getGroupPlayer(player, this.databaseManager.getDataSource());
    }


    /*============================================
      Part of groups manager
    ============================================*/

    // Post a friendship demand
    public void postFriendshipDemand(FriendshipBean friendship)
    {
        // Post the friendship demand
        this.friendshipManager.postFriendshipDemand(friendship, this.databaseManager.getDataSource());
    }

    // Accept a friendship demand
    public void acceptFriendshipDemand(FriendshipBean friendship)
    {
        // Accept the demand
        this.friendshipManager.acceptFriendshipDemand(friendship, this.databaseManager.getDataSource());
    }

    // Refuse a friendship demand
    public void refuseFriendshipDemand(FriendshipBean friendship)
    {
        // Refuse the demand
        this.friendshipManager.refuseFriendshipDemand(friendship, this.databaseManager.getDataSource());
    }

    // Get the list of friendship demand
    public ArrayList<FriendshipBean> getFriendshipDemandList(PlayerBean player)
    {
        // Get the list
        return this.friendshipManager.getFriendshipDemandList(player, this.databaseManager.getDataSource());
    }

    // Get the list of friendship
    public ArrayList<FriendshipBean> getFriendshipList(PlayerBean player)
    {
        // Get the list
        return this.friendshipManager.getFriendshipList(player, this.databaseManager.getDataSource());
    }

    /*============================================
      Part of promotions manager
    ============================================*/

    // Get all active promotions
    public ArrayList<PromotionsBean> getAllActivePromotions()
    {
        // Get promotions list
        return this.promotionsManager.getAllActivePromotions(this.databaseManager.getDataSource());
    }

    // Get specific promotions
    public ArrayList<PromotionsBean> getPromotion(int typePromotion, int typeGame)
    {
        // Get promotions
        return this.promotionsManager.getPromotion(this.databaseManager.getDataSource(), typePromotion, typeGame);
    }

    // Create promotion
    public void createPromotion(PromotionsBean promotionsBean)
    {
        // Create promotion
        this.promotionsManager.createPromotion(promotionsBean, this.databaseManager.getDataSource());
    }

    // Delete promotion
    public void deletePromotion(PromotionsBean promotionsBean)
    {
        // Delete promotion
        this.promotionsManager.deletePromotion(promotionsBean, this.databaseManager.getDataSource());
    }


    /*============================================
      Part of player settings manager
    ============================================*/

    // Get the player settings
    public PlayerSettingsBean getPlayerSettings(PlayerBean player)
    {
        // Get settings
        return this.playerSettingsManager.getPlayerSettings(player, this.databaseManager.getDataSource());
    }

    // Set the player settings
    public void setPlayerSettings(PlayerBean player, PlayerSettingsBean settingsBeans)
    {
        // Set settings
        this.playerSettingsManager.setPlayerSettings(player, settingsBeans, this.databaseManager.getDataSource());
    }

    // Create default settings
    public void createDefaultPlayerSettings(PlayerBean player)
    {
        // Create settings
        this.playerSettingsManager.createDefaultPlayerSettings(player, this.databaseManager.getDataSource());
    }




}
