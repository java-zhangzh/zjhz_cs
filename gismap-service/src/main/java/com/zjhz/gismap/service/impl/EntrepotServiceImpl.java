package com.zjhz.gismap.service.impl;

import com.zjhz.gismap.dao.BaseAirportMapper;
import com.zjhz.gismap.dao.BaseEntrepotMapper;
import com.zjhz.gismap.dto.BaseAirportDTO;
import com.zjhz.gismap.dto.BaseEntrepotDTO;
import com.zjhz.gismap.service.AirportService;
import com.zjhz.gismap.service.EntrepotService;
import com.zjhz.gismap.vo.BaseAirportVO;
import com.zjhz.gismap.vo.BaseEntrepotVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12947 on 2019/12/3.
 */
@Service
public class EntrepotServiceImpl implements EntrepotService {


    @Autowired
    BaseEntrepotMapper baseEntrepotMapper;

    @Override
    public List<BaseEntrepotDTO> getAirportList() {
        List<BaseEntrepotDTO> result=new ArrayList<>();
        List<BaseEntrepotVO> entrepotVOList=    baseEntrepotMapper.selectAll();
        if(entrepotVOList!=null&&entrepotVOList.size()>0){
            for (BaseEntrepotVO baseEntrepotVO:entrepotVOList){
                BaseEntrepotDTO baseAirportDTO=new BaseEntrepotDTO(baseEntrepotVO);
                result.add(baseAirportDTO);
            }
        }
        return result;
    }
}
