package com.zjhz.gismap.controller;

import com.zjhz.base.enums.ProcuctCodeEnum;
import com.zjhz.base.model.HttpResult;
import com.zjhz.base.model.ValidResult;
import com.zjhz.gismap.dto.BaseAccidentDTO;
import com.zjhz.gismap.dto.BaseAirportDTO;
import com.zjhz.gismap.pvo.NoParamPVO;
import com.zjhz.gismap.service.AccidentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by GCR8949 on 2020/3/5.
 */
@Api(description = "事故事件接口",tags="事故事件接口 http header 请增加 token=登录认证接口返回值")
@RestController
@RequestMapping(value = "accident")
public class AccidentController {

    private static Logger logger = LoggerFactory.getLogger(AccidentController.class);

    @Autowired
    AccidentService accidentService;

    /**
     * <b>方法名：</b>获取事故事件列表<br>
     * <b>说明：</b> <br>
     * @param noParamPVO
     * @return com.zjhz.base.model.HttpResult
     * @author 2019/12/03   zzh
     */
    @ApiOperation(value = "获取事故事件列表" ,  notes="获取事故事件列表")
    @PostMapping(value = "/getAccidents", produces = "application/json;charset=utf-8")
    public HttpResult<List<BaseAccidentDTO>> getAccidentHtml(@RequestBody @Valid NoParamPVO noParamPVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidResult.handleBindingResult(ProcuctCodeEnum.GisMap, bindingResult, logger);
        }

        HttpResult httpResult =new HttpResult();

        try {
            List<BaseAccidentDTO> result= accidentService.getAccidentList();
            httpResult.setSuccess(true);
            httpResult.setModel(result);
        } catch (Exception e) {
            httpResult.fromException(e);
        }
        return httpResult;
    }
}
