package com.zjhz.gismap.service.impl;

import com.zjhz.gismap.dao.BaseAccidentMapper;
import com.zjhz.gismap.dto.BaseAccidentDTO;
import com.zjhz.gismap.service.AccidentService;
import com.zjhz.gismap.vo.BaseAccidentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GCR8949 on 2020/3/5.
 */
@Service
public class AccidentServiceImpl implements AccidentService {

    @Autowired
    BaseAccidentMapper baseAccidentMapper;

    @Override
    public List<BaseAccidentDTO> getAccidentList() {
        List<BaseAccidentDTO> result = new ArrayList<>();
        List<BaseAccidentVO> accidentVOList = baseAccidentMapper.selectAll();
        if(accidentVOList != null&&accidentVOList.size()>0){
            for (BaseAccidentVO baseAccidentVO:accidentVOList){
                BaseAccidentDTO baseAccidentDTO=new BaseAccidentDTO(baseAccidentVO);
                result.add(baseAccidentDTO);
            }
        }
        return result;
    }
}
