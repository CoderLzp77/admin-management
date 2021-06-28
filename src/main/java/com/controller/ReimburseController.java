package com.controller;

import com.pojo.Vo.ReimbursementVo;
import com.service.ReimburseService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Reimburse")
@CrossOrigin
public class ReimburseController {
    @Autowired
    private R r;
    @Autowired
    private ReimburseService reimburseService;
    @PostMapping(value = "/AddReimburse")
    public R AddReimburse(@RequestBody ReimbursementVo reimbursementVo){
    return r.success(reimburseService.AddReimburse(reimbursementVo));
    }
    @GetMapping(value = "queryAllReim")
    public R queryAllReim(){
        return r.success(reimburseService.queryAllReim());
    }
}
