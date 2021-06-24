package com.dao;

import com.pojo.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffDao {
    List<Staff> findById(int id);
}
