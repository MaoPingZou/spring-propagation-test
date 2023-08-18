package com.example.demo.database_example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.database_example.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
