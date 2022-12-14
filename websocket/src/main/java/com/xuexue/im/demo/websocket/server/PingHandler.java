package com.xuexue.im.demo.websocket.server;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Korben on 2022/5/23
 */
@Slf4j
@Sharable
@Component
public class PingHandler extends SimpleChannelInboundHandler<PingWebSocketFrame> {

    private static final Logger logger = LoggerFactory.getLogger(PingHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PingWebSocketFrame frame) {
        log.info("#PingHandler# {}", ctx.channel());
        frame.content().retain();
        ctx.channel().writeAndFlush(new PongWebSocketFrame(frame.content()));
    }
}