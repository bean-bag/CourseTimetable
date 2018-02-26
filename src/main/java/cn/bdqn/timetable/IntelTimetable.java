/**
 * Project Name:CourseTimetable
 * File Name:Course.java
 * Package Name:cn.bdqn.project.timetable
 * Date:2018年1月31日上午8:21:00
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.bdqn.timetable;

import java.util.Date;

import cn.bdqn.timetable.vo.ClassRoom;
import cn.bdqn.timetable.vo.Clazz;
import cn.bdqn.timetable.vo.Resource;
import cn.bdqn.timetable.vo.TimetableData;

/**
 * Description: 自动排课 <br/>
 * Date: 2018年1月31日 上午8:21:00 <br/>
 * 
 * @author thinkpad
 * @version
 * @see
 * 
 *      排课要素：<br>
 *      1、教室<br>
 *      2、班级<br>
 *      3、老师<br>
 *      4、课程<br>
 *      <br>
 *      排课规则控制：<br>
 *      1、优先级控制<br>
 *      2、约定控制<br>
 *      3、调整级控制<br>
 *      <br>
 *      排课结果：<br>
 *      1、班次<br>
 *      2、天课表<br>
 *      3、周课表<br>
 * 
 * 
 */
public class IntelTimetable {

    /**
     * out:周排课数据
     */
    private TimetableData weekClassTime;

    private Resource resource;
    
    //private List<Rule> rules;

    public IntelTimetable(Resource resource, Date firstDate, int period) {
        this.resource = resource;
        this.weekClassTime = new TimetableData(period, resource.getRooms().length);

        this.init();
    }

    /**
     * 初始化操作 Description: <br/>
     *
     * @author thinkpad
     */
    private void init() {
        // 1、对班按人数排序
        // TODO bjw
        // 2、加载默认规则
        //this.rules = new ArrayList<>();
        // 3、处理事前排课要求

    }

    public void execute() {
        // 按周循环，先排每天的课
        for (int i = 0; i < this.resource.getPeriod(); i++) {
            this.executeByDate(i);
        }
    }

    /**
     * 按天排课 Description: <br/>
     *
     * @author thinkpad
     * @param date
     */
    private void executeByDate(int dayOfweek) {
        for (int i = 0; i < this.resource.getRooms().length; i++) {
            executeByRoom(dayOfweek, i);
        }
    }

    /**
     * 按教室排课 Description: <br/>
     *
     * @author thinkpad
     * @param room
     */
    private boolean executeByRoom(int dayOfweek, int roomIndex) {
        for (int i = 0; i < this.resource.getClasses().length; i++) {
            if (accept(resource.getRoom(roomIndex), resource.getClass(i))) {
                this.weekClassTime.put(dayOfweek, roomIndex, i);
                return true;
            }
        }
        return false;
    }

    private boolean accept(ClassRoom room, Clazz clazz) {
        return (room.getCapacity() >= clazz.getNum());

    }

    public TimetableData getWeekClassTime() {
        return weekClassTime;
    }

}
