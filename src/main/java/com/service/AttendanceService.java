package com.service;

import com.pojo.Attendance;
import com.pojo.Vo.AttendanceVo1;

import java.util.Date;
import java.util.List;

public interface AttendanceService {
    /**
     * 个人考勤查看
     * 日查询
     */
    //查看个人的日考勤情况
    List<Attendance> queryAttendanceDay(int staffId, Integer pageNum, Integer pageSize);
    //查看个人的日考勤情况按选择的时间来查
    List<Attendance> queryAttendanceDayByTime(int staffId,Date date, Integer pageNum, Integer pageSize);
    /**
     * 月查询
     */
    //查看个人的月考勤情况按选择的时间来查
    AttendanceVo1 queryAttendanceMonthByTime(int staffId, Date time, Integer pageNum, Integer pageSize);

}
