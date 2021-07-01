
package com.service.Impl;

import com.dao.OtherConsumeDao;
import com.dao.ScheduleDao;
import com.dao.TripDao;
import com.dao.TripInfoDao;
import com.pojo.Trip;
import com.pojo.TripInfo;
import com.pojo.Vo.TripVo;
import com.service.TripService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripImpl implements TripService {
    @Autowired
    private TripDao tripDao;
    @Autowired
    private TripInfoDao tripInfoDao;
    @Autowired
    private ScheduleDao scheduleDao;
    @Autowired
    private OtherConsumeDao otherConsumeDao;

    public List<Trip> queryAllTrip(Integer pageNum,Integer pageSize) {
        return tripDao.queryAllTrip(pageNum, pageSize);
    }

    public List<TripInfo> queryTripInfoById(int id) {
        return tripInfoDao.queryTripInfoById(id);
    }

    public List<Trip> queryApproveTrip() {
        return tripDao.queryApproveTrip();
    }

    public int AddTrip(TripVo tripVo) {
        Trip trip=new Trip();
        trip.setApprovalId(tripVo.getApprovalId());
        trip.setCategory(tripVo.getCategory());
        trip.setReason(tripVo.getReason());
        trip.setDuration(tripVo.getDuration());
        trip.setEndTime(tripVo.getEndTime());
        trip.setStartTime(tripVo.getStartTime());
        trip.setAmount(tripVo.getAmount());
        trip.setState(0);
        int i = tripDao.AddTrip(trip);
        if (i>0){
            scheduleDao.AddSchedule(tripVo.getSchedules());
        }else {
            return -1;
        }
        return otherConsumeDao.AddOtherConsume(tripVo.getOtherconsumes());
    }

    @Override
    public List<Trip> querySubordinateTrip(Integer state, String category, Integer duration) {
        return tripDao.querySubordinateTrip(state, category, duration);
    }
}
