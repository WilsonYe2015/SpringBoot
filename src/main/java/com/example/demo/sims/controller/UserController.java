package com.example.demo.sims.controller;


import com.example.demo.sims.common.exception.BizException;
import com.example.demo.sims.common.model.ResultBody;
import com.example.demo.sims.entity.User;
import com.example.demo.sims.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
   public ResultBody FindAll()
   {
       List<User> userList = userService.FindAll();
       userList.forEach(System.out::println);
       return  ResultBody.success(userList);
   }

   @GetMapping("/finduser")
   public ResultBody FindUser(int id)
   {
      User user = userService.FindUser(id);
      System.out.println(user);
      System.out.println("name:"+user.getName());
       return  ResultBody.success(user);
   }


   @GetMapping("/finduserbyname")
   public ResultBody FindUserByName(String name)
   {
       List<User> userList = userService.FindUserByName(name);
       userList.forEach(System.out::println);
       return ResultBody.success(userList);
   }

    @GetMapping("/finduserbynamexml")
    public ResultBody FindUserByNameXml(String name)
    {
        List<User> userList = userService.FindUserByNameXml(name);
        userList.forEach(System.out::println);
        return ResultBody.success(userList);
    }

    @GetMapping("/finduserbynamewapper")
    public ResultBody FindUserByNameWapper(String name)
    {
        List<User> userList = userService.FindUserByNameWapper(name);
        userList.forEach(System.out::println);
        return ResultBody.success(userList);
    }

    @PostMapping("/add")
    public ResultBody Add(@RequestBody User user)
    {
        if(user.getName()==null || user.getName().isEmpty()){
            throw  new BizException("-1","用户姓名不能为空！");
        }
        if(userService.Add(user)>0)
        {
            return ResultBody.success();
        }else{
            return ResultBody.error("新增失败！");
        }
    }

    @PostMapping("/addtran")
    @Transactional()
    public  ResultBody AddTran(@RequestBody User user)
    {
        if(user.getName()==null || user.getName().isEmpty()){
            throw  new BizException("-1","用户姓名不能为空！");
        }
        boolean bsuccess = userService.Add(user)>0;
        if (bsuccess)
        {
            throw  new BizException("-1","测试事务");
        }else
        {
            return ResultBody.error("新增失败！");
        }
    }

    @PostMapping("/edit")
    public ResultBody Edit(@RequestBody User user)
    {
        if(user.getName()==null|| user.getName().isEmpty()){
            throw  new BizException("-1","用户姓名不能为空！");
        }
        if(user.getId()==null|| user.getId()<=0){
            throw  new BizException("-1","用户ID不能为空！");
        }
        if(userService.Edit(user)>0)
        {
            return ResultBody.success();
        }else{
            return ResultBody.error("编辑失败！");
        }
    }

    @GetMapping("/remove")
    public ResultBody Remove(int id)
    {
        if(userService.removeById(id))
        {
            return ResultBody.success();
        }
        else
        {
            return ResultBody.error("删除失败！");
        }
    }


}
