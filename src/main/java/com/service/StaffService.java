package com.service;

import com.pojo.Staff;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StaffService {
    List<Staff> queryStaffById(int id, Integer pageNum, Integer pageSize);

    List<Staff> queryAll();

    List<Staff>  queryApprove();

    String changeAvatar(MultipartFile file) throws IOException;

    Staff queryUserAndPass(String username ,String password);
}
