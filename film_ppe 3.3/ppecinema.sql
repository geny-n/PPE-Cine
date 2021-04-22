-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 14 avr. 2021 à 17:55
-- Version du serveur :  8.0.21
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ppecinema`
--

-- --------------------------------------------------------

--
-- Structure de la table `auteur`
--

DROP TABLE IF EXISTS `auteur`;
CREATE TABLE IF NOT EXISTS `auteur` (
  `ACTEUR` char(50) NOT NULL,
  `NOMACTEUR` varchar(128) DEFAULT NULL,
  `PRENOMACTEUR` char(50) DEFAULT NULL,
  `DATETOURNAGE` date DEFAULT NULL,
  `NATIONALITEACTEUR` char(50) DEFAULT NULL,
  PRIMARY KEY (`ACTEUR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `calendrier`
--

DROP TABLE IF EXISTS `calendrier`;
CREATE TABLE IF NOT EXISTS `calendrier` (
  `id_seance` int NOT NULL,
  `date_jour` date NOT NULL,
  `date_heure` time NOT NULL,
  `idfilm` int NOT NULL,
  `capacite` int DEFAULT NULL,
  PRIMARY KEY (`id_seance`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `calendrier`
--

INSERT INTO `calendrier` (`id_seance`, `date_jour`, `date_heure`, `idfilm`, `capacite`) VALUES
(1, '2021-05-01', '13:00:00', 1, 100),
(2, '2021-05-01', '17:00:00', 1, 100),
(3, '2021-05-02', '19:00:00', 1, 100),
(4, '2021-06-01', '13:00:00', 2, 120),
(5, '2021-06-01', '17:00:00', 2, 120),
(6, '2021-06-10', '13:00:00', 2, 120),
(7, '2021-07-01', '13:00:00', 3, 20),
(8, '2021-07-01', '18:00:00', 3, 20),
(9, '2021-07-20', '15:00:00', 3, 20);

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

DROP TABLE IF EXISTS `contact`;
CREATE TABLE IF NOT EXISTS `contact` (
  `idcontact` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `typedemande` varchar(50) NOT NULL,
  `description` varchar(250) NOT NULL,
  PRIMARY KEY (`idcontact`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `contact`
--

INSERT INTO `contact` (`idcontact`, `email`, `typedemande`, `description`) VALUES
(1, '', 'Bug technique', 'zzzzz'),
(2, '', 'SuggÃ©rer une amÃ©lioration', 'nynyn'),
(3, 'darpier@gmail.com', 'SuggÃ©rer une amÃ©lioration', 'Coucou');

-- --------------------------------------------------------

--
-- Structure de la table `corealisateur`
--

DROP TABLE IF EXISTS `corealisateur`;
CREATE TABLE IF NOT EXISTS `corealisateur` (
  `VISA` char(15) NOT NULL,
  `IDREALISATEUR` char(32) NOT NULL,
  PRIMARY KEY (`VISA`,`IDREALISATEUR`),
  KEY `I_FK_COREALISATEUR_FILM` (`VISA`),
  KEY `I_FK_COREALISATEUR_REALISATEUR` (`IDREALISATEUR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

DROP TABLE IF EXISTS `film`;
CREATE TABLE IF NOT EXISTS `film` (
  `idfilm` int NOT NULL AUTO_INCREMENT,
  `VISA` char(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NOMCOMPAGNIE` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CODEGENRE` char(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TITRE` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `DUREE` smallint DEFAULT NULL,
  `VERSION` char(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `DATELIMITE` date DEFAULT NULL,
  `URL` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `dateSortie` date NOT NULL,
  `avec` mediumtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `synopsis` mediumtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `prochainement` tinyint(1) NOT NULL,
  PRIMARY KEY (`idfilm`),
  KEY `I_FK_FILM_MAISONEDITION` (`NOMCOMPAGNIE`),
  KEY `I_FK_FILM_GENRE` (`CODEGENRE`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `film`
--

INSERT INTO `film` (`idfilm`, `VISA`, `NOMCOMPAGNIE`, `CODEGENRE`, `TITRE`, `DUREE`, `VERSION`, `DATELIMITE`, `URL`, `dateSortie`, `avec`, `synopsis`, `prochainement`) VALUES
(1, '', 'Disney', 'Animation', 'Reine des neiges 2', 104, 'Française', '2020-05-24', 'ReineDesNeiges2.jpg', '2020-04-20', 'Kristen Bell, Idina Menzel, Jonathan Groff, Josh Gad', 'En septembre, au royaume d\'Arendelle. 6 ans après la mort de ses parents, alors qu\'elle célèbre\r\n                    l\'arrivée de l\'automne, la reine Elsa commence à entendre une étrange voix venant du nord et\r\n                    l\'appellant. Le royaume est attaqué par des esprits élémentaires lorsque la reine les réveille\r\n                    accidentellement. Les habitants mis en lieu sûr, Elsa entame une nouvelle aventure avec sa sœur Anna\r\n                    et leurs amis Kristoff, le renne Sven et le bonhomme de neige Olaf. Ensemble, afin de sauver le\r\n                    royaume, ils partent à la recherche de la Forêt Enchantée...', 0),
(2, '', 'SND', 'Comédie', 'Inséparable', 94, 'Française', '2020-05-17', 'Inseparables.jpg', '2020-04-17', 'Kristen Bell, Idina Menzel, Jonathan Groff, Josh Gad', 'Mika, un petit escroc, a fait un rapide tour en prison, où il a fait la connaissance de « Poutine »,\r\n                    un détenu cinglé et imprévisible. Sitôt sa peine purgée, il décide de repartir à zéro et de refaire\r\n                    sa vie. Alors qu’il s’apprête à épouser la fille d’un riche homme d’affaires, son passé le rattrape\r\n                    : Poutine débarque sans prévenir ! Mika va vite réaliser qu’on ne se débarrasse pas aisément d’un\r\n                    tel boulet...', 0),
(3, '', 'Sony', 'Action', 'Charlie\'s angels', 119, 'Française', '2020-12-07', 'CharlesAngels.jpg', '2020-11-07', 'Kristen Stewart, Naomi Scott, Ella Balinska, Elizabeth Banks', 'Depuis plusieurs années, l\'agence de détectives Townsend est réputée pour les services offert par ses\r\n                    « Anges » : un trio de femmes qui change d\'une génération à l\'autre. Mais ce temps est désormais\r\n                    révolu, l\'agence est maintenant internationale et dispose de plusieurs équipes d\'« Anges » partout\r\n                    dans le monde, toutes guidées par des « Bosley ». Quand Elena Houghlin, une scientifique de génie,\r\n                    découvre que la société pour laquelle elle travaille, Brock Industrie, veut mettre sur le marché une\r\n                    technologie nommée Calisto, qu\'elle a créée, elle avertit son supérieur que le projet est loin\r\n                    d\'être terminé et qu\'il peut, dans de mauvaises mains, être transformé en arme. Néanmoins, cela ne\r\n                    l\'arrête pas. Elena se tourne donc vers les services de l\'agence Townsend...', 0),
(4, '', 'Paramount', 'Horreur', 'Sans un bruit 2', 97, 'Française', '2021-07-26', 'Sans-un-bruit-2.jpg', '2021-05-26', 'Emily Blunt, Millicent Simmonds, Noah Jupe, Cillian Murphy, Djimon Hounsou', 'Après les événements mortels survenus dans sa maison, la famille Abbot doit faire face au\r\n					danger du monde extérieur. Pour survivre, ils doivent se battre en silence. Forcés à\r\n					s\'aventurer en terrain inconnu, ils réalisent que les créatures qui attaquent au moindre son\r\n					ne sont pas la seule menace qui se dresse sur leur chemin...', 1),
(5, '', 'Nickelodeon', 'Animation', 'Bob l\'eponge le film', 83, 'Française', '2021-12-05', 'Bob_l_eponge_le_film.jpg', '2021-11-05', 'Tom Kenny, Bill Fagerbakke', ' Suite à l’escargot-napping de Gary, son compagnon de toujours, Bob l’éponge entraîne son\r\n                    meilleur ami Patrick dans une folle aventure vers la Cité Perdue d’Atlantic City afin de le\r\n                    retrouver. À travers cette mission sauvetage pleine de surprises, de merveilles et de\r\n                    dangers, Bob l’éponge et ses acolytes vont réaliser que rien n’est plus fort que le pouvoir\r\n                    de l’amitié...', 1),
(6, '', 'Fox Studio', 'Science-fiction', 'Avatar 2', 180, 'Française', '2022-01-16', 'Avatar_2.jpg', '2021-12-16', 'Zoe Saldana, Sam Worthington, Stephen Lang, Kate Winslet, Sigourney Weaver', 'L\'intrigue se déroule plusieurs années après la destruction de l\'arbre-maison1.\r\n                    Le réalisateur a fait savoir que le film a pour thème principal la famille (Jake Sully,\r\n                    Ney\'tiri et leurs trois enfants) et se déroule sur les côtes et dans les océans de Pandora.\r\n                    Le film explore les coutumes et la culture du peuple des Na\'vi avec les Omaticayas ainsi que\r\n                    le clan côtier des Metkayina....', 1);

-- --------------------------------------------------------

--
-- Structure de la table `genre`
--

DROP TABLE IF EXISTS `genre`;
CREATE TABLE IF NOT EXISTS `genre` (
  `CODEGENRE` char(32) NOT NULL,
  `NOMGENRE` char(32) DEFAULT NULL,
  PRIMARY KEY (`CODEGENRE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `heureprojection`
--

DROP TABLE IF EXISTS `heureprojection`;
CREATE TABLE IF NOT EXISTS `heureprojection` (
  `HEUREDEBUT` date NOT NULL,
  `HEUREFIN` date DEFAULT NULL,
  PRIMARY KEY (`HEUREDEBUT`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `idinscription` int NOT NULL AUTO_INCREMENT,
  `prenom` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `animation` varchar(50) NOT NULL,
  `structure` varchar(50) NOT NULL,
  PRIMARY KEY (`idinscription`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`idinscription`, `prenom`, `nom`, `email`, `tel`, `adresse`, `animation`, `structure`) VALUES
(1, 'Pierre', '', 'darpier@gmail.com', '01...', '04 rue commartin', 'Bambin(e)s', 'Centre de loisirs'),
(2, 'Pierre', '', 'user', '06...', '04 rue commartin', 'Roulez Jeunesse', 'Association'),
(3, 'Pierre', '', 'darpier@gmail.com', '06...', '24bis avenue cÃ©sar', 'Nous les Gosses', 'Centre de loisirs'),
(19, '', 'SSSSSSSS', 'veyrat.marine@gmail.com', '01...', '04 rue commartin', 'Nous les Gosses', 'du Centre'),
(20, '', 'WWWWWWWW', 'veyrat.marine@gmail.com', '01...', '04 rue commartin', 'Nous les Gosses', 'de l\'Association'),
(21, 'Pierre', 'Darcel', 'darpier@gmail.com', '01...', '04 rue commartin', 'Nous les Gosses', '');

-- --------------------------------------------------------

--
-- Structure de la table `jouer`
--

DROP TABLE IF EXISTS `jouer`;
CREATE TABLE IF NOT EXISTS `jouer` (
  `VISA` char(15) NOT NULL,
  `ACTEUR` char(50) NOT NULL,
  `ROLE` char(32) DEFAULT NULL,
  PRIMARY KEY (`VISA`,`ACTEUR`),
  KEY `I_FK_JOUER_FILM` (`VISA`),
  KEY `I_FK_JOUER_AUTEUR` (`ACTEUR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `maisonedition`
--

DROP TABLE IF EXISTS `maisonedition`;
CREATE TABLE IF NOT EXISTS `maisonedition` (
  `NOMCOMPAGNIE` varchar(128) NOT NULL,
  PRIMARY KEY (`NOMCOMPAGNIE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

DROP TABLE IF EXISTS `paiement`;
CREATE TABLE IF NOT EXISTS `paiement` (
  `idpaiement` int NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `carte` bigint NOT NULL,
  `mois` varchar(30) NOT NULL,
  `annee` int NOT NULL,
  `code` int NOT NULL,
  PRIMARY KEY (`idpaiement`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `paiement`
--

INSERT INTO `paiement` (`idpaiement`, `type`, `nom`, `email`, `carte`, `mois`, `annee`, `code`) VALUES
(1, 'Visa', '', '', 2223524, 'Janvier', 2021, 123),
(7, 'Visa', 'VEYRATTTTT', '', 8426264444444444, '10', 2021, 123),
(8, 'Visa', 'VEYRATTTTT', '', 8426264444444444, '10', 2021, 123),
(9, 'Visa', 'MARINEEEE', '', 1234567891234567, '05', 2021, 123),
(10, 'Visa', 'PAPAPAPAPAPA', '', 1234787891234569, '09', 2024, 852),
(11, 'Visa', 'PAPAPAPAPAPA', '', 1234787891234569, '09', 2024, 852),
(12, 'Visa', '', '', 1111111111111111, '03', 2021, 123),
(13, 'Visa', '', 'darpier@gmail.com', 1234567891234567, '03', 2021, 123),
(14, 'Visa', '', '', 1234567891234567, '03', 2021, 123),
(15, 'VisaElectron', '', '', 1234567891234567, '03', 2021, 123),
(16, 'Visa', '', '', 1234567891234567, '03', 2021, 123),
(17, 'Visa', '', '', 1234567891234567, '03', 2021, 123),
(18, 'Visa', '', '', 1234567891234567, '03', 2021, 123),
(19, 'Visa', 'yuyuyuyu', 'jfgeny@gmail.com', 1231231525478521, '03', 2021, 123),
(20, 'Visa', '', '', 1111111111111111, '04', 2021, 111),
(21, 'Visa', 'Gény', '', 1111111111111111, '04', 2021, 654),
(22, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(23, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(24, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(25, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(26, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 123),
(27, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(28, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(29, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(30, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(31, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(32, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(33, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(34, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(35, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(36, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(37, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(38, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(39, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(40, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111222233334444, '04', 2021, 111),
(41, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111222233334444, '04', 2021, 111),
(42, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(43, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(44, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(45, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(46, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(47, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(48, 'Visa', 'Gény', 'pseudo.ano.nyme.12345@gmail.com', 1111111111111111, '04', 2021, 111),
(49, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(50, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(51, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(52, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(53, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(54, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(55, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(56, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(57, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(58, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(59, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(60, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(61, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(62, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(63, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(64, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(65, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(66, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(67, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(68, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(69, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(70, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(71, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(72, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(73, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(74, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(75, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(76, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(77, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(78, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(79, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(80, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(81, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(82, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(83, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(84, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(85, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(86, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(87, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(88, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(89, 'MasterCard', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(90, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(91, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(92, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(93, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(94, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(95, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(96, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(97, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(98, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(99, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(100, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(101, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111),
(102, 'Visa', 'Gény', 'jfgeny@gmail.com', 1111111111111111, '04', 2021, 111);

--
-- Déclencheurs `paiement`
--
DROP TRIGGER IF EXISTS `longcrypto`;
DELIMITER $$
CREATE TRIGGER `longcrypto` BEFORE INSERT ON `paiement` FOR EACH ROW BEGIN


    if length(new.code) > 3  or length(new.code) < 3
   then signal sqlstate '45000'
   set message_text = 'Le numero de votre crypto doit comporter 3 chiffres'; 
    end if;
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `numcarte`;
DELIMITER $$
CREATE TRIGGER `numcarte` BEFORE INSERT ON `paiement` FOR EACH ROW BEGIN 
if (new.carte) < 1000000000000000 or (new.carte) > 9999999999999999 
then signal sqlstate '45000' 
set message_text = 'Le numero de votre carte bancaire doit comporter 16 chiffres'; 
end if; 
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `validation_carteExpiration`;
DELIMITER $$
CREATE TRIGGER `validation_carteExpiration` BEFORE INSERT ON `paiement` FOR EACH ROW if concat(new.annee,new.mois)<concat(year(now()),date_format(now(),'%m')) then
signal sqlstate '50000'
set message_text = 'Carte expirée';
end if
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `panier`
-- (Voir ci-dessous la vue réelle)
--
DROP VIEW IF EXISTS `panier`;
CREATE TABLE IF NOT EXISTS `panier` (
`titre` varchar(50)
,`nom` varchar(50)
,`prenom` varchar(50)
,`email` varchar(100)
,`date_jour` date
,`date_heure` time
,`tarifScolaire` int
,`tarifEnfant` int
,`tarifReduit` int
,`tarifPlein` int
,`total` decimal(25,2)
);

-- --------------------------------------------------------

--
-- Structure de la table `realisateur`
--

DROP TABLE IF EXISTS `realisateur`;
CREATE TABLE IF NOT EXISTS `realisateur` (
  `NOMREALISATEUR` varchar(128) DEFAULT NULL,
  `PRENOMREALISATEUR` varchar(128) DEFAULT NULL,
  `NATIONALITEREALISATEUR` varchar(128) DEFAULT NULL,
  `IDREALISATEUR` char(32) NOT NULL,
  PRIMARY KEY (`IDREALISATEUR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `idreservation` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `confirmation` varchar(100) NOT NULL,
  `tarifPlein` int DEFAULT NULL,
  `tarifReduit` int DEFAULT NULL,
  `tarifEnfant` int DEFAULT NULL,
  `tarifScolaire` int DEFAULT NULL,
  `idfilm` int NOT NULL,
  `id_seance` int DEFAULT NULL,
  PRIMARY KEY (`idreservation`),
  KEY `idfilm` (`idfilm`),
  KEY `id_seance` (`id_seance`)
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`idreservation`, `nom`, `prenom`, `email`, `confirmation`, `tarifPlein`, `tarifReduit`, `tarifEnfant`, `tarifScolaire`, `idfilm`, `id_seance`) VALUES
(226, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 5, 0, 0, 0, 3, 7),
(227, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 2, 3, 2, 3, 1, 1),
(228, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 10, 0, 0, 0, 1, 1),
(229, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 2, 0, 7, 0, 1, 1),
(230, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 3, 2, 0, 6, 1, 1),
(231, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 1, 1, 1, 1, 3, 0),
(232, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 2, 2, 2, 4, 3, 9),
(233, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 2, 0, 0, 0, 3, 9),
(234, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 3, 0, 0, 0, 2, 0),
(235, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 1, 0, 0, 0, 2, 0),
(236, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 1, 0, 0, 0, 2, 4),
(237, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 12, 0, 0, 0, 3, 8),
(238, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 8, 0, 0, 0, 3, 9),
(239, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 2, 0, 0, 0, 3, 0),
(240, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 1, 0, 0, 0, 3, 0),
(241, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 1, 0, 0, 0, 3, 8),
(242, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 1, 0, 0, 0, 0, 0),
(243, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 4, 0, 0, 0, 3, 8),
(244, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 1, 0, 0, 0, 3, 0),
(245, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 2, 0, 0, 0, 3, 7),
(246, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 14, 0, 0, 0, 0, 0),
(247, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 2, 0, 0, 0, 3, 0),
(248, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 1, 0, 0, 0, 3, 0),
(249, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 13, 0, 0, 0, 0, 0),
(250, 'Gény', 'Jean-François', 'jfgeny@gmail.com', 'jfgeny@gmail.com', 1, 0, 0, 0, 3, 0);

--
-- Déclencheurs `reservation`
--
DROP TRIGGER IF EXISTS `verifEmail`;
DELIMITER $$
CREATE TRIGGER `verifEmail` BEFORE INSERT ON `reservation` FOR EACH ROW BEGIN

   if (new.email) <> (new.confirmation) 
        then signal sqlstate '45000'
        set message_text = 'Emails non identiques';
    end if;

END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `verifPlace`;
DELIMITER $$
CREATE TRIGGER `verifPlace` BEFORE INSERT ON `reservation` FOR EACH ROW BEGIN
   if (new.tarifPlein = 0) and (new.tarifReduit = 0) and (new.tarifEnfant = 0) and (new.tarifScolaire = 0)
        then signal sqlstate '45000'
        set message_text = 'Vous devez acheter au moins une place';
    end if;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `idutilisateur` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mdp` varchar(30) DEFAULT NULL,
  `confirmation` varchar(100) DEFAULT NULL,
  `poste` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idutilisateur`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idutilisateur`, `nom`, `prenom`, `email`, `mdp`, `confirmation`, `poste`) VALUES
(1, 'veyrat', 'marine', 'veyrat.marine@gmail.com', '123', '', 'directrice'),
(2, 'Bournonville', 'loic', 'bour.loic@gmail.com', '123', '', ''),
(4, 'geny', 'ninon', 'geny.ninon@gmail.com', '123', '', 'directrice'),
(5, 'ezzc', 'vdvdv', 'vdvssvd', '123', '', ''),
(6, 'Geni', 'Ninon', '', '123', '', ''),
(8, 'Darcel', 'Pierre', 'darpier@gmail.com', '123', '', 'Client'),
(11, '', '', 'veyrat.eric@gmail.com', '123', '', 'Client'),
(13, '', '', 'jfgeny@gmail.com', '123', '123', 'Client');

--
-- Déclencheurs `utilisateur`
--
DROP TRIGGER IF EXISTS `verifMdp`;
DELIMITER $$
CREATE TRIGGER `verifMdp` BEFORE INSERT ON `utilisateur` FOR EACH ROW BEGIN

   if (new.mdp) <> (new.confirmation) 
        then signal sqlstate '45000'
        set message_text = 'Mot de passe non identiques';
    end if;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la vue `panier`
--
DROP TABLE IF EXISTS `panier`;

DROP VIEW IF EXISTS `panier`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `panier`  AS  select `f`.`TITRE` AS `titre`,`r`.`nom` AS `nom`,`r`.`prenom` AS `prenom`,`r`.`email` AS `email`,`c`.`date_jour` AS `date_jour`,`c`.`date_heure` AS `date_heure`,`r`.`tarifScolaire` AS `tarifScolaire`,`r`.`tarifEnfant` AS `tarifEnfant`,`r`.`tarifReduit` AS `tarifReduit`,`r`.`tarifPlein` AS `tarifPlein`,((((`r`.`tarifScolaire` * 3) + (`r`.`tarifEnfant` * 3.50)) + (`r`.`tarifReduit` * 4.50)) + (`r`.`tarifPlein` * 6.50)) AS `total` from ((`film` `f` join `reservation` `r`) join `calendrier` `c`) where ((`f`.`idfilm` = `r`.`idfilm`) and (`r`.`id_seance` = `c`.`id_seance`)) ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
