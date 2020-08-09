package com.example.demo.sims.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Wilson
 * @since 2020-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DistributorInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String distName;

    private String region;

    private Integer inputId;


}
