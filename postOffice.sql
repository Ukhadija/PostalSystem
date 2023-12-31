use postoffice;


create table User_(
	UserID int not null auto_increment primary key,
    FullName Varchar(255) not null,
    Address Varchar (255),
    Phone VArchar (15),
    Email varchar (255),
    CNIC varchar (20),
    Username varchar  (50) unique ,
    Pass varchar (20) not null
);

Insert into User_(FullName, Address, Phone, Email,CNIC, Username, Pass) 
VALUES ('khadija', 'h#23', '033445566564', 'u.khada@gmail.com', '3453242342342', 'kh@123', 'Khadija1') ;
 
create table Bank(
	BankID int not null auto_increment primary key,
	BankName varchar (225) not null unique
);



create table BankAccount(
	BankAccountNo Varchar(225) primary key,
    balance double,
    branch varchar(225),
    BankName varchar(225) not null ,
    foreign key (BankName) references Bank(BankName)
);

create table ParcelDescription(
	TrackingID varchar(225) primary key,
    TrackingInfo varchar(500),
    priority int,
    weight double,
    mailingAddress varchar(225),
    destinationAddress varchar(255),
    receiverName varchar(100),
    contact varchar(13),
    price double
);

create table parcel(
	parcelID varchar(225) primary key,
    ParcelDescription varchar(225),
    Foreign key (parcelDescription) references ParcelDescription(trackingID)
);

create table Item(
	ItemNo varchar(225) not null primary key,
    ItemName varchar(225),
    ItemDesc varchar(225),
    Quantity int,
    price double
);

INSERT INTO Item (ItemNo, ItemName, ItemDesc, Quantity, price)
VALUES ('I712', 'envelopes', 'white', 5000, 20),
  ('I001', 'pens', 'blue', 20000, 10),
   ('I02', 'JanuaryStamps', 'bluw', 5000, 40),
    ('I003', 'Stamps', 'red flower', 5000, 40),
     ('I004', 'letteropener', 'white', 300, 100),
  ('I005', 'paper', 'white', 1000, 5);

create table cart(
	cartID int not null auto_increment primary key,
	CartUser int,
    ItemID varchar (225),
    Foreign key (ItemID) references Item(ItemNo),
    foreign key (cartUSer) references USer_(UserID)    
);

create table vendors(
	VendorID int not null auto_increment primary key,
    VendorName varchar(225)
);

CREATE TABLE VendorItem (
    VendorID INT,
    ItemID varchar(225),
    PRIMARY KEY (VendorID, ItemID),
    FOREIGN KEY (VendorID) REFERENCES Vendors(VendorID),
    FOREIGN KEY (ItemID) REFERENCES Item(ItemNo)
);


create table Inventory(
	InventoryID int primary key,
    capacity int
);

CREATE TABLE Inventory_Item (
    InventoryID INT,
    ItemID Varchar(225),
    PRIMARY KEY (InventoryID, ItemID),
    FOREIGN KEY (InventoryID) REFERENCES Inventory(InventoryID),
    FOREIGN KEY (ItemID) REFERENCES Item(ItemNo)
);

CREATE TABLE Cart_Item (
    CartID INT,
    ItemID varchar(225),
    PRIMARY KEY (CartID, ItemID),
    FOREIGN KEY (CartID) REFERENCES Cart(CartID),
    FOREIGN KEY (ItemID) REFERENCES Item(ItemNo)
);



create table logs_(
	LogID int not null auto_increment primary key,
	LogType char,
    Date_ dateTime,
    Status_ varchar (225)
);


 
create table BankAccLog(
	BankAccNo varchar(225),
    LogID INT,
    PRIMARY KEY (BankAccNo, LogID),
    FOREIGN KEY (BankAccNo) REFERENCES BankAccount(BankAccountNo),
    FOREIGN KEY (LogID) REFERENCES Logs_(LogID)
);




create table Customer(
	customerID int primary key auto_increment,
    Username varchar(50) ,
    BankAccID varchar(30),
    InventoryID int,
    foreign key (Username) references User_(Username),
    foreign key (BankAccID) references BankAccount(BankAccountNo),
    foreign key (InventoryID) references Inventory(InventoryID)
);


create table Admin_(
	AdminID varchar (30) primary key,
    Username varchar(225),
    foreign key (Username) references User_(Username)
);



CREATE TABLE AdminLogs (
    AdminID varchar(30),
    LogID INT,
    PRIMARY KEY (AdminID, LogID),
    FOREIGN KEY (LogID) REFERENCES Logs_(LogID),
    FOREIGN KEY (AdminID) references Admin_(AdminID)
);



create table PostOfficeEmployee(
	EmployeeID varchar(225) primary key,
    Username varchar(225),
    InventoryID int,
    foreign key (Username) references User_(Username),
    foreign key (InventoryID) references Inventory(InventoryID)
);


CREATE TABLE Employee_Parcel(
    EmployeeID varchar(255),
    ParcelID varchar(255),
    PRIMARY KEY (EmployeeID, ParcelID),
    FOREIGN KEY (EmployeeID) REFERENCES PostOfficeEmployee(EmployeeID),
    FOREIGN KEY (ParcelID) REFERENCES Parcel(ParcelID)
);


create table customerService(
	CustomerService varchar(225) primary key,
    Username varchar(225),
    foreign key (Username) references User_(Username)
);


create table Postman(
	PostmanID varchar(225) primary key,
    Username varchar(225),
    foreign key (Username) references User_(Username)
);

















