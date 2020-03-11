package com.zjhz.gismap.dto;

import com.zjhz.gismap.vo.BaseAirportVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Data
public class BaseAirportDTO implements Serializable {


    public BaseAirportDTO(){}
    public BaseAirportDTO(BaseAirportVO baseAirportVO){
        BeanUtils.copyProperties(baseAirportVO, this);
    }


    @ApiModelProperty(notes = "飞机场id",dataType="int",required = true)
    private Integer id;

    @ApiModelProperty(notes = "飞机场中文名称",dataType="String",required = true)
    private String cnName;

    @ApiModelProperty(notes = "飞机场英文名称",dataType="String",required = true)
    private String enName;

    @ApiModelProperty(notes = "飞机场精度",dataType="String",required = true)
    private String lon;

    @ApiModelProperty(notes = "飞机场纬度",dataType="String",required = true)
    private String lat;

    @ApiModelProperty(notes = "飞机场具体地址",dataType="String",required = true)
    private String address;

    @ApiModelProperty(notes = "飞机场描述",dataType="String",required = true)
    private String description;

    @ApiModelProperty(notes = "颜色",dataType="String",required = true)
    private String color ;

    @ApiModelProperty(notes = "阈值",dataType="String",required = true)
    private String threshold ;

    @ApiModelProperty(notes = "客流量",dataType="String",required = true)
    private String passengerFlow ;



    private static final long serialVersionUID = 1L;


}