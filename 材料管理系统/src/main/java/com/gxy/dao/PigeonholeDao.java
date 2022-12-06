package com.gxy.dao;

import com.gxy.domain.Pigeonhole;

import java.util.List;

/**
 * 进出汇总表
 */
public interface PigeonholeDao {
    //浏览全数据(插入） 小心使用
    List<Pigeonhole> PigeonholeSelect();
    //清空
    void PigeonholeClear();
    //浏览
    List<Pigeonhole> PigeonholeSelectGood();
}
