package com.dao;

import com.pojo.Staff;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 查询所有请假
     * @return
     */
    List<Staff> queryAll();

    /**
     * 查询所有未批准假期
     * @return
     */
    List<Staff> queryApprove();

    /**
     * 登录验证
     * @param username
     * @param password
     * @return
     */
    Staff queryUserAndPass(String username ,String password);

    /**
     * 更新token
     * @param token
     * @param id
     * @return
     */
    int updateToken(String token, int id);

    /**
     * 多条件查询请假信息
     * @param state
     * @param category
     * @param duration
     * @return
     */
    List<Staff> queryMyLeave(@Param("state")Integer state,
                             @Param("category") String category,
                             @Param("duration") Integer duration);
}
