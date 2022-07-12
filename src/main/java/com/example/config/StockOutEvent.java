package com.example.config;

import com.example.domain.StockOut;
import org.springframework.context.ApplicationEvent;

public class StockOutEvent extends ApplicationEvent {
    private StockOut stockOut;

    private  String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public StockOutEvent(Object source, StockOut stockOut, String content){
        super(source);
        this.stockOut = stockOut;
        this.content = content;
    }

    public StockOutEvent(Object source) {
        super(source);
    }

}
