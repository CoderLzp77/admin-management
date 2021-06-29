package com.pojo.Vo;

import com.pojo.Attendance;

import java.util.Date;
import java.util.List;

public class AttendanceVo {
    private Date dateId;
    private int clockSum; //打卡次数
    private Date checkInTime;
    private Date signOutTime;
    private String remark;

    public AttendanceVo() {
    }

    public AttendanceVo(Date dateId, int clockSum, Date checkInTime, Date signOutTime, String remark) {
        this.dateId = dateId;
        this.clockSum = clockSum;
        this.checkInTime = checkInTime;
        this.signOutTime = signOutTime;
        this.remark = remark;
    }

    public Date getDateId() {
        return dateId;
    }

    public void setDateId(Date dateId) {
        this.dateId = dateId;
    }

    public int getClockSum() {
        return clockSum;
    }

    public void setClockSum(int clockSum) {
        this.clockSum = clockSum;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getSignOutTime() {
        return signOutTime;
    }

    public void setSignOutTime(Date signOutTime) {
        this.signOutTime = signOutTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "AttendanceVo{" +
                "dateId=" + dateId +
                ", clockSum=" + clockSum +
                ", checkInTime=" + checkInTime +
                ", signOutTime=" + signOutTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
