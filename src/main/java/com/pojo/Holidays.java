package com.pojo;


public class Holidays {

  private long holidayId;
  private java.sql.Date holidayStartTime;
  private java.sql.Date holidayEndTime;

  public Holidays() {
  }

  public long getHolidayId() {
    return holidayId;
  }

  public void setHolidayId(long holidayId) {
    this.holidayId = holidayId;
  }


  public java.sql.Date getHolidayStartTime() {
    return holidayStartTime;
  }

  public void setHolidayStartTime(java.sql.Date holidayStartTime) {
    this.holidayStartTime = holidayStartTime;
  }


  public java.sql.Date getHolidayEndTime() {
    return holidayEndTime;
  }

  public void setHolidayEndTime(java.sql.Date holidayEndTime) {
    this.holidayEndTime = holidayEndTime;
  }

}
