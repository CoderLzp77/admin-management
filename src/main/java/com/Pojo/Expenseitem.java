package com.sample;


public class Expenseitem {

  private long reimId;
  private long contentId;
  private java.sql.Timestamp consumeTime;
  private double cost;
  private String remark;


  public long getReimId() {
    return reimId;
  }

  public void setReimId(long reimId) {
    this.reimId = reimId;
  }


  public long getContentId() {
    return contentId;
  }

  public void setContentId(long contentId) {
    this.contentId = contentId;
  }


  public java.sql.Timestamp getConsumeTime() {
    return consumeTime;
  }

  public void setConsumeTime(java.sql.Timestamp consumeTime) {
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
