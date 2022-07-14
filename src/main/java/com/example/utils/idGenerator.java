package com.example.utils;

/**
 * info id生成工具类
 * @author ginger
 */
public class idGenerator {
    private idGenerator(){
    }

    /**
     * id生成器
     * @param oriId userid
     * @param time alt time
     * @return user info id
     */
    public static long userInfoIdGenerator(int oriId, long time){
       String value1 = time+""+oriId;
        return Long.parseLong(value1);
    }



    public static void main(String[] args) throws Exception{

        System.out.println(userInfoIdGenerator(11,11));

    }
}
