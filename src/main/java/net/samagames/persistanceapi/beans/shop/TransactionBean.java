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
    | item_id          | int(11)    | YES  | MUL | NULL                |                |
    | price_coins      | int(11)    | YES  |     | NULL                |                |
    | price_stars      | int(11)    | YES  |     | NULL                |                |
    | transaction_date | timestamp  | NO   |     | 0000-00-00 00:00:00 |                |
    | selected         | bit(1)     | NO   |     | NULL                |                |
    | uuid_buyer       | binary(16) | NO   |     | NULL                |                |
    +------------------+------------+------+-----+---------------------+----------------+
    */

    // Defines
    private long transactionId;
    private int item_id;
    private int priceCoins;
    private int priceStars;
    private Timestamp transactionDate;
    private boolean selected;
    private UUID uuidBuyer;

    // Constructor
    public TransactionBean(long transactionId, int item_id, int priceCoins, int priceStars, Timestamp transactionDate, boolean selected, UUID uuidBuyer)
    {
        this.transactionId = transactionId;
        this.item_id = item_id;
        this.priceCoins = priceCoins;
        this.priceStars = priceStars;
        this.transactionDate = transactionDate;
        this.selected = selected;
        this.uuidBuyer = uuidBuyer;
    }

    // Getters
    public long getTransactionId() { return this.transactionId; }
    public int getItem_id() { return this.item_id; }
    public int getPriceCoins() { return this.priceCoins; }
    public int getPriceStars() { return this.priceStars; }
    public Timestamp getTransactionDate() { return this.transactionDate; }
    public boolean isSelected() { return this.selected; }
    public UUID getUuidBuyer() { return this.uuidBuyer; }

    // Setters
    public void setItem_id(int item_id) { this.item_id = item_id; }
    public void setPriceCoins(int priceCoins) { this.priceCoins = priceCoins; }
    public void setPriceStars(int priceStars) { this.priceStars = priceStars; }
    public void setTransactionDate(Timestamp transactionDate) { this.transactionDate = transactionDate; }
    public void setSelected(boolean selected) { this.selected = selected; }
    public void setUuidBuyer(UUID uuidBuyer) { this.uuidBuyer = uuidBuyer; }
}
