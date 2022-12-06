package com.gxy.dao;

import com.gxy.domain.Input;

import java.util.List;

/*
 * 材料入库表增删改查
 */
public interface InputDao {
    //插入
    void inputInsert(String id,String name,int num,int trade_price,String date_in);
    //更新
    void inputUpdate(Input input);
    //统计
    void inputCount();
    //删除
    void inputDelete(String id);
    //查询
     Input inputQuery(String id);
    //浏览全部
    List<Input> inputSelect();
    //清空表
    void inputClear();
}
