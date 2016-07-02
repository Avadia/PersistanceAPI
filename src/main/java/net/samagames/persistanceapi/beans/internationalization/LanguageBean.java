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

public class LanguageBean
{
    /* Database structure

    Table : languages
    +-------------------+--------------+------+-----+--------------+-------+
    | Field             | Type         | Null | Key | Default      | Extra |
    +-------------------+--------------+------+-----+--------------+-------+
    | language_id       | int(11)      | NO   | PRI | NULL         |       |
    | language_code     | varchar(16)  | NO   |     | NULL         |       |
    | language_name     | varchar(255) | NO   |     | Non définie  |       |
    +-------------------+--------------+------+-----+--------------+-------+
    */

    // Defines
    private int languageId;
    private String languageCode;
    private String languageName;

    // Constructor
    @ConstructorProperties({"languageId", "languageCode", "languageName"})
    public LanguageBean(int languageId, String languageCode, String languageName)
    {
        this.languageId = languageId;
        this.languageCode = languageCode;
        this.languageName = languageName;
    }

    // Getters
    public int getLanguageId() { return this.languageId; }
    public String getGameCategory() { return this.languageCode; }
    public String setLanguageName() { return this.languageName; }

    // Setters

    public void setLanguageId(int languageId) { this.languageId = languageId; }
    public void setLanguageCode(String languageCode) { this.languageCode = languageCode; }
    public void setLanguageName(String languageName) { this.languageName = languageName; }
}
