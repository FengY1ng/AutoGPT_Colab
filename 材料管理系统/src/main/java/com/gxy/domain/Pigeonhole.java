package com.gxy.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

@Data
public class Pigeonhole {
    @ExcelProperty(value="材料编码",index=0)
    String ID;
    @ColumnWidth(20)
    @ExcelProperty(value="材料名称",index=1)
    String name;
    @ColumnWidth(20)
    @ExcelProperty(value="操作数量",index=2)
    int num;
    @ColumnWidth(20)
    @ExcelProperty(value="进出类型",index=3)
    String state;
    @ColumnWidth(20)
    @ExcelProperty(value="进出时间",index=4)
    String date;

    public Pigeonhole() {
    }

    public Pigeonhole(String ID, String name, int num, String state, String date) {
        this.ID = ID;
        this.name = name;
        this.num = num;
        this.state = state;
        this.date = date;
    }
}
