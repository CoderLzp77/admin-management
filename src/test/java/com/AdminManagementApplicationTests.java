package com;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminManagementApplicationTests {


    @Test
    void contextLoads() {
        String Filename="1232.com";
        String substring = Filename.substring(Filename.lastIndexOf("."));
        System.out.println(substring);
    }

}
