CREATE TABLE `fullstackhandyman`.`cookie_maps_container`
(
    container_num INT NOT NULL auto_increment UNIQUE,
    name VARCHAR(150) NOT NULL UNIQUE,
    primary key (container_num)
);