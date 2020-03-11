package com.zjhz.gismap.service;

import com.zjhz.gismap.dto.GoverOverloadDTO;

import java.util.List;

/**
 * Created by GCR8949 on 2020/3/10.
 */
public interface BusinessStatisticsService {

    /***
     * 获取治超站数据列表
     * @return List<GoverOverloadDTO>
     * @Author zzh
     * @createDate 2020/03/10
     */
    public List<GoverOverloadDTO> getGoverOverloadList();
}
