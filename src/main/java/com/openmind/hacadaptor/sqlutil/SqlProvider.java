package com.openmind.hacadaptor.sqlutil;

import com.openmind.hacadaptor.util.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by KJB-001064 on 2017/6/22.
 * //用map或者Page什么的包装一个类传入， 就可以附带各种其他参数了
 */
public class SqlProvider {

    Logger logger = Logger.getLogger(SqlProvider.class);
    private TableFormat tableFormat = new HumpToUnderLineFormat();

    public String insert(Object bean) {
        Class<?> beanClass = bean.getClass();
        String tableName = getTableName(beanClass);
        Field[] fields = getFields(beanClass);
        StringBuilder insertSql = new StringBuilder();
        //mybatis 的参数化表示  #{xxx}
        List<String> insertParas = new ArrayList<String>();
        //字段名
        List<String> insertParaNames = new ArrayList<String>();
        insertSql.append("INSERT INTO ").append(tableName).append("(");
        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Column column = field.getAnnotation(Column.class);
                String columnName = "";
                if (column != null) {
                    if (!column.required())
                        continue;
                    columnName = column.value();
                }
                if (StringUtils.isEmpty(columnName)) {
                    columnName = tableFormat.getColumnName(field.getName());
                }
                field.setAccessible(true);
                Object object = field.get(bean);
                if (object != null) {
                    insertParaNames.add(columnName);
                    insertParas.add("#{" + field.getName() + "}");
                }
            }
        } catch (Exception e) {
            //throw
            new RuntimeException("get insert sql is exceptoin:" + e);
        }
        for (int i = 0; i < insertParaNames.size(); i++) {
            insertSql.append(insertParaNames.get(i));
            if (i != insertParaNames.size() - 1)
                insertSql.append(",");
        }
        insertSql.append(")").append(" VALUES(");
        for (int i = 0; i < insertParas.size(); i++) {
            insertSql.append(insertParas.get(i));
            if (i != insertParas.size() - 1)
                insertSql.append(",");
        }
        insertSql.append(")");
        logger.info("##insert sql##:" + insertSql.toString());
        return insertSql.toString();
    }

    public String update(Object bean) {
        Class<?> beanClass = bean.getClass();
        String tableName = getTableName(beanClass);
        Field[] fields = getFields(beanClass);
        StringBuilder updateSql = new StringBuilder();
        updateSql.append(" update ").append(tableName).append(" set ");
        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Column column = field.getAnnotation(Column.class);
                String columnName = "";
                if (column != null) {
                    if (!column.required())
                        continue;
                    columnName = column.value();
                }
                if (StringUtils.isEmpty(columnName)) {
                    columnName = tableFormat.getColumnName(field.getName());
                }
                field.setAccessible(true);
                Object beanValue = field.get(bean);
                if (beanValue != null) {
                    updateSql.append(columnName).append("=#{").append(field.getName()).append("}");
                    if (i != fields.length - 1) {
                        updateSql.append(",");
                    }
                }
            }
        } catch (Exception e) {
            new RuntimeException("get update sql is exceptoin:" + e);
        }
        updateSql.append(" where ").append(tableFormat.getId() + " =#{id}");
        logger.info("##update sql##:" + updateSql.toString());
        return updateSql.toString();
    }

    public String delete(Object bean) {
        Class<?> beanClass = bean.getClass();
        String tableName = getTableName(beanClass);
        Field[] fields = getFields(beanClass);
        StringBuilder deleteSql = new StringBuilder();
        deleteSql.append(" delete from ").append(tableName).append(" where  ");
        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Column column = field.getAnnotation(Column.class);
                String columnName = "";
                if (column != null) {
                    if (!column.required())
                        continue;
                    columnName = column.value();
                }
                if (StringUtils.isEmpty(columnName)) {
                    columnName = tableFormat.getColumnName(field.getName());
                }
                field.setAccessible(true);
                Object beanValue = field.get(bean);
                if (beanValue != null) {
                    deleteSql.append(columnName).append("=#{").append(field.getName()).append("}");
                    if (i != fields.length - 1) {
                        deleteSql.append(" and ");
                    }
                }
            }
        } catch (Exception e) {
            new RuntimeException("get delete sql is exceptoin:" + e);
        }
        logger.info("##delete sql##:" + deleteSql.toString());
        return deleteSql.toString();
    }

    public String select(Object bean) {
        Class<?> beanClass = bean.getClass();
        String tableName = getTableName(beanClass);
        Field[] fields = getFields(beanClass);
        StringBuilder selectSql = new StringBuilder();
        List<String> selectParaNames = new ArrayList<String>();
        List<String> selectParas = new ArrayList<String>();
        selectSql.append("select ");
        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Column column = field.getAnnotation(Column.class);
                String columnName = "";
                if (column != null) {
                    if (!column.required())
                        continue;
                    columnName = column.value();
                }
                if (StringUtils.isEmpty(columnName)) {
                    columnName = tableFormat.getColumnName(field.getName());
                }
                field.setAccessible(true);
                Object object = field.get(bean);
                selectSql.append(field.getName());
                if (object != null) {
                    if (object instanceof Integer)
                        selectParaNames.add(columnName);
                    selectParas.add("#{" + field.getName() + "}");
                }
                if (i != fields.length - 1)
                    selectSql.append(",");
            }
        } catch (Exception e) {
            new RuntimeException("get select sql is exceptoin:" + e);
        }
        selectSql.append(" from ").append(tableName);
        //如果bean的字段值都是空的，代表全查
        if (selectParaNames.size() > 0)
            selectSql.append(" where ");
        for (int i = 0; i < selectParaNames.size(); i++) {
            selectSql.append(selectParaNames.get(i)).append("=").append(selectParas.get(i));
            if (i != selectParaNames.size() - 1)
                selectSql.append(" and ");
        }
        logger.info("##select sql##:" + selectSql.toString());
        return selectSql.toString();
    }

    public String fuzzySelect(Object bean) {
        Class<?> beanClass = bean.getClass();
        String tableName = getTableName(beanClass);
        Field[] fields = getFields(beanClass);
        StringBuilder selectSql = new StringBuilder();
        List<String> selectParaNames = new ArrayList<String>();
        List<String> selectParas = new ArrayList<String>();
        selectSql.append("select ");
        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Column column = field.getAnnotation(Column.class);
                String columnName = "";
                if (column != null) {
                    if (!column.required())
                        continue;
                    columnName = column.value();
                }
                if (StringUtils.isEmpty(columnName)) {
                    columnName = tableFormat.getColumnName(field.getName());
                }
                field.setAccessible(true);
                Object object = field.get(bean);
                selectSql.append(field.getName());
                if (object != null) {
                    selectParaNames.add(columnName);
                    selectParas.add("#{" + field.getName() + "}");
                }
                if (i != fields.length - 1)
                    selectSql.append(",");
            }
        } catch (Exception e) {
            new RuntimeException("get fuzzy select sql is exceptoin:" + e);
        }
        selectSql.append(" from ").append(tableName).append(" where ");
        for (int i = 0; i < selectParaNames.size(); i++) {
            selectSql.append(selectParaNames.get(i)).append(" like '%").append(selectParas.get(i)).append("'% ");
            if (i != selectParaNames.size() - 1)
                selectSql.append(" and ");
        }
        logger.info("##fuzzy select sql##:" + selectSql.toString());
        return selectSql.toString();
    }


    public String selectCount(Object bean) {
        Class<?> beanClass = bean.getClass();
        String tableName = getTableName(beanClass);
        Field[] fields = getFields(beanClass);
        StringBuilder selectSql = new StringBuilder();
        List<String> selectParaNames = new ArrayList<>();
        List<String> selectParas = new ArrayList<>();
        selectSql.append("select count(1) ").append(" from ").append(tableName);
        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Column column = field.getAnnotation(Column.class);
                String columnName = "";
                if (column != null)
                    if (column.required())
                        columnName = column.value();
                if (StringUtils.isEmpty(columnName)) {
                    columnName = tableFormat.getColumnName(field.getName());
                }
                field.setAccessible(true);
                Object object = field.get(bean);
                selectSql.append(field.getName());
                if (object != null) {
                    selectParaNames.add(columnName);
                    selectParas.add("#{" + field.getName() + "}");
                }
                if (i != fields.length - 1)
                    selectSql.append(",");
            }
        } catch (Exception e) {
            new RuntimeException("get select count sql is exceptoin:" + e);
        }
        for (int i = 0; i < selectParaNames.size(); i++) {
            selectSql.append(selectParaNames.get(i)).append(" like '%").append(selectParas.get(i)).append("'% ");
            if (i != selectParaNames.size() - 1)
                selectSql.append(" and ");
        }
        logger.info("##select count sql##" + selectSql.toString());
        return selectSql.toString();
    }

    private String getTableName(Class<?> beanClass) {
        String tableName = "";
        Table table = beanClass.getAnnotation(Table.class);
        if (table != null) {
            tableName = table.value();
        } else {
            tableName = tableFormat.getTableName(beanClass.getSimpleName());
        }
        return tableName;
    }

    private Field[] getFields(Class<?> beanClass) {
        Field[] beanFields = beanClass.getDeclaredFields();
        Class<?> beanSuperClass = beanClass.getSuperclass();
        Field[] beanSuperFields = beanSuperClass.getDeclaredFields();
        return ArrayUtils.addAll(beanFields, beanSuperFields);
    }
}