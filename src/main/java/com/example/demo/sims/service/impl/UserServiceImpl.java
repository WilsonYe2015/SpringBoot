package com.example.demo.sims.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.example.demo.sims.entity.User;
import com.example.demo.sims.mapper.UserMapper;
import com.example.demo.sims.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wilson
 * @since 2020-08-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> FindAll() {
        return userMapper.selectList(null);
    }

    @Override
    public List<User> FindUserByName(String name) {
        return userMapper.FindUserByName(name);
    }

    @Override
    public List<User> FindUserByNameXml(String name) {
        return userMapper.FindUserByNameXml(name);
    }

    @Override
    public List<User> FindUserByNameWapper(String name) {
        /*
        Map<String,Object> Where = new HashMap<>();
        Where.put("name",name);
        return userMapper.selectByMap(Where);
         */
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("name",name);
        return userMapper.selectList(queryWrapper);

    }

    @Override
    public int Remove(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int Add(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int Edit(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public User FindUser(int id) {
        return userMapper.selectById(id);
    }
}
