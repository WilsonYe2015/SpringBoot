package com.example.demo.sims.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.sims.common.exception.BizException;
import com.example.demo.sims.common.model.ResultBody;
import com.example.demo.sims.entity.DistributorInfo;
import com.example.demo.sims.service.IDistributorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Wilson
 * @since 2020-08-08
 */
@RestController
@RequestMapping("/sims/distributor-info")
public class DistributorInfoController {

    @Autowired
    @Qualifier("distributorInfoServiceImpl")
    private IDistributorInfoService distributorInfoService;

    @GetMapping("/findallwithuser")
    public ResultBody FindAllDistributorWithUser()
    {
        List<Map<String,Object>> mapList = distributorInfoService.FindAllDistributorWithUser();
        mapList.forEach(System.out::println);
        return ResultBody.success(mapList);
    }

    @GetMapping("/findallwithuserxml")
    public ResultBody FindAllDistributorWithUserXml()
    {
        List<Map<String,Object>> mapList = distributorInfoService.FindAllDistributorWithUserXml();
        mapList.forEach(System.out::println);
        return ResultBody.success(mapList);
    }

    @GetMapping("/selectbypage")
    public ResultBody SelectByPage(String keyWord,int iCurrentPage,int iPageSize)
    {
        List<Map<String,Object>> mapList = distributorInfoService.SelectMyCustomPage(keyWord,iCurrentPage,iPageSize);
        mapList.forEach(System.out::println);
        return ResultBody.success(mapList);
    }

    @GetMapping("/count")
    public ResultBody Count(String keyWord)
    {
       int total= distributorInfoService.Count(keyWord);
       return ResultBody.success(total);
    }

    @PostMapping("/add")
    public ResultBody Add(@RequestBody DistributorInfo distributorInfo)
    {
        if(distributorInfo.getDistName()==null || distributorInfo.getDistName().isEmpty()){
            throw  new BizException("-1","经销商姓名不能为空！");
        }
        if (distributorInfoService.Add(distributorInfo)>0)
        {
            return ResultBody.success();
        }
        else{
            return ResultBody.error("新增失败！");
        }
    }

    @PostMapping("/edit")
    public ResultBody Edit(@RequestBody DistributorInfo distributorInfo)
    {
        if(distributorInfo.getDistName()==null || distributorInfo.getDistName().isEmpty()){
            throw  new BizException("-1","经销商姓名不能为空！");
        }
        if(distributorInfo.getId()==null ||distributorInfo.getId()<=0){
            throw  new BizException("-1","经销商ID不能为空！");
        }
        if (distributorInfoService.Edit(distributorInfo)>0)
        {
            return ResultBody.success();
        }
        else{
            return ResultBody.error("新增失败！");
        }
    }

    @GetMapping("/find")
    public ResultBody Find(int id)
    {
        return ResultBody.success(distributorInfoService.Find(id));
    }

    @GetMapping("/remove")
    public ResultBody Remove(int id)
    {
        if(distributorInfoService.removeById(id))
        {
            return ResultBody.success();
        }
        else
        {
            return ResultBody.error("删除失败！");
        }
    }

}
