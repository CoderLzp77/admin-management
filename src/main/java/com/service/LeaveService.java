package com.service;

import com.pojo.Askforleave;

public interface LeaveService {
    int queryStaff(Askforleave askforleave);

    int updateById(int state,int id);
}
