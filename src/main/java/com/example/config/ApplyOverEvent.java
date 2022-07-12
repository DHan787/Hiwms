package com.example.config;

import com.example.domain.Orders;
import org.springframework.context.ApplicationEvent;

/**
 * @author ymm
 * 申请完成事件
 */
public class ApplyOverEvent extends ApplicationEvent {
    private Orders applyOver;

    private  String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public ApplyOverEvent(Object source, Orders applyOver, String content){
        super(source);
        this.applyOver = applyOver;
        this.content = content;
    }

    public ApplyOverEvent(Object source) {
        super(source);
    }

}
