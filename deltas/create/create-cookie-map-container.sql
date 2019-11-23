CREATE TABLE fullstackhandyman.cookie_maps_container
(
    container_num INT NOT NULL AUTO_INCREAMENT UNIQUE,
    name [VARCHAR](150) NOT NULL UNIQUE,
    PRIMARY_KEY (container_num)
);