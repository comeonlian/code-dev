create table Trips(
	Id tinyint unsigned auto_increment primary key,
	Client_Id tinyint unsigned foreign key references Users(Users_Id),
	Driver_Id tinyint unsigned foreign key references Users(Users_Id),
	City_Id tinyint unsigned,
	Status enum('completed', 'cancelled_by_driver', 'cancelled_by_client'),
	Request_at date
);

create table Users(
	Users_Id tinyint unsigned auto_increment primary key,
	Banned varchar(10),
	Role enum('client', 'driver', 'partner')
);


+----------+--------+--------+
|    1     |   No   | client |
|    2     |   Yes  | client |
|    3     |   No   | client |
|    4     |   No   | client |
|    10    |   No   | driver |
|    11    |   No   | driver |
|    12    |   No   | driver |
|    13    |   No   | driver |
+----------+--------+--------+















