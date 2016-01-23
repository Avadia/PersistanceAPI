package com.samagames.persistanceapi;/*
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

import com.samagames.persistanceapi.beans.PlayerBean;

public class Test
{
    public static void main (String[] args)
    {
        // Defines
        long startTime;

        // Initialize the manager
        GameServiceManager manager = new GameServiceManager();

        // Find a player test
        startTime = System.currentTimeMillis();
        PlayerBean player = manager.getPlayer("a9ebd2f3-271d-4c6c-ba28-50f7ddd3465d");
        System.out.println("Find player process time: " + (System.currentTimeMillis()-startTime) + " ms");

        // Data player update test
        startTime = System.currentTimeMillis();
        player.setCoins(20);
        player.setStars(10);
        manager.updatePlayer(player);
        System.out.println("Update player process time: " + (System.currentTimeMillis()-startTime) + " ms");
    }
}
