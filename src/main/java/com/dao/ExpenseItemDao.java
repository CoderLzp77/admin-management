package com.dao;

import com.pojo.Expenseitem;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseItemDao {
    int ExpenseItemInfo(Expenseitem expenseItem);
}
