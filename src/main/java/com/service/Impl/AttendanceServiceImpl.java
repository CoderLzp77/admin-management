package com.service.Impl;

import com.dao.AttendanceDao;
import com.pojo.Attendance;
import com.pojo.Vo.AttendanceVo;
import com.pojo.Vo.AttendanceVo1;
import com.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceDao attendanceDao;
    /**
     * 个人考勤查看
     * 日查询
     */
    //查看个人的日考勤情况
    @Override
    public List<Attendance> queryAttendanceDay(int staffId, Integer pageNum, Integer pageSize) {
        return attendanceDao.queryAttendanceDay(staffId,(pageNum-1)*pageSize,pageSize);
    }
    //查看个人的日考勤情况按选择的时间来查
    @Override
    public List<Attendance> queryAttendanceDayByTime(int staffId, Date date, Integer pageNum, Integer pageSize) {
        return attendanceDao.queryAttendanceDayByTime(staffId,date,(pageNum-1)*pageSize,pageSize);
    }

    /**
     * 月查询
     */
    //查看个人的月考勤情况按选择的时间来查
    @Override
    public AttendanceVo1 queryAttendanceMonthByTime(int staffId, Date time, Integer pageNum, Integer pageSize) {
        ArrayList<AttendanceVo> attendanceVos = new ArrayList<>();
        Date date1 = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        date1=cal.getTime();
        cal.add(Calendar.MONTH, 1);
        Date date2 = new Date();
        date2=cal.getTime();
        List<Attendance> attendances =attendanceDao.queryAttendanceMonthByTime(staffId, date1, date2, (pageNum - 1) * pageSize, pageSize);
        Map<Date,Integer> map = new HashMap<>();
        for (int i = 0; i < attendances.size(); i++) {
            Attendance attendance = attendances.get(i);
            Date dateId = attendance.getDateId();
            map.put(dateId,attendance.getClockintimeList().size());
        }
        List<Attendance> attendances1 = attendanceDao.queryAttendanceAll(staffId, date1, date2, (pageNum - 1) * pageSize, pageSize);
        for (int i = 0; i < attendances1.size(); i++) {
            if(map.get(attendances1.get(i).getDateId())!=null){
                attendanceVos.add(new AttendanceVo(attendances1.get(i).getDateId(),map.get(attendances1.get(i).getDateId()),attendances1.get(i).getCheckInTime(),attendances1.get(i).getSignOutTime(),attendances1.get(i).getRemark()));
            }else {
                attendanceVos.add(new AttendanceVo(attendances1.get(i).getDateId(),0,attendances1.get(i).getCheckInTime(),attendances1.get(i).getSignOutTime(),attendances1.get(i).getRemark()));
            }
        }
        int outSum=0,askForLeaveSum=0,trip=0,holidaysSum=0,atTimeSum=0;
        for (AttendanceVo attendanceVo : attendanceVos) {
            Date dateId = attendanceVo.getDateId();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String s = simpleDateFormat.format(dateId);
            String s1=s+" 09:00:00",s2=s+" 17:00:00";
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start=new Date();
            Date end=new Date();
            try {
                start = simpleDateFormat1.parse(s1);
                end = simpleDateFormat1.parse(s2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (attendanceVo.getClockSum()==0){
                if(attendanceVo.getRemark().equals("请假")){
                    askForLeaveSum++;
                }else if(attendanceVo.getRemark().equals("出差")){
                    trip++;
                }else if(attendanceVo.getRemark().equals("假期")){
                    holidaysSum++;
                }
            }else{
                if(attendanceVo.getCheckInTime().compareTo(start)>=0 || attendanceVo.getSignOutTime().compareTo(end)<=0){
                    outSum++;
                }else{
                    atTimeSum++;
                }
            }

        }
        AttendanceVo1 attendanceVo1 = new AttendanceVo1();
        attendanceVo1.setAttendanceVos(attendanceVos);
        attendanceVo1.setAskForLeaveSum(askForLeaveSum);
        attendanceVo1.setAtTimeSum(atTimeSum);
        attendanceVo1.setHolidaysSum(holidaysSum);
        attendanceVo1.setOutSum(outSum);
        attendanceVo1.setTrip(trip);

        return attendanceVo1;
    }

}
