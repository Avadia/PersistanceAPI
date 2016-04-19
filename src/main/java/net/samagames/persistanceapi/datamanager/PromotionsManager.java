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

public class PromotionsManager
{
    // Defines
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null;
    public ArrayList<PromotionsBean> promotionList = new ArrayList<>(); // Fixme see for concurrency !
    //List promotionList = Collections.synchronizedList(new ArrayList<PromotionsBean>);

    // Get all the promotions
    public ArrayList<PromotionsBean> getAllActivePromotions(DataSource dataSource) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select promotion_id, type_id, game, multiplier, message, start_date, end_date from promotions where end_date>now()";

            // Execute the query
            resultset = statement.executeQuery(sql);

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
            close();
        }
    }

    // Get a special promotions
    public ArrayList<PromotionsBean> getPromotion(DataSource dataSource, int typePromotion, int typeGame) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select promotion_id, type_id, game, multiplier, message, start_date, end_date from promotions where end_date>now()";
            sql += " and type_id=" + typePromotion;
            sql += " and game=" + typeGame;

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while(resultset.next())
            {
                // Manage the result in a list of bean
                long promotionId = resultset.getLong("promotion_id");
                int type = resultset.getInt("type_id");
                int game = resultset.getInt("game");
                int multiplier = resultset.getInt("multiplier");
                String message = resultset.getString("message");
                Timestamp startDate = resultset.getTimestamp("start_date");
                Timestamp endDate = resultset.getTimestamp("end_date");
                PromotionsBean promotionsBean = new PromotionsBean(promotionId, type, game, multiplier, message, startDate, endDate);
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
            close();
        }
    }

    // Create a promotion
    public void createPromotion(PromotionsBean promotionsBean, DataSource dataSource) throws Exception
    {
        try {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "insert into promotions(type_id, game, multiplier, message, start_date, end_date)";
            sql += " values (" + promotionsBean.getTypePromotion();
            sql += ", " + promotionsBean.getGame() + "";
            sql += ", " + promotionsBean.getMultiplier();
            sql += ", '" + promotionsBean.getMessage() + "'";
            sql += ", '" + promotionsBean.getStartDate() + "'";
            sql += ", '" + promotionsBean.getEndDate() + "')";

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
            close();
        }
    }


    // Delete a promotion
    public void deletePromotion(PromotionsBean promotionsBean, DataSource dataSource) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "delete from promotions where promotion_id=" + promotionsBean.getPromotionId();

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
            close();
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
