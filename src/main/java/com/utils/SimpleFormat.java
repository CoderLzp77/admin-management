package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleFormat {
    public String getTime(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
}
