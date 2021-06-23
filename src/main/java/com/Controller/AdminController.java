package com.Controller;

import com.Utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "Admin")
@CrossOrigin
@RestController
public class AdminController {
    @Autowired
    private R r;
    @GetMapping("/Test")
    public R Test(){
        return r.error();
    }
}
