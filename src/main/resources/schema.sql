DROP TABLE IF EXISTS `boilerplate`.`user`;

CREATE TABLE `boilerplate`.`user` (
                        id	bigint	NOT NULL,
                        email	varchar(100)	NOT NULL,
                        password	varchar(100)	NOT NULL,
                        name	varchar(30)	NOT NULL,
                        phone	varchar(30)	NOT NULL,
                        address	varchar(100)	NULL,
                        created_at	datetime	NOT NULL,
                        updated_at	datetime	NOT NULL
);