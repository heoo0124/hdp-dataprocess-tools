SELECT
    to_date(from_unixtime(cast(time/1000 as BIGINT))) as '日期',
    count(if(element_name='scn_rent',1,null)) as '扫码租借',
    count(if(element_name='pwd_rent',1,null)) as '密码租借'


from impala_sensors.general_click WHERE page_name = 'page_shp_detl'
AND time >= unix_timestamp('2020-12-14')*1000 AND time < unix_timestamp('2021-02-25')*1000

GROUP BY to_date(from_unixtime(cast(time/1000 as BIGINT)));


with general_click as (
	select * from impala_sensors.general_click where time >= unix_timestamp('2020-12-14')*1000 AND time < unix_timestamp('2021-02-25')*1000
),

general_view as (
	select * from impala_sensors.general_view where time >= unix_timestamp('2020-12-14')*1000 AND time < unix_timestamp('2021-02-25')*1000
),

scn_click as (
    select distinct_id,time from general_click WHERE page_name = 'page_shp_detl' and element_name='scn_rent'
),

pwd_click as (
    select distinct_id,time from general_click WHERE page_name = 'page_shp_detl' and element_name='pwd_rent'
)

select
    to_date(from_unixtime(cast(general_view.time/1000 as BIGINT))) as '日期',
    count(if(general_view.distinct_id is not null and scn_click.distinct_id is not null,1,null)) as '扫码租借成功',
    count(if(general_view.distinct_id is not null and pwd_click.distinct_id is not null,1,null)) as '密码租借成功'
from general_view
left join scn_click on general_view.distinct_id = scn_click.distinct_id and substr(from_unixtime(cast(scn_click.time/1000 as BIGINT)),1,16) = substr(from_unixtime(cast(general_view.time/1000 as BIGINT)),1,16)
left join pwd_click on general_view.distinct_id = pwd_click.distinct_id and substr(from_unixtime(cast(pwd_click.time/1000 as BIGINT)),1,16) = substr(from_unixtime(cast(general_view.time/1000 as BIGINT)),1,16)
where general_view.page_name = 'page_fne_rent'
GROUP BY to_date(from_unixtime(cast(general_view.time/1000 as BIGINT)));



