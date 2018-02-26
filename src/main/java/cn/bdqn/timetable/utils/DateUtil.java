/**
 * Project Name:CourseTimetable
 * File Name:DateUtil.java
 * Package Name:cn.bdqn.timetable.utils
 * Date:2018年2月4日下午8:10:27
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.timetable.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Description: <br/>
 * Date: 2018年2月4日 下午8:10:27 <br/>
 * 
 * @author thinkpad
 * @version
 * @see
 */
public class DateUtil {

    /**
     * 判断是周几
     * Description: <br/>
     *
     * @author thinkpad
     * @param date
     * @param day
     * @return
     */
    public static boolean isDay(Date date,int day) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        return day == cale.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 
     * Description: <br/>
     *
     * @author thinkpad
     * @param date
     * @return
     */
    public static Date addDay(Date date, int num) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(Calendar.DAY_OF_MONTH, num);
        return cale.getTime();
    }
}
