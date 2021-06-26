package com.pojo;


import java.util.Date;

public class Holidays {

  private int holidayId;
  private Date holidayStartTime;
  private Date holidayEndTime;

  public Holidays() {
  }

  public int getHolidayId() {
    return holidayId;
  }

  public void setHolidayId(int holidayId) {
    this.holidayId = holidayId;
  }

  public Date getHolidayStartTime() {
    return holidayStartTime;
  }

  public void setHolidayStartTime(Date holidayStartTime) {
    this.holidayStartTime = holidayStartTime;
  }

  public Date getHolidayEndTime() {
    return holidayEndTime;
  }

  public void setHolidayEndTime(Date holidayEndTime) {
    this.holidayEndTime = holidayEndTime;
  }
}
