-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 14 juin 2018 à 16:28
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
-- Structure de la table `activite`
--

CREATE TABLE `activite` (
  `NumInscription` int(11) NOT NULL,
  `CodeSport` int(11) NOT NULL,
  `DateJour` date NOT NULL,
  `NbLoc` int(6) NOT NULL,
  `NumResa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `activite`
--

INSERT INTO `activite` (`NumInscription`, `CodeSport`, `DateJour`, `NbLoc`, `NumResa`) VALUES
(1, 1, '2012-07-05', 1, 1),
(2, 1, '2012-07-20', 1, 13),
(3, 2, '2012-07-05', 1, 2),
(4, 2, '2012-07-10', 1, 3),
(5, 2, '2012-07-15', 2, 1),
(6, 3, '2012-07-07', 2, 4),
(7, 3, '2012-07-14', 3, 13),
(8, 4, '2012-07-09', 2, 4),
(9, 5, '2012-07-07', 3, 2),
(10, 5, '2012-07-12', 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `NumCli` int(11) NOT NULL,
  `NomCli` varchar(100) COLLATE utf8_bin NOT NULL,
  `AdrRueCli` varchar(50) COLLATE utf8_bin NOT NULL,
  `CpCli` int(11) NOT NULL,
  `VilleCli` varchar(50) COLLATE utf8_bin NOT NULL,
  `PieceCli` varchar(2) COLLATE utf8_bin NOT NULL,
  `NumPieceCli` int(11) NOT NULL,
  `username` varchar(12) COLLATE utf8_bin NOT NULL,
  `password` varchar(11) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`NumCli`, `NomCli`, `AdrRueCli`, `CpCli`, `VilleCli`, `PieceCli`, `NumPieceCli`, `username`, `password`) VALUES
(1, 'Merle', '3 rue des lilas', 69005, 'Lyon', 'CI', 2356786, 'merle', 'merle'),
(2, 'Poussin', 'rue des tulipes', 69007, 'Lyon', 'CI', 347835684, 'poussin', 'poussin'),
(3, 'Rossignol', '3 rue des glaieuls', 69002, 'Lyon', 'CI', 23556645, '', '0'),
(4, 'Canaris', '10 rue des acacias', 69005, 'Lyon', 'PS', 235667, '', '0'),
(5, 'Piaf', '4 rue des pivoines', 69007, 'Lyon', 'PC', 347235684, '', '0'),
(6, 'Rose', '5 rue des marguerites', 69160, 'Tassin', 'CI', 56947341, '', '0'),
(7, 'Poussin', '20 rue des iris', 69400, 'Villefranche', 'CI', 234511, '', '0'),
(8, 'Piactivitet', 'rue des pÃ©tunias', 69340, 'Francheville', 'CI', 347289, '', '0'),
(9, 'Aigle', '3 rue des geraniums', 69290, 'Saint Consorce', 'CI', 234591, '', '0'),
(10, 'Mesange', '10 rue des aubÃ©pines', 69290, 'Craponne', 'PS', 2398643, '', '0'),
(11, 'Aactivitette', '4 rue des orchidÃ©s', 69500, 'Bron', 'PC', 34723896, '', '0'),
(12, 'Buse', '5 rue des nÃ©nuphars', 69200, 'Venissieux', 'CI', 569475342, '', '0'),
(16, 'cf', 'dffgd', 69110, 'sd', 'PS', 446464, 'axouille', 'a');

-- --------------------------------------------------------

--
-- Structure de la table `emplacement`
--

CREATE TABLE `emplacement` (
  `NumEmpl` int(11) NOT NULL,
  `CodeTypeE` int(11) NOT NULL,
  `SurfaceEmpl` int(6) NOT NULL,
  `NbPersMaxEmpl` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `emplacement`
--

INSERT INTO `emplacement` (`NumEmpl`, `CodeTypeE`, `SurfaceEmpl`, `NbPersMaxEmpl`) VALUES
(1, 1, 4, 4),
(2, 1, 4, 4),
(3, 1, 6, 5),
(4, 1, 8, 8),
(5, 2, 8, 12),
(6, 2, 10, 14),
(7, 2, 12, 16),
(8, 3, 12, 12),
(9, 3, 10, 8),
(10, 4, 19, 15),
(11, 4, 18, 16),
(12, 4, 18, 16),
(13, 4, 20, 25);

-- --------------------------------------------------------

--
-- Structure de la table `sejours_proposes`
--

CREATE TABLE `sejours_proposes` (
  `NumSej` int(11) NOT NULL,
  `DateFinOffre` date NOT NULL,
  `NumEmpl` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sejours_proposes`
--

INSERT INTO `sejours_proposes` (`NumSej`, `DateFinOffre`, `NumEmpl`) VALUES
(1, '2018-05-01', 1),
(2, '2018-05-03', 2),
(3, '2018-05-11', 3),
(4, '2018-05-11', 3),
(13, '2018-05-11', 11);

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
(1, 1, 1, '2012-07-01', '2018-12-14', 4, 0, 'VISA', '2012-04-05', 0),
(2, 2, 2, '2012-07-02', '2012-07-13', 4, 0, 'VISA', '2018-06-03', 0),
(3, 3, 3, '2012-07-01', '2012-07-14', 4, 0, 'VISA', '2018-06-11', 0),
(4, 4, 4, '2012-07-05', '2012-07-15', 5, 0, 'VISA', '2018-06-12', 0),
(13, 13, 5, '2012-07-17', '2012-07-28', 4, 0, 'VISA', '2018-06-19', 0);

-- --------------------------------------------------------

--
-- Structure de la table `sport`
--

CREATE TABLE `sport` (
  `CodeSport` int(11) NOT NULL,
  `LibelleSport` varchar(100) COLLATE utf8_bin NOT NULL,
  `UniteTpsSport` varchar(20) COLLATE utf8_bin NOT NULL,
  `TarifUnite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `sport`
--

INSERT INTO `sport` (`CodeSport`, `LibelleSport`, `UniteTpsSport`, `TarifUnite`) VALUES
(1, 'Tennis', '1 heure', 9),
(2, 'VTT', '1/2 journÃ©e', 15),
(3, 'Planche-vo', '1 journÃ©e', 22),
(4, 'PÃ©dalo', '2 heures', 8),
(5, 'CanoÃ©', '1/2 journÃ©e', 10);

-- --------------------------------------------------------

--
-- Structure de la table `type_emplacement`
--

CREATE TABLE `type_emplacement` (
  `CodeTypeE` int(11) NOT NULL,
  `LIBTYPEPL` varchar(30) COLLATE utf8_bin NOT NULL,
  `TARIFTYPEPL` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `type_emplacement`
--

INSERT INTO `type_emplacement` (`CodeTypeE`, `LIBTYPEPL`, `TARIFTYPEPL`) VALUES
(1, 'TENTE', 19),
(2, 'CARAVANE', 29),
(3, 'CAMPING-CAR', 32),
(4, 'BUNGALOW', 28);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `activite`
--
ALTER TABLE `activite`
  ADD PRIMARY KEY (`NumInscription`),
  ADD KEY `CodeSport` (`CodeSport`),
  ADD KEY `NumResa` (`NumResa`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`NumCli`);

--
-- Index pour la table `emplacement`
--
ALTER TABLE `emplacement`
  ADD PRIMARY KEY (`NumEmpl`),
  ADD KEY `CodeTypeE` (`CodeTypeE`);

--
-- Index pour la table `sejours_proposes`
--
ALTER TABLE `sejours_proposes`
  ADD PRIMARY KEY (`NumSej`),
  ADD KEY `NumEmpl` (`NumEmpl`);

--
-- Index pour la table `sejours_reserves`
--
ALTER TABLE `sejours_reserves`
  ADD PRIMARY KEY (`numResa`),
  ADD KEY `NumSej` (`NumSej`),
  ADD KEY `NumCli` (`NumCli`);

--
-- Index pour la table `sport`
--
ALTER TABLE `sport`
  ADD PRIMARY KEY (`CodeSport`);

--
-- Index pour la table `type_emplacement`
--
ALTER TABLE `type_emplacement`
  ADD PRIMARY KEY (`CodeTypeE`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `activite`
--
ALTER TABLE `activite`
  MODIFY `NumInscription` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `NumCli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `sejours_proposes`
--
ALTER TABLE `sejours_proposes`
  MODIFY `NumSej` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `sejours_reserves`
--
ALTER TABLE `sejours_reserves`
  MODIFY `numResa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `emplacement`
--
ALTER TABLE `emplacement`
  ADD CONSTRAINT `emplacement_ibfk_1` FOREIGN KEY (`CodeTypeE`) REFERENCES `type_emplacement` (`CodeTypeE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
