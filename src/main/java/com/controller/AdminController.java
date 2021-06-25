package com.controller;

import com.dao.AdminDao;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "Admin")
@CrossOrigin
@RestController
public class AdminController {
    @Autowired
    private R r;
    @Autowired
    private AdminDao adminDao;
    @GetMapping("/Test")
    public R Test(String name){
        return r.success(adminDao.queryAll());
    }
}
