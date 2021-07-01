package com.service;

import com.pojo.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StaffService {

    List<Staff> queryStaffById(int id, Integer pageNum, Integer pageSize);

    List<Staff> queryAll(String userName);

    /**
     * 查询未批准请假
     */
    List<Staff>  queryApprove();

    /**
     * 上传头像
     */
    String changeAvatar(MultipartFile file) throws IOException;


    Staff queryUserAndPass(String username ,String password);


    int updateToken(String token, int id);

    List<Staff> queryMyLeave(@Param("state")Integer state,
                             @Param("category") String category,
                             @Param("duration") Integer duration);

    int addNewStaff(Staff staff);

    int rePassword(int staffId);

    int deleteStaffById(int staffId);

    int updateStaffInfo(Staff staff);

    List<Staff> queryStaffSub(int staffId,Integer pageNum,Integer pageSize);
}
