package com.controller;

import com.pojo.Reimbursement;
import com.pojo.Vo.ReimbursementSubVo;
import com.pojo.Vo.ReimbursementVo;
import com.service.ReimburseService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public R queryAllReim(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "pageSize",defaultValue = "1") Integer pageSize){
        List<Reimbursement> reimbursements = reimburseService.queryAllReim();
        List<Reimbursement> collect = reimbursements.stream().
        skip((long) (pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        return r.success(collect);
    }
    @PostMapping(value = "/AddReimbursementSub")
    public R AddReimbursementSub(@RequestBody ReimbursementSubVo reimbursementSubVo){
        int i = reimburseService.AddReimbursementSub(reimbursementSubVo);
        return i>0? r.success():r.error();
    }
    @GetMapping(value = "/queryAllSub")
    public R queryAllSub(){
        return r.success(reimburseService.queryAllSub());
    }
    @GetMapping(value = "/queryApprove")
    public R queryApprove(){
        return r.success(reimburseService.queryApprove());
    }
    @GetMapping(value = "/queryReimById")
    public R queryReimById(@RequestParam(value = "id") int id){
        return  r.success(reimburseService.queryReimById(id));
    }
    @GetMapping(value = "/queryMyReim")
    public R queryMyReim(@RequestParam(value = "state",required = false) Integer state,
                         @RequestParam(value = "subjectId",required = false) Integer subjectId,
                         @RequestParam(value = "totalAmount",required = false) Integer totalAmount,
                         @RequestParam(value = "applicant") int applicant){
        return r.success(reimburseService.queryMyReim(state, subjectId, totalAmount,applicant));
    }

}
