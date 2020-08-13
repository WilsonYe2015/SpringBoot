package com.example.demo.sims.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.sims.entity.DistributorInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Wilson
 * @since 2020-08-08
 */
public interface DistributorInfoMapper extends BaseMapper<DistributorInfo> {

    @Select("Select d.*,u.name input_name from distributor_info d inner join user u on d.input_id = u.id ")
    public List<Map<String,Object>> FindAllDistributorWithUser();

    public List<Map<String,Object>> FindAllDistributorWithUserXml();

    @Select("<script>" +
            "Select d.*,u.name input_name from distributor_info d inner join user u on d.input_id = u.id "+
            "<if test='ew!=null'>"+
            "${ew.customSqlSegment}"+
            "</if>"+
            "</script>"
    )
    public IPage<Map<String,Object>> SelectMyCustomPage(IPage<Map<String,Object>> page, @Param(Constants.WRAPPER) Wrapper<Map<String,Object>> wrapper);

}
