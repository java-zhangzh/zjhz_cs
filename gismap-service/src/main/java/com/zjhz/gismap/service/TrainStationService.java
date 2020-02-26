package com.zjhz.gismap.service;

import com.zjhz.gismap.dao.BaseTrainMapper;
import com.zjhz.gismap.dto.BaseTrainDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 12947 on 2019/12/3.
 */
public interface TrainStationService {


    /***
     * @name 获取火车站列表
     * @return List<BaseTrainDTO>
     * @Author zzh
     * @createDate 2019/12/03
     */
    public List<BaseTrainDTO> getTrainStationList();


}
