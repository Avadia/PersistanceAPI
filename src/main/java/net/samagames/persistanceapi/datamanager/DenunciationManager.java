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

import net.samagames.persistanceapi.beans.players.DenunciationBean;
import net.samagames.persistanceapi.beans.players.PlayerBean;
import net.samagames.persistanceapi.utils.Transcoder;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

public class DenunciationManager
{
    // Defines
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null;

    // Denunciation by a player
    public void denouncePlayer(PlayerBean player, DenunciationBean denunciation, DataSource dataSource, PlayerManager playerManager) throws Exception
    {
        // Create denunciation
        try
        {
            // Retrieve suspect UUID
            UUID suspectUUID = playerManager.recoverSuspect(denunciation.getSuspect_name(), dataSource);

            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "insert into denunciations (denouncer, date, reason, suspect_name)";
            sql += " values (UNHEX('" + Transcoder.Encode(player.getUuid().toString()) + "')";
            sql += ", now()";
            sql += ", '" + denunciation.getReason() + "'";
            sql += ", '" + denunciation.getSuspect_name() + "')";

            // Execute the query
            statement.executeUpdate(sql);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
    }

    // Close the connection
    public void close() throws Exception
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
            if (connection != null)
            {
                // Close the connection
                connection.close();
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
    }
}
