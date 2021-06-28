package com.dao;

import com.pojo.Schedule;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleDao {
    int AddSchedule(List<Schedule> var1);
}
