package com.service;

import com.pojo.Job;

import java.util.List;

public interface JobService {
    /**
     * 岗位信息
     */

    //通过staffId查询员工的职位
    Job queryJobById(int jobId);

    //查询所有工作岗位
    List<Job> queryJobLimit(int pageNum);

    //添加工作岗位
    int addNewJob(Job newJob);

    //根据ID删除工作岗位
    int deleteJobById(int jobId);

    //修改工作岗位
    int updateJob(Job job);
}
