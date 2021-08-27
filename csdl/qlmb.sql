-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 27, 2021 lúc 08:13 AM
-- Phiên bản máy phục vụ: 10.4.20-MariaDB
-- Phiên bản PHP: 7.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlmb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_hoa_don`
--

CREATE TABLE `chi_tiet_hoa_don` (
  `MA_HD` varchar(24) NOT NULL,
  `MA_VE` varchar(24) NOT NULL,
  `SO_LUONG` int(11) NOT NULL,
  `DON_GIA` int(11) NOT NULL,
  `THANH_TIEN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chi_tiet_hoa_don`
--

INSERT INTO `chi_tiet_hoa_don` (`MA_HD`, `MA_VE`, `SO_LUONG`, `DON_GIA`, `THANH_TIEN`) VALUES
('HD0_1_22-12-2022', '05_CB5_1', 1, 200000, 200000),
('HD0_1_22-12-2022', '06_CB5_1', 1, 200000, 200000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chuc_vu`
--

CREATE TABLE `chuc_vu` (
  `MA_CV` varchar(24) NOT NULL,
  `TEN_CV` varchar(24) NOT NULL,
  `LUONG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chuyen_bay`
--

CREATE TABLE `chuyen_bay` (
  `MA_CB` varchar(24) NOT NULL,
  `MA_MB` varchar(24) NOT NULL,
  `MA_DB` varchar(24) NOT NULL,
  `GIO_BAY` varchar(24) NOT NULL,
  `NGAY_DI` varchar(24) NOT NULL,
  `NGAY_DEN` varchar(24) NOT NULL,
  `SO_GHE_LOAI_1` int(11) NOT NULL,
  `SO_GHE_LOAI_2` int(11) NOT NULL,
  `TINH_TRANG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chuyen_bay`
--

INSERT INTO `chuyen_bay` (`MA_CB`, `MA_MB`, `MA_DB`, `GIO_BAY`, `NGAY_DI`, `NGAY_DEN`, `SO_GHE_LOAI_1`, `SO_GHE_LOAI_2`, `TINH_TRANG`) VALUES
('CB1', 'MB1', 'db1', '22:22', '22-12-2022', '23-12-2022', 10, 5, 0),
('CB2', 'MB1', 'db1', '22:22', '22-12-2022', '23-12-2022', 10, 5, 0),
('CB3', 'MB1', 'db1', '22:22', '22-12-2022', '23-12-2022', 10, 5, 0),
('CB4', 'MB1', 'db1', '22:22', '22-12-2022', '23-12-2022', 10, 5, 0),
('CB5', 'MB1', 'db1', '22:22', '22-12-2022', '23-12-2022', 10, 5, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dia_diem`
--

CREATE TABLE `dia_diem` (
  `MA_DD` varchar(10) NOT NULL,
  `TEN_DD` varchar(24) NOT NULL,
  `MUI_GIO` varchar(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `dia_diem`
--

INSERT INTO `dia_diem` (`MA_DD`, `TEN_DD`, `MUI_GIO`) VALUES
('HCM', 'HO CHI MINH', '7'),
('hn', 'ha noi', '7');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `duong_bay`
--

CREATE TABLE `duong_bay` (
  `MA_DB` varchar(24) NOT NULL,
  `MA_SB_DI` varchar(10) NOT NULL,
  `MA_SB_DEN` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `duong_bay`
--

INSERT INTO `duong_bay` (`MA_DB`, `MA_SB_DI`, `MA_SB_DEN`) VALUES
('db1', 'sb1', 'sb2'),
('db2', 'sb2', 'sb1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoa_don`
--

CREATE TABLE `hoa_don` (
  `MA_HD` varchar(24) NOT NULL,
  `MA_KH` int(11) NOT NULL,
  `MA_NV` int(11) DEFAULT NULL,
  `NGAY_MUA` varchar(11) DEFAULT NULL,
  `TONG_TIEN` int(11) DEFAULT NULL,
  `KM` int(11) DEFAULT NULL,
  `TINH_TRANG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `hoa_don`
--

INSERT INTO `hoa_don` (`MA_HD`, `MA_KH`, `MA_NV`, `NGAY_MUA`, `TONG_TIEN`, `KM`, `TINH_TRANG`) VALUES
('HD0_1_22-12-2022', 1, 1, '22-12-2022', 400000, 0, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khach_hang`
--

CREATE TABLE `khach_hang` (
  `MA_KH` int(11) NOT NULL,
  `HO` varchar(11) NOT NULL,
  `LOT` varchar(11) NOT NULL,
  `TEN` varchar(11) NOT NULL,
  `CMND` varchar(24) NOT NULL,
  `DIA_CHI` varchar(24) NOT NULL,
  `SDT` varchar(11) NOT NULL,
  `NAM_SINH` int(11) NOT NULL,
  `TINH_TRANG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `khach_hang`
--

INSERT INTO `khach_hang` (`MA_KH`, `HO`, `LOT`, `TEN`, `CMND`, `DIA_CHI`, `SDT`, `NAM_SINH`, `TINH_TRANG`) VALUES
(1, 'le', 'van', 'b', '123', '123', '123', 123, 1),
(2, 'le', 'van', 'b', '123', '123', '123', 123, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `km`
--

CREATE TABLE `km` (
  `MA_KM` varchar(10) NOT NULL,
  `BD` varchar(10) NOT NULL,
  `KT` varchar(10) NOT NULL,
  `SO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `may_bay`
--

CREATE TABLE `may_bay` (
  `MA_MB` varchar(24) NOT NULL,
  `TEN_MB` varchar(24) NOT NULL,
  `HANG_SX` varchar(24) NOT NULL,
  `SO_GHE_LOAI_1` int(11) NOT NULL,
  `SO_GHE_LOAI_2` int(11) NOT NULL,
  `TONG_GHE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `may_bay`
--

INSERT INTO `may_bay` (`MA_MB`, `TEN_MB`, `HANG_SX`, `SO_GHE_LOAI_1`, `SO_GHE_LOAI_2`, `TONG_GHE`) VALUES
('MB1', 'MB1', 'NGA', 10, 5, 15);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhan_vien`
--

CREATE TABLE `nhan_vien` (
  `MA_NV` int(11) NOT NULL,
  `HO` varchar(11) NOT NULL,
  `LOT` varchar(11) NOT NULL,
  `TEN` varchar(11) NOT NULL,
  `MA_CV` varchar(11) NOT NULL,
  `CMND` varchar(11) NOT NULL,
  `DIA_CHI` varchar(11) NOT NULL,
  `SDT` varchar(11) NOT NULL,
  `NAM_SINH` int(11) NOT NULL,
  `TINH_TRANG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhan_vien`
--

INSERT INTO `nhan_vien` (`MA_NV`, `HO`, `LOT`, `TEN`, `MA_CV`, `CMND`, `DIA_CHI`, `SDT`, `NAM_SINH`, `TINH_TRANG`) VALUES
(1, 'nguyen', 'van', 'bin', 'ql', '1234', '1234', '1234', 2001, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `san_bay`
--

CREATE TABLE `san_bay` (
  `MA_SB` varchar(10) NOT NULL,
  `TEN_SB` varchar(24) NOT NULL,
  `MA_DD` varchar(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `san_bay`
--

INSERT INTO `san_bay` (`MA_SB`, `TEN_SB`, `MA_DD`) VALUES
('sb1', 'tansonnhat', 'hcm'),
('sb2', 'tansonnhat2', 'hn');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tai_khoan`
--

CREATE TABLE `tai_khoan` (
  `ID` varchar(10) NOT NULL,
  `MA` int(11) NOT NULL,
  `TK` varchar(24) NOT NULL,
  `MK` varchar(24) NOT NULL,
  `ROLE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tai_khoan`
--

INSERT INTO `tai_khoan` (`ID`, `MA`, `TK`, `MK`, `ROLE`) VALUES
('KH1', 1, 'kh1', '1234', 1),
('KH2', 2, 'kh2', '123', 1),
('NV1', 1, 'admin1', '123', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ve`
--

CREATE TABLE `ve` (
  `MA_VE` varchar(24) NOT NULL,
  `MA_CB` varchar(24) NOT NULL,
  `MA_KH` int(11) NOT NULL,
  `NGAY_DAT` varchar(11) DEFAULT NULL,
  `LOAI_VE` int(11) NOT NULL,
  `GIA_TIEN` int(11) NOT NULL,
  `TINH_TRANG` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ve`
--

INSERT INTO `ve` (`MA_VE`, `MA_CB`, `MA_KH`, `NGAY_DAT`, `LOAI_VE`, `GIA_TIEN`, `TINH_TRANG`) VALUES
('01_CB4_1', 'CB4', 0, NULL, 1, 200000, 0),
('01_CB5_1', 'CB5', 1, '21-12-2022', 1, 200000, 1),
('02_CB4_1', 'CB4', 0, NULL, 1, 200000, 0),
('02_CB5_1', 'CB5', 1, '21-12-2022', 1, 200000, 1),
('03_CB4_1', 'CB4', 0, NULL, 1, 200000, 0),
('03_CB5_1', 'CB5', 1, '22-12-2022', 1, 200000, 1),
('04_CB4_1', 'CB4', 0, NULL, 1, 200000, 0),
('04_CB5_1', 'CB5', 1, '22-12-2022', 1, 200000, 1),
('05_CB4_1', 'CB4', 0, NULL, 1, 200000, 0),
('05_CB5_1', 'CB5', 1, '22-12-2022', 1, 200000, 1),
('06_CB4_1', 'CB4', 0, NULL, 1, 200000, 0),
('06_CB5_1', 'CB5', 1, '22-12-2022', 1, 200000, 1),
('07_CB4_1', 'CB4', 0, NULL, 1, 200000, 0),
('07_CB5_1', 'CB5', 0, NULL, 1, 200000, 1),
('08_CB4_1', 'CB4', 0, NULL, 1, 200000, 0),
('08_CB5_1', 'CB5', 0, NULL, 1, 200000, 1),
('09_CB4_1', 'CB4', 0, NULL, 1, 200000, 0),
('09_CB5_1', 'CB5', 0, NULL, 1, 200000, 1),
('10_CB4_1', 'CB4', 0, NULL, 1, 200000, 0),
('10_CB5_1', 'CB5', 0, NULL, 1, 200000, 1),
('11_CB4_2', 'CB4', 0, NULL, 2, 50000, 0),
('11_CB5_2', 'CB5', 0, NULL, 2, 50000, 1),
('12_CB4_2', 'CB4', 0, NULL, 2, 50000, 0),
('12_CB5_2', 'CB5', 0, NULL, 2, 50000, 1),
('13_CB4_2', 'CB4', 0, NULL, 2, 50000, 0),
('13_CB5_2', 'CB5', 0, NULL, 2, 50000, 1),
('14_CB4_2', 'CB4', 0, NULL, 2, 50000, 0),
('14_CB5_2', 'CB5', 0, NULL, 2, 50000, 1),
('15_CB4_2', 'CB4', 0, NULL, 2, 50000, 0),
('15_CB5_2', 'CB5', 0, NULL, 2, 50000, 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chi_tiet_hoa_don`
--
ALTER TABLE `chi_tiet_hoa_don`
  ADD PRIMARY KEY (`MA_HD`,`MA_VE`);

--
-- Chỉ mục cho bảng `dia_diem`
--
ALTER TABLE `dia_diem`
  ADD PRIMARY KEY (`MA_DD`);

--
-- Chỉ mục cho bảng `duong_bay`
--
ALTER TABLE `duong_bay`
  ADD PRIMARY KEY (`MA_DB`);

--
-- Chỉ mục cho bảng `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD PRIMARY KEY (`MA_HD`);

--
-- Chỉ mục cho bảng `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`MA_KH`);

--
-- Chỉ mục cho bảng `km`
--
ALTER TABLE `km`
  ADD PRIMARY KEY (`MA_KM`);

--
-- Chỉ mục cho bảng `may_bay`
--
ALTER TABLE `may_bay`
  ADD PRIMARY KEY (`MA_MB`);

--
-- Chỉ mục cho bảng `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD PRIMARY KEY (`MA_NV`);

--
-- Chỉ mục cho bảng `san_bay`
--
ALTER TABLE `san_bay`
  ADD PRIMARY KEY (`MA_SB`);

--
-- Chỉ mục cho bảng `tai_khoan`
--
ALTER TABLE `tai_khoan`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `ve`
--
ALTER TABLE `ve`
  ADD PRIMARY KEY (`MA_VE`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `khach_hang`
--
ALTER TABLE `khach_hang`
  MODIFY `MA_KH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `nhan_vien`
--
ALTER TABLE `nhan_vien`
  MODIFY `MA_NV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chi_tiet_hoa_don`
--
ALTER TABLE `chi_tiet_hoa_don`
  ADD CONSTRAINT `chi_tiet_hoa_don_ibfk_1` FOREIGN KEY (`MA_HD`) REFERENCES `hoa_don` (`MA_HD`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
