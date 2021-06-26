package com.service.Impl;

import com.dao.ExpenseItemDao;
import com.pojo.Expenseitem;
import com.pojo.Reimbursement;
import com.pojo.Vo.ReimbursementVo;
import com.service.ExpenseItemService;
import com.service.ReimburseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ExpenseItemImpl implements ExpenseItemService {
    @Autowired
    private ExpenseItemDao expenseItemDao;
    @Autowired
    private ReimburseService reimburseService;
    @Override
    public int ExpenseItemInfo(ReimbursementVo reimbursementVo) {
            Expenseitem expenseitem=new Expenseitem();
            expenseitem.setConsumeTime(reimbursementVo.getConsumeTime());
            expenseitem.setContentId(reimbursementVo.getContentId());
            expenseitem.setCost(reimbursementVo.getCost());
            expenseitem.setRemark(reimbursementVo.getRemark());
        if (expenseItemDao.ExpenseItemInfo(expenseitem)>0){
            Reimbursement reimbursement=new Reimbursement();
            reimbursement.setApplyTime(new Date());
            reimbursement.setState(0);
      /*      reimbursement.setTotalAmount();*/
           /* reimbursement.setApplicant(expenseItem.getReimId());*/
        }
        return 1;
    }
}
