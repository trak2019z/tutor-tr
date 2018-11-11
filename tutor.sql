-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 11 Lis 2018, 18:50
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
-- Struktura tabeli dla tabeli `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `commentId` int(11) NOT NULL,
  `content` varchar(3000) COLLATE utf8_polish_ci NOT NULL,
  `subDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userId` int(11) NOT NULL,
  `subTutId` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `comment`
--

INSERT INTO `comment` (`commentId`, `content`, `subDate`, `userId`, `subTutId`) VALUES
(1, 'testowy komentarz', '2018-11-11 16:00:12', 1, 4),
(2, 'komentarz', '2018-11-11 16:22:34', 1, 5),
(3, 'pierwszy :)', '2018-11-11 16:55:58', 1, 1),
(4, 'i drugi od razu :D', '2018-11-11 16:56:09', 1, 1),
(5, 'KOMENTARZ CAPS LOCK', '2018-11-11 17:46:32', 1, 7);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `subtutorial`
--

CREATE TABLE IF NOT EXISTS `subtutorial` (
  `subTutId` int(11) NOT NULL,
  `subject` varchar(150) COLLATE utf8_polish_ci NOT NULL,
  `content` varchar(20000) COLLATE utf8_polish_ci NOT NULL,
  `lessNumb` int(11) NOT NULL,
  `subDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idTut` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `subtutorial`
--

INSERT INTO `subtutorial` (`subTutId`, `subject`, `content`, `lessNumb`, `subDate`, `idTut`) VALUES
(1, 'pierwsza lekcja', 'to jest pierwsza lekcja', 1, '2018-11-10 18:41:01', 2),
(2, 'druga lekcja', 'to jest druga lekcja', 2, '2018-11-10 18:41:27', 2),
(3, 'assa', 'dsfsd', 3, '2018-11-10 20:50:21', 2),
(4, 'pierwszy', 'first *imgUrl* https://i.imgur.com/Lgw3gLg.jpg *imgUrl*', 1, '2018-11-10 21:01:10', 4),
(5, 'To jest temat', 'To jest treść lekcji :) *imgUrl* https://i.imgur.com/NTS9ZUy.jpg *imgUrl*', 1, '2018-11-10 21:41:02', 3),
(6, 'Test wielu zdjęć przesłanych na serwer.', 'Lorem Ipsum jest tekstem stosowanym jako przykładowy wypełniacz w przemyśle poligraficznym. Został po raz pierwszy użyty w XV w. przez nieznanego drukarza do wypełnienia tekstem próbnej książki. Pięć wieków później zaczął być używany przemyśle elektronicznym, pozostając praktycznie niezmienionym. Spopularyzował się w latach 60. XX w. wraz z publikacją arkuszy Letrasetu, zawierających fragmenty Lorem Ipsum, a ostatnio z zawierającym różne wersje Lorem Ipsum oprogramowaniem przeznaczonym do realizacji druków na komputerach osobistych, jak Aldus PageMaker *imgUrl* https://i.imgur.com/QmNcQyq.png *imgUrl*W przeciwieństwie do rozpowszechnionych opinii, Lorem Ipsum nie jest tylko przypadkowym tekstem. Ma ono korzenie w klasycznej łacińskiej literaturze z 45 roku przed Chrystusem, czyli ponad 2000 lat temu! Richard McClintock, wykładowca łaciny na uniwersytecie Hampden-Sydney w Virginii, przyjrzał się uważniej jednemu z najbardziej niejasnych słów w Lorem Ipsum – consectetur – i po wielu poszukiwaniach odnalazł niezaprzeczalne źródło: Lorem Ipsum pochodzi z fragmentów (1.10.32 i 1.10.33) „de Finibus Bonorum et Malorum”, czyli „O granicy dobra i zła”, napisanej właśnie w 45 p.n.e. przez Cycerona. Jest to bardzo popularna w czasach renesansu rozprawa na temat etyki. Pierwszy wiersz Lorem Ipsum, „Lorem ipsum dolor sit amet...” pochodzi właśnie z sekcji 1.10.32. *imgUrl* https://i.imgur.com/KyalOgb.jpg *imgUrl*Ogólnie znana teza głosi, iż użytkownika może rozpraszać zrozumiała zawartość strony, kiedy ten chce zobaczyć sam jej wygląd. Jedną z mocnych stron używania Lorem Ipsum jest to, że ma wiele różnych „kombinacji” zdań, słów i akapitów, w przeciwieństwie do zwykłego: „tekst, tekst, tekst”, sprawiającego, że wygląda to „zbyt czytelnie” po polsku. Wielu webmasterów i designerów używa Lorem Ipsum jako domyślnego modelu tekstu i wpisanie w internetowej wyszukiwarce ‘lorem ipsum’ spowoduje znalezienie bardzo wielu stron, które wciąż są w budowie. Wiele wersji tekstu ewoluowało i zmieniało się przez lata, czasem przez przypadek, czasem specjalnie (humorystyczne wstawki itd). *imgUrl* https://i.imgur.com/RhRqspr.jpg *imgUrl*', 4, '2018-11-10 22:04:13', 2),
(7, 'Jak sobie radzić z błędem 404', 'Żeby szybko naprawić błędy 404, trzeba najpierw zrozumieć, czym one są i dlaczego występują.\r\n\r\nKrótka definicja: błędy 404 to standardowy status HTTP(S), który mówi użytkownikowi o tym, że uzyskał połączenie z serwerem, jednakże nie można wyświetlić podstrony o takim adresie URL, ponieważ jej po prostu nie ma.\r\n\r\nDlaczego występują błędy 404?\r\n\r\nBłąd po stronie użytkownika:\r\n\r\nRęcznie wpisany adres URL strony internetowej zawiera literówkę.\r\nŁącze, które użytkownik kliknął, zawiera literówkę.\r\nBłąd po stronie serwera:\r\n\r\nDana podstrona została przeniesiona do innego miejsca bez wcześniejszego przekierowania 301 lub 302.\r\nDana podstrona jest w tej chwili niedostępna np. z powodu prac nad nią.\r\nDana podstrona została usunięta.\r\nPierwszym krokiem jest znalezienie wszystkich błędów 404, które występują na Twojej witrynie, zarówno tych wewnętrznych, jak i zewnętrznych.\r\n\r\nJak to zrobić?\r\n\r\nPrzede wszystkim omijaj narzędzia online, ponieważ w większości przypadków nie znajdą one wszystkich błędów 404.\r\n\r\nWarto postawić na sprawdzone przez nas narzędzie Screaming Frog. W wersji darmowej możesz przeskanować 500 linków, a jeżeli Twoja witryna ma ich więcej, warto zastanowić się nad wersją płatną.\r\n\r\nPo instalacji programu w górne okienko wpisujemy nazwę naszej strony internetowej i klikamy „Start”. Po kilku minutach (w zależności od wielkości serwisu) otrzymujemy wyniki.\r\n\r\nInteresuje nas kolumna o nazwie „Status Code”, która posortuje wyniki według statusów odpowiedzi serwera. *imgUrl* https://i.imgur.com/oj2zIqt.png *imgUrl*Jeżeli Twoja strona zawiera tylko kilka podstron, to z pewnością sam znajdziesz wszystkie błędy 404 manualnie.\r\n\r\nJeżeli strona jest bardzo rozbudowana i występuje na niej duża liczba błędów 404, to warto skorzystać ze wbudowanej funkcji programu.Problem z błędami 404 jest taki, że będą pojawiać się regularnie na skutek naszej nieuwagi lub usunięcia przez kogoś linka, który umieściliśmy np. w swoim wpisie lub artykule na blogu.\r\n\r\nDlatego należy monitorować i na bieżąco naprawiać błędy 404. *imgUrl* https://i.imgur.com/urGOCwP.png *imgUrl*Niezależnie od tego, jak będziesz się starał walczyć z błędami 404, nie można zapobiec wszystkim.\r\n\r\nNajczęściej występują przez nieuwagę użytkowników, którzy wpisują nieprawidłowe adresy URL.\r\n\r\nWobec tego warto stworzyć niestandardowy szablon błędu 404.\r\n\r\nDlaczego?\r\n\r\nStandardowy wygląd błędu 404 jest surowy i odpychający. Jednakże dobrze zaprojektowana strona z błędem 404 potrafi utrzymać odbiorców na witrynie internetowej i zaproponować alternatywne rozwiązanie.\r\n\r\nCo powinna zawierać niestandardowa strona błędu 404?\r\n\r\nPodstawowe funkcje związane z Twoją marką.\r\nNawigację, w tym nagłówek oraz logo firmy.\r\nKrótki oraz miły komunikat o tym, że szukana podstrona nie istnieje. Warto postawić na humor, kreatywność, czy nawet dziwaczność.\r\nWezwanie do działania (CTA).\r\nInne wpisy lub produkty, które mogą zainteresować użytkownika.\r\nPole z wyszukiwarką.', 1, '2018-11-10 23:28:42', 5);

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `tutorial`
--

INSERT INTO `tutorial` (`tutId`, `subDate`, `name`, `description`, `imgName`, `marks`, `opinionsCount`, `userId`, `catId`) VALUES
(2, '2018-11-08 20:25:48', 'test', 'testowy poradnik', 'https://i.imgur.com/OZcuXrG.jpg', 0, 0, 1, 1),
(3, '2018-11-08 20:41:54', 'Test2', 'poradnik testowy dla użytkownika', 'https://i.imgur.com/98lmAxv.jpg', 0, 0, 2, 5),
(4, '2018-11-08 20:54:33', 'test3', 'test3', 'https://i.imgur.com/IzKjjCI.jpg', 0, 0, 1, 3),
(5, '2018-11-10 23:16:53', 'Jak sobie radzić z błędem 404.', 'Opis jak rozwiązać problem z pojawiającym się błędem 404', 'https://i.imgur.com/l30EH6T.jpg', 0, 0, 1, 1);

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
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`commentId`);

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
-- AUTO_INCREMENT dla tabeli `comment`
--
ALTER TABLE `comment`
  MODIFY `commentId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT dla tabeli `subtutorial`
--
ALTER TABLE `subtutorial`
  MODIFY `subTutId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT dla tabeli `tutorial`
--
ALTER TABLE `tutorial`
  MODIFY `tutId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
