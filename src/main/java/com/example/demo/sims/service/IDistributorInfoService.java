package com.example.demo.sims.service;

import com.example.demo.sims.entity.DistributorInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.sims.entity.User;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wilson
 * @since 2020-08-08
 */
public interface IDistributorInfoService extends IService<DistributorInfo> {

    public List<Map<String,Object>> FindAllDistributorWithUser();

    public List<Map<String,Object>> FindAllDistributorWithUserXml();

    public List<Map<String,Object>> SelectMyCustomPage(int iCurrentPage,int iPageSize);

    public DistributorInfo Find(int id);

    public int Add(DistributorInfo distributorInfo);

    public int Edit(DistributorInfo distributorInfo);

    public int Remove(int id);
}
