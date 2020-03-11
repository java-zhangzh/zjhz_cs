package com.zjhz.gismap.dto;

import com.zjhz.base.model.BaseEntity;
import com.zjhz.gismap.vo.GoverOverloadVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

@Data
public class GoverOverloadDTO implements Serializable {

    public GoverOverloadDTO(){}
    public GoverOverloadDTO(GoverOverloadVO goverOverloadVO){
        BeanUtils.copyProperties(goverOverloadVO, this);
    }

    @ApiModelProperty(notes = "治超路段信息表id",dataType="int",required = true)
    private Integer id;

    @ApiModelProperty(notes = "检测站点id",dataType="int",required = true)
    private Integer checkStationId;

    @ApiModelProperty(notes = "路段id",dataType="int",required = true)
    private Integer roadId;

    @ApiModelProperty(notes = "超限超载违法行为类型",dataType="String",required = true)
    private String overloadType;

    @ApiModelProperty(notes = "时间",dataType="Date",required = true)
    private Date time;

    @ApiModelProperty(notes = "车辆数量",dataType="int",required = true)
    private Integer carCount;


    private static final long serialVersionUID = 1L;

}