package net.samagames.persistanceapi.datamanager.aggregationmanager.statistics;

import net.samagames.persistanceapi.beans.players.PlayerBean;
import net.samagames.persistanceapi.beans.statistics.LeaderboardBean;
import net.samagames.persistanceapi.beans.statistics.TheDropperMapStatisticsBean;
import net.samagames.persistanceapi.beans.statistics.TheDropperStatisticsBean;
import net.samagames.persistanceapi.utils.Transcoder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *                )\._.,--....,'``.
 * .b--.        /;   _.. \   _\  (`._ ,.
 * `=,-,-'~~~   `----(,_..'--(,_..'`-.;.'
 *
 * Created by Jérémy L. (BlueSlime) on 25/02/2017
 */
public class TheDropperStatisticsManager
{
    // Defines
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultset = null;

    // Get the dropper player statistics
    public TheDropperStatisticsBean getTheDropperStatistics(PlayerBean player, DataSource dataSource) throws Exception
    {
        TheDropperStatisticsBean theDropperStats = null;

        try
        {
            // Set connection
            connection = dataSource.getConnection();

            // Query construction
            String sql = "select HEX(uuid) as uuid, creation_date, update_date, played_time from thedropper_stats where uuid = UNHEX(?)";

            statement = connection.prepareStatement(sql);
            statement.setString(1, Transcoder.encode(player.getUuid().toString()));

            // Execute the query
            resultset = statement.executeQuery();

            // Manage the result in a bean
            if (resultset.next())
            {
                // There's a result
                String playerUuid = Transcoder.decode(resultset.getString("uuid"));
                UUID uuid = UUID.fromString(playerUuid);
                Timestamp creationDate = resultset.getTimestamp("creation_date");
                Timestamp updateDate = resultset.getTimestamp("update_date");
                long playedTime = resultset.getLong("played_time");

                theDropperStats = new TheDropperStatisticsBean(uuid, creationDate, updateDate, playedTime);
            }
            else
            {
                // If there no the dropper stats in the database create empty one
                this.close();
                this.createEmptyTheDropperStatistics(player, dataSource);
                this.close();

                TheDropperStatisticsBean newTheDropperStats = this.getTheDropperStatistics(player,dataSource);
                this.close();

                return newTheDropperStats;
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

        return theDropperStats;
    }

    // Get the dropper map player statistics
    public TheDropperMapStatisticsBean getTheDropperMapStatistics(PlayerBean player, String mapName, DataSource dataSource) throws Exception
    {
        TheDropperMapStatisticsBean theDropperMapStats = null;

        try
        {
            // Set connection
            connection = dataSource.getConnection();

            // Query construction
            String sql = "select HEX(uuid) as uuid, tries, wins, best_time from thedropper_maps_stats where uuid = UNHEX(?) and map_name = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, Transcoder.encode(player.getUuid().toString()));
            statement.setString(2, mapName);

            // Execute the query
            resultset = statement.executeQuery();

            // Manage the result in a bean
            if (resultset.next())
            {
                // There's a result
                String playerUuid = Transcoder.decode(resultset.getString("uuid"));
                UUID uuid = UUID.fromString(playerUuid);
                int tries = resultset.getInt("tries");
                int wins = resultset.getInt("wins");
                long bestTime = resultset.getLong("best_time");

                theDropperMapStats = new TheDropperMapStatisticsBean(uuid, mapName, tries, wins, bestTime);
            }
            else
            {
                // If there no the dropper map stats in the database create empty one
                this.close();
                this.createEmptyTheDropperMapStatistics(player, mapName, dataSource);
                this.close();

                TheDropperMapStatisticsBean newTheDropperMapStats = this.getTheDropperMapStatistics(player, mapName, dataSource);
                this.close();

                return newTheDropperMapStats;
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

        return theDropperMapStats;
    }

    // Create an empty the dropper statistics
    private void createEmptyTheDropperStatistics(PlayerBean player, DataSource dataSource) throws Exception
    {
        try
        {
            // Create an empty bean
            TheDropperStatisticsBean theDropperStats = new TheDropperStatisticsBean(player.getUuid(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 0);

            // Set connection
            connection = dataSource.getConnection();

            // Query construction for create
            String sql = "insert into thedropper_stats (uuid, creation_date, update_date, played_time) values (UNHEX(?), now(), now(), ?)";

            statement = connection.prepareStatement(sql);
            statement.setString(1, Transcoder.encode(player.getUuid().toString()));
            statement.setLong(2, theDropperStats.getPlayedTime());

            // Execute the query
            statement.executeUpdate();
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

    // Create an empty the dropper map statistics
    private void createEmptyTheDropperMapStatistics(PlayerBean player, String mapName, DataSource dataSource) throws Exception
    {
        try
        {
            // Create an empty bean
            TheDropperMapStatisticsBean theDropperMapStats = new TheDropperMapStatisticsBean(player.getUuid(), mapName, 0, 0, 0);

            // Set connection
            connection = dataSource.getConnection();

            // Query construction for create
            String sql = "insert into thedropper_maps_stats (uuid, map_name, tries, wins, best_time) values (UNHEX(?), ?, ?, ?, ?)";

            statement = connection.prepareStatement(sql);
            statement.setString(1, Transcoder.encode(player.getUuid().toString()));
            statement.setString(2, theDropperMapStats.getMapName());
            statement.setInt(3, theDropperMapStats.getTries());
            statement.setInt(4, theDropperMapStats.getWins());
            statement.setLong(5, theDropperMapStats.getBestTime());

            // Execute the query
            statement.executeUpdate();
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

    // Update the dropper player statistics
    public void updateTheDropperStatistics(PlayerBean player, TheDropperStatisticsBean theDropperStats, DataSource dataSource) throws Exception
    {
        try
        {
            // Check if a record exists
            if (this.getTheDropperStatistics(player, dataSource) == null)
            {
                // Create an empty the dropper statistics
                this.createEmptyTheDropperStatistics(player, dataSource);
            }
            else
            {
                // Set connection
                connection = dataSource.getConnection();

                // Query construction for update
                String sql = "update thedropper_stats set update_date = now(), played_time = ? where uuid = UNHEX(?)";

                statement = connection.prepareStatement(sql);
                statement.setLong(1, theDropperStats.getPlayedTime());
                statement.setString(2, Transcoder.encode(player.getUuid().toString()));

                // Execute the query
                statement.executeUpdate();
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

    // Update the dropper map player statistics
    public void updateTheDropperMapStatistics(PlayerBean player, TheDropperMapStatisticsBean theDropperMapStats, DataSource dataSource) throws Exception
    {
        try
        {
            // Check if a record exists
            if (this.getTheDropperMapStatistics(player, theDropperMapStats.getMapName(), dataSource) == null)
            {
                // Create an empty the dropper map statistics
                this.createEmptyTheDropperMapStatistics(player, theDropperMapStats.getMapName(), dataSource);
            }
            else
            {
                // Set connection
                connection = dataSource.getConnection();

                // Query construction for update
                String sql = "update thedropper_maps_stats set map_name = ?, tries = ?, wins = ?, best_time = ? where uuid = UNHEX(?)";

                statement = connection.prepareStatement(sql);
                statement.setString(1, theDropperMapStats.getMapName());
                statement.setInt(2, theDropperMapStats.getTries());
                statement.setInt(3, theDropperMapStats.getWins());
                statement.setLong(4, theDropperMapStats.getBestTime());
                statement.setString(5, Transcoder.encode(player.getUuid().toString()));

                // Execute the query
                statement.executeUpdate();
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

            // Query construction
            String sql = String.format("select p.name as name, d.%1$s as score from players as p, thedropper_stats as d where p.uuid = d.uuid order by d.%2$s desc limit 3", category, category);

            statement = connection.prepareStatement(sql);

            // Execute the query
            resultset = statement.executeQuery();

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

    // Get the board for this map
    public List<LeaderboardBean> getMapLeaderBoard(String category, DataSource dataSource) throws Exception
    {
        List<LeaderboardBean> leaderBoard = new ArrayList<>();
        try
        {
            // Set connection
            connection = dataSource.getConnection();

            // Query construction
            String sql = String.format("select p.name as name, d.%1$s as score from players as p, thedropper_maps_stats as d where p.uuid = d.uuid order by d.%2$s desc limit 3", category, category);

            statement = connection.prepareStatement(sql);

            // Execute the query
            resultset = statement.executeQuery();

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
