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

import java.util.UUID;

public class Test
{
    public static void main (String[] args)
    {
        // Defines
        long startTime;

        // Initialize the manager
        System.out.println("Exécution du test");
        System.out.println("-----------------");
        GameServiceManager manager = new GameServiceManager();

        // Find a player test
        startTime = System.currentTimeMillis();
        PlayerBean player = manager.getPlayer(UUID.fromString("a9ebd2f3-271d-4c6c-ba28-50f7ddd3465d"));
        System.out.println("Find player process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Data player update test
        startTime = System.currentTimeMillis();
        player.setCoins(20);
        player.setStars(10);
        manager.updatePlayer(player);
        System.out.println("Update player process time: " + (System.currentTimeMillis()-startTime) + " ms");

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

        // All statistics read for player test
        startTime = System.currentTimeMillis();
        manager.getAllStatistics(player);
        System.out.println("All statistics read process time: " + (System.currentTimeMillis()-startTime) + " ms");
    }
}
