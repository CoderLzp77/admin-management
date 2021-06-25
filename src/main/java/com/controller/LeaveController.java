package com.controller;

import com.dao.AskforLeaveDao;
import com.pojo.Askforleave;
import com.service.LeaveService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Leave")
@CrossOrigin
public class LeaveController {
    @Autowired
    private R r;
    @Autowired
    private LeaveService leaveService;
    @PostMapping("/InsertById")
    public R insert(@RequestBody Askforleave askforleave){
        return leaveService.queryStaff(askforleave) > 0 ? r.success() : r.error();
    }
    @PutMapping("/updateStateById")
    public R updateStateById(@RequestParam(value = "state") Integer state,
                             @RequestParam(value = "id") Integer id){
        return leaveService.updateById(state,id) > 0 ? r.success() : r.error();
    }
}
