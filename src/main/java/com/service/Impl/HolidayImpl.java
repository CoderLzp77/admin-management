package com.service.Impl;

import com.dao.HolidayDao;
import com.pojo.Holidays;
import com.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class HolidayImpl implements HolidayService {
    @Autowired
    private HolidayDao holidayDao;
    @Override
    public List<Holidays> queryHolidayTime(Integer pageNum,Integer pageSize) {
        return holidayDao.queryHolidayTime(pageNum, pageSize);
    }

    @Override
    public List<Holidays> queryHolidayAllTime(Integer pageNum, Integer pageSize) {
        return holidayDao.queryHolidayAllTime((pageNum-1)*pageSize,pageSize);
    }
    //查看该年假期
    @Override
    public List<Holidays> queryHolidayTimeByYear(Date year, Integer pageNum, Integer pageSize) {
        Date date1 = new Date();
        Long stratTime= year.getTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(year);
        date1=cal.getTime();
        cal.add(Calendar.YEAR, 1);
        Date date2 = new Date();
        date2=cal.getTime();
        return holidayDao.queryHolidayTimeByYear(date1,date2,(pageNum-1)*pageSize,pageSize);
    }
    //添加假期
    @Override
    @Transactional
    public int addHolidayTimeByTime(Holidays holidays) {
        return holidayDao.addHolidayTimeByTime(holidays);
    }
    //删除假期
    @Override
    @Transactional
    public int delectHolidayTimeById(int id) {
        return holidayDao.delectHolidayTimeById(id);
    }

}
