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
public class Teacher4class extends Teacher {

    public Teacher4class(String id, String name) {
        super(id,name,WorkRole.ClassTeacher,CourseType.COT,CourseType.SST);
    }
}
