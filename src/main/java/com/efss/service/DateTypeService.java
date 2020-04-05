package com.efss.service;

import com.efss.entity.datetype.DateType;
import com.efss.mapper.DateTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateTypeService extends  BaseService {

    @Autowired
    private DateTypeMapper dateTypeMapper;

    public List<DateType> selectDataType(String type){
        return dateTypeMapper.selectDataType(type);
    }



}
