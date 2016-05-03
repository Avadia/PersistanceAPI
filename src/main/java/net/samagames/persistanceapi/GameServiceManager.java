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

import net.samagames.persistanceapi.beans.permissions.*;
import net.samagames.persistanceapi.beans.players.*;
import net.samagames.persistanceapi.beans.shop.ItemDescriptionBean;
import net.samagames.persistanceapi.beans.shop.PromotionsBean;
import net.samagames.persistanceapi.beans.shop.TransactionBean;
import net.samagames.persistanceapi.beans.statistics.PlayerStatisticsBean;
import net.samagames.persistanceapi.beans.statistics.*;
import net.samagames.persistanceapi.beans.utils.BungeeConfigBean;
import net.samagames.persistanceapi.datamanager.*;
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
    private TransactionManager transactionManager;
    private ItemManager itemManager;

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
        this.transactionManager = new TransactionManager();
        this.itemManager = new ItemManager();
    }


    /*============================================
      Part of denunciation manager
    ============================================*/

    // Make a denunciation
    public synchronized  void denouncePlayer(PlayerBean player, DenunciationBean denunciation) throws Exception
    {
        this.denunciationManager.denouncePlayer(player, denunciation, this.databaseManager.getDataSource(), this.playerManager);
    }



    /*============================================
      Part of config manager
    ============================================*/

    // Get the bungee config
    public synchronized BungeeConfigBean getBungeeConfig()throws Exception
    {
        return this.configurationManager.getConfig(this.databaseManager.getDataSource());
    }

    // Update the bungee config
    public synchronized void updateBungeeConfig(BungeeConfigBean config)throws Exception
    {
        this.configurationManager.updateConfig(config, this.databaseManager.getDataSource());
    }


    /*============================================
      Part of player manager
    ============================================*/

    // Get the player by UUID
    public synchronized PlayerBean getPlayer(UUID uuid, PlayerBean player)throws Exception
    {
       // Get the PlayerBean
        return this.playerManager.getPlayer(uuid, player, this.databaseManager.getDataSource());
    }

    // Update the player
    public synchronized void updatePlayer(PlayerBean player)throws Exception
    {
        // Update datas of player
        this.playerManager.updatePlayer(player, this.databaseManager.getDataSource());
    }

    // Create the player
    public synchronized void createPlayer(PlayerBean player)throws Exception
    {
        // Create the player
        this.playerManager.createPlayer(player, this.databaseManager.getDataSource());
    }


    /*============================================
      Part of sanction manager
    ============================================*/

    // Apply a sanction to a player
    public synchronized void applySanction(int sanctionType, SanctionBean sanction)throws Exception
    {
        // Do the sanction
        this.sanctionManager.applySanction(sanctionType, sanction, this.databaseManager.getDataSource());
    }

    public synchronized void removeSanction(int sanctionType, PlayerBean player)throws Exception
    {
        // Remove the sanction
        this.sanctionManager.removeSanction(sanctionType, player, this.databaseManager.getDataSource());
    }

    // Check if a player is banned
    public synchronized SanctionBean getPlayerBanned(PlayerBean player)throws Exception
    {
        // Check the ban status
        return this.sanctionManager.getPlayerBanned(player, this.databaseManager.getDataSource());
    }

    // Check if a player is muted
    public synchronized SanctionBean getPlayerMuted(PlayerBean player)throws Exception
    {
        // Check the mute status
        return this.sanctionManager.getPlayerMuted(player, this.databaseManager.getDataSource());
    }


    /*============================================
      Part of statistics manager
    ============================================*/

    // Get Dimension player statistics
    public synchronized DimensionStatisticsBean getDimensionStatistics(PlayerBean player) throws Exception
    {
        // Get the statistics
        return this.statisticsManager.dimensionStatsManager.getDimensionStatistics(player, this.databaseManager.getDataSource());
    }

    // Get HeroBattle player statistics
    public synchronized HeroBattleStatisticsBean getHeroBattleStatistics(PlayerBean player) throws Exception
    {
        // Get the statistics
        return this.statisticsManager.heroBattleStatsManager.getHeroBattleStatistics(player, this.databaseManager.getDataSource());
    }

    // Get JukeBox player statistics
    public synchronized  JukeBoxStatisticsBean getJukeBoxStatistics(PlayerBean player) throws Exception
    {
        // Get the statistics
        return this.statisticsManager.jukeBoxStatsManager.getJukeBoxStatistics(player, this.databaseManager.getDataSource());
    }

    // Get Quake player statistics
    public synchronized QuakeStatisticsBean getQuakeStatistics(PlayerBean player) throws Exception
    {
        // Get the statistics
        return this.statisticsManager.quakeStatsManager.getQuakeStatistics(player, this.databaseManager.getDataSource());
    }

    // Get UHCRun player statistics
    public synchronized UHCRunStatisticsBean getUHCRunStatistics(PlayerBean player) throws Exception
    {
        // Get the statistics
        return this.statisticsManager.uhcRunStatsManager.getUHCRunStatistics(player, this.databaseManager.getDataSource());
    }

    // Get UpperVoid player statistics
    public synchronized UppervoidStatisticsBean getUpperVoidStatistics(PlayerBean player) throws Exception
    {
        // Get the statistics
        return this.statisticsManager.upperVoidStatsManager.getUpperVoidStatistics(player, this.databaseManager.getDataSource());
    }

    // Get all player statistics
    public synchronized PlayerStatisticsBean getAllStatistics(PlayerBean player) throws Exception
    {
        // Get all the statistics
        return this.statisticsManager.getAllPlayerStatistics(player, this.databaseManager.getDataSource());
    }

    // Update all player statistics
    public synchronized void updateAllStatistics(PlayerBean player, PlayerStatisticsBean stats) throws Exception
    {
        // Update statistics
        this.statisticsManager.updateAllPlayerStatistics(player, stats, this.databaseManager.getDataSource());
    }

    // Update Dimension statistics
    public synchronized void updateDimensionStatistics(PlayerBean player, DimensionStatisticsBean dimensionStats) throws Exception
    {
        // Update statistics
        this.statisticsManager.dimensionStatsManager.updateDimensionStatistics(player, dimensionStats, this.databaseManager.getDataSource());
    }

    // Update HeroBattle statistics
    public synchronized void updateHeroBattleStatistics(PlayerBean player, HeroBattleStatisticsBean heroBattleStats) throws Exception
    {
        // Update statistics
        this.statisticsManager.heroBattleStatsManager.updateHeroBattleStatistics(player, heroBattleStats, this.databaseManager.getDataSource());
    }

    // Update JukeBox statistics
    public synchronized void updateJukeBoxStatistics(PlayerBean player, JukeBoxStatisticsBean jukeBoxStats) throws Exception
    {
        // Update statistics
        this.statisticsManager.jukeBoxStatsManager.updateJukeBoxStatistics(player, jukeBoxStats, this.databaseManager.getDataSource());
    }

    // Update Quake statistics
    public synchronized void updateQuakeStatistics(PlayerBean player, QuakeStatisticsBean quakeStats) throws Exception
    {
        // Update statistics
        this.statisticsManager.quakeStatsManager.updateQuakeStatistics(player, quakeStats, this.databaseManager.getDataSource());
    }

    // Update UHCRun statistics
    public synchronized void updateUHCRunStatistics(PlayerBean player, UHCRunStatisticsBean uhcRunStats) throws Exception
    {
        // Update statistics
        this.statisticsManager.uhcRunStatsManager.updateUHCRunStatistics(player, uhcRunStats,this.databaseManager.getDataSource());
    }

    // Update UpperVoid statistics
    public synchronized void updateUpperVoidStatistics(PlayerBean player, UppervoidStatisticsBean upperVoidStats) throws Exception
    {
        // Update statistics
        this.statisticsManager.upperVoidStatsManager.updateUpperVoidStatistics(player, upperVoidStats,this.databaseManager.getDataSource());
    }

    // Get the dimensions leaderboard
    public synchronized List<LeaderboardBean> getDimmensionLeaderBoard(String category) throws Exception
    {
        // Get the leaderboard
        return this.statisticsManager.dimensionStatsManager.getLeaderBoard(category, this.databaseManager.getDataSource());
    }

    // Get the herobattle leaderboard
    public synchronized List<LeaderboardBean> getHeroBattleLeaderBoard(String category) throws Exception
    {
        // Get the leaderboard
        return this.statisticsManager.heroBattleStatsManager.getLeaderBoard(category, this.databaseManager.getDataSource());
    }

    // Get the jukebox leaderboard
    public synchronized List<LeaderboardBean> getJukeBoxLeaderBoard(String category) throws Exception
    {
        // Get the leaderboard
        return this.statisticsManager.jukeBoxStatsManager.getLeaderBoard(category, this.databaseManager.getDataSource());
    }

    // Get the quake leaderboard
    public synchronized List<LeaderboardBean> getQuakeLeaderBoard(String category) throws Exception
    {
        // Get the leaderboard
        return this.statisticsManager.quakeStatsManager.getLeaderBoard(category, this.databaseManager.getDataSource());
    }

    // Get the uhcrun leaderboard
    public synchronized List<LeaderboardBean> getUhcLeaderBoard(String category) throws Exception
    {
        // Get the leaderboard
        return this.statisticsManager.uhcRunStatsManager.getLeaderBoard(category, this.databaseManager.getDataSource());
    }

    // Get the uppervoid leaderboard
    public synchronized List<LeaderboardBean> getUpperVoidLeaderBoard(String category) throws Exception
    {
        // Get the leaderboard
        return this.statisticsManager.upperVoidStatsManager.getLeaderBoard(category, this.databaseManager.getDataSource());
    }


    /*============================================
      Part of permissions manager
    ============================================*/

    // Get API permissions
    public synchronized APIPermissionsBean getAPIPermission(PlayerBean player)throws Exception
    {
        // Get the permissions
        return this.permissionsManager.apiPermissionManager.getAPIPermission(player, this.databaseManager.getDataSource());
    }

    // Get Bukkit permissions
    public synchronized BukkitPermissionsBean getBukkitPermission(PlayerBean player)throws Exception
    {
        // Get the permissions
        return this.permissionsManager.bukkitPermissionManager.getBukkitPermission(player, this.databaseManager.getDataSource());
    }

    // Get Bungee & Redis permissions
    public synchronized BungeeRedisPermissionsBean getBungeeRedisPemission(PlayerBean player)throws Exception
    {
        // Get the permissions
        return this.permissionsManager.bungeeRedisPermissionManager.getBungeeRedisPemission(player, this.databaseManager.getDataSource());
    }

    // Get Hub permissions
    public synchronized HubPermissionsBean getHubPermission(PlayerBean player)throws Exception
    {
        // Get the permissions
        return this.permissionsManager.hubPermissionManager.getHubPermission(player, this.databaseManager.getDataSource());
    }

    // Get Moderation permissions
    public synchronized ModerationPermissionsBean getModerationPermission(PlayerBean player)throws Exception
    {
        // Get the permissions
        return this.permissionsManager.moderationPermissionManager.getModerationPermission(player, this.databaseManager.getDataSource());
    }

    // Get Proxies permissions
    public synchronized ProxiesPermissionsBean getProxiesPermission(PlayerBean player) throws Exception
    {
        // Get the permissions
        return this.permissionsManager.proxiesPermissionManager.getProxiesPermission(player, this.databaseManager.getDataSource());
    }

    // Get Staff permissions
    public synchronized StaffPermissionsBean getStaffPermission(PlayerBean player) throws Exception
    {
        // Get the permissions
        return this.permissionsManager.staffPermissionManager.getStaffPermission(player, this.databaseManager.getDataSource());
    }

    // Get all player permissions
    public synchronized PlayerPermissionBean getAllPlayerPermission(PlayerBean player) throws Exception
    {
        // Get all the statistics
        return this.permissionsManager.getAllPlayerPermission(player, this.databaseManager.getDataSource());
    }

    /*============================================
      Part of groups manager
    ============================================*/

    public synchronized GroupsBean getGroupPlayer(PlayerBean player)throws Exception
    {
        // Get the groups permision for a player
        return this.groupsManager.getGroupPlayer(player, this.databaseManager.getDataSource());
    }


    /*============================================
      Part of groups manager
    ============================================*/

    // Post a friendship demand
    public synchronized void postFriendshipDemand(FriendshipBean friendship)throws Exception
    {
        // Post the friendship demand
        this.friendshipManager.postFriendshipDemand(friendship, this.databaseManager.getDataSource());
    }

    // Accept a friendship demand
    public synchronized void acceptFriendshipDemand(FriendshipBean friendship)throws Exception
    {
        // Accept the demand
        this.friendshipManager.acceptFriendshipDemand(friendship, this.databaseManager.getDataSource());
    }

    // Refuse a friendship demand
    public synchronized void refuseFriendshipDemand(FriendshipBean friendship)throws Exception
    {
        // Refuse the demand
        this.friendshipManager.refuseFriendshipDemand(friendship, this.databaseManager.getDataSource());
    }

    // Get the list of friendship demand
    public synchronized List<FriendshipBean> getFriendshipDemandList(PlayerBean player)throws Exception
    {
        // Get the list
        return this.friendshipManager.getFriendshipDemandList(player, this.databaseManager.getDataSource());
    }

    // Get the list of friendship
    public synchronized List<FriendshipBean> getFriendshipList(PlayerBean player)throws Exception
    {
        // Get the list
        return this.friendshipManager.getFriendshipList(player, this.databaseManager.getDataSource());
    }

    /*============================================
      Part of promotions manager
    ============================================*/

    // Get all active promotions
    public synchronized List<PromotionsBean> getAllActivePromotions()throws Exception
    {
        // Get promotions list
        return this.promotionsManager.getAllActivePromotions(this.databaseManager.getDataSource());
    }

    // Get specific promotions
    public synchronized List<PromotionsBean> getPromotion(int typePromotion, int typeGame)throws Exception
    {
        // Get promotions
        return this.promotionsManager.getPromotion(this.databaseManager.getDataSource(), typePromotion, typeGame);
    }

    // Create promotion
    public synchronized void createPromotion(PromotionsBean promotionsBean)throws Exception
    {
        // Create promotion
        this.promotionsManager.createPromotion(promotionsBean, this.databaseManager.getDataSource());
    }

    // Delete promotion
    public synchronized void deletePromotion(PromotionsBean promotionsBean)throws Exception
    {
        // Delete promotion
        this.promotionsManager.deletePromotion(promotionsBean, this.databaseManager.getDataSource());
    }


    /*============================================
      Part of player settings manager
    ============================================*/

    // Get the player settings
    public synchronized PlayerSettingsBean getPlayerSettings(PlayerBean player)throws Exception
    {
        // Get settings
        return this.playerSettingsManager.getPlayerSettings(player, this.databaseManager.getDataSource());
    }

    // Set the player settings
    public synchronized void setPlayerSettings(PlayerBean player, PlayerSettingsBean settingsBeans)throws Exception
    {
        // Set settings
        this.playerSettingsManager.setPlayerSettings(player, settingsBeans, this.databaseManager.getDataSource());
    }

    // Create default settings
    public synchronized void createDefaultPlayerSettings(PlayerBean player)throws Exception
    {
        // Create settings
        this.playerSettingsManager.createDefaultPlayerSettings(player, this.databaseManager.getDataSource());
    }


    /*============================================
      Part of transaction manager
    ============================================*/

    // Get all the player transactions
    public synchronized List<TransactionBean> getPlayerTransactions(PlayerBean player) throws Exception
    {
        // Get transactions
        return this.transactionManager.getPlayerTransactions(player, this.databaseManager.getDataSource());
    }

    // Get all the player transactions with selected items
    public synchronized List<TransactionBean> getPlayerSelectedTransactions(PlayerBean player) throws Exception
    {
        // Get transactions
        return this.transactionManager.getPlayerSelectedTransactions(player, this.databaseManager.getDataSource());
    }

    // Get all the player transactions with selected items for a game
    public synchronized List<TransactionBean> getPlayerGameSelectedTransactions(PlayerBean player, int selectedGame) throws Exception
    {
        // Get transactions
        return this.transactionManager.getPlayerGameSelectedTransactions(player, this.databaseManager.getDataSource(), selectedGame);
    }

    // Create a transaction shop for a player
    public synchronized void createTransaction(PlayerBean player, TransactionBean transaction) throws Exception
    {
        // Write transaction
        this.transactionManager.createTransaction(player, this.databaseManager.getDataSource(), transaction);
    }


    /*============================================
      Part of item manager
    ============================================*/

    // Get description of an item
    public synchronized ItemDescriptionBean getItemDescription(int itemId) throws Exception
    {
        // Get description
        return this.itemManager.getItemDescription(itemId, this.databaseManager.getDataSource());
    }

    // Get all the items
    public synchronized List<ItemDescriptionBean> getAllItemDescription() throws Exception
    {
        // Get items
        return this.itemManager.getAllItemDescription(this.databaseManager.getDataSource());
    }
}
