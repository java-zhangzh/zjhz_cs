package com.zjhz.gismap.controller;


import com.zjhz.base.enums.ProcuctCodeEnum;
import com.zjhz.base.model.HttpResult;
import com.zjhz.base.model.ValidResult;
import com.zjhz.gismap.dto.BaseAirportDTO;
import com.zjhz.gismap.dto.BaseBusStationDTO;
import com.zjhz.gismap.pvo.NoParamPVO;
import com.zjhz.gismap.service.AirportService;
import com.zjhz.gismap.service.BusStationService;
import com.zjhz.gismap.util.WebSocketUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <b>功能名：</b>ParentsTestController<br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2019 ZJHZ  CORPORATION<br>
 * <b>修改履历：
 *
 * @author 2019-05-13 zzh
 */
@Api(description = "飞机场业务接口",tags="飞机场业务接口 http header 请增加 token=登录认证接口返回值")
@RestController
@RequestMapping(value = "airport")
public class AirportController {

    private static Logger logger = LoggerFactory.getLogger(AirportController.class);

    @Autowired
    AirportService airportService;

    @Autowired
    private WebSocketUtil socketUtil;

    /**
    * <b>方法名：</b>获取火车站列表信息<br>
    * <b>说明：</b> <br>
    * @param noParamPVO
    * @return com.zjhz.base.model.HttpResult
    * @author 2019/12/03   zzh
    */
    @ApiOperation(value = "获取飞机场列表" ,  notes="获取飞机场列表")
    @PostMapping(value = "/getAriportes", produces = "application/json;charset=utf-8")
    public HttpResult<List<BaseAirportDTO>> getKgHtml(@RequestBody @Valid NoParamPVO noParamPVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidResult.handleBindingResult(ProcuctCodeEnum.GisMap, bindingResult, logger);
        }
        HttpResult httpResult =new HttpResult();
        try {
            List<BaseAirportDTO> result= airportService.getAirportList();
            httpResult.setSuccess(true);
            httpResult.setModel(result);
        } catch (Exception e) {
            httpResult.fromException(e);
        }
        return httpResult;
    }


    /**
     * /topic/message 要推送的频道
     */

    @PostMapping(value = "/send", produces = "application/json;charset=utf-8")
    @ResponseBody
    public void send() {
        System.out.println("asdf");
        socketUtil.sendMsg("/topic/message","拉拉");
    }
}
