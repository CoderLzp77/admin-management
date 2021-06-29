package com.service;

import com.pojo.Organization;

import java.util.List;

public interface OrganizationService {
    //通过部门号查询部门
    Organization queryOrganizationById(int organizationId);

    //查询所有部门
    List<Organization> queryOrganizationLimit(int pageNum);

    //添加部门
    int addNewOrganization(Organization organization);

    //根据ID删除部门
    int deleteOrganizationById(int organizationId);

    //修改部门信息
    int updateOrganization(Organization organization);
}
