package com.zjhz.gismap.service;

import com.zjhz.gismap.dto.BaseBusStationDTO;


import java.util.List;

/**
 * Created by 12947 on 2019/12/3.
 */
public interface BusStationService {


    /***
     * @name 获取客运站列表
     * @return List<BaseTrainDTO>
     * @Author zzh
     * @createDate 2019/12/03
     */
    public List<BaseBusStationDTO> getBusStationList();


}
