//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.service;

import com.pojo.Reimbursement;
import com.pojo.Reimbursementsubjects;
import com.pojo.Vo.ReimbursementSubVo;
import com.pojo.Vo.ReimbursementVo;
import java.util.List;

public interface ReimburseService {
    /**
     * 添加报销申请
     */
    int AddReimburse(ReimbursementVo reimbursementVo);

    /**
     * 查询所有报销信息详情
     */
    List<Reimbursement> queryAllReim();

    /**
     *添加报销科目
     */
    int AddReimbursementSub(ReimbursementSubVo reimbursementSubVo);

    /**
     * 查询所有报销科目
     */
    List<Reimbursementsubjects> queryAllSub();

    /**
     * 查询所有未审批报销
     */
    List<Reimbursement> queryApprove();

    /**
     * 通过id查询报销信息
     */
    List<Reimbursement> queryReimById(int id);

    List<Reimbursement> queryMyReim(Integer state,Integer subjectId,Integer totalAmount,int applicant);
}
