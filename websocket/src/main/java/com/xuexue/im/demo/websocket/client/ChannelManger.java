package com.xuexue.im.demo.websocket.client;

import org.springframework.stereotype.Component;

import java.nio.channels.Channel;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huchai
 * @date 2022/12/13
 */
@Component
public class ChannelManger {

    Map<Integer, Set<Channel>> channelMap = new ConcurrentHashMap<>();

    public void addChannel(int userId, Channel channel) {
        Set<Channel> channels = channelMap.get(userId);
        if (channels == null) {
            channels = ConcurrentHashMap.newKeySet();
            channelMap.put(userId, channels);
        }
        channels.add(channel);
    }

    public void removeChannel(int userId, Channel channel) {
        Set<Channel> channels = channelMap.get(userId);
        if (channels != null) {
            channels.remove(channel);
        }
    }
}
