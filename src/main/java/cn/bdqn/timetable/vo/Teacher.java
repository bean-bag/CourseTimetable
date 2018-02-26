/**
 * Project Name:CourseTimetable
 * File Name:Teacher.java
 * Package Name:cn.bdqn.project.timetable.vo
 * Date:2018年1月31日上午8:33:48
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.timetable.vo;

import cn.bdqn.timetable.enums.CourseType;
import cn.bdqn.timetable.enums.WorkRole;

/**
 * Description: 教师 <br/>
 * Date: 2018年1月31日 上午8:33:48 <br/>
 * 
 * @author thinkpad
 * @version
 * @see
 */
public class Teacher extends Info {

    public Teacher(String id, String name, WorkRole role, CourseType... courseTypes) {
        super(id, name);
        this.role = role;
        this.courseTypes = courseTypes;
    }

    /**
     * 老师职责角色
     */
    private WorkRole role;
    
    /**
     * 老师授课内容
     */
    private CourseType[] courseTypes;

    public WorkRole getRole() {
        return role;
    }

    public CourseType[] getCourseTypes() {
        return courseTypes;
    }
    
    
}
