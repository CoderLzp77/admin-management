
package com.dao;

import com.pojo.TripInfo;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface TripInfoDao {
    List<TripInfo> queryTripInfoById(int var1);
}
