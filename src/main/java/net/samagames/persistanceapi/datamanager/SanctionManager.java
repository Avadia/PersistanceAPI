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
import net.samagames.persistanceapi.beans.players.SanctionBean;
import net.samagames.persistanceapi.utils.Transcoder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SanctionManager
{
    // Defines
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultset = null;

    // Create a sanction
    public void applySanction(int sanctionType, SanctionBean sanction, DataSource dataSource) throws Exception
    {
        // Create the sanction
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            Timestamp expirationTime = sanction.getExpirationTime();
            String expirationData = "0000-00-00 00:00:00";
            if(expirationTime != null)
            {
                expirationData = expirationTime.toString();
            }

            // Query construction
            String sql = "";
            sql += "insert into sanctions (player_uuid, type_id, reason, punisher_uuid, expiration_date, is_deleted, creation_date, update_date) values (";
            sql += "UNHEX('" + Transcoder.Encode(sanction.getPlayerUuid().toString()) + "')";
            sql += ", " + sanctionType;
            sql += ", '" + sanction.getReason() + "'";
            sql += ", UNHEX('" + Transcoder.Encode(sanction.getPunisherUuid().toString()) +"')";
            sql += ", '" + expirationData + "'";
            sql += ", 0";
            sql += ", now()";
            sql += ", now())";

            // Execute the query
            statement.executeUpdate(sql);
        }
        catch (Exception exception)
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

    // Remove a sanction
    public void removeSanction(int sanctionType, PlayerBean player, DataSource dataSource) throws Exception
    {
        // Remove the last active sanction
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "update sanctions set is_deleted=1 where type_id=";
            sql += sanctionType + " and player_uuid=UNHEX('" + Transcoder.Encode(player.getUuid().toString()) +"')";
            sql += " where is_deleted=0 order by creation_date desc limit 1";

            // Execute the query
            statement.executeUpdate(sql);
        }
        catch (Exception exception)
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

    // Check if a player is banned
    public SanctionBean getPlayerBanned(PlayerBean player, DataSource dataSource) throws Exception
    {
        // Defines
        SanctionBean sanction = null;

        // Do the check of ban
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            Timestamp expirationTime = null;

            // Query construction
            String sql = "";
            sql += "select sanction_id, (HEX(player_uuid)) as uuid , type_id, reason, (HEX(punisher_uuid)) as punisher, expiration_date, is_deleted, creation_date, update_date from sanctions";
            sql += " where player_uuid=UNHEX('" + Transcoder.Encode(player.getUuid().toString()) +"')";
            sql += " and type_id=" + SanctionBean.BAN;
            sql += " and (expiration_date>now() or expiration_date='0000-00-00 00:00:00')";
            sql += " and is_deleted=0";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result
            if (resultset.next())
            {
                // The player is banned
                long sanctionId =  resultset.getLong("sanction_id");
                String banPlayer = Transcoder.Decode(resultset.getString("uuid"));
                UUID playerUuid = UUID.fromString(banPlayer);
                int typeId = resultset.getInt("type_id");
                String reason = resultset.getString("reason");
                String punisher = Transcoder.Decode(resultset.getString("punisher"));
                UUID punisherUuid = UUID.fromString(punisher);
                try
                {
                    expirationTime = resultset.getTimestamp("expiration_date");
                }
                catch (Exception dateException)
                {
                    expirationTime = null;
                }
                boolean isDeleted = resultset.getBoolean("is_deleted");
                Timestamp creationDate = resultset.getTimestamp("creation_date");
                Timestamp updateDate = resultset.getTimestamp("update_date");
                sanction = new SanctionBean(sanctionId, playerUuid, typeId, reason, punisherUuid, expirationTime, isDeleted, creationDate, updateDate);
                return sanction;
            }
            else
            {
                // The player is not banned
                return null;
            }
        }
        catch (Exception exception)
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

    // Check if a player is muted
    public SanctionBean getPlayerMuted(PlayerBean player, DataSource dataSource) throws Exception
    {
        // Defines
        SanctionBean sanction = null;

        // Do the check of mute
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            Timestamp expirationTime = null;

            // Query construction
            String sql = "";
            sql += "select sanction_id, (HEX(player_uuid)) as uuid , type_id, reason, (HEX(punisher_uuid)) as punisher, expiration_date, is_deleted, creation_date, update_date from sanctions";
            sql += " where player_uuid=UNHEX('" + Transcoder.Encode(player.getUuid().toString()) +"')";
            sql += " and type_id=" + SanctionBean.MUTE;
            sql += " and expiration_date>now()";
            sql += " and is_deleted=0";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result
            if (resultset.next())
            {
                // The player is muted
                long sanctionId = resultset.getLong("sanction_id");
                String mutePlayer = Transcoder.Decode(resultset.getString("uuid"));
                UUID playerUuid = UUID.fromString(mutePlayer);
                int typeId = resultset.getInt("type_id");
                String reason = resultset.getString("reason");
                String punisher = Transcoder.Decode(resultset.getString("punisher"));
                UUID punisherUuid = UUID.fromString(punisher);
                try
                {
                    expirationTime = resultset.getTimestamp("expiration_date");
                }
                catch (Exception dateException)
                {
                    expirationTime = null;
                }
                boolean isDeleted = resultset.getBoolean("is_deleted");
                Timestamp creationDate = resultset.getTimestamp("creation_date");
                Timestamp updateDate = resultset.getTimestamp("update_date");
                sanction = new SanctionBean(sanctionId, playerUuid, typeId, reason, punisherUuid, expirationTime, isDeleted, creationDate, updateDate);
                return sanction;
            }
            else
            {
                // The player is not banned
                return null;
            }
        }
        catch (Exception exception)
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

    // Get all actives sanctions by type
    public List<SanctionBean> getAllSanction(UUID uuid, int sanctionType, DataSource dataSource) throws Exception
    {
        // Get all sanctions
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            List<SanctionBean> sanctionList = new ArrayList<>();
            Timestamp expirationTime = null;

            // Query construction
            String sql = "select sanction_id, (HEX(player_uuid)) as player_uuid, type_id, reason, (HEX(punisher_uuid)) as punisher_uuid, expiration_date, is_deleted, creation_date, update_date from sanctions";
            sql += " where player_uuid=(UNHEX('"+ Transcoder.Encode(uuid.toString())+"'))";
            sql += " and type_id=" + sanctionType;
            sql += " order by creation_date desc";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while (resultset.next())
            {
                // There's a result
                long sanctionId = resultset.getLong("sanction_id");
                String playerUuid = Transcoder.Decode(resultset.getString("player_uuid"));
                int typeId = resultset.getInt("type_id");
                String reason = resultset.getString("reason");
                String punisherUUID = Transcoder.Decode(resultset.getString("punisher_uuid"));
                try
                {
                    expirationTime = resultset.getTimestamp("expiration_date");
                }
                catch (Exception dateException)
                {
                    expirationTime = null;
                }
                boolean isDeleted = resultset.getBoolean("is_deleted");
                Timestamp creationDate = resultset.getTimestamp("creation_date");
                Timestamp updateDate = resultset.getTimestamp("update_date");
                SanctionBean sanction = new SanctionBean(sanctionId, UUID.fromString(playerUuid), typeId, reason, UUID.fromString(punisherUUID), expirationTime, isDeleted, creationDate, updateDate);
                sanctionList.add(sanction);
            }
            return sanctionList;
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

    // Get all non actives sanctions by type
    public List<SanctionBean> getAllActiveSanctions(UUID uuid, int sanctionType, DataSource dataSource) throws Exception
    {
        // Get all sanctions
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            List<SanctionBean> sanctionList = new ArrayList<>();
            Timestamp expirationTime = null;

            // Query construction
            String sql = "select sanction_id, (HEX(player_uuid)) as player_uuid, type_id, reason, (HEX(punisher_uuid)) as punisher_uuid, expiration_date, is_deleted, creation_date, update_date from sanctions";
            sql += " where player_uuid=(UNHEX('"+ Transcoder.Encode(uuid.toString())+"'))";
            sql += " and type_id=" + sanctionType;
            sql += " and is_deleted=0";
            sql += " order by creation_date desc";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while (resultset.next())
            {
                // There's a result
                long sanctionId = resultset.getLong("sanction_id");
                String playerUuid = Transcoder.Decode(resultset.getString("player_uuid"));
                int typeId = resultset.getInt("type_id");
                String reason = resultset.getString("reason");
                String punisherUUID = Transcoder.Decode(resultset.getString("punisher_uuid"));
                try
                {
                    expirationTime = resultset.getTimestamp("expiration_date");
                }
                catch (Exception dateException)
                {
                    expirationTime = null;
                }
                boolean isDeleted = resultset.getBoolean("is_deleted");
                Timestamp creationDate = resultset.getTimestamp("creation_date");
                Timestamp updateDate = resultset.getTimestamp("update_date");
                SanctionBean sanction = new SanctionBean(sanctionId, UUID.fromString(playerUuid), typeId, reason, UUID.fromString(punisherUUID), expirationTime, isDeleted, creationDate, updateDate);
                sanctionList.add(sanction);
            }
            return sanctionList;
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

    // Get all sanctions by type
    // Get all non actives sanctions by type
    public List<SanctionBean> getAllPassiveSanctions(UUID uuid, int sanctionType, DataSource dataSource) throws Exception
    {
        // Get all sanctions
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            List<SanctionBean> sanctionList = new ArrayList<>();
            Timestamp expirationTime = null;

            // Query construction
            String sql = "select sanction_id, (HEX(player_uuid)) as player_uuid, type_id, reason, (HEX(punisher_uuid)) as punisher_uuid, expiration_date, is_deleted, creation_date, update_date from sanctions";
            sql += " where player_uuid=(UNHEX('"+ Transcoder.Encode(uuid.toString())+"'))";
            sql += " and type_id=" + sanctionType;
            sql += " and is_deleted=1";
            sql += " order by creation_date desc";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while (resultset.next())
            {
                // There's a result
                long sanctionId = resultset.getLong("sanction_id");
                String playerUuid = Transcoder.Decode(resultset.getString("player_uuid"));
                int typeId = resultset.getInt("type_id");
                String reason = resultset.getString("reason");
                String punisherUUID = Transcoder.Decode(resultset.getString("punisher_uuid"));
                try
                {
                    expirationTime = resultset.getTimestamp("expiration_date");
                }
                catch (Exception dateException)
                {
                    expirationTime = null;
                }
                boolean isDeleted = resultset.getBoolean("is_deleted");
                Timestamp creationDate = resultset.getTimestamp("creation_date");
                Timestamp updateDate = resultset.getTimestamp("update_date");
                SanctionBean sanction = new SanctionBean(sanctionId, UUID.fromString(playerUuid), typeId, reason, UUID.fromString(punisherUUID), expirationTime, isDeleted, creationDate, updateDate);
                sanctionList.add(sanction);
            }
            return sanctionList;
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

    // Update a sanction status
    public void updateSanctionStatus(long sanctionId, boolean status, DataSource dataSource) throws Exception
    {
        // Update the sanction status
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            // Query construction
            String sql = "";
            sql += "update sanctions set is_deleted=" + ((status)?"1":"0") +" where sanction_id=" + sanctionId;

            // Execute the query
            statement.executeUpdate(sql);
        }
        catch (Exception exception)
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

    // Get sanctions by UUID
    public List<SanctionBean> getAllModoSanctions(UUID uuid, DataSource dataSource) throws Exception
    {
        // Get all sanctions
        try
        {
            // Set connection
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            List<SanctionBean> sanctionList = new ArrayList<>();
            Timestamp expirationTime = null;

            // Query construction
            String sql = "select sanction_id, (HEX(player_uuid)) as player_uuid, type_id, reason, (HEX(punisher_uuid)) as punisher_uuid, expiration_date, is_deleted, creation_date, update_date from sanctions";
            sql += " where punisher_uuid=(UNHEX('"+ Transcoder.Encode(uuid.toString())+"'))";
            sql += " order by creation_date desc";

            // Execute the query
            resultset = statement.executeQuery(sql);

            // Manage the result in a bean
            while (resultset.next())
            {
                // There's a result
                long sanctionId = resultset.getLong("sanction_id");
                String playerUuid = Transcoder.Decode(resultset.getString("player_uuid"));
                int typeId = resultset.getInt("type_id");
                String reason = resultset.getString("reason");
                String punisherUUID = Transcoder.Decode(resultset.getString("punisher_uuid"));
                try
                {
                    expirationTime = resultset.getTimestamp("expiration_date");
                }
                catch (Exception dateException)
                {
                    expirationTime = null;
                }
                boolean isDeleted = resultset.getBoolean("is_deleted");
                Timestamp creationDate = resultset.getTimestamp("creation_date");
                Timestamp updateDate = resultset.getTimestamp("update_date");
                SanctionBean sanction = new SanctionBean(sanctionId, UUID.fromString(playerUuid), typeId, reason, UUID.fromString(punisherUUID), expirationTime, isDeleted, creationDate, updateDate);
                sanctionList.add(sanction);
            }
            return sanctionList;
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
