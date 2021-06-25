package com;

import com.dao.AdminDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootTest
class AdminManagementApplicationTests {
   @Autowired
   private AdminDao adminDao;

    @Test
    void contextLoads() throws MalformedURLException {
   /*     String Filename="1232.com";
        String substring = Filename.substring(Filename.lastIndexOf("."));
        System.out.println(substring);*/
      /*  adminDao.queryAll();*/
    }

}
