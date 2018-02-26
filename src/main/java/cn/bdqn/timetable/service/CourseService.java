/**
 * Project Name:CourseTimetable
 * File Name:ClassRoomService.java
 * Package Name:cn.bdqn.timetable.service
 * Date:2018年2月4日下午8:49:50
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.timetable.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.bdqn.timetable.enums.CourseType;
import cn.bdqn.timetable.ro.ClassTimeRo;
import cn.bdqn.timetable.vo.Course;

/**
 * Description: <br/>
 * Date: 2018年2月4日 下午8:49:50 <br/>
 * 
 * @author thinkpad
 * @version
 * @see
 */
@Service
public class CourseService {

    public List<Course> list(ClassTimeRo ctRo) {
        List<Course> list = new ArrayList<>();
        list.add(new Course("1", "JAVA", CourseType.JAVA));
        list.add(new Course("2", "UI", CourseType.UI));
        list.add(new Course("3", "COT", CourseType.COT));
        list.add(new Course("4", "自习课", CourseType.SST));
        list.add(new Course("5", "面试", CourseType.COT));
        return list;
    }
}
