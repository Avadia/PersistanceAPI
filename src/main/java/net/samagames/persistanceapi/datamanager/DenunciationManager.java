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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

public class DenunciationManager
{
    // Defines
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultset = null;

    // Denunciation by a player
    public void denouncePlayer(PlayerBean player, DenunciationBean denunciation, DataSource dataSource) throws Exception
    {
        // Create denunciation
        try
        {
            // Set connection
            connection = dataSource.getConnection();

            // Query construction
            String sql = "insert into denunciations (denouncer, date, reason, suspect_name) values (UNHEX(?), now(), ?, ?)";

            statement = connection.prepareStatement(sql);
            statement.setString(1, Transcoder.encode(player.getUuid().toString()));
            statement.setString(2, denunciation.getReason());
            statement.setString(3, denunciation.getSuspectName());

            // Execute the query
            statement.executeUpdate();
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
