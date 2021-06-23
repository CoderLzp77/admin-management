package com.sample;


public class Askforleave {

  private long leaveId;
  private java.sql.Timestamp applyTime;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private long duration;
  private long applicant;
  private String category;
  private String reason;
  private long state;
  private String approvalId;


  public long getLeaveId() {
    return leaveId;
  }

  public void setLeaveId(long leaveId) {
    this.leaveId = leaveId;
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


  public long getDuration() {
    return duration;
  }

  public void setDuration(long duration) {
    this.duration = duration;
  }


  public long getApplicant() {
    return applicant;
  }

  public void setApplicant(long applicant) {
    this.applicant = applicant;
  }


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
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
