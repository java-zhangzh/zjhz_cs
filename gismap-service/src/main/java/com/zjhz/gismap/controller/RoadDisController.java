package com.zjhz.gismap.controller;

import com.zjhz.base.enums.ProcuctCodeEnum;
import com.zjhz.base.model.HttpResult;
import com.zjhz.base.model.ValidResult;
import com.zjhz.gismap.dto.*;
import com.zjhz.gismap.pvo.DisCarSpeedPVO;
import com.zjhz.gismap.pvo.DisObservationDayPVO;
import com.zjhz.gismap.pvo.DisObservationHourPVO;
import com.zjhz.gismap.pvo.NoParamPVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by 12947 on 2019/12/27.
 */
@Api(description = "路网业务接口",tags="路网业务接口 http header 请增加 token=登录认证接口返回值")
@RestController
@RequestMapping(value = "roadDis")
public class RoadDisController {

    private static Logger logger = LoggerFactory.getLogger(RoadDisController.class);
    /**
     * <b>方法名：</b>获取路网车辆速度统计图<br>
     * <b>说明：</b> <br>
     * @param disCarSpeedPVO
     * @return com.zjhz.base.model.HttpResult
     * @author 2019/12/03   zzh
     */
    @ApiOperation(value = "获取路网车辆速度统计图" ,  notes="获取路网车辆速度统计图")
    @PostMapping(value = "/getRoadDisCarSpeeds", produces = "application/json;charset=utf-8")
    public HttpResult<List<DisCarSpeedDTO>> getRoadDisCarSpeeds(@RequestBody @Valid DisCarSpeedPVO disCarSpeedPVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidResult.handleBindingResult(ProcuctCodeEnum.GisMap, bindingResult, logger);
        }
        HttpResult httpResult =new HttpResult();
        try {


        } catch (Exception e) {
            httpResult.fromException(e);
        }
        return httpResult;
    }



    /**
     * <b>方法名：</b>获取路网观测站日交通量统计图<br>
     * <b>说明：</b> <br>
     * @param disObservationDayPVO
     * @return com.zjhz.base.model.HttpResult
     * @author 2019/12/03   zzh
     */
    @ApiOperation(value = "获取路网观测站日交通量统计图" ,  notes="获取路网观测站日交通量统计图")
    @PostMapping(value = "/getRoadDisObservationDaies", produces = "application/json;charset=utf-8")
    public HttpResult<List<DisObservationDayDTO>> getRoadDisObservations(@RequestBody @Valid DisObservationDayPVO disObservationDayPVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidResult.handleBindingResult(ProcuctCodeEnum.GisMap, bindingResult, logger);
        }
        HttpResult httpResult =new HttpResult();
        try {


        } catch (Exception e) {
            httpResult.fromException(e);
        }
        return httpResult;
    }



    /**
     * <b>方法名：</b>获取路网观测站小时交通量统计图<br>
     * <b>说明：</b> <br>
     * @param disObservationHourPVO
     * @return com.zjhz.base.model.HttpResult
     * @author 2019/12/03   zzh
     */
    @ApiOperation(value = "获取路网观测站小时交通量统计图" ,  notes="获取路网观测站小时交通量统计图")
    @PostMapping(value = "/getRoadDisObservationHoures", produces = "application/json;charset=utf-8")
    public HttpResult<List<DisObservationHourDTO>> getRoadDisObservationHoures(@RequestBody @Valid DisObservationHourPVO disObservationHourPVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidResult.handleBindingResult(ProcuctCodeEnum.GisMap, bindingResult, logger);
        }
        HttpResult httpResult =new HttpResult();
        try {


        } catch (Exception e) {
            httpResult.fromException(e);
        }
        return httpResult;
    }




    /**
     * <b>方法名：</b>获取路网拥挤度全网路统计图<br>
     * <b>说明：</b> <br>
     * @param noParamPVO
     * @return com.zjhz.base.model.HttpResult
     * @author 2019/12/03   zzh
     */
    @ApiOperation(value = "获取路网拥挤度全网路统计图" ,  notes="获取路网拥挤度全网路统计图")
    @PostMapping(value = "/getRoadDisAllNetworkConDegree", produces = "application/json;charset=utf-8")
    public HttpResult<List<DisAllNetworkConDegreeDTO>> getRoadDisAllNetworkConDegree(@RequestBody @Valid NoParamPVO noParamPVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidResult.handleBindingResult(ProcuctCodeEnum.GisMap, bindingResult, logger);
        }
        HttpResult httpResult =new HttpResult();
        try {


        } catch (Exception e) {
            httpResult.fromException(e);
        }
        return httpResult;
    }


    /**
     * <b>方法名：</b>获取路网拥挤度线路统计图<br>
     * <b>说明：</b> <br>
     * @param disLineConDegreeDTO
     * @return com.zjhz.base.model.HttpResult
     * @author 2019/12/03   zzh
     */
    @ApiOperation(value = "获取路网拥挤度线路统计图" ,  notes="获取路网拥挤度线路统计图")
    @PostMapping(value = "/getRoadDisLineConDegree", produces = "application/json;charset=utf-8")
    public HttpResult<List<DisLineConDegreeDTO>> getRoadDisLineConDegree(@RequestBody @Valid DisLineConDegreeDTO disLineConDegreeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidResult.handleBindingResult(ProcuctCodeEnum.GisMap, bindingResult, logger);
        }
        HttpResult httpResult =new HttpResult();
        try {


        } catch (Exception e) {
            httpResult.fromException(e);
        }
        return httpResult;
    }

}
