DROP TABLE IF EXISTS `MBR`;

CREATE TABLE `MBR`
(
    MBR_ID       bigint       NOT NULL AUTO_INCREMENT,
    MBR_LOGIN_ID varchar(100) NOT NULL,
    MBR_NM       varchar(30)  NOT NULL,
    MBR_PWD      varchar(100) NOT NULL,
    MBR_HPNO     varchar(30)  NOT NULL,
    MBR_IMG_URL  varchar(300) NOT NULL,
    REG_DTS      datetime     NOT NULL,
    REGPE_ID     bigint NULL,
    MOD_DTS      datetime     NOT NULL,
    MODPE_ID     bigint NULL,
    PRIMARY KEY (MBR_ID)
);