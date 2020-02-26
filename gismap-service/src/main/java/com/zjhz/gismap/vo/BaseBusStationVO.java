package com.zjhz.gismap.vo;

import com.zjhz.base.model.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class BaseBusStationVO extends BaseEntity implements Serializable {


    private String cname;

    private String ename;

    private String area;

    private String lon;

    private String lat;

    private String address;

    private String ofAdd;

    private String size;

    private String regional;

    private String description;

    private Integer isEnable;



    private static final long serialVersionUID = 1L;


}