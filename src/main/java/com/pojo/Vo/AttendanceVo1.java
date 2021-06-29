package com.pojo.Vo;

import java.util.List;

public class AttendanceVo1 {
    private List<AttendanceVo> attendanceVos;
    private int outSum; //迟到、早退总次数
    private int askForLeaveSum; //请假次数
    private int trip; //出差次数
    private int holidaysSum; //放假次数
    private int atTimeSum; //准时上下班次数

    public AttendanceVo1() {
    }

    public AttendanceVo1(List<AttendanceVo> attendanceVos, int outSum, int askForLeaveSum, int trip, int holidaysSum, int atTimeSum) {
        this.attendanceVos = attendanceVos;
        this.outSum = outSum;
        this.askForLeaveSum = askForLeaveSum;
        this.trip = trip;
        this.holidaysSum = holidaysSum;
        this.atTimeSum = atTimeSum;
    }

    public List<AttendanceVo> getAttendanceVos() {
        return attendanceVos;
    }

    public void setAttendanceVos(List<AttendanceVo> attendanceVos) {
        this.attendanceVos = attendanceVos;
    }

    public int getOutSum() {
        return outSum;
    }

    public void setOutSum(int outSum) {
        this.outSum = outSum;
    }

    public int getAskForLeaveSum() {
        return askForLeaveSum;
    }

    public void setAskForLeaveSum(int askForLeaveSum) {
        this.askForLeaveSum = askForLeaveSum;
    }

    public int getTrip() {
        return trip;
    }

    public void setTrip(int trip) {
        this.trip = trip;
    }

    public int getHolidaysSum() {
        return holidaysSum;
    }

    public void setHolidaysSum(int holidaysSum) {
        this.holidaysSum = holidaysSum;
    }

    public int getAtTimeSum() {
        return atTimeSum;
    }

    public void setAtTimeSum(int atTimeSum) {
        this.atTimeSum = atTimeSum;
    }

    @Override
    public String toString() {
        return "AttendanceVo1{" +
                "attendanceVos=" + attendanceVos +
                ", outSum=" + outSum +
                ", askForLeaveSum=" + askForLeaveSum +
                ", trip=" + trip +
                ", holidaysSum=" + holidaysSum +
                ", atTimeSum=" + atTimeSum +
                '}';
    }
}
