package com.zjhz.gismap.dao;

import com.zjhz.base.model.BaseMapper;
import com.zjhz.gismap.domain.BaseAccident;
import com.zjhz.gismap.vo.BaseAccidentVO;

import java.util.List;

public interface BaseAccidentMapper extends BaseMapper<BaseAccidentVO> {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseAccidentVO record);

    BaseAccidentVO selectByPrimaryKey(Integer id);

    List<BaseAccidentVO> selectAll();

    int updateByPrimaryKey(BaseAccidentVO record);
}