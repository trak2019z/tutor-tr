-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 05 Lis 2018, 20:24
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
-- Struktura tabeli dla tabeli `tutorial`
--

CREATE TABLE IF NOT EXISTS `tutorial` (
  `tutId` int(11) NOT NULL,
  `subDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(150) COLLATE utf8_polish_ci NOT NULL,
  `description` varchar(300) COLLATE utf8_polish_ci NOT NULL,
  `imgName` varchar(60) CHARACTER SET utf16 COLLATE utf16_polish_ci NOT NULL,
  `marks` int(11) NOT NULL,
  `opinionsCount` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `catId` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `tutorial`
--

INSERT INTO `tutorial` (`tutId`, `subDate`, `name`, `description`, `imgName`, `marks`, `opinionsCount`, `userId`, `catId`) VALUES
(1, '2018-11-05 14:22:14', 'Pierwszy tutorial', 'Pierwszy testowy tutorial', 'firstTut.jpg', 0, 0, 1, 1);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `tutorial`
--
ALTER TABLE `tutorial`
  ADD PRIMARY KEY (`tutId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `tutorial`
--
ALTER TABLE `tutorial`
  MODIFY `tutId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
