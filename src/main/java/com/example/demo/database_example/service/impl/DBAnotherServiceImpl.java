package com.example.demo.database_example.service.impl;

import com.example.demo.database_example.entity.User;
import com.example.demo.database_example.mapper.UserMapper;
import com.example.demo.database_example.service.DBAnotherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class DBAnotherServiceImpl implements DBAnotherService {

    @Autowired
    private UserMapper userMapper;

    @Override
    // 使用  REQUIRES_NEW
//    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    // 使用 NESTED
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    public void innerMethod() {

        User user = new User();
        user.setUsername("methodB-username");
        user.setPassword("methodB-password");
        userMapper.insert(user);

        // 模拟抛出运行时异常
//        throw new RuntimeException();
    }
}
