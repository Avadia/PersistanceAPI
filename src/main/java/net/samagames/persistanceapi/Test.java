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
import net.samagames.persistanceapi.beans.statistics.DimensionStatisticsBean;

import java.sql.Timestamp;
import java.util.UUID;

public class Test
{
    public static void main (String[] args)
    {
        // Defines
        long startTime;
        DimensionStatisticsBean dimensionStats;
        DenunciationBean denunciationBean;
        UUID uuid;
        PlayerBean player;
        PlayerBean otherPlayer;

        // Initialize the manager
        System.out.println("Exécution du test");
        System.out.println("-----------------");
        GameServiceManager manager = new GameServiceManager("jdbc:mysql://127.0.0.1:8889/samagamesV3", "root","root", 1, 10);

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
        player = new PlayerBean(UUID.fromString("a9ebd2f3-271d-4c6c-ba28-50f7ddd3465d"), "mistersatch", 0, 0, new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),"125.125.125.125","TheUltimateKey");
        manager.createPlayer(player);
        System.out.println("Create player process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Find a player test
        startTime = System.currentTimeMillis();
        player = manager.getPlayer(UUID.fromString("a9ebd2f3-271d-4c6c-ba28-50f7ddd3465d"), player);
        System.out.println("Find player process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Find player test and self create one
        startTime = System.currentTimeMillis();
        PlayerBean selfPlayer = new PlayerBean(UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeeeee"),"gasper", 0, 0, null, null, null, null);
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

        // Dimension statistics read for player test
        startTime = System.currentTimeMillis();
        manager.getDimensionStatistics(player);
        System.out.println("Dimension statistics read process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // HeroBattle statistics read for player test
        startTime = System.currentTimeMillis();
        manager.getHeroBattleStatistics(player);
        System.out.println("HeroBattle statistics read process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // JukeBox statistics read for player test
        startTime = System.currentTimeMillis();
        manager.getJukeBoxStatistics(player);
        System.out.println("JukeBox statistics read process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Quake statistics read for player test
        startTime = System.currentTimeMillis();
        manager.getQuakeStatistics(player);
        System.out.println("Quake statistics read process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // UHCRun statistics read for player test
        startTime = System.currentTimeMillis();
        manager.getUHCRunStatistics(player);
        System.out.println("UHCRun statistics read process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // UpperVoid statistics read for player test
        startTime = System.currentTimeMillis();
        manager.getUpperVoidStatistics(player);
        System.out.println("UpperVoid statistics read process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // All statistics read for player test
        startTime = System.currentTimeMillis();
        manager.getAllStatistics(player);
        System.out.println("All statistics read process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Create dimensions statistics test
        uuid = UUID.fromString("7b9ffe3f-96d0-41dc-bb2a-93b7c7ba2bcd");
        otherPlayer = new PlayerBean(uuid, "thegreatancien", 0, 0, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),"50.50.50.50","AnotherKey");
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

        // Create a ban sanction test
        startTime = System.currentTimeMillis();
        SanctionBean sanction = new SanctionBean(UUID.fromString("7b9ffe3f-96d0-41dc-bb2a-93b7c7ba2bcd"), SanctionBean.BAN, "fly", UUID.fromString("a9ebd2f3-271d-4c6c-ba28-50f7ddd3465d"),
                new Timestamp(System.currentTimeMillis()), false, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        manager.applySanction(SanctionBean.BAN, sanction);
        System.out.println("Create sanction ban process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Create a mute sanction test
        startTime = System.currentTimeMillis();
        sanction = new SanctionBean(UUID.fromString("7b9ffe3f-96d0-41dc-bb2a-93b7c7ba2bcd"), SanctionBean.MUTE, "trololol", UUID.fromString("a9ebd2f3-271d-4c6c-ba28-50f7ddd3465d"),
                new Timestamp(System.currentTimeMillis()), false, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        manager.applySanction(SanctionBean.MUTE, sanction);
        System.out.println("Create sanction mute process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Check if player is banned test

        // Check if player is muted test

        // Remove ban sanction test


     }
}
