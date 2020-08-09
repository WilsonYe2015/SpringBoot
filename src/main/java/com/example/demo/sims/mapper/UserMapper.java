package com.example.demo.sims.mapper;

import com.example.demo.sims.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Wilson
 * @since 2020-08-07
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where name=#{name}")
    public List<User> FindUserByName(String name);


    public List<User> FindUserByNameXml(String name);




}
