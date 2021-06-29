package com.controller;

import com.service.AttendanceService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping(value = "Attendance")
@CrossOrigin
@Controller
@ResponseBody
public class AttendanceController {
    @Autowired
    private R r;
    @Autowired
    private AttendanceService attendanceService;

    /**
     * 个人考勤查看
     * 日查询
     */
    //查看个人的日考勤情况
    @GetMapping("/queryAttendanceDay")
    public R queryAttendanceDay(@RequestParam(value = "staffId") int staffId,
                                @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize){
        return r.success(attendanceService.queryAttendanceDay(staffId,pageNum,pageSize));
    }

    //查看个人的日考勤情况按选择的时间来查
    @GetMapping("queryAttendanceDayByTime")
    public R queryAttendanceDayByTime(@RequestParam(value = "staffId") int staffId,
                                      @RequestParam(value = "date")Date date,
                                      @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize){
        return r.success(attendanceService.queryAttendanceDayByTime(staffId, date, pageNum, pageSize));
    }
    /**
     * 月查询
     */
    //查看个人的月考勤情况按选择的时间来查
    @GetMapping("queryAttendanceMonthByTime")
    public R queryAttendanceMonthByTime(@RequestParam(value = "staffId") int staffId,
                                      @RequestParam(value = "date")Date date,
                                      @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize){
        return r.success(attendanceService.queryAttendanceMonthByTime(staffId, date, pageNum, pageSize));
    }
}
