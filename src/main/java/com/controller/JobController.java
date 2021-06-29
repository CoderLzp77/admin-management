package com.controller;

import com.pojo.Job;
import com.service.JobService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "Job")
@CrossOrigin
@RestController
public class JobController {
    @Autowired
    private R r;
    @Autowired
    private JobService jobService;
    @RequestMapping(value ="/AddJob",method = RequestMethod.POST)
    public R addNewStaff(@RequestBody Job job){
        int result = jobService.addNewJob(job);
        return result > 0 ? r.success():r.error();
    }
    //TODO 删除现有岗位功能
    @RequestMapping(value = "/DeleteJob/{jobId}",method = RequestMethod.DELETE)
    public R deleteStaff(@PathVariable("jobId") int jobId) {
        return r.success(jobService.deleteJobById(jobId));
    }
    @RequestMapping(value ="/UpdateJob",method = RequestMethod.PUT)
    public R updateJob(@RequestBody Job job) {

        int result = jobService.updateJob(job);
       return result > 0 ? r.success():r.error();
    }
    //TODO 分页展示员工信息功能
    @RequestMapping(value = "/ShwoJobInfoLimit",method = RequestMethod.GET)
    public R shwoJobInfo(@RequestParam("pageNum") Integer pageNum) {
        List<Job> job = jobService.queryJobLimit(pageNum);
        if (CollectionUtils.isEmpty(job)){
            return r.error();
        }
        return r.success(job);
    }
    //TODO 根据ID查询岗位功能
    @RequestMapping(value ="/ShowJobById",method = RequestMethod.GET)
    public R showJobById(@RequestBody int jobId) {
        return r.success(jobService.queryJobById(jobId));
    }
}
