package com.dao;

import com.pojo.Job;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobDao {
    //通过staffId查询员工的职位
    Job queryJobById(int jobId);

    //通过职位名称查询工作的工号
    int queryJobId(String jobName);

    //查询所有工作岗位
    List<Job> queryJobLimit(int pageNum);

    //添加工作岗位
    int addNewJob(Job newJob);

    //根据ID删除工作岗位
    int deleteJobById(int jobId);

    //修改工作岗位
    int updateJob(Job job);
}
