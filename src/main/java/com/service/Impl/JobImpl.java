package com.service.Impl;

import com.dao.JobDao;
import com.pojo.Job;
import com.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobImpl implements JobService {

    @Autowired
    private JobDao adminJobDao;

    @Override
    public Job queryJobById(int jobId) {
        return adminJobDao.queryJobById(jobId);
    }

    @Override
    public List<Job> queryJobLimit(int pageNum) {
        return adminJobDao.queryJobLimit((pageNum-1)*5);
    }

    @Override
    @Transactional
    public int addNewJob(Job newJob) {
        return adminJobDao.addNewJob(newJob);
    }

    @Override
    @Transactional
    public int deleteJobById(int jobId) {
        return adminJobDao.deleteJobById(jobId);
    }

    @Override
    @Transactional
    public int updateJob(Job job) {
        return adminJobDao.updateJob(job);
    }
}
