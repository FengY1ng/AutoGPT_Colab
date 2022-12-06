package com.gxy.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

/**
 * 总表！！！
 */
@Data
public class WareHouse {

    @ExcelProperty(value="材料编码",index=0)
    private String ID;
    @ColumnWidth(20)
    @ExcelProperty(value="材料名称",index=1)
    private String name;
    @ColumnWidth(20)
    @ExcelProperty(value="材料数量",index=2)
    private int num;
    @ColumnWidth(20)
    @ExcelProperty(value="售卖价格",index=3)
    private int sell_price;


    public WareHouse() {
    }

    public WareHouse(String ID, String name, Integer num, Integer sell_price) {
        this.ID = ID;
        this.name = name;
        this.num = num;
        this.sell_price = sell_price;
    }
}
