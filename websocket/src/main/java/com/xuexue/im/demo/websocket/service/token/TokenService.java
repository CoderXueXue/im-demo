package com.xuexue.im.demo.websocket.service.token;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huchai
 * @date 2022/12/14
 * @description token服务
 */
@Service
public class TokenService {

    private static final Map<String, Integer> tokenMap = new HashMap<>();

    static {
        tokenMap.put("uuuuuaaaaaa", 1);
        tokenMap.put("qweadsadasd", 2);
    }

    public Integer getUserIdByToken(String token) {
        return tokenMap.get(token);
    }
}
