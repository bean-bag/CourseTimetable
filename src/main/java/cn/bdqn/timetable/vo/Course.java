/**
 * Project Name:CourseTimetable
 * File Name:Course.java
 * Package Name:cn.bdqn.project.timetable.vo
 * Date:2018年1月31日上午8:35:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.timetable.vo;

import cn.bdqn.timetable.enums.CourseType;

/**
 * Description:  课程 <br/>
 * Date:     2018年1月31日 上午8:35:25 <br/>
 * @author   thinkpad
 * @version
 * @see
 */
public class Course extends Info{
    
    public Course(String id, String name, CourseType courseType) {
        super(id, name);
        this.courseType = courseType;
    }

    private CourseType courseType;

    public CourseType getCourseType() {
        return courseType;
    }
    
    

}

