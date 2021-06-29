package com.service;

import com.pojo.Askforleave;

import java.util.Date;
import java.util.List;

public interface AskforleaveService {
    /**
     * 请假情况
     */
    //所有请假记录
    List<Askforleave> queryAskforleaveAll(int id,Integer pageNum, Integer pageSize);
    //查看该月的请假记录
    List<Askforleave> queryAskforleaveAllByTime(int id,Date year,Integer pageNum, Integer pageSize);

}
