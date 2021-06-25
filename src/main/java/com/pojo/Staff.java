package com.pojo;


import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Staff {

  private int staffId;
  private String userName;
  private String password;
  private int state;
  private String staffName;
  private String gender;
  private java.sql.Timestamp birthday;
  private int organizationId;
  private int jobId;
  private String directBoss;
  private String birthplace;
  private String position;
  private String phoneNumber;
  private String email;
  private String photoUrl;
  private Set<Askforleave> askforleave = new HashSet<>();
  private Organization organization;

  public Staff() {
  }

  public int getStaffId() {
    return staffId;
  }

  public void setStaffId(int staffId) {
    this.staffId = staffId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public String getStaffName() {
    return staffName;
  }

  public void setStaffName(String staffName) {
    this.staffName = staffName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Timestamp getBirthday() {
    return birthday;
  }

  public void setBirthday(Timestamp birthday) {
    this.birthday = birthday;
  }

  public int getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(int organizationId) {
    this.organizationId = organizationId;
  }

  public int getJobId() {
    return jobId;
  }

  public void setJobId(int jobId) {
    this.jobId = jobId;
  }

  public String getDirectBoss() {
    return directBoss;
  }

  public void setDirectBoss(String directBoss) {
    this.directBoss = directBoss;
  }

  public String getBirthplace() {
    return birthplace;
  }

  public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhotoUrl() {
    return photoUrl;
  }

  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }

  public Set<Askforleave> getAskforleave() {
    return askforleave;
  }

  public void setAskforleave(Set<Askforleave> askforleave) {
    this.askforleave = askforleave;
  }

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }
}