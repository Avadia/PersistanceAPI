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

package net.samagames.persistanceapi.beans.internationalization;

import java.beans.ConstructorProperties;

public class SentenceBean
{
    /* Database structure

    Table : languages_sentences
    +-------------------+--------------+------+-----+--------------+-------+
    | Field             | Type         | Null | Key | Default      | Extra |
    +-------------------+--------------+------+-----+--------------+-------+
    | sentence_id       | int(11)      | NO   | PRI | NULL         |       |
    | language_id       | int(11)      | NO   |     | NULL         |       |
    | game_category     | tinyint(4)   | NO   |     | NULL         |       |
    | sentence_text     | varchar(255) | NO   |     | Non définie  |       |
    +-------------------+--------------+------+-----+--------------+-------+
    */

    // Defines
    private int sentenceId;
    private int languageId;
    private int gameCategory;
    private String sentenceText;

    // Constructor
    @ConstructorProperties({"sentenceId", "languageId", "gameCategory", "sentenceText"})
    public SentenceBean(int sentenceId, int languageId, int gameCategory, String sentenceText)
    {
        this.sentenceId = sentenceId;
        this.languageId = languageId;
        this.gameCategory = gameCategory;
        this.sentenceText = sentenceText;
    }

    // Getters
    public int getSentenceId() { return this.sentenceId; }
    public int getLanguageId() { return this.languageId; }
    public int getGameCategory() { return this.gameCategory; }
    public String getSentenceText() { return this.sentenceText; }

    // Setters

    public void setSentenceId(int sentenceId) {
        this.sentenceId = sentenceId;
    }
    public void setLanguageId(int languageId) { this.languageId = languageId; }
    public void setGameCategory(int gameCategory) { this.gameCategory = gameCategory; }
    public void setSentenceText(String sentenceText) { this.sentenceText = sentenceText; }
}
