package com.zk.chinkjet.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xf
 * @version 1.0
 * @date 2020/4/1 11:00
 */
public class DateFormat {


    /**
     * 根据GPS时间返回时间格式
     * @param GPSDate
     * @return
     */
    public static Date decryptGPSDate_Date(String GPSDate){
        Date date = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

        // 2019-05-21T08:44:00Z 对应的时间格式 yyyy-MM-dd'T'HH:mm:ss'Z'
        try {
            date = sdf.parse(GPSDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 根据GPS时间返回时间格式
     * @param GPSDate
     * @return
     */
    public static Date decryptGPSDate_Date2(String GPSDate){
        Date date = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 2019-05-21T08:44:00Z 对应的时间格式 yyyy-MM-dd'T'HH:mm:ss'Z'
        try {
            date = sdf.parse(GPSDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 根据GPS时间返回时间格式
     * @param GPSDate
     * @return
     */
    public static Date decryptGPSDate_Date3(String GPSDate){
        Date date = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmss");
        // 2019-05-21T08:44:00Z 对应的时间格式 yyyy-MM-dd'T'HH:mm:ss'Z'
        try {
            date = sdf.parse(GPSDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * 根据yyyy-MM-dd时间返回时间格式
     * @param DateStr
     * @return
     */
    public static Date decryptGPSDate_Date4(String DateStr){
        Date date = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 2019-05-21T08:44:00Z 对应的时间格式 yyyy-MM-dd'T'HH:mm:ss'Z'
        try {
            date = sdf.parse(DateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 返回当前时间或者之后的时间
     * @param day +1后一天，-1前一天
     * @return
     */
    public static Date getCurrentDate(int day){
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * 返回String时间 格式 yyyy-MM-dd
     * @return
     */
    public static String getNowDate(){
        java.text.DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format( new Date(  ) );
        return time;
    }


    /**
     * 根据GPS时间返回时间格式
     * @param GPSDate
     * @return
     */
    public static Date GPSDate_Date(String GPSDate){
        Date date = null;

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy HHmmss");

        // 2019-05-21T08:44:00Z 对应的时间格式 yyyy-MM-dd'T'HH:mm:ss'Z'
        try {
            date = sdf.parse(GPSDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 根据GPS时间转换为正常的时间格式，并返回string类型
     * @param GPSDate
     * @return
     */
    public static String GPSDate_DateStr(String GPSDate){

        Date date = null;
        // ISO 8601 slightly modified */"yyyy-MM-dd'T'HH:mm:ss'Z'",
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy HHmmss");
        // 2019-05-21T08:44:00Z 对应的时间格式 yyyy-MM-dd'T'HH:mm:ss'Z'
        try {
            date = sdf.parse(GPSDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = simpleDateFormat.format(date);
        return str;
    }


    /**
     * 将时间格式转换为字符串时间格式
     * @param date
     * @return
     */
    public static String Date_DateStr(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         return sdf.format(date);
    }

    /**
     * 将秒数转换为具体的时间
     * @param m
     * @return
     */
    public static Date miaoToDate(Integer m){

        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");//制定日期的显示格式

        Date date = new Date(((m-28800)*1000L));

        String time=sdf.format(date);//m为从服务器返回的数据转换后的值（往往是将服务器返回的字符串形式的值，需要转化为int型或者long型）

        //格林时间是以1970-01-01 00:00:00为基准计起的，服务器返回的就是某一时刻到这个基准的秒数（如果是毫秒那就更好了，直接使用不用*1000L）

        return date;
    }
}
