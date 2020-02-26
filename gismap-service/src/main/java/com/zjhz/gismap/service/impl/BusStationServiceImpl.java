package com.zjhz.gismap.service.impl;

import com.zjhz.gismap.dao.BaseBusStationMapper;
import com.zjhz.gismap.dao.BaseTrainMapper;
import com.zjhz.gismap.domain.BaseBusStation;
import com.zjhz.gismap.dto.BaseBusStationDTO;
import com.zjhz.gismap.dto.BaseTrainDTO;
import com.zjhz.gismap.service.BusStationService;
import com.zjhz.gismap.service.TrainStationService;
import com.zjhz.gismap.vo.BaseBusStationVO;
import com.zjhz.gismap.vo.BaseTrainVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12947 on 2019/12/3.
 */
@Service
public class BusStationServiceImpl implements BusStationService {


    @Autowired
    BaseBusStationMapper baseBusStationMapper;

    @Override
    public List<BaseBusStationDTO> getBusStationList() {
        List<BaseBusStationDTO> result=new ArrayList<>();
        List<BaseBusStationVO> busStationVOList=    baseBusStationMapper.selectAll();
        if(busStationVOList!=null&&busStationVOList.size()>0){
            for (BaseBusStationVO baseBusStationVO:busStationVOList){
                BaseBusStationDTO baseBusStationDTO=new BaseBusStationDTO(baseBusStationVO);
                result.add(baseBusStationDTO);
            }
        }
        return result;
    }
}
