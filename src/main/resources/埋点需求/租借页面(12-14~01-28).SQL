SELECT
    to_date(from_unixtime(cast(time/1000 as BIGINT))) as '日期',
    count(1) as '租借页面-点击量',
    count(if(element_name='fre_rent',1,null)) as '信用租借-点击量',
    count(if(element_name='dpst_rent',1,null)) as '押金租借-点击量',
    count(if(element_name='imdt_rent',1,null)) as '立即租借-点击量'


from impala_sensors.general_click WHERE page_name = 'page_rent_chrg'
AND time >= unix_timestamp('2020-12-14')*1000 AND time < unix_timestamp('2021-01-29')*1000

GROUP BY to_date(from_unixtime(cast(time/1000 as BIGINT)));