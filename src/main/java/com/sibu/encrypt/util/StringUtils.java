package com.sibu.encrypt.util;

import com.sibu.encrypt.constants.Constants;

import java.util.Collection;
import java.util.Map;

/**
 * <pre>
 *  file:com.sibu.mall.dataprocess.common.util.StringUtils
 *  Copyright (c) 2019, wljs.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *
 *  Revision History
 *  Date,              Who,               What;
 *  2019/9/9 16:22           @author 子一          Initial.
 *
 * </pre>
 */
public class StringUtils
{

    public static boolean isEmpty(Object obj)
    {
        if (obj == null){
            return true;
        }

        if (obj instanceof CharSequence){
            return ((CharSequence) obj).length() == 0;
        }

        if (obj instanceof Collection){
            return ((Collection) obj).isEmpty();
        }

        if (obj instanceof Map){
            return ((Map) obj).isEmpty();
        }

        if (obj instanceof Object[])
        {
            Object[] object = (Object[]) obj;
            if (object.length == 0)
            {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++)
            {
                if (!isEmpty(object[i]))
                {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }

    public static boolean isNotEmpty(Object obj)
    {
        return !isEmpty(obj);
    }

    public static String toUpperCaseFirstOne(String s)
    {
        if (Character.isUpperCase(s.charAt(0)))
        {
            return s;
        }
        else
        {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * 判断是JsonObject
     *
     * @param obj
     * @return
     */
    public static boolean isJsonObject(Object obj)
    {
        String content = obj.toString();
        try
        {
            if (content.startsWith(Constants.LEFT_BRACE))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * 判断是JsonArray
     *
     * @param obj
     * @return
     */
    public static boolean isJsonArray(Object obj)
    {
        String content = obj.toString();
        try
        {
            if (content.startsWith(Constants.LEFT_BRACKET))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * 从字符串中获取数字
     *
     * @param str
     * @return
     */
    public static String getNumber(String str)
    {
        return str.replaceAll("\\D+", "");
    }

    /**
     * 从字符串中获取字母
     *
     * @param str
     * @return
     */
    public static String getString(String str)
    {
        return str.replaceAll("\\d+", "").replaceAll("ym","");
    }

    public static String getName(String str)
    {
        String database = getString(str);
        if (database.endsWith(Constants.NUDER_LINE))
        {
            database = database.substring(0, database.length() - 1);
        }
        return database;
    }

    public static void main(String[] args) {
        System.out.println(getName("auth_taobao_authorization_history_record_3"));
    }
}
