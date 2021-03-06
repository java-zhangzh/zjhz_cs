package com.zjhz.gismap.pvo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by 12947 on 2019/11/26.
 */

@Data
public class DisObservationHourPVO {


    @ApiModelProperty(notes = "开始小时",dataType="String",required = true)
    protected  String startHour;

    @ApiModelProperty(notes = "结束小时",dataType="String",required = true)
    protected  String endHour;


    @ApiModelProperty(notes = "路网道路类型",dataType="String",required = true)
    protected  String roadType;

    @ApiModelProperty(notes = "路网道路ID",dataType="Integer",required = true)
    protected  String roadId;

    @ApiModelProperty(notes = "观测站ID",dataType="Integer",required = true)
    protected  String obsTrafficesId;


}
