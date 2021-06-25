package com.service.Impl;

import com.dao.AskforLeaveDao;
import com.pojo.Askforleave;
import com.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private AskforLeaveDao askforLeaveDao;
    @Override
    @Transactional
    public int queryStaff(Askforleave askforleave) {
        return askforLeaveDao.queryStaff(askforleave);
    }
}
