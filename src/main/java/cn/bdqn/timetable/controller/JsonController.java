/**
 * Project Name:CourseTimetable
 * File Name:JsonController.java
 * Package Name:cn.bdqn.timetable
 * Date:2018年2月4日下午2:49:02
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.timetable.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bdqn.timetable.ro.ClassTimeRo;
import cn.bdqn.timetable.service.ClassRoomService;
import cn.bdqn.timetable.service.ClassService;
import cn.bdqn.timetable.service.CourseService;
import cn.bdqn.timetable.service.TeacherService;
import cn.bdqn.timetable.vo.ClassRoom;
import cn.bdqn.timetable.vo.ClassTime4week;
import cn.bdqn.timetable.vo.Clazz;
import cn.bdqn.timetable.vo.Course;
import cn.bdqn.timetable.vo.Teacher;

/**
 * Description: <br/>
 * Date: 2018年2月4日 下午2:49:02 <br/>
 * 
 * @author thinkpad
 * @version
 * @see
 */
@Controller
public class JsonController {

    @Autowired
    private ClassRoomService classRoomService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClassService classService;    
    @Autowired
    private CourseService courseService;
    
    @RequestMapping("classList")
    @ResponseBody
    public List<Clazz> classList(ClassTimeRo ctRo) {
       return classService.list(ctRo);
    }
    
    @RequestMapping("courseList")
    @ResponseBody
    public List<Course> courseList(ClassTimeRo ctRo) {
       return courseService.list(ctRo);
    }
    
    @RequestMapping("teacherList")
    @ResponseBody
    public List<Teacher> teacherList(ClassTimeRo ctRo) {
        return teacherService.list(ctRo);
    }

    @RequestMapping("classTime4week")
    @ResponseBody
    public ClassTime4week classTime4week(@DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        List<ClassRoom> list = this.classRoomService.list();
        return new ClassTime4week(date, list.toArray(new ClassRoom[list.size()]));
    }
}
