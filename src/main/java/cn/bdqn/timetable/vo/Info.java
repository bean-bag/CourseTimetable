/**
 * Project Name:CourseTimetable
 * File Name:Info.java
 * Package Name:cn.bdqn.project.timetable.vo
 * Date:2018年1月31日上午8:38:09
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.timetable.vo;

/**
 * Description: 信息类抽象类 <br/>
 * Date: 2018年1月31日 上午8:38:09 <br/>
 * 
 * @author thinkpad
 * @version
 * @see
 */
public abstract class Info {

    /**
     * 唯一标识
     */
    private String id;

    /**
     * 显示名称
     */
    private String name;

    public Info(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
