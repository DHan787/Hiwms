package com.example.config;

import cn.hutool.db.sql.Order;
import com.example.domain.StockIn;
import org.springframework.context.ApplicationEvent;

/**
 * @author ymm
 * 入库申请事件
 */
public class StockInEvent extends ApplicationEvent {
    private StockIn stockIn;

    private  String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public StockInEvent(Object source, StockIn stockIn, String content){
        super(source);
        this.stockIn = stockIn;
        this.content = content;
    }

    public StockInEvent(Object source) {
        super(source);
    }

}
