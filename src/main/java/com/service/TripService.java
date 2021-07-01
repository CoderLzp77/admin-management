package com.service;

import com.pojo.Trip;
import com.pojo.TripInfo;
import com.pojo.Vo.TripVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TripService {
    List<Trip> queryAllTrip(Integer pageNum,Integer pageSize);

    List<TripInfo> queryTripInfoById(int id);

    List<Trip> queryApproveTrip();

    int AddTrip(TripVo tripVo);

    List<Trip> querySubordinateTrip(@Param("state")Integer state,
                                    @Param("category") String category,
                                    @Param("duration") Integer duration);
}
