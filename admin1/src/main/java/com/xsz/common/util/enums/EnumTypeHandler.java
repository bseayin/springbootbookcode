package com.xsz.common.util.enums;

import com.xsz.common.enums.IEnum;
import com.xsz.product.enums.DishesEnum;
import org.apache.ibatis.type.MappedTypes;

/**
 * @author llf
 * @description:枚举自定义的转换器
 * https://www.cnblogs.com/yuluoxingkong/p/11423486.html
 * @date 2020/5/26
 */
@MappedTypes(value = {DishesEnum.class})
public class EnumTypeHandler <E extends Enum<E> & IEnum> extends BaseEnumTypeHandler<E> {
    /**
     * 设置配置文件设置的转换类以及枚举类内容，供其他方法更便捷高效的实现
     *
     * @param type 配置文件中设置的转换类
     */
    public EnumTypeHandler(Class<E> type) {
        super(type);
    }
}
