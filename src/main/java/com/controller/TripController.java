package com.controller;

import com.pojo.Vo.TripVo;
import com.service.TripService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Trip")
@CrossOrigin
public class TripController {
    @Autowired
    private R r;
    @Autowired
    private TripService tripService;
    @GetMapping("/queryAllTrip")
    public R queryAllTrip(){
        return r.success(tripService.queryAllTrip());
    }
    @GetMapping("/queryTripInfoById")
    public R queryTripInfoById(@RequestParam(value = "id") int id){
        return  r.success(tripService.queryTripInfoById(id));
    }
    @PostMapping("/AddTrip")
    public R AddTrip(@RequestBody TripVo tripVo){
        return r.success(tripService.AddTrip(tripVo));
    }
    @GetMapping("/queryApprove")
    public R queryApprove(){
        return r.success(tripService.queryApproveTrip());
    }
    @GetMapping("/querySubordinateTrip")
    public R querySubordinateTrip(@RequestParam(value = "state",required = false) Integer state,
                                  @RequestParam(value = "category",required = false) String category,
                                  @RequestParam(value = "duration",required = false) Integer duration){
        return r.success(tripService.querySubordinateTrip(state, category, duration));
    }
}
