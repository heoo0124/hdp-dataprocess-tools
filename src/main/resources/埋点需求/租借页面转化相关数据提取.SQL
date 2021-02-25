--1
with general_view as (
	select * from impala_sensors.general_view where time >= unix_timestamp('2021-01-09')*1000 AND time < unix_timestamp('2021-01-20')*1000
),

general_click as (
	select * from impala_sensors.general_click where time >= unix_timestamp('2021-01-09')*1000 AND time < unix_timestamp('2021-01-20')*1000
),

fne_rent_pv as (
	SELECT to_date(from_unixtime(cast(time/1000 as BIGINT))) as dt,count(1) as pv
from general_view WHERE page_name = 'page_fne_rent'
group by to_date(from_unixtime(cast(time/1000 as BIGINT)))

),

fne_rent_uv as(
	SELECT dt,count(1) as uv from
	(select distinct to_date(from_unixtime(cast(time/1000 as BIGINT))) as dt, if(user_id = '-1',distinct_id,user_id) as user_id from
	general_view WHERE page_name = 'page_fne_rent')a
group by dt
),

chrg_rent_cli as (
	SELECT to_date(from_unixtime(cast(time/1000 as BIGINT))) as dt,count(1) as pv
from general_click WHERE page_name = 'page_rent_chrg' AND element_name in ('fre_rent','dpst_rent')
group by to_date(from_unixtime(cast(time/1000 as BIGINT)))

),

chrg_rent_uv as(
	SELECT dt,count(1) as uv from
	(select distinct to_date(from_unixtime(cast(time/1000 as BIGINT))) as dt, if(user_id = '-1',distinct_id,user_id) as user_id from
impala_sensors.general_click WHERE page_name = 'page_rent_chrg' AND element_name in ('fre_rent','dpst_rent'))a
group by dt
)

select a.dt dt,a.pv,b.uv,c.pv, d.uv from fne_rent_pv a left join fne_rent_uv b on a.dt=b.dt
left join chrg_rent_cli c on a.dt=c.dt
left join chrg_rent_uv d on a.dt=d.dt;

--2
with general_click as (
	select * from impala_sensors.general_click where time >= unix_timestamp('2021-01-14')*1000 AND time < unix_timestamp('2021-01-20')*1000
),

general_view as (
	select * from impala_sensors.general_view where time >= unix_timestamp('2021-01-14')*1000 AND time < unix_timestamp('2021-01-20')*1000
),

fne_rent_uv as(
	SELECT dt,count(1) as uv from
	(select distinct to_date(from_unixtime(cast(time/1000 as BIGINT))) as dt, if(user_id = '-1',distinct_id,user_id) as user_id from
	general_view WHERE page_name = 'page_fne_rent' )a
group by dt
),

fne_rent_auth_uv as(
	SELECT a.dt,count(1) as uv from
	(select distinct to_date(from_unixtime(cast(time/1000 as BIGINT))) as dt, if(user_id = '-1',distinct_id,user_id) as user_id from
	impala_sensors.general_view WHERE page_name = 'page_fne_rent'
	and time >= unix_timestamp('2021-01-09')*1000 AND time < unix_timestamp('2021-01-20')*1000) a
	LEFT JOIN
	(select distinct to_date(from_unixtime(cast(time/1000 as BIGINT))) as dt, if(user_id = '-1',distinct_id,user_id) as user_id from impala_sensors.general_click
	WHERE page_name = 'page_rent_chrg' and element_name in ('cfse','cmfn') AND source in ('fre_rent','dpst_rent')
	AND  time >= unix_timestamp('2021-01-09')*1000 AND time < unix_timestamp('2021-01-20')*1000) b
	on a.user_id = b.user_id AND a.dt = b.dt WHERE b.user_id IS not NULL
group by a.dt
),

