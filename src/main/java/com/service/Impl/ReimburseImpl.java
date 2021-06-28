//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.service.Impl;

import com.dao.ReimbursementDao;
import com.pojo.Expenseitem;
import com.pojo.Reimbursement;
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

    public ReimburseImpl() {
    }

    @Transactional
    public int ReimburseInfo(ReimbursementVo reimbursementVo) {
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
            return i > 0 ? this.reimbursementDao.ReimbursementApply(reimbursement) : -1;
        }
    }

    public List<Reimbursement> queryAllReim() {
        return this.reimbursementDao.queryAllReim();
    }
}
