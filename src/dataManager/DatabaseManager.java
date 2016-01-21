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

package DataManager;

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

    // Default constructor
    public DatabaseManager()
    {
        // Super constructor
        super();
        this.setupDataSource();
    }

    // Singleton generator
    public final static DatabaseManager getInstance()
    {
        if (DatabaseManager.instance == null)
        {
            synchronized(DatabaseManager.class)
            {
                if (DatabaseManager.instance == null)
                {
                    DatabaseManager.instance = new DatabaseManager();
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
        dataSource.setUrl("jdbc:mysql://127.0.0.1:8889/samagames"); //TODO Externalize
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        // Set minimal pool size to 1
        dataSource.setInitialSize(1); //TODO Externalize
        // Set maximal pool size to 10
        dataSource.setMaxTotal(10); //TODO Externalize
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
