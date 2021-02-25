REFRESH sdbattery.sd_ad;
REFRESH sdbattery.sd_ad_image;
REFRESH sdbattery.sd_ali_pre_auth_order;
REFRESH sdbattery.sd_ali_pre_auth_order_mapping;
REFRESH sdbattery.sd_ali_source_bind;
REFRESH sdbattery.sd_area;
REFRESH sdbattery.sd_attachs;
REFRESH sdbattery.sd_battery_log;
REFRESH sdbattery.sd_bill;
REFRESH sdbattery.sd_bill_allocation;
REFRESH sdbattery.sd_bill_detail;
REFRESH sdbattery.sd_bill_multi;
REFRESH sdbattery.sd_complain;
REFRESH sdbattery.sd_complain_image;
REFRESH sdbattery.sd_country;
REFRESH sdbattery.sd_coupon;
REFRESH sdbattery.sd_coupon_consume;
REFRESH sdbattery.sd_coupon_item;
REFRESH sdbattery.sd_coupon_quota;
REFRESH sdbattery.sd_daily_income_rate;
REFRESH sdbattery.sd_dict_operator;
REFRESH sdbattery.sd_dict_order_status;
REFRESH sdbattery.sd_equip_deposit;
REFRESH sdbattery.sd_equip_deposit_log;
REFRESH sdbattery.sd_equip_discount;
REFRESH sdbattery.sd_failed_jobs;
REFRESH sdbattery.sd_fee_strategy;
REFRESH sdbattery.sd_goods;
REFRESH sdbattery.sd_income_rate;
REFRESH sdbattery.sd_income_rate_log;
REFRESH sdbattery.sd_merchant_bill_account_daily;
REFRESH sdbattery.sd_migrations;
REFRESH sdbattery.sd_multi_agent_bill_dailies;
REFRESH sdbattery.sd_oper_log;
REFRESH sdbattery.sd_oper_records;
REFRESH sdbattery.sd_order_color_ext;
REFRESH sdbattery.sd_order_ext;
REFRESH sdbattery.sd_order_password;
REFRESH sdbattery.sd_order_troubles;
REFRESH sdbattery.sd_order_user_ref_ext;
REFRESH sdbattery.sd_orders;
REFRESH sdbattery.sd_promotions;
REFRESH sdbattery.sd_qrcode_bind;
REFRESH sdbattery.sd_qrcode_task;
REFRESH sdbattery.sd_qrcodes;
REFRESH sdbattery.sd_refund_error;
REFRESH sdbattery.sd_remote_upgrade_record;
REFRESH sdbattery.sd_sale_bill_account_daily;
REFRESH sdbattery.sd_shop_apply;
REFRESH sdbattery.sd_shop_income_shares;
REFRESH sdbattery.sd_shop_income_shares_log;
REFRESH sdbattery.sd_shop_type;
REFRESH sdbattery.sd_shops;
REFRESH sdbattery.sd_source;
REFRESH sdbattery.sd_station_image;
REFRESH sdbattery.sd_station_infos;
REFRESH sdbattery.sd_stations;
REFRESH sdbattery.sd_subject;
REFRESH sdbattery.sd_support_records;
REFRESH sdbattery.sd_switchs;
REFRESH sdbattery.sd_sys_users;
REFRESH sdbattery.sd_tasks;
REFRESH sdbattery.sd_trouble;
REFRESH sdbattery.sd_user_bind;
REFRESH sdbattery.sd_user_charge_log;
REFRESH sdbattery.sd_user_deposit_notice;
REFRESH sdbattery.sd_user_income_shares;
REFRESH sdbattery.sd_user_income_shares_log;
REFRESH sdbattery.sd_user_record;
REFRESH sdbattery.sd_user_record_issue;
REFRESH sdbattery.sd_user_record_item;
REFRESH sdbattery.sd_users;
REFRESH sdbattery.sd_vip_card_order;
REFRESH sdbattery.sd_vip_discount;
REFRESH sdbattery.sd_vip_level_log;
REFRESH sdbattery.sd_wechat_fen_order;
REFRESH sdbattery.sd_wechat_fen_order_mapping;
REFRESH sdbattery.sd_withdraw_log;
REFRESH sdbattery.sd_withdraw_quota;

UPSERT INTO impala_sdbattery.sd_ad
SELECT * FROM sdbattery.sd_ad;

UPSERT INTO impala_sdbattery.sd_ad_image
SELECT * FROM sdbattery.sd_ad_image;

UPSERT INTO impala_sdbattery.sd_ali_pre_auth_order
SELECT * FROM sdbattery.sd_ali_pre_auth_order;

UPSERT INTO impala_sdbattery.sd_ali_pre_auth_order_mapping
SELECT * FROM sdbattery.sd_ali_pre_auth_order_mapping;

