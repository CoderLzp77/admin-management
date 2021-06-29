package com.service.Impl;

import com.dao.OrganizationDao;
import com.pojo.Organization;
import com.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationImpl implements OrganizationService {

    @Autowired
    private OrganizationDao adminOrganizationDao;

    @Override
    public Organization queryOrganizationById(int organizationId) {
        return queryOrganizationById(organizationId);
    }

    @Override
    public List<Organization> queryOrganizationLimit(int pageNum) {
        return adminOrganizationDao.queryOrganizationLimit((pageNum-1)*5);
    }

    @Override
    public int addNewOrganization(Organization organization) {
        return adminOrganizationDao.addNewOrganization(organization);
    }

    @Override
    public int deleteOrganizationById(int organizationId) {
        return adminOrganizationDao.deleteOrganizationById(organizationId);
    }

    @Override
    public int updateOrganization(Organization organization) {
        return adminOrganizationDao.updateOrganization(organization);
    }
}
