package com.example.demo.sims.mapper;

import com.example.demo.sims.entity.DistributorInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

}
