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
  By MisterSatch, July 2016
===============================================================
*/

package net.samagames.persistanceapi.datamanager;

import net.samagames.persistanceapi.beans.achievements.AchievementBean;
import net.samagames.persistanceapi.beans.achievements.AchievementCategoryBean;
import net.samagames.persistanceapi.beans.achievements.AchievementProgressBean;
import net.samagames.persistanceapi.utils.Transcoder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AchievementManager
{
    // Defines
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null;

    // Get the category by ID
    public AchievementCategoryBean getAchievementCategory(int categoryId, DataSource dataSource) throws Exception
    {
        try
        {
            // Defines
            AchievementCategoryBean achievementCategory = null;

            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select category_name, category_description, item_minecraft_id, parent_id from achievement_categories";
            sql += " where category_id=" + categoryId;

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if(resultset.next())
            {
                // There's a result
                String categoryName = resultset.getString("category_name");
                String categoryDescription = resultset.getString("category_description");
                String itemMinecraftId = resultset.getString("item_minecraft_id");
                int parentId = resultset.getInt("parent_id");
                achievementCategory = new AchievementCategoryBean(categoryId, categoryName, categoryDescription, itemMinecraftId, parentId);
            }

            return achievementCategory;
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

    // Get the categories
    public List<AchievementCategoryBean> getAchievementCategories(DataSource dataSource) throws Exception
    {
        try
        {
            // Defines
            List<AchievementCategoryBean> achievementCategories = new ArrayList<>();

            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select category_name, category_description, item_minecraft_id, parent_id from achievement_categories";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while (resultset.next())
            {
                // There's a result
                int categoryId = resultset.getInt("category_id");
                String categoryName = resultset.getString("category_name");
                String categoryDescription = resultset.getString("category_description");
                String itemMinecraftId = resultset.getString("item_minecraft_id");
                int parentId = resultset.getInt("parent_id");
                achievementCategories.add(new AchievementCategoryBean(categoryId, categoryName, categoryDescription, itemMinecraftId, parentId));
            }

            return achievementCategories;
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

    // Get the achievement by ID
    public AchievementBean getAchievement(int achievementId, DataSource dataSource) throws Exception
    {
        try
        {
            // Defines
            AchievementBean achievement = null;

            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select achievement_name, achievement_description, progress_target, category_id from achievements";
            sql += " where achievement_id=" + achievementId;

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if(resultset.next())
            {
                // There's a result
                String achievementName = resultset.getString("achievement_name");
                String achievementDescription = resultset.getString("achievement_description");
                int progressTarget = resultset.getInt("progress_target");
                int categoryId = resultset.getInt("category_id");
                achievement = new AchievementBean(achievementId, achievementName, achievementDescription, progressTarget, categoryId);
            }

            return achievement;
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

    // Get achievement progress by UUID, create if unknown
    public AchievementProgressBean getAchievementProgress(AchievementProgressBean progress, DataSource dataSource) throws Exception
    {
        // Make the research of player by UUID
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select (HEX(uuid_player)) as uuid_player, progress_id, achievement_id, progress, start_date, unlock_date from achievements_progress where uuid_player=(UNHEX('"+ Transcoder.Encode(progress.getUuidPlayer().toString())+"'))";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if (resultset.next())
            {
                // There's a result
                String playerUuid = Transcoder.Decode(resultset.getString("uuid_player"));
                long progressId = resultset.getLong("progress_id");
                int achievementId = resultset.getInt("achievement_id");
                int achievementProgress = resultset.getInt("progress");
                Timestamp startDate = resultset.getTimestamp("start_date");
                Timestamp unlockDate = resultset.getTimestamp("unlock_date");
                progress = new AchievementProgressBean(progressId, achievementId, achievementProgress, startDate, unlockDate, UUID.fromString(playerUuid));
                return progress;
            }
            else
            {
                // If there no achievement progress for the uuid in database create a new achievement progress
                this.close();
                this.createAchievementProgress(progress, dataSource);
                AchievementProgressBean newAchievementProgress = this.getAchievementProgress(progress, dataSource);
                this.close();
                return newAchievementProgress;
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

    // Update the achievement progress data
    public void updateAchievementProgress(AchievementProgressBean progress, DataSource dataSource) throws Exception
    {
        // Update the players data
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "update achievements_progress set progress=" + progress.getProgress();
            sql += ", start_date='" + progress.getStartDate() + "'";
            sql += ", unlock_date=" + progress.getUnlockDate();
            sql += " where progress_id=" + progress.getProgressId();

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

    // Create the achievement progress
    public void createAchievementProgress(AchievementProgressBean progress, DataSource dataSource) throws Exception
    {
        // Create the player
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "insert into achievements_progress (achievement_id, progress, start_date, unlock_date, uuid_player)";
            sql += "values '" + progress.getAchievementId() + "'";
            sql += ", '0'";
            sql += ", now()";
            sql +=", NULL";
            sql +=", (UNHEX('"+ Transcoder.Encode(progress.getUuidPlayer().toString())+"')";

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
