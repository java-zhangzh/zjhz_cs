package com.zjhz.gismap.service.impl;

import com.zjhz.gismap.dao.BaseAirportMapper;
import com.zjhz.gismap.dao.BaseBusStationMapper;
import com.zjhz.gismap.dto.BaseAirportDTO;
import com.zjhz.gismap.dto.BaseBusStationDTO;
import com.zjhz.gismap.service.AirportService;
import com.zjhz.gismap.service.BusStationService;
import com.zjhz.gismap.vo.BaseAirportVO;
import com.zjhz.gismap.vo.BaseBusStationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12947 on 2019/12/3.
 */
@Service
public class AirportServiceImpl implements AirportService {


    @Autowired
    BaseAirportMapper baseAirportMapper;

    @Override
    public List<BaseAirportDTO> getAirportList() {
        List<BaseAirportDTO> result=new ArrayList<>();
        List<BaseAirportVO> airportVOList=    baseAirportMapper.selectAll();
        if(airportVOList!=null&&airportVOList.size()>0){
            for (BaseAirportVO baseAirportVO:airportVOList){
                BaseAirportDTO baseAirportDTO=new BaseAirportDTO(baseAirportVO);
                result.add(baseAirportDTO);
            }
        }
        return result;
    }
}
