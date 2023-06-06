

-- create database project_team_java5;			
-- use project_team_java5;
-- drop database project_team_java5;
create table users
(
	username varchar(50) primary key,
	password varchar(50) not null,
	fullname nvarchar(100) not null,
	adress nvarchar(300) not null,
	phone_number varchar(10) not null,
	email varchar(50) not null,
	photo nvarchar(1000) not null,
	createDate date not null,
	isAdmin bit not null,
	isActive bit not null
)
--drop table users;
create table product_category
(
	category_id int identity(1,1) primary key,
	name nvarchar(1000) not null,
	image nvarchar(1000) not null

)
--drop table category;
create table product_discount
(
	id int identity(1,1) primary key,
	discount_percent decimal not null,
	imageUrl varchar(max) null,
	isActive bit not null,
)
--drop table product_discount;
create table product
(
	id varchar(50) primary key,
	names nvarchar(50) not null,
	price float not null,
	images nvarchar(1000) not null,
	category_id int not null,
	descriptions nvarchar(max) not null,
	create_by varchar(50) not null,
	discount_id int null,
	isActive bit not null,
	create_date date not null
		foreign key				(create_by)						references users(username),
	foreign key				(category_id)					references product_category(category_id),
	foreign key				(discount_id)					references product_discount(id)
)
--drop table product;
create table product_access
(
	review_id int identity(1,1) primary key,
	product_id varchar(50) not null,
	username varchar(50) not null,
	date_create date not null,
	content nvarchar(max) not null,
	start_rate int not null,
	foreign key				(product_id)					references product(id),
	foreign key				(username)						references users(username)
)




-- drop table access;
create table shopping_cart
(
	id int identity(1,1) primary key,
	username varchar(50) not null,
	createDate date not null
		foreign key				(username)						references users(username)
)
-- drop table shopping_cart;
create table cart_item
(
	id int identity(1,1) primary key,
	product_id varchar(50) not null,
	quantity int not null,
	shopping_cart_id int not null,
	foreign key				(product_id)					references product(id),
	foreign key				(shopping_cart_id)				references shopping_cart(id)

)

-- drop table cart_item;
create table orders
(
	id int identity(1,1) primary key,
	username varchar(50) not null,
	total float not null,
	[status] nvarchar(50) not null,
	create_at date not null,
	foreign key				(username)							references users(username)
)
-- drop table Orders;
create table orders_items
(
	id int identity(1,1) primary key,
	order_id int not null,
	product_id varchar(50) not null,
	price float not null,
	foreign key				(order_id)							references orders(id),
	foreign key				(product_id)						references product(id)
)


insert into product_category
values
	(N'Đồng Hồ', 'cat-1.jpg'),
	(N'Quần Áo', 'cat-1.jpg'),
	(N'Giày Dép', 'cat-1.jpg')

insert into product_discount
values
	(20, '/img/carousel-1.jpg', 1),
	(30, '/img/carousel-2.jpg', 1),
	(40, '/img/carousel-3.jpg', 1),
	(50, '/img/cat-1.jpg', 1),
	(60, '/img/cat-2.jpg', 1),
	(70, '/img/cat-3.jpg', 1)

insert into users
values
	('hoangthanhtung', '123', N'Hoàng Thanh Tùng', N'Long An', '0378785270', 'tunghtps22191@fpt.edu.vn', 'quocviet.img', '2023-01-01', 0 , 1),
	('ngohoangquocviet', '123', N'Ngô Hoàng Quốc Việt', N'Long An', '0123456789', 'vietnhqps@fpt.edu.vn', 'quocviet.img', '2023-01-01', 0 , 1),
	('danghoangcanh', '123', N'Đặng Hoàng Cảnh', N'Nha Trang', '0987654321', 'canhhdps@fpt.edu.vn', 'hoangcanh.img', '2023-01-01', 0 , 1),
	('taquocphong', '123', N'Tạ Quốc Phong', N'Lâm Đồng', '0987654321', 'phongqt@fpt.edu.vn', 'quocphong.img', '2023-01-01', 0 , 1),
	('botantruong', '123', N'Bồ Tấn Trương', N'Hoà Bình', '0702835096', 'botantruong889@naver.com', 'BoTanTruong.jpg', '2023-01-01', 0 , 1),
	('PhiThanhBinh', '123', N'Phí Thanh Bình', N'Bình Dương', '0895672819', 'phithanhbinh514@facebook.com', 'PhiThanhBinh.jpg', '2023-01-01', 0 , 1),
	('DiepNhaY', '123', N'Diệp Nhã Ý', N'Tuyên Quang', '0894386915', 'phithanhbinh514@facebook.com', 'DiepNhaY.jpg', '2023-01-01', 0 , 1),
	('ChuDuyMinh', '123', N'Chu Duy Minh', N'Nghệ An', '0938402631', '	chuduyminh218@icloud.com', 'ChuDuyMinh.jpg', '2023-01-01', 0 , 1),
	('LeuThienTrang', '123', N'Lều Thiên Trang', N'Bình Dương', '0333908624', 'leuthientrang605@yahoo.com', 'LeuThienTrang.jpg', '2023-01-01', 0 , 1),
	('SaiDucLong', '123', N'Sái Ðức Long', N'Bình Dương', '0368497520', 'saiuclong466@google.com', 'SaiDucLong.jpg', '2023-01-01', 0 , 1),
	('CapMinhHue', '123', N'Cáp Minh Huệ', N'Bình Dương', '0895672819', 'capminhhue566@icloud.com', 'CapMinhHue.jpg', '2023-01-01', 0 , 1),
	('ThachThuLinh', '123', N'Phí Thanh Bình', N'Đà Nẵng', '0895672819', 'ThachThuLinh@facebook.com', 'PhiThanhBinh.jpg', '2023-01-01', 0 , 1)

