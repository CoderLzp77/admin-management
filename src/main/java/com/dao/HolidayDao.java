package com.dao;

import com.pojo.Holidays;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HolidayDao {
    List<Holidays> queryHolidayTime();
    //查看全部假期
    List<Holidays> queryHolidayAllTime(Integer pageNum, Integer pageSize);
    //查看该年假期
    List<Holidays> queryHolidayTimeByYear(Date stratTime, Date endTime, Integer pageNum, Integer pageSize);
    //添加假期
    int addHolidayTimeByTime(Holidays holidays);
    //删除假期
    int delectHolidayTimeById(int id);
}
