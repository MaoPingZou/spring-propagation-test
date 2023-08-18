package com.example.demo.database_example.service.impl;

import com.example.demo.database_example.entity.User;
import com.example.demo.database_example.mapper.UserMapper;
import com.example.demo.database_example.service.DBService;
import com.example.demo.database_example.service.DBAnotherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class DBServiceImpl implements DBService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DBAnotherService dbAnotherService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void outterMethod() {

        // 插入一个用户
        User user = new User();
        user.setUsername("methodA-username");
        user.setPassword("methodA-password");
        userMapper.insert(user);

        // 调用 DBServiceB 的 methodB() 方法
        dbAnotherService.innerMethod();

        // 模拟抛出运行时异常
//        throw new RuntimeException();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void outterMethodForTryCatch() {

        // 插入一个用户
        User user = new User();
        user.setUsername("methodA-username");
        user.setPassword("methodA-password");
        userMapper.insert(user);

        try {
            // 调用 DBServiceB 的 methodB() 方法
            dbAnotherService.innerMethod();
        } catch (Exception e) {
            log.error("将异常吞掉，不向上抛出异常");
        }

        // 模拟抛出运行时异常
//        throw new RuntimeException();
    }
}
