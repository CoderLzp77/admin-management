package com.dao;

import com.pojo.Trip;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TripDao {
    List<Trip> queryAllTrip(@Param(value = "pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    List<Trip> queryApproveTrip();

    int AddTrip(Trip trip);

    List<Trip> querySubordinateTrip(@Param("state")Integer state,
                                    @Param("category") String category,
                                    @Param("duration") Integer duration);
}
