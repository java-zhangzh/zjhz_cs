package com.zjhz.gismap.dto;

import com.zjhz.gismap.vo.BaseTrainVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseTrainDTO implements Serializable {


    public BaseTrainDTO(){}
    public BaseTrainDTO(BaseTrainVO baseTrainVO){
        BeanUtils.copyProperties(baseTrainVO, this);
    }


    @ApiModelProperty(notes = "火车站id",dataType="int",required = true)
    private Integer id;

    @ApiModelProperty(notes = "火车站中文名称",dataType="String",required = true)
    private String cnName;

    @ApiModelProperty(notes = "火车站英文名称",dataType="String",required = true)
    private String enName;

    @ApiModelProperty(notes = "火车站精度",dataType="String",required = true)
    private String lon;

    @ApiModelProperty(notes = "火车站纬度",dataType="String",required = true)
    private String lat;

    @ApiModelProperty(notes = "火车站具体地址",dataType="String",required = true)
    private String address;

    @ApiModelProperty(notes = "火车站描述",dataType="String",required = true)
    private String description;

    @ApiModelProperty(notes = "颜色",dataType="String",required = true)
    private String color ;

    @ApiModelProperty(notes = "阈值",dataType="String",required = true)
    private String threshold ;

    @ApiModelProperty(notes = "客流量",dataType="String",required = true)
    private String passengerFlow ;

    private static final long serialVersionUID = 1L;


}