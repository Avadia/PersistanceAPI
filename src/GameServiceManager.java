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

import Beans.PlayerBean;
import DataManager.DatabaseManager;
import DataManager.PlayerManager;
import DataManager.SamaritanManager;

public class GameServiceManager
{
    // Defines attributes
    public DatabaseManager databaseManager;
    public PlayerManager playerManager;
    public SamaritanManager samaritanManager;

    // Super constructor
    public GameServiceManager()
    {
        // Singleton of DatabaseManager
        this.databaseManager = DatabaseManager.getInstance();
        this.playerManager = new PlayerManager();

    }



    /*============================================
      Part of player Manager
    ============================================*/

    // Get the player by UUID
    public PlayerBean getPlayer(String uuid)
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



    /*============================================
      Part of samaritan Manager
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
}
