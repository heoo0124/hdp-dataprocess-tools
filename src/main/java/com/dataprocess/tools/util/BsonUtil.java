package com.dataprocess.tools.util;

import com.dataprocess.tools.constants.Constants;
import org.bson.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  file:com.sibu.encrypt.util.BsonUtil
 *  Copyright (c) 2020, www.sdbattery.com All Rights Reserved.
 *
 *  Description:
 *
 *
 *  Revision History
 *  Date,                    Who,                       What;
 *  2020-10-12 20:49          @author yangtaiwei         Initial.
 *
 * </pre>
 */
public class BsonUtil
{
    /**
     * 替换bson字段对应的值存在换行符的;
     * @author yangtaiwei
     * @date 20:42 2020-10-13
     * @param file
     * @return java.lang.String
     **/
    private static String replaceLinefeed(File file)
    {
        // user.dir指定了当前的路径
        System.out.println(System.getProperty("user.dir"));
        int count = 0;
        BSONObject obj = null;
        try (FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(
                        new File("E:\\chromedownload\\sd_erp_sale_stock_out.bson"));
                InputStream inputStream = new BufferedInputStream(fileInputStream))
        {

            BSONDecoder decoder = new BasicBSONDecoder();
            BSONEncoder encoder = new BasicBSONEncoder();
            while (inputStream.available() > 0)
            {
                obj = decoder.readObject(inputStream);
                if (obj == null)
                {
                    break;
                }
                for (String key : obj.keySet())
                {
                    if (StringUtils.isNotEmpty(obj.get(key)) && obj.get(key).getClass() == String.class)
                    {
                        obj.put(key, obj.get(key).toString().replaceAll("(\\r\\n|\\n|\\n\\r)", ""));
                    }
                }
                fileOutputStream.write(encoder.encode(obj));
                count++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.err.println(String.format("%s objects read", count));
        return obj.toString();
    }

    private static String mongoStruct(File file)
    {
        StringBuilder dropTableSql = new StringBuilder();
        StringBuilder createTableSql = new StringBuilder();
        // user.dir指定了当前的路径
        System.out.println(System.getProperty("user.dir"));
        int max = 0;
        BSONObject obj = null;
        try (FileInputStream fileInputStream = new FileInputStream(file);
             InputStream inputStream = new BufferedInputStream(fileInputStream))
        {

            BSONDecoder decoder = new BasicBSONDecoder();
            while (inputStream.available() > 0)
            {
                obj = decoder.readObject(inputStream);
                if (obj == null)
                {
                    break;
                }
                if (obj.keySet().size() > max)
                {
                    max = obj.keySet().size();
                    dropTableSql = buildDropTableSql("sdbackend_mongo", "sd_erp_sale_stock");
                    createTableSql = buildCreateTableSql("sdbackend_mongo","sd_erp_sale_stock", obj);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.err.println(String.format("%s objects read", max));
        return String.join("\n--------华丽分割符---------\n",dropTableSql,createTableSql);
    }

    private static StringBuilder buildCreateTableSql(String dbName, String tableName, BSONObject obj)
    {
        StringBuilder createBuilder = new StringBuilder();
        createBuilder.append("CREATE TABLE IF NOT EXISTS ").append(dbName).append(Constants.DOT).append(tableName).append(" (").append("    ").append("\n");
        createBuilder.append("    ").append("`sharing_seq`    STRING    comment '数据源地址',").append("\n");
        createBuilder.append("    ").append("`db_seq`    STRING    comment '数据库序号',").append("\n");
        createBuilder.append("    ").append("`tb_seq`    STRING    comment '数据表序号',").append("\n");
        List<String> fields = new ArrayList<>(obj.keySet());
        int size = fields.size()-1;

        for (String field : fields)
        {
            if (field.startsWith("_")) {
                field = field.split("_")[1];
            }

            String dataType = StringUtils.isEmpty(obj.get(field)) ? "STRING" : obj.get(field).getClass().getSimpleName().toUpperCase();
            createBuilder.append("    ").append("`").append(field).append("`").append("    ").append("INTEGER".equals(dataType) ? "BIGINT" : dataType);
            if (fields.indexOf(field) != size)
            {
                createBuilder.append(",");
            }
            createBuilder.append("\n");
        }

        createBuilder.append(" )  ").append("    ").append("\n");
        createBuilder.append("ROW FORMAT SERDE 'com.mongodb.hadoop.hive.BSONSerDe'").append("\n");
        createBuilder.append("WITH SERDEPROPERTIES('mongo.columns.mapping'='{\"id\":\"_id\"}')").append("\n");
        createBuilder.append("STORED AS INPUTFORMAT 'com.mongodb.hadoop.mapred.BSONFileInputFormat'").append("\n");
        createBuilder.append("OUTPUTFORMAT 'com.mongodb.hadoop.hive.output.HiveBSONFileOutputFormat'").append("\n");
        //createBuilder.append("location").append(" \"").append(apolloDto.getPathPrefix()).append(StringUtils.getName(sqoopParamsDto.getDatabaseName())).append("/").append(StringUtils.getName(sqoopParamsDto.getTableName())).append("\"").append(" \n");
        createBuilder.append("location").append(" '/data/business/").append(dbName).append("/").append(tableName).append("'; \n");

        return createBuilder;
    }

    private static StringBuilder buildDropTableSql(String dbName, String tableName)
    {
        StringBuilder deleteBuilder = new StringBuilder();
        deleteBuilder.append("DROP TABLE IF EXISTS ").append(dbName).append(Constants.DOT).append(tableName).append(";");
        return deleteBuilder;
    }

    public static void main(String[] args)
    {
        //System.out.println(replaceLinefeed(new File("E:\\chromedownload\\sd_erp_sale_stock.bson")));
        System.out.println(mongoStruct(new File("E:\\chromedownload\\sd_msg_task._COPYING_")));
    }

}
