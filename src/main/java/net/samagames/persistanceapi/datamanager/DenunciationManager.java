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

import net.samagames.persistanceapi.beans.DenunciationBean;
import net.samagames.persistanceapi.beans.PlayerBean;
import net.samagames.persistanceapi.utils.Transcoder;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class DenunciationManager
{
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
    boolean nestedQuery = false;

    // Denunciation by a player
    public void denouncePlayer(PlayerBean player, DenunciationBean denunciation, DataSource dataSource, PlayerManager playerManager)
    {
        // Create denunciation
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Set flag for nested query
            this.nestedQuery = true;

            UUID suspectUUID = playerManager.recoverSuspect(denunciation.getSuspect_name(), dataSource);

            // Query construction
            String sql = "";
            sql += "insert into denunciation (denouncer, suspect, date, reason, suspect_name)";
            sql += " values (UNHEX('" + Transcoder.Encode(player.getUuid().toString()) + "')";
            if (suspectUUID != null)
            {
                sql += ", UNHEX('" + Transcoder.Encode(suspectUUID.toString()) + "')";
            }
            else
            {
                sql += ", NULL";
            }
            sql += ", now()";
            sql += ", '" + denunciation.getReason() + "'";
            sql += ", '" + denunciation.getSuspect_name() + "')";

            // Execute the query
            statement.executeUpdate(sql);
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            // Set flag for nested query
            this.nestedQuery = false;

            // Close the query environment in order to prevent leaks
            close();
        }
    }

    // Close the connection
    public void close()
    {
        // Close the query environment in order to prevent leaks
        try
        {
            if (resultset != null)
            {
                // Close the resulset
                resultset.close();
            }
            if (statement != null)
            {
                // Close the statement
                statement.close();
            }
            if (connection != null && this.nestedQuery == false)
            {
                // Close the connection
                connection.close();
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
    }
}
