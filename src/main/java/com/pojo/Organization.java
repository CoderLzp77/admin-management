package com.pojo;


public class Organization {

  private int organizationId;
  private String name;
  private String higherOrgId;
  private String remark;

  public Organization() {
  }

  public long getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(int organizationId) {
    this.organizationId = organizationId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getHigherOrgId() {
    return higherOrgId;
  }

  public void setHigherOrgId(String higherOrgId) {
    this.higherOrgId = higherOrgId;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
