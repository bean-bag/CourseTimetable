/**
 * Project Name:CourseTimetable
 * File Name:Clazz.java
 * Package Name:cn.bdqn.project.timetable.vo
 * Date:2018年1月31日上午8:32:30
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.timetable.vo;

import java.util.List;

/**
 * Description: 班级 <br/>
 * Date: 2018年1月31日 上午8:32:30 <br/>
 * 
 * @author thinkpad
 * @version
 * @see
 */
public class Clazz extends Info {

    public Clazz(String id, String name, int num) {
        super(id, name);
        this.num = num;
    }

    /**
     * 班级人数
     */
    private int num;

    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    /**
     * 
     * Description: <br/>
     *
     * @author thinkpad
     * @param courses
     * @deprecated
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getNum() {
        return num;
    }
    
    
}
