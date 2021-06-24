package com.pojo;


public class Trip {

  private long tripId;
  private java.sql.Timestamp applyTime;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private long staffId;
  private long duration;
  private String category;
  private double amount;
  private String reason;
  private long state;
  private String approvalId;

  public Trip() {
  }

  public long getTripId() {
    return tripId;
  }

  public void setTripId(long tripId) {
    this.tripId = tripId;
  }


  public java.sql.Timestamp getApplyTime() {
    return applyTime;
  }

  public void setApplyTime(java.sql.Timestamp applyTime) {
    this.applyTime = applyTime;
  }


  public java.sql.Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Timestamp startTime) {
    this.startTime = startTime;
  }


  public java.sql.Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Timestamp endTime) {
    this.endTime = endTime;
  }


  public long getStaffId() {
    return staffId;
  }

  public void setStaffId(long staffId) {
    this.staffId = staffId;
  }


  public long getDuration() {
    return duration;
  }

  public void setDuration(long duration) {
    this.duration = duration;
  }


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }


  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }


  public String getApprovalId() {
    return approvalId;
  }

  public void setApprovalId(String approvalId) {
    this.approvalId = approvalId;
  }

}
