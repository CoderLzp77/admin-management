package com.controller;

import com.pojo.Organization;
import com.service.OrganizationService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Organization")
@CrossOrigin
public class OrganizationController {
    @Autowired
    private R r;
    @Autowired
    private OrganizationService OrganizationService;

    //TODO 分页展示员工信息功能
    @RequestMapping(value = "/ShwoOrganizationInfoLimit",method = RequestMethod.GET)
    public R showOrganizationInfo(@RequestParam("pageNum") Integer pageNum)
    {
        List<Organization> organizations = OrganizationService.queryOrganizationLimit(pageNum);
        if (CollectionUtils.isEmpty(organizations)){
            return r.error();
        }
        return r.success(organizations);
    }

    //TODO 添加新部门功能
    @RequestMapping(value ="/AddOrganization",method = RequestMethod.POST)
    public R addNewStaff(@RequestBody Organization organization) {
        int result = OrganizationService.addNewOrganization(organization);
        return result > 0 ? r.success():r.error();
    }

    //TODO 删除现有部门功能
    @RequestMapping(value = "/DeleteOrganization/{organizationId}",method = RequestMethod.DELETE)
    public R deleteStaff(@PathVariable("organizationId") int organizationId) {
        return r.success(OrganizationService.deleteOrganizationById(organizationId));
    }

    //TODO 修改现有部门功能
    @RequestMapping(value ="/UpdateOrganization",method = RequestMethod.PUT)
    public R updateOrganization(@RequestBody Organization organization) {
        int result = OrganizationService.updateOrganization(organization);
        return result > 0 ? r.success():r.error();
    }

    //TODO 根据ID查询部门功能
    @RequestMapping(value ="/ShowOrganizationById",method = RequestMethod.GET)
    public R showOrganizationById(@RequestBody int organizationId) {
        Organization organization = OrganizationService.queryOrganizationById(organizationId);
        return r.success(organization);
    }
}
