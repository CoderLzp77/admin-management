package com.dao;

import com.pojo.Job;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {
    List<Job> queryAll();
}
