package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseVo implements Serializable {
    //仓库名
    private List<String> name;
    //仓库占用量
    private List<String> value;
}
