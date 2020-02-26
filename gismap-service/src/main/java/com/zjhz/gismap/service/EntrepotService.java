package com.zjhz.gismap.service;

import com.zjhz.gismap.dto.BaseAirportDTO;
import com.zjhz.gismap.dto.BaseEntrepotDTO;

import java.util.List;

/**
 * Created by 12947 on 2019/12/3.
 */
public interface EntrepotService {


    /***
     * @name 获取集散中心列表
     * @return List<BaseTrainDTO>
     * @Author zzh
     * @createDate 2019/12/03
     */
    public List<BaseEntrepotDTO> getAirportList();


}
