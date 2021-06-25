package com.pojo;


import java.sql.Timestamp;

public class Askforleave {

  private int leaveId;
  private java.sql.Timestamp applyTime;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private int duration;
  private int applicant;
  private String category;
  private String reason;
  private int state;
  private String approvalId;

  public Askforleave() {
  }

  public int getLeaveId() {
    return leaveId;
  }

  public void setLeaveId(int leaveId) {
    this.leaveId = leaveId;
  }

  public Timestamp getApplyTime() {
    return applyTime;
  }

  public void setApplyTime(Timestamp applyTime) {
    this.applyTime = applyTime;
  }

  public Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(Timestamp startTime) {
    this.startTime = startTime;
  }

  public Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(Timestamp endTime) {
    this.endTime = endTime;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public int getApplicant() {
    return applicant;
  }

  public void setApplicant(int applicant) {
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

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public String getApprovalId() {
    return approvalId;
  }

  public void setApprovalId(String approvalId) {
    this.approvalId = approvalId;
  }
}
