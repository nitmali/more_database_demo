package com.nitmali.demo.mapper.first;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author nitmali
 * @date 2019/1/10 16:04
 */
@Mapper
public interface FirstMapper {
    Integer countAll();
}
