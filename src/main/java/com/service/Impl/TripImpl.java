
package com.service.Impl;

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

    public List<Trip> queryAllTrip() {
        return this.tripDao.queryAllTrip();
    }

    public List<TripInfo> queryTripInfoById(int id) {
        return tripInfoDao.queryTripInfoById(id);
    }

    public List<Trip> queryApproveTrip() {
        return tripDao.queryApproveTrip();
    }

    public int AddTrip(TripVo tripVo) {
        return 1;
    }
}
