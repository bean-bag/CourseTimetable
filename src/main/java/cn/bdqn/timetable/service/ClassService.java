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

import cn.bdqn.timetable.ro.ClassTimeRo;
import cn.bdqn.timetable.vo.Clazz;

/**     
 * Description: <br/>
 * Date: 2018年2月4日 下午8:49:50 <br/>
 * 
 * @author thinkpad
 * @version
 * @see
 */
@Service
public class ClassService {

    public List<Clazz> list(ClassTimeRo ctRo) {
        List<Clazz> list = new ArrayList<>();
        list.add(new Clazz("1", "DT51", 30));
        list.add(new Clazz("2", "DT52", 30));
        list.add(new Clazz("3", "DT53", 30));
        list.add(new Clazz("4", "DT54", 30));
        list.add(new Clazz("5", "DT55", 30));
        list.add(new Clazz("6", "DT56", 30));
        list.add(new Clazz("7", "DT57", 30));
        list.add(new Clazz("8", "DT58", 30));

        return list;
    }
}
