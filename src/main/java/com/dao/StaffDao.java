package com.dao;

import com.pojo.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffDao {
    /**
     * 通过员工id查询员工所有信息以及请假信息和直属部门
     */
    List<Staff> queryStaffById(int id,int pageNum,int pageSize);

    /**
     * 查询员工信息岗位部门请假总接口
     */
    List<Staff> queryAll(@Param("userName") String userName);

    /**
     * 查询未批准假期
     */
    List<Staff> queryApprove();

    /**
     * 登录验证
     */
    Staff queryUserAndPass(String username ,String password);

    /**
     * 更新token
     */
    int updateToken(String token, int id);

    /**
     * 多条件查询请假信息
     */
    List<Staff> queryMyLeave(@Param("state")Integer state,
                             @Param("category") String category,
                             @Param("duration") Integer duration);

    /**
     * 添加新员工
     */
    int addNewStaff(Staff Staff);

    /**
     * 重置密码
     */
    int rePassword(int staffId);

    /**
     * 删除员工
     */
    int deleteStaffById(int staffId);

    /**
     * 添加新员工
     */
    int updateStaffInfo(Staff staff);

    List<Staff> queryStaffSub(@Param("staffId") int staffId,
                              @Param("pageNum") Integer pageNum,
                              @Param("pageSize") Integer pageSize);
}
