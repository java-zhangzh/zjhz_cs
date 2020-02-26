package com.zjhz.gismap.dto;

import com.zjhz.gismap.vo.BaseBusStationVO;
import com.zjhz.gismap.vo.BaseTrainVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Data
public class BaseBusStationDTO implements Serializable {


    public BaseBusStationDTO(){}
    public BaseBusStationDTO(BaseBusStationVO baseBusStationVO){
        BeanUtils.copyProperties(baseBusStationVO, this);
    }


    @ApiModelProperty(notes = "客运站id",dataType="int",required = true)
    private Integer id;

    @ApiModelProperty(notes = "客运站中文名称",dataType="String",required = true)
    private String cnName;

    @ApiModelProperty(notes = "客运站英文名称",dataType="String",required = true)
    private String enName;

    @ApiModelProperty(notes = "客运站精度",dataType="String",required = true)
    private String lon;

    @ApiModelProperty(notes = "客运站纬度",dataType="String",required = true)
    private String lat;

    @ApiModelProperty(notes = "客运站具体地址",dataType="String",required = true)
    private String address;

    @ApiModelProperty(notes = "客运站描述",dataType="String",required = true)
    private String description;

    @ApiModelProperty(notes = "颜色",dataType="String",required = true)
    private String color ;

    @ApiModelProperty(notes = "阈值",dataType="String",required = true)
    private String threshold ;

    @ApiModelProperty(notes = "客流量",dataType="String",required = true)
    private String passengerFlow ;

    private static final long serialVersionUID = 1L;


}