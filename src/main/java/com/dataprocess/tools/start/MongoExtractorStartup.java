package com.dataprocess.tools.start;


import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

/**
 * <pre>
 *  file:com.sibu.mall.dataprocess.hdp.sqoop.start.MongoExtractorStartup
 *  Copyright (c) 2020, www.sdbattery.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *
 *  Revision History
 *  Date,                    Who,                       What;
 *  2020-10-11 17:11          @author yangtaiwei         Initial.
 *
 * </pre>
 */
@Slf4j
public class MongoExtractorStartup
{
    public static void main(String[] args)
    {
        /*File file = new File("/data/data/mongo/after/test.txt");
        File dir = new File(file.getParent());
        if(!dir.exists())
        {
            //创建目录
            try {
                Process exec = Runtime.getRuntime().exec("sudo mkdir -p " + file.getParent());
                BufferedReader err = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
                String line = null;
                while((line = err.readLine()) != null){
                    log.error("cmd error: {}",line);
                }
                Runtime.getRuntime().exec("sudo chown -R nobody:nobody " + file.getParent());
            } catch (IOException e) {
                log.error("cmd error: {}",e.getMessage());
            }

        }
        if(file.setWritable(true, false))
        {
            log.info("cmd setWritable: OK");
        }else {
            log.info("cmd setWritable: ERROR");
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(file))
        {
            InetAddress ia = InetAddress.getLocalHost();
            log.info("host: {},user:{}",ia.getHostName(),System.getProperty("user.name"));

            fileOutputStream.write("你y好啊！！！！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        String[] cmd = { "/bin/sh", "-c",
                "sudo mongodump -h dds-wz9150598efb12741.mongodb.rds.aliyuncs.com:3717 -u \"sdbackend\" -p \"gwGm9V44oZsqDOXFjlXat8sM\" -d sdbackend_mongo -c sd_msg_task -o /data/data/mongodump" };

        String[] cmd2 = { "/bin/sh", "-c",
                "sudo hdfs dfs -mkdir -p /data/business/sdbackend_mongo/sd_msg_task" };

        String[] cmd3 = { "/bin/sh", "-c",
                "sudo hdfs dfs -put /data/data/mongodump/sdbackend_mongo/sd_msg_task.bson /data/business/sdbackend_mongo/sd_msg_task" };
        try
        {
            Process exec = Runtime.getRuntime().exec(cmd);
            InetAddress ia = InetAddress.getLocalHost();
            log.info("host: {},user:{}",ia.getHostName(),System.getProperty("user.name"));

            BufferedReader read = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            String line = null;
            while((line = read.readLine())!=null){
                log.info("cmd out: {}",line);
            }
            BufferedReader err = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            while((line = err.readLine()) != null){
                log.error("cmd error: {}",line);
            }

            Runtime.getRuntime().exec(cmd2);

            Process exec3 = Runtime.getRuntime().exec(cmd3);
            String line3 = null;
            BufferedReader read3 = new BufferedReader(new InputStreamReader(exec3.getInputStream()));
            while((line3 = read3.readLine())!=null){
                log.info("cmd3 out: {}",line3);
            }
            BufferedReader err3 = new BufferedReader(new InputStreamReader(exec3.getErrorStream()));

            while((line3 = err3.readLine()) != null){
                log.error("cmd3 error: {}",line3);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
