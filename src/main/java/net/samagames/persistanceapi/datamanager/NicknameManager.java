
package net.samagames.persistanceapi.datamanager;

import net.samagames.persistanceapi.beans.players.NicknameBean;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class NicknameManager
{
    // Defines
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null;

    // Get a random nickname
    public NicknameBean getRandomNickname(DataSource dataSource) throws Exception
    {
        // get a free random nickname
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select nick_id, nickname, blacklisted, used from nickname where blacklisted=0 and used=0 order by rand() limit 1";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            if (resultset.next())
            {
                // There's a result
                long nick_id = resultset.getInt("nick_id");
                String nickname = resultset.getString("nickname");
                boolean blacklisted = resultset.getBoolean("blacklisted");
                boolean used = resultset.getBoolean("used");
                NicknameBean nicknameBean = new NicknameBean(nick_id, nickname, blacklisted, used);
                this.close();
                this.reserveNickname(nicknameBean.getNickId(), dataSource);
                return nicknameBean;
            }
            else
            {
                // If there no more free nickname
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
            this.close();
        }
    }

    // Check if a nickname is blacklisted
    public boolean isNicknameBlacklisted(String nickname, DataSource dataSource) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select nick_id from nickname where nickname='" + nickname + "' and blacklisted=1";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // If there'a a result
            if (resultset.next())
            {
                // There's a result
                return true;
            }
            else
            {
                // If there no more free nickname
                return false;
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
            this.close();
        }
    }

    // Reserve a nickname
    private void reserveNickname(long nick_id, DataSource dataSource) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "update nickname set used=true where nick_id=" + nick_id;

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

    // Free a nickname
    public void freeNickname(String nickname, DataSource dataSource) throws Exception
    {
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "update nickname set used=false where nickname='" + nickname +"'";

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
