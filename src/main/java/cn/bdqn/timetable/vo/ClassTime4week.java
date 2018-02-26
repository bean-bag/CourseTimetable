/**
 * Project Name:CourseTimetable
 * File Name:WeekClassTime.java
 * Package Name:cn.bdqn.timetable.vo
 * Date:2018年2月4日下午7:23:53
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.timetable.vo;

import java.util.Calendar;
import java.util.Date;

import cn.bdqn.timetable.utils.DateUtil;

/**
 * Description: <br/>
 * Date: 2018年2月4日 下午7:23:53 <br/>
 * 
 * @author thinkpad
 * @version
 * @see
 */
public class ClassTime4week {
    private static int DAYNUM = 7;

    private ClassTime4day[] classTime4day = new ClassTime4day[DAYNUM];

    public ClassTime4week(Date firstDate, ClassRoom[] rooms) {
        // 必须是周一;
        if (!DateUtil.isDay(firstDate, Calendar.MONDAY)) {
            throw new RuntimeException();
        }
        
        classTime4day[0] = new ClassTime4day(firstDate,  rooms);
        
        for (int i = 1; i < DAYNUM; i++) {
            classTime4day[i] = new ClassTime4day(DateUtil.addDay(firstDate, i), rooms);
        }
    }

    public ClassTime4day[] getClassTime4day() {
        return classTime4day;
    }

    

}
