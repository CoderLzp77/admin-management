package com.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Reimbursement {

  private int reimId;
  private int subjectId;
  private int applicant;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date applyTime;
  private double totalAmount;
  private int state;
  private String approvalId;
  private Set<Expenseitem> expenseitems=new HashSet<>();

  public Reimbursement() {
  }

  public int getReimId() {
    return reimId;
  }

  public void setReimId(int reimId) {
    this.reimId = reimId;
  }

  public int getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(int subjectId) {
    this.subjectId = subjectId;
  }

  public int getApplicant() {
    return applicant;
  }

  public void setApplicant(int applicant) {
    this.applicant = applicant;
  }

  public Date getApplyTime() {
    return applyTime;
  }

  public void setApplyTime(Date applyTime) {
    this.applyTime = applyTime;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
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

  public Set<Expenseitem> getExpenseitems() {
    return expenseitems;
  }

  public void setExpenseitems(Set<Expenseitem> expenseitems) {
    this.expenseitems = expenseitems;
  }
}
