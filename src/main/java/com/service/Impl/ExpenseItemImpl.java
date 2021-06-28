//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.service.Impl;

import com.dao.ExpenseItemDao;
import com.pojo.Expenseitem;
import com.service.ExpenseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseItemImpl implements ExpenseItemService {
    @Autowired
    private ExpenseItemDao expenseItemDao;

    public ExpenseItemImpl() {
    }

    public int AddExpenseItem(Expenseitem expenseitem) {
        return this.expenseItemDao.AddExpenseItem(expenseitem);
    }
}
