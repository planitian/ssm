package com.plani.handler;

import com.plani.bean.Type;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserHandler extends BaseTypeHandler<Type> {
    /**
     * 用于定义设置参数时，该如何把Java类型的参数转换为对应的数据库类型
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Type parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getType() + "");
    }

    /**
     * 用于定义通过字段名称获取字段数据时，如何把数据库类型转换为对应的Java类型
     */
    @Override
    public Type getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String key = rs.getString(columnName);
        return getType(rs, key);
    }

    /**
     * 用于定义通过字段索引获取字段数据时，如何把数据库类型转换为对应的Java类型
     */
    @Override
    public Type getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String key = rs.getString(columnIndex);
        return getType(rs, key);
    }


    private Type getType(ResultSet rs, String key) throws SQLException {
        if (rs.wasNull()) {
            return null;
        } else {
            Integer integer = Integer.parseInt(key);
            Type type = null;
            switch (integer) {
                case 1:
                    type = Type.One;
                    break;
                case 2:
                    type = Type.Two;
                    break;
                case 3:
                    type = Type.Three;
                    break;
                default:
            }
            return type;
        }
    }

    /**
     * 用定义调用存储过程后，如何把数据库类型转换为对应的Java类型
     */
    @Override
    public Type getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String key = cs.getString(columnIndex);
        Integer integer = Integer.parseInt(key);
        Type type = null;
        switch (integer) {
            case 1:
                type = Type.One;
                break;
            case 2:
                type = Type.Two;
                break;
            case 3:
                type = Type.Three;
                break;
            default:
        }
        return type;
    }
}
