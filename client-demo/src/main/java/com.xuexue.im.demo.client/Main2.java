package com.xuexue.im.demo.client;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author huchai
 * @date 2022/12/13
 */
public class Main2 {
    public static void main(String[] args) {
        try {
            WebSocketClient client = new WebSocketClient("ws://127.0.0.1:1500/ws");
            client.open();
            client.eval("hello");

            new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    String line = scanner.nextLine();
                    if ("q".equals(line)) {
                        try {
                            client.close();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }
                    try {
                        client.eval(line);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();

            //  client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
