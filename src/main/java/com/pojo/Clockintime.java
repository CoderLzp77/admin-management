package com.pojo;


import java.util.Date;

public class Clockintime {

  private int staffId;
  private Date clockInTime;

  public Clockintime() {
  }


  public int getStaffId() {
    return staffId;
  }

  public void setStaffId(int staffId) {
    this.staffId = staffId;
  }

  public Date getClockInTime() {
    return clockInTime;
  }

  public void setClockInTime(Date clockInTime) {
    this.clockInTime = clockInTime;
  }
}
