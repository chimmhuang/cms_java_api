CREATE TABLE `users` (
  `uid` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '用户表主键',
  `name` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '用户名',
  `pwd` varchar(32) NOT NULL COMMENT '密码',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;