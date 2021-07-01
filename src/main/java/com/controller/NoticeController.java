package com.controller;

import com.service.HolidayService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public R slideshow(@RequestParam(value = "pageNum",defaultValue = "1",required = false) Integer pageNum,
                       @RequestParam(value="pageSize",defaultValue = "5",required = false) Integer pageSize) {
        return r.success(holidayService.queryHolidayTime((pageNum-1)*pageSize, pageSize));
    }
}
