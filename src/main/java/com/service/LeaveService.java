package com.service;

import com.pojo.Askforleave;

import java.util.List;

public interface LeaveService {
    int InsertLeave(Askforleave askforleave);

    int updateById(int state,int id);

    List<Askforleave> queryAllLeave();

    List<Askforleave> queryApprove();
}
