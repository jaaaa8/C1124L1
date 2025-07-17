drop database if exists ordersmanagement;
create database ordersmanagement;
use ordersmanagement;

create table NhaCC(
	id_ncc int primary key auto_increment unique,
    name varchar(50),
    location varchar(50)
);

create table PhoneNumber(
	id_phone int primary key auto_increment,
    id_nhacc int,
    phone_number varchar(20),
    foreign key(id_nhacc) references NhaCC(id_ncc)
);

create table DonDH(
	id_don_dh int primary key auto_increment unique,
    ngay_DH date,
    id_nha_cc int,
    foreign key(id_nha_cc) references NhaCC(id_ncc)
);

create table PhieuNhap(
	id_pn int primary key auto_increment unique,
    ngay_nhap date
);

create table VatTu(
	id_vt int primary key auto_increment unique,
    name varchar(50)
);

create table DonNhap(
    id_vat_tu int,
    id_phieu_nhap int,
    don_gia float,
    so_luong int,
    constraint id primary key(id_vat_tu,id_phieu_nhap),
    foreign key(id_vat_tu) references VatTu(id_vt),
    foreign key(id_phieu_nhap) references PhieuNhap(id_pn)
);

create table PhieuXuat(
	id_px int primary key auto_increment unique,
    ngay_xuat date
);

create table DonXuat(
	id_vat_tu int,
    id_phieu_xuat int,
    don_gia float,
    so_luong int,
    constraint id primary key(id_vat_tu,id_phieu_xuat),
    foreign key(id_vat_tu) references VatTu(id_vt),
    foreign key(id_phieu_xuat) references PhieuXuat(id_px)
);

create table ChiTietDonDH(
	id_don_hang int,
    id_vat_tu int,
    constraint id primary key(id_don_hang,id_vat_tu),
    foreign key(id_don_hang) references DonDH(id_don_dh),
    foreign key(id_vat_tu) references VatTu(id_vt)
);