package com.Pojo;


public class Reimbursement {

  private long reimId;
  private long subjectId;
  private long applicant;
  private java.sql.Timestamp applyTime;
  private double totalAmount;
  private long state;
  private String approvalId;

  public Reimbursement() {
  }

  public long getReimId() {
    return reimId;
  }

  public void setReimId(long reimId) {
    this.reimId = reimId;
  }


  public long getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(long subjectId) {
    this.subjectId = subjectId;
  }


  public long getApplicant() {
    return applicant;
  }

  public void setApplicant(long applicant) {
    this.applicant = applicant;
  }


  public java.sql.Timestamp getApplyTime() {
    return applyTime;
  }

  public void setApplyTime(java.sql.Timestamp applyTime) {
    this.applyTime = applyTime;
  }


  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
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
