package com.zjhz.gismap.service;

import com.zjhz.gismap.dto.BaseAirportDTO;
import com.zjhz.gismap.dto.BaseBusStationDTO;

import java.util.List;

/**
 * Created by 12947 on 2019/12/3.
 */
public interface AirportService {


    /***
     * @name 获取飞机场列表
     * @return List<BaseTrainDTO>
     * @Author zzh
     * @createDate 2019/12/03
     */
    public List<BaseAirportDTO> getAirportList();


}
