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

import net.samagames.persistanceapi.beans.PlayerBean;
import net.samagames.persistanceapi.beans.SanctionBean;
import net.samagames.persistanceapi.utils.Transcoder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.UUID;

public class SanctionManager
{
    // Defines
    Connection connection = null;
    Statement statement = null;
    ResultSet resultset = null;

    // Create a sanction
    public void applySanction(int sanctionType, SanctionBean sanction, DataSource dataSource)
    {
        // Create the sanction
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "insert into sanctions (player_uuid, type_id, reason, punisher_uuid, expiration_date, is_deleted, creation_date, update_date) values (";
            sql += "UNHEX('" + Transcoder.Encode(sanction.getPlayerUuid().toString()) + "')";
            sql += ", " + sanctionType;
            sql += ", '" + sanction.getReason() + "'";
            sql += ", UNHEX('" + Transcoder.Encode(sanction.getPunisherUuid().toString()) +"')";
            sql += ", '" + sanction.getExpirationTime() + "'";
            sql += ", false";
            sql += ", now()";
            sql += ", now())";

            // Execute the query
            statement.executeUpdate(sql);
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
    }

    // Remove a sanction
    public void removeSanction(int sanctionType, PlayerBean player, DataSource dataSource)
    {
        // Remove the last active sanction
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "update sanctions set is_deleted=true where type_id=";
            sql += sanctionType + " and player_uuid=UNHEX('" + Transcoder.Encode(player.getUuid().toString()) +"')";
            sql += " order by creation_date desc limit 1";

            // Execute the query
            statement.executeUpdate(sql);
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
    }

    // Check if a player is banned
    public SanctionBean getPlayerBanned(PlayerBean player, DataSource dataSource)
    {
        // Defines
        SanctionBean sanction = null;

        // Do the check of ban
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select sanction_id, (HEX(player_uuid)) as uuid , type_id, reason, (HEX(punisher_uuid)) as punisher, expiration_date, is_deleted, creation_date, update_date from sanctions";
            sql += " where player_uuid=UNHEX('" + Transcoder.Encode(player.getUuid().toString()) +"')";
            sql += " and type_id=" + SanctionBean.BAN;
            sql += " and expiration_date>now()";
            sql += " and is_deleted=false";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result
            if (resultset.next())
            {
                // The player is banned
                String banPlayer = Transcoder.Decode(resultset.getString("uuid"));
                UUID playerUuid = UUID.fromString(banPlayer);
                int typeId = resultset.getInt("");
                String reason = resultset.getString("");
                String punisher = Transcoder.Decode(resultset.getString("punisher"));
                UUID punisherUuid = UUID.fromString(punisher);
                Timestamp expirationTime = resultset.getTimestamp("");
                boolean isDeleted = resultset.getBoolean("");
                Timestamp creationDate = resultset.getTimestamp("");
                Timestamp updateDate = resultset.getTimestamp("");
                sanction = new SanctionBean(playerUuid, typeId, reason, punisherUuid, expirationTime, isDeleted, creationDate, updateDate);
                return sanction;
            }
            else
            {
                // The player is not banned
                return null;
            }
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
        return null;
    }

    // Check if a player is muted
    public SanctionBean getPlayerMuted(PlayerBean player, DataSource dataSource)
    {
        // Defines
        SanctionBean sanction = null;

        // Do the check of mute
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "select sanction_id, (HEX(player_uuid)) as uuid , type_id, reason, (HEX(punisher_uuid)) as punisher, expiration_date, is_deleted, creation_date, update_date from sanctions";
            sql += " where player_uuid=UNHEX('" + Transcoder.Encode(player.getUuid().toString()) +"')";
            sql += " and type_id=" + SanctionBean.MUTE;
            sql += " and expiration_date>now()";
            sql += " and is_deleted=false";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result
            if (resultset.next())
            {
                // The player is muted
                String mutePlayer = Transcoder.Decode(resultset.getString("uuid"));
                UUID playerUuid = UUID.fromString(mutePlayer);
                int typeId = resultset.getInt("type_id");
                String reason = resultset.getString("reason");
                String punisher = Transcoder.Decode(resultset.getString("punisher"));
                UUID punisherUuid = UUID.fromString(punisher);
                Timestamp expirationTime = resultset.getTimestamp("expiration_date");
                boolean isDeleted = resultset.getBoolean("is_deleted");
                Timestamp creationDate = resultset.getTimestamp("creation_date");
                Timestamp updateDate = resultset.getTimestamp("update_date");
                sanction = new SanctionBean(playerUuid, typeId, reason, punisherUuid, expirationTime, isDeleted, creationDate, updateDate);
                return sanction;
            }
            else
            {
                // The player is not banned
                return null;
            }
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            // Close the query environment in order to prevent leaks
            close();
        }
        return null;
    }


    // Close the connection
    public void close()
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
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
    }
}
