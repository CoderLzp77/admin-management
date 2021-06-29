package com.dao;

import com.pojo.Attendance;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AttendanceDao {
    /**
     * 个人考勤查看
     * 日查询
     */
    //查看个人的日考勤情况
    List<Attendance> queryAttendanceDay(int staffId, Integer pageNum, Integer pageSize);
    //查看个人的日考勤情况按选择的时间来查
    List<Attendance> queryAttendanceDayByTime(int staffId, Date date, Integer pageNum, Integer pageSize);
    /**
     * 月查询
     */
    //查看个人的月考勤情况按选择的时间来查
    List<Attendance> queryAttendanceMonthByTime(int staffId, Date stratTime, Date endTime, Integer pageNum, Integer pageSize);
    //查考勤单表（补充按月查service）
    List<Attendance> queryAttendanceAll(int staffId, Date stratTime, Date endTime, Integer pageNum, Integer pageSize);
}
