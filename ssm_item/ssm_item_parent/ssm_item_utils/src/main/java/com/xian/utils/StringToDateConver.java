package com.xian.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把字符串转换为日期
 */
public class StringToDateConver implements Converter<String,Date> {

    @Override
    public Date convert(String source) {
        if (source==null){
            throw new RuntimeException("请传入数据");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换出现异常");
        }

    }
}
