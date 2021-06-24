package com.pojo;


public class Schedule {

  private long scheduleId;
  private long tripId;
  private String departure;
  private String destination;
  private String transport;
  private double cost;

  public Schedule() {
  }

  public long getScheduleId() {
    return scheduleId;
  }

  public void setScheduleId(long scheduleId) {
    this.scheduleId = scheduleId;
  }


  public long getTripId() {
    return tripId;
  }

  public void setTripId(long tripId) {
    this.tripId = tripId;
  }


  public String getDeparture() {
    return departure;
  }

  public void setDeparture(String departure) {
    this.departure = departure;
  }


  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }


  public String getTransport() {
    return transport;
  }

  public void setTransport(String transport) {
    this.transport = transport;
  }


  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

}
