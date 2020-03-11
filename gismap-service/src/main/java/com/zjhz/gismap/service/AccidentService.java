package com.zjhz.gismap.service;

import com.zjhz.gismap.dto.BaseAccidentDTO;

import java.util.List;

/**
 * Created by GCR8949 on 2020/3/5.
 */
public interface AccidentService {

    /***
     * 获取事故事件列表
     * @return List<BaseAccidentDTO>
     * @Author zzh
     * @createDate 2020/03/05
     */
    public List<BaseAccidentDTO> getAccidentList();
}
