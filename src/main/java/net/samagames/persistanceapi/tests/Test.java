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

package net.samagames.persistanceapi.tests;

import net.samagames.persistanceapi.GameServiceManager;
import net.samagames.persistanceapi.beans.permissions.APIPermissionsBean;
import net.samagames.persistanceapi.beans.players.*;
import net.samagames.persistanceapi.beans.shop.PromotionsBean;
import net.samagames.persistanceapi.beans.statistics.*;
import net.samagames.persistanceapi.beans.utils.BungeeConfigBean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

public class Test
{
    public static void main (String[] args)
    {
        /*
            Pour la connetion à la Bdd en local ligne de commande :  /Applications/MAMP/Library/bin/mysql --host=localhost -uroot -proot
        */

        // Execution plateform
        String cible = args[0];
        if (cible == null)
        {
            cible = "";
        }

        // Defines
        long startTime;
        DenunciationBean denunciationBean;
        UUID uuid;
        PlayerBean player;
        PlayerBean otherPlayer;
        DimensionStatisticsBean dimensionStats;
        HeroBattleStatisticsBean heroBattleStats;
        JukeBoxStatisticsBean jukeBoxStats;
        QuakeStatisticsBean quakeStats;
        UHCRunStatisticsBean uhcRunStats;
        UppervoidStatisticsBean upperVoidStats;
        GameServiceManager manager;

        // Initialize the manager
        System.out.println("Exécution du test");
        System.out.println("-----------------");
        startTime = System.currentTimeMillis();
        if (cible.equals("maison"))
        {
            // For MisterSatch only
            manager = new GameServiceManager("jdbc:mysql://127.0.0.1:8889/samagamesV3", "root", "root", 1, 10);
        }
        else
        {
            // For standard localhost configuration
            manager = new GameServiceManager("jdbc:mysql://127.0.0.1:3306/samagamesv3", "root", "", 1, 20);
        }
        System.out.println("Manager init time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Config loading
        startTime = System.currentTimeMillis();
        BungeeConfigBean config = manager.getBungeeConfig();
        System.out.println("Load config time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Config updating
        startTime = System.currentTimeMillis();
        config.setSlots(10);
        config.setMaxPlayers(10000);
        manager.updateBungeeConfig(config);
        System.out.println("Update config time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Create the player
        startTime = System.currentTimeMillis();
        player = new PlayerBean(UUID.fromString("a9ebd2f3-271d-4c6c-ba28-50f7ddd3465d"), "mistersatch", "the boss", 0, 0, new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),"125.125.125.125","TheUltimateKey", 1);
        manager.createPlayer(player);
        System.out.println("Create player process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Find a player test
        startTime = System.currentTimeMillis();
        player = manager.getPlayer(UUID.fromString("a9ebd2f3-271d-4c6c-ba28-50f7ddd3465d"), null);
        System.out.println("Find player process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Find player test and self create one
        startTime = System.currentTimeMillis();
        PlayerBean selfPlayer = new PlayerBean(UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeeeee"),"player_1", "the looser", 0, 0, null, null, null, null, 1);
        manager.getPlayer(UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeeeee"), selfPlayer);
        System.out.println("Find and self create player process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Data player update test
        player.setCoins(20);
        player.setStars(10);
        player.setLastIP("100.100.100.100");
        player.setToptpKey("NewKey");
        startTime = System.currentTimeMillis();
        manager.updatePlayer(player);
        System.out.println("Update player process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Create a denunciation with existing player name
        startTime = System.currentTimeMillis();
        denunciationBean = new DenunciationBean(player.getUuid(), new Timestamp(System.currentTimeMillis()), "fly", "mistersatch");
        manager.denouncePlayer(player, denunciationBean);
        System.out.println("Denunciation with name process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Create a denunciation without existing player name
        startTime = System.currentTimeMillis();
        denunciationBean = new DenunciationBean(player.getUuid(), new Timestamp(System.currentTimeMillis()), "fly", "billyboy");
        manager.denouncePlayer(player, denunciationBean);
        System.out.println("Denunciation without process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Create dimensions statistics test
        uuid = UUID.fromString("7b9ffe3f-96d0-41dc-bb2a-93b7c7ba2bcd");
        otherPlayer = new PlayerBean(uuid, "thegreatancien", "the killer", 0, 0, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),"50.50.50.50","AnotherKey", 1);
        dimensionStats = new DimensionStatisticsBean(uuid, 50, 60, 70, 80, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 0);
        startTime = System.currentTimeMillis();
        manager.updateDimensionStatistics(otherPlayer, dimensionStats);
        System.out.println("Create dimension statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Update dimension statistics test
        dimensionStats.setDeaths(0);
        dimensionStats.setPlayedGames(0);
        startTime = System.currentTimeMillis();
        manager.updateDimensionStatistics(otherPlayer, dimensionStats);
        System.out.println("Update dimension statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Read dimension statistics test
        startTime = System.currentTimeMillis();
        manager.getDimensionStatistics(otherPlayer);
        System.out.println("Read dimension statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Create herobattle statistics test
        heroBattleStats = new HeroBattleStatisticsBean(uuid, 10, 20, 50, 8, 4, 2, new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()), 100);
        startTime = System.currentTimeMillis();
        manager.updateHeroBattleStatistics(otherPlayer, heroBattleStats);
        System.out.println("Create herobattle statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Update herobattle statistics test
        heroBattleStats.setKills(1000);
        heroBattleStats.setDeaths(42);
        startTime = System.currentTimeMillis();
        manager.updateHeroBattleStatistics(otherPlayer, heroBattleStats);
        System.out.println("Update herobattle statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Read herobattle statistics test
        startTime = System.currentTimeMillis();
        manager.getHeroBattleStatistics(otherPlayer);
        System.out.println("Read herobattle statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Create jukebox statistics test
        jukeBoxStats = new JukeBoxStatisticsBean(uuid, 10, 20, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 1000);
        startTime = System.currentTimeMillis();
        manager.updateJukeBoxStatistics(otherPlayer, jukeBoxStats);
        System.out.println("Create jukebox statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Update jukebox statistics test
        jukeBoxStats.setWoots(42);
        jukeBoxStats.setMehs(77);
        startTime = System.currentTimeMillis();
        manager.updateJukeBoxStatistics(otherPlayer, jukeBoxStats);
        System.out.println("Update jukebox statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Read jukebox statistics test
        startTime = System.currentTimeMillis();
        manager.getJukeBoxStatistics(otherPlayer);
        System.out.println("Read jukebox statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Create quake statistics test
        quakeStats = new QuakeStatisticsBean(uuid, 10, 20, 30, 5, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 1000);
        startTime = System.currentTimeMillis();
        manager.updateQuakeStatistics(otherPlayer, quakeStats);
        System.out.println("Create quake statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Update quake statistics test
        quakeStats.setDeaths(1000);
        quakeStats.setWins(1);
        startTime = System.currentTimeMillis();
        manager.updateQuakeStatistics(otherPlayer, quakeStats);
        System.out.println("Update quake statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Read quake statistics test
        startTime = System.currentTimeMillis();
        manager.getQuakeStatistics(otherPlayer);
        System.out.println("Read quake statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Create UHCRun statistics test
        uhcRunStats = new UHCRunStatisticsBean(uuid, 10, 20, 30, 50, 3, 1, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),8000);
        startTime = System.currentTimeMillis();
        manager.updateUHCRunStatistics(otherPlayer, uhcRunStats);
        System.out.println("Create UHCRun statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Update UHCRun statistics test
        uhcRunStats.setKills(1000);
        uhcRunStats.setPlayedGames(42);
        startTime = System.currentTimeMillis();
        manager.updateUHCRunStatistics(otherPlayer, uhcRunStats);
        System.out.println("Update UHCRun statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Read UHCRun statistics test
        startTime = System.currentTimeMillis();
        manager.getUHCRunStatistics(otherPlayer);
        System.out.println("Read UHCRun statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Create UpperVoid statistics test
        upperVoidStats = new UppervoidStatisticsBean(uuid, 40, 60, 5, 120, 2, 10, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),6000);
        startTime = System.currentTimeMillis();
        manager.updateUpperVoidStatistics(otherPlayer, upperVoidStats);
        System.out.println("Create UpperVoid statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Update UpperVoid statistics test
        upperVoidStats.setPlayedGames(555);
        startTime = System.currentTimeMillis();
        manager.updateUHCRunStatistics(otherPlayer, uhcRunStats);
        System.out.println("Update UpperVoid statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Read UpperVoid statistics test
        startTime = System.currentTimeMillis();
        manager.getUpperVoidStatistics(otherPlayer);
        System.out.println("Read UpperVoid statistics process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // All statistics read for player test
        startTime = System.currentTimeMillis();
        manager.getAllStatistics(player);
        System.out.println("All statistics read process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Create a ban sanction test
        startTime = System.currentTimeMillis();
        SanctionBean sanction = new SanctionBean(UUID.fromString("7b9ffe3f-96d0-41dc-bb2a-93b7c7ba2bcd"), SanctionBean.BAN, "fly", UUID.fromString("a9ebd2f3-271d-4c6c-ba28-50f7ddd3465d"),
                new Timestamp(System.currentTimeMillis()), false, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        manager.applySanction(SanctionBean.BAN, sanction);
        System.out.println("Create sanction ban process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Create a mute sanction test
        startTime = System.currentTimeMillis();
        sanction = new SanctionBean(UUID.fromString("7b9ffe3f-96d0-41dc-bb2a-93b7c7ba2bcd"), SanctionBean.MUTE, "trololol", UUID.fromString("a9ebd2f3-271d-4c6c-ba28-50f7ddd3465d"),
                new Timestamp(System.currentTimeMillis()+800000), false, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        manager.applySanction(SanctionBean.MUTE, sanction);
        System.out.println("Create sanction mute process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Remove ban sanction test
        startTime = System.currentTimeMillis();
        manager.removeSanction(SanctionBean.BAN, otherPlayer);
        System.out.println("Remove sanction ban process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Check if player is banned test
        startTime = System.currentTimeMillis();
        manager.getPlayerBanned(otherPlayer);
        System.out.println("Check isBanned process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Check if player is muted test
        startTime = System.currentTimeMillis();
        manager.getPlayerMuted(otherPlayer);
        System.out.println("Check isMute process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get API permissions
        startTime = System.currentTimeMillis();
        manager.getAPIPermission(otherPlayer);
        System.out.println("Get API permissions process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get Bukkit permissions
        startTime = System.currentTimeMillis();
        manager.getBukkitPermission(otherPlayer);
        System.out.println("Get Bukkit permissions process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get Bungee & Redis permissions
        startTime = System.currentTimeMillis();
        manager.getBungeeRedisPemission(otherPlayer);
        System.out.println("Get Bungee & Redis permissions process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get Hub permissions
        startTime = System.currentTimeMillis();
        manager.getHubPermission(otherPlayer);
        System.out.println("Get Hub permissions process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get moderation permissions
        startTime = System.currentTimeMillis();
        manager.getModerationPermission(otherPlayer);
        System.out.println("Get moderation permissions process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get proxies permissions
        startTime = System.currentTimeMillis();
        manager.getProxiesPermission(otherPlayer);
        System.out.println("Get proxies permissions process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get staff permissions
        startTime = System.currentTimeMillis();
        manager.getStaffPermission(otherPlayer);
        System.out.println("Get staff permissions process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get UHC permissions
        startTime = System.currentTimeMillis();
        manager.getUHCPermission(otherPlayer);
        System.out.println("Get UHC permissions process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get all permissions
        startTime = System.currentTimeMillis();
        manager.getAllPlayerPermission(otherPlayer);
        System.out.println("Get all permissions process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get group permission for a player
        startTime = System.currentTimeMillis();
        manager.getGroupPlayer(otherPlayer);
        System.out.println("Get group permissions process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Create a friendship demand
        FriendshipBean friendhip = new FriendshipBean(otherPlayer.getUuid(), player.getUuid(), null, null, false);
        startTime = System.currentTimeMillis();
        manager.postFriendshipDemand(friendhip);
        System.out.println("Friendhip demand creation process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get friendship demand list
        startTime = System.currentTimeMillis();
        ArrayList<FriendshipBean> friendshipList = manager.getFriendshipDemandList(player);
        System.out.println("Friendhip get list process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Accept a friendship demand
        startTime = System.currentTimeMillis();
        FriendshipBean friendshipDemand = friendshipList.get(0);
        manager.acceptFriendshipDemand(friendshipDemand);
        System.out.println("Friendship accept demand process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get friendship  list
        startTime = System.currentTimeMillis();
        friendshipList = manager.getFriendshipList(player);
        System.out.println("Friendhip get list process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Refuse a friendship demand
        startTime = System.currentTimeMillis();
        manager.refuseFriendshipDemand(friendshipList.get(0));
        System.out.println("Friendhip refuse demand process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Create a promotion
        startTime = System.currentTimeMillis();
        long time = System.currentTimeMillis();
        PromotionsBean promotionsBean = new PromotionsBean(0, 1, 10, "super promo", new Timestamp(time), new Timestamp(time + 20000));
        PromotionsBean otherPromotionBean = new PromotionsBean(1, 4, 50, "promo", new Timestamp(time), new Timestamp(time + 20000));
        manager.createPromotion(promotionsBean);
        manager.createPromotion(otherPromotionBean);
        System.out.println("Promotion creation process time: " + (System.currentTimeMillis()-startTime)/2 + " ms");

        // Get all active promotion
        startTime = System.currentTimeMillis();
        manager.getAllActivePromotions();
        System.out.println("Get all active promotion process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get specific promotion
        startTime = System.currentTimeMillis();
        otherPromotionBean = manager.getPromotion(0, 1).get(0);
        System.out.println("Get specific promotion process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Delete promotion
        startTime = System.currentTimeMillis();
        manager.deletePromotion(otherPromotionBean);
        System.out.println("Delete promotion process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Permission to hashmap test
        startTime = System.currentTimeMillis();
        APIPermissionsBean bean = new APIPermissionsBean(1, true, false, true, false, true, false, true, false, true, false, true, false, true, false);
        bean.getHashMap();
        System.out.println("Permission to hashmap process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // HashMap permission setup test
        startTime = System.currentTimeMillis();
        bean.set("api.servers.debug",new Boolean(false));
        System.out.println("HashMap permissions setup process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get dimensions leaderboard
        PlayerBean player_2 = new PlayerBean(UUID.fromString("aaaaaaaa-cccc-cccc-dddd-eeeeeeeeeeeeee"),"player_2", "the 2", 0, 0, null, null, null, null, 1);
        manager.getPlayer(UUID.fromString("aaaaaaaa-cccc-cccc-dddd-eeeeeeeeeeeeee"), player_2);
        PlayerBean player_3 = new PlayerBean(UUID.fromString("aaaaaaaa-dddd-cccc-dddd-eeeeeeeeeeeeee"),"player_3", "the 3", 0, 0, null, null, null, null, 1);
        manager.getPlayer(UUID.fromString("aaaaaaaa-dddd-cccc-dddd-eeeeeeeeeeeeee"), player_3);
        uuid = UUID.fromString("aaaaaaaa-cccc-cccc-dddd-eeeeeeeeeeeeee");
        dimensionStats = new DimensionStatisticsBean(uuid, 10, 20, 30, 40, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 0);
        manager.updateDimensionStatistics(player_2, dimensionStats);
        uuid = UUID.fromString("aaaaaaaa-dddd-cccc-dddd-eeeeeeeeeeeeee");
        dimensionStats = new DimensionStatisticsBean(uuid, 100, 200, 300, 400, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 0);
        manager.updateDimensionStatistics(player_3, dimensionStats);
        uuid = UUID.fromString("a9ebd2f3-271d-4c6c-ba28-50f7ddd3465d");
        dimensionStats = new DimensionStatisticsBean(uuid, 1, 2, 3, 4, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 0);
        manager.updateDimensionStatistics(player, dimensionStats);
        startTime = System.currentTimeMillis();
        manager.getDimmensionLeaderBoard("deaths");
        System.out.println("Get dimensions leaderboard process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get herobattle leaderboard
        uuid = UUID.fromString("aaaaaaaa-cccc-cccc-dddd-eeeeeeeeeeeeee");
        heroBattleStats = new HeroBattleStatisticsBean(uuid, 30, 20, 50, 8, 4, 2, new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()), 100);
        manager.updateHeroBattleStatistics(player_2, heroBattleStats);
        uuid = UUID.fromString("aaaaaaaa-dddd-cccc-dddd-eeeeeeeeeeeeee");
        heroBattleStats = new HeroBattleStatisticsBean(uuid, 20, 20, 40, 8, 4, 2, new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()), 100);
        manager.updateHeroBattleStatistics(player_3, heroBattleStats);
        uuid = UUID.fromString("a9ebd2f3-271d-4c6c-ba28-50f7ddd3465d");
        heroBattleStats = new HeroBattleStatisticsBean(uuid, 10, 20, 30, 8, 4, 2, new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()), 100);
        manager.updateHeroBattleStatistics(player, heroBattleStats);
        startTime = System.currentTimeMillis();
        manager.getHeroBattleLeaderBoard("kills");
        System.out.println("Get herobattle leaderboard process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get jukebox leaderboard
        uuid = UUID.fromString("aaaaaaaa-cccc-cccc-dddd-eeeeeeeeeeeeee");
        jukeBoxStats = new JukeBoxStatisticsBean(uuid, 10, 20, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 1000);
        manager.updateJukeBoxStatistics(player_2, jukeBoxStats);
        uuid = UUID.fromString("aaaaaaaa-dddd-cccc-dddd-eeeeeeeeeeeeee");
        jukeBoxStats = new JukeBoxStatisticsBean(uuid, 5, 20, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 1000);
        manager.updateJukeBoxStatistics(player_3, jukeBoxStats);
        uuid = UUID.fromString("a9ebd2f3-271d-4c6c-ba28-50f7ddd3465d");
        jukeBoxStats = new JukeBoxStatisticsBean(uuid, 15, 20, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 1000);
        manager.updateJukeBoxStatistics(player, jukeBoxStats);
        startTime = System.currentTimeMillis();
        manager.getJukeBoxLeaderBoard("mehs");
        System.out.println("Get jukebox leaderboard process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get quake leaderboard
        uuid = UUID.fromString("aaaaaaaa-cccc-cccc-dddd-eeeeeeeeeeeeee");
        quakeStats = new QuakeStatisticsBean(uuid, 10, 20, 30, 5, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 1000);
        manager.updateQuakeStatistics(player_2, quakeStats);
        uuid = UUID.fromString("aaaaaaaa-dddd-cccc-dddd-eeeeeeeeeeeeee");
        quakeStats = new QuakeStatisticsBean(uuid, 10, 20, 40, 5, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 1000);
        manager.updateQuakeStatistics(player_3, quakeStats);
        uuid = UUID.fromString("a9ebd2f3-271d-4c6c-ba28-50f7ddd3465d");
        quakeStats = new QuakeStatisticsBean(uuid, 10, 20, 50, 5, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 1000);
        manager.updateQuakeStatistics(player, quakeStats);
        startTime = System.currentTimeMillis();
        manager.getQuakeLeaderBoard("wins");
        System.out.println("Get quake leaderboard process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get uhcrun leaderboard
        uuid = UUID.fromString("aaaaaaaa-cccc-cccc-dddd-eeeeeeeeeeeeee");
        uhcRunStats = new UHCRunStatisticsBean(uuid, 10, 20, 20, 30, 3, 1, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),8000);
        manager.updateUHCRunStatistics(player_2, uhcRunStats);
        uuid = UUID.fromString("aaaaaaaa-dddd-cccc-dddd-eeeeeeeeeeeeee");
        uhcRunStats = new UHCRunStatisticsBean(uuid, 10, 20, 30, 40, 3, 1, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),8000);
        manager.updateUHCRunStatistics(player_3, uhcRunStats);
        uuid = UUID.fromString("a9ebd2f3-271d-4c6c-ba28-50f7ddd3465d");
        uhcRunStats = new UHCRunStatisticsBean(uuid, 10, 20, 10, 50, 3, 1, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),8000);
        manager.updateUHCRunStatistics(player, uhcRunStats);
        startTime = System.currentTimeMillis();
        manager.getUhcLeaderBoard("kills");
        System.out.println("Get uhcrun leaderboard process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get uppervoid leaderboard
        uuid = UUID.fromString("aaaaaaaa-cccc-cccc-dddd-eeeeeeeeeeeeee");
        upperVoidStats = new UppervoidStatisticsBean(uuid, 40, 60, 5, 120, 2, 10, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),6000);
        manager.updateUpperVoidStatistics(player_2, upperVoidStats);
        uuid = UUID.fromString("aaaaaaaa-dddd-cccc-dddd-eeeeeeeeeeeeee");
        upperVoidStats = new UppervoidStatisticsBean(uuid, 40, 60, 6, 120, 2, 10, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),6000);
        manager.updateUpperVoidStatistics(player_3, upperVoidStats);
        uuid = UUID.fromString("a9ebd2f3-271d-4c6c-ba28-50f7ddd3465d");
        upperVoidStats = new UppervoidStatisticsBean(uuid, 50, 60, 4, 120, 2, 10, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),6000);
        manager.updateUpperVoidStatistics(player, upperVoidStats);
        startTime = System.currentTimeMillis();
        manager.getUpperVoidLeaderBoard("kills");
        System.out.println("Get uppervoid leaderboard process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Create player settings test
        startTime = System.currentTimeMillis();
        manager.createDefaultPlayerSettings(otherPlayer);
        System.out.println("Create default player settings process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Get player settings test
        startTime = System.currentTimeMillis();
        PlayerSettingsBean settings = manager.getPlayerSettings(otherPlayer);
        System.out.println("Get player settings process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Update player settings test
        settings.setAllowClickOnOther(false);
        settings.setClickOnMeActivation(false);
        startTime = System.currentTimeMillis();
        manager.setPlayerSettings(otherPlayer, settings);
        System.out.println("Update player settings process time: " + (System.currentTimeMillis()-startTime) + " ms");

    }
}
