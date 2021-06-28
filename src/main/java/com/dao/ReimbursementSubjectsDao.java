package com.dao;

import com.pojo.Reimbursementsubjects;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReimbursementSubjectsDao {
    int AddReimbursementSubjects(Reimbursementsubjects reimbursementSubjects);

    @Select(value = "select * from reimbursementsubjects")
    List<Reimbursementsubjects> queryAllSub();
}
