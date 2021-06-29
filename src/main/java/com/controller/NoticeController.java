package com.controller;

import com.service.HolidayService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "Notice")
@CrossOrigin
@RestController
public class NoticeController {
    @Autowired
    private HolidayService holidayService;
    @Autowired
    private R r;
    //TODO 展示最新放假通知的功能
    @RequestMapping(value = "/Slideshow", method = RequestMethod.GET)
    public R slideshow() {
        return r.success(holidayService.queryHolidayTime());
    }
}
