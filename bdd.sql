-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Dim 15 Mai 2016 à 00:33
-- Version du serveur :  5.5.42
-- Version de PHP :  7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `samagamesv3`
--

CREATE DATABASE IF NOT EXISTS `samagamesv3` DEFAULT CHARACTER SET utf8 COLLATE utf8_roman_ci;
USE `samagamesv3`;

-- --------------------------------------------------------

--
-- Structure de la table `api_permissions`
--

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

CREATE TABLE `friendship` (
  `friendship_id` bigint(20) NOT NULL,
  `requester_uuid` binary(16) NOT NULL,
  `recipient_uuid` binary(16) NOT NULL,
  `demand_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `acceptation_date` timestamp NULL DEFAULT NULL,
  `active_status` bit(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=477791 DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `game_category`
--

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
-- Structure de la table `hub_permissions`
--

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
-- Structure de la table `players`
--

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
  `group_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `player_settings`
--

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
) ENGINE=InnoDB AUTO_INCREMENT=58641 DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `sanctions_ref`
--

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

CREATE TABLE `transaction_shop` (
  `transaction_id` bigint(20) NOT NULL,
  `item_id` int(11) DEFAULT NULL,
  `price_coins` int(11) DEFAULT NULL,
  `price_stars` int(11) DEFAULT NULL,
  `transaction_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `selected` bit(1) NOT NULL,
  `uuid_buyer` binary(16) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=23931 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `uhcrun_stats`
--

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
MODIFY `friendship_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=477791;
--
-- AUTO_INCREMENT pour la table `groups`
--
ALTER TABLE `groups`
MODIFY `group_id` tinyint(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
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
-- AUTO_INCREMENT pour la table `promotions`
--
ALTER TABLE `promotions`
MODIFY `promotion_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `sanctions`
--
ALTER TABLE `sanctions`
MODIFY `sanction_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=58641;
--
-- AUTO_INCREMENT pour la table `staff_permissions`
--
ALTER TABLE `staff_permissions`
MODIFY `groups_id` tinyint(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT pour la table `transaction_shop`
--
ALTER TABLE `transaction_shop`
MODIFY `transaction_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=23931;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `transaction_shop`
--
ALTER TABLE `transaction_shop`
ADD CONSTRAINT `fk_shop_item_item_desc1` FOREIGN KEY (`item_id`) REFERENCES `item_description` (`item_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