insert into product
values
	('01', N'Đồng Hồ Omega', 100.0, 'carousel-1.jpg', 1, N'Đẹp', 'botantruong', 3, 1, '2023-01-01'),
	('02', N'Đồng Hồ Orient 41.7mm Nam RA-AA0B02R19B', 100.0, 'carousel-1.jpg', 1, N'Đẹp', 'CapMinhHue', 4, 1, '2023-01-01'),
	('03', N'QUẦN SHORT KẺ SỌC', 100.0, 'carousel-1.jpg', 2, N'Đẹp', 'ChuDuyMinh', 3, 1, '2023-01-01'),
	('04', N'QUẦN JOGGER DỆT KIM', 100.0, 'carousel-1.jpg', 2, N'Đẹp', 'danghoangcanh', 5, 1, '2023-01-01'),
	('05', N'QUẦN LEN ỐNG SUÔNG', 100.0, 'carousel-1.jpg', 2, N'Đẹp', 'DiepNhaY', 4, 1, '2023-01-01'),
	('06', N'GIÀY THỂ THAO DA', 100.0, 'carousel-1.jpg', 3, N'Đẹp', 'hoangthanhtung', 1, 1, '2023-01-01'),
	('07', N'GIÀY SNEAKER', 100.0, 'carousel-1.jpg', 3, N'Đẹp', 'LeuThienTrang', 4, 1, '2023-01-01'),
	('08', N'GIÀY SNEAKER DA SQUARE CROSS', 100.0, 'carousel-1.jpg', 3, N'Đẹp', 'ngohoangquocviet', 3, 1, '2023-01-01'),
	('09', N'ÁO SƠ MI DÁNG RỘNG', 100.0, 'carousel-1.jpg', 2, N'Đẹp', 'PhiThanhBinh', 4, 1, '2023-01-01'),
	('10', N'ÁO SƠ MI IN OVERSIZE', 100.0, 'carousel-1.jpg', 2, N'Đẹp', 'SaiDucLong', 5, 1, '2023-01-01'),
	('11', N'ÁO SƠ MI SỌC', 100.0, 'carousel-2.jpg', 2, N'Đẹp', 'PhiThanhBinh', 4, 1, '2023-01-01'),
	('12', N'ÁO SƠ MI HÌNH TƯỢNG', 100.0, 'carousel-3.jpg', 2, N'Đẹp', 'ngohoangquocviet', 3, 1, '2023-01-01'),
	('13', N'ÁO SƠ MI COTTON', 100.0, 'carousel-1.jpg', 2, N'Đẹp', 'LeuThienTrang', 4, 1, '2023-01-01'),
	('14', N'GIÀY CHẠY BẰNG DA', 100.0, 'carousel-2.jpg', 3, N'Đẹp', 'PhiThanhBinh', 4, 1, '2023-01-01'),
	('15', N'GIÀY SNEAKER DA SQUARE CROSS', 100.0, 'carousel-3.jpg', 3, N'Đẹp', 'PhiThanhBinh', 6, 1, '2023-01-01'),
	('16', N'GIÀY TRAINER DA', 100.0, 'carousel-2.jpg', 3, N'Đẹp', 'PhiThanhBinh', 4, 1, '2023-01-01'),
	('17', N'ĐỒNG HỒ CASIO WORLD TIME', 100.0, 'carousel-1.jpg', 1, N'Đẹp', 'CapMinhHue', 5, 1, '2023-01-01'),
	('18', N'ĐỒNG HỒ CITIZEN TSUYOSA', 100.0, 'carousel-2.jpg', 1, N'Đẹp', 'PhiThanhBinh', 4, 1, '2023-01-01'),
	('19', N'ĐỒNG HỒ ORIENT OPEN HEART', 100.0, 'carousel-3.jpg', 1, N'Đẹp', 'PhiThanhBinh', 4, 1, '2023-01-01')
