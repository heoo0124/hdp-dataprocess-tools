package com.dataprocess.tools.constants;

/**
 * <pre>
 *  Copyright (c) 2020, wljs.com All Rights Reserved.
 *
 *  Description: 变量工具类
 *  ${TODO}
 *
 *  Revision History
 *  Date,              Who,               What;
 *  2020-03-18         @author dengzs          Initial.
 *
 * </pre>
 */
public interface Constants {

    public static final String ALL = "ALL";

    public static final String QUEUE_DEFAULT = "default";

    public static final String PBE_SALT = "Yigipjbos04=";

    public static final String PBE_PWD = "wljs2020";

    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";

    public static final String HIVE_DRIVER = "org.apache.hive.jdbc.HiveDriver";

    public static final String POSTGRE_DRIVER = "org.postgresql.Driver";

    public static final String IMPALA_DRIVER = "com.cloudera.impala.jdbc41.Driver";

    public static final String POSTGRE_URL = "jdbc:postgresql://%1$s:%2$s/%3$s";

    public static final String MYSQL_URL = "jdbc:mysql://%1$s:%2$s/%3$s?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false";

    public static final String HIVE_URL = "jdbc:hive2://%1$s:%2$s/default";

    public static final String IMPALA_URL = "jdbc:impala://%1$s:%2$s/impala";

    public static final String SQL_SELECT = "SELECT * FROM ";

    public static final String SQL_MYSQL_SHOW_FULL = "SHOW FULL COLUMNS FROM %1$s";

    public static final String SQL_POSTGRE_SHOW_FULL = "SELECT (SELECT description FROM pg_catalog.pg_description WHERE objoid=a.attrelid and objsubid=a.attnum) as Comment FROM pg_catalog.pg_attribute a WHERE 1=1 and a.attrelid=(SELECT oid from pg_class WHERE relname='%1$s' ) and a.attnum>0 and not a.attisdropped order by a.attnum";

    public static final String COMMENT = "Comment";

    public static final String DATASOURCE_MYSQL = "MYSQL";

    public static final String DATASOURCE_POSTGRESQL = "POSTGRESQL";

    public static final String DATASOURCE_HIVE = "HIVE";

    public static final String DATASOURCE_IMPALA = "IMPALA";

    public static final String EXTRACTOR = "Extractor";

    public static final String STRUCT = "Struct";

    public static final String SHARING_FLAG = "true";

    public static final String LEFT_BRACE="{";

    public static final String RIGHT_BRACE="}";

    public static final String LEFT_BRACKET="[";

    public static final String RIGHT_BRACKET="[";

    public static final String NUDER_LINE="_";

    public static final String COMMA=",";

    public static final String DOT=".";

    public static final String SORT = "sort";// 建表排序字段sort，kudu语法不支持，建表时候加 S后缀

    public static final Integer MAX_FOUR_LENGTH=4;

    public static final Integer MAX_ONE_LENGTH=1;

    public static final Integer MAX_TWO_LENGTH=2;

    public static final Integer MIN_LENGTH=0;

    public static final String SEMICOLON=";";


}
