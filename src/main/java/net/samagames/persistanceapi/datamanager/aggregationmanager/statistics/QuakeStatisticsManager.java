package net.samagames.persistanceapi.datamanager.aggregationmanager.statistics;

import net.samagames.persistanceapi.beans.players.PlayerBean;
import net.samagames.persistanceapi.beans.statistics.LeaderboardBean;
import net.samagames.persistanceapi.beans.statistics.QuakeStatisticsBean;
import net.samagames.persistanceapi.utils.Transcoder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
 * This file is part of PersistanceAPI.
 *
 * PersistanceAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PersistanceAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PersistanceAPI.  If not, see <http://www.gnu.org/licenses/>.
 */
public class QuakeStatisticsManager {
    // Defines
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultset = null;

    // Get quake player statistics
    public QuakeStatisticsBean getQuakeStatistics(PlayerBean player, DataSource dataSource) throws Exception {
        QuakeStatisticsBean quakeStats;

        try {
            // Set connection
            connection = dataSource.getConnection();

            // Query construction
            String sql = "select HEX(uuid) as uuid, deaths, kills, played_games, wins, creation_date, update_date, played_time from quake_stats where uuid = UNHEX(?)";

            statement = connection.prepareStatement(sql);
            statement.setString(1, Transcoder.encode(player.getUuid().toString()));

            // Execute the query
            resultset = statement.executeQuery();

            // Manage the result in a bean
            if (resultset.next()) {
                // There's a result
                String playerUuid = Transcoder.decode(resultset.getString("uuid"));
                UUID uuid = UUID.fromString(playerUuid);
                int deaths = resultset.getInt("deaths");
                int kills = resultset.getInt("kills");
                int playedGames = resultset.getInt("played_games");
                int wins = resultset.getInt("wins");
                Timestamp creationDate = resultset.getTimestamp("creation_date");
                Timestamp updateDate = resultset.getTimestamp("update_date");
                long playedTime = resultset.getLong("played_time");

                quakeStats = new QuakeStatisticsBean(uuid, deaths, kills, playedGames, wins, creationDate, updateDate, playedTime);
            } else {
                // If there no quake stats int the database create empty one
                this.close();
                this.createEmptyQuakeStatistics(player, dataSource);
                this.close();

                QuakeStatisticsBean newQuakeStats = this.getQuakeStatistics(player, dataSource);
                this.close();

                return newQuakeStats;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        } finally {
            // Close the query environment in order to prevent leaks
            this.close();
        }

        return quakeStats;
    }

    // Create an empty quake statistics
    private void createEmptyQuakeStatistics(PlayerBean player, DataSource dataSource) throws Exception {
        try {
            // Create empty bean
            QuakeStatisticsBean quakeStats = new QuakeStatisticsBean(player.getUuid(), 0, 0, 0, 0, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 0);

            // Set connection
            connection = dataSource.getConnection();

            // Query construction for create
            String sql = "insert into quake_stats (uuid, deaths, kills, played_games, wins, creation_date, update_date, played_time) values (UNHEX(?), ?, ?, ?, ?, now(), now(), ?)";

            statement = connection.prepareStatement(sql);
            statement.setString(1, Transcoder.encode(player.getUuid().toString()));
            statement.setInt(2, quakeStats.getDeaths());
            statement.setInt(3, quakeStats.getKills());
            statement.setInt(4, quakeStats.getPlayedGames());
            statement.setInt(5, quakeStats.getWins());
            statement.setLong(6, quakeStats.getPlayedTime());

            // Execute the query
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        } finally {
            // Close the query environment in order to prevent leaks
            this.close();
        }
    }

    // Update quake player statistics
    public void updateQuakeStatistics(PlayerBean player, QuakeStatisticsBean quakeStats, DataSource dataSource) throws Exception {
        try {
            // Check if a record exists
            if (this.getQuakeStatistics(player, dataSource) == null) {
                // Create an empty quake statistics
                this.createEmptyQuakeStatistics(player, dataSource);
            } else {

                // Set connection
                connection = dataSource.getConnection();

                // Query construction for update
                String sql = "update quake_stats set deaths = ?, kills = ?, played_games = ?, wins = ?, update_date = now(), played_time = ? where uuid = UNHEX(?)";

                statement = connection.prepareStatement(sql);
                statement.setInt(1, quakeStats.getDeaths());
                statement.setInt(2, quakeStats.getKills());
                statement.setInt(3, quakeStats.getPlayedGames());
                statement.setInt(4, quakeStats.getWins());
                statement.setLong(5, quakeStats.getPlayedTime());
                statement.setString(6, Transcoder.encode(player.getUuid().toString()));

                // Execute the query
                statement.executeUpdate();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        } finally {
            // Close the query environment in order to prevent leaks
            close();
        }
    }

    // Get the board for this game
    public List<LeaderboardBean> getLeaderBoard(String category, DataSource dataSource) throws Exception {
        List<LeaderboardBean> leaderBoard = new ArrayList<>();
        try {
            // Set connection
            connection = dataSource.getConnection();

            // Query construction
            String sql = String.format("select p.name as name, d.%1$s as score from players as p, quake_stats as d where p.uuid = d.uuid order by d.%2$s desc limit 3", category, category);

            statement = connection.prepareStatement(sql);

            // Execute the query
            resultset = statement.executeQuery();

            // Manage the result in a bean
            while (resultset.next()) {
                LeaderboardBean bean = new LeaderboardBean(resultset.getString("name"), resultset.getInt("score"));
                leaderBoard.add(bean);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        } finally {
            // Close the query environment in order to prevent leaks
            close();
        }
        return leaderBoard;
    }

    // Close all connection
    public void close() throws Exception {
        // Close the query environment in order to prevent leaks
        try {
            if (resultset != null) {
                // Close the resulset
                resultset.close();
            }
            if (statement != null) {
                // Close the statement
                statement.close();
            }
            if (connection != null) {
                // Close the connection
                connection.close();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }
}
