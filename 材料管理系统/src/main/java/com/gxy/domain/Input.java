package com.gxy.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

/**
 * 入库表数据!！！
 */
@Data
public class Input {
    @ExcelProperty(value="材料编码",index=0)
     String ID;
    @ColumnWidth(20)
    @ExcelProperty(value="材料名称",index=1)
     String name;
    @ColumnWidth(20)
    @ExcelProperty(value="入库数量",index=2)
    int num;
    @ColumnWidth(20)
    @ExcelProperty(value="入库价格",index=3)
     int trade_price;
    @ColumnWidth(20)
    @ExcelProperty(value="入库时间",index=4)
     String date_in;

    public Input() {
    }

    public Input(String ID, String name, int num, int trade_price, String date_in) {
        this.ID = ID;
        this.name = name;
        this.num = num;
        this.trade_price = trade_price;
        this.date_in = date_in;
    }

}
