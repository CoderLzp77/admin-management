package com.dao;

import com.pojo.Reimbursement;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementDao {
  int ReimbursementApply(Reimbursement reimbursement);
}
