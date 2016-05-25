-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 25 Mai 2016 à 12:33
-- Version du serveur :  5.7.9
-- Version de PHP :  5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projet_java`
--

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `idMessage` int(11) NOT NULL AUTO_INCREMENT,
  `timestampmessage` datetime DEFAULT NULL,
  `contenu` varchar(200) DEFAULT NULL,
  `auteur` varchar(25) DEFAULT NULL,
  `idUser` int(11) DEFAULT NULL,
  `idSalon` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMessage`),
  KEY `FK_message_idUser` (`idUser`),
  KEY `FK_message_idSalon` (`idSalon`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `message`
--

INSERT INTO `message` (`idMessage`, `timestampmessage`, `contenu`, `auteur`, `idUser`, `idSalon`) VALUES
(1, '2016-05-15 00:00:00', 'Bienvenue sur iHear !', 'Server', 1, 1),
(2, '2016-05-15 00:00:01', 'Comment allez-vous ?', 'Server', 1, 1),
(3, '2016-05-15 03:00:00', 'C''est l''heure de dormir !', 'Server', 1, 1),
(4, '2016-05-02 07:00:00', 'Et alors ? ', 'Alexis', 2, 1),
(5, '2016-05-15 13:02:58', 'Oui ?', 'Alexis', 2, 1),
(6, '2016-05-15 13:05:19', 'ça va ?', 'Alexis', 3, 1),
(7, '2016-05-15 13:05:31', 'oui et toi ?', 'Alexis', 2, 1),
(8, '2016-05-15 13:09:03', 'Oui', 'Samsam', 3, 1),
(9, '2016-05-15 13:09:10', 'lol', 'Samsam', 3, 1),
(10, '2016-05-15 13:10:01', 'ah?', 'Alexis', 2, 1),
(11, '2016-05-15 13:10:11', 'Comme ça ?', 'Alexis', 2, 1),
(12, '2016-05-15 13:12:04', 'et là ? Est-ce que ça fonctionne mieux ?', 'Alexis', 2, 1),
(13, '2016-05-15 13:12:31', 'Comme une envie de me sucer...', 'Alexis', 2, 1),
(14, '2016-05-15 13:13:42', 'Oui', 'Alexis', 2, 1),
(15, '2016-05-15 13:30:28', 'lol', 'Samsam', 3, 1),
(16, '2016-05-15 13:31:25', 'Et alors ?', 'Samsam', 3, 1),
(17, '2016-05-15 13:31:59', 'laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', 'Samsam', 3, 1),
(18, '2016-05-15 13:32:08', 'Tu te chauffes beaucoup trop...', 'Samsam', 3, 1),
(19, '2016-05-15 13:34:55', 'lol', 'Samsam', 3, 1),
(20, '2016-05-15 13:44:18', 'lol', 'Samsam', 3, 1),
(21, '2016-05-15 13:46:18', 'yep', 'Samsam', 3, 1),
(22, '2016-05-15 13:46:21', 'ola', 'Samsam', 3, 1),
(23, '2016-05-15 13:46:22', 'la', 'Samsam', 3, 1),
(24, '2016-05-15 13:46:23', 'l', 'Samsam', 3, 1),
(25, '2016-05-15 13:46:25', 'la', 'Samsam', 3, 1),
(26, '2016-05-15 16:21:30', 'ça va ?', 'Alexis', 2, 1),
(27, '2016-05-15 17:10:48', 'ça va et toi ?', 'Samsam', 3, 1),
(28, '2016-05-15 17:10:55', 'Beh écoute super !', 'Alexis', 2, 1),
(29, '2016-05-15 17:22:19', 'Je te suce quand tu veux !', 'Samsam', 3, 1),
(30, '2016-05-15 17:22:51', 'Avec plaisir ! <3', 'Alexis', 2, 1),
(31, '2016-05-15 17:26:40', 'Coucou !', 'Alexis', 2, 1),
(32, '2016-05-15 17:26:55', 'ça va bien ? :D', 'Samsam', 3, 1),
(33, '2016-05-15 21:24:22', 'coucou !', 'Alexis', 2, 1),
(34, '2016-05-15 21:24:56', 'Coucou !', 'Samsam', 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `salons`
--

DROP TABLE IF EXISTS `salons`;
CREATE TABLE IF NOT EXISTS `salons` (
  `idSalon` int(11) NOT NULL AUTO_INCREMENT,
  `intitule` varchar(25) DEFAULT NULL,
  `nbmax` int(11) DEFAULT NULL,
  `couleur` varchar(25) DEFAULT NULL,
  `description` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idSalon`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `salons`
--

INSERT INTO `salons` (`idSalon`, `intitule`, `nbmax`, `couleur`, `description`) VALUES
(1, 'Bienvenue', 5, 'bleu', 'Salon de bienvenue'),
(2, '13 Mai', 5, 'rouge', 'Reunion du 13 mai'),
(3, 'Mise au point', 5, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(200) NOT NULL,
  `prenom` varchar(25) DEFAULT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `typeprofil` varchar(25) DEFAULT NULL,
  `description` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`idUser`, `username`, `password`, `prenom`, `nom`, `typeprofil`, `description`) VALUES
(1, 'Server', '4a7d1ed414474e4033ac29ccb8653d9b', 'local', 'host', 'admin', NULL),
(2, 'Alexis', 'stristri', 'Alexis', 'Gardavoir', 'user', NULL),
(3, 'Samsam', 'masmas', 'Samuel', 'Garcia', 'user', 'Délégué');

-- --------------------------------------------------------

--
-- Structure de la table `utiliser`
--

DROP TABLE IF EXISTS `utiliser`;
CREATE TABLE IF NOT EXISTS `utiliser` (
  `idUser` int(11) NOT NULL,
  `idSalon` int(11) NOT NULL,
  PRIMARY KEY (`idUser`,`idSalon`),
  KEY `FK_utiliser_idSalon` (`idSalon`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utiliser`
--

INSERT INTO `utiliser` (`idUser`, `idSalon`) VALUES
(1, 1),
(2, 1),
(3, 1),
(2, 2),
(2, 3),
(3, 3);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `FK_message_idSalon` FOREIGN KEY (`idSalon`) REFERENCES `salons` (`idSalon`),
  ADD CONSTRAINT `FK_message_idUser` FOREIGN KEY (`idUser`) REFERENCES `utilisateurs` (`idUser`);

--
-- Contraintes pour la table `utiliser`
--
ALTER TABLE `utiliser`
  ADD CONSTRAINT `FK_utiliser_idSalon` FOREIGN KEY (`idSalon`) REFERENCES `salons` (`idSalon`),
  ADD CONSTRAINT `FK_utiliser_idUser` FOREIGN KEY (`idUser`) REFERENCES `utilisateurs` (`idUser`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
