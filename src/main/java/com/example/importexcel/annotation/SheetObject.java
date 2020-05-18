package com.example.importexcel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SheetObject {
    // sheet 名
    String sheetName() default "";

    // 最大行数
    int maxColumn() default 0;

    // 起始行数
    int beginColumn() default 0;
}
