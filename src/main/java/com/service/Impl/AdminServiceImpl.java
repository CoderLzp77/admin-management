package com.service.Impl;

import com.dao.AdminDao;
import com.pojo.Job;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public List<Job> queryAll() {

        return adminDao.queryAll();
    }
}
