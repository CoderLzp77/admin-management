package com.service.Impl;

import com.dao.ScheduleDao;
import com.pojo.Schedule;
import com.service.ScheduleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheduleImpl implements ScheduleService {
    @Autowired
    private ScheduleDao scheduleDao;

    public ScheduleImpl() {
    }

    @Transactional
    public int AddSchedule(List<Schedule> schedules) {
        return this.scheduleDao.AddSchedule(schedules);
    }
}
