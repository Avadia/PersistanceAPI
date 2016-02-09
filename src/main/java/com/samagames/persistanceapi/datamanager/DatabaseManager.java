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

import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/*============================================
  Database DataManager
============================================*/
public class DatabaseManager
{
    // Defines attributes
    public static volatile DatabaseManager instance = null;
    public DataSource dataSource = null;
    private String url;
    private String name;
    private String password;

    // Default constructor
    public DatabaseManager(String url, String name, String password)
    {
        // Super constructor
        super();
        this.url = url;
        this.name = name;
        this.password = password;
        this.setupDataSource();
    }

    // Singleton generator
    public final static DatabaseManager getInstance(String url, String name, String password)
    {
        if (DatabaseManager.instance == null)
        {
            synchronized(DatabaseManager.class)
            {
                if (DatabaseManager.instance == null)
                {
                    DatabaseManager.instance = new DatabaseManager(url, name, password);
                }
            }
        }
        return DatabaseManager.instance;
    }

    // Initialize the data source
    public void setupDataSource()
    {
        // Set a JDBC/MySQL connection
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver"); //TODO Externalize
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.name);
        dataSource.setPassword(this.password);
        // Set minimal pool size to 1
        dataSource.setInitialSize(1);
        // Set maximal pool size to 10
        dataSource.setMaxTotal(10);
        this.dataSource = dataSource;
    }

    public DataSource getDataSource()
    {
        // Return the datasource
        return this.dataSource;
    }

    // Get the data sources stats
    public void getSourcesStats(DataSource dataSource)
    {
        BasicDataSource basicDataSource = (BasicDataSource) dataSource;
        System.out.println("Number of active: " + basicDataSource.getNumActive());
        System.out.println("Number of idle: " + basicDataSource.getNumIdle());
    }

    // Shutdown the data source
    public void shutdownDataSource(DataSource dataSource) throws SQLException
    {
        BasicDataSource basicDataSource = (BasicDataSource) dataSource;
        basicDataSource.close();
    }
}
