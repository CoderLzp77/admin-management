//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.service;

import com.pojo.Reimbursement;
import com.pojo.Vo.ReimbursementVo;
import java.util.List;

public interface ReimburseService {
    int ReimburseInfo(ReimbursementVo var1);

    List<Reimbursement> queryAllReim();
}