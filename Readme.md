## 用途
本项目用于测试 Spring 的事务传播属性在嵌套事务的情况下，子事务使用 NESTED 和 REQUIRES_NEW 两种事务传播属性，两者会有哪些差异。 

代码可直接pull到本地进行运行。入口在 test 包下面的 DBExampleTest 测试类中。

本项目中，使用到了一张user表，sql语句在 sql.sql 文件中。运行项目前需要把表在本地数据库中建好。

## 涉及技术版本
- Spring Boot 3
- Mybatis 3
- Mybatis Plus 3
- Mysql 8
