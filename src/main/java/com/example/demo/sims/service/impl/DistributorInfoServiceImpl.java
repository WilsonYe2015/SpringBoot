package com.example.demo.sims.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.sims.entity.DistributorInfo;
import com.example.demo.sims.mapper.DistributorInfoMapper;
import com.example.demo.sims.service.IDistributorInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wilson
 * @since 2020-08-08
 */
@Service
public class DistributorInfoServiceImpl extends ServiceImpl<DistributorInfoMapper, DistributorInfo> implements IDistributorInfoService {

    @Autowired
    private DistributorInfoMapper distributorInfoMapper;

    @Override
    public List<Map<String,Object>> FindAllDistributorWithUser()
    {
        return distributorInfoMapper.FindAllDistributorWithUser();
    }

    @Override
    public DistributorInfo Find(int id) {
        return distributorInfoMapper.selectById(id);
    }

    @Override
    public int Add(DistributorInfo distributorInfo) {
        return distributorInfoMapper.insert(distributorInfo);
    }

    @Override
    public int Edit(DistributorInfo distributorInfo) {
        return distributorInfoMapper.updateById(distributorInfo);
    }

    @Override
    public List<Map<String,Object>> FindAllDistributorWithUserXml()
    {
        return distributorInfoMapper.FindAllDistributorWithUserXml();
    }

    @Override
    public int Remove(int id) {
        return distributorInfoMapper.deleteById(id);
    }
}