package com.dataprocess.tools.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <pre>
 *  file:com.sibu.mall.dataprocess.hdp.sqoop.util.GetLocation
 *  Copyright (c) 2020, wljs.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *
 *  Revision History
 *  Date,              Who,               What;
 *  2020/12/4 10:18           @author 子一          Initial.
 *
 * </pre>
 */
public class GetLocation {
    public static Map<String,String> getLnglat(String longitude, String latitude) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(longitude).append(",").append(latitude);
        //"http://restapi.amap.com/v3/geocode/geo?address=上海市东方明珠&output=JSON&key=xxxxxxxxx";
        String geturl = "https://restapi.amap.com/v3/geocode/regeo?output=json&location="+buffer+"&key=a404c7cede48a035edf876d88c951ef2&radius=1000&extensions=all";
        String location = "";
        Map<String,String> map= new HashMap<String,String>();
        try {
            // 把字符串转换为URL请求地址
            URL url = new URL(geturl);
            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(1500);
            connection.setReadTimeout(1500);
            connection.connect();// 连接会话
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            // 循环读取流
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接
            JSONObject a = JSONObject.parseObject(sb.toString());
            //判断输入的位置点是否存在
            JSONObject json=a.getJSONObject("regeocode");
            String detailAddress=json.getString("formatted_address");
            JSONObject addressComponent=json.getJSONObject("addressComponent");
            //String country=addressComponent.getString("country");
            String province=addressComponent.getString("province");
            String city=addressComponent.getString("city");
            String county=addressComponent.getString("district");
            String township=addressComponent.getString("township");
            map.put("detailAddress",detailAddress);
            map.put("province",province);
            map.put("county",county);
            if(province.equals("北京市") || province.equals("天津市") ||province.equals("上海市") ||province.equals("重庆市")){
                map.put("city",province);
            }else {
                map.put("city",city);
            }
            map.put("township",township);
        } catch (Exception e) {
            //e.printStackTrace();
            //System.out.println("失败!");
        }
        return map;
    }

    public static Map<String,String> getAddress(String detail, String city) {
        String geturl = "http://restapi.amap.com/v3/geocode/geo?address="+detail+"&city="+city+"&key=a404c7cede48a035edf876d88c951ef2";
        //String geturl = "https://restapi.amap.com/v3/geocode/regeo?output=json&location="+buffer+"&key=f5702f717845f7ee603486bbda083220&radius=1000&extensions=all";
        String location = "";
        Map<String,String> map= new HashMap<String,String>();
        try {
            // 把字符串转换为URL请求地址
            URL url = new URL(geturl);
            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.connect();// 连接会话
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            // 循环读取流
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接
            JSONObject a = JSONObject.parseObject(sb.toString());
            //判断输入的位置点是否存在
            JSONObject json=a.getJSONArray("geocodes").getJSONObject(0);
            String detailAddress=json.getString("formatted_address");
            //JSONObject addressComponent=json.getJSONObject("addressComponent");
            String county=json.getString("district");
            String township=json.getString("township");
            String province=json.getString("province");
            map.put("detailAddress",detailAddress);
            if("[]".equals(county)){
                map.put("county",township);
            }else {
                map.put("county",county);
            }
            map.put("province",province);
            if(province.equals("北京市") || province.equals("天津市") ||province.equals("上海市") ||province.equals("重庆市")){
                map.put("city",province);
            }else {
                map.put("city",json.getString("city"));
            }
        } catch (Exception e) {
            //e.printStackTrace();
            //System.out.println("失败!");
        }
        return map;
    }

    public static void main(String[] args) {
        List<String> contents=new ArrayList<String>();
        try {
            contents.addAll(FileUtils.readLines(new File("D:\\27461.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String content : contents)
        {
            String[] splitArray = content.split(",");
             Map<String,String> detail=getLnglat(splitArray[2],splitArray[1]);
            String addr = "";
            /*if("NULL".equals(splitArray[5])){
                addr = splitArray[2]+splitArray[1];
            }else {
                addr = splitArray[5] + splitArray[6] + splitArray[1];
            }
            Map<String, String> detail = getAddress(addr, splitArray[4]);*/
            if(detail.size() > 0) {
                StringBuffer buffer = new StringBuffer();
                buffer.append(splitArray[0]).append(",").append(detail.get("detailAddress")).append(",")
                        .append(detail.get("county")).append(",").append(detail.get("province")).append(",")
                        .append(detail.get("city"));
                System.out.println(buffer.toString());
            }
        }
    }
}
