package com.pojo;


public class Otherconsume {

  private long consumeId;
  private long tripId;
  private java.sql.Timestamp consumeTime;
  private String consumeType;
  private double cost;

  public Otherconsume() {
  }

  public long getConsumeId() {
    return consumeId;
  }

  public void setConsumeId(long consumeId) {
    this.consumeId = consumeId;
  }


  public long getTripId() {
    return tripId;
  }

  public void setTripId(long tripId) {
    this.tripId = tripId;
  }


  public java.sql.Timestamp getConsumeTime() {
    return consumeTime;
  }

  public void setConsumeTime(java.sql.Timestamp consumeTime) {
    this.consumeTime = consumeTime;
  }


  public String getConsumeType() {
    return consumeType;
  }

  public void setConsumeType(String consumeType) {
    this.consumeType = consumeType;
  }


  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

}
