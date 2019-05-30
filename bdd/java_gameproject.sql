-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 28 mai 2019 à 08:28
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
  `map1` int(11) NOT NULL AUTO_INCREMENT,
  `COL 1` varchar(1073) DEFAULT NULL,
  PRIMARY KEY (`map1`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `map1`
--

INSERT INTO `map1` (`map1`, `COL 1`) VALUES
(1, 'XXXXXXXXXXXXXXXXXXXXXXXXX\r\nXHDDDDDDDDDDDDDDDDXDDDDDX\r\nXDDDDDDDDDDDDDDDDDXDDDDDX\r\nXDDDDDDDDDDDDDDDDDXDDDDDX\r\nXXXXXXXXXXDDDDDDDDXDDDDDX\r\nXDDDXDRRDDDDDDDDDDXDDDDDX\r\nXDDDXDRRDDDDDDDDDDXDDDDDX\r\nXDDDXDDDDDDDDDDDDDDDDDDDX\r\nXDDDXDDDDDDDDDDDDDDDDDDDX\r\nXDDDXDDXXXXXDDDDRRRDDDDDX\r\nXDDDDDDDDDDXDDDDDDRDDDDDX\r\nXDDDDDDDDDDXDDDDDDRRRRDDX\r\nXDDDDDDDDDDXDDDDDDDDVDDDX\r\nXVDDDDDDDDDXDDDDDDDDDDDDX\r\nXXXXXXXXXXXXDDDDDDDDDDDDX\r\nXDDDDDDDDDDDDDDDDDDDDDDDX\r\nXDDDDDDDDDDDDDDDDDDDDDDEX\r\nXDDDDDDDDDDDDDDDDDDDDDDDX\r\nXDDDDDDDDDDDDDDDDDDDDDDDX\r\nXDDDDDDDDDDDDDDDDDXXXXXXX\r\nXDDDDDDDDDDDDDDDDDXDRRDVX\r\nXDDDDDDDDDDDDDDDDDXDRRDDX\r\nXDDDDDDDRRRRRDDDDDXDRRDDX\r\nXDDDDDDDRRDDRDDDDDXDDDDDX\r\nXDDDDDDDRRVDRDDDDDDDDDDDX\r\nXDDDDDDDDDDDDDDDDDDDDDDDX\r\nXDDDDDDDDDDDDDDDDDDDDDDDX\r\nXXXXXXXXXXXXXXXXXXXXXXXXX');

-- --------------------------------------------------------

--
-- Structure de la table `map2`
--

DROP TABLE IF EXISTS `map2`;
CREATE TABLE IF NOT EXISTS `map2` (
  `map2` int(11) NOT NULL AUTO_INCREMENT,
  `COL 1` varchar(1073) DEFAULT NULL,
  PRIMARY KEY (`map2`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `map2`
--

INSERT INTO `map2` (`map2`, `COL 1`) VALUES
(1, 'XXXXXXXXXXXXXXXXXXXXXXXXX\r\nXDDDDDDDDDDDDDDDDDDDDDDDX\r\nXXXXXXXXXXDXXXXXXXXDDDDDX\r\nXDDDDDDDVXDXVDDDDDXDDDDDX\r\nXDDDDDDDDXDXXDDDDDXDDDDDX\r\nXDDDDDDDDXDDXDDDDDDDDDDDX\r\nXDDDDXXXXXDDXDDDDDDDDDDVX\r\nXDDDDXDDDDDDXXXXXXXXXXXXX\r\nXDDDDXDDDDDDDDDDDDDDDDDDX\r\nXDDDDXXXXXXXXXXXXXXXXXXDX\r\nXDDDDDDDDDDDDDDDDDDDDDDHX\r\nXDDDDDDXXXXXXXXXXXXXXXXDX\r\nXDDXXXDXDDDDDDDDDDDDDDDDX\r\nXDDXVXDXDDDDDDDDDDDDDDDDX\r\nXDDXDXXXDDDDDDDDDDDDDDDDX\r\nXDDXDDDDDDDDDDDDDDDDDDDDX\r\nXDDXXXXXXXXXXXXXXXXXXXXDX\r\nXDDDDDDDDDDDDDXDDDDDDDDDX\r\nXDDDDDDDDDDDDDXDDDDDDDDDX\r\nXDXXXDDDDDDDDDXDDDDDDDDDX\r\nXDXDDDDDDDDDDDXXXDDDDDDDX\r\nXDXXXXXXXXXXDDDDXDDDDDDDX\r\nXDDDDDDDDDDXDDDDXXXXXXDDX\r\nXXXXXXXXXDDXDDDDXDDDDDDDX\r\nXVDDDDDDXDVXDDDDXDDDDDDDX\r\nXDDDDDDDXXXXDDDDXDDDDDDDX\r\nXEDDDDDDDDDDDDDDXDDDDDDDX\r\nXXXXXXXXXXXXXXXXXXXXXXXXX');

-- --------------------------------------------------------

--
-- Structure de la table `map3`
--

DROP TABLE IF EXISTS `map3`;
CREATE TABLE IF NOT EXISTS `map3` (
  `map3` int(11) NOT NULL AUTO_INCREMENT,
  `COL 1` varchar(1073) DEFAULT NULL,
  PRIMARY KEY (`map3`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `map3`
--

INSERT INTO `map3` (`map3`, `COL 1`) VALUES
(1, 'XXXXXXXXXXXXXXXXXXXXXXXXX\r\nXDDDDDDDDDXXOORROOXDDDDDX\r\nXDDDDDDDDDXXORRRROXDDDDDX\r\nXDDDDDDDDDXXRRVVRRXDDDDDX\r\nXDDDDDDDDDXDDDDDDEXDDDDDX\r\nXDDDDDDDDDXRXXXXXXXDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXDXXDDDDDDDDDDX\r\nXDDDDDDDDDXDVXDDDDDDDDDDX\r\nXDDDDDDDDDXDXXDDDDDDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXDXDDDDDDDDDDDX\r\nXDDDDDDDDDXHXDDDDDDDDDDDX\r\nXXXXXXXXXXXXXXXXXXXXXXXXX');

-- --------------------------------------------------------

--
-- Structure de la table `map4`
--

DROP TABLE IF EXISTS `map4`;
CREATE TABLE IF NOT EXISTS `map4` (
  `map4` int(11) NOT NULL AUTO_INCREMENT,
  `COL 1` varchar(1073) DEFAULT NULL,
  PRIMARY KEY (`map4`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `map4`
--

INSERT INTO `map4` (`map4`, `COL 1`) VALUES
(1, 'XXXXXXXXXXXXXXXXXXXXXXXXX\r\nXOOOOOOOOOOOMOOOOOOOOOOHX\r\nXOOOOOOOOOOOOOOOOOOOOOOOX\r\nXOOOOOORRRRRRRRRRROOOOOOX\r\nXOOOOOODDDDDDDDDDDOOOOOOX\r\nXOOOOOOOOOOOOOOOOOOOOOOOX\r\nXOOOOOOOOOOOOOOOOOOOOOOOX\r\nXXXXXXXXXXXXXXXXXXXXXXXXX\r\nXOOOOOOOOOOOMOOOOOOOOOOOX\r\nXOOOOOOOOOOOOOOOOOOOOOOOX\r\nXOOOOOOOOOOOOOOOOOOOOOOOX\r\nXOOOOOOOOOOOOOOOOOOOOOOOX\r\nXOOOOOORRRRRRRRRRROOOOOOX\r\nXOOOOOODDDDDDDDDDDOOOOOOX\r\nXOOOOOOOOOOOOOOOOOOOOOOOX\r\nXOOOOOOOOOOOOOOOOOOOOOOOX\r\nXOOOOOOOOOOOOOOOOOOOOOOOX\r\nXXXXXXXXXXXXXXXXXXXXXXXXX\r\nXOOOOOOOOOOOMOOOOOOOOOOOX\r\nXOOOOOOOOOOOOOOOOOOOOOOOX\r\nXOOOOOOOOOOOOOOOOOOOOOOOX\r\nXOORRRROOOOOOOOOOORRRROOX\r\nXOODDDDOOOOOOOOOOODDDDOOX\r\nXOOOOOOOOOOOOOOOOOOOOOOOX\r\nXOOOOOOOOOOOOOOOOOOOOOOOX\r\nXOOOOOOOOOOOOOOOOOOOOOOOX\r\nXEOOOOOOOOOOOOOOOOOOOOOOX\r\nXXXXXXXXXXXXXXXXXXXXXXXXX');

-- --------------------------------------------------------

--
-- Structure de la table `map5`
--

DROP TABLE IF EXISTS `map5`;
CREATE TABLE IF NOT EXISTS `map5` (
  `map5` int(11) NOT NULL AUTO_INCREMENT,
  `COL 1` varchar(1073) DEFAULT NULL,
  PRIMARY KEY (`map5`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `map5`
--

INSERT INTO `map5` (`map5`, `COL 1`) VALUES
(1, 'XXXXXXXXXXXXXXXXXXXXXXXXX\r\nXDDDDDDDDDDDDDDDDDDDDDOMX\r\nXDDDDDDDDDDDDDDDDDDDDDOOX\r\nXDDDDDDDDDDDDDDDDDDDDDDDX\r\nXDDDDDDDDDDDDDDDDDDDDDDDX\r\nXDDDVVVVVDDDDDDDVVVVVDDDX\r\nXDDDRRRRRDDDDDDDRRRRRDDDX\r\nXDDDDDDDDDDDDDDDDDDDDDDDX\r\nXDDDDOOMDDDDDDDDDMOODDDDX\r\nXDDDDOOODDDDDDDDDOOODDDDX\r\nXDDDDOOODDDDDDDDDOOODDDDX\r\nXDDDDDDDDDDDDDDDDDDDDDDDX\r\nXDDDDDDDDDDDDDDDDDDDDDDDX\r\nXDDDDDDDDDDDDDDDDDDDDDDDX\r\nXDDDDDDDDDDDDDDDDDDDDDDDX\r\nXDDDDDDDDDDDDDDDDDDDDDDDX\r\nXDDDDDDDDDDDEDDDDDDDDDDDX\r\nXDDDDDDDRRRRRRRRRDDDDDDDX\r\nXDDDDDDDDDDDDDDDDDDDDDDDX\r\nXDDDDDDDOOOOMOOOODDDDDDDX\r\nXDDDDDDDXOOOOOOOXDDDDDDDX\r\nXDDDDDDDDXVOOOVXDDDDDDDDX\r\nXDDDDDDDDDXVVVXDDDDDDDDDX\r\nXDDDDDDDDDDXXXDDDDDDDDDDX\r\nXDDDDDDDDDDDDDDDDDDDDDDDX\r\nXOMDDDDDDDDDDDDDDDDDDDDDX\r\nXOODDDDDDDDDDDDDDDDDDDDHX\r\nXXXXXXXXXXXXXXXXXXXXXXXXX');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;