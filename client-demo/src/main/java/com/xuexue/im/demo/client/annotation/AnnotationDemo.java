package com.xuexue.im.demo.client.annotation;

import lombok.Data;

/**
 * @author huchai
 * @date 2022/12/15
 */
@Data
@LeiMode(0)
public class AnnotationDemo {
    @FiledMode(2)
    private int name;
    @FiledMode(3)
    private int age;

    @TreahMode(8)
    public void test() {
        System.out.println("test");
    }
}
