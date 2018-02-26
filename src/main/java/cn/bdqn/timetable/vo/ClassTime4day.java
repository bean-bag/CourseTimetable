/**
 * Project Name:CourseTimetable
 * File Name:DayClassTime.java
 * Package Name:cn.bdqn.project.timetable.vo
 * Date:2018年1月31日上午8:49:08
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.timetable.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Description: 一天的班次数据 <br/>
 * Date: 2018年1月31日 上午8:49:08 <br/>
 * 
 * @author thinkpad
 * @version
 * @see
 */
public class ClassTime4day {

    /**
     * 教室列表
     */
    private ClassRoom[] classRooms;

    @DateTimeFormat
    private Date date;

    public ClassTime4day(Date date, ClassRoom[] classRooms) {
        this.date = date;
        this.classRooms = classRooms;
    }

    public Date getDate() {
        return date;
    }

    public ClassRoom[] getClassRooms() {
        return classRooms;
    }

    public void put(int roomIndex,ClassTime classTime) {
        this.classRooms[roomIndex].setClassTime(classTime);
    }

}
