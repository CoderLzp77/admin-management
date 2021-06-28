//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dao;

import com.pojo.Reimbursement;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementDao {
  int AddReimburse(Reimbursement var1);

  List<Reimbursement> queryAllReim();

  List<Reimbursement> queryApprove();

  List<Reimbursement> queryReimById(int id);
}
