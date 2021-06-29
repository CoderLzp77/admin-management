package com.service.Impl;

import com.dao.AskforLeaveDao;
import com.pojo.Askforleave;
import com.service.AskforleaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AskforleaveServiceImpl implements AskforleaveService {
    @Autowired
    private AskforLeaveDao askforleaveDao;
    /**
     * 请假情况
     */
    //所有请假记录
    @Override
    public List<Askforleave> queryAskforleaveAll(int id,Integer pageNum, Integer pageSize) {
        return askforleaveDao.queryAskforleaveAll(id, (pageNum-1)*pageSize, pageSize);
    }
    //查看该月的请假记录
    @Override
    public List<Askforleave> queryAskforleaveAllByTime(int id, Date year,Integer pageNum, Integer pageSize) {
        Date date1;
        Calendar cal = Calendar.getInstance();
        cal.setTime(year);
        date1=cal.getTime();
        cal.add(Calendar.MONTH, 1);
        Date date2 = new Date();
        date2=cal.getTime();
        return askforleaveDao.queryAskforleaveAllByTime(id,date1,date2,(pageNum-1)*pageSize,pageSize);
    }


}
