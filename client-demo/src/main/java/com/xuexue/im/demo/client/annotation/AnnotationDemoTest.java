package com.xuexue.im.demo.client.annotation;

import java.lang.reflect.Field;

/**
 * @author huchai
 * @date 2022/12/15
 */
public class AnnotationDemoTest {
    public static void main(String[] args) throws IllegalAccessException {

        AnnotationDemo annotationDemo = new AnnotationDemo();

        // 获取注解类上的值
        LeiMode annotation = AnnotationDemo.class.getAnnotation(LeiMode.class);

        Field[] fields = AnnotationDemo.class.getDeclaredFields();
        for (Field field : fields) {
            FiledMode annotation1 = field.getAnnotation(FiledMode.class);
            System.out.println(field.getName() + ":::" + annotation1.value());
            field.setAccessible(true);
            field.set(annotationDemo, annotation1.value());
        }

        System.out.println(annotationDemo.getAge());
        System.out.println(annotationDemo.getName());
    }
}
