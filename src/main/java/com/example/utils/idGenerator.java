package com.example.utils;

import java.util.Date;

public class idGenerator {
    private idGenerator(){
    }

    public static long UserInfoIDGenerator(int oriId,long time){
       String value1 = time+""+oriId;
        return Long.parseLong(value1);
    }



    public static void main(String[] args) throws Exception{

        System.out.println(UserInfoIDGenerator(11,11));

    }
}
