package com.sibu.encrypt.util;

import org.bson.*;

import java.io.*;

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
    private static String replaceLineFeed(File file)
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
                /*
                 * if (StringUtils.isNotEmpty(obj.get("gui_equip_ids")))
                 * {
                 * System.out.println(obj);
                 * }
                 */
                for (String key : obj.keySet())
                {

                    if (StringUtils.isNotEmpty(obj.get(key)) && obj.get(key).getClass() == String.class)
                    {
                        obj.put(key, obj.get(key).toString().replaceAll("(\\r\\n|\\n|\\n\\r)", ""));
                    }
                }
                fileOutputStream.write(encoder.encode(obj));
                /*
                 * if (obj.keySet().size() > 50) {
                 * System.out.println(obj);
                 * break;
                 * }
                 */
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
                    dropTableSql = buildDropTableSql(obj);
                    createTableSql = buildCreateTableSql(obj);
                    break;
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.err.println(String.format("%s objects read", max));
        return String.join("--------华丽分割符---------\\n",dropTableSql,createTableSql);
    }

    private static StringBuilder buildCreateTableSql(BSONObject obj) {
        return null;
    }

    private static StringBuilder buildDropTableSql(BSONObject obj) {
        return null;
    }

    public static void main(String[] args)
    {
        System.out.println(replaceLineFeed(new File("E:\\chromedownload\\sd_erp_sale_stock.bson")));
    }

}
