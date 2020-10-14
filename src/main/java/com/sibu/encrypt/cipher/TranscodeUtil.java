package com.sibu.encrypt.cipher;

import com.sibu.encrypt.constants.Constants;
import com.sibu.encrypt.start.CipherUtil;
import org.apache.commons.net.util.Base64;

/**
 * <pre>
 *  file:org.sicn.lee.apollo.TranscodeUtil
 *  Copyright (c) 2020, wljs.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *
 *  Revision History
 *  Date,              Who,               What;
 *  2020/3/23 12:14            @author子一          Initial.
 *
 * </pre>
 */
public class TranscodeUtil
{
    // base64字符串转byte[]

    public static byte[] base64StrToByteArray(String base64Str)
    {
        return Base64.decodeBase64(base64Str);
    }

    public static String byteArrayToBase64Str(byte[] b)
    {
        return Base64.encodeBase64String(b);
    }

    public static String byteArrayToHexStr(byte... src)
    {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0)
        {
            return null;
        }
        for (int i = 0; i < src.length; i++)
        {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2)
            {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        /*System.out.println(CipherUtil.generatePbeSalt());*/
        /*System.out.println(CipherUtil.pbeEncrypt(\"rm-wz976vto9g9tnh904.mysql.rds.aliyuncs.com\",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("3306",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("develop",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("U2@amhtEs6YhU6",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("mall_activity",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("act_config,act_faddish,act_faddish_point,act_faddish_point_product,act_faddish_product,act_faddish_product_goods,act_faddish_product_goods_log,act_faddish_record",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("trace",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("/data/latest_code/",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("false",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("mysql",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("/data/business/", Constants.PBE_PWD, Constants.PBE_SALT));*/

        /*System.out.println(CipherUtil.pbeDecrypt("HWPs34EG4UPpYXw7tnTGI4JCOa8OXZDUiyBKES/Z+eKL6FEqKgk1FXHd75aIjRGh", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeDecrypt("/vb/ZDGzj/I=", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeDecrypt("eL4BBncFURk=", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeDecrypt("bxLpwN6mQgDW75+nP6CH3Q==", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeDecrypt("ukeWvnXqTIQWbE1bXIYm7g==", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeDecrypt("7qgR/8nZp7Dai5Du7mfV5I0mlA0Lt/vNOZBhZ66zHqeNMF0hpNL04SAbTTMmv3MM3WE+VWZmLGCRl3wyElURpS2gWSx/TXSjXrZL4vQin0Q1kmqu5W0tqMbH3Y2K7ueAZJXN+FYncXmfGXhJtSZ5nmQb//go3ecHkQpJEnXszO9c6dcKXWniGXR0D1a+r9209tiHuaoNF5QV98aJjEKrJdNMzuhzvGCD", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeDecrypt("tNM0fswXsaA=", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeDecrypt("wmPeMlR+vojLKKB7mNchjEFONAok3UeV", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeDecrypt("2OaMVHNiy1Q=", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeDecrypt("vxGxlyDkzXc=", Constants.PBE_PWD, Constants.PBE_SALT));*/


        /*System.out.println(CipherUtil.pbeEncrypt("10.0.46.98", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("15432", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("bigdata_pg_rd", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("CJzqYvBii1LM", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("mall_member", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("mall_member", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("auth_member_login_record,auth_member_login_record_default,auth_nullify_record,auth_oauth_record,auth_refresh_token,auth_taobao_authorization_history_record,auth_taobao_authorization_record,auth_wx_kf_subscribe_event,deleted_member,member,member_address,member_alipay_account,member_certification_info,member_change_record,member_identity_card_info,member_invite_code_record,member_mobile_change_record,member_shop,member_talent_discount,member_wechat_apply,region,relationship_follow,relationship_recommend", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("postgresql", Constants.PBE_PWD, Constants.PBE_SALT));*/

        /*System.out.println(CipherUtil.pbeDecrypt("o1AYqfUiUJCpO23a0ApFSg==", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeDecrypt("hEA/+PBH2gQ=", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeDecrypt("dIBjT4r+juumRkjztwPR2g==", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeDecrypt("mEvfmOEDA8Li3mGeMnrtAQ==", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeDecrypt("fca5CHWyC4IlFdYF70aAkw==", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeDecrypt("rlzLkWl4PBrauMy7REdB/DfrH35kWHIapchuVVfO9O2RFW6hnzholl4OhY6YHG3XQ0onM3usLT7wGUgcfy828jTNkNVkS1Ak8E9F7VNEo0+FNgk/sw+UOBHCNDSGEC9XBCtHA2CfDuPtCTsrIEFfdVjuk3xnmEkVne07vvHsq5hPVcKMU4sxC9L57Wi3MFukFRvFfshY5KockcBzbocA4Je71ClLyVqJviulmXmKTk9VpspkO6ZOP3NBt9djjWagWxT3WjeHF/PGFB9Z8a4IWzusfIbVCa1FfEA8hZPEwBkR6HQAmiVhZE6otk7Zy1zML1H6//4NFBPNEHfni7cl1o+yKYrMUs8hiUrGmJaKYTGHvm3YtKCJetc/WtzhlRjFDtRdmTW7R8AO/PK1kjKOYxwSVugehxq6x106+XPnfTgRi0tBMX10ENx0IYnV3JAZYTX60BKm77zw09/DF3t6WcWU7TL/oW6gYAuokC3N+r2htSBE9aAsnB3oRuvxtET4lxx0S1s5cOctmLBFovVq+vb82MJjC92/LU4mrP0o/K+RTBG80hrg//8PFxZzq5OHld78hB6FTSWYcCBJdM5nqBaoPaqLy/ceKo65SeNcCiKuacjg/j0uxKeByXiBgaJD4SE5shzC3sT3as3iVLhzY++RL7ogy6X3BlKc/7gjFr0=", Constants.PBE_PWD, Constants.PBE_SALT));*/

       /* System.out.println(CipherUtil.pbeEncrypt("pgm-wz9se919g2rmlyt8129210.pg.rds.aliyuncs.com", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("1433", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("bigdata_pg_rd", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("CJzqYvBii1LM", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("mall_member", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println(CipherUtil.pbeEncrypt("{\"table_01\":\"region,member_identity_card_info,auth_nullify_record,member_invite_code_record,member_mobile_change_record,member_wechat_apply,member_alipay_account,auth_taobao_authorization_history_record,auth_member_login_record,member_address,deleted_member,relationship_recommend,member_shop,auth_refresh_token,auth_taobao_authorization_history_record,member_address,auth_member_login_record,auth_member_login_record_default,auth_wx_kf_subscribe_event,relationship_follow,member_talent_discount,member_certification_info,auth_taobao_authorization_record,member_net_sign,member,member_change_record\"}", Constants.PBE_PWD, Constants.PBE_SALT));*/

        /*System.out.println(CipherUtil.pbeDecrypt("1W6CRyYeEHXJXGd5fLIk37C6v2Ghk9MiPbYR6jE0cmM=", Constants.PBE_PWD, Constants.PBE_SALT));*/

        /*System.out.println("host="+CipherUtil.pbeEncrypt("pgm-wz9se919g2rmlyt8129210.pg.rds.aliyuncs.com",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("port="+CipherUtil.pbeEncrypt("1433",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("user_name="+CipherUtil.pbeEncrypt("bigdata_pg_rd",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("password="+CipherUtil.pbeEncrypt("CJzqYvBii1LM",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("database_name="+CipherUtil.pbeEncrypt("mall_member", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("table_name="+CipherUtil.pbeEncrypt("{\"table_01\":\"member_cps\"}",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("queue_name="+CipherUtil.pbeEncrypt("trace,debug,info,warn,error",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("path_prefix="+CipherUtil.pbeEncrypt("/data/business/",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("common_path="+CipherUtil.pbeEncrypt("{\"common_path_01\":\"/data/latest_code/\",\"common_path_02\":\"/data/latest_wljs_code/\",\"common_path_03\":\"/data/professional_work/\"}",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("sharing="+CipherUtil.pbeEncrypt("false",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("source="+CipherUtil.pbeEncrypt("postgresql",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("target_source="+CipherUtil.pbeEncrypt("impala",Constants.PBE_PWD, Constants.PBE_SALT));*/


       /* System.out.println("hive_host="+CipherUtil.pbeEncrypt("hdp-prod-02",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("hive_port="+CipherUtil.pbeEncrypt("10000",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("hive_user_name="+CipherUtil.pbeEncrypt("sicnlee",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("hive_password="+CipherUtil.pbeEncrypt("yuziyi10201102",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("impala_host="+CipherUtil.pbeEncrypt("hdp-prod-01",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("impala_port="+CipherUtil.pbeEncrypt("21050",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("impala_user_name="+CipherUtil.pbeEncrypt("sicnlee",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("impala_password="+CipherUtil.pbeEncrypt("yuziyi10201102",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("impala_partition_num="+CipherUtil.pbeEncrypt("22",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("impala_cluster="+CipherUtil.pbeEncrypt("hdp-prod-06,hdp-prod-05,hdp-prod-01,hdp-prod-09,hdp-prod-02,hdp-prod-11,hdp-prod-10,hdp-prod-07,hdp-prod-04,hdp-prod-03,hdp-prod-08",Constants.PBE_PWD, Constants.PBE_SALT));*/



       /* System.out.println("host="+CipherUtil.pbeDecrypt("+hAm7tXr8bJUVsDzgFsU0fdFu8AB/6nIxLJL7MxrY7JygQIH2Xk6ZwOJ3kRh+4Iz",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("port="+CipherUtil.pbeDecrypt("/vb/ZDGzj/I=",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("user_name="+CipherUtil.pbeDecrypt("eL4BBncFURk=",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("password="+CipherUtil.pbeDecrypt("bxLpwN6mQgDW75+nP6CH3Q==",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("database_name="+CipherUtil.pbeDecrypt("/pF6gfKsSTo+LgYDWw98U1wBhg47/X/L",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("table_name="+CipherUtil.pbeDecrypt("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",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("queue_name="+CipherUtil.pbeDecrypt("1W6CRyYeEHXJXGd5fLIk37C6v2Ghk9MiPbYR6jE0cmM=",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("path_prefix="+CipherUtil.pbeDecrypt("j2QmG4vGIacXE8/okKfR5Q==",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("common_path="+CipherUtil.pbeDecrypt("oGgv8+MaPH5O5bjiUK9YH5lrLUD79qq+ZitSAc5E9xFa9rC81R1e3qgzKTxXcNKcnCV8F9qdjw7BPagjCDGegp/GrXJwfOmK5/HZzGPfL7nqXbFLKl+ZmPVgYsSiD81yQZDfjswAN8HUttyP0ahzS/kxtfOt6hwQoP+Ex1aTN90=",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("sharing="+CipherUtil.pbeDecrypt("lpz8L8jk5Wc=",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("source="+CipherUtil.pbeDecrypt("vxGxlyDkzXc=",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("target_source="+CipherUtil.pbeDecrypt("oj0tj9ZGH5w=",Constants.PBE_PWD, Constants.PBE_SALT));*/


       /* System.out.println("financial_account_split:"+CipherUtil.pbeEncrypt("financial_account_split", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("financial_settle_split:"+CipherUtil.pbeEncrypt("financial_settle_split", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("mall_cart:"+CipherUtil.pbeEncrypt("mall_cart", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("mall_coupon_user:"+CipherUtil.pbeEncrypt("mall_coupon_user", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("mall_pay_order:"+CipherUtil.pbeEncrypt("mall_pay_order", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("mall_profit:"+CipherUtil.pbeEncrypt("mall_profit", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("mall_promotion_activity:"+CipherUtil.pbeEncrypt("mall_promotion_activity", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("mall_selection:"+CipherUtil.pbeEncrypt("mall_selection", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("mall_tkorder:"+CipherUtil.pbeEncrypt("mall_tkorder", Constants.PBE_PWD, Constants.PBE_SALT));*/
        /*System.out.println("mall_order:"+CipherUtil.pbeDecrypt("j2QmG4vGIacXE8/okKfR5Q==", Constants.PBE_PWD, Constants.PBE_SALT));*/
        /*System.out.println("mall_order:"+CipherUtil.pbeEncrypt("wanghongyu", Constants.PBE_PWD, Constants.PBE_SALT));*/

        /*System.out.println("host="+CipherUtil.pbeDecrypt("KkPOHRNCgxWVLJIYzd6mBtTz1C/5vBNqm1mQwU0FzduJ9j4cPo0mcw8i+BUhL9o2",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("port="+CipherUtil.pbeDecrypt("gZz9O1lVlQA=",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("user_name="+CipherUtil.pbeDecrypt("BRWrKQVopyqEw5c2GYPZJA==",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("password="+CipherUtil.pbeDecrypt("9zidYdwTY5P5rq+Y4/asNfI9s5Yja6i9",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("database_name="+CipherUtil.pbeDecrypt("cdRx6y8nguSvLE/Y8PAlbA==",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("table_name="+CipherUtil.pbeDecrypt("5qnkr59a4r8lDD+LlwIbfWcZFfXLWtgU040jgkFq1YDbbr4iSpld00uk99ODBoBkm4JSo0sgq89DB7gfIoORBdrV12bs7r+H2dKz8S6MtP+gcgacrbyZow==",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("queue_name="+CipherUtil.pbeDecrypt("IHBjx8nxIaSfK5ln3VFh2qaHvcGFa/qfQawkZ0g/wAo=",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("path_prefix="+CipherUtil.pbeDecrypt("5EeetDjD0nULkPS/1kwqQQ==",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("common_path="+CipherUtil.pbeDecrypt("wd3kBX+fRepjJZn21zrkYIhrAcixDAIdh3BOVxISr9qJ8x1ZBMgJHR9M7j9EyGS6BcDsKSV14p7pvSBUg8P/iq9Quc1bLgXEFC++Vn5lwjNKhdc9CgAinbeRmBtvgj9QFaugqRslG2xNzaRO3gMcVx54oR+Ff8DnTg3orSCmiFw=",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("sharing="+CipherUtil.pbeDecrypt("eEPYRlAE5uQ=",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("source="+CipherUtil.pbeDecrypt("6eM4NX4JgHc=", Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("target_source="+CipherUtil.pbeDecrypt("rF8euboCGQE=",Constants.PBE_PWD, Constants.PBE_SALT));*/
        /*List<String> contents=new ArrayList<String>();
        try {
            contents.addAll(FileUtils.readLines(new File("D:\\test-en.SQL")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer buffer=new StringBuffer();
        for (String content:contents){
            buffer.append(content);
        }
        System.out.println(CipherUtil.pbeEncrypt(buffer.toString(), Constants.PBE_PWD, Constants.PBE_SALT));*/

        /*System.out.println(CipherUtil.pbeDecrypt("VXrtaxfriT2Qgot6PWsjpMdagr1SXw1lU1q44YhUKoHAW3Z9GFNbKyERPpbP97nz", Constants.IMP_PBE_SALT, Constants.IMP_PBE_PWD));*/
        /*List<String> contents=new ArrayList<String>();
        try {
            contents.addAll(FileUtils.readLines(new File("D:\\a.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer buffer=new StringBuffer();
        for (String content:contents){
            buffer.append(content);
        }
        System.out.println(CipherUtil.pbeDecrypt(buffer.toString(), Constants.IMP_PBE_PWD, Constants.IMP_PBE_SALT));*/

        /*System.out.println("database_settings="+CipherUtil.pbeDecrypt("{\"host\":\"sdadsaf\",\"userName\":\"sdafdfs\",\"password\": \"asdfasdf\"}",Constants.PBE_PWD, Constants.PBE_SALT));*/
        System.out.println("host="+ CipherUtil.pbeEncrypt("{\"host_01\":\"rr1-wz9w4787jew8ysgei.mysql.rds.aliyuncs.com\",\"host_02\":\"rr2-wz9w4787jew8ysgei.mysql.rds.aliyuncs.com\",\"host_03\":\"rr3-wz9w4787jew8ysgei.mysql.rds.aliyuncs.com\",\"host_04\":\"rr4-wz9w4787jew8ysgei.mysql.rds.aliyuncs.com\",\"host_05\":\"rr5-wz9w4787jew8ysgei.mysql.rds.aliyuncs.com\",\"host_06\":\"rr6-wz9w4787jew8ysgei.mysql.rds.aliyuncs.com\",\"host_07\":\"rr7-wz9w4787jew8ysgei.mysql.rds.aliyuncs.com\",\"host_08\":\"rr8-wz9w4787jew8ysgei.mysql.rds.aliyuncs.com\"}",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("host="+CipherUtil.pbeEncrypt("{\"host_01\":\"3301\",\"port_02\":\"3302\",\"port_03\":\"3303\",\"port_04\":\"3304\",\"port_05\":\"3305\",\"port_06\":\"3306\",\"port_07\":\"3307\",\"port_08\":\"3308\"}",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("user_name="+CipherUtil.pbeEncrypt("{\"user_name_01\":\"pro_bigdata_rd_01\",\"user_name_02\":\"pro_bigdata_rd_02\",\"user_name_03\":\"pro_bigdata_rd_03\",\"user_name_04\":\"pro_bigdata_rd_04\",\"user_name_05\":\"pro_bigdata_rd_05\",\"user_name_06\":\"pro_bigdata_rd_06\",\"user_name_07\":\"pro_bigdata_rd_07\",\"user_name_08\":\"pro_bigdata_rd_08\"}",Constants.PBE_PWD, Constants.PBE_SALT));
        System.out.println("password="+CipherUtil.pbeEncrypt("{\"password_01\":\"U4kD2l4GjbLTdLHy_01\",\"password_02\":\"U4kD2l4GjbLTdLHy_02\",\"password_03\":\"U4kD2l4GjbLTdLHy_03\",\"password_04\":\"U4kD2l4GjbLTdLHy_04\",\"password_05\":\"U4kD2l4GjbLTdLHy_05\",\"password_06\":\"U4kD2l4GjbLTdLHy_06\",\"password_07\":\"U4kD2l4GjbLTdLHy_07\",\"password_08\":\"U4kD2l4GjbLTdLHy_08\"}",Constants.PBE_PWD, Constants.PBE_SALT));
    }
}
