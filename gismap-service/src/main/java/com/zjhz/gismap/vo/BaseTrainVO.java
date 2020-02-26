package com.zjhz.gismap.vo;

import com.zjhz.base.model.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseTrainVO extends BaseEntity implements Serializable {



    private String cnName;


    private String enName;


    private String lon;


    private String lat;


    private String address;


    private String description;



    private static final long serialVersionUID = 1L;


}