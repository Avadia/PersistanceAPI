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

import net.samagames.persistanceapi.beans.internationalization.LanguageBean;
import net.samagames.persistanceapi.beans.internationalization.SentenceBean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LanguageManager
{
    // Defines
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null;

    // Get the languages available for the internationalization
    public List<LanguageBean> getAllLanguages(DataSource dataSource) throws Exception
    {
        // Defines
        List<LanguageBean> languageBeans = new ArrayList<>();

        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select language_id, language_code, language_name";
            sql += " from languages";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while (resultset.next())
            {
                // There's a result
                int languageId = resultset.getInt("language_id");
                String languageCode = resultset.getString("language_code");
                String languageName = resultset.getString("language_name");

                languageBeans.add(new LanguageBean(languageId, languageCode, languageName));
            }

            return languageBeans;
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

    // Get the language available for the internationalization by id
    public LanguageBean getLanguage(int languageId, DataSource dataSource) throws Exception
    {
        // Defines
        LanguageBean languageBean = null;

        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select language_id, language_code, language_name";
            sql += " from languages";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if (resultset.next())
            {
                // There's a result
                String languageCode = resultset.getString("language_code");
                String languageName = resultset.getString("language_name");

                languageBean = new LanguageBean(languageId, languageCode, languageName);
                return languageBean;
            }
            else
            {
                // The language requested is not found
                return null;
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
            close();
        }
    }

    // Get the sentences available for the internationalization
    public List<SentenceBean> getAllSentences(DataSource dataSource) throws Exception
    {
        // Defines
        List<SentenceBean> sentenceBeens = new ArrayList<>();

        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select sentence_id, language_id, game_category, sentence_text";
            sql += " from languages_sentences";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while (resultset.next())
            {
                // There's a result
                int sentenceId = resultset.getInt("sentence_id");
                int languageId = resultset.getInt("language_id");
                int gameCategory = resultset.getInt("game_category");
                String sentenceText = resultset.getString("sentence_text");

                sentenceBeens.add(new SentenceBean(sentenceId, languageId, gameCategory, sentenceText));
            }

            return sentenceBeens;
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

    // Get the sentences available for the internationalization of the provided language
    public List<SentenceBean> getLanguageSentences(LanguageBean languageBean, DataSource dataSource) throws Exception
    {
        // Defines
        List<SentenceBean> sentenceBeens = new ArrayList<>();

        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select sentence_id, game_category, sentence_text";
            sql += " from languages_sentences where language_id = " + languageBean.getLanguageId();

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while (resultset.next())
            {
                // There's a result
                int sentenceId = resultset.getInt("sentence_id");
                int gameCategory = resultset.getInt("game_category");
                String sentenceText = resultset.getString("sentence_text");

                sentenceBeens.add(new SentenceBean(sentenceId, languageBean.getLanguageId(), gameCategory, sentenceText));
            }

            return sentenceBeens;
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

    // Get the sentences available for the internationalization of the provided game
    public List<SentenceBean> getGameSentences(int gameCategory, DataSource dataSource) throws Exception
    {
        // Defines
        List<SentenceBean> sentenceBeens = new ArrayList<>();

        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select sentence_id, language_id, sentence_text";
            sql += " from languages_sentences where game_category = " + gameCategory;

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while (resultset.next())
            {
                // There's a result
                int sentenceId = resultset.getInt("sentence_id");
                int languageId = resultset.getInt("language_id");
                String sentenceText = resultset.getString("sentence_text");

                sentenceBeens.add(new SentenceBean(sentenceId, languageId, gameCategory, sentenceText));
            }

            return sentenceBeens;
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
