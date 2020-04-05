package com.efss.controller;

import com.efss.controller.base.BaseController;
import com.efss.entity.datetype.DateType;
import com.efss.entity.user.JsonResult;
import com.efss.service.DateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据字典
 */
@RestController
@CrossOrigin
public class DateTypeController extends BaseController {
    @Autowired
    private DateTypeService dateTypeService;

    //根据type 查询name
    @PostMapping("selectDataType")
    public JsonResult selectDataType(String type){
        List<DateType> list= dateTypeService.selectDataType(type);
        return buildJsonSuccess(list);
    }
}
