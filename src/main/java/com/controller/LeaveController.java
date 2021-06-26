package com.controller;

import com.pojo.Askforleave;
import com.service.LeaveService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Leave")
@CrossOrigin
public class LeaveController {
    @Autowired
    private R r;
    @Autowired
    private LeaveService leaveService;
    @PostMapping("/InsertLeave")
    public R insert(@RequestBody Askforleave askforleave){
        return leaveService.InsertLeave(askforleave) > 0 ? r.success() : r.error();
    }
    @PutMapping("/updateStateById")
    public R updateStateById(@RequestParam(value = "state") Integer state,
                             @RequestParam(value = "id") Integer id){
        return leaveService.updateById(state,id) > 0 ? r.success() : r.error();
    }
    @GetMapping("/queryAllLeave")
    public R queryAllLeave(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        List<Askforleave> askforleaves = leaveService.queryAllLeave();
        List<Askforleave> collect = askforleaves.stream().skip((long) (pageNum - 1) * pageSize)
        .limit(pageSize).collect(Collectors.toList());
        return r.success(collect);
    }
    @GetMapping("/queryApprove")
    public R queryApprove(){
        return r.success(leaveService.queryApprove());
    }
}
