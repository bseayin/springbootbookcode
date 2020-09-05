package com.xsz.common.enums;

/**
 * @author llf
 * @description: 通用枚举接口
 * @date 2020/5/26
 */
public interface IEnum<E extends Enum<?>, T> {
    /**
     * 获取枚举值
     * @return
     */
    T getValue();

}
