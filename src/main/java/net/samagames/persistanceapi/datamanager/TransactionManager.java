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

import net.samagames.persistanceapi.beans.players.PlayerBean;
import net.samagames.persistanceapi.beans.shop.TransactionBean;
import net.samagames.persistanceapi.utils.Transcoder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransactionManager
{
    // Defines
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null;
    public List<TransactionBean> transactionList = new ArrayList<>();

    // Get all the player transactions
    public List<TransactionBean> getPlayerTransactions(PlayerBean player, DataSource dataSource) throws Exception
    {
        // Get all transactions
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "select transaction_id, item_id, price_coins, price_stars, transaction_date, selected, uuid_buyer from transaction_shop";
            sql += " where uuid_buyer=(UNHEX('"+ Transcoder.Encode(player.getUuid().toString())+"'))";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while (resultset.next())
            {
                // There's a result
                long transactionId = resultset.getLong("transaction_id");
                int item_id = resultset.getInt("item_id");
                int priceCoins = resultset.getInt("price_coins");
                int priceStars = resultset.getInt("price_stars");
                Timestamp transactionDate = resultset.getTimestamp("transaction_date");
                boolean selected = resultset.getBoolean("selected");
                String uuidBuyer = resultset.getString("uuid_buyer");
                UUID buyer = UUID.fromString(uuidBuyer);
                TransactionBean transaction = new TransactionBean(transactionId, item_id, priceCoins, priceStars, transactionDate, selected, buyer);
                transactionList.add(transaction);
            }
            return transactionList;
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

    // Get all the selected player transactions
    public List<TransactionBean> getPlayerSelectedTransactions(PlayerBean player, DataSource dataSource) throws Exception
    {
        // Get all selected transactions
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "select transaction_id, item_id, price_coins, price_stars, transaction_date, selected, uuid_buyer from transaction_shop";
            sql += " where uuid_buyer=(UNHEX('"+ Transcoder.Encode(player.getUuid().toString())+"'))";
            sql += " and selected=true";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while (resultset.next())
            {
                // There's a result
                long transactionId = resultset.getLong("transaction_id");
                int item_id = resultset.getInt("item_id");
                int priceCoins = resultset.getInt("price_coins");
                int priceStars = resultset.getInt("price_stars");
                Timestamp transactionDate = resultset.getTimestamp("transaction_date");
                boolean selected = resultset.getBoolean("selected");
                String uuidBuyer = resultset.getString("uuid_buyer");
                UUID buyer = UUID.fromString(uuidBuyer);
                TransactionBean transaction = new TransactionBean(transactionId, item_id, priceCoins, priceStars, transactionDate, selected, buyer);
                transactionList.add(transaction);
            }
            return transactionList;
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

    // Get all the selected player transactions for a game
    public List<TransactionBean> getPlayerGameSelectedTransactions(PlayerBean player, DataSource dataSource, int selectedGame) throws Exception
    {
        // Get all selected transactions for a game
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "select transaction_id, item_id, price_coins, price_stars, transaction_date, selected, uuid_buyer from transaction_shop, item_description";
            sql += " where uuid_buyer=(UNHEX('"+ Transcoder.Encode(player.getUuid().toString())+"'))";
            sql += " and selected=true";
            sql += " and item_description.item_id=transaction_shop.item_id";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while (resultset.next())
            {
                // There's a result
                long transactionId = resultset.getLong("transaction_id");
                int item_id = resultset.getInt("item_id");
                int priceCoins = resultset.getInt("price_coins");
                int priceStars = resultset.getInt("price_stars");
                Timestamp transactionDate = resultset.getTimestamp("transaction_date");
                boolean selected = resultset.getBoolean("selected");
                String uuidBuyer = resultset.getString("uuid_buyer");
                UUID buyer = UUID.fromString(uuidBuyer);
                TransactionBean transaction = new TransactionBean(transactionId, item_id, priceCoins, priceStars, transactionDate, selected, buyer);
                transactionList.add(transaction);
            }
            return transactionList;
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
