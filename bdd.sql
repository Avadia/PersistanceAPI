-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Sam 13 Février 2016 à 23:36
-- Version du serveur :  5.5.42
-- Version de PHP :  7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `samagamesV3`
--
CREATE DATABASE IF NOT EXISTS `samagamesV3` DEFAULT CHARACTER SET utf8 COLLATE utf8_roman_ci;
USE `samagamesV3`;

-- --------------------------------------------------------

--
-- Structure de la table `api_permissions`
--

DROP TABLE IF EXISTS `api_permissions`;
CREATE TABLE `api_permissions` (
  `api_permission_id` bigint(20) NOT NULL,
  `api_servers_debug` tinyint(1) NOT NULL,
  `api_permissions_refresh` tinyint(1) NOT NULL,
  `api_coins_get_other` tinyint(1) NOT NULL,
  `api_coins_credit` tinyint(1) NOT NULL,
  `api_coins_withdraw` tinyint(1) NOT NULL,
  `api_inventory_show` tinyint(1) NOT NULL,
  `api_player_data_set` tinyint(1) NOT NULL,
  `api_player_data_del` tinyint(1) NOT NULL,
  `api_modo_speakup` tinyint(1) NOT NULL,
  `api_stars_getother` tinyint(1) NOT NULL,
  `api_stars_credit` tinyint(1) NOT NULL,
  `api_stars_withdraw` tinyint(1) NOT NULL,
  `api_game_start` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `bukkit_permissions`
--

DROP TABLE IF EXISTS `bukkit_permissions`;
CREATE TABLE `bukkit_permissions` (
  `bukkit_permission_id` bigint(20) NOT NULL,
  `minecraft_command_op` tinyint(1) NOT NULL,
  `bukkit_command_op_give` tinyint(1) NOT NULL,
  `bukkit_command_plugins` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `bungee_redis_permissions`
--

DROP TABLE IF EXISTS `bungee_redis_permissions`;
CREATE TABLE `bungee_redis_permissions` (
  `bungee_redis_permission_id` bigint(20) NOT NULL,
  `bungeecord_command_list` tinyint(1) NOT NULL,
  `bungeecord_command_find` tinyint(1) NOT NULL,
  `redisbungee_command_last_seen` tinyint(1) NOT NULL,
  `redisbungee_command_send_to_all` tinyint(1) NOT NULL,
  `redisbungee_command_server_id` tinyint(1) NOT NULL,
  `redisbunge_command_server_ids` tinyint(1) NOT NULL,
  `redisbungee_command_pproxy` tinyint(1) NOT NULL,
  `redisbungee_command_plist` tinyint(1) NOT NULL,
  `bungeecord_command_server` tinyint(1) NOT NULL,
  `bungeecord_command_send` tinyint(1) NOT NULL,
  `bungeecord_command_end` tinyint(1) NOT NULL,
  `bungeecord_command_alert` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

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
  (10, 'MOTD', 'CLOSE', 'LINE', 10000);

-- --------------------------------------------------------

--
-- Structure de la table `denunciation`
--

DROP TABLE IF EXISTS `denunciation`;
CREATE TABLE `denunciation` (
  `denouncement_id` int(11) NOT NULL,
  `denouncer` binary(16) NOT NULL,
  `suspect` binary(16) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `reason` varchar(255) NOT NULL,
  `suspect_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Structure de la table `hub_permissions`
--

DROP TABLE IF EXISTS `hub_permissions`;
CREATE TABLE `hub_permissions` (
  `hub_permission_id` bigint(20) NOT NULL,
  `hub_jukebox_lock` tinyint(1) NOT NULL,
  `hub_jukebox_next` tinyint(1) NOT NULL,
  `hub_mod_slow` tinyint(1) NOT NULL,
  `hub_mod_shutup` tinyint(1) NOT NULL,
  `hub_admin_sign` tinyint(1) NOT NULL,
  `hub_anguille` tinyint(1) NOT NULL,
  `hub_jukebox_nbs` tinyint(1) NOT NULL,
  `hub_announce` tinyint(1) NOT NULL,
  `hub_gadgets_cooldown_bypass` tinyint(1) NOT NULL,
  `hub_jukebox_limit_bypass` tinyint(1) NOT NULL,
  `hub_bypass_mute` tinyint(1) NOT NULL,
  `hub_fly` tinyint(1) NOT NULL,
  `hub_debug_sign` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

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
  `moderation_permission_id` bigint(20) NOT NULL,
  `mod_ban` tinyint(1) NOT NULL,
  `mod_tp` tinyint(1) NOT NULL,
  `mod_kick` tinyint(1) NOT NULL,
  `mod_pardon` tinyint(1) NOT NULL,
  `mod_mute_longtime` tinyint(1) NOT NULL,
  `mod_mute` tinyint(1) NOT NULL,
  `mod_channel` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `players`
--

DROP TABLE IF EXISTS `players`;
CREATE TABLE `players` (
  `uuid` binary(16) NOT NULL,
  `name` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `coins` int(11) DEFAULT NULL,
  `stars` int(11) DEFAULT NULL,
  `last_login` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `first_login` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `last_ip` varchar(15) COLLATE utf8_roman_ci DEFAULT NULL,
  `toptp_key` varchar(32) COLLATE utf8_roman_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `proxies_permissions`
--

DROP TABLE IF EXISTS `proxies_permissions`;
CREATE TABLE `proxies_permissions` (
  `proxies_permission_id` bigint(20) NOT NULL,
  `proxies_dispatch` tinyint(1) NOT NULL,
  `proxies_global` tinyint(1) NOT NULL,
  `proxies_debug` tinyint(1) NOT NULL,
  `proxies_set_option` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

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
  `type_id` int(11) NOT NULL,
  `reason` varchar(255) COLLATE utf8_roman_ci NOT NULL,
  `punisher_uuid` binary(16) NOT NULL,
  `expiration_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `is_deleted` tinyint(1) NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

-- --------------------------------------------------------

--
-- Structure de la table `sanctions_ref`
--

DROP TABLE IF EXISTS `sanctions_ref`;
CREATE TABLE `sanctions_ref` (
  `id` int(11) NOT NULL,
  `text` varchar(255) COLLATE utf8_roman_ci NOT NULL
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
CREATE TABLE `staff_permissions` (
  `staff_permission_id` bigint(20) NOT NULL,
  `staff_member` tinyint(1) NOT NULL,
  `netjoin_closed` tinyint(1) NOT NULL,
  `netjoin_vip` tinyint(1) NOT NULL,
  `netjoin_full` tinyint(1) NOT NULL,
  `tracker_famous` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_roman_ci;

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
-- Structure de la table `uhc_permissions`
--

DROP TABLE IF EXISTS `uhc_permissions`;
CREATE TABLE `uhc_permissions` (
  `uhc_permission_id` bigint(20) NOT NULL,
  `uhc_team_lock` tinyint(1) NOT NULL,
  `uhc_team_name` tinyint(1) NOT NULL,
  `uhc_team_invite` tinyint(1) NOT NULL
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

--
-- Index pour les tables exportées
--

--
-- Index pour la table `api_permissions`
--
ALTER TABLE `api_permissions`
ADD PRIMARY KEY (`api_permission_id`);

--
-- Index pour la table `bukkit_permissions`
--
ALTER TABLE `bukkit_permissions`
ADD PRIMARY KEY (`bukkit_permission_id`);

--
-- Index pour la table `bungee_redis_permissions`
--
ALTER TABLE `bungee_redis_permissions`
ADD PRIMARY KEY (`bungee_redis_permission_id`);

--
-- Index pour la table `denunciation`
--
ALTER TABLE `denunciation`
ADD PRIMARY KEY (`denouncement_id`);

--
-- Index pour la table `dimensions_stats`
--
ALTER TABLE `dimensions_stats`
ADD PRIMARY KEY (`uuid`);

--
-- Index pour la table `herobattle_stats`
--
ALTER TABLE `herobattle_stats`
ADD PRIMARY KEY (`uuid`);

--
-- Index pour la table `hub_permissions`
--
ALTER TABLE `hub_permissions`
ADD PRIMARY KEY (`hub_permission_id`);

--
-- Index pour la table `jukebox_stats`
--
ALTER TABLE `jukebox_stats`
ADD PRIMARY KEY (`uuid`);

--
-- Index pour la table `moderation_permissions`
--
ALTER TABLE `moderation_permissions`
ADD PRIMARY KEY (`moderation_permission_id`);

--
-- Index pour la table `players`
--
ALTER TABLE `players`
ADD PRIMARY KEY (`uuid`);

--
-- Index pour la table `proxies_permissions`
--
ALTER TABLE `proxies_permissions`
ADD PRIMARY KEY (`proxies_permission_id`);

--
-- Index pour la table `quake_stats`
--
ALTER TABLE `quake_stats`
ADD PRIMARY KEY (`uuid`);

--
-- Index pour la table `sanctions`
--
ALTER TABLE `sanctions`
ADD PRIMARY KEY (`sanction_id`),
ADD KEY `player_uuid` (`player_uuid`);

--
-- Index pour la table `sanctions_ref`
--
ALTER TABLE `sanctions_ref`
ADD PRIMARY KEY (`id`);

--
-- Index pour la table `staff_permissions`
--
ALTER TABLE `staff_permissions`
ADD PRIMARY KEY (`staff_permission_id`);

--
-- Index pour la table `uhcrun_stats`
--
ALTER TABLE `uhcrun_stats`
ADD PRIMARY KEY (`uuid`);

--
-- Index pour la table `uhc_permissions`
--
ALTER TABLE `uhc_permissions`
ADD PRIMARY KEY (`uhc_permission_id`);

--
-- Index pour la table `uppervoid_stats`
--
ALTER TABLE `uppervoid_stats`
ADD PRIMARY KEY (`uuid`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `denunciation`
--
ALTER TABLE `denunciation`
MODIFY `denouncement_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `sanctions`
--
ALTER TABLE `sanctions`
MODIFY `sanction_id` bigint(20) NOT NULL AUTO_INCREMENT;