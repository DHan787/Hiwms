package com.example.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("msgs")
@Data
public class Msgs {
    @TableId("msgs_id")
    /**
     * id
     */
    private Integer msgsId;
    /**
     * 消息内容
     */
    private String  msgsCont;
    /**
     * 消息类型
     */
    private Integer type;
    /**
     * 订单id
     */
    private Integer orderId;

    public Integer getMsgsId() {
        return msgsId;
    }

    public void setMsgsId(Integer msgsId) {
        this.msgsId = msgsId;
    }

    public String getMsgsCont() {
        return msgsCont;
    }

    public void setMsgsCont(String msgsCont) {
        this.msgsCont = msgsCont;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrderId(){
        return orderId;
    }

    public void setOrderId(Integer orderId){
        this.orderId = orderId;
    }
}
