CREATE TABLE fullstackhandyman.cookie_maps
(
    map_num INT NOT NULL auto_increment UNIQUE,
    container_num INT NOT NULL,
    name VARCHAR(150) NOT NULL UNIQUE,
    primary key (map_num),
    foreign key (container_num) REFERENCES cookie_maps_container(container_num)
);