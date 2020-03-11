package com.zjhz.gismap.controller;

import com.zjhz.base.enums.ProcuctCodeEnum;
import com.zjhz.base.model.HttpResult;
import com.zjhz.base.model.ValidResult;
import com.zjhz.gismap.dto.GoverOverloadDTO;
import com.zjhz.gismap.pvo.NoParamPVO;
import com.zjhz.gismap.service.BusinessStatisticsService;
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
 * Created by GCR8949 on 2020/3/10.
 */
@Api(description = "业务统计接口",tags="业务统计接口 http header 请增加 token=登录认证接口返回值")
@RestController
@RequestMapping(value = "businessStatistics")
public class BusinessStatisticsController {

    private static Logger logger = LoggerFactory.getLogger(BusinessStatisticsController.class);

    @Autowired
    BusinessStatisticsService businessStatisticsService;

    /**
     * <b>方法名：</b>获取治超站数据列表<br>
     * <b>说明：</b> <br>
     * @param noParamPVO
     * @return com.zjhz.base.model.HttpResult
     * @author 2020/03/10   zzh
     */
    @ApiOperation(value = "获取治超站数据列表" ,  notes="获取治超站数据列表")
    @PostMapping(value = "/getGoverOverloads", produces = "application/json;charset=utf-8")
    public HttpResult<List<GoverOverloadDTO>> getGoverOverloadHtml(@RequestBody @Valid NoParamPVO noParamPVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ValidResult.handleBindingResult(ProcuctCodeEnum.GisMap, bindingResult, logger);
        }

        HttpResult httpResult =new HttpResult();

        try {
            List<GoverOverloadDTO> result= businessStatisticsService.getGoverOverloadList();
            httpResult.setSuccess(true);
            httpResult.setModel(result);
        } catch (Exception e) {
            httpResult.fromException(e);
        }
        return httpResult;
    }
}
