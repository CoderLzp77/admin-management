package com.service;

import com.pojo.Staff;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StaffService {
    /**
     * 通过id查询员工请假信息
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Staff> queryStaffById(int id, Integer pageNum, Integer pageSize);

    /**
     * 查询所有员工请假信息
     * @return
     */
    List<Staff> queryAll();

    /**
     * 查询未批准请假
     * @return
     */
    List<Staff>  queryApprove();

    /**
     * 上传头像
     * @param file
     * @return
     * @throws IOException
     */
    String changeAvatar(MultipartFile file) throws IOException;

    /**
     * 验证登录
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

    List<Staff> queryMyLeave(@Param("state")Integer state,
                             @Param("category") String category,
                             @Param("duration") Integer duration);
}
