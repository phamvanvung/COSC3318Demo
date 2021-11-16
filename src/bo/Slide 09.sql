# Drop existing db
DROP DATABASE IF EXISTS StudentDB;
# Create and use
CREATE DATABASE StudentDB;
USE StudentDB;
# Create Staff
create table Staff(
stfId int primary key auto_increment,
stfName varchar(100),
stfUsername varchar(100),
stfPassword varchar(100),
stfRole int default 1
);
insert into Staff(stfName, stfUsername, stfPassword) values('Mr. A', 'aaccount', 'apass');
select * from Staff;

create table Cohort(
chId int primary key auto_increment,
chName varchar(100)
);
insert into Cohort(chName) values('Fall 2021'), ('Spring 2022'), ('Summer 2022');
select * from Cohort;

create table Student(
sId int primary key auto_increment,
sName varchar(100),
sAddress varchar(500),
chId int,
stfId int,
foreign key (chId) references Cohort(chId),
foreign key (stfId) references Staff(stfId)
);

select * from Student;