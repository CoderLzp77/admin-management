package com.pojo;


public class Clockintime {

  private long staffId;
  private java.sql.Timestamp clockInTime;

  public Clockintime() {
  }

  public long getStaffId() {
    return staffId;
  }

  public void setStaffId(long staffId) {
    this.staffId = staffId;
  }


  public java.sql.Timestamp getClockInTime() {
    return clockInTime;
  }

  public void setClockInTime(java.sql.Timestamp clockInTime) {
    this.clockInTime = clockInTime;
  }

}
