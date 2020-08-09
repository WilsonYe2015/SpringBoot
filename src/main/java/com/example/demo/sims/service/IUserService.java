package com.example.demo.sims.service;

import com.example.demo.sims.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wilson
 * @since 2020-08-07
 */
public interface IUserService extends IService<User> {

    public List<User> FindAll();

    public  User FindUser(int id);

    public List<User> FindUserByName(String name);

    public List<User> FindUserByNameXml(String name);

    public List<User> FindUserByNameWapper(String name);

    public int Add(User user);

    public int Edit(User user);

    public int Remove(int id);

}
