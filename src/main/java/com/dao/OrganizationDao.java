package com.dao;

import com.pojo.Organization;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationDao {
    //通过部门号查询员工的部门
    Organization queryOrganizationById(int organizationId);

    //通过部门名称查询部门号
    int queryOrganizationId(String  organizationName);

    //查询所有部门
    List<Organization> queryOrganizationLimit(int pageNum);

    //添加部门
    int addNewOrganization(Organization organization);

    //根据ID删除部门
    int deleteOrganizationById(int organizationId);

    //修改部门信息
    int updateOrganization(Organization organization);
}
