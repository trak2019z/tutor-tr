-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 08 Lis 2018, 22:03
-- Wersja serwera: 5.6.26
-- Wersja PHP: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `tutor`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `categoryId` int(11) NOT NULL,
  `categoryName` varchar(30) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `category`
--

INSERT INTO `category` (`categoryId`, `categoryName`) VALUES
(1, 'IT'),
(2, 'Progrmowanie'),
(3, 'Kulinaria'),
(4, 'Motoryzacja'),
(5, 'Elektronika');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `subtutorial`
--

CREATE TABLE IF NOT EXISTS `subtutorial` (
  `subTutId` int(11) NOT NULL,
  `subject` varchar(150) COLLATE utf8_polish_ci NOT NULL,
  `content` varchar(20000) COLLATE utf8_polish_ci NOT NULL,
  `subDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idTut` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tutorial`
--

CREATE TABLE IF NOT EXISTS `tutorial` (
  `tutId` int(11) NOT NULL,
  `subDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(150) COLLATE utf8_polish_ci NOT NULL,
  `description` varchar(300) COLLATE utf8_polish_ci NOT NULL,
  `imgName` varchar(60) CHARACTER SET utf16 COLLATE utf16_polish_ci NOT NULL,
  `marks` int(11) NOT NULL DEFAULT '0',
  `opinionsCount` int(11) NOT NULL DEFAULT '0',
  `userId` int(11) NOT NULL,
  `catId` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `tutorial`
--

INSERT INTO `tutorial` (`tutId`, `subDate`, `name`, `description`, `imgName`, `marks`, `opinionsCount`, `userId`, `catId`) VALUES
(2, '2018-11-08 20:25:48', 'test', 'testowy poradnik', 'https://i.imgur.com/OZcuXrG.jpg', 0, 0, 1, 1),
(3, '2018-11-08 20:41:54', 'Test2', 'poradnik testowy dla użytkownika', 'https://i.imgur.com/98lmAxv.jpg', 0, 0, 2, 5),
(4, '2018-11-08 20:54:33', 'test3', 'test3', 'https://i.imgur.com/IzKjjCI.jpg', 0, 0, 1, 3);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(11) NOT NULL,
  `login` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `password` varchar(60) COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `user_role` varchar(10) COLLATE utf8_polish_ci NOT NULL DEFAULT 'ROLE_USER',
  `user_status` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `user`
--

INSERT INTO `user` (`userId`, `login`, `password`, `email`, `user_role`, `user_status`) VALUES
(1, 'asd', '$2a$10$QbS7MrstUq2aZe4k.svqj.918e6EFYqAPK579Y9sjpxcMPbDx/Qiy', 'asd', 'ROLE_USER', 1),
(2, 'asdf', '$2a$10$a3LWoCeYQIYsnHNKGjNfnu99560S7jOvUwfDMF8hmbOA/7XZOUPo.', 'asdf', 'ROLE_USER', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `user_name` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `user_role` varchar(20) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryId`);

--
-- Indexes for table `subtutorial`
--
ALTER TABLE `subtutorial`
  ADD PRIMARY KEY (`subTutId`);

--
-- Indexes for table `tutorial`
--
ALTER TABLE `tutorial`
  ADD PRIMARY KEY (`tutId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `category`
--
ALTER TABLE `category`
  MODIFY `categoryId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT dla tabeli `subtutorial`
--
ALTER TABLE `subtutorial`
  MODIFY `subTutId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `tutorial`
--
ALTER TABLE `tutorial`
  MODIFY `tutId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
