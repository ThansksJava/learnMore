package com.weakpasswd.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.weakpasswd.domain.UserInfo;
import com.weakpasswd.domain.UserInfoResult;
import com.weakpasswd.service.CheckPasswdService;
import com.weakpasswd.util.ExcelUtil;
import com.weakpasswd.util.PasswordUtil;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FengJie
 */
public class UserInfoListener extends AnalysisEventListener<UserInfo> {
    List<UserInfo> list = new ArrayList<UserInfo>();

    @Override
    public void invoke(UserInfo data, AnalysisContext context) {
        list.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        checkAndSave(list);
    }

    /**
     * 判断是否合规，并创建到excel
     */
    private void checkAndSave(List<UserInfo> list) {
        List<UserInfoResult> result = new ArrayList<>();
        for (UserInfo userInfo : list) {
            String username = userInfo.getUsername();
            String password = userInfo.getPassword();
            String needModify = "很强，不需要修改";
            if(!CheckPasswdService.EvalPWD(password == null?password:PasswordUtil.decoding(password))){
                needModify  ="弱口令需要修改";
            }
            UserInfoResult userInfoResult = new UserInfoResult();
            userInfoResult.setUsername(username);
            userInfoResult.setPassword(password);
            userInfoResult.setNeedModify(needModify);
            if (password == null){
                userInfoResult.setNeedModify(null);
                userInfoResult.setComments("组");
            }
            result.add(userInfoResult);
        }
        ExcelUtil.writeToExcel("D:\\workspace\\PesonalProject\\learnMore\\learnMore-weakpasswd\\src\\main\\resources\\弱口令结果.xlsx",
        UserInfoResult.class,result);

    }

}