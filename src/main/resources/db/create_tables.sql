create table Sensor(
    id int primary key auto_increment,
    name varchar(100) not null unique
);

create table Measurement(
    id int primary key auto_increment,
    value double precision not null,
    raining bit(1) not null,
    measurement_date_time timestamp not null,
    sensor varchar(100) references Sensor(name)
);