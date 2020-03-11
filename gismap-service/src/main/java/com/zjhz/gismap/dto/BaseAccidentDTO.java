package com.zjhz.gismap.dto;

import com.zjhz.gismap.vo.BaseAccidentVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseAccidentDTO implements Serializable {

    public BaseAccidentDTO(){}
    public BaseAccidentDTO(BaseAccidentVO baseAccidentVO){
        BeanUtils.copyProperties(baseAccidentVO, this);
    }

    @ApiModelProperty(notes = "事件事故id",dataType="Integer",required = true)
    private Integer id;

    @ApiModelProperty(notes = "标题",dataType="String",required = true)
    private String title;

    @ApiModelProperty(notes = "事故类型id",dataType="Integer",required = true)
    private Integer typeId;

    @ApiModelProperty(notes = "时间",dataType="Date",required = true)
    private Date time;

    @ApiModelProperty(notes = "地点",dataType="String",required = true)
    private String place;

    @ApiModelProperty(notes = "经度",dataType="Double",required = true)
    private Double longitude;

    @ApiModelProperty(notes = "纬度",dataType="Double",required = true)
    private Double latitude;

    @ApiModelProperty(notes = "描述",dataType="String",required = true)
    private String details;


    private static final long serialVersionUID = 1L;

}