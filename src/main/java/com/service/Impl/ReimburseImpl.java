//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.service.Impl;

import com.dao.ReimbursementContentDao;
import com.dao.ReimbursementDao;
import com.dao.ReimbursementSubjectsDao;
import com.pojo.Expenseitem;
import com.pojo.Reimbursement;
import com.pojo.Reimbursementcontent;
import com.pojo.Reimbursementsubjects;
import com.pojo.Vo.ReimbursementSubVo;
import com.pojo.Vo.ReimbursementVo;
import com.service.ExpenseItemService;
import com.service.ReimburseService;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReimburseImpl implements ReimburseService {
    @Autowired
    private ReimbursementDao reimbursementDao;
    @Autowired
    private ExpenseItemService expenseItemService;
    @Autowired
    private ReimbursementSubjectsDao reimbursementSubjectsDao;
    @Autowired
    private ReimbursementContentDao reimbursementContentDao;

    public ReimburseImpl() {
    }

    @Transactional
    public int AddReimburse(ReimbursementVo reimbursementVo) {
        Expenseitem expenseitem = new Expenseitem();
        expenseitem.setRemark(reimbursementVo.getRemark());
        expenseitem.setContentId(reimbursementVo.getContentId());
        expenseitem.setConsumeTime(reimbursementVo.getConsumeTime());
        expenseitem.setCost(reimbursementVo.getCost());
        expenseitem.setApplicant(reimbursementVo.getApplicant());
        List<Integer> collect = reimbursementDao.queryAllReim().stream().map(Reimbursement::getReimId).collect(Collectors.toList());
        if (collect.contains(reimbursementVo.getApplicant())) {
            return this.expenseItemService.AddExpenseItem(expenseitem);
        } else {
            Reimbursement reimbursement = new Reimbursement();
            reimbursement.setApplyTime(new Date());
            reimbursement.setState(0);
            reimbursement.setApprovalId(reimbursementVo.getApprovalId());
            reimbursement.setApplicant(reimbursementVo.getApplicant());
            reimbursement.setSubjectId(reimbursementVo.getSubjectId());
            reimbursement.setTotalAmount(reimbursementVo.getTotalAmount());
            int i = this.expenseItemService.AddExpenseItem(expenseitem);
            return i > 0 ? this.reimbursementDao.AddReimburse(reimbursement) : -1;
        }
    }

    @Override
    public List<Reimbursement> queryAllReim() {
        return reimbursementDao.queryAllReim();
    }

    @Override
    public int AddReimbursementSub(ReimbursementSubVo reimbursementSubVo) {
        Reimbursementcontent  reimbursementcontent=new Reimbursementcontent();
        reimbursementcontent.setSubjectId(reimbursementSubVo.getSubjectId());
        reimbursementcontent.setContentName(reimbursementSubVo.getContentName());
        Reimbursementsubjects reimbursementsubjects=new Reimbursementsubjects();
        reimbursementsubjects.setSubjectName(reimbursementSubVo.getSubjectName());
        List<Reimbursementsubjects> reimbursementsubjects1 = reimbursementSubjectsDao.queryAllSub();
        List<String> collect = reimbursementsubjects1.stream().map(Reimbursementsubjects::getSubjectName)
        .collect(Collectors.toList());
        if (collect.contains(reimbursementSubVo.getSubjectName())){
           return reimbursementContentDao.AddReimbursementContent(reimbursementcontent);
        }else {
            int i = reimbursementSubjectsDao.AddReimbursementSubjects(reimbursementsubjects);
            return i>0? reimbursementContentDao.AddReimbursementContent(reimbursementcontent):-1;
        }
    }

    @Override
    public List<Reimbursementsubjects> queryAllSub() {
        return reimbursementSubjectsDao.queryAllSub();
    }

    @Override
    public List<Reimbursement> queryApprove() {
        return reimbursementDao.queryApprove();
    }

    @Override
    public List<Reimbursement> queryReimById(int id) {
        return reimbursementDao.queryReimById(id);
    }

    @Override
    public List<Reimbursement> queryMyReim(Integer state,Integer subjectId,Integer totalAmount,int applicant) {
        return reimbursementDao.queryMyReim(state, subjectId, totalAmount, applicant);
    }


}
