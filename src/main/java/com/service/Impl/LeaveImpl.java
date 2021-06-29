package com.service.Impl;

import com.dao.AskforLeaveDao;
import com.pojo.Askforleave;
import com.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LeaveImpl implements LeaveService {
    @Autowired
    private AskforLeaveDao askforLeaveDao;
    @Override
    @Transactional
    public int InsertLeave(Askforleave askforleave) {
        return askforLeaveDao.InsertLeave(askforleave);
    }

    @Override
    @Transactional
    public int updateById(int state, int id) {
        return askforLeaveDao.updateStateById(state,id);
    }

    @Override
    public List<Askforleave> queryAllLeave() {
        return askforLeaveDao.queryAllLeave();
    }

    @Override
    public List<Askforleave> queryApprove() {
        return askforLeaveDao.queryApprove();
    }

    @Override
    public List<Askforleave> queryMyAcc(int staffId) {
        return askforLeaveDao.queryMyAcc(staffId);
    }

    @Override
    public List<Askforleave> queryMyAsk(int staffId) {
        return askforLeaveDao.queryMyAsk(staffId);
    }

    @Override
    public List<Askforleave> queryOrgAsk() {
        return askforLeaveDao.queryOrgAsk();
    }

    @Override
    public List<Askforleave> queryMyEmpAsk(int staffId) {
        return askforLeaveDao.queryMyEmpAsk(staffId);
    }
}
