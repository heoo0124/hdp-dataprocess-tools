package com.sibu.encrypt.start;


import lombok.extern.slf4j.Slf4j;

import java.io.*;
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
        String[] cmd = { "/bin/sh", "-c",
                "sudo mongodump -h dds-wz9150598efb12741.mongodb.rds.aliyuncs.com:3717 -u \"sdbackend\" -p \"gwGm9V44oZsqDOXFjlXat8sM\" -d sdbackend_mongo -c sd_msg_task -o /data/data/mongodump" };
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

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
