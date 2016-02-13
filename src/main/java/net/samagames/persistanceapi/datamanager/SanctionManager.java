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

package net.samagames.persistanceapi.datamanager;

import net.samagames.persistanceapi.beans.PlayerBean;
import net.samagames.persistanceapi.beans.SanctionBean;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SanctionManager
{
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;

    // Ban a player
    public void banPlayer(PlayerBean player, DataSource dataSource)
    {
        // Do
        //
    }

    // Check if a player is banned
    public boolean isPlayerBanned(PlayerBean player, DataSource dataSource)
    {
        // Do
        //
        return false;
    }

    // Remove ban from player
    public void removeBan(PlayerBean player, DataSource dataSource)
    {
        // Do
        //
    }

    // Mute a player
    public void mutePlayer(PlayerBean player, DataSource dataSource)
    {
        // Do
        //
    }

    // Check if a player is muted
    public boolean isPlayerMuted(PlayerBean player, DataSource dataSource)
    {
        // Do
        //
        return false;
    }

    // Remove mute from player
    public void removeMute(PlayerBean player, DataSource dataSource)
    {

    }

    // Kick a player
    public void kickPlayer(PlayerBean player, DataSource dataSource)
    {

    }
}
