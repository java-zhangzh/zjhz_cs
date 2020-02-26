package com.zjhz.gismap.pvo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by 12947 on 2019/11/26.
 */

@Data
public class DisCarSpeedPVO {


    @ApiModelProperty(notes = "日期",dataType="String",required = true)
    protected  String date;


    @ApiModelProperty(notes = "路网道路类型",dataType="String",required = true)
    protected  String roadType;

    @ApiModelProperty(notes = "路网道路ID",dataType="Integer",required = true)
    protected  String roadId;


}
