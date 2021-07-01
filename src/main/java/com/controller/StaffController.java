package com.controller;

import com.pojo.Staff;
import com.service.StaffService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    /**
     * 请假信息查询以及分页
     */
    @GetMapping("/queryStaffById")
    public R find(@RequestParam(value = "id",required = false) Integer id,
                  @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                  @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        return r.success(staffService.queryStaffById(id,(pageNum-1)*pageSize, pageSize));
    }
    /**
     * 查询所有员工全部信息以及分页
     */
    @GetMapping("/queryAll")
    public R findAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                     @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                     @RequestParam(value = "userName",required = false) String userName){
        List<Staff> staff = staffService.queryAll(userName);
        List<Staff> collect = staff.stream().skip((long) (pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        return r.success(collect);
    }
    @GetMapping("/Approve")
    public R findBy(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                    @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        List<Staff> staff = staffService.queryApprove();
        List<Staff> collect = staff.stream().skip((long) (pageNum - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        return r.success(collect);
    }
    /**
     * 上传头像
     */
    @PostMapping("/changeAvatar")
    public R changeAvatar(@RequestParam(value = "file",required = false) MultipartFile file) throws IOException {
        String s = staffService.changeAvatar(file);
        return  s != null ? r.success(s).message("上传成功") : r.error().message("上传失败");
    }

    /**
     * 用户登录
     */
    @PostMapping("/Login")
    public R Login(@RequestParam(value = "username") String username,
                   @RequestParam(value = "password") String password){
        Staff staff = staffService.queryUserAndPass(username, password);
        return staff != null ? r.success() : r.error().message("用户名或密码错误");
    }
    @GetMapping("/queryApprove")
    public R queryApprove(){
        return r.success(staffService.queryApprove());
    }

    @GetMapping("/queryMyLeave")
    public R queryMyLeave(@RequestParam(value = "state",required = false) Integer state,
                          @RequestParam(value = "category",required = false) String category,
                          @RequestParam(value = "duration",required = false) Integer duration){
        return r.success(staffService.queryMyLeave(state, category, duration));
    }
    //TODO 添加员工功能
    @PostMapping(value ="/AddStaff")
    public R addNewStaff(@RequestBody Staff staff) {
        int result = staffService.addNewStaff(staff);
        return result >0 ? r.success():r.error();
    }
    //TODO 重置密码功能
    @PutMapping(value ="/rePassWord")
    public R rePassWord(@RequestParam("staffId") Integer staffId)
    {
        int result = staffService.rePassword(staffId);
        return result > 0 ? r.success():r.error();
    }
    //TODO 删除员工
    @DeleteMapping(value = "/deleteStaff/{staffId}")
    public R deleteStaff(@PathVariable(value = "staffId") int staffId){
        int i = staffService.deleteStaffById(staffId);
        return i > 0 ? r.success():r.error();
    }
    //TODO 修改员工信息
    @RequestMapping(value = "dateStaffInfo", method = RequestMethod.POST)
    public R dateStaffInfo(@RequestBody Staff staff){
        if(staffService.updateStaffInfo(staff)>1)
        {
            return r.success();
        }else
        {
            return r.error();
        }
    }
    @GetMapping("/queryStaffSub")
    public R queryStaffAll(@RequestParam(value = "staffId") int staffId ,
                           @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                           @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize){
        return r.success(staffService.queryStaffSub(staffId,pageNum,pageSize));
    }
}
