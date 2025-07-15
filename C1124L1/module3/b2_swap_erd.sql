create database if not exists ordersmanagement;
use ordersmanagement;

create table NhaCC(
	id int primary key auto_increment unique,
    name varchar(50),
    location varchar(50)
);

create table PhoneNumber(
	id int primary key auto_increment,
    id_nhacc int,
    phone_number varchar(20),
    foreign key(id_nhacc) references NhaCC(id)
);

create table DonDH(
	id int primary key auto_increment unique,
    ngay_DH date,
    id_nha_cc int,
    foreign key(id_nha_cc) references NhaCC(id)
);

create table PhieuNhap(
	id int primary key auto_increment unique,
    ngay_nhap date
);

create table VatTu(
	id int primary key auto_increment unique,
    name varchar(50)
);

create table DonNhap(
    id_vat_tu int,
    id_phieu_nhap int,
    don_gia float,
    so_luong int,
    constraint id primary key(id_vat_tu,id_phieu_nhap),
    foreign key(id_vat_tu) references VatTu(id),
    foreign key(id_phieu_nhap) references PhieuNhap(id)
);

create table PhieuXuat(
	id int primary key auto_increment unique,
    ngay_xuat date
);

create table DonXuat(
	id_vat_tu int,
    id_phieu_xuat int,
    don_gia float,
    so_luong int,
    constraint id primary key(id_vat_tu,id_phieu_xuat),
    foreign key(id_vat_tu) references VatTu(id),
    foreign key(id_phieu_xuat) references PhieuXuat(id)
);

create table ChiTietDonDH(
	id_don_hang int,
    id_vat_tu int,
    constraint id primary key(id_don_hang,id_vat_tu),
    foreign key(id_don_hang) references DonDH(id),
    foreign key(id_vat_tu) references VatTu(id)
);