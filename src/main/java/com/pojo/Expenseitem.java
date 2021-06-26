package com.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Expenseitem {
  private int reimId;
  private int contentId;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date consumeTime;
  private double cost;
  private String remark;

  public Expenseitem() {
  }

  public int getReimId() {
    return reimId;
  }

  public void setReimId(int reimId) {
    this.reimId = reimId;
  }

  public int getContentId() {
    return contentId;
  }

  public void setContentId(int contentId) {
    this.contentId = contentId;
  }

  public Date getConsumeTime() {
    return consumeTime;
  }

  public void setConsumeTime(Date consumeTime) {
    this.consumeTime = consumeTime;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }
}
