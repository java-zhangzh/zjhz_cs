package com.zjhz.gismap.service.impl;

import com.zjhz.gismap.dao.GoverOverloadMapper;
import com.zjhz.gismap.dto.GoverOverloadDTO;
import com.zjhz.gismap.service.BusinessStatisticsService;
import com.zjhz.gismap.vo.GoverOverloadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GCR8949 on 2020/3/10.
 */
@Service
public class BusinessStatisticsServiceImpl implements BusinessStatisticsService {

    @Autowired
    GoverOverloadMapper goverOverloadMapper;

    @Override
    public List<GoverOverloadDTO> getGoverOverloadList() {
        List<GoverOverloadDTO> result = new ArrayList<>();
        List<GoverOverloadVO> goverOverloadVOList = goverOverloadMapper.selectAll();
        if(goverOverloadVOList != null&&goverOverloadVOList.size()>0){
            for (GoverOverloadVO goverOverloadVO:goverOverloadVOList){
                GoverOverloadDTO goverOverloadDTO=new GoverOverloadDTO(goverOverloadVO);
                result.add(goverOverloadDTO);
            }
        }
        return result;
    }
}
