SELECT
to_date(from_unixtime(cast(time/1000 as BIGINT))) as '日期',
count(if(element_name='all',1,null)) as '全部',
count(if(element_name='slt',1,null)) as '八宝',
count(if(element_name='clr',1,null)) as '彩宝',
count(if(element_name='nby_shp',1,null)) as '附近门店',
count(if(element_name='curr_ste',1,null)) as '当前位置',
count(if(element_name='srch_ste',1,null)) as '搜索地点',
count(if(element_name='cust_svc',1,null)) as '在线客服',
count(if(element_name='cust_cntr',1,null)) as '个人中心'


from impala_sensors.general_click WHERE page_name='page_sd_chrg'
and time >= unix_timestamp('2021-01-01')*1000 AND time < unix_timestamp('2021-01-23')*1000
group by to_date(from_unixtime(cast(time/1000 as BIGINT)))
ORDER BY to_date(from_unixtime(cast(time/1000 as BIGINT))) DESC;