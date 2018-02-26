/**
 * Project Name:CourseTimetable
 * File Name:WeekClassTime.java
 * Package Name:cn.bdqn.project.timetable.vo
 * Date:2018年1月31日上午8:49:58
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.timetable.vo;

/**
 * Description: 一周的班次数据 <br/>
 * Date: 2018年1月31日 上午8:49:58 <br/>
 * 
 * @author thinkpad
 * @version
 * @see
 */
public class TimetableData {

    private int[][] data;

    public TimetableData(int period, int roomSize) {
        this.data = new int[period][roomSize];
    }


    public void put(int dayOfweek, int roomIndex, int classIndex) {
        this.data[dayOfweek][roomIndex] = classIndex;
    }
}
