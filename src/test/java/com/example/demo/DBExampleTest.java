package com.example.demo;

import com.example.demo.database_example.mapper.UserMapper;
import com.example.demo.database_example.service.DBService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DBExampleTest {

    @Autowired
    public UserMapper userMapper;

    /**
     * 每次测试前，先清空数据库表
     */
    @BeforeEach
    public void setUp() {
        userMapper.delete(null);
    }

    @Autowired
    public DBService dbService;

    @Test
    void test() {
        dbService.outterMethod();
    }

    /**
     * 对异常进行了 try catch 的测试
     */
    @Test
    void testForTryCatch() {
        dbService.outterMethodForTryCatch();
    }

}
