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

import net.samagames.persistanceapi.beans.shop.ItemDescriptionBean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemManager
{
    // Defines
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null;

    // Get the item by ID
    public ItemDescriptionBean getItemDescription(int intemId, DataSource dataSource) throws Exception
    {
        // Get item
        try
        {
            // Defines
            ItemDescriptionBean itemDescription = null;

            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "select item_id, item_name, item_desc, price_coins, price_stars, game_category, item_minecraft_id, item_rarity, rank_accessibility";
            sql += " from item_description where item_id=" + intemId;

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while (resultset.next())
            {
                // There's a result
                int itemId = resultset.getInt("item_id");
                String itemName = resultset.getString("item_name");
                String itemDesc = resultset.getString("item_desc");
                int priceCoins = resultset.getInt("price_coins");
                int priceStars = resultset.getInt("price_stars");
                int gameCategory = resultset.getInt("game_category");
                String itemMinecraftId = resultset.getString("item_minecraft_id");
                String itemRarity = resultset.getString("item_rarity");
                String rankAccessiblity = resultset.getString("rank_accessibility");
                itemDescription = new ItemDescriptionBean(itemId, itemName, itemDesc, priceCoins, priceStars, gameCategory, itemMinecraftId, itemRarity, rankAccessiblity);

            }
            return itemDescription;
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

    // Get all the item description
    public List<ItemDescriptionBean> getAllItemDescription(DataSource dataSource) throws Exception
    {
        // Get item
        try
        {
            // Defines
            ItemDescriptionBean itemDescription = null;

            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            List<ItemDescriptionBean> itemList = new ArrayList<>();

            // Query construction
            String sql = "select item_id, item_name, item_desc, price_coins, price_stars, game_category, item_minecraft_id, item_rarity, rank_accessibility";
            sql += " from item_description";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while (resultset.next())
            {
                // There's a result
                int itemId = resultset.getInt("item_id");
                String itemName = resultset.getString("item_name");
                String itemDesc = resultset.getString("item_desc");
                int priceCoins = resultset.getInt("price_coins");
                int priceStars = resultset.getInt("price_stars");
                int gameCategory = resultset.getInt("game_category");
                String itemMinecraftId = resultset.getString("item_minecraft_id");
                String itemRarity = resultset.getString("item_rarity");
                String rankAccessiblity = resultset.getString("rank_accessibility");
                itemDescription = new ItemDescriptionBean(itemId, itemName, itemDesc, priceCoins, priceStars, gameCategory, itemMinecraftId, itemRarity, rankAccessiblity);
                itemList.add(itemDescription);
            }
            return itemList;
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
