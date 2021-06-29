package com.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Holidays {

  private int holidayId;
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date holidayStartTime;
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
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
