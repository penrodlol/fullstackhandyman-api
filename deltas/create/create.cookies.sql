CREATE TABLE fullstackhandyman.cookies
(
    cookie_num INT NOT NULL auto_increment UNIQUE,
    map_num INT NOT NULL,
    name VARCHAR(150) NOT NULL,
    value VARCHAR(150) NOT NULL,
    primary key (cookie_num),
    foreign key (map_num) REFERENCES cookie_maps(map_num)
);