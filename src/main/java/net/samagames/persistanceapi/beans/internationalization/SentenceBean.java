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
    | project_id        | tinyint(4)   | NO   |     | NULL         |       |
    | sentence_text     | varchar(255) | NO   |     | Non définie  |       |
    +-------------------+--------------+------+-----+--------------+-------+
    */

    // Defines
    private int sentenceId;
    private int languageId;
    private int projectId;
    private String sentenceText;

    // Constructor
    @ConstructorProperties({"sentenceId", "languageId", "projectId", "sentenceText"})
    public SentenceBean(int sentenceId, int languageId, int projectId, String sentenceText)
    {
        this.sentenceId = sentenceId;
        this.languageId = languageId;
        this.projectId = projectId;
        this.sentenceText = sentenceText;
    }

    // Getters
    public int getSentenceId() { return this.sentenceId; }
    public int getLanguageId() { return this.languageId; }
    public int getProjectId() { return this.projectId; }
    public String getSentenceText() { return this.sentenceText; }

    // Setters

    public void setSentenceId(int sentenceId) {
        this.sentenceId = sentenceId;
    }
    public void setLanguageId(int languageId) { this.languageId = languageId; }
    public void setProjectId(int projectId) { this.projectId = projectId; }
    public void setSentenceText(String sentenceText) { this.sentenceText = sentenceText; }
}
