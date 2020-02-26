package com.zjhz.gismap.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by 12947 on 2019/12/27.
 */
@Data
public class DisObservationDayDTO {

    @ApiModelProperty(notes = "时间数组",dataType="list",required = true)
    private String [] dates;

    @ApiModelProperty(notes = "交通量数组",dataType="list",required = true)
    private String [] traffices;
}
