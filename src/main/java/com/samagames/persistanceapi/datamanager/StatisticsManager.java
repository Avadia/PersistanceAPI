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

package com.samagames.persistanceapi.datamanager;

import com.samagames.persistanceapi.beans.PlayerBean;
import com.samagames.persistanceapi.beans.PlayerStatisticsBean;
import com.samagames.persistanceapi.beans.aggregationbean.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatisticsManager
{
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;
    DimensionStatisticsBean dimensionStats = null;
    HeroBattleStatisticsBean heroBattleStats = null;
    JukeBoxStatisticsBean jukeBoxStats = null;
    QuakeStatisticsBean quakeStats = null;
    UHCRunStatisticsBean uhcRunStats = null;
    UppervoidStatistics uppervoidStats = null;

    // Get Dimension player statistics
    public DimensionStatisticsBean getDimensionStatistics(PlayerBean player, DataSource dataSource)
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            resultset.next();
        }
        catch(SQLException e)
        {
            e.printStackTrace(); //TODO Change the granularity of exception
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
        return dimensionStats;
    }

    // Get HeroBattle palyer statistics
    public HeroBattleStatisticsBean getHeroBattleStatistics(PlayerBean player, DataSource dataSource)
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            resultset.next();
        }
        catch(SQLException e)
        {
            e.printStackTrace(); //TODO Change the granularity of exception
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
        return heroBattleStats;
    }

    // Get JukeBox player statistics
    public JukeBoxStatisticsBean getJukeBoxStatistics(PlayerBean player, DataSource dataSource)
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            resultset.next();
        }
        catch(SQLException e)
        {
            e.printStackTrace(); //TODO Change the granularity of exception
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
        return jukeBoxStats;
    }

    // Get Quake player statistics
    public QuakeStatisticsBean getQuakeStatistics(PlayerBean player, DataSource dataSource)
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            resultset.next();
        }
        catch(SQLException e)
        {
            e.printStackTrace(); //TODO Change the granularity of exception
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
        return quakeStats;
    }

    // Get UHCRun player statistics
    public UHCRunStatisticsBean getUHCRunStatistics(PlayerBean player, DataSource dataSource)
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            resultset.next();
        }
        catch(SQLException e)
        {
            e.printStackTrace(); //TODO Change the granularity of exception
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
        return uhcRunStats;
    }

    // Get UpperVoid player statistics
    public UppervoidStatistics getUpperVoidStatistics(PlayerBean player, DataSource dataSource)
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            resultset.next();
        }
        catch(SQLException e)
        {
            e.printStackTrace(); //TODO Change the granularity of exception
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
        return uppervoidStats;
    }

    // Get all player statistics
    public PlayerStatisticsBean getAllPlayerStatistics(PlayerBean player, DataSource dataSource)
    {
        // Get the different statistics bean
        DimensionStatisticsBean dimensionStats = this.getDimensionStatistics(player, dataSource);
        HeroBattleStatisticsBean heroBattleStats = this.getHeroBattleStatistics(player, dataSource);
        JukeBoxStatisticsBean jukeBoxStats = this.getJukeBoxStatistics(player, dataSource);
        QuakeStatisticsBean quakeStats = this.getQuakeStatistics(player, dataSource);
        UHCRunStatisticsBean uhcRunStatcs = this.getUHCRunStatistics(player, dataSource);
        UppervoidStatistics upperVoidStats = this.getUpperVoidStatistics(player, dataSource);
        // Create the aggregation of different statistics bean
        PlayerStatisticsBean playerStatisticsBean = new PlayerStatisticsBean(dimensionStats, heroBattleStats, jukeBoxStats, quakeStats, uhcRunStatcs, upperVoidStats);
        return playerStatisticsBean;
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
            if (connection != null)
            {
                // Close the connection
                connection.close();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace(); //TODO Change the granularity of exception
        }
    }

}
