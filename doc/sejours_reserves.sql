-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 07 juin 2018 à 21:55
-- Version du serveur :  10.1.28-MariaDB
-- Version de PHP :  7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cerisaie`
--

-- --------------------------------------------------------

--
-- Structure de la table `sejours_reserves`
--

CREATE TABLE `sejours_reserves` (
  `numResa` int(11) NOT NULL,
  `NumSej` int(11) NOT NULL,
  `NumCli` int(11) NOT NULL,
  `DatedebSej` date NOT NULL,
  `DateFinSej` date DEFAULT NULL,
  `NbPersonnes` int(11) NOT NULL,
  `NumCarteCredit` int(11) NOT NULL,
  `TypeCarteCredit` varchar(20) COLLATE utf8_bin NOT NULL,
  `DateExpirationCarte` date NOT NULL,
  `TotalTtc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `sejours_reserves`
--

INSERT INTO `sejours_reserves` (`numResa`, `NumSej`, `NumCli`, `DatedebSej`, `DateFinSej`, `NbPersonnes`, `NumCarteCredit`, `TypeCarteCredit`, `DateExpirationCarte`, `TotalTtc`) VALUES
(1, 1, 1, '2012-07-01', '2012-07-10', 4, 0, '', '2010-00-00', 0),
(2, 2, 2, '2012-07-02', '2012-07-13', 4, 0, '', '2010-00-00', 0),
(3, 3, 3, '2012-07-01', '2012-07-14', 4, 0, '', '2010-00-00', 0),
(4, 4, 4, '2012-07-05', '2012-07-15', 5, 0, '', '2010-00-00', 0),
(5, 5, 5, '2012-07-08', '2012-07-25', 8, 0, '', '2010-00-00', 0),
(6, 6, 6, '2012-07-09', '2012-07-23', 11, 0, '', '2010-00-00', 0),
(7, 7, 7, '2012-07-10', '2012-07-20', 6, 0, '', '2010-00-00', 0),
(8, 8, 8, '2012-07-11', '2012-07-26', 2, 0, '', '2010-00-00', 0),
(9, 9, 9, '2012-07-12', '2012-07-15', 3, 0, '', '2010-00-00', 0),
(10, 10, 10, '2012-07-13', '2012-07-17', 7, 0, '', '2010-00-00', 0),
(11, 11, 11, '2012-07-14', '2012-07-19', 6, 0, '', '2010-00-00', 0),
(12, 12, 12, '2012-07-15', '2012-07-21', 5, 0, '', '2010-00-00', 0),
(13, 13, 2, '2012-07-15', '2012-07-25', 14, 0, '', '2010-00-00', 0),
(14, 14, 3, '2012-07-16', '2012-07-23', 5, 0, '', '2010-00-00', 0),
(15, 15, 4, '2012-07-16', '2012-07-26', 4, 0, '', '2010-00-00', 0),
(16, 16, 5, '2012-07-17', '2012-07-28', 4, 0, '', '2010-00-00', 0),
(17, 1, 1, '2018-06-08', '2018-06-09', 2, 6546546, '1', '2018-06-09', 0),
(18, 1, 1, '2018-06-07', '2018-06-13', 1, 4455, '1', '2018-06-16', 133);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `sejours_reserves`
--
ALTER TABLE `sejours_reserves`
  ADD PRIMARY KEY (`numResa`),
  ADD KEY `NumSej` (`NumSej`),
  ADD KEY `NumCli` (`NumCli`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `sejours_reserves`
--
ALTER TABLE `sejours_reserves`
  MODIFY `numResa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
