package com.zjhz.gismap.dto;

import com.zjhz.gismap.vo.BaseAirportVO;
import com.zjhz.gismap.vo.BaseEntrepotVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Data
public class BaseEntrepotDTO implements Serializable {


    public BaseEntrepotDTO(){}
    public BaseEntrepotDTO(BaseEntrepotVO baseEntrepotVO){
        BeanUtils.copyProperties(baseEntrepotVO, this);
    }


    @ApiModelProperty(notes = "集散中心id",dataType="int",required = true)
    private Integer id;

    @ApiModelProperty(notes = "集散中心中文名称",dataType="String",required = true)
    private String cnName;

    @ApiModelProperty(notes = "集散中心英文名称",dataType="String",required = true)
    private String enName;

    @ApiModelProperty(notes = "集散中心精度",dataType="String",required = true)
    private String lon;

    @ApiModelProperty(notes = "集散中心纬度",dataType="String",required = true)
    private String lat;

    @ApiModelProperty(notes = "集散中心具体地址",dataType="String",required = true)
    private String address;

    @ApiModelProperty(notes = "集散中心描述",dataType="String",required = true)
    private String description;

    @ApiModelProperty(notes = "颜色",dataType="String",required = true)
    private String color ;

    @ApiModelProperty(notes = "阈值",dataType="String",required = true)
    private String threshold ;

    @ApiModelProperty(notes = "客流量",dataType="String",required = true)
    private String passengerFlow ;


    private static final long serialVersionUID = 1L;


}