package com.dao;

import com.pojo.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffDao {
    /**
     * @paramid
     * @return
     * 通过员工id查询员工所有信息以及请假信息和直属部门
     */
    List<Staff> queryStaffById(int id,int pageNum,int pageSize);

    List<Staff> queryAll();
}
