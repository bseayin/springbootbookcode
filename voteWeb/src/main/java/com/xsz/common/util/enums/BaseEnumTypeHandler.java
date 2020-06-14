package com.xsz.common.util.enums;

import com.xsz.common.enums.IEnum;
import com.xsz.product.enums.DishesEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author llf
 * @description: 自定义枚举类型转换器
 * https://blog.csdn.net/u010979642/article/details/90547722
 * @date 2020/5/26
 */
public class BaseEnumTypeHandler<E extends Enum<E> & IEnum> extends BaseTypeHandler<E> {
    private Class<E> type;

    private E[] enums;

    /**
     * 一定要有默认的构造函数, 不然抛出 not found method 异常
     */
    public BaseEnumTypeHandler() {
    }

    /**
     * 设置配置文件设置的转换类以及枚举类内容, 供其他方法更便捷高效的实现
     *
     * @param type 配置文件中设置的转换类
     */
    public BaseEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
        this.enums = type.getEnumConstants();
        if (this.enums == null) {
            throw new IllegalArgumentException(type.getSimpleName()
                    + " does not represent an enum type.");
        }
    }

    /**
     * 用于定义设置参数时，该如何把Java类型的参数转换为对应的数据库类型
     *
     * @param preparedStatement
     * @param i
     * @param parameter
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E parameter, JdbcType jdbcType) throws SQLException {
        /*
         * BaseTypeHandler已经帮我们做了parameter的null判断
         * 数据库存储的是枚举的值, 所以我们这里使用 value ,  如果需要存储 name, 可以自定义修改
         */
        if (jdbcType == null) {
            preparedStatement.setString(i, Objects.toString(parameter.getValue()));
        } else {
            preparedStatement.setObject(i, parameter.getValue(), jdbcType.TYPE_CODE);
        }
    }

    /**
     * 用于定义通过字段名称获取字段数据时，如何把数据库类型转换为对应的Java类型
     *
     * @param resultSet
     * @param columnName
     * @return
     * @throws SQLException
     */
    @Override
    public E getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        // 根据数据库存储类型决定获取类型
        int setInt = resultSet.getInt(columnName);
        // 根据数据库中的value值
        return resultSet.wasNull() ? null : locateEnumStatus(setInt);
    }

    /**
     * 用于定义通过字段索引获取字段数据时，如何把数据库类型转换为对应的Java类型
     *
     * @param resultSet
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public E getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        // 根据数据库存储类型决定获取类型
        int setInt = resultSet.getInt(columnIndex);
        // 根据数据库中的value值
        return resultSet.wasNull() ? null : locateEnumStatus(setInt);
    }

    /**
     * 用定义调用存储过程后，如何把数据库类型转换为对应的Java类型
     *
     * @param callableStatement
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public E getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        // 根据数据库存储类型决定获取类型
        int setInt = callableStatement.getInt(columnIndex);
        // 根据数据库中的value值
        return callableStatement.wasNull() ? null : locateEnumStatus(setInt);
    }

    /**
     * 枚举类型转换
     *
     * @param value 数据库中存储的自定义value属性
     * @return value 对应的枚举类
     */
    private E locateEnumStatus(int value) {
        for (E e : enums) {
            if (Objects.equals(e.getValue(),value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("未知的枚举类型：" + value + ",请核对"
                + type.getSimpleName());
    }

}