fne_rent_noauth_uv as(
	SELECT a.dt,count(1) as uv from
	(select distinct to_date(from_unixtime(cast(time/1000 as BIGINT))) as dt, if(user_id = '-1',distinct_id,user_id) as user_id from
	general_view WHERE page_name = 'page_fne_rent' ) a
	LEFT JOIN
	(select distinct to_date(from_unixtime(cast(time/1000 as BIGINT))) as dt, if(user_id = '-1',distinct_id,user_id) as user_id from general_click
	WHERE page_name = 'page_rent_chrg' and element_name in ('cfse','cmfn') AND source in ('fre_rent','dpst_rent')) b
	on a.user_id = b.user_id AND a.dt = b.dt WHERE b.user_id IS NULL
group by a.dt
),

chrg_rent_cli as (
	SELECT to_date(from_unixtime(cast(time/1000 as BIGINT))) as dt,count(1) as pv
from general_click WHERE page_name = 'page_rent_chrg' AND element_name in ('fre_rent','dpst_rent')
group by to_date(from_unixtime(cast(time/1000 as BIGINT)))

),

chrg_rent_uv as(
	SELECT dt,count(1) as uv from
	(select distinct to_date(from_unixtime(cast(time/1000 as BIGINT))) as dt, if(user_id = '-1',distinct_id,user_id) as user_id from
impala_sensors.general_click WHERE page_name = 'page_rent_chrg' AND element_name in ('fre_rent','dpst_rent'))a
group by dt
),

phone_auth_times as (
    SELECT to_date(from_unixtime(cast(time/1000 as BIGINT))) as dt,count(1) as pv
from general_click WHERE page_name = 'page_rent_chrg' AND element_name in ('cfse','cmfn') AND source in ('fre_rent','dpst_rent')
group by to_date(from_unixtime(cast(time/1000 as BIGINT)))

),

phone_auth_users as (
    SELECT dt,count(1) as uv from
(select distinct to_date(from_unixtime(cast(time/1000 as BIGINT))) as dt, if(user_id = '-1',distinct_id,user_id) as user_id
from general_click WHERE page_name = 'page_rent_chrg' AND element_name in ('cfse','cmfn') AND source in ('fre_rent','dpst_rent'))a
group by dt

),

phone_cmfn_users as (
    SELECT dt,count(1) as uv from
(select distinct to_date(from_unixtime(cast(time/1000 as BIGINT))) as dt, if(user_id = '-1',distinct_id,user_id) as user_id
from general_click WHERE page_name = 'page_rent_chrg' AND element_name = 'cmfn' AND source in ('fre_rent','dpst_rent'))a
group by dt
),

phone_cfse_users as (
    SELECT dt,count(1) as uv from
(select distinct to_date(from_unixtime(cast(time/1000 as BIGINT))) as dt, if(user_id = '-1',distinct_id,user_id) as user_id
from general_click WHERE page_name = 'page_rent_chrg' AND element_name = 'cfse' AND source in ('fre_rent','dpst_rent'))a
group by dt
)

select  a.dt,d.pv,f.pv,i.uv,j.uv,h.uv,(e.uv-h.uv),a.uv,b.uv,c.uv from fne_rent_uv a
left join fne_rent_auth_uv b on a.dt=b.dt
left join fne_rent_noauth_uv c on a.dt=c.dt
left join chrg_rent_cli d on a.dt=d.dt
left join chrg_rent_uv e on a.dt=e.dt
left join phone_auth_times f on a.dt=f.dt
left join phone_auth_users h on a.dt=h.dt
left join phone_cmfn_users i on a.dt=i.dt
left join phone_cfse_users j on a.dt=j.dt
;


-- 14  478
-- 14  471162
-- all 471640
SELECT dt,count(1) as uv from
(select distinct to_date(from_unixtime(cast(time/1000 as BIGINT))) as dt, if(user_id = '-1',distinct_id,user_id) as user_id
from general_click WHERE page_name = 'page_rent_chrg' AND element_name = 'cmfn' AND source in ('fre_rent','dpst_rent')
and time >= unix_timestamp('2021-01-09')*1000 AND time < unix_timestamp('2021-01-20')*1000)a
group by dt

