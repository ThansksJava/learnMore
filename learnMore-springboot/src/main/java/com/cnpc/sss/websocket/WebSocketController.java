package com.cnpc.sss.websocket;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/8/14
 * @Time 15:48
 */
@RestController
public class WebSocketController {
    @RequestMapping(value="/pushVideoListToWeb")
    public Map<String,Object> pushVideoListToWeb() {
        Map<String,Object> result =new HashMap<String,Object>();

        try {
            WebSocketServer.sendInfo("有新客户呼入,sltAccountId:"+1);

            result.put("operationResult", true);
        }catch (IOException e) {
            result.put("operationResult", true);
        }
        return result;
    }

}
