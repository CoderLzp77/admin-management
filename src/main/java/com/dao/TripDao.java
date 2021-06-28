package com.dao;

import com.pojo.Trip;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface TripDao {
    List<Trip> queryAllTrip();

    List<Trip> queryApproveTrip();
}
