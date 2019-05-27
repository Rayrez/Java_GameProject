-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 27 mai 2019 à 18:30
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `java_gameproject`
--

-- --------------------------------------------------------

--
-- Structure de la table `map1`
--

DROP TABLE IF EXISTS `map1`;
CREATE TABLE IF NOT EXISTS `map1` (
  `COL 1` varchar(49) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `map1`
--

INSERT INTO `map1` (`COL 1`) VALUES
('X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X'),
('X;H;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X;D;D;D;D;D;X'),
('X;X;X;X;X;X;X;X;X;X;D;D;D;D;D;D;D;D;X;D;D;D;D;D;X'),
('X;D;D;D;X;D;R;R;D;D;D;D;D;D;D;D;D;D;X;D;D;D;D;D;X'),
('X;D;D;D;X;D;R;R;D;D;D;D;D;D;D;D;D;D;X;D;D;D;D;D;X'),
('X;D;D;D;X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;X;D;D;X;X;X;X;X;D;D;D;D;R;R;R;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;X;D;D;D;D;D;D;R;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;X;D;D;D;D;D;D;R;R;R;R;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;X;D;D;D;D;D;D;D;D;V;D;D;D;X'),
('X;V;D;D;D;D;D;D;D;D;D;X;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;X;X;X;X;X;X;X;X;X;X;X;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;E;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X;X;X;X;X;X;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X;D;R;R;D;V;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X;D;R;R;D;D;X'),
('X;D;D;D;D;D;D;D;R;R;R;R;R;D;D;D;D;D;X;D;R;R;D;D;X'),
('X;D;D;D;D;D;D;D;R;R;D;D;R;D;D;D;D;D;X;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;R;R;V;D;R;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X');

-- --------------------------------------------------------

--
-- Structure de la table `map2`
--

DROP TABLE IF EXISTS `map2`;
CREATE TABLE IF NOT EXISTS `map2` (
  `COL 1` varchar(49) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `map2`
--

INSERT INTO `map2` (`COL 1`) VALUES
('X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;X;X;X;X;X;X;X;X;X;D;X;X;X;X;X;X;X;X;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;V;X;D;X;V;D;D;D;D;D;X;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;X;D;X;X;D;D;D;D;D;X;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;X;D;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;X;X;X;X;X;D;D;X;D;D;D;D;D;D;D;D;D;D;V;X'),
('X;D;D;D;D;X;D;D;D;D;D;D;X;X;X;X;X;X;X;X;X;X;X;X;X'),
('X;D;D;D;D;X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;H;X'),
('X;D;D;D;D;D;D;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;D;X'),
('X;D;D;X;X;X;D;X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;X;V;X;D;X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;X;D;X;X;X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;X;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;X;D;D;D;D;D;D;D;D;D;X'),
('X;D;X;X;X;D;D;D;D;D;D;D;D;D;X;D;D;D;D;D;D;D;D;D;X'),
('X;D;X;D;D;D;D;D;D;D;D;D;D;D;X;X;X;D;D;D;D;D;D;D;X'),
('X;D;X;X;X;X;X;X;X;X;X;X;D;D;D;D;X;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;X;D;D;D;D;X;X;X;X;X;X;D;D;X'),
('X;X;X;X;X;X;X;X;X;D;D;X;D;D;D;D;X;D;D;D;D;D;D;D;X'),
('X;V;D;D;D;D;D;D;X;D;V;X;D;D;D;D;X;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;X;X;X;X;D;D;D;D;X;D;D;D;D;D;D;D;X'),
('X;E;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X;D;D;D;D;D;D;D;X'),
('X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X');

-- --------------------------------------------------------

--
-- Structure de la table `map3`
--

DROP TABLE IF EXISTS `map3`;
CREATE TABLE IF NOT EXISTS `map3` (
  `COL 1` varchar(49) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `map3`
--

INSERT INTO `map3` (`COL 1`) VALUES
('X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X'),
('X;D;D;D;D;D;D;D;D;D;X;X;O;O;R;R;O;O;X;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;X;O;R;R;R;R;O;X;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;X;R;R;V;V;R;R;X;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;D;D;D;D;D;E;X;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;R;X;X;X;X;X;X;X;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;X;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;V;X;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;X;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;D;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;H;X;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X');

-- --------------------------------------------------------

--
-- Structure de la table `map4`
--

DROP TABLE IF EXISTS `map4`;
CREATE TABLE IF NOT EXISTS `map4` (
  `COL 1` varchar(1073) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `map4`
--

INSERT INTO `map4` (`COL 1`) VALUES
('X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;P;O;O;O;O;O;O;O;O;O;O;H;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;O;O;O;O;O;O;R;R;R;R;R;R;R;R;R;R;R;O;O;O;O;O;O;X'),
('X;O;O;O;O;O;O;D;D;D;D;D;D;D;D;D;D;D;O;O;O;O;O;O;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;P;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;O;O;O;O;O;O;R;R;R;R;R;R;R;R;R;R;R;O;O;O;O;O;O;X'),
('X;O;O;O;O;O;O;D;D;D;D;D;D;D;D;D;D;D;O;O;O;O;O;O;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;P;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;O;O;R;R;R;R;O;O;O;O;O;O;O;O;O;O;O;R;R;R;R;O;O;X'),
('X;O;O;D;D;D;D;O;O;O;O;O;O;O;O;O;O;O;D;D;D;D;O;O;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;E;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;O;X'),
('X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X');

-- --------------------------------------------------------

--
-- Structure de la table `map5`
--

DROP TABLE IF EXISTS `map5`;
CREATE TABLE IF NOT EXISTS `map5` (
  `COL 1` varchar(1073) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `map5`
--

INSERT INTO `map5` (`COL 1`) VALUES
('X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;O;M;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;O;O;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;V;V;V;V;V;D;D;D;D;D;D;D;V;V;V;V;V;D;D;D;X'),
('X;D;D;D;R;R;R;R;R;D;D;D;D;D;D;D;R;R;R;R;R;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;O;O;M;D;D;D;D;D;D;D;D;D;M;O;O;D;D;D;D;X'),
('X;D;D;D;D;O;O;O;D;D;D;D;D;D;D;D;D;O;O;O;D;D;D;D;X'),
('X;D;D;D;D;O;O;O;D;D;D;D;D;D;D;D;D;O;O;O;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;E;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;R;R;R;R;R;R;R;R;R;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;O;O;O;O;M;O;O;O;O;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;X;O;O;O;O;O;O;O;X;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;X;V;O;O;O;V;X;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;X;V;V;V;X;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;X;X;X;D;D;D;D;D;D;D;D;D;D;X'),
('X;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;O;M;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;X'),
('X;O;O;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;D;H;X'),
('X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X;X');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
