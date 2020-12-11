DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS STOCKS;
DROP TABLE IF EXISTS STORE;

CREATE TABLE PRODUCT(
	pid int,
    pname varchar(50),
    pprice numeric(6,2),
    pbrand varchar(50),
    primary key(pid)
);

CREATE TABLE STOCKS(
	sid int AUTO_INCREMENT ,
    pid int,
    squantity int,
    primary key(sid),
    foreign key(pid) references PRODUCT(pid)
);

CREATE TABLE STORE(
	pid int,
    sid int,
	foreign key(pid) references PRODUCT(pid),
	foreign key(sid) references STOCKS(sid)
);

