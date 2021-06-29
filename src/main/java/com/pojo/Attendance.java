package com.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Attendance {

  private int staffId;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date dateId;
  private Date checkInTime;
  private Date signOutTime;
  private String remark;
  private List<Clockintime> clockintimeList;

  public Attendance() {
  }

  public int getStaffId() {
    return staffId;
  }

  public void setStaffId(int staffId) {
    this.staffId = staffId;
  }

  public Date getDateId() {
    return dateId;
  }

  public void setDateId(Date dateId) {
    this.dateId = dateId;
  }

  public Date getCheckInTime() {
    return checkInTime;
  }

  public void setCheckInTime(Date checkInTime) {
    this.checkInTime = checkInTime;
  }

  public Date getSignOutTime() {
    return signOutTime;
  }

  public void setSignOutTime(Date signOutTime) {
    this.signOutTime = signOutTime;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public List<Clockintime> getClockintimeList() {
    return clockintimeList;
  }

  public void setClockintimeList(List<Clockintime> clockintimeList) {
    this.clockintimeList = clockintimeList;
  }
}
