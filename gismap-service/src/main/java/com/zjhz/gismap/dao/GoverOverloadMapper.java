package com.zjhz.gismap.dao;

import com.zjhz.base.model.BaseMapper;
import com.zjhz.gismap.domain.GoverOverload;
import com.zjhz.gismap.vo.GoverOverloadVO;

import java.util.List;

public interface GoverOverloadMapper extends BaseMapper<GoverOverloadVO> {
    int deleteByPrimaryKey(Integer id);

    int insert(GoverOverloadVO record);

    GoverOverloadVO selectByPrimaryKey(Integer id);

    List<GoverOverloadVO> selectAll();

    int updateByPrimaryKey(GoverOverloadVO record);
}