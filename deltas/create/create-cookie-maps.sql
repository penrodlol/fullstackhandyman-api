CREATE TABLE fullstackhandyman.cookie_maps
(
    map_num INT NOT NULL AUTO_INCREAMENT UNIQUE,
    container_num INT NOT NULL,
    name [VARCHAR](150) NOT NULL UNIQUE,
    PRIMARY_KEY (map_num),
    FOREIGN_KEY (container_num) REFERENCES cookie_maps_container(container_num)
);