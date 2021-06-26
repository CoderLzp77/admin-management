package com.service.Impl;

import com.dao.ReimbursementDao;
import com.pojo.Reimbursement;
import com.service.ReimburseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReimburseImpl implements ReimburseService {
    @Autowired
    private ReimbursementDao reimbursementDao;

    @Override
    public int ReimburseInfo(Reimbursement reimbursement) {
        return reimbursementDao.ReimbursementApply(reimbursement);
    }
}
