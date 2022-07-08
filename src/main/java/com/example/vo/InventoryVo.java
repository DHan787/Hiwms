package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryVo implements Serializable {
    //柱状图的名称集合
    private List<String> name;
    //柱状图的数量集合
    private List<String> value;
}
