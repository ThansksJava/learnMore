package com.weakpasswd;


import com.weakpasswd.domain.UserInfo;
import com.weakpasswd.listener.UserInfoListener;
import com.weakpasswd.util.ExcelUtil;

/**
 * Created by xianbin
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("this is a test code");
//
//        boolean flag = false;
//        String[] testPass = {
//                null,
//                "",
//                "123456",
//                "12345678",
//                "abcdefgh",
//                "123abc456",
//                "1231adf@",
//                "12341adf@",
//                "fdahuier243335ddfa#$*&",
//                "aBcd1859d4!@",
//                "zaq13edfgt#",
//                "Bgt5sj4#"
//        };
//        for (int i = 0; i < testPass.length; i++) {
//            System.out.printf("testpass[%d] = %s\n", i,testPass[i]);
//            flag = CheckPWD.EvalPWD(testPass[i]);
//            if (flag) {
//                System.out.println("secret pass.\n");
//            } else {
//                System.out.println("secret failed.\n");
//            }
//        }
        String fileName = ClassLoader.getSystemResource("user_info.xlsx").getPath();
        ExcelUtil.readFromExcel("D:/workspace/PesonalProject/learnMore/learnMore-weakpasswd/target/classes/user_info.xlsx", UserInfo.class,new UserInfoListener());
 
    }
}
 
 