UPSERT INTO impala_sdbattery.sd_ali_source_bind
SELECT * FROM sdbattery.sd_ali_source_bind;

UPSERT INTO impala_sdbattery.sd_area
SELECT * FROM sdbattery.sd_area;

UPSERT INTO impala_sdbattery.sd_attachs
SELECT * FROM sdbattery.sd_attachs;

UPSERT INTO impala_sdbattery.sd_battery_log
SELECT * FROM sdbattery.sd_battery_log;

UPSERT INTO impala_sdbattery.sd_bill
SELECT * FROM sdbattery.sd_bill;

UPSERT INTO impala_sdbattery.sd_bill_allocation
SELECT * FROM sdbattery.sd_bill_allocation;

UPSERT INTO impala_sdbattery.sd_bill_detail
SELECT * FROM sdbattery.sd_bill_detail;

UPSERT INTO impala_sdbattery.sd_bill_multi
SELECT * FROM sdbattery.sd_bill_multi;

UPSERT INTO impala_sdbattery.sd_complain
SELECT * FROM sdbattery.sd_complain;

UPSERT INTO impala_sdbattery.sd_complain_image
SELECT * FROM sdbattery.sd_complain_image;

UPSERT INTO impala_sdbattery.sd_country
SELECT * FROM sdbattery.sd_country;

UPSERT INTO impala_sdbattery.sd_coupon
SELECT * FROM sdbattery.sd_coupon;

UPSERT INTO impala_sdbattery.sd_coupon_consume
SELECT * FROM sdbattery.sd_coupon_consume;

UPSERT INTO impala_sdbattery.sd_coupon_item
SELECT * FROM sdbattery.sd_coupon_item;

UPSERT INTO impala_sdbattery.sd_coupon_quota
SELECT * FROM sdbattery.sd_coupon_quota;

UPSERT INTO impala_sdbattery.sd_daily_income_rate
SELECT * FROM sdbattery.sd_daily_income_rate;

UPSERT INTO impala_sdbattery.sd_dict_operator
SELECT * FROM sdbattery.sd_dict_operator;

UPSERT INTO impala_sdbattery.sd_dict_order_status
SELECT * FROM sdbattery.sd_dict_order_status;

UPSERT INTO impala_sdbattery.sd_equip_deposit
SELECT * FROM sdbattery.sd_equip_deposit;

UPSERT INTO impala_sdbattery.sd_equip_deposit_log
SELECT * FROM sdbattery.sd_equip_deposit_log;

UPSERT INTO impala_sdbattery.sd_equip_discount
SELECT * FROM sdbattery.sd_equip_discount;

UPSERT INTO impala_sdbattery.sd_failed_jobs
SELECT * FROM sdbattery.sd_failed_jobs;

UPSERT INTO impala_sdbattery.sd_fee_strategy
SELECT * FROM sdbattery.sd_fee_strategy;

UPSERT INTO impala_sdbattery.sd_goods
SELECT * FROM sdbattery.sd_goods;

UPSERT INTO impala_sdbattery.sd_income_rate
SELECT * FROM sdbattery.sd_income_rate;

UPSERT INTO impala_sdbattery.sd_income_rate_log
SELECT * FROM sdbattery.sd_income_rate_log;

UPSERT INTO impala_sdbattery.sd_merchant_bill_account_daily
SELECT * FROM sdbattery.sd_merchant_bill_account_daily;

UPSERT INTO impala_sdbattery.sd_migrations
SELECT * FROM sdbattery.sd_migrations;

UPSERT INTO impala_sdbattery.sd_multi_agent_bill_dailies
SELECT * FROM sdbattery.sd_multi_agent_bill_dailies;

UPSERT INTO impala_sdbattery.sd_oper_log
SELECT * FROM sdbattery.sd_oper_log;

UPSERT INTO impala_sdbattery.sd_oper_records
SELECT * FROM sdbattery.sd_oper_records;

UPSERT INTO impala_sdbattery.sd_order_color_ext
SELECT * FROM sdbattery.sd_order_color_ext;

UPSERT INTO impala_sdbattery.sd_order_ext
SELECT * FROM sdbattery.sd_order_ext;

UPSERT INTO impala_sdbattery.sd_order_password
SELECT * FROM sdbattery.sd_order_password;

UPSERT INTO impala_sdbattery.sd_order_troubles
SELECT * FROM sdbattery.sd_order_troubles;

UPSERT INTO impala_sdbattery.sd_order_user_ref_ext
SELECT * FROM sdbattery.sd_order_user_ref_ext;

UPSERT INTO impala_sdbattery.sd_orders
SELECT * FROM sdbattery.sd_orders;

UPSERT INTO impala_sdbattery.sd_promotions
SELECT * FROM sdbattery.sd_promotions;

