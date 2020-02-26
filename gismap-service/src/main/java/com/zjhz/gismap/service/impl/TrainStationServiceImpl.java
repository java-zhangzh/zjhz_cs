package com.zjhz.gismap.service.impl;

import com.zjhz.gismap.dao.BaseTrainMapper;
import com.zjhz.gismap.domain.BaseTrain;
import com.zjhz.gismap.dto.BaseTrainDTO;
import com.zjhz.gismap.service.TrainStationService;
import com.zjhz.gismap.vo.BaseTrainVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12947 on 2019/12/3.
 */
@Service
public class TrainStationServiceImpl implements TrainStationService {


    @Autowired
    BaseTrainMapper baseTrainMapper;

    @Override
    public List<BaseTrainDTO> getTrainStationList() {
        List<BaseTrainDTO> result=new ArrayList<>();
        List<BaseTrainVO> trainVOList=    baseTrainMapper.selectAll();
        if(trainVOList!=null&&trainVOList.size()>0){
            for (BaseTrainVO baseTrainVO:trainVOList){
                BaseTrainDTO baseTrainDTO=new BaseTrainDTO(baseTrainVO);
                result.add(baseTrainDTO);
            }
        }
        return result;
    }
}
