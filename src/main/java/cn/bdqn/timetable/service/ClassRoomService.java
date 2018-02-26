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

import cn.bdqn.timetable.vo.ClassRoom;

/**
 * Description:   <br/>
 * Date:     2018年2月4日 下午8:49:50 <br/>
 * @author   thinkpad
 * @version
 * @see
 */
@Service
public class ClassRoomService {

    public List<ClassRoom> list(){
        List<ClassRoom> list = new ArrayList<>();
        list.add(new ClassRoom("1","一教室",30,false,false));
        list.add(new ClassRoom("2","二教室",30,false,false));
        list.add(new ClassRoom("3","三教室",30,false,false));
        list.add(new ClassRoom("4","四教室",30,false,false));
        list.add(new ClassRoom("5","五教室",30,false,false));
        list.add(new ClassRoom("6","六教室",30,false,false));
        list.add(new ClassRoom("7","七教室",30,false,false));
        list.add(new ClassRoom("8","八教室",30,false,false));
        
        return list;
    }
}

