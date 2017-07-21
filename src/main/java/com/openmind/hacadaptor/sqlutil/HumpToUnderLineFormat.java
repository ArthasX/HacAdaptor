package com.openmind.hacadaptor.sqlutil;

import com.openmind.hacadaptor.socket.util.ClassUtil;

import java.lang.reflect.Field;

/**
 * TODO ...wait to finish
 * Created by LiuBin on 2017/6/22.
 */
public class HumpToUnderLineFormat<T> implements TableFormat<T> {

    private Class clazz = ClassUtil.getSuperClassGenricType(getClass(), 0);

    /**
     * 根据field name 格式化 生成统一的colum name
     * 本次程序简单因此没有具体实现，如有需要待有具体标准后再实现
     * <p>
     * e.g. Field name is aaBbCcDd,
     * colum name may be aa_bb_cc_dd
     *
     * @param field
     * @return colum name
     */
    @Override
    public String getColumnName(String field) {
//        Field f = clazz.getField(field);
//        Column c = f.getAnnotation(Column.class);
//        return c.value();
        //TODO getTableName
        return field;
    }

    /**
     * 根据class name 格式化 生成统一的table name
     * 本次程序简单因此没有具体实现，如有需要待有具体标准后再实现
     *
     * @param className
     * @return table name
     */
    @Override
    public String getTableName(String className) {
        //TODO getTableName
        return className;
    }

    /**
     *
     * @return id name
     */
    @Override
    public String getId() {
        Field[] fields = clazz.getDeclaredFields();
        Column column;
        for (Field f : fields) {
            column = f.getAnnotation(Column.class);
            if (column.required() && column.value().equals("id"))
                return f.getName();
        }
        return "id";
    }


}
