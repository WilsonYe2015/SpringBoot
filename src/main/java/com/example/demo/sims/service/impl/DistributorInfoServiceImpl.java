package com.example.demo.sims.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public int Count(String keyword) {
        QueryWrapper<DistributorInfo> wapper = new QueryWrapper<DistributorInfo>();
        if (!(keyword==null || keyword.isEmpty()))
        {
            wapper.like("dist_name",keyword);
        }
        return distributorInfoMapper.selectCount(wapper);
    }

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
    public List<Map<String, Object>> SelectMyCustomPage(String keyWord,int iCurrentPage, int iPageSize) {
        QueryWrapper<Map<String,Object>> wapper = new QueryWrapper<Map<String,Object>>();
        if (!(keyWord==null || keyWord.isEmpty()))
        {
            wapper.like("dist_name",keyWord);
        }
        IPage<Map<String,Object>> distributorInfoPage = new Page<>(iCurrentPage, iPageSize);//参数一是当前页，参数二是每页个数
        distributorInfoPage = distributorInfoMapper.SelectMyCustomPage(distributorInfoPage, wapper);
        return distributorInfoPage.getRecords();
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
