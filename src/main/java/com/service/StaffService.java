package com.service;

import com.pojo.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> queryStaffById(int id, Integer pageNum, Integer pageSize);

    List<Staff> queryAll();

    List<Staff> Approve();
}
