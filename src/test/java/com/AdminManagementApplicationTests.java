package com;

import com.dao.AdminDao;
import com.dao.ReimbursementSubjectsDao;
import com.pojo.Otherconsume;
import com.service.OtherConsumeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AdminManagementApplicationTests {
   @Autowired
   private OtherConsumeService otherConsumeService;
   @Autowired
   private ReimbursementSubjectsDao reimbursementSubjectsDao;
    @Test
    void contextLoads() throws MalformedURLException {
   /*     String Filename="1232.com";
        String substring = Filename.substring(Filename.lastIndexOf("."));
        System.out.println(substring);*/
      /*  adminDao.queryAll();*/
        List<Otherconsume> otherconsumes=new ArrayList<>();
        Otherconsume otherconsume=new Otherconsume();
        Otherconsume otherconsume1=new Otherconsume();
        otherconsume.setCost(1000);
        otherconsume.setConsumeType("吃饭");
        otherconsume.setTripId(1);
        otherconsume1.setCost(2000);
        otherconsume1.setConsumeType("睡觉");
        otherconsume1.setTripId(1);
        otherconsumes.add(otherconsume);
        otherconsumes.add(otherconsume1);
        otherConsumeService.AddOtherConsume(otherconsumes);

    }
    @Test
    public void Test6(){
        System.out.println(reimbursementSubjectsDao.queryAllSub());
    }

}
