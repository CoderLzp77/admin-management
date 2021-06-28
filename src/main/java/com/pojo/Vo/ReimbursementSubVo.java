package com.pojo.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReimbursementSubVo {
    /**
     * 添加报销科目类
     */
    private String subjectName;//科目名称
    private int subjectId;//科目编号
    private String contentName;//科目内容
}
