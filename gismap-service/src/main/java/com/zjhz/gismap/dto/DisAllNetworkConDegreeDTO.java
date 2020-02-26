package com.zjhz.gismap.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by 12947 on 2019/12/27.
 */
@Data
public class DisAllNetworkConDegreeDTO {

    @ApiModelProperty(notes = "时间",dataType="list",required = true)
    private String  datetime;

    @ApiModelProperty(notes = "拥堵值",dataType="list",required = true)
    private String  congVolume;
}
