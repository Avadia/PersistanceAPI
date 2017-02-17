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

import net.samagames.persistanceapi.beans.shop.PromotionsBean;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PromotionsManager
{
    // Defines
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultset = null;

    // Get all the promotions
    public List<PromotionsBean> getAllActivePromotions(DataSource dataSource) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            List<PromotionsBean> promotionList = new ArrayList<>();

            // Query construction
            String sql = "select promotion_id, type_id, game, multiplier, message, start_date, end_date from promotions where end_date > now()";

            statement = connection.prepareStatement(sql);

            // Execute the query
            resultset = statement.executeQuery();

            // Manage the result in a bean
            while(resultset.next())
            {
                // Manage the result in a list of bean
                long promitionId = resultset.getLong("promotion_id");
                int typePromotion = resultset.getInt("type_id");
                int game = resultset.getInt("game");
                int multiplier = resultset.getInt("multiplier");
                String message = resultset.getString("message");
                Timestamp startDate = resultset.getTimestamp("start_date");
                Timestamp endDate = resultset.getTimestamp("end_date");
                PromotionsBean promotionsBean = new PromotionsBean(promitionId, typePromotion, game, multiplier, message, startDate, endDate);
                promotionList.add(promotionsBean);
            }
            return promotionList;
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

    // Get a special promotions
    public List<PromotionsBean> getPromotion(DataSource dataSource, int typeId, int game) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            List<PromotionsBean> promotionList = new ArrayList<>();

            // Query construction
            String sql = "select promotion_id, type_id, game, multiplier, message, start_date, end_date from promotions where end_date > now()";
            sql += " and type_id = ? and game = ?";

            statement = connection.prepareStatement(sql);
            statement.setInt(1, typeId);
            statement.setInt(2, game);

            // Execute the query
            resultset = statement.executeQuery();

            // Manage the result in a bean
            while(resultset.next())
            {
                // Manage the result in a list of bean
                long promotionId = resultset.getLong("promotion_id");
                int multiplier = resultset.getInt("multiplier");
                String message = resultset.getString("message");
                Timestamp startDate = resultset.getTimestamp("start_date");
                Timestamp endDate = resultset.getTimestamp("end_date");
                PromotionsBean promotionsBean = new PromotionsBean(promotionId, typeId, game, multiplier, message, startDate, endDate);
                promotionList.add(promotionsBean);
            }
            return promotionList;
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

    // Create a promotion
    public void createPromotion(PromotionsBean promotionsBean, DataSource dataSource) throws Exception
    {
        try {
            // Set connection
            connection = dataSource.getConnection();

            // Query construction
            String sql = "insert into promotions (type_id, game, multiplier, message, start_date, end_date) values (?, ?, ?, ?, ?, ?)";

            statement = connection.prepareStatement(sql);
            statement.setInt(1, promotionsBean.getPromotionType());
            statement.setInt(2, promotionsBean.getGame());
            statement.setInt(3, promotionsBean.getMultiplier());
            statement.setString(4, promotionsBean.getMessage());
            statement.setString(5, promotionsBean.getStartDate().toString());
            statement.setString(6, promotionsBean.getEndDate().toString());

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


    // Delete a promotion
    public void deletePromotion(PromotionsBean promotionsBean, DataSource dataSource) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();

            // Query construction
            String sql = "delete from promotions where promotion_id = ?";

            statement = connection.prepareStatement(sql);
            statement.setLong(1, promotionsBean.getPromotionId());

            // Execute the query
            statement.executeUpdate(sql);
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
