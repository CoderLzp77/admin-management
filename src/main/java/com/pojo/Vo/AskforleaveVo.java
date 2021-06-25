package com.pojo.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AskforleaveVo {
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
    private Integer pageNum;
    private Integer pageSize;
}
