//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.service.Impl;

import com.dao.OtherConsumeDao;
import com.pojo.Otherconsume;
import com.service.OtherConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtherConsumeImpl implements OtherConsumeService {
    @Autowired
    private OtherConsumeDao otherConsumeDao;

    public OtherConsumeImpl() {
    }

    public int AddOtherConsume(List<Otherconsume> otherconsumes) {
        return this.otherConsumeDao.AddOtherConsume(otherconsumes);
    }
}
