package com.sample;


public class Attendance {

  private long staffId;
  private long dateId;
  private java.sql.Timestamp checkInTime;
  private java.sql.Timestamp signOutTime;
  private String remark;


  public long getStaffId() {
    return staffId;
  }

  public void setStaffId(long staffId) {
    this.staffId = staffId;
  }


  public long getDateId() {
    return dateId;
  }

  public void setDateId(long dateId) {
    this.dateId = dateId;
  }


  public java.sql.Timestamp getCheckInTime() {
    return checkInTime;
  }

  public void setCheckInTime(java.sql.Timestamp checkInTime) {
    this.checkInTime = checkInTime;
  }


  public java.sql.Timestamp getSignOutTime() {
    return signOutTime;
  }

  public void setSignOutTime(java.sql.Timestamp signOutTime) {
    this.signOutTime = signOutTime;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
