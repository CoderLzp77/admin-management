package com.service;

import com.pojo.Trip;
import com.pojo.TripInfo;
import com.pojo.Vo.TripVo;
import java.util.List;

public interface TripService {
    List<Trip> queryAllTrip();

    List<TripInfo> queryTripInfoById(int id);

    List<Trip> queryApproveTrip();

    int AddTrip(TripVo tripVo);
}
