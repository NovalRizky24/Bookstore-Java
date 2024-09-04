-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 03, 2024 at 08:59 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_tokobuku`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `idbuku` int(11) NOT NULL,
  `filegambar` varchar(255) DEFAULT NULL,
  `harga` double NOT NULL,
  `jumlahhalaman` int(11) NOT NULL,
  `namabuku` varchar(255) DEFAULT NULL,
  `penulis` varchar(255) DEFAULT NULL,
  `tglterbit` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`idbuku`, `filegambar`, `harga`, `jumlahhalaman`, `namabuku`, `penulis`, `tglterbit`) VALUES
(2, 'LautBercerita.png', 109000, 394, 'Laut Bercerita', 'Leila S. Chudori', '2017-10-25 00:00:00.000000'),
(5, 'Laskar Pelangi.jpg', 89000, 529, 'Laskar Pelangi', 'Andrea Hirata', '2011-05-10 00:00:00.000000'),
(6, '1716732213562_Habits.jpg', 59000, 140, 'Is It Bad or Good Habits', 'Sabrina Ara', '2021-11-30 00:00:00.000000'),
(7, '1716952145483_Kata.jpg', 88000, 369, 'Kata', 'Rintik Sedu', '2018-11-07 00:00:00.000000'),
(8, '1716953433035_DuniaSopie.jpg', 125000, 798, 'Dunia Sophie', 'Jostein Gaarder', '2020-06-03 00:00:00.000000'),
(10, 'Dilan1990.jpg', 80000, 500, 'Dilan1990', 'Pidi Baiq', '2015-12-10 00:00:00.000000'),
(11, '1717369162704_Psychology of Money.jpeg', 90000, 268, 'Psychology of Money', 'Morgan Housell', '2021-12-28 00:00:00.000000'),
(12, '1717370439045_The Principles of Power.jpg', 60000, 194, 'The Principles Of Power', 'Dion Yulianto', '2023-09-28 00:00:00.000000'),
(13, '1717370499910_Sun Tzu.jpg', 58000, 200, 'The Power of Sun Tzu', 'Kai Tan', '2014-02-28 00:00:00.000000'),
(14, '1717370583981_Sebuah Sikap.jpg', 94000, 256, 'Sebuah Seni untuk Bersikap Bodo Amat', 'Mark Manson', '2009-03-19 00:00:00.000000');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `idtransaksi` int(11) NOT NULL,
  `harga` double DEFAULT NULL,
  `idbuku` int(11) DEFAULT NULL,
  `tanggaltransaksi` datetime(6) DEFAULT NULL,
  `iduser` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`idtransaksi`, `harga`, `idbuku`, `tanggaltransaksi`, `iduser`) VALUES
(1, 109000, 1, '2024-06-03 05:55:35.000000', 1),
(2, 80000, 1, '2024-06-03 05:55:55.000000', 1),
(3, 109000, 1, '2024-06-03 05:56:05.000000', 1),
(4, 89000, 3, '2024-06-03 05:56:18.000000', 3),
(5, 125000, 4, '2024-06-03 05:56:31.000000', 4),
(6, 59000, 4, '2024-06-03 05:56:40.000000', 4),
(7, 80000, 5, '2024-06-03 05:57:01.000000', 5),
(8, 109000, 5, '2024-06-03 05:57:06.000000', 5),
(9, 88000, 7, '2024-06-03 05:57:20.000000', 7),
(10, 60000, 1, '2024-06-03 06:55:07.000000', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`iduser`, `nama`, `password`, `role`, `username`) VALUES
(1, 'User', '1234', 'user', 'user'),
(2, 'admin', '1234', 'admin', 'admin'),
(3, 'Noval', '1234', 'user', 'noval'),
(4, 'Zaki', '1234', 'user', 'zaki'),
(5, 'Alpin', '1234', 'user', 'alpin'),
(6, 'User 3', '1234', 'user', 'user3'),
(7, 'User2', '1234', 'user', 'user2'),
(8, 'Roger', '1234', 'user', 'roger'),
(9, 'Huha', '123', 'user', 'Wongka');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`idbuku`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`idtransaksi`),
  ADD KEY `FKfswyiuvtpw4mgexq6vtstxxwa` (`iduser`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`iduser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `idbuku` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `idtransaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `FKfswyiuvtpw4mgexq6vtstxxwa` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