UPSERT INTO impala_sdbattery.sd_qrcode_bind
SELECT * FROM sdbattery.sd_qrcode_bind;

UPSERT INTO impala_sdbattery.sd_qrcode_task
SELECT * FROM sdbattery.sd_qrcode_task;

UPSERT INTO impala_sdbattery.sd_qrcodes
SELECT * FROM sdbattery.sd_qrcodes;

UPSERT INTO impala_sdbattery.sd_refund_error
SELECT * FROM sdbattery.sd_refund_error;

UPSERT INTO impala_sdbattery.sd_remote_upgrade_record
SELECT * FROM sdbattery.sd_remote_upgrade_record;

UPSERT INTO impala_sdbattery.sd_sale_bill_account_daily
SELECT * FROM sdbattery.sd_sale_bill_account_daily;

UPSERT INTO impala_sdbattery.sd_shop_apply
SELECT * FROM sdbattery.sd_shop_apply;

UPSERT INTO impala_sdbattery.sd_shop_income_shares
SELECT * FROM sdbattery.sd_shop_income_shares;

UPSERT INTO impala_sdbattery.sd_shop_income_shares_log
SELECT * FROM sdbattery.sd_shop_income_shares_log;

UPSERT INTO impala_sdbattery.sd_shop_type
SELECT * FROM sdbattery.sd_shop_type;

UPSERT INTO impala_sdbattery.sd_shops
SELECT * FROM sdbattery.sd_shops;

UPSERT INTO impala_sdbattery.sd_source
SELECT * FROM sdbattery.sd_source;

UPSERT INTO impala_sdbattery.sd_station_image
SELECT * FROM sdbattery.sd_station_image;

UPSERT INTO impala_sdbattery.sd_station_infos
SELECT * FROM sdbattery.sd_station_infos;

UPSERT INTO impala_sdbattery.sd_stations
SELECT * FROM sdbattery.sd_stations;

UPSERT INTO impala_sdbattery.sd_subject
SELECT * FROM sdbattery.sd_subject;

UPSERT INTO impala_sdbattery.sd_support_records
SELECT * FROM sdbattery.sd_support_records;

UPSERT INTO impala_sdbattery.sd_switchs
SELECT * FROM sdbattery.sd_switchs;

UPSERT INTO impala_sdbattery.sd_sys_users
SELECT * FROM sdbattery.sd_sys_users;

UPSERT INTO impala_sdbattery.sd_tasks
SELECT * FROM sdbattery.sd_tasks;

UPSERT INTO impala_sdbattery.sd_trouble
SELECT * FROM sdbattery.sd_trouble;

UPSERT INTO impala_sdbattery.sd_user_bind
SELECT * FROM sdbattery.sd_user_bind;

UPSERT INTO impala_sdbattery.sd_user_charge_log
SELECT * FROM sdbattery.sd_user_charge_log;

UPSERT INTO impala_sdbattery.sd_user_deposit_notice
SELECT * FROM sdbattery.sd_user_deposit_notice;

UPSERT INTO impala_sdbattery.sd_user_income_shares
SELECT * FROM sdbattery.sd_user_income_shares;

UPSERT INTO impala_sdbattery.sd_user_income_shares_log
SELECT * FROM sdbattery.sd_user_income_shares_log;

UPSERT INTO impala_sdbattery.sd_user_record
SELECT * FROM sdbattery.sd_user_record;

UPSERT INTO impala_sdbattery.sd_user_record_issue
SELECT * FROM sdbattery.sd_user_record_issue;

UPSERT INTO impala_sdbattery.sd_user_record_item
SELECT * FROM sdbattery.sd_user_record_item;

UPSERT INTO impala_sdbattery.sd_users
SELECT * FROM sdbattery.sd_users;

UPSERT INTO impala_sdbattery.sd_vip_card_order
SELECT * FROM sdbattery.sd_vip_card_order;

UPSERT INTO impala_sdbattery.sd_vip_discount
SELECT * FROM sdbattery.sd_vip_discount;

UPSERT INTO impala_sdbattery.sd_vip_level_log
SELECT * FROM sdbattery.sd_vip_level_log;

UPSERT INTO impala_sdbattery.sd_wechat_fen_order
SELECT * FROM sdbattery.sd_wechat_fen_order;

UPSERT INTO impala_sdbattery.sd_wechat_fen_order_mapping
SELECT * FROM sdbattery.sd_wechat_fen_order_mapping;

UPSERT INTO impala_sdbattery.sd_withdraw_log
SELECT * FROM sdbattery.sd_withdraw_log;

UPSERT INTO impala_sdbattery.sd_withdraw_quota
SELECT * FROM sdbattery.sd_withdraw_quota;
