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

import net.samagames.persistanceapi.beans.statistics.HostStatisticsBean;
import net.samagames.persistanceapi.utils.Transcoder;

import javax.sql.DataSource;
import java.sql.*;

public class HostManager
{
    // Defines
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultset = null;

    // Create a record of host statistic
    public void createHostRecord(HostStatisticsBean hostStatisticsBean, DataSource dataSource) throws Exception
    {
        // Create the player
        try
        {
            // Set connection
            connection = dataSource.getConnection();

            // Query construction
            String sql = "insert into host_stats (template_id, host_id, ip_address, player_uuid, started_time, played_time) values (?, ?, ?, UNHEX(?), ?, ?)";

            statement = connection.prepareStatement(sql);
            statement.setString(1, hostStatisticsBean.getTemplateId());
            statement.setString(2, hostStatisticsBean.getHostId());
            statement.setString(3, hostStatisticsBean.getIpAddress());
            statement.setString(4, Transcoder.encode(hostStatisticsBean.getPlayerUuid().toString()));
            statement.setString(5, new Timestamp(hostStatisticsBean.getStartedTime()).toString());
            statement.setLong(6, hostStatisticsBean.getPlayedTime());

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
            this.close();
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
