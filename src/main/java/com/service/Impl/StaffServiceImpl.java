package com.service.Impl;

import com.dao.StaffDao;
import com.pojo.Askforleave;
import com.pojo.Staff;
import com.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Override
    public List<Staff> queryStaffById(int id, Integer pageNum, Integer pageSize) {
        return staffDao.queryStaffById(id, pageNum, pageSize);
    }

    @Override
    public List<Staff> queryAll() {
        return staffDao.queryAll();
    }

    @Override
    public List<Staff> Approve() {
     /*   List<Staff> staff = staffDao.queryAll();
        staff.forEach(item->{
            Set<Askforleave> askforleave = item.getAskforleave();
            Set<Askforleave> collect = askforleave.stream().
            filter(n -> n.getState() == 1).collect(Collectors.toSet());
            item.setAskforleave(collect);
        });*/
        return null;
    }


}
