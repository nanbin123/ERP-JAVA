package com.efss.mapper;

import com.efss.entity.datetype.DateType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DateTypeMapper {

    List<DateType> selectDataType(@Param("type") String type);
}
