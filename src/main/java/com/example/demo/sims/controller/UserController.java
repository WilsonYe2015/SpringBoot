package com.example.demo.sims.controller;


import com.example.demo.sims.common.exception.BizException;
import com.example.demo.sims.entity.User;
import com.example.demo.sims.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Wilson
 * @since 2020-08-07
 */
@RestController
@RequestMapping("/sims/user")
public class UserController {


   @Autowired
   @Qualifier("userServiceImpl")
   public IUserService userService;

    @GetMapping("/findall")
   public List<User> FindAll()
   {
       List<User> userList = userService.FindAll();
       userList.forEach(System.out::println);
       return userList;

   }

   @GetMapping("/finduser")
   public User FindUser(int id)
   {
      User user = userService.FindUser(id);
      System.out.println(user);
      System.out.println("name:"+user.getName());
       return  user;
   }


   @GetMapping("/finduserbyname")
   public List<User> FindUserByName(String name)
   {
       List<User> userList = userService.FindUserByName(name);
       userList.forEach(System.out::println);
       return userList;
   }

    @GetMapping("/finduserbynamexml")
    public List<User> FindUserByNameXml(String name)
    {
        List<User> userList = userService.FindUserByNameXml(name);
        userList.forEach(System.out::println);
        return userList;
    }

    @GetMapping("/finduserbynamewapper")
    public List<User> FindUserByNameWapper(String name)
    {
        List<User> userList = userService.FindUserByNameWapper(name);
        userList.forEach(System.out::println);
        return userList;
    }

    @PostMapping("/add")
    public boolean Add(@RequestBody User user)
    {
        if(user.getName()==null || user.getName().isEmpty()){
            throw  new BizException("-1","用户姓名不能为空！");
        }
        return userService.Add(user)>0;
    }

    @PostMapping("/edit")
    public boolean Edit(@RequestBody User user)
    {
        if(user.getName()==null|| user.getName().isEmpty()){
            throw  new BizException("-1","用户姓名不能为空！");
        }
        if(user.getId()==null|| user.getId()<=0){
            throw  new BizException("-1","用户ID不能为空！");
        }
        return userService.Edit(user)>0;
    }

    @GetMapping("/remove")
    public boolean Remove(int id)
    {
        return  userService.removeById(id);
    }


}
