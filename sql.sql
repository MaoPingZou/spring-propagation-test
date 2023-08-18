-- `user` definition

CREATE TABLE `user`
(
    `id`       int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `username` varchar(100) DEFAULT NULL COMMENT '用户名',
    `password` varchar(100) DEFAULT NULL COMMENT '密码',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;