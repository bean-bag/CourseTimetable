/**
 * Project Name:CourseTimetable
 * File Name:Resource.java
 * Package Name:cn.bdqn.project.timetable.vo
 * Date:2018年1月31日下午2:35:08
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.timetable.vo;
/**
 * Description:   <br/>
 * Date:     2018年1月31日 下午2:35:08 <br/>
 * @author   thinkpad
 * @version
 * @see
 */
public class Resource {
    /**
     * in:教室信息数组
     */
    private ClassRoom[] rooms;

    /**
     * in:班级信息数组
     */
    private Clazz[] classes;

    /**
     * in:老师信息数组
     */
    private Teacher[] teachers;
    
    /**
     * 该期排课天数，默认一周时间（7天）
     */
    private int period = 7;


    public Resource(ClassRoom[] rooms, Clazz[] classes, Teacher[] teachers,int period) {
        this.rooms = rooms;
        this.classes = classes;
        this.teachers = teachers;
        this.period = period;        
    }


    public ClassRoom[] getRooms() {
        return rooms;
    }


    public Clazz[] getClasses() {
        return classes;
    }
    public ClassRoom getRoom(int index) {
        return rooms[index];
    }


    public Clazz getClass(int index) {
        return classes[index];
    }

    public Teacher[] getTeachers() {
        return teachers;
    }


    public int getPeriod() {
        return period;
    }

    
    
}

