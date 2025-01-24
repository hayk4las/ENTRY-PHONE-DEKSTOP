-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 24 Jan 2025 pada 02.59
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `entry_phone`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `imei` varchar(16) NOT NULL,
  `merk_hp` varchar(100) NOT NULL,
  `storage` varchar(10) NOT NULL,
  `harga` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`imei`, `merk_hp`, `storage`, `harga`) VALUES
('356789123456781', 'iPhone 13', '4/64GB', 12000000),
('356789123456782', 'iPhone 13 Mini', '4/128GB', 13000000),
('356789123456783', 'iPhone 14', '6/128GB', 14000000),
('356789123456784', 'iPhone 14 Pro', '6/256GB', 16000000),
('356789123456785', 'iPhone 14 Pro Max', '8/512GB', 20000000),
('356789123456786', 'Samsung Galaxy A52', '4/64GB', 6000000),
('356789123456787', 'Samsung Galaxy A72', '6/128GB', 7500000),
('356789123456788', 'Samsung Galaxy S20', '8/256GB', 10000000),
('356789123456789', 'Samsung Galaxy S21 Ultra', '12/512GB', 15000000),
('356789123456790', 'Samsung Galaxy Z Flip 4', '8/256GB', 14000000),
('356789123456791', 'iPhone SE 2022', '3/64GB', 9000000),
('356789123456792', 'iPhone 12', '4/128GB', 12000000),
('356789123456793', 'Samsung Galaxy Note 20', '8/128GB', 11000000),
('356789123456794', 'Samsung Galaxy Note 20 Ultra', '12/512GB', 16000000),
('356789123456795', 'Samsung Galaxy S23', '8/256GB', 14000000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `kode` varchar(20) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `alamat` text NOT NULL,
  `telepon` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`kode`, `nama`, `alamat`, `telepon`) VALUES
('P001', 'Haykal', 'Batang', '085602505754'),
('P002', 'Aulia', 'Jakarta', '081234567891'),
('P003', 'Zahra', 'Surabaya', '081234567892'),
('P004', 'Raka', 'Bandung', '081234567893'),
('P005', 'Naufal', 'Yogyakarta', '081234567894'),
('P006', 'Dina', 'Semarang', '081234567895'),
('P007', 'Fikri', 'Malang', '081234567896'),
('P008', 'Arif', 'Medan', '081234567897'),
('P009', 'Rani', 'Makassar', '081234567898'),
('P010', 'Citra', 'Palembang', '081234567899'),
('P011', 'Farhan', 'Denpasar', '081234567810'),
('P012', 'Tasya', 'Padang', '081234567811'),
('P013', 'Ihsan', 'Banjarmasin', '081234567812'),
('P014', 'Adit', 'Pontianak', '081234567813'),
('P015', 'Rina', 'Batam', '081234567814'),
('P016', 'Dewi', 'Pekanbaru', '081234567815');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tr_penjualan`
--

CREATE TABLE `tr_penjualan` (
  `nomor` varchar(20) NOT NULL,
  `tanggal` date NOT NULL,
  `total` int(11) NOT NULL,
  `pelanggan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tr_penjualan`
--

INSERT INTO `tr_penjualan` (`nomor`, `tanggal`, `total`, `pelanggan`) VALUES
('T001', '2024-01-04', 20000000, 'P001'),
('T002', '2025-01-01', 7500000, 'P002');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tr_penjualan_detail`
--

CREATE TABLE `tr_penjualan_detail` (
  `id` int(11) NOT NULL,
  `kuantiti` double NOT NULL,
  `harga` int(11) NOT NULL,
  `barang` varchar(100) NOT NULL,
  `penjualan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tr_penjualan_detail`
--

INSERT INTO `tr_penjualan_detail` (`id`, `kuantiti`, `harga`, `barang`, `penjualan`) VALUES
(1, 1, 20000000, '356789123456785', 'T001'),
(2, 1, 7500000, '356789123456787', 'T002');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`username`, `password`) VALUES
('admin', '202cb962ac59075b964b07152d234b70');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`imei`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`kode`);

--
-- Indeks untuk tabel `tr_penjualan`
--
ALTER TABLE `tr_penjualan`
  ADD PRIMARY KEY (`nomor`);

--
-- Indeks untuk tabel `tr_penjualan_detail`
--
ALTER TABLE `tr_penjualan_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tr_penjualan_detail`
--
ALTER TABLE `tr_penjualan_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
