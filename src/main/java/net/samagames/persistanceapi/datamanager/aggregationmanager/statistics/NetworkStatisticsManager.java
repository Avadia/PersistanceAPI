package net.samagames.persistanceapi.datamanager.aggregationmanager.statistics;

import net.samagames.persistanceapi.beans.players.PlayerBean;
import net.samagames.persistanceapi.beans.statistics.LeaderboardBean;
import net.samagames.persistanceapi.beans.statistics.NetworkStatisticsBean;
import net.samagames.persistanceapi.utils.Transcoder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * ╱╲＿＿＿＿＿＿╱╲
 * ▏╭━━╮╭━━╮▕
 * ▏┃＿＿┃┃＿＿┃▕
 * ▏┃＿▉┃┃▉＿┃▕
 * ▏╰━━╯╰━━╯▕
 * ╲╰╰╯╲╱╰╯╯╱  Created by Silvanosky on 08/08/2016
 * ╱╰╯╰╯╰╯╰╯╲
 * ▏▕╰╯╰╯╰╯▏▕
 * ▏▕╯╰╯╰╯╰▏▕
 * ╲╱╲╯╰╯╰╱╲╱
 * ＿＿╱▕▔▔▏╲＿＿
 * ＿＿▔▔＿＿▔▔＿＿
 */
public class NetworkStatisticsManager {
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;

    // Get Network player statistics
    public NetworkStatisticsBean getNetworkStatistics(PlayerBean player, DataSource dataSource) throws Exception
    {
        NetworkStatisticsBean networkStats = null;
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select (HEX(uuid)) as uuid, creation_date, update_date, played_time from network_stats";
            sql +=" where uuid=(UNHEX('"+ Transcoder.Encode(player.getUuid().toString())+"'))";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if (resultset.next())
            {
                // There's a result
                String playerUuid = Transcoder.Decode(resultset.getString("uuid"));
                UUID uuid = UUID.fromString(playerUuid);
                Timestamp creationDate = resultset.getTimestamp("creation_date");
                Timestamp updateDate = resultset.getTimestamp("update_date");
                long playedTime = resultset.getLong("played_time");
                networkStats = new NetworkStatisticsBean(uuid, creationDate, updateDate, playedTime);
            }
            else
            {
                // If there no HeroBattle stats int the database create empty one
                this.close();
                this.createEmptyNetworkStatistics(player, dataSource);
                this.close();
                NetworkStatisticsBean newNetworkStats = this.getNetworkStatistics(player,dataSource);
                this.close();
                return newNetworkStats;
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            this.close();
        }
        return networkStats;
    }

    // Create an empty network statistics
    private void createEmptyNetworkStatistics(PlayerBean player, DataSource dataSource) throws Exception
    {
        try
        {
            // Create an empty bean
            NetworkStatisticsBean networkStats = new NetworkStatisticsBean(player.getUuid(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 0);

            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction for create
            String sql = "";
            sql += "insert into jukebox_stats (uuid, creation_date, update_date, played_time)";
            sql += " values (UNHEX('"+ Transcoder.Encode(player.getUuid().toString())+"')";
            sql += ", now()";
            sql += ", now()";
            sql += ", played_time=" + networkStats.getPlayedTime() + ")";

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
            this.close();
        }
    }

    // Update Network player statistics
    public void updateNetworkStatistics(PlayerBean player, NetworkStatisticsBean networkStats, DataSource dataSource) throws Exception
    {
        try
        {
            // Check if a record exists
            if (this.getNetworkStatistics(player, dataSource) == null)
            {
                // Create an empty jukebox statistics
                this.createEmptyNetworkStatistics(player, dataSource);
            }
            else
            {
                // Set connection
                connection = dataSource.getConnection();
                statement = connection.createStatement();

                // Query construction for update
                String sql = "";
                sql += "update network_stats set";
                sql += "update_date=now()";
                sql += ", played_time=" + networkStats.getPlayedTime();
                sql += " where uuid=(UNHEX('"+ Transcoder.Encode(player.getUuid().toString())+"'))";

                // Execute the query
                statement.executeUpdate(sql);
            }
        }
        catch(Exception exception)
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

    // Get the board for this game
    public List<LeaderboardBean> getLeaderBoard(String category, DataSource dataSource) throws Exception
    {
        List<LeaderboardBean> leaderBoard = new ArrayList<>();
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "select p.name as name, d." + category + " as score from players as p, network_stats as d where p.uuid=d.uuid order by d." + category + " desc limit 3";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while(resultset.next())
            {
                LeaderboardBean bean = new LeaderboardBean(resultset.getString("name"), resultset.getInt("score"));
                leaderBoard.add(bean);
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            this.close();
        }
        return leaderBoard;
    }

    // Close all connection
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
