package com.controller;

import com.pojo.Askforleave;
import com.pojo.Staff;
import com.service.StaffService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Staff")
@CrossOrigin
public class StaffController {
    @Autowired
    private R r;
    @Autowired
    private StaffService staffService;
    @GetMapping("/queryStaffById")
    public R find(@RequestParam(value = "id",required = false) Integer id,
                  @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                  @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        return r.success(staffService.queryStaffById(id,(pageNum-1)*pageSize, pageSize));
    }
    @GetMapping("/queryAll")
    public R findAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                     @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        List<Staff> staff = staffService.queryAll();
        List<Staff> collect = staff.stream().skip((long) (pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        return r.success(collect);
    }
    @GetMapping("/Approve")
    public R findBy(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                    @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){

        return r.success(staffService.queryAll());
    }
}
