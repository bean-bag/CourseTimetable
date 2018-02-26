/**
 * Project Name:CourseTimetable
 * File Name:ClassRoom.java
 * Package Name:cn.bdqn.project.timetable.vo
 * Date:2018年1月31日上午8:31:03
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.timetable.vo;

/**
 * Description: 教室 <br/>
 * Date: 2018年1月31日 上午8:31:03 <br/>
 * 
 * @author thinkpad
 * @version
 * @see
 */
public class ClassRoom extends Info {

    
    private ClassTime[] classTimes = new ClassTime[3];
    /**
     * 教室能容纳人数
     */
    private int capacity;

    /**
     * 能否联网
     */
    private boolean networked;

    /**
     * 能否组局域网
     */
    private boolean lan;

    public ClassRoom(String id, String name, int capacity, boolean networked, boolean lan) {
        super(id, name);
        this.capacity = capacity;
        this.networked = networked;
        this.lan = lan;
    }

    public ClassTime[] getClassTimes() {
        return classTimes;
    }

    public void setClassTimes(ClassTime[] classTime) {
        this.classTimes = classTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isNetworked() {
        return networked;
    }

    public boolean isLan() {
        return lan;
    }

    public void setClassTime(ClassTime classTime) {
        
        //TODO bjw this.classTimes[classTime.get] = classTime;
        
    }

}
