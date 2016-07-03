-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Dim 26 Juin 2016 à 19:05
-- Version du serveur :  5.5.42
-- Version de PHP :  7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `samagamesV3`
--
CREATE DATABASE IF NOT EXISTS `samagamesV3` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `samagamesV3`;

-- --------------------------------------------------------

--
-- Structure de la table `api_permissions`
--

DROP TABLE IF EXISTS `api_permissions`;
CREATE TABLE `api_permissions` (
  `groups_id` tinyint(4) NOT NULL,
  `api_servers_debug` bit(1) NOT NULL,
  `api_permissions_refresh` bit(1) NOT NULL,
  `api_coins_getother` bit(1) NOT NULL,
  `api_coins_credit` bit(1) NOT NULL,
  `api_coins_withdraw` bit(1) NOT NULL,
  `api_inventory_show` bit(1) NOT NULL,
  `api_playerdata_show` bit(1) NOT NULL,
  `api_playerdata_set` bit(1) NOT NULL,
  `api_playerdata_del` bit(1) NOT NULL,
  `api_modo_speakup` bit(1) NOT NULL,
  `api_stars_getother` bit(1) NOT NULL,
  `api_stars_credit` bit(1) NOT NULL,
  `api_stars_withdraw` bit(1) NOT NULL,
  `api_game_start` bit(1) NOT NULL,
  `api_chat_bypass` bit(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `api_permissions`
--

INSERT INTO `api_permissions` (`groups_id`, `api_servers_debug`, `api_permissions_refresh`, `api_coins_getother`, `api_coins_credit`, `api_coins_withdraw`, `api_inventory_show`, `api_playerdata_show`, `api_playerdata_set`, `api_playerdata_del`, `api_modo_speakup`, `api_stars_getother`, `api_stars_credit`, `api_stars_withdraw`, `api_game_start`, `api_chat_bypass`) VALUES
  (1, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (2, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (3, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (4, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (5, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (6, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1'),
  (7, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1'),
  (8, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1'),
  (9, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1'),
  (10, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1'),
  (11, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1'),
  (12, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1'),
  (13, b'0', b'0', b'0', b'0', b'0', b'1', b'0', b'0', b'0', b'1', b'0', b'0', b'0', b'0', b'1'),
  (14, b'0', b'0', b'1', b'1', b'1', b'1', b'0', b'0', b'0', b'1', b'1', b'1', b'1', b'1', b'1'),
  (15, b'0', b'0', b'1', b'1', b'1', b'1', b'0', b'0', b'0', b'1', b'1', b'1', b'1', b'1', b'1'),
  (16, b'0', b'0', b'1', b'1', b'1', b'1', b'0', b'0', b'0', b'1', b'1', b'1', b'1', b'1', b'1'),
  (17, b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
  (18, b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
  (19, b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `bukkit_permissions`
--

DROP TABLE IF EXISTS `bukkit_permissions`;
CREATE TABLE `bukkit_permissions` (
  `groups_id` tinyint(4) NOT NULL,
  `minecraft_command_op` bit(1) NOT NULL,
  `bukkit_command_op_give` bit(1) NOT NULL,
  `bukkit_command_plugins` bit(1) NOT NULL,
  `bukkit_command_effect` bit(1) NOT NULL,
  `bukkit_command_gamemode` bit(1) NOT NULL,
  `bukkit_command_teleport` bit(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `bukkit_permissions`
--

INSERT INTO `bukkit_permissions` (`groups_id`, `minecraft_command_op`, `bukkit_command_op_give`, `bukkit_command_plugins`, `bukkit_command_effect`, `bukkit_command_gamemode`, `bukkit_command_teleport`) VALUES
  (1, b'0', b'0', b'0', b'0', b'0', b'0'),
  (2, b'0', b'0', b'0', b'0', b'0', b'0'),
  (3, b'0', b'0', b'0', b'0', b'0', b'0'),
  (4, b'0', b'0', b'0', b'0', b'0', b'0'),
  (5, b'0', b'0', b'0', b'0', b'0', b'0'),
  (6, b'0', b'0', b'0', b'0', b'0', b'0'),
  (7, b'0', b'0', b'0', b'0', b'0', b'0'),
  (8, b'0', b'0', b'0', b'0', b'0', b'0'),
  (9, b'0', b'0', b'0', b'0', b'0', b'0'),
  (10, b'0', b'0', b'0', b'0', b'0', b'0'),
  (11, b'0', b'0', b'0', b'0', b'0', b'0'),
  (12, b'0', b'0', b'0', b'0', b'0', b'0'),
  (13, b'0', b'0', b'0', b'1', b'1', b'1'),
  (14, b'1', b'1', b'1', b'1', b'1', b'1'),
  (15, b'1', b'1', b'1', b'1', b'1', b'1'),
  (16, b'1', b'1', b'1', b'1', b'1', b'1'),
  (17, b'1', b'1', b'1', b'1', b'1', b'1'),
  (18, b'1', b'1', b'1', b'1', b'1', b'1'),
  (19, b'1', b'1', b'1', b'1', b'1', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `bungee_redis_permissions`
--

DROP TABLE IF EXISTS `bungee_redis_permissions`;
CREATE TABLE `bungee_redis_permissions` (
  `groups_id` tinyint(4) NOT NULL,
  `bungeecord_command_list` bit(1) NOT NULL,
  `bungeecord_command_find` bit(1) NOT NULL,
  `redisbungee_command_lastseen` bit(1) NOT NULL,
  `bungeecord_command_ip` bit(1) NOT NULL,
  `redisbungee_command_sendtoall` bit(1) NOT NULL,
  `redisbungee_command_serverid` bit(1) NOT NULL,
  `redisbunge_command_serverids` bit(1) NOT NULL,
  `redisbungee_command_pproxy` bit(1) NOT NULL,
  `redisbungee_command_plist` bit(1) NOT NULL,
  `bungeecord_command_server` bit(1) NOT NULL,
  `bungeecord_command_send` bit(1) NOT NULL,
  `bungeecord_command_end` bit(1) NOT NULL,
  `bungeecord_command_alert` bit(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `bungee_redis_permissions`
--

INSERT INTO `bungee_redis_permissions` (`groups_id`, `bungeecord_command_list`, `bungeecord_command_find`, `redisbungee_command_lastseen`, `bungeecord_command_ip`, `redisbungee_command_sendtoall`, `redisbungee_command_serverid`, `redisbunge_command_serverids`, `redisbungee_command_pproxy`, `redisbungee_command_plist`, `bungeecord_command_server`, `bungeecord_command_send`, `bungeecord_command_end`, `bungeecord_command_alert`) VALUES
  (1, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (2, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (3, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (4, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (5, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (6, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (7, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (8, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (9, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (10, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (11, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (12, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (13, b'0', b'0', b'1', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (14, b'0', b'0', b'1', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (15, b'0', b'0', b'1', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (16, b'0', b'0', b'1', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (17, b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
  (18, b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
  (19, b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `configuration`
--

DROP TABLE IF EXISTS `configuration`;
CREATE TABLE `configuration` (
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
  (4242, '§c§lNouveau Hub §r§f- §a§lMise à jour de Uppervoid', 'staff', '§6? §e§lSamaGames - Pre Release 1 §6?', 4242);

-- --------------------------------------------------------

--
-- Structure de la table `denunciations`
--

DROP TABLE IF EXISTS `denunciations`;
CREATE TABLE `denunciations` (
  `denouncement_id` int(11) NOT NULL,
  `denouncer` binary(16) NOT NULL,
  `date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `reason` varchar(255) NOT NULL,
  `suspect_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `dimensions_stats`
--

DROP TABLE IF EXISTS `dimensions_stats`;
CREATE TABLE `dimensions_stats` (
  `uuid` binary(16) NOT NULL,
  `deaths` int(11) NOT NULL,
  `kills` int(11) NOT NULL,
  `played_games` int(11) NOT NULL,
  `wins` int(11) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `played_time` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `friendship`
--

DROP TABLE IF EXISTS `friendship`;
CREATE TABLE `friendship` (
  `friendship_id` bigint(20) NOT NULL,
  `requester_uuid` binary(16) NOT NULL,
  `recipient_uuid` binary(16) NOT NULL,
  `demand_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `acceptation_date` timestamp NULL DEFAULT NULL,
  `active_status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `game_category`
--

DROP TABLE IF EXISTS `game_category`;
CREATE TABLE `game_category` (
  `category_id` tinyint(4) NOT NULL,
  `name` tinytext
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `game_category`
--

INSERT INTO `game_category` (`category_id`, `name`) VALUES
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
CREATE TABLE `groups` (
  `group_id` tinyint(4) NOT NULL,
  `group_name` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `rank` int(11) NOT NULL,
  `tag` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `prefix` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `suffix` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `multiplier` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `groups`
--

INSERT INTO `groups` (`group_id`, `group_name`, `rank`, `tag`, `prefix`, `suffix`, `multiplier`) VALUES
  (1, 'Joueur', 100, '', '&7', '&7', 1),
  (2, 'VIP', 95, '&a[VIP]&s', '&a', '&r', 2),
  (3, 'VIPPlus', 90, '&b[VIP&d+&b]&s', '&b', '&r', 3),
  (4, 'Coupaing', 85, '&6[Coupaing]&s', '&6', '&r', 4),
  (5, 'Ambassador', 80, '&e[&6S&eam&6A&ellié&e]&s', '&e', '&r', 4),
  (6, 'Staff', 70, '&2[Staff]&s', '&2', '&r', 4),
  (7, 'Helper', 50, '&3[Guide]&s', '&3', '&r', 4),
  (8, 'Animator', 55, '&5[Animateur]&s', '&5', '&r', 4),
  (9, 'Graphic', 65, '&2[Graphiste]&s', '&2', '&r', 4),
  (10, 'Redactor', 62, '&2[Redacteur]&s', '&2', '&r', 4),
  (11, 'Builder', 60, '&2[Builder]&s', '&2', '&r', 4),
  (12, 'Developper', 40, '&c[Développeur]&s', '&c', '&r', 4),
  (13, 'Mod', 45, '&9[Modérateur]&s', '&9', '&r', 4),
  (14, 'MasterMod', 2, '&9[Resp.&sModo]&s', '&9', '&r', 5),
  (15, 'MasterBuild', 2, '&2[Resp.&sBuild]&s', '&2', '&r', 5),
  (16, 'MasterComm', 2, '&c[Resp.&sComm.]&s', '&c', '&r', 5),
  (17, 'MasterDev', 40, '&c[Développeur]&s', '&c', '&r', 5),
  (18, 'System', 1, '&4[SysAdmin]&s', '&c', '&r', 5),
  (19, 'Admin', 1, '&4[Admin]&s', '&4', '&r', 5);

-- --------------------------------------------------------

--
-- Structure de la table `herobattle_stats`
--

DROP TABLE IF EXISTS `herobattle_stats`;
CREATE TABLE `herobattle_stats` (
  `uuid` binary(16) NOT NULL,
  `deaths` int(11) NOT NULL,
  `elo` int(11) NOT NULL,
  `kills` int(11) NOT NULL,
  `played_games` int(11) NOT NULL,
  `powerup_taken` int(11) NOT NULL,
  `wins` int(11) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `played_time` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `host_stats`
--

DROP TABLE IF EXISTS `host_stats`;
CREATE TABLE `host_stats` (
  `id` double NOT NULL,
  `host_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_roman_ci NOT NULL,
  `ip_address` varchar(15) CHARACTER SET utf8 COLLATE utf8_roman_ci NOT NULL,
  `player_uuid` binary(16) NOT NULL,
  `played_time` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `hub_permissions`
--

DROP TABLE IF EXISTS `hub_permissions`;
CREATE TABLE `hub_permissions` (
  `groups_id` tinyint(4) NOT NULL,
  `hub_jukebox_lock` bit(1) NOT NULL,
  `hub_jukebox_next` bit(1) NOT NULL,
  `hub_jukebox_clear` bit(1) NOT NULL,
  `hub_mod_slow` bit(1) NOT NULL,
  `hub_mod_shutup` bit(1) NOT NULL,
  `hub_admin_npc` bit(1) NOT NULL,
  `hub_admin_sign` bit(1) NOT NULL,
  `hub_anguille` bit(1) NOT NULL,
  `hub_jukebox_nbs` bit(1) NOT NULL,
  `hub_admin_evacuate` bit(1) NOT NULL,
  `hub_announce` bit(1) NOT NULL,
  `hub_gadgets_cooldownbypass` bit(1) NOT NULL,
  `hub_gadgets_nuke` bit(1) NOT NULL,
  `hub_jukebox_limitbypass` bit(1) NOT NULL,
  `hub_jukebox_limitstaff` bit(1) NOT NULL,
  `hub_bypassmute` bit(1) NOT NULL,
  `hub_fly` bit(1) NOT NULL,
  `hub_debug_sign` bit(1) NOT NULL,
  `hub_sign_selection` bit(1) NOT NULL,
  `hub_beta_vip` bit(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `hub_permissions`
--

INSERT INTO `hub_permissions` (`groups_id`, `hub_jukebox_lock`, `hub_jukebox_next`, `hub_jukebox_clear`, `hub_mod_slow`, `hub_mod_shutup`, `hub_admin_npc`, `hub_admin_sign`, `hub_anguille`, `hub_jukebox_nbs`, `hub_admin_evacuate`, `hub_announce`, `hub_gadgets_cooldownbypass`, `hub_gadgets_nuke`, `hub_jukebox_limitbypass`, `hub_jukebox_limitstaff`, `hub_bypassmute`, `hub_fly`, `hub_debug_sign`, `hub_sign_selection`, `hub_beta_vip`) VALUES
  (1, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (2, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1', b'0', b'0', b'1'),
  (3, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1', b'0', b'0', b'1'),
  (4, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1', b'0', b'0', b'0', b'0', b'1', b'1', b'0', b'0', b'1'),
  (5, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1', b'0', b'0', b'0', b'0', b'1', b'1', b'0', b'0', b'1'),
  (6, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1', b'0', b'0', b'0', b'1', b'1', b'1', b'0', b'0', b'1'),
  (7, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1', b'0', b'0', b'0', b'1', b'1', b'1', b'0', b'0', b'1'),
  (8, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1', b'1', b'0', b'1', b'1', b'1', b'1', b'0', b'0', b'1'),
  (9, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1', b'0', b'0', b'0', b'1', b'1', b'1', b'0', b'0', b'1'),
  (10, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1', b'0', b'0', b'0', b'1', b'1', b'1', b'0', b'0', b'1'),
  (11, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1', b'0', b'0', b'0', b'1', b'1', b'1', b'0', b'0', b'1'),
  (12, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'1', b'0', b'0', b'0', b'1', b'1', b'1', b'0', b'1', b'1'),
  (13, b'0', b'0', b'0', b'1', b'1', b'0', b'0', b'0', b'0', b'0', b'1', b'0', b'0', b'0', b'1', b'1', b'1', b'0', b'0', b'1'),
  (14, b'0', b'0', b'0', b'1', b'1', b'0', b'1', b'0', b'0', b'0', b'1', b'1', b'0', b'1', b'1', b'1', b'1', b'0', b'0', b'1'),
  (15, b'0', b'0', b'0', b'1', b'1', b'0', b'0', b'0', b'0', b'0', b'1', b'1', b'0', b'1', b'1', b'1', b'1', b'0', b'0', b'1'),
  (16, b'0', b'0', b'0', b'1', b'1', b'0', b'0', b'0', b'0', b'0', b'1', b'1', b'0', b'1', b'1', b'1', b'1', b'0', b'0', b'1'),
  (17, b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
  (18, b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
  (19, b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `item_description`
--

DROP TABLE IF EXISTS `item_description`;
CREATE TABLE `item_description` (
  `item_id` int(11) NOT NULL,
  `item_name` tinytext,
  `item_desc` text,
  `price_coins` int(11) DEFAULT NULL,
  `price_stars` int(11) DEFAULT NULL,
  `item_rarity` varchar(45) DEFAULT NULL,
  `rank_accessibility` varchar(45) DEFAULT NULL,
  `game_category` tinyint(4) DEFAULT NULL,
  `item_minecraft_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `jukebox_stats`
--

DROP TABLE IF EXISTS `jukebox_stats`;
CREATE TABLE `jukebox_stats` (
  `uuid` binary(16) NOT NULL,
  `mehs` int(11) NOT NULL,
  `woots` int(11) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `played_time` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `moderation_permissions`
--

DROP TABLE IF EXISTS `moderation_permissions`;
CREATE TABLE `moderation_permissions` (
  `groups_id` tinyint(4) NOT NULL,
  `mod_ban` bit(1) NOT NULL,
  `mod_tp` bit(1) NOT NULL,
  `mod_kick` bit(1) NOT NULL,
  `mod_pardon` bit(1) NOT NULL,
  `mod_mute_longtime` bit(1) NOT NULL,
  `mod_mute` bit(1) NOT NULL,
  `mod_channel` bit(1) NOT NULL,
  `mod_channel_report` bit(1) NOT NULL,
  `mod_quiet` bit(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `moderation_permissions`
--

INSERT INTO `moderation_permissions` (`groups_id`, `mod_ban`, `mod_tp`, `mod_kick`, `mod_pardon`, `mod_mute_longtime`, `mod_mute`, `mod_channel`, `mod_channel_report`, `mod_quiet`) VALUES
  (1, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (2, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (3, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (4, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (5, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (6, b'0', b'0', b'0', b'0', b'0', b'1', b'1', b'1', b'0'),
  (7, b'0', b'0', b'0', b'0', b'0', b'1', b'1', b'1', b'1'),
  (8, b'0', b'0', b'0', b'0', b'0', b'1', b'1', b'1', b'1'),
  (9, b'0', b'0', b'0', b'0', b'0', b'1', b'1', b'1', b'1'),
  (10, b'0', b'0', b'0', b'0', b'0', b'1', b'1', b'1', b'1'),
  (11, b'0', b'0', b'0', b'0', b'0', b'1', b'1', b'1', b'1'),
  (12, b'0', b'0', b'0', b'0', b'0', b'1', b'1', b'1', b'1'),
  (13, b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
  (14, b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
  (15, b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
  (16, b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
  (17, b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
  (18, b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1'),
  (19, b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `nickname`
--

DROP TABLE IF EXISTS `nickname`;
CREATE TABLE `nickname` (
  `nick_id` int(11) NOT NULL,
  `nickname` varchar(16) CHARACTER SET utf8 COLLATE utf8_roman_ci NOT NULL,
  `blacklisted` bit(1) NOT NULL,
  `used` bit(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=843 DEFAULT CHARSET=utf32 COLLATE=utf32_roman_ci;

--
-- Contenu de la table `nickname`
--

INSERT INTO `nickname` (`nick_id`, `nickname`, `blacklisted`, `used`) VALUES
  (1, 'Meroc_Brandephin', b'0', b'0'),
  (2, 'Nimoc_Blanboc', b'0', b'0'),
  (3, 'Pome_Sacbouc', b'0', b'0'),
  (4, 'Trabon_Boupied', b'0', b'0'),
  (5, 'Ranmoc_Sonnepied', b'0', b'0'),
  (6, 'Solaloc_Bollot', b'0', b'0'),
  (7, 'Sololgas_Blangie', b'0', b'0'),
  (8, 'Bruboc_Boille', b'0', b'0'),
  (9, 'Sialas_Soupied', b'0', b'0'),
  (10, 'Drigoc_Toupied', b'0', b'0'),
  (11, 'Ligoc_Champique', b'0', b'0'),
  (12, 'Padin_Toupied', b'0', b'0'),
  (13, 'Trolon_Bomracine', b'0', b'0'),
  (14, 'Melin_Mouracine', b'0', b'0'),
  (15, 'Bialoc_Grandille', b'0', b'0'),
  (16, 'Tredion_Blanbouc', b'0', b'0'),
  (17, 'Soluilas_Foulot', b'0', b'0'),
  (18, 'Merroloc_Bobouc', b'0', b'0'),
  (19, 'Perraloc_Bolger', b'0', b'0'),
  (20, 'Brigon_Bogie', b'0', b'0'),
  (21, 'Brebas_Grandbuc', b'0', b'0'),
  (22, 'Rigoc_Vieildil', b'0', b'0'),
  (23, 'Rabas_Bolcor', b'0', b'0'),
  (24, 'Muigoc_Vieilboc', b'0', b'0'),
  (25, 'Maloc_Sanglepied', b'0', b'0'),
  (26, 'Trangoc_Fierdil', b'0', b'0'),
  (27, 'Biagas_Soubec', b'0', b'0'),
  (28, 'Troibe_Bravepied', b'0', b'0'),
  (29, 'Biogon_Blanboc', b'0', b'0'),
  (30, 'Oraboc_Fierpied', b'0', b'0'),
  (31, 'Polgoc_Vieilgie', b'0', b'0'),
  (32, 'Luiroc_Boupied', b'0', b'0'),
  (33, 'Orilas_Foubuc', b'0', b'0'),
  (34, 'Bolde_Braveque', b'0', b'0'),
  (35, 'Tragin_Mouracine', b'0', b'0'),
  (36, 'Nerion_Brandegie', b'0', b'0'),
  (37, 'Oranmoc_Bravegie', b'0', b'0'),
  (38, 'Merrure_Grandlot', b'0', b'0'),
  (39, 'Perredon_Bobadil', b'0', b'0'),
  (40, 'Bririn_Blanbouc', b'0', b'0'),
  (41, 'Briroc_Sacracine', b'0', b'0'),
  (42, 'Fririn_Foupied', b'0', b'0'),
  (43, 'Sanroc_Gameque', b'0', b'0'),
  (44, 'Lolmon_Bouille', b'0', b'0'),
  (45, 'Brigon_Brandegie', b'0', b'0'),
  (46, 'Terondon_Sacquet', b'0', b'0'),
  (47, 'Brandoc_Bravedil', b'0', b'0'),
  (48, 'Frodion_Tougie', b'0', b'0'),
  (49, 'Perrogoc_Boboc', b'0', b'0'),
  (50, 'Bruidin_Bodil', b'0', b'0'),
  (51, 'Bronrin_Fouque', b'0', b'0'),
  (52, 'Morogon_Gamebouc', b'0', b'0'),
  (53, 'Bibion_Gourdebec', b'0', b'0'),
  (54, 'Stidon_Brandeboc', b'0', b'0'),
  (55, 'Perremoc_Souque', b'0', b'0'),
  (56, 'Miroc_Mouque', b'0', b'0'),
  (57, 'Staron_Soupied', b'0', b'0'),
  (58, 'Soligin_Foubec', b'0', b'0'),
  (59, 'Luloc_Fierpied', b'0', b'0'),
  (60, 'Bromoc_Gourdegie', b'0', b'0'),
  (61, 'Perraroc_Bombouc', b'0', b'0'),
  (62, 'Stulon_Foulot', b'0', b'0'),
  (63, 'Peranras_Bolbec', b'0', b'0'),
  (64, 'Tragoc_Bravepied', b'0', b'0'),
  (65, 'Soigin_Bomracine', b'0', b'0'),
  (66, 'Oredoc_Marcheger', b'0', b'0'),
  (67, 'Barn_le_glorieux', b'0', b'0'),
  (68, 'Gag_le_crayeux', b'0', b'0'),
  (69, 'Bagrm_le_formel', b'0', b'0'),
  (70, 'Parurll_le_gras', b'0', b'0'),
  (71, 'Rush_le_fourbe', b'0', b'0'),
  (72, 'Grirm_le_glouton', b'0', b'0'),
  (73, 'Mourm_le_gras', b'0', b'0'),
  (74, 'Vormur_le_barbu', b'0', b'0'),
  (75, 'Com_le_furieux', b'0', b'0'),
  (76, 'Rikrr_le_gamin', b'0', b'0'),
  (77, 'Torn_le_gamin', b'0', b'0'),
  (78, 'Vrinrk_le_beau', b'0', b'0'),
  (79, 'Torrm_le_crayeux', b'0', b'0'),
  (80, 'Praw_le_colossal', b'0', b'0'),
  (81, 'Prador_le_beau', b'0', b'0'),
  (82, 'Tarlur_le_brutal', b'0', b'0'),
  (83, 'Knush_le_chevelu', b'0', b'0'),
  (84, 'Prom_le_fort', b'0', b'0'),
  (85, 'Erlur_le_boiteux', b'0', b'0'),
  (86, 'Tarmir_le_grand', b'0', b'0'),
  (87, 'Rikrn_le_beau', b'0', b'0'),
  (88, 'Edor_le_brutal', b'0', b'0'),
  (89, 'Mouw_le_chasseur', b'0', b'0'),
  (90, 'Koug_le_fugitif', b'0', b'0'),
  (91, 'Varr_le_grand', b'0', b'0'),
  (92, 'Kuzog_le_boiteux', b'0', b'0'),
  (93, 'Torsh_le_furieux', b'0', b'0'),
  (94, '_Hiril_Farondiel', b'0', b'0'),
  (95, 'Doril_Sirildilin', b'0', b'0'),
  (96, 'Valer_Inil', b'0', b'0'),
  (97, 'Turor_Ante', b'0', b'0'),
  (98, 'Aril_Seramiel', b'0', b'0'),
  (99, 'Elar_Brimentil', b'0', b'0'),
  (100, 'Numil_Glorril', b'0', b'0'),
  (101, 'Herer_Filiel', b'0', b'0'),
  (102, 'Lalul_Finiorer', b'0', b'0'),
  (103, 'Silior_Othieler', b'0', b'0'),
  (104, 'Fanur_Elen', b'0', b'0'),
  (105, 'Lalir_Othil', b'0', b'0'),
  (106, 'Nimul_Elieliel', b'0', b'0'),
  (107, 'Sirel_Arielin', b'0', b'0'),
  (108, 'Elur_Tore', b'0', b'0'),
  (109, 'Brimul_Filadrial', b'0', b'0'),
  (110, 'Fanul_Filondial', b'0', b'0'),
  (111, 'Athon_Sere', b'0', b'0'),
  (112, 'Turur_Athonde', b'0', b'0'),
  (113, 'Pelen_Ciryen', b'0', b'0'),
  (114, 'Numor_Peler', b'0', b'0'),
  (115, 'Finar_Fildaror', b'0', b'0'),
  (116, 'Ciryin_Neril', b'0', b'0'),
  (117, 'Filiel_Athis', b'0', b'0'),
  (118, 'Turil_Athanatir', b'0', b'0'),
  (119, 'Anil_Lalial', b'0', b'0'),
  (120, 'Filon_Isdacel', b'0', b'0'),
  (121, 'Faril_Heronderil', b'0', b'0'),
  (122, 'Finul_Ciryiel', b'0', b'0'),
  (123, 'Athor_Turambir', b'0', b'0'),
  (124, 'Othen_Serelur', b'0', b'0'),
  (125, 'Torar_Hiriorial', b'0', b'0'),
  (126, 'Calar_Gloril', b'0', b'0'),
  (127, 'Thanar_Tordacial', b'0', b'0'),
  (128, 'Finur_Lalel', b'0', b'0'),
  (129, 'Elir_Nariondiel', b'0', b'0'),
  (130, 'Ison_Fardarul', b'0', b'0'),
  (131, 'Athon_Turil', b'0', b'0'),
  (132, 'Thanor_Isen', b'0', b'0'),
  (133, 'Elil_Terumil', b'0', b'0'),
  (134, 'Finiel_Fanis', b'0', b'0'),
  (135, 'Tarur_Arel', b'0', b'0'),
  (136, 'Finin_Isisel', b'0', b'0'),
  (137, 'Athin_Elilial', b'0', b'0'),
  (138, 'Farer_Filor', b'0', b'0'),
  (139, 'Narer_Seriniel', b'0', b'0'),
  (140, 'Lalen_Atenen', b'0', b'0'),
  (141, 'Artil_Nimil', b'0', b'0'),
  (142, '_Henam_Sharsar', b'0', b'0'),
  (143, 'Prebos_Leoriral', b'0', b'0'),
  (144, 'Alvard_Ydod', b'0', b'0'),
  (145, 'Meron_Gresath', b'0', b'0'),
  (146, 'Tolvam_Jean', b'0', b'0'),
  (147, 'Leonam_Jalvus', b'0', b'0'),
  (148, 'Helver_Thodan', b'0', b'0'),
  (149, 'Todur_Rakon', b'0', b'0'),
  (150, 'Brolatath_Ralan', b'0', b'0'),
  (151, 'Rillot_Brertan', b'0', b'0'),
  (152, 'Hesus_Rersien', b'0', b'0'),
  (153, 'Thobion_Ugrapeth', b'0', b'0'),
  (154, 'Boros_Trallir', b'0', b'0'),
  (155, 'Satis_Piperas', b'0', b'0'),
  (156, 'Jircard_Bakin', b'0', b'0'),
  (157, 'Idot_Drothis', b'0', b'0'),
  (158, 'Rarsien_Daon', b'0', b'0'),
  (159, 'Jiton_Retelan', b'0', b'0'),
  (160, 'Thogosus_Oceor', b'0', b'0'),
  (161, 'Ubreth_Azan', b'0', b'0'),
  (162, 'Redert_Disel', b'0', b'0'),
  (163, 'Drucan_Mesor', b'0', b'0'),
  (164, 'Lunen_Propis', b'0', b'0'),
  (165, 'Lisas_Bobril', b'0', b'0'),
  (166, 'Daulvas_Thobrel', b'0', b'0'),
  (167, 'Helal_Litan', b'0', b'0'),
  (168, 'Uden_Thersion', b'0', b'0'),
  (169, 'Upath_Piris', b'0', b'0'),
  (170, 'Jadircer_Cabien', b'0', b'0'),
  (171, 'Jemilvien_Leoner', b'0', b'0'),
  (172, 'Othur_Salan', b'0', b'0'),
  (173, 'Theregros_Luser', b'0', b'0'),
  (174, 'Hilar_Rire', b'0', b'0'),
  (175, 'Iscan_Nadas', b'0', b'0'),
  (176, 'Hertien_Jimard', b'0', b'0'),
  (177, 'Jeton_Brelar', b'0', b'0'),
  (178, 'Ukal_Daurcod', b'0', b'0'),
  (179, 'Hinorcen_Darcard', b'0', b'0'),
  (180, 'Pason_Latheth', b'0', b'0'),
  (181, 'Aton_Runtheth', b'0', b'0'),
  (182, 'Hemath_Ebis', b'0', b'0'),
  (183, 'Grevur_Luzus', b'0', b'0'),
  (184, 'Savus_Dramben', b'0', b'0'),
  (185, 'Thelar_Narath', b'0', b'0'),
  (186, 'Medath_Thortan', b'0', b'0'),
  (187, 'Cambard_Ylursan', b'0', b'0'),
  (188, 'Proman_Ralvon', b'0', b'0'),
  (189, 'Hilesath_Resen', b'0', b'0'),
  (190, 'Poral_Pidus', b'0', b'0'),
  (191, 'Dirien_Premot', b'0', b'0'),
  (192, 'Leobrus_Memimeth', b'0', b'0'),
  (193, 'Sethor_Heten', b'0', b'0'),
  (194, 'Pemard_Droot', b'0', b'0'),
  (195, 'Komam_Breion', b'0', b'0'),
  (196, 'Prelas_Barur', b'0', b'0'),
  (197, 'Thesod_Rimban', b'0', b'0'),
  (198, 'Redimbin_Grebal', b'0', b'0'),
  (199, 'Sorise_Aner', b'0', b'0'),
  (200, 'Haram_Didan', b'0', b'0'),
  (201, 'Mesil_Lortan', b'0', b'0'),
  (202, 'Hemus_Zarin', b'0', b'0'),
  (203, 'Lurtis_Pirert', b'0', b'0'),
  (204, 'Dolel_Druperam', b'0', b'0'),
  (205, 'Jinan_Dralorcal', b'0', b'0'),
  (206, 'Solin_Premot', b'0', b'0'),
  (207, 'Etus_Grelinrtan', b'0', b'0'),
  (208, 'Acil_Lasur', b'0', b'0'),
  (209, 'Grembos_Megel', b'0', b'0'),
  (210, 'Eder_Vacis', b'0', b'0'),
  (211, 'Saudor_Thomircen', b'0', b'0'),
  (212, 'Mersis_Randath', b'0', b'0'),
  (213, 'Thepot_Rellas', b'0', b'0'),
  (214, 'Sausath_Gider', b'0', b'0'),
  (215, 'Fikus_Regrot', b'0', b'0'),
  (216, 'Haal_Bombien', b'0', b'0'),
  (217, 'Marien_Solan', b'0', b'0'),
  (218, 'Rimbeth_Fibris', b'0', b'0'),
  (219, 'Repil_Greredard', b'0', b'0'),
  (220, 'Fiman_Jegrert', b'0', b'0'),
  (221, 'Litod_Vapir', b'0', b'0'),
  (222, 'Daudel_Ombus', b'0', b'0'),
  (223, 'Melan_Shatevas', b'0', b'0'),
  (224, 'Kodan_Buten', b'0', b'0'),
  (225, 'Hior_Vascion', b'0', b'0'),
  (226, 'Ritegron_Thebion', b'0', b'0'),
  (227, 'Domon_Tonarar', b'0', b'0'),
  (228, 'Brevis_Jetoer', b'0', b'0'),
  (229, 'Midar_Buard', b'0', b'0'),
  (230, 'Mabot_Bodis', b'0', b'0'),
  (231, 'Jetil_Melalvis', b'0', b'0'),
  (232, 'Ydebod_Brarsath', b'0', b'0'),
  (233, 'Mimiteth_Zaris', b'0', b'0'),
  (234, 'Libras_Bomor', b'0', b'0'),
  (235, 'Daulve_Kolain', b'0', b'0'),
  (236, 'Sabod_Brecin', b'0', b'0'),
  (237, 'Damas_Siver', b'0', b'0'),
  (238, '_Rheke_Domens', b'0', b'0'),
  (239, 'Gurry_Anov', b'0', b'0'),
  (240, 'Iakin_Harkobac', b'0', b'0'),
  (241, 'Blaivan_Spilski', b'0', b'0'),
  (242, 'Kok_Chimaebac', b'0', b'0'),
  (243, 'Barell_Anho', b'0', b'0'),
  (244, 'Rhecan_Corkos', b'0', b'0'),
  (245, 'Lankin_Dokor', b'0', b'0'),
  (246, 'Dar_Lonov', b'0', b'0'),
  (247, 'Kunb_Atine', b'0', b'0'),
  (248, 'Miger_Bunnak', b'0', b'0'),
  (249, 'Lenb_Spilbac', b'0', b'0'),
  (250, 'Rhilik_Pieness', b'0', b'0'),
  (251, 'Gurgan_Gowski', b'0', b'0'),
  (252, 'Lanrek_Skybi', b'0', b'0'),
  (253, 'Heb_Skyda', b'0', b'0'),
  (254, 'Hab_Harmann', b'0', b'0'),
  (255, 'Dungan_Donov', b'0', b'0'),
  (256, 'Monnik_Orssian', b'0', b'0'),
  (257, 'Kocan_Darsom', b'0', b'0'),
  (258, 'Deney_Hanov', b'0', b'0'),
  (259, 'Lando_Ande', b'0', b'0'),
  (260, 'Migan_Baman', b'0', b'0'),
  (261, 'Legan_Babac', b'0', b'0'),
  (262, 'Bondo_Ariper', b'0', b'0'),
  (263, 'Malik_Gosam', b'0', b'0'),
  (264, 'Nuno_Skybac', b'0', b'0'),
  (265, 'Deerek_Skyvel', b'0', b'0'),
  (266, 'Kunlek_Pieman', b'0', b'0'),
  (267, 'Tedam_Ackda', b'0', b'0'),
  (268, 'Miwen_Akor', b'0', b'0'),
  (269, 'Bonk_Calmann', b'0', b'0'),
  (270, 'Nuran_Darssian', b'0', b'0'),
  (271, 'Tek_Erador', b'0', b'0'),
  (272, 'Ialik_Bukor', b'0', b'0'),
  (273, 'Brivan_Palnak', b'0', b'0'),
  (274, 'Tekin_Harra', b'0', b'0'),
  (275, 'Newen_Thrawdor', b'0', b'0'),
  (276, 'Cekin_Femens', b'0', b'0'),
  (277, 'Cek_Neelo', b'0', b'0'),
  (278, 'Kocan_Jakoness', b'0', b'0'),
  (279, 'Rodatt_Jakoda', b'0', b'0'),
  (280, 'Oll_Thrawchov', b'0', b'0'),
  (281, 'Blaito_Mothriper', b'0', b'0'),
  (282, 'Nunik_Skykis', b'0', b'0'),
  (283, 'Sandatt_Darnans', b'0', b'0'),
  (284, 'Hecus_Chimaede', b'0', b'0'),
  (285, 'Nuk_Chimaetine', b'0', b'0'),
  (286, 'Thannik_Vade', b'0', b'0'),
  (287, 'Munwen_Orman', b'0', b'0'),
  (288, 'Kek_Haara', b'0', b'0'),
  (289, 'Iakin_Sokis', b'0', b'0'),
  (290, 'Rhilik_Idatine', b'0', b'0'),
  (291, 'Blairan_Bulo', b'0', b'0'),
  (292, 'Tecan_Bunak', b'0', b'0'),
  (293, 'Iaran_Erakis', b'0', b'0'),
  (294, 'Bonlik_Calman', b'0', b'0'),
  (295, 'Ludam_Harder', b'0', b'0'),
  (296, 'Danrell_Ackllek', b'0', b'0'),
  (297, 'Nadge_Calrillek', b'0', b'0'),
  (298, 'Blairan_Skyriper', b'0', b'0'),
  (299, 'Blaib_Caltine', b'0', b'0'),
  (300, 'Lenger_Erakis', b'0', b'0'),
  (301, 'Grin_Vavel', b'0', b'0'),
  (302, 'Obill_Palrel', b'0', b'0'),
  (303, 'Nuvan_Buntine', b'0', b'0'),
  (304, 'Onik_Hanna', b'0', b'0'),
  (305, 'Pauke_Goriper', b'0', b'0'),
  (306, 'Heney_Orkeefe', b'0', b'0'),
  (307, 'Sanwen_Harda', b'0', b'0'),
  (308, 'Danar_Darrek', b'0', b'0'),
  (309, 'Andge_Basom', b'0', b'0'),
  (310, 'Lolek_Jakoara', b'0', b'0'),
  (311, 'Newen_Spilma', b'0', b'0'),
  (312, 'Daggs_Buntt', b'0', b'0'),
  (313, 'Bondo_Thrawho', b'0', b'0'),
  (314, 'Magan_Vassian', b'0', b'0'),
  (315, 'Leger_Jatine', b'0', b'0'),
  (316, 'Iar_Skygana', b'0', b'0'),
  (317, 'Brilik_Erader', b'0', b'0'),
  (318, 'Cegan_Ornen', b'0', b'0'),
  (319, 'Kogan_Gona', b'0', b'0'),
  (320, 'Renry_Gokor', b'0', b'0'),
  (321, 'Mando_Ackski', b'0', b'0'),
  (322, 'Kerell_Banov', b'0', b'0'),
  (323, 'Munger_Darmann', b'0', b'0'),
  (324, 'Ok_Anen', b'0', b'0'),
  (325, 'Dak_Calra', b'0', b'0'),
  (326, 'Manpren_Sokor', b'0', b'0'),
  (327, 'Degan_Idatt', b'0', b'0'),
  (328, 'Lul_Ackra', b'0', b'0'),
  (329, 'Darek_Dargana', b'0', b'0'),
  (330, 'Locan_Harkos', b'0', b'0'),
  (331, 'Hell_Jakoda', b'0', b'0'),
  (332, 'Monvan_Hakis', b'0', b'0'),
  (333, 'Gundar_Bunmens', b'0', b'0'),
  (334, 'Lannik_Vador', b'0', b'0'),
  (335, 'Danggs_Sokos', b'0', b'0'),
  (336, '_Falka_Tolemrum', b'0', b'0'),
  (337, 'Milo_Worlin', b'0', b'0'),
  (338, 'Dax_Zagerthio', b'0', b'0'),
  (339, 'Boro_Fennion', b'0', b'0'),
  (340, 'Draze_Helltus', b'0', b'0'),
  (341, 'Josev_Zemvicta', b'0', b'0'),
  (342, 'Ekoh_Sonsal', b'0', b'0'),
  (343, 'Elthan_Zemian', b'0', b'0'),
  (344, 'Elthan_Sondar', b'0', b'0'),
  (345, 'Scipio_Nemiel', b'0', b'0'),
  (346, 'Criid_Frauka', b'0', b'0'),
  (347, 'Dax_Impebear', b'0', b'0'),
  (348, 'Jader_Wolfeas', b'0', b'0'),
  (349, 'Skoh_Koll', b'0', b'0'),
  (350, 'Macharius_Tharn', b'0', b'0'),
  (351, 'Anders_Binders', b'0', b'0'),
  (352, 'Anders_Tiguius', b'0', b'0'),
  (353, 'Zeph_Asteltes', b'0', b'0'),
  (354, 'Josev_Astelillus', b'0', b'0'),
  (355, 'Falka_Yoncy', b'0', b'0'),
  (356, 'Skoh_Nayl', b'0', b'0'),
  (357, 'Hark_Stormdane', b'0', b'0'),
  (358, 'Anders_Holtum', b'0', b'0'),
  (359, 'Bragg_Corbec', b'0', b'0'),
  (360, 'Falka_Limbwall', b'0', b'0'),
  (361, 'Jader_Hehteng', b'0', b'0'),
  (362, 'Skoh_Limbwall', b'0', b'0'),
  (363, 'Brin_Arkio', b'0', b'0'),
  (364, 'Dersk_Nova', b'0', b'0'),
  (365, 'Anders_Cruxil', b'0', b'0'),
  (366, 'Dersk_Lutdz', b'0', b'0'),
  (367, 'Kyband_Tharn', b'0', b'0'),
  (368, 'Curth_Dercius', b'0', b'0'),
  (369, 'Konrad_Ravenrum', b'0', b'0'),
  (370, 'Varl_Nayl', b'0', b'0'),
  (371, 'Falka_Leznic', b'0', b'0'),
  (372, 'Dersk_Astellan', b'0', b'0'),
  (373, 'Dersk_Holion', b'0', b'0'),
  (374, 'Anko_Nayl', b'0', b'0'),
  (375, 'Elyas_Holis', b'0', b'0'),
  (376, 'Varl_Dartes', b'0', b'0'),
  (377, 'Wilhelm_Futhark', b'0', b'0'),
  (378, 'Brin_Adatus', b'0', b'0'),
  (379, 'Kalder_Tharser', b'0', b'0'),
  (380, 'Zaul_Nayl', b'0', b'0'),
  (381, 'Stef_Blenner', b'0', b'0'),
  (382, 'Khordel_Haakon', b'0', b'0'),
  (383, 'Olyvier_Tuvant', b'0', b'0'),
  (384, 'Criid_Kenshen', b'0', b'0'),
  (385, 'Varl_Dalin', b'0', b'0'),
  (386, 'Bragg_Haller', b'0', b'0'),
  (387, 'Carl_Kovendane', b'0', b'0'),
  (388, 'Zeph_Ektae', b'0', b'0'),
  (389, 'Zeph_Arkio', b'0', b'0'),
  (390, 'Harlon_Xeres', b'0', b'0'),
  (391, 'Varen_Holdis', b'0', b'0'),
  (392, 'Cuu_Helliva', b'0', b'0'),
  (393, 'Varen_Fennion', b'0', b'0'),
  (394, 'Cuu_Futhark', b'0', b'0'),
  (395, 'Elthan_Adepdar', b'0', b'0'),
  (396, 'Gideon_Bazarov', b'0', b'0'),
  (397, 'Lesp_Hehteng', b'0', b'0'),
  (398, 'Olyvier_Rawne', b'0', b'0'),
  (399, 'Criid_Zemtus', b'0', b'0'),
  (400, 'Caff_Tharthon', b'0', b'0'),
  (401, 'Varko_Zagerrum', b'0', b'0'),
  (402, 'Dax_Ashlag', b'0', b'0'),
  (403, 'Criid_Boltthon', b'0', b'0'),
  (404, 'Varko_Karto', b'0', b'0'),
  (405, 'Falka_Helldane', b'0', b'0'),
  (406, 'Ranklin_Fennion', b'0', b'0'),
  (407, 'Dax_Kovenvictus', b'0', b'0'),
  (408, 'Kyband_Ravenicus', b'0', b'0'),
  (409, 'Nash_Yoncy', b'0', b'0'),
  (410, 'Brin_Tarken', b'0', b'0'),
  (411, 'Konrad_Futhark', b'0', b'0'),
  (412, 'Quintus_Zemser', b'0', b'0'),
  (413, 'Draze_Thracian', b'0', b'0'),
  (414, 'Karsh_Xunther', b'0', b'0'),
  (415, 'Carl_Corbec', b'0', b'0'),
  (416, 'Hark_Ekrium', b'0', b'0'),
  (417, 'Ratko_Astellan', b'0', b'0'),
  (418, 'Skoh_Tiguis', b'0', b'0'),
  (419, 'Zigmund_Kardis', b'0', b'0'),
  (420, 'Zigmund_Zordane', b'0', b'0'),
  (421, 'Quintus_Zorael', b'0', b'0'),
  (422, 'Kreff_Astellan', b'0', b'0'),
  (423, 'Hark_Larceus', b'0', b'0'),
  (424, 'Draze_Zemmic', b'0', b'0'),
  (425, 'Lesp_Yoncy', b'0', b'0'),
  (426, 'Jader_Tiguvictus', b'0', b'0'),
  (427, '_Olaf_Sigvaldson', b'0', b'0'),
  (428, 'Frode_Osfridson', b'0', b'0'),
  (429, 'Holger_Sverreson', b'0', b'0'),
  (430, 'Thorolf_Rolfson', b'0', b'0'),
  (431, 'Runi_Rolfson', b'0', b'0'),
  (432, 'Turold_Rurikson', b'0', b'0'),
  (433, 'Ranulf_Arvidson', b'0', b'0'),
  (434, 'Snorri_Holgerson', b'0', b'0'),
  (435, 'Runi_Valterson', b'0', b'0'),
  (436, 'Sigvard_Knudson', b'0', b'0'),
  (437, 'Oluf_Odomarson', b'0', b'0'),
  (438, 'Sigurd_Sejerson', b'0', b'0'),
  (439, 'Erik_Helgison', b'0', b'0'),
  (440, 'Sejer_Haraldson', b'0', b'0'),
  (441, 'Halvor_Sigurdson', b'0', b'0'),
  (442, 'Haldor_Ranulfson', b'0', b'0'),
  (443, 'Frederik_Knutson', b'0', b'0'),
  (444, 'Halvor_Hagenson', b'0', b'0'),
  (445, 'Hakon_Ivarson', b'0', b'0'),
  (446, 'Havard_Knutson', b'0', b'0'),
  (447, 'Osbern_Asgeirson', b'0', b'0'),
  (448, 'Uwe_Hrolfson', b'0', b'0'),
  (449, 'Sigvard_Eskilson', b'0', b'0'),
  (450, 'Asulf_Arnvaldson', b'0', b'0'),
  (451, 'Thorolf_Sigerson', b'0', b'0'),
  (452, 'Grim_Sigvardson', b'0', b'0'),
  (453, 'Siger_Olufson', b'0', b'0'),
  (454, 'Snorri_Aslakson', b'0', b'0'),
  (455, 'Terkel_Aslakson', b'0', b'0'),
  (456, 'Vilfrid_Arwedson', b'0', b'0'),
  (457, 'Hakon_Ragnarson', b'0', b'0'),
  (458, 'Njall_Sigerson', b'0', b'0'),
  (459, 'Veland_Stigson', b'0', b'0'),
  (460, 'Eirik_Arnvaldson', b'0', b'0'),
  (461, 'Asulf_Ulfson', b'0', b'0'),
  (462, 'Skeggi_Bertilson', b'0', b'0'),
  (463, 'Knud_Leifson', b'0', b'0'),
  (464, 'Sigvald_Eskilson', b'0', b'0'),
  (465, 'Ole_Olufson', b'0', b'0'),
  (466, 'Hrolf_Velandson', b'0', b'0'),
  (467, 'Ulv_Godfredson', b'0', b'0'),
  (468, 'Hakon_Herulfson', b'0', b'0'),
  (469, 'Hakon_Svendson', b'0', b'0'),
  (470, 'Ivar_Hermodson', b'0', b'0'),
  (471, 'Snorri_Olafson', b'0', b'0'),
  (472, 'Olrik_Holgerson', b'0', b'0'),
  (473, 'Ingvald_Olrikson', b'0', b'0'),
  (474, 'Arvid_Osbernson', b'0', b'0'),
  (475, 'Ivar_Svartingson', b'0', b'0'),
  (476, 'Roald_Thorolfson', b'0', b'0'),
  (477, 'Thormod_Olafson', b'0', b'0'),
  (478, 'Ole_Holgerson', b'0', b'0'),
  (479, 'Grim_Erikson', b'0', b'0'),
  (480, 'Erling_Oleson', b'0', b'0'),
  (481, 'Ketil_Knutson', b'0', b'0'),
  (482, '_Luderik', b'0', b'0'),
  (483, 'Luderik', b'0', b'0'),
  (484, 'Erwin', b'0', b'0'),
  (485, 'Lambert', b'0', b'0'),
  (486, 'Manfred', b'0', b'0'),
  (487, 'Hubert', b'0', b'0'),
  (488, 'Godfred', b'0', b'0'),
  (489, 'Norbert', b'0', b'0'),
  (490, 'Alwin', b'0', b'0'),
  (491, 'Henrik', b'0', b'0'),
  (492, 'Wido', b'0', b'0'),
  (493, 'Wilhelm', b'0', b'0'),
  (494, 'Frank', b'0', b'0'),
  (495, 'Otmar', b'0', b'0'),
  (496, 'Otger', b'0', b'0'),
  (497, 'Gervin', b'0', b'0'),
  (498, 'Norbert', b'0', b'0'),
  (499, 'Ditbert', b'0', b'0'),
  (500, 'Falko', b'0', b'0'),
  (501, 'Gervin', b'0', b'0'),
  (502, 'Ingmar', b'0', b'0'),
  (503, 'Walther', b'0', b'0'),
  (504, 'Rodger', b'0', b'0'),
  (505, 'Hagen', b'0', b'0'),
  (506, 'Fredegar', b'0', b'0'),
  (507, 'Baldwin', b'0', b'0'),
  (508, 'Herbert', b'0', b'0'),
  (509, 'Sigfrid', b'0', b'0'),
  (510, 'Robert', b'0', b'0'),
  (511, 'Godfred', b'0', b'0'),
  (512, 'Richard', b'0', b'0'),
  (513, 'Answald', b'0', b'0'),
  (514, 'Till', b'0', b'0'),
  (515, 'Hugo', b'0', b'0'),
  (516, 'Wilhelm', b'0', b'0'),
  (517, 'Ulrik', b'0', b'0'),
  (518, 'Herbert', b'0', b'0'),
  (519, 'Dltwin', b'0', b'0'),
  (520, 'Adalrik', b'0', b'0'),
  (521, 'Ingmar', b'0', b'0'),
  (522, 'Adalrik', b'0', b'0'),
  (523, 'Gervald', b'0', b'0'),
  (524, 'Alwin', b'0', b'0'),
  (525, 'Answald', b'0', b'0'),
  (526, 'Falko', b'0', b'0'),
  (527, 'Otvard', b'0', b'0'),
  (528, 'Almut', b'0', b'0'),
  (529, 'Diter', b'0', b'0'),
  (530, 'Markvart', b'0', b'0'),
  (531, 'Bernulf', b'0', b'0'),
  (532, 'Hilbert', b'0', b'0'),
  (533, 'Froward', b'0', b'0'),
  (534, 'Diter', b'0', b'0'),
  (535, 'Gilbert', b'0', b'0'),
  (536, 'Till', b'0', b'0'),
  (537, 'Gerwald', b'0', b'0'),
  (538, 'Ansfrid', b'0', b'0'),
  (539, 'Robert', b'0', b'0'),
  (540, 'Didrik', b'0', b'0'),
  (541, 'Rambert', b'0', b'0'),
  (542, 'Wilfrid', b'0', b'0'),
  (543, 'Gerolf', b'0', b'0'),
  (544, 'Radulf', b'0', b'0'),
  (545, 'Ditmar', b'0', b'0'),
  (546, 'Erwin', b'0', b'0'),
  (547, 'Sigmund', b'0', b'0'),
  (548, 'Luderik', b'0', b'0'),
  (549, 'Wiland', b'0', b'0'),
  (550, 'Roderik', b'0', b'0'),
  (551, 'Diter', b'0', b'0'),
  (552, 'Hubert', b'0', b'0'),
  (553, 'Gilbert', b'0', b'0'),
  (554, 'Otvard', b'0', b'0'),
  (555, 'Frank', b'0', b'0'),
  (556, 'Edouard', b'0', b'0'),
  (557, 'Lothar', b'0', b'0'),
  (558, 'Baldwin', b'0', b'0'),
  (559, 'Ditbert', b'0', b'0'),
  (560, 'Diter', b'0', b'0'),
  (561, 'Reginald', b'0', b'0'),
  (562, 'Almar', b'0', b'0'),
  (563, 'Gildwin', b'0', b'0'),
  (564, 'Wilfrid', b'0', b'0'),
  (565, 'Wido', b'0', b'0'),
  (566, 'Norbert', b'0', b'0'),
  (567, 'Tankred', b'0', b'0'),
  (568, 'Gunter', b'0', b'0'),
  (569, 'Baldrik', b'0', b'0'),
  (570, 'Gunter', b'0', b'0'),
  (571, 'Frowin', b'0', b'0'),
  (572, 'Dirk', b'0', b'0'),
  (573, 'Ditbert', b'0', b'0'),
  (574, 'Klothar', b'0', b'0'),
  (575, 'Almar', b'0', b'0'),
  (576, 'Frowin', b'0', b'0'),
  (577, 'Almar', b'0', b'0'),
  (578, 'Frowin', b'0', b'0'),
  (579, 'Gerolf', b'0', b'0'),
  (580, 'Frowin', b'0', b'0'),
  (581, '_Tokitake_Sugino', b'0', b'0'),
  (582, 'Shimoue_Kaneao', b'0', b'0'),
  (583, 'Yoshi_Naka', b'0', b'0'),
  (584, 'Iwa_Hidekaka', b'0', b'0'),
  (585, 'Higakaka_Asasugi', b'0', b'0'),
  (586, 'Tada_Hata', b'0', b'0'),
  (587, 'Bata_Uji', b'0', b'0'),
  (588, 'Yoko_Mune', b'0', b'0'),
  (589, 'Kunishima_Bata', b'0', b'0'),
  (590, 'Shishi_Zawamae', b'0', b'0'),
  (591, 'Tokishima_Kitano', b'0', b'0'),
  (592, 'Sakasaka_Mori', b'0', b'0'),
  (593, 'Katsuhiga_Yoko', b'0', b'0'),
  (594, 'Morimura_Hashiki', b'0', b'0'),
  (595, 'Yoshiki_Da', b'0', b'0'),
  (596, 'Datake_Bayaaka', b'0', b'0'),
  (597, 'Taka_Yokosugi', b'0', b'0'),
  (598, 'Shi_Mitsuoka', b'0', b'0'),
  (599, 'Yorikawa_Akazawa', b'0', b'0'),
  (600, 'Kisugi_Yama', b'0', b'0'),
  (601, 'Okanishi_Yone', b'0', b'0'),
  (602, 'Asaba_Kunihata', b'0', b'0'),
  (603, 'Tokikaka_Sakamae', b'0', b'0'),
  (604, 'Sugihaya_Masa', b'0', b'0'),
  (605, 'Sugi_Tsukada', b'0', b'0'),
  (606, 'Tomomura_Ujiike', b'0', b'0'),
  (607, 'Tokitani_Kaka', b'0', b'0'),
  (608, 'Hatanishi_Sane', b'0', b'0'),
  (609, 'Taniasa_Yamakaka', b'0', b'0'),
  (610, 'Tsukayone_Takuro', b'0', b'0'),
  (611, 'Shitada_Kuronuma', b'0', b'0'),
  (612, 'Yoriiwa_Uchiao', b'0', b'0'),
  (613, 'Yorikami_Muraaka', b'0', b'0'),
  (614, 'Moriasa_Aki', b'0', b'0'),
  (615, 'Yasu_Nishiuchi', b'0', b'0'),
  (616, 'Shikita_Tomokawa', b'0', b'0'),
  (617, 'Kuro_Shi', b'0', b'0'),
  (618, 'Shigeyoko_Iwa', b'0', b'0'),
  (619, 'Akitsuka_Kami', b'0', b'0'),
  (620, 'Kawada_Hide', b'0', b'0'),
  (621, 'Maehashi_Aota', b'0', b'0'),
  (622, 'Tsuna_Minamino', b'0', b'0'),
  (623, 'Nishitake_Jima', b'0', b'0'),
  (624, 'Taka_Tokisaka', b'0', b'0'),
  (625, 'Hayaba_Uchijima', b'0', b'0'),
  (626, 'Sugino_Saneshima', b'0', b'0'),
  (627, 'Oka_Tsuguhata', b'0', b'0'),
  (628, 'Naga_Tsuna', b'0', b'0'),
  (629, 'Zawa_Tokiao', b'0', b'0'),
  (630, 'Sugifuka_Yoneki', b'0', b'0'),
  (631, 'Kane_Yasu', b'0', b'0'),
  (632, 'Nobu_Tsunamori', b'0', b'0'),
  (633, 'Hayakami_Mori', b'0', b'0'),
  (634, 'Norizawa_Hideasa', b'0', b'0'),
  (635, 'Nori_Shitaao', b'0', b'0'),
  (636, 'Tsunasaka_Maeike', b'0', b'0'),
  (637, 'Naga_Uji', b'0', b'0'),
  (638, 'Noriaka_Mori', b'0', b'0'),
  (639, 'Takaiwa_Saka', b'0', b'0'),
  (640, 'Uji_Baya', b'0', b'0'),
  (641, 'Mizumizu_Bata', b'0', b'0'),
  (642, 'Mitsuyama_Naka', b'0', b'0'),
  (643, 'Mitsukaka_Nishi', b'0', b'0'),
  (644, 'Hidejima_Uenaka', b'0', b'0'),
  (645, 'Yasusugi_Shisawa', b'0', b'0'),
  (646, 'Takemae_Yoshiasa', b'0', b'0'),
  (647, 'Bata_Kaneoka', b'0', b'0'),
  (648, 'Hideita_Sanemizu', b'0', b'0'),
  (649, 'Ta_Tsugufuka', b'0', b'0'),
  (650, 'Okashimo_Nosawa', b'0', b'0'),
  (651, 'Uchi_Iesugi', b'0', b'0'),
  (652, 'Noda_Shima', b'0', b'0'),
  (653, 'Nobu_Takamizu', b'0', b'0'),
  (654, 'Shige_Numaoka', b'0', b'0'),
  (655, 'Tsugu_Hayafuka', b'0', b'0'),
  (656, '_Andromax', b'0', b'0'),
  (657, 'Abrarith', b'0', b'0'),
  (658, 'Limman', b'0', b'0'),
  (659, 'Agamelet', b'0', b'0'),
  (660, 'Byberith', b'0', b'0'),
  (661, 'Moher', b'0', b'0'),
  (662, 'Azahel', b'0', b'0'),
  (663, 'Azaphoman', b'0', b'0'),
  (664, 'Moberel', b'0', b'0'),
  (665, 'Byssagax', b'0', b'0'),
  (666, 'Abamoch', b'0', b'0'),
  (667, 'Anphomech', b'0', b'0'),
  (668, 'Apolas', b'0', b'0'),
  (669, 'Agaddus', b'0', b'0'),
  (670, 'Vasal', b'0', b'0'),
  (671, 'Paiuth', b'0', b'0'),
  (672, 'Amdussagus', b'0', b'0'),
  (673, 'Liphomial', b'0', b'0'),
  (674, 'Stouth', b'0', b'0'),
  (675, 'Aguagal', b'0', b'0'),
  (676, 'Ababor', b'0', b'0'),
  (677, 'Ababor', b'0', b'0'),
  (678, 'Paidrith', b'0', b'0'),
  (679, 'Abrammel', b'0', b'0'),
  (680, 'Apolal', b'0', b'0'),
  (681, 'Naddon', b'0', b'0'),
  (682, 'Listor', b'0', b'0'),
  (683, 'Bemech', b'0', b'0'),
  (684, 'Abaheth', b'0', b'0'),
  (685, 'Nestaroth', b'0', b'0'),
  (686, 'Vasas', b'0', b'0'),
  (687, 'Alalym', b'0', b'0'),
  (688, 'Salus', b'0', b'0'),
  (689, 'Adracifel', b'0', b'0'),
  (690, 'Azaech', b'0', b'0'),
  (691, 'Agaan', b'0', b'0'),
  (692, 'Sasius', b'0', b'0'),
  (693, 'Natech', b'0', b'0'),
  (694, 'Andreammus', b'0', b'0'),
  (695, 'Aladdas', b'0', b'0'),
  (696, 'Lubeth', b'0', b'0'),
  (697, 'Amdugan', b'0', b'0'),
  (698, 'Lilym', b'0', b'0'),
  (699, 'Abracifias', b'0', b'0'),
  (700, 'Storial', b'0', b'0'),
  (701, 'Ludret', b'0', b'0'),
  (702, 'Zamelax', b'0', b'0'),
  (703, 'Asmocifym', b'0', b'0'),
  (704, 'Lurias', b'0', b'0'),
  (705, 'Molias', b'0', b'0'),
  (706, 'Asmorius', b'0', b'0'),
  (707, 'Asmomas', b'0', b'0'),
  (708, 'Androdruth', b'0', b'0'),
  (709, 'Andrassagel', b'0', b'0'),
  (710, 'Mocifel', b'0', b'0'),
  (711, 'Neberan', b'0', b'0'),
  (712, 'Androroth', b'0', b'0'),
  (713, 'Vatet', b'0', b'0'),
  (714, 'Abaddax', b'0', b'0'),
  (715, 'Abradroch', b'0', b'0'),
  (716, 'Adrastaroth', b'0', b'0'),
  (717, 'Aporech', b'0', b'0'),
  (718, 'Lugym', b'0', b'0'),
  (719, 'Vaddius', b'0', b'0'),
  (720, 'Vaguth', b'0', b'0'),
  (721, 'Aporgax', b'0', b'0'),
  (722, 'Bygax', b'0', b'0'),
  (723, 'Amdumor', b'0', b'0'),
  (724, 'Limeloth', b'0', b'0'),
  (725, 'Malpher', b'0', b'0'),
  (726, 'Pairoch', b'0', b'0'),
  (727, 'Zaphomax', b'0', b'0'),
  (728, 'Zabas', b'0', b'0'),
  (729, 'Beal', b'0', b'0'),
  (730, 'Aguacifor', b'0', b'0'),
  (731, 'Lioth', b'0', b'0'),
  (732, 'Azacifan', b'0', b'0'),
  (733, 'Baberial', b'0', b'0'),
  (734, 'Zastech', b'0', b'0'),
  (735, 'Anstias', b'0', b'0'),
  (736, 'Vazet', b'0', b'0'),
  (737, 'Nestuth', b'0', b'0'),
  (738, 'Beberon', b'0', b'0'),
  (739, 'Nessagoch', b'0', b'0'),
  (740, 'Abramelax', b'0', b'0'),
  (741, 'Bazuth', b'0', b'0'),
  (742, 'Limmet', b'0', b'0'),
  (743, '_Rorathel', b'0', b'0'),
  (744, 'Midiah', b'0', b'0'),
  (745, 'Mehetiel', b'0', b'0'),
  (746, 'Mehalel', b'0', b'0'),
  (747, 'Yeialahiel', b'0', b'0'),
  (748, 'Rariah', b'0', b'0'),
  (749, 'Metaiah', b'0', b'0'),
  (750, 'Launakiel', b'0', b'0'),
  (751, 'Hedel', b'0', b'0'),
  (752, 'Poriel', b'0', b'0'),
  (753, 'Meremiah', b'0', b'0'),
  (754, 'Jenakiah', b'0', b'0'),
  (755, 'Pomabaiah', b'0', b'0'),
  (756, 'Rothaiah', b'0', b'0'),
  (757, 'Nidiah', b'0', b'0'),
  (758, 'Helaiah', b'0', b'0'),
  (759, 'Marathael', b'0', b'0'),
  (760, 'Alanakel', b'0', b'0'),
  (761, 'Lenaiah', b'0', b'0'),
  (762, 'Jaziel', b'0', b'0'),
  (763, 'Ieiahael', b'0', b'0'),
  (764, 'Alahuiah', b'0', b'0'),
  (765, 'Royiah', b'0', b'0'),
  (766, 'Rathaiah', b'0', b'0'),
  (767, 'Mehetel', b'0', b'0'),
  (768, 'Paheaiah', b'0', b'0'),
  (769, 'Meheaiah', b'0', b'0'),
  (770, 'Rabahiah', b'0', b'0'),
  (771, 'Niremiah', b'0', b'0'),
  (772, 'Jahaliel', b'0', b'0'),
  (773, 'Lauhiah', b'0', b'0'),
  (774, 'Mehasel', b'0', b'0'),
  (775, 'Haraiah', b'0', b'0'),
  (776, 'Lauheiah', b'0', b'0'),
  (777, 'Mehuiel', b'0', b'0'),
  (778, 'Jatzraiah', b'0', b'0'),
  (779, 'Siremiel', b'0', b'0'),
  (780, 'Charathel', b'0', b'0'),
  (781, 'Jahaliah', b'0', b'0'),
  (782, 'Launael', b'0', b'0'),
  (783, 'Pomamael', b'0', b'0'),
  (784, 'Podiel', b'0', b'0'),
  (785, 'Nilahel', b'0', b'0'),
  (786, 'Camamiah', b'0', b'0'),
  (787, 'Simamel', b'0', b'0'),
  (788, 'Methel', b'0', b'0'),
  (789, 'Olemiah', b'0', b'0'),
  (790, 'Jeraiah', b'0', b'0'),
  (791, 'Lekamiel', b'0', b'0'),
  (792, 'Hazaliah', b'0', b'0'),
  (793, 'Laurathiel', b'0', b'0'),
  (794, 'Roheaiah', b'0', b'0'),
  (795, 'Halahael', b'0', b'0'),
  (796, 'Mehetaiah', b'0', b'0'),
  (797, 'Lautel', b'0', b'0'),
  (798, 'Laukamiel', b'0', b'0'),
  (799, 'Revaiah', b'0', b'0'),
  (800, 'Mirathiah', b'0', b'0'),
  (801, 'Jehaliel', b'0', b'0'),
  (802, 'Hahetiah', b'0', b'0'),
  (803, 'Madaiah', b'0', b'0'),
  (804, 'Hahetiel', b'0', b'0'),
  (805, 'Ihuel', b'0', b'0'),
  (806, 'Mudael', b'0', b'0'),
  (807, 'Lekamiel', b'0', b'0'),
  (808, 'Nabamiah', b'0', b'0'),
  (809, 'Yeiahaliah', b'0', b'0'),
  (810, 'Jekiah', b'0', b'0'),
  (811, 'Ieiabamael', b'0', b'0'),
  (812, 'Roriel', b'0', b'0'),
  (813, 'Onakael', b'0', b'0'),
  (814, 'Jazael', b'0', b'0'),
  (815, 'Mebahiel', b'0', b'0'),
  (816, 'Pothiel', b'0', b'0'),
  (817, 'Nalkhiel', b'0', b'0'),
  (818, 'Nirel', b'0', b'0'),
  (819, 'Nitiel', b'0', b'0'),
  (820, 'Sibahael', b'0', b'0'),
  (821, 'Machel', b'0', b'0'),
  (822, 'Ieiavael', b'0', b'0'),
  (823, 'Meheuaiah', b'0', b'0'),
  (824, 'Ralkhel', b'0', b'0'),
  (825, 'Osariah', b'0', b'0'),
  (826, 'Erathiah', b'0', b'0'),
  (827, 'Chakamiah', b'0', b'0'),
  (828, 'Rekamiel', b'0', b'0'),
  (829, 'Jemamiel', b'0', b'0'),
  (830, 'Dalkhiel', b'0', b'0'),
  (831, 'Retzrael', b'0', b'0'),
  (832, 'Mahaliah', b'0', b'0'),
  (833, 'Hasarael', b'0', b'0'),
  (834, 'Vethel', b'0', b'0'),
  (835, 'Ronakael', b'0', b'0'),
  (836, 'Alahael', b'0', b'0'),
  (837, 'Erathiah', b'0', b'0'),
  (838, 'Nahetaiah', b'0', b'0'),
  (839, 'Dazaliel', b'0', b'0'),
  (840, 'Renakael', b'0', b'0'),
  (841, 'Melemiah', b'0', b'0'),
  (842, 'Ahuael', b'0', b'0');

-- --------------------------------------------------------

--
-- Structure de la table `players`
--

DROP TABLE IF EXISTS `players`;
CREATE TABLE `players` (
  `uuid` binary(16) NOT NULL,
  `name` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `nickname` varchar(45) COLLATE utf8_roman_ci DEFAULT NULL,
  `coins` int(11) NOT NULL DEFAULT '0',
  `stars` int(11) NOT NULL DEFAULT '0',
  `last_login` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `first_login` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `last_ip` varchar(15) COLLATE utf8_roman_ci DEFAULT NULL,
  `toptp_key` varchar(32) COLLATE utf8_roman_ci DEFAULT NULL,
  `group_id` bigint(20) NOT NULL,
  `language_id` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `player_settings`
--

DROP TABLE IF EXISTS `player_settings`;
CREATE TABLE `player_settings` (
  `uuid` binary(16) NOT NULL,
  `jukebox_listen` bit(1) NOT NULL,
  `group_demand_receive` bit(1) NOT NULL,
  `friendship_demand_receive` bit(1) NOT NULL,
  `notification_receive` bit(1) NOT NULL,
  `private_message_receive` bit(1) NOT NULL,
  `chat_visible` bit(1) NOT NULL,
  `player_visible` bit(1) NOT NULL,
  `waiting_line_notification` bit(1) NOT NULL,
  `other_player_interaction` bit(1) NOT NULL,
  `click_on_me_activation` bit(1) NOT NULL,
  `allow_statistic_onclick` bit(1) NOT NULL,
  `allow_coins_onclick` bit(1) NOT NULL,
  `allow_stars_onclick` bit(1) NOT NULL,
  `allow_click_on_other` bit(1) NOT NULL,
  `elytra_activated` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `promotions`
--

DROP TABLE IF EXISTS `promotions`;
CREATE TABLE `promotions` (
  `promotion_id` bigint(20) NOT NULL,
  `type_id` tinyint(4) NOT NULL,
  `game` int(11) NOT NULL,
  `multiplier` int(11) NOT NULL,
  `message` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `start_date` timestamp NULL DEFAULT NULL,
  `end_date` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `promotions_ref`
--

DROP TABLE IF EXISTS `promotions_ref`;
CREATE TABLE `promotions_ref` (
  `type_id` tinyint(4) NOT NULL,
  `text` varchar(255) COLLATE utf8_roman_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `promotions_ref`
--

INSERT INTO `promotions_ref` (`type_id`, `text`) VALUES
  (0, 'coins'),
  (1, 'stars');

-- --------------------------------------------------------

--
-- Structure de la table `proxies_permissions`
--

DROP TABLE IF EXISTS `proxies_permissions`;
CREATE TABLE `proxies_permissions` (
  `groups_id` tinyint(4) NOT NULL,
  `proxies_dispatch` bit(1) NOT NULL,
  `proxies_global` bit(1) NOT NULL,
  `proxies_debug` bit(1) NOT NULL,
  `proxies_set_option` bit(1) NOT NULL,
  `proxies_hydro` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `proxies_permissions`
--

INSERT INTO `proxies_permissions` (`groups_id`, `proxies_dispatch`, `proxies_global`, `proxies_debug`, `proxies_set_option`, `proxies_hydro`) VALUES
  (1, b'0', b'0', b'0', b'0', b'0'),
  (2, b'0', b'0', b'0', b'0', b'0'),
  (3, b'0', b'0', b'0', b'0', b'0'),
  (4, b'0', b'0', b'0', b'0', b'0'),
  (5, b'0', b'0', b'0', b'0', b'0'),
  (6, b'0', b'0', b'0', b'0', b'0'),
  (7, b'0', b'0', b'0', b'0', b'0'),
  (8, b'0', b'0', b'0', b'0', b'0'),
  (9, b'0', b'0', b'0', b'0', b'0'),
  (10, b'0', b'0', b'0', b'0', b'0'),
  (11, b'0', b'0', b'0', b'0', b'0'),
  (12, b'0', b'0', b'0', b'0', b'0'),
  (13, b'0', b'0', b'0', b'0', b'0'),
  (14, b'1', b'1', b'0', b'0', b'1'),
  (15, b'1', b'1', b'0', b'0', b'1'),
  (16, b'1', b'1', b'0', b'0', b'1'),
  (17, b'1', b'1', b'1', b'1', b'1'),
  (18, b'1', b'1', b'1', b'1', b'1'),
  (19, b'1', b'1', b'1', b'1', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `quake_stats`
--

DROP TABLE IF EXISTS `quake_stats`;
CREATE TABLE `quake_stats` (
  `uuid` binary(16) NOT NULL,
  `deaths` int(11) NOT NULL,
  `kills` int(11) NOT NULL,
  `played_games` int(11) NOT NULL,
  `wins` int(11) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `played_time` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `sanctions`
--

DROP TABLE IF EXISTS `sanctions`;
CREATE TABLE `sanctions` (
  `sanction_id` bigint(20) NOT NULL,
  `player_uuid` binary(16) NOT NULL,
  `type_id` tinyint(4) NOT NULL,
  `reason` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `punisher_uuid` binary(16) NOT NULL,
  `expiration_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `is_deleted` bit(1) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `sanctions_ref`
--

DROP TABLE IF EXISTS `sanctions_ref`;
CREATE TABLE `sanctions_ref` (
  `type_id` tinyint(4) NOT NULL,
  `text` varchar(255) COLLATE utf8_roman_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `sanctions_ref`
--

INSERT INTO `sanctions_ref` (`type_id`, `text`) VALUES
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
CREATE TABLE `staff_permissions` (
  `groups_id` tinyint(4) NOT NULL,
  `netjoin_closed` bit(1) NOT NULL,
  `netjoin_vip` bit(1) NOT NULL,
  `netjoin_full` bit(1) NOT NULL,
  `tracker_famous` bit(1) NOT NULL,
  `network_vip` bit(1) NOT NULL,
  `network_vip_plus` bit(1) NOT NULL,
  `network_staff` bit(1) NOT NULL,
  `network_admin` bit(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `staff_permissions`
--

INSERT INTO `staff_permissions` (`groups_id`, `netjoin_closed`, `netjoin_vip`, `netjoin_full`, `tracker_famous`, `network_vip`, `network_vip_plus`, `network_staff`, `network_admin`) VALUES
  (1, b'0', b'0', b'0', b'0', b'0', b'0', b'0', b'0'),
  (2, b'0', b'1', b'1', b'0', b'1', b'0', b'0', b'0'),
  (3, b'0', b'1', b'1', b'0', b'1', b'1', b'0', b'0'),
  (4, b'0', b'1', b'1', b'1', b'1', b'1', b'0', b'0'),
  (5, b'0', b'1', b'1', b'1', b'1', b'1', b'0', b'0'),
  (6, b'0', b'1', b'1', b'0', b'1', b'1', b'1', b'0'),
  (7, b'0', b'1', b'1', b'0', b'1', b'1', b'1', b'0'),
  (8, b'0', b'1', b'1', b'0', b'1', b'1', b'1', b'0'),
  (9, b'0', b'1', b'1', b'0', b'1', b'1', b'1', b'0'),
  (10, b'0', b'1', b'1', b'0', b'1', b'1', b'1', b'0'),
  (11, b'0', b'1', b'1', b'0', b'1', b'1', b'1', b'0'),
  (12, b'1', b'1', b'1', b'0', b'1', b'1', b'1', b'0'),
  (13, b'0', b'1', b'1', b'0', b'1', b'1', b'1', b'0'),
  (14, b'1', b'1', b'1', b'0', b'1', b'1', b'1', b'0'),
  (15, b'1', b'1', b'1', b'0', b'1', b'1', b'1', b'0'),
  (16, b'1', b'1', b'1', b'0', b'1', b'1', b'1', b'0'),
  (17, b'1', b'1', b'1', b'0', b'1', b'1', b'1', b'1'),
  (18, b'1', b'1', b'1', b'0', b'1', b'1', b'1', b'1'),
  (19, b'1', b'1', b'1', b'0', b'1', b'1', b'1', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `transaction_shop`
--

DROP TABLE IF EXISTS `transaction_shop`;
CREATE TABLE `transaction_shop` (
  `transaction_id` bigint(20) NOT NULL,
  `item_id` int(11) DEFAULT NULL,
  `price_coins` int(11) DEFAULT NULL,
  `price_stars` int(11) DEFAULT NULL,
  `transaction_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `selected` bit(1) NOT NULL,
  `uuid_buyer` binary(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `uhcrun_stats`
--

DROP TABLE IF EXISTS `uhcrun_stats`;
CREATE TABLE `uhcrun_stats` (
  `uuid` binary(16) NOT NULL,
  `damages` int(11) NOT NULL,
  `deaths` int(11) NOT NULL,
  `kills` int(11) NOT NULL,
  `max_damages` int(11) NOT NULL,
  `played_games` int(11) NOT NULL,
  `wins` int(11) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `played_time` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `uppervoid_stats`
--

DROP TABLE IF EXISTS `uppervoid_stats`;
CREATE TABLE `uppervoid_stats` (
  `uuid` binary(16) NOT NULL,
  `blocks` int(11) NOT NULL,
  `grenades` int(11) NOT NULL,
  `kills` int(11) NOT NULL,
  `played_games` int(11) NOT NULL,
  `tnt_launched` int(11) NOT NULL,
  `wins` int(11) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `played_time` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `languages`
--

DROP TABLE IF EXISTS `languages`;
CREATE TABLE `languages` (
  `language_id` int(11) NOT NULL,
  `language_code` varchar(16) NOT NULL,
  `language_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

--
-- Contenu de la table `languages`
--

INSERT INTO `languages` (`language_id`, `language_code`, `language_name`) VALUES
  (1, 'fr_FR', 'French'),
  (2, 'en_US', 'English');

-- --------------------------------------------------------

--
-- Structure de la table `languages_sentences`
--

DROP TABLE IF EXISTS `languages_sentences`;
CREATE TABLE `languages_sentences` (
  `sentence_id` int(11) NOT NULL,
  `language_id` int(11) NOT NULL,
  `project_id` tinyint(4) NOT NULL,
  `sentence_text` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Index pour les tables exportées
--

--
-- Index pour la table `api_permissions`
--
ALTER TABLE `api_permissions`
ADD PRIMARY KEY (`groups_id`);

--
-- Index pour la table `bukkit_permissions`
--
ALTER TABLE `bukkit_permissions`
ADD PRIMARY KEY (`groups_id`);

--
-- Index pour la table `bungee_redis_permissions`
--
ALTER TABLE `bungee_redis_permissions`
ADD PRIMARY KEY (`groups_id`);

--
-- Index pour la table `denunciations`
--
ALTER TABLE `denunciations`
ADD PRIMARY KEY (`denouncement_id`);

--
-- Index pour la table `dimensions_stats`
--
ALTER TABLE `dimensions_stats`
ADD PRIMARY KEY (`uuid`);

--
-- Index pour la table `friendship`
--
ALTER TABLE `friendship`
ADD PRIMARY KEY (`friendship_id`),
ADD KEY `Requester_uuid` (`requester_uuid`),
ADD KEY `recepient_uuid` (`recipient_uuid`),
ADD KEY `active_status` (`active_status`);

--
-- Index pour la table `game_category`
--
ALTER TABLE `game_category`
ADD PRIMARY KEY (`category_id`);

--
-- Index pour la table `groups`
--
ALTER TABLE `groups`
ADD PRIMARY KEY (`group_id`);

--
-- Index pour la table `herobattle_stats`
--
ALTER TABLE `herobattle_stats`
ADD PRIMARY KEY (`uuid`);

--
-- Index pour la table `host_stats`
--
ALTER TABLE `host_stats`
ADD PRIMARY KEY (`id`),
ADD KEY `Player_Uuid` (`player_uuid`),
ADD KEY `Ip_Adress` (`ip_address`);

--
-- Index pour la table `hub_permissions`
--
ALTER TABLE `hub_permissions`
ADD PRIMARY KEY (`groups_id`),
ADD KEY `groups_id` (`groups_id`);

--
-- Index pour la table `item_description`
--
ALTER TABLE `item_description`
ADD PRIMARY KEY (`item_id`);

--
-- Index pour la table `jukebox_stats`
--
ALTER TABLE `jukebox_stats`
ADD PRIMARY KEY (`uuid`);

--
-- Index pour la table `moderation_permissions`
--
ALTER TABLE `moderation_permissions`
ADD PRIMARY KEY (`groups_id`);

--
-- Index pour la table `nickname`
--
ALTER TABLE `nickname`
ADD PRIMARY KEY (`nick_id`);

--
-- Index pour la table `players`
--
ALTER TABLE `players`
ADD PRIMARY KEY (`uuid`);

--
-- Index pour la table `player_settings`
--
ALTER TABLE `player_settings`
ADD PRIMARY KEY (`uuid`);

--
-- Index pour la table `promotions`
--
ALTER TABLE `promotions`
ADD PRIMARY KEY (`promotion_id`);

--
-- Index pour la table `promotions_ref`
--
ALTER TABLE `promotions_ref`
ADD PRIMARY KEY (`type_id`);

--
-- Index pour la table `proxies_permissions`
--
ALTER TABLE `proxies_permissions`
ADD PRIMARY KEY (`groups_id`);

--
-- Index pour la table `quake_stats`
--
ALTER TABLE `quake_stats`
ADD PRIMARY KEY (`uuid`);

--
-- Index pour la table `sanctions`
--
ALTER TABLE `sanctions`
ADD PRIMARY KEY (`sanction_id`);

--
-- Index pour la table `sanctions_ref`
--
ALTER TABLE `sanctions_ref`
ADD PRIMARY KEY (`type_id`);

--
-- Index pour la table `staff_permissions`
--
ALTER TABLE `staff_permissions`
ADD PRIMARY KEY (`groups_id`);

--
-- Index pour la table `transaction_shop`
--
ALTER TABLE `transaction_shop`
ADD PRIMARY KEY (`transaction_id`),
ADD KEY `fk_shop_item_item_idx` (`item_id`);

--
-- Index pour la table `uhcrun_stats`
--
ALTER TABLE `uhcrun_stats`
ADD PRIMARY KEY (`uuid`);

--
-- Index pour la table `uppervoid_stats`
--
ALTER TABLE `uppervoid_stats`
ADD PRIMARY KEY (`uuid`);

--
-- Index pour la table `languages`
--
ALTER TABLE `languages`
ADD PRIMARY KEY (`language_id`);

--
-- Index pour la table `languages_sentences`
--
ALTER TABLE `languages_sentences`
ADD PRIMARY KEY (`sentence_text`);


--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `api_permissions`
--
ALTER TABLE `api_permissions`
MODIFY `groups_id` tinyint(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT pour la table `bukkit_permissions`
--
ALTER TABLE `bukkit_permissions`
MODIFY `groups_id` tinyint(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT pour la table `bungee_redis_permissions`
--
ALTER TABLE `bungee_redis_permissions`
MODIFY `groups_id` tinyint(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT pour la table `denunciations`
--
ALTER TABLE `denunciations`
MODIFY `denouncement_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `friendship`
--
ALTER TABLE `friendship`
MODIFY `friendship_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `groups`
--
ALTER TABLE `groups`
MODIFY `group_id` tinyint(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT pour la table `host_stats`
--
ALTER TABLE `host_stats`
MODIFY `id` double NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `hub_permissions`
--
ALTER TABLE `hub_permissions`
MODIFY `groups_id` tinyint(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT pour la table `moderation_permissions`
--
ALTER TABLE `moderation_permissions`
MODIFY `groups_id` tinyint(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT pour la table `nickname`
--
ALTER TABLE `nickname`
MODIFY `nick_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=843;
--
-- AUTO_INCREMENT pour la table `promotions`
--
ALTER TABLE `promotions`
MODIFY `promotion_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `sanctions`
--
ALTER TABLE `sanctions`
MODIFY `sanction_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `staff_permissions`
--
ALTER TABLE `staff_permissions`
MODIFY `groups_id` tinyint(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT pour la table `transaction_shop`
--
ALTER TABLE `transaction_shop`
MODIFY `transaction_id` bigint(20) NOT NULL AUTO_INCREMENT;