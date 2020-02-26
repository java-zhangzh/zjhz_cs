package com.zjhz.base.model;



import java.util.List;

/**
 * Created by 12947 on 2019/11/26.
 */
public interface BaseMapper<T> {

    int deleteByPrimaryKey(Integer id);

    int insert(T t);

    T selectByPrimaryKey(Integer id);

    List<T> selectAll();

    int updateByPrimaryKey(T t);
}
