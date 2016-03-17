-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- GÈnÈrÈ le :  Jeu 17 Mars 2016 ‡ 16:39
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de donnÈes :  `samagamesv3`
--
CREATE DATABASE IF NOT EXISTS `samagamesv3` DEFAULT CHARACTER SET utf8 COLLATE utf8_roman_ci;
USE `samagamesv3`;

-- --------------------------------------------------------

--
-- Structure de la table `api_permissions`
--

DROP TABLE IF EXISTS `api_permissions`;
CREATE TABLE IF NOT EXISTS `api_permissions` (
  `groups_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `api_servers_debug` tinyint(1) NOT NULL,
  `api_permissions_refresh` tinyint(1) NOT NULL,
  `api_coins_getother` tinyint(1) NOT NULL,
  `api_coins_credit` tinyint(1) NOT NULL,
  `api_coins_withdraw` tinyint(1) NOT NULL,
  `api_inventory_show` tinyint(1) NOT NULL,
  `api_playerdata_show` tinyint(1) NOT NULL,
  `api_playerdata_set` tinyint(1) NOT NULL,
  `api_playerdata_del` tinyint(1) NOT NULL,
  `api_modo_speakup` tinyint(1) NOT NULL,
  `api_stars_getother` tinyint(1) NOT NULL,
  `api_stars_credit` tinyint(1) NOT NULL,
  `api_stars_withdraw` tinyint(1) NOT NULL,
  `api_game_start` tinyint(1) NOT NULL,
  PRIMARY KEY (`groups_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci AUTO_INCREMENT=16 ;

--
-- Contenu de la table `api_permissions`
--

INSERT INTO `api_permissions` (`groups_id`, `api_servers_debug`, `api_permissions_refresh`, `api_coins_getother`, `api_coins_credit`, `api_coins_withdraw`, `api_inventory_show`, `api_playerdata_show`, `api_playerdata_set`, `api_playerdata_del`, `api_modo_speakup`, `api_stars_getother`, `api_stars_credit`, `api_stars_withdraw`, `api_game_start`) VALUES
  (1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (10, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0),
  (11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (14, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1),
  (15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `bukkit_permissions`
--

DROP TABLE IF EXISTS `bukkit_permissions`;
CREATE TABLE IF NOT EXISTS `bukkit_permissions` (
  `groups_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `minecraft_command_op` tinyint(1) NOT NULL,
  `bukkit_command_op_give` tinyint(1) NOT NULL,
  `bukkit_command_plugins` tinyint(1) NOT NULL,
  PRIMARY KEY (`groups_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci AUTO_INCREMENT=16 ;

--
-- Contenu de la table `bukkit_permissions`
--

INSERT INTO `bukkit_permissions` (`groups_id`, `minecraft_command_op`, `bukkit_command_op_give`, `bukkit_command_plugins`) VALUES
  (1, 0, 0, 0),
  (2, 0, 0, 0),
  (3, 0, 0, 0),
  (4, 0, 0, 0),
  (5, 0, 0, 0),
  (6, 0, 0, 0),
  (7, 0, 0, 0),
  (8, 0, 0, 0),
  (9, 0, 0, 0),
  (10, 0, 0, 0),
  (11, 0, 0, 0),
  (12, 0, 0, 0),
  (13, 0, 0, 0),
  (14, 1, 1, 1),
  (15, 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `bungee_redis_permissions`
--

DROP TABLE IF EXISTS `bungee_redis_permissions`;
CREATE TABLE IF NOT EXISTS `bungee_redis_permissions` (
  `groups_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bungeecord_command_list` tinyint(1) NOT NULL,
  `bungeecord_command_find` tinyint(1) NOT NULL,
  `redisbungee_command_lastseen` tinyint(1) NOT NULL,
  `bungeecord_command_ip` tinyint(1) NOT NULL,
  `redisbungee_command_sendtoall` tinyint(1) NOT NULL,
  `redisbungee_command_serverid` tinyint(1) NOT NULL,
  `redisbunge_command_serverids` tinyint(1) NOT NULL,
  `redisbungee_command_pproxy` tinyint(1) NOT NULL,
  `redisbungee_command_plist` tinyint(1) NOT NULL,
  `bungeecord_command_server` tinyint(1) NOT NULL,
  `bungeecord_command_send` tinyint(1) NOT NULL,
  `bungeecord_command_end` tinyint(1) NOT NULL,
  `bungeecord_command_alert` tinyint(1) NOT NULL,
  PRIMARY KEY (`groups_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci AUTO_INCREMENT=16 ;

--
-- Contenu de la table `bungee_redis_permissions`
--

INSERT INTO `bungee_redis_permissions` (`groups_id`, `bungeecord_command_list`, `bungeecord_command_find`, `redisbungee_command_lastseen`, `bungeecord_command_ip`, `redisbungee_command_sendtoall`, `redisbungee_command_serverid`, `redisbunge_command_serverids`, `redisbungee_command_pproxy`, `redisbungee_command_plist`, `bungeecord_command_server`, `bungeecord_command_send`, `bungeecord_command_end`, `bungeecord_command_alert`) VALUES
  (1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (14, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
  (15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `configuration`
--

DROP TABLE IF EXISTS `configuration`;
CREATE TABLE IF NOT EXISTS `configuration` (
  `slots` int(11) NOT NULL,
  `motd` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `close_type` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `server_line` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `max_players` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `configuration`
--

INSERT INTO `configuration` (`slots`, `motd`, `close_type`, `server_line`, `max_players`) VALUES
  (10, 'MOTD', 'CLOSE', 'LINE', 10000);

-- --------------------------------------------------------

--
-- Structure de la table `denunciation`
--

DROP TABLE IF EXISTS `denunciation`;
CREATE TABLE IF NOT EXISTS `denunciation` (
  `denouncement_id` int(11) NOT NULL AUTO_INCREMENT,
  `denouncer` binary(16) NOT NULL,
  `suspect` binary(16) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `reason` varchar(255) NOT NULL,
  `suspect_name` varchar(255) NOT NULL,
  PRIMARY KEY (`denouncement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `dimensions_stats`
--

DROP TABLE IF EXISTS `dimensions_stats`;
CREATE TABLE IF NOT EXISTS `dimensions_stats` (
  `uuid` binary(16) NOT NULL,
  `deaths` int(11) NOT NULL,
  `kills` int(11) NOT NULL,
  `played_games` int(11) NOT NULL,
  `wins` int(11) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `played_time` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `friendship`
--

DROP TABLE IF EXISTS `friendship`;
CREATE TABLE IF NOT EXISTS `friendship` (
  `friendship_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `requester_uuid` binary(16) NOT NULL,
  `requester_name` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `recipient_uuid` binary(16) NOT NULL,
  `recipient_name` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `demand_date` timestamp NULL DEFAULT NULL,
  `acceptation_date` timestamp NULL DEFAULT NULL,
  `active_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`friendship_id`),
  KEY `Requester_uuid` (`requester_uuid`),
  KEY `recepient_uuid` (`recipient_uuid`),
  KEY `active_status` (`active_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `game_ref`
--

DROP TABLE IF EXISTS `game_ref`;
CREATE TABLE IF NOT EXISTS `game_ref` (
  `id` int(20) NOT NULL,
  `text` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `game_ref`
--

INSERT INTO `game_ref` (`id`, `text`) VALUES
  (1, 'herobattle'),
  (2, 'jukebox'),
  (3, 'quake'),
  (4, 'uhcrun'),
  (5, 'uppervoid'),
  (6, 'dimensions');

-- --------------------------------------------------------

--
-- Structure de la table `groups`
--

DROP TABLE IF EXISTS `groups`;
CREATE TABLE IF NOT EXISTS `groups` (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `player_name` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `rank` int(11) NOT NULL,
  `tag` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `prefix` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `suffix` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `multiplier` int(11) NOT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci AUTO_INCREMENT=16 ;

--
-- Contenu de la table `groups`
--

INSERT INTO `groups` (`group_id`, `player_name`, `rank`, `tag`, `prefix`, `suffix`, `multiplier`) VALUES
  (1, 'Joueur', 100, '&7', '&7', '&7', 1),
  (2, 'VIP', 95, '[VIP]&s', '&a', '&r', 2),
  (3, 'VIPPlus', 90, '[VIP&d+&b]&s', '&b', '&r', 3),
  (4, 'Coupaing', 85, '[Coupaing]&s', '&6', '&r', 4),
  (5, 'Helper', 50, '[Guide]&s', '&3', '&r', 3),
  (6, 'Animator', 55, '[Animateur]&s', '&5', '&r', 3),
  (7, 'Graphic', 65, '[Graphiste]&s', '&2', '&r', 3),
  (8, 'Builder', 60, '[Builder]&s', '&2', '&r', 3),
  (9, 'Developper', 45, '[DÈveloppeur]&s', '&c', '&r', 4),
  (10, 'Mod', 40, '[ModÈrateur]&s', '&9', '&r', 4),
  (11, 'MasterMod', 2, '[Resp.&sModo]&s', '&9', '&r', 5),
  (12, 'MasterBuild', 2, '[Resp.&sBuild]&s', '&2', '&r', 5),
  (13, 'MasterComm', 2, '[Resp.&sComm.]&s', '&c', '&r', 5),
  (14, 'System', 1, '[SysAdmin]&s', '&c', '&r', 5),
  (15, 'Admin', 1, '[Admin]&s', '&4', '&r', 5);

-- --------------------------------------------------------

--
-- Structure de la table `herobattle_stats`
--

DROP TABLE IF EXISTS `herobattle_stats`;
CREATE TABLE IF NOT EXISTS `herobattle_stats` (
  `uuid` binary(16) NOT NULL,
  `deaths` int(11) NOT NULL,
  `elo` int(11) NOT NULL,
  `kills` int(11) NOT NULL,
  `played_games` int(11) NOT NULL,
  `powerup_taken` int(11) NOT NULL,
  `wins` int(11) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `played_time` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `hub_permissions`
--

DROP TABLE IF EXISTS `hub_permissions`;
CREATE TABLE IF NOT EXISTS `hub_permissions` (
  `groups_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hub_jukebox_lock` tinyint(1) NOT NULL,
  `hub_jukebox_next` tinyint(1) NOT NULL,
  `hub_jukebox_clear` tinyint(1) NOT NULL,
  `hub_mod_slow` tinyint(1) NOT NULL,
  `hub_mod_shutup` tinyint(1) NOT NULL,
  `hub_admin_npc` tinyint(1) NOT NULL,
  `hub_admin_sign` tinyint(1) NOT NULL,
  `hub_anguille` tinyint(1) NOT NULL,
  `hub_jukebox_nbs` tinyint(1) NOT NULL,
  `hub_admin_evacuate` tinyint(1) NOT NULL,
  `hub_announce` tinyint(1) NOT NULL,
  `hub_gadgets_cooldownbypass` tinyint(1) NOT NULL,
  `hub_gadgets_nuke` tinyint(1) NOT NULL,
  `hub_jukebox_limitbypass` tinyint(1) NOT NULL,
  `hub_jukebox_limitstaff` tinyint(1) NOT NULL,
  `hub_bypassmute` tinyint(1) NOT NULL,
  `hub_fly` tinyint(1) NOT NULL,
  `hub_debug_sign` tinyint(1) NOT NULL,
  PRIMARY KEY (`groups_id`),
  KEY `groups_id` (`groups_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci AUTO_INCREMENT=16 ;

--
-- Contenu de la table `hub_permissions`
--

INSERT INTO `hub_permissions` (`groups_id`, `hub_jukebox_lock`, `hub_jukebox_next`, `hub_jukebox_clear`, `hub_mod_slow`, `hub_mod_shutup`, `hub_admin_npc`, `hub_admin_sign`, `hub_anguille`, `hub_jukebox_nbs`, `hub_admin_evacuate`, `hub_announce`, `hub_gadgets_cooldownbypass`, `hub_gadgets_nuke`, `hub_jukebox_limitbypass`, `hub_jukebox_limitstaff`, `hub_bypassmute`, `hub_fly`, `hub_debug_sign`) VALUES
  (1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0),
  (3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0),
  (5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0),
  (6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0),
  (7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (10, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0),
  (12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
  (14, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1),
  (15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `jukebox_stats`
--

DROP TABLE IF EXISTS `jukebox_stats`;
CREATE TABLE IF NOT EXISTS `jukebox_stats` (
  `uuid` binary(16) NOT NULL,
  `mehs` int(11) NOT NULL,
  `woots` int(11) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `played_time` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `moderation_permissions`
--

DROP TABLE IF EXISTS `moderation_permissions`;
CREATE TABLE IF NOT EXISTS `moderation_permissions` (
  `groups_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mod_ban` tinyint(1) NOT NULL,
  `mod_tp` tinyint(1) NOT NULL,
  `mod_kick` tinyint(1) NOT NULL,
  `mod_pardon` tinyint(1) NOT NULL,
  `mod_mute_longtime` tinyint(1) NOT NULL,
  `mod_mute` tinyint(1) NOT NULL,
  `mod_channel` tinyint(1) NOT NULL,
  PRIMARY KEY (`groups_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci AUTO_INCREMENT=16 ;

--
-- Contenu de la table `moderation_permissions`
--

INSERT INTO `moderation_permissions` (`groups_id`, `mod_ban`, `mod_tp`, `mod_kick`, `mod_pardon`, `mod_mute_longtime`, `mod_mute`, `mod_channel`) VALUES
  (1, 0, 0, 0, 0, 0, 0, 0),
  (2, 0, 0, 0, 0, 0, 0, 0),
  (3, 0, 0, 0, 0, 0, 0, 0),
  (4, 0, 0, 0, 0, 0, 0, 0),
  (5, 0, 0, 0, 0, 0, 1, 1),
  (6, 0, 0, 0, 0, 0, 0, 0),
  (7, 0, 0, 0, 0, 0, 0, 0),
  (8, 0, 0, 0, 0, 0, 0, 0),
  (9, 0, 0, 0, 0, 0, 0, 0),
  (10, 1, 1, 1, 1, 1, 0, 0),
  (11, 0, 0, 0, 0, 0, 0, 0),
  (12, 0, 0, 0, 0, 0, 0, 0),
  (13, 0, 0, 0, 0, 0, 0, 0),
  (14, 0, 0, 0, 0, 0, 0, 0),
  (15, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `players`
--

DROP TABLE IF EXISTS `players`;
CREATE TABLE IF NOT EXISTS `players` (
  `uuid` binary(16) NOT NULL,
  `name` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `coins` int(11) DEFAULT NULL,
  `stars` int(11) DEFAULT NULL,
  `last_login` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `first_login` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `last_ip` varchar(15) COLLATE utf8_roman_ci DEFAULT NULL,
  `toptp_key` varchar(32) COLLATE utf8_roman_ci DEFAULT NULL,
  `group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `player_settings`
--

DROP TABLE IF EXISTS `player_settings`;
CREATE TABLE IF NOT EXISTS `player_settings` (
  `player_uuid` binary(16) NOT NULL,
  `jukebox_listen` tinyint(1) NOT NULL,
  `group_demand_receive` tinyint(1) NOT NULL,
  `friendship_demand_receive` tinyint(1) NOT NULL,
  `notification_receive` tinyint(1) NOT NULL,
  `private_message_receive` tinyint(1) NOT NULL,
  `chat_visible` tinyint(1) NOT NULL,
  `player_visible` tinyint(1) NOT NULL,
  `waiting_line_notification` tinyint(1) NOT NULL,
  `other_player_interaction` tinyint(1) NOT NULL,
  `click_on_me_activation` tinyint(1) NOT NULL,
  `allow_statistic_onclick` tinyint(1) NOT NULL,
  `allow_coins_onclick` tinyint(1) NOT NULL,
  `allow_stars_onclick` tinyint(1) NOT NULL,
  `allow_click_on_other` tinyint(1) NOT NULL,
  PRIMARY KEY (`player_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `promotions`
--

DROP TABLE IF EXISTS `promotions`;
CREATE TABLE IF NOT EXISTS `promotions` (
  `promotion_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_promotion` int(11) NOT NULL,
  `game` int(11) NOT NULL,
  `multiplier` int(11) NOT NULL,
  `message` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `start_date` timestamp NULL DEFAULT NULL,
  `end_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`promotion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `promotions_ref`
--

DROP TABLE IF EXISTS `promotions_ref`;
CREATE TABLE IF NOT EXISTS `promotions_ref` (
  `id` int(11) NOT NULL,
  `text` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `promotions_ref`
--

INSERT INTO `promotions_ref` (`id`, `text`) VALUES
  (0, 'coins'),
  (1, 'stars');

-- --------------------------------------------------------

--
-- Structure de la table `proxies_permissions`
--

DROP TABLE IF EXISTS `proxies_permissions`;
CREATE TABLE IF NOT EXISTS `proxies_permissions` (
  `groups_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `proxies_dispatch` tinyint(1) NOT NULL,
  `proxies_global` tinyint(1) NOT NULL,
  `proxies_debug` tinyint(1) NOT NULL,
  `proxies_set_option` tinyint(1) NOT NULL,
  PRIMARY KEY (`groups_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci AUTO_INCREMENT=16 ;

--
-- Contenu de la table `proxies_permissions`
--

INSERT INTO `proxies_permissions` (`groups_id`, `proxies_dispatch`, `proxies_global`, `proxies_debug`, `proxies_set_option`) VALUES
  (1, 0, 0, 0, 0),
  (2, 0, 0, 0, 0),
  (3, 0, 0, 0, 0),
  (4, 0, 0, 0, 0),
  (5, 0, 0, 0, 0),
  (6, 0, 0, 0, 0),
  (7, 0, 0, 0, 0),
  (8, 0, 0, 0, 0),
  (9, 0, 0, 0, 0),
  (10, 0, 0, 0, 0),
  (11, 0, 0, 0, 0),
  (12, 0, 0, 0, 0),
  (13, 0, 0, 0, 0),
  (14, 1, 1, 1, 1),
  (15, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `quake_stats`
--

DROP TABLE IF EXISTS `quake_stats`;
CREATE TABLE IF NOT EXISTS `quake_stats` (
  `uuid` binary(16) NOT NULL,
  `deaths` int(11) NOT NULL,
  `kills` int(11) NOT NULL,
  `played_games` int(11) NOT NULL,
  `wins` int(11) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `played_time` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `sanctions`
--

DROP TABLE IF EXISTS `sanctions`;
CREATE TABLE IF NOT EXISTS `sanctions` (
  `sanction_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `player_uuid` binary(16) NOT NULL,
  `type_id` int(11) NOT NULL,
  `reason` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `punisher_uuid` binary(16) NOT NULL,
  `expiration_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `is_deleted` tinyint(1) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`sanction_id`),
  KEY `player_uuid` (`player_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `sanctions_ref`
--

DROP TABLE IF EXISTS `sanctions_ref`;
CREATE TABLE IF NOT EXISTS `sanctions_ref` (
  `id` int(11) NOT NULL,
  `text` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `sanctions_ref`
--

INSERT INTO `sanctions_ref` (`id`, `text`) VALUES
  (1, 'Avertissement'),
  (2, 'Ban'),
  (3, 'Kick'),
  (4, 'Mute'),
  (5, 'Text');

-- --------------------------------------------------------

--
-- Structure de la table `staff_permissions`
--

DROP TABLE IF EXISTS `staff_permissions`;
CREATE TABLE IF NOT EXISTS `staff_permissions` (
  `groups_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staff_member` tinyint(1) NOT NULL,
  `netjoin_closed` tinyint(1) NOT NULL,
  `netjoin_vip` tinyint(1) NOT NULL,
  `netjoin_full` tinyint(1) NOT NULL,
  `tracker_famous` tinyint(1) NOT NULL,
  PRIMARY KEY (`groups_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci AUTO_INCREMENT=16 ;

--
-- Contenu de la table `staff_permissions`
--

INSERT INTO `staff_permissions` (`groups_id`, `staff_member`, `netjoin_closed`, `netjoin_vip`, `netjoin_full`, `tracker_famous`) VALUES
  (1, 0, 0, 0, 0, 0),
  (2, 0, 0, 1, 1, 0),
  (3, 0, 0, 0, 0, 0),
  (4, 0, 0, 0, 0, 1),
  (5, 1, 0, 0, 0, 0),
  (6, 0, 0, 0, 0, 0),
  (7, 0, 0, 0, 0, 0),
  (8, 0, 0, 0, 0, 0),
  (9, 0, 0, 0, 0, 0),
  (10, 0, 0, 0, 0, 0),
  (11, 0, 0, 0, 0, 0),
  (12, 0, 0, 0, 0, 0),
  (13, 0, 0, 0, 0, 0),
  (14, 0, 1, 0, 0, 0),
  (15, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `uhcrun_stats`
--

DROP TABLE IF EXISTS `uhcrun_stats`;
CREATE TABLE IF NOT EXISTS `uhcrun_stats` (
  `uuid` binary(16) NOT NULL,
  `damages` int(11) NOT NULL,
  `deaths` int(11) NOT NULL,
  `kills` int(11) NOT NULL,
  `max_damages` int(11) NOT NULL,
  `played_games` int(11) NOT NULL,
  `wins` int(11) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `played_time` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `uhc_permissions`
--

DROP TABLE IF EXISTS `uhc_permissions`;
CREATE TABLE IF NOT EXISTS `uhc_permissions` (
  `groups_id` bigint(20) NOT NULL,
  `uhc_team_lock` tinyint(1) NOT NULL,
  `uhc_team_name` tinyint(1) NOT NULL,
  `uhc_team_invite` tinyint(1) NOT NULL,
  PRIMARY KEY (`groups_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `uppervoid_stats`
--

DROP TABLE IF EXISTS `uppervoid_stats`;
CREATE TABLE IF NOT EXISTS `uppervoid_stats` (
  `uuid` binary(16) NOT NULL,
  `blocks` int(11) NOT NULL,
  `grenades` int(11) NOT NULL,
  `kills` int(11) NOT NULL,
  `played_games` int(11) NOT NULL,
  `tnt_launched` int(11) NOT NULL,
  `wins` int(11) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `played_time` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
