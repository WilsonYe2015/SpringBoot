package com.example.demo.sims.controller;


import com.example.demo.sims.common.exception.BizException;
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
    public List<Map<String,Object>> FindAllDistributorWithUser()
    {
        List<Map<String,Object>> mapList = distributorInfoService.FindAllDistributorWithUser();
        mapList.forEach(System.out::println);
        return mapList;
    }

    @GetMapping("/findallwithuserxml")
    public List<Map<String,Object>> FindAllDistributorWithUserXml()
    {
        List<Map<String,Object>> mapList = distributorInfoService.FindAllDistributorWithUserXml();
        mapList.forEach(System.out::println);
        return mapList;
    }

    @PostMapping("/add")
    public boolean Add(@RequestBody DistributorInfo distributorInfo)
    {
        if(distributorInfo.getDistName()==null || distributorInfo.getDistName().isEmpty()){
            throw  new BizException("-1","经销商姓名不能为空！");
        }
        return distributorInfoService.Add(distributorInfo)>0;
    }

    @PostMapping("/edit")
    public boolean Edit(@RequestBody DistributorInfo distributorInfo)
    {
        if(distributorInfo.getDistName()==null || distributorInfo.getDistName().isEmpty()){
            throw  new BizException("-1","经销商姓名不能为空！");
        }
        if(distributorInfo.getId()==null ||distributorInfo.getId()<=0){
            throw  new BizException("-1","经销商ID不能为空！");
        }
        return distributorInfoService.Edit(distributorInfo)>0;
    }

    @GetMapping("/find")
    public DistributorInfo Find(int id)
    {
        return distributorInfoService.Find(id);
    }

    @GetMapping("/remove")
    public boolean Remove(int id)
    {
        return  distributorInfoService.removeById(id);
    }

}
