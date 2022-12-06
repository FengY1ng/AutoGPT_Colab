package com.gxy.dao;

import com.gxy.domain.Input;
import com.gxy.domain.Output;

import java.util.List;

public interface OutputDao {
    //插入
    void outputInsert(String id,String name,int num,int sell_price,String date_out);
    //更新
    void outputUpdate(Output output);
    //统计
    void outputCount();
    //删除
    void outputDelete(String id);
    //查询
    Output outputQuery(String id);
    //浏览全部
    List<Output> outputSelect();
    //清空表
    void outputClear();
}
