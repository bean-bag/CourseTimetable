/**
 * Project Name:CourseTimetable
 * File Name:ClassTime.java
 * Package Name:cn.bdqn.project.timetable.vo
 * Date:2018年1月31日上午8:47:04
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.timetable.vo;

import cn.bdqn.timetable.enums.Period;

/**
 * Description: 班次数据 <br/>
 * 记录某班在某教室信息<br>
 * Date: 2018年1月31日 上午8:47:04 <br/>
 * 
 * @author thinkpad
 * @version
 * @see
 */
public class ClassTime {

    private Clazz clazz;

    private Period period;

    private Teacher teacher;

    public ClassTime(Clazz clazz, Period period) {
        this.clazz = clazz;
        this.period = period;
    }

    public ClassTime(Clazz clazz, Period period, Teacher teacher) {
        this(clazz, period);
        this.teacher = teacher;
    }

    public Clazz getClazz() {
        return clazz;
    }

    /**
     * 可能修改班级 Description: <br/>
     *
     * @author thinkpad
     * @param clazz
     */
    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Period getPeriod() {
        return period;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
