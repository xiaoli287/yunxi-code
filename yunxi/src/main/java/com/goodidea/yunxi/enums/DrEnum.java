package com.goodidea.yunxi.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum DrEnum {
    //未删除
    NULL(0, "未删除"),

    //已删除
    FAIL(1, "已删除");

    @EnumValue//标记数据库存的值是code
    private final int code;

    @JsonValue //前端展示
    private final String text;

    DrEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }

}
