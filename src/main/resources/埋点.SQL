SELECT from_unixtime(cast(time/1000 as BIGINT)),* from impala_sensors.general_view WHERE page_name = 'page_sd_chrg' ORDER BY time DESC;

SELECT from_unixtime(cast(time/1000 as BIGINT)),* from impala_sensors.general_click WHERE page_name = 'page_rent_chrg' and element_name = 'rgt_svc' ORDER BY time DESC;

SELECT from_unixtime(cast(time/1000 as BIGINT)),* from impala_sensors.general_click WHERE page_name = 'page_hlp_cntr' ORDER BY time DESC;

SELECT from_unixtime(cast(time/1000 as BIGINT)),* from impala_sensors.general_click WHERE page_name = 'page_fne_rent' ORDER BY time DESC;

SELECT from_unixtime(cast(time/1000 as BIGINT)),* from impala_sensors.general_click WHERE page_name = 'page_nby_shp' ORDER BY time DESC;

SELECT from_unixtime(cast(time/1000 as BIGINT)),* from impala_sensors.general_click WHERE page_name = 'page_shp_detl' ORDER BY time DESC;

SELECT from_unixtime(cast(time/1000 as BIGINT)),* from impala_sensors.general_click WHERE page_name = 'page_pwd_rent' ORDER BY time DESC;

SELECT from_unixtime(cast(time/1000 as BIGINT)),* from impala_sensors.general_click WHERE page_name = 'page_sd_jon' ORDER BY time DESC;

SELECT from_unixtime(cast(time/1000 as BIGINT)),* from impala_sensors.general_click WHERE page_name = 'page_cust_cntr' ORDER BY time DESC;

SELECT from_unixtime(cast(time/1000 as BIGINT)),* from impala_sensors.general_click WHERE page_name = 'page_abt_us' ORDER BY time DESC;

SELECT from_unixtime(cast(time/1000 as BIGINT)),* from impala_sensors.general_click WHERE page_name = 'page_cust_wlt' ORDER BY time DESC;

SELECT from_unixtime(cast(time/1000 as BIGINT)),* from impala_sensors.general_click WHERE page_name = 'page_tup_chrg' ORDER BY time DESC;

SELECT from_unixtime(cast(time/1000 as BIGINT)),* from impala_sensors.general_click WHERE page_name = 'page_order_list' ORDER BY time DESC;

SELECT from_unixtime(cast(time/1000 as BIGINT)),* from impala_sensors.general_click WHERE page_name = 'page_ord_detl' ORDER BY time DESC;

SELECT from_unixtime(cast(time/1000 as BIGINT)),* from impala_sensors.general_click WHERE page_name = 'page_rent_chrg' ORDER BY time DESC;

SELECT count(1) from impala_sensors.general_view WHERE page_name = 'page_sd_chrg' AND lib != 'MiniProgram' ORDER BY time DESC;

SELECT * from impala_sensors.general_view WHERE lib != 'MiniProgram' ORDER BY time DESC;


SELECT from_unixtime(cast(rent_time as BIGINT)),* from impala_sdbattery.sd_orders WHERE order_sn = 'SD201215174607N96356834';
