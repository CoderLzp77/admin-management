package com.dao;

import com.pojo.Reimbursementcontent;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementContentDao {
    int AddReimbursementContent(Reimbursementcontent reimbursementcontent );
}
