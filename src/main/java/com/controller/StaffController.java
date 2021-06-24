package com.controller;

import com.dao.StaffDao;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Staff")
@CrossOrigin
public class StaffController {
    @Autowired
    private R r;
    @Autowired
    private StaffDao staffDao;
    @GetMapping("/Test")
    public R find(@RequestParam(value = "id") int id){
        return r.success(staffDao.findById(id));
    }
}
