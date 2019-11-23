CREATE TABLE fullstackhandyman.cookies
(
    cookie_num INT NOT NULL AUTO_INCREAMENT UNIQUE,
    map_num INT NOT NULL,
    name [VARCHAR](150) NOT NULL,
    value [VARCHAR](150) NOT NULL,
    PRIMARY_KEY (cookie_num),
    FOREIGN_KEY (map_num) REFERENCES cookie_maps(map_num)
);