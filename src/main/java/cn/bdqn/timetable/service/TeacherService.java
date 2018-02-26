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
import cn.bdqn.timetable.enums.WorkRole;
import cn.bdqn.timetable.ro.ClassTimeRo;
import cn.bdqn.timetable.vo.Teacher;
import cn.bdqn.timetable.vo.Teacher4class;

/**
 * Description: <br/>
 * Date: 2018年2月4日 下午8:49:50 <br/>
 * 
 * @author thinkpad
 * @version
 * @see
 */
@Service
public class TeacherService {

    public List<Teacher> list(ClassTimeRo ctRo) {
        List<Teacher> list = new ArrayList<>();
        list.add(new Teacher("1", "王建兵", WorkRole.CourseTeacher, CourseType.JAVA));
        list.add(new Teacher("2", "徐士甲", WorkRole.CourseTeacher, CourseType.JAVA));
        list.add(new Teacher("3", "丁鹏", WorkRole.CourseTeacher, CourseType.JAVA));
        list.add(new Teacher("4", "吴智超", WorkRole.CourseTeacher, CourseType.JAVA));
        list.add(new Teacher("5", "孙子荃", WorkRole.CourseTeacher, CourseType.UI));
        list.add(new Teacher("6", "包俊文", WorkRole.CourseTeacher, CourseType.JAVA));

        list.add(new Teacher4class("7", "阮柳"));
        list.add(new Teacher4class("8", "朱大玲"));
        list.add(new Teacher4class("9", "文雯"));
        list.add(new Teacher4class("10", "罗纯"));
        list.add(new Teacher4class("11", "汪文妮"));
        list.add(new Teacher4class("12", "陈冠男"));

        return list;
    }
}