,
	('20', N'GIÀY THỂ THAO DA', 100.0, 'carousel-2.jpg', 3, N'Đẹp', 'ngohoangquocviet', 4, 1, '2023-01-01')


insert into product_access
values
	('01', 'hoangthanhtung', getdate(), N'Sản Phẩm Đẹp, chất lượng như hình', 5),
	('02', 'PhiThanhBinh', getdate(), N'Sản Phẩm Đẹp, chất lượng như hình', 5),
	('03', 'danghoangcanh', getdate(), N'Sản Phẩm Đẹp, chất lượng như hình', 5),
	('04', 'ChuDuyMinh', getdate(), N'Sản Phẩm Đẹp, chất lượng như hình', 5),
	('05', 'hoangthanhtung', getdate(), N'Sản Phẩm Đẹp, chất lượng như hình', 5),
	('06', 'botantruong', getdate(), N'Sản Phẩm Đẹp, chất lượng như hình', 5),
	('07', 'hoangthanhtung', getdate(), N'Sản Phẩm Đẹp, chất lượng như hình', 5),
	('08', 'SaiDucLong', getdate(), N'Sản Phẩm Đẹp, chất lượng như hình', 5),
	('09', 'CapMinhHue', getdate(), N'Sản Phẩm Đẹp, chất lượng như hình', 5),
	('10', 'CapMinhHue', getdate(), N'Sản Phẩm Đẹp, chất lượng như hình', 5)

insert into orders
values
	('ngohoangquocviet', 100.0, 'Đã thanh toán', getdate()),
	('botantruong', 100.0, 'Đã thanh toán', getdate()),
	('danghoangcanh', 100.0, 'Đã thanh toán', getdate()),
	('ngohoangquocviet', 100.0, 'Đã thanh toán', getdate()),
	('taquocphong', 100.0, 'Đã thanh toán', getdate()),
	('botantruong', 100.0, 'Đã thanh toán', getdate()),
	('danghoangcanh', 100.0, 'Đã thanh toán', getdate()),
	('taquocphong', 100.0, 'Đã thanh toán', getdate()),
	('ngohoangquocviet', 100.0, 'Đã thanh toán', getdate()),
	('ngohoangquocviet', 100.0, 'Đã thanh toán', getdate()),
	('ThachThuLinh', 100.0, 'Đã thanh toán', getdate()),
	('ngohoangquocviet', 100.0, 'Đã thanh toán', getdate())

insert into orders_items
values
	('01', '01', 100.0),
	('02', '02', 100.0),
	('03', '03', 100.0),
	('04', '04', 100.0),
	('05', '05', 100.0),
	('06', '06', 100.0),
	('07', '07', 100.0),
	('08', '08', 100.0),
	('09', '09', 100.0),
	('10', '10', 100.0),
	('11', '12', 100.0),
	('11', '12', 100.0)


INSERT into shopping_cart
VALUES
	('ngohoangquocviet', getdate()),
	('botantruong', getdate()),
	('taquocphong', getdate()),
	('ngohoangquocviet', getdate()),
	('ngohoangquocviet', getdate()),
	('LeuThienTrang',getdate()),
	('danghoangcanh', getdate()),
	('hoangthanhtung',getdate()),
	('ngohoangquocviet',getdate()),
	('danghoangcanh',getdate()),
	('ngohoangquocviet',getdate()),
	('DiepNhaY',getdate()),
	('PhiThanhBinh',getdate()),
	('danghoangcanh',getdate()),
	('CapMinhHue',getdate())
	
	
INSERT into cart_item
VALUES
	('06', 20, 1),
	('20', 20, 2),
	('01', 20, 2),
	('11', 20, 2),
	('12', 20, 2),
	('13', 20, 2),
	('20', 20, 3),
	('01', 20, 3),
	('02', 20, 4),
	('09', 20, 4),
	('11', 20, 5),
	('15', 20, 5),
	('16', 20, 5),
	('18', 20, 6),
	('01', 20, 7),
	('04', 20, 8),
	('20', 20, 8),
	('01', 20, 9),
	('11', 20, 9),
	('13', 20, 10),
	('12', 20, 10),
	('16', 20, 10),
	('01', 20, 11),
	('08', 20, 11),
	('09', 20, 11),
	('01', 20, 12),
	('11', 20, 12),
	('20', 20, 12),
	('13', 20, 12),
	('01', 20, 13),
	('14', 20, 13),
	('01', 20, 14),
	('01', 20, 15),
	('20', 20, 15)


