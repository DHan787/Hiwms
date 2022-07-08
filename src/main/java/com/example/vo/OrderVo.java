package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVo implements Serializable {

    //折线图的x轴日期集合
    private List<String> time;

    //折线图的入库订单数据集合
    private List<Integer> stockInOrder;

    //折线图的出库订单数据集合
    private List<Integer> stockOutOrder;
}
