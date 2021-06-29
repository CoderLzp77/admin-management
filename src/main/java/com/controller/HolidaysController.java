package com.controller;

import com.pojo.Holidays;
import com.service.HolidayService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping(value = "Holidays")
@CrossOrigin
@Controller
@ResponseBody
public class HolidaysController {
    @Autowired
    private R r;
    @Autowired
    private HolidayService holidaysService;
    /**
     * 节假日修改
     */
    //查看全部假期
    @GetMapping("/queryHolidayTime")
    public R queryHolidayTime(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                              @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize){
        return r.success(holidaysService.queryHolidayAllTime(pageNum,pageSize));
    }

    //查看该年假期
    @GetMapping("/queryHolidayTimeByYear")
    public R queryHolidayTimeByYear(@RequestParam(value = "date") Date date,
                                    @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                    @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize){
        return r.success(holidaysService.queryHolidayTimeByYear(date,pageNum,pageSize));
    }

    //添加假期
    @PostMapping("/addHolidayTimeByTime")
    public R addHolidayTimeByTime(@RequestParam(value = "holidays") Holidays holidays){
        return r.success(holidaysService.addHolidayTimeByTime(holidays));
    }

    //删除假期
    @DeleteMapping("/delectHolidayTimeById/{holidayId}")
    public R delectHolidayTimeById(@PathVariable(value = "holidayId") int holidayId){
        return r.success(holidaysService.delectHolidayTimeById(holidayId));
    }
}
