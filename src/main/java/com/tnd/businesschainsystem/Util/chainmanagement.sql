Drop database if exists BUSINESSCHAINSYSTEM;
CREATE SCHEMA BUSINESSCHAINSYSTEM;

USE BUSINESSCHAINSYSTEM;

create table branch(
	id int not null auto_increment primary key,
    name varchar(64),
    address varchar(64),
    manager int,
    status int, /* 0,1 */
    openDay date
);

create table rule(
	id int not null auto_increment primary key,
    name varchar(64),
    value varchar(16),
    type int, /* 0: danh muc hoa don, 1: khuyen mai, 2 : hop dong */
    branch int
);

create table employee(
	id int not null auto_increment primary key,
    employeeID varchar(64),
    name varchar(64),
    cardID varchar(16),
    birthDay date,
    gender int, /* 0: nữ, 1: nam */
    address varchar(100),
    phoneNumber varchar(16),
    email varchar(64),
    branch int,
    status int,
    createdDate datetime,
    createdBy int,
    updatedDate datetime,
    updatedBy int
);

create table role(
	id int not null auto_increment primary key,
    role varchar(64)
);

create table employee_role(
	id int not null auto_increment primary key,
    employee int,
    role int
);

create table account(
	id int not null auto_increment primary key,
    username varchar(100),
    password varchar(100),
    employee int,
    status int
);

create table timework(
	id int not null auto_increment primary key,
    date date,
    employee int,
    status int     /* 0: false, 1: true */
);

create table equipment(
	id int not null auto_increment primary key,
    equipmentID varchar(100),
    name varchar(100),
    status int,
    branch int
);

create table material(
	id int not null auto_increment primary key,
    materialID varchar(100),
    name varchar(100),
    count int
);

create table material_branch(
	id int not null auto_increment primary key,
    material int,
    branch int,
    count int
);

create table import(
	id int not null auto_increment primary key,
    resourceID varchar(100),
    count int,
    price long,
    totalMoney long,
    createdDate datetime,
    createdBy int
);

create table shipway(
	id int not null auto_increment primary key,
    fromBranch int,
    toBranch int,
    resourceID varchar(100),
    count int
);

create table bill(
	id int not null auto_increment primary key,
    itemMenu int,
    name varchar(100),
    count int,
    price long,
    total long,
    createdDate datetime,
    createdBy int
);

create table class(
	id int not null auto_increment primary key,
    classID varchar(64),
    teacher int,
    status int,
    branch int,
    fromDate date,
    toDate date,
    createdDate datetime,
    createdBy int,
    updatedDate datetime,
    updatedBy int
);

create table shift(
	id int not null auto_increment primary key,
    date varchar(20),
    time varchar(20)
);

create table schedule(
	id int not null auto_increment primary key,
    class int,
    shift int
);

create table student(
	id int not null auto_increment primary key,
    studentID varchar(64),
    name varchar(64),
    cardID varchar(16),
    birthDay date,
    gender int, /* 0: nữ, 1: nam */
    address varchar(100),
    phoneNumber varchar(16),
    email varchar(64),
    branch int,
    status int,
    createdDate datetime,
    createdBy int,
    updatedDate datetime,
    updatedBy int
);

create table student_class(
	id int not null auto_increment primary key,
    student int,
    class int,
    statscheduleus int,
    statusTuition int
);

create table tuition(
	id int not null auto_increment primary key,
    studentClass int,
    totalMoney long,
    createdDate datetime,
    createdBy int
);

create table spend(
	id int not null auto_increment primary key,
    content longtext,
    totalMoney long,
    createdDate datetime,
    createBy int
);
