package com.service;

import com.pojo.Askforleave;

import java.util.List;

public interface LeaveService {
    /**
     * 新增请假
     * @param askforleave
     * @return
     */
    int InsertLeave(Askforleave askforleave);

    /**
     * 更新状态
     * @param state
     * @param id
     * @return
     */
    int updateById(int state,int id);

    /**
     * 查询所有请假
     * @return
     */
    List<Askforleave> queryAllLeave();

    /**
     * 查询所有未批准
     * @return
     */
    List<Askforleave> queryApprove();

    /**
     *
     * @param staffId
     * @return
     */
    List<Askforleave> queryMyAcc(int staffId);

    List<Askforleave> queryMyAsk(int staffId);

    List<Askforleave> queryOrgAsk();

    List<Askforleave> queryMyEmpAsk(int staffId);

}
