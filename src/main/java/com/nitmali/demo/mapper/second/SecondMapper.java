package com.nitmali.demo.mapper.second;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author nitmali
 * @date 2019/1/10 16:07
 */
@Mapper
public interface SecondMapper {
    Integer countAll();
}
