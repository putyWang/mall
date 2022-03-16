package com.ego.commons.utils;

import java.util.Random;

public class CreatIdUtil {

    public static Long getId(){
        //获取当前时间毫秒数
        Long millis = System.currentTimeMillis();
        //获取两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //随机数不全时，前面加0
        String str = millis + String.format("%02d", end2);
        return Long.parseLong(str);
    }


    public static Long getImgeId(){
        //获取当前时间毫秒数
        Long millis = System.currentTimeMillis();
        //获取两位随机数
        Random random = new Random();
        int end2 = random.nextInt(999);
        //随机数不全时，前面加0
        String str = millis + String.format("%03d", end2);
        return Long.parseLong(str);
    }
}
