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

package net.samagames.persistanceapi.beans.shop;

import java.beans.ConstructorProperties;
import java.sql.Timestamp;
import java.util.UUID;

public class TransactionBean
{
    /* Database structure

    Table : transaction_shop
    +------------------+------------+------+-----+---------------------+----------------+
    | Field            | Type       | Null | Key | Default             | Extra          |
    +------------------+------------+------+-----+---------------------+----------------+
    | transaction_id   | bigint(20) | NO   | PRI | NULL                | auto_increment |
    | itemId          | int(11)    | YES  | MUL | NULL                |                |
    | price_coins      | int(11)    | YES  |     | NULL                |                |
    | price_stars      | int(11)    | YES  |     | NULL                |                |
    | transaction_date | timestamp  | NO   |     | 0000-00-00 00:00:00 |                |
    | selected         | bit(1)     | NO   |     | NULL                |                |
    | uuid_buyer       | binary(16) | NO   |     | NULL                |                |
    +------------------+------------+------+-----+---------------------+----------------+
    */

    // Defines
    private long transactionId;
    private int itemId;
    private int priceCoins;
    private int priceStars;
    private Timestamp transactionDate;
    private boolean selected;
    private UUID uuidBuyer;

    // Constructor
    @ConstructorProperties({"transactionId", "itemId", "priceCoins", "priceStars", "transactionDate", "selected", "uuidBuyer"})
    public TransactionBean(long transactionId, int itemId, int priceCoins, int priceStars, Timestamp transactionDate, boolean selected, UUID uuidBuyer)
    {
        this.transactionId = transactionId;
        this.itemId = itemId;
        this.priceCoins = priceCoins;
        this.priceStars = priceStars;
        this.transactionDate = transactionDate;
        this.selected = selected;
        this.uuidBuyer = uuidBuyer;
    }

    // Getters
    public long getTransactionId() { return this.transactionId; }
    public int getItemId() { return this.itemId; }
    public int getPriceCoins() { return this.priceCoins; }
    public int getPriceStars() { return this.priceStars; }
    public Timestamp getTransactionDate() { return this.transactionDate; }
    public boolean isSelected() { return this.selected; }
    public UUID getUuidBuyer() { return this.uuidBuyer; }

    // Setters

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }
    public void setItemId(int itemId) { this.itemId = itemId; }
    public void setPriceCoins(int priceCoins) { this.priceCoins = priceCoins; }
    public void setPriceStars(int priceStars) { this.priceStars = priceStars; }
    public void setTransactionDate(Timestamp transactionDate) { this.transactionDate = transactionDate; }
    public void setSelected(boolean selected) { this.selected = selected; }
    public void setUuidBuyer(UUID uuidBuyer) { this.uuidBuyer = uuidBuyer; }
}
