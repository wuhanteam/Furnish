prompt PL/SQL Developer import file
prompt Created on 2017Äê3ÔÂ5ÈÕ by Ye
set feedback off
set define off
prompt Disabling triggers for TBL_FINDPWD_LOG...
alter table TBL_FINDPWD_LOG disable all triggers;
prompt Disabling triggers for T_CHZBINFO...
alter table T_CHZBINFO disable all triggers;
prompt Disabling triggers for T_CUSTOMERINFO...
alter table T_CUSTOMERINFO disable all triggers;
prompt Disabling triggers for T_GOODS...
alter table T_GOODS disable all triggers;
prompt Disabling triggers for T_GWCINFO...
alter table T_GWCINFO disable all triggers;
prompt Disabling triggers for T_MENUINFO...
alter table T_MENUINFO disable all triggers;
prompt Disabling triggers for T_PURCHASEDGOODSINFO...
alter table T_PURCHASEDGOODSINFO disable all triggers;
prompt Disabling triggers for T_REF_USERMENU...
alter table T_REF_USERMENU disable all triggers;
prompt Disabling triggers for T_USERINFO...
alter table T_USERINFO disable all triggers;
prompt Disabling triggers for T_YIYUANINFO...
alter table T_YIYUANINFO disable all triggers;
prompt Disabling triggers for T_YXBTOTALNUMINFO...
alter table T_YXBTOTALNUMINFO disable all triggers;
prompt Disabling triggers for T_ZJINFO...
alter table T_ZJINFO disable all triggers;
prompt Loading TBL_FINDPWD_LOG...
insert into TBL_FINDPWD_LOG (logid, usercode, email, ipaddress, createtime)
values ('11', '23', '323', '323', '2017-03-02 22:10:41');
commit;
prompt 1 records loaded
prompt Loading T_CHZBINFO...
prompt Table is empty
prompt Loading T_CUSTOMERINFO...
insert into T_CUSTOMERINFO (cid, uname, upwd, ptname, address, qq, zfbnum, telphone, jqrflag, params1, params2, yxbtotalnum)
values (10002, 'yh', '123456', 'ptname', 'address', 'qq', '13080640672', '11111111111', '0', 'params1', 'params2', 111);
insert into T_CUSTOMERINFO (cid, uname, upwd, ptname, address, qq, zfbnum, telphone, jqrflag, params1, params2, yxbtotalnum)
values (10043, 'yhh', '123', '23233²âÊÔ', '112¶öËÀ', '123456', '12', null, '0', '2323', '²âÊÔ22', 12);
insert into T_CUSTOMERINFO (cid, uname, upwd, ptname, address, qq, zfbnum, telphone, jqrflag, params1, params2, yxbtotalnum)
values (10042, '11111', '11111', '1111', '11111', '11111', '11111', '11111111111', '1', '1111', '1111', 1111);
insert into T_CUSTOMERINFO (cid, uname, upwd, ptname, address, qq, zfbnum, telphone, jqrflag, params1, params2, yxbtotalnum)
values (10061, 'qq', 'w', 'ÍøÒ×', 'ew', 'ewe', 'ewe', '13080640672', '0', 'ewe', 'ewe', 1);
insert into T_CUSTOMERINFO (cid, uname, upwd, ptname, address, qq, zfbnum, telphone, jqrflag, params1, params2, yxbtotalnum)
values (10062, '23', '23', '2', 'qw', 'we', 'ewe', '13080640672', '0', 'ew', 'ewe', 1);
insert into T_CUSTOMERINFO (cid, uname, upwd, ptname, address, qq, zfbnum, telphone, jqrflag, params1, params2, yxbtotalnum)
values (10063, '22', '34', '434', '343', '434', '434', '13025169091', '0', '434', '434', 434);
insert into T_CUSTOMERINFO (cid, uname, upwd, ptname, address, qq, zfbnum, telphone, jqrflag, params1, params2, yxbtotalnum)
values (10064, '333', '2323', '232', '323', '323', '32', '13080640672', '0', '32332323', '2323', 1);
insert into T_CUSTOMERINFO (cid, uname, upwd, ptname, address, qq, zfbnum, telphone, jqrflag, params1, params2, yxbtotalnum)
values (10065, '2323', '323', '323', '323', '32', '323', '13080640672', '0', '3232', '33232323', 232);
insert into T_CUSTOMERINFO (cid, uname, upwd, ptname, address, qq, zfbnum, telphone, jqrflag, params1, params2, yxbtotalnum)
values (10066, '1111', '323', '23', '232', '3232', '3232', '13080640672', '0', '2323', '32323', 1);
insert into T_CUSTOMERINFO (cid, uname, upwd, ptname, address, qq, zfbnum, telphone, jqrflag, params1, params2, yxbtotalnum)
values (10067, '23456', '123456', '323', '3233', '11345', '²âÊÔ', null, '0', '23', '23²âÊÔ', 1);
commit;
prompt 10 records loaded
prompt Loading T_GOODS...
insert into T_GOODS (gid, gsid, gname, gdate, gdetail, isexpire, gprice, gnumber, gsynumber, gimg1, gimg2, gimg3)
values ('G71001553901', '12', '23', '2017-03-08 18:32:03', '23', '0', '323', '3', '44', 'E:/yuanhao/upload/images/20170305/hubei-jt.jpg.jpg', null, null);
commit;
prompt 1 records loaded
prompt Loading T_GWCINFO...
prompt Table is empty
prompt Loading T_MENUINFO...
insert into T_MENUINFO (menuid, menuname, isdisplay, params1, muid)
values (1, 'ÓÃ»§¹ÜÀí', '1', null, '1');
insert into T_MENUINFO (menuid, menuname, isdisplay, params1, muid)
values (2, '¿Í»§¹ÜÀí', '1', null, '1');
insert into T_MENUINFO (menuid, menuname, isdisplay, params1, muid)
values (3, 'ÉÌÆ·ÐÅÏ¢¹ÜÀí', '1', null, '1');
insert into T_MENUINFO (menuid, menuname, isdisplay, params1, muid)
values (4, '1Ôª¶á±¦', '1', null, '1');
commit;
prompt 4 records loaded
prompt Loading T_PURCHASEDGOODSINFO...
prompt Table is empty
prompt Loading T_REF_USERMENU...
insert into T_REF_USERMENU (umid, muid, params1, mmid)
values (1, 1, null, 1);
insert into T_REF_USERMENU (umid, muid, params1, mmid)
values (1, 2, null, 2);
insert into T_REF_USERMENU (umid, muid, params1, mmid)
values (1, 3, null, 3);
insert into T_REF_USERMENU (umid, muid, params1, mmid)
values (1, 4, null, 4);
insert into T_REF_USERMENU (umid, muid, params1, mmid)
values (2, 1, null, 5);
insert into T_REF_USERMENU (umid, muid, params1, mmid)
values (2, 2, null, 6);
insert into T_REF_USERMENU (umid, muid, params1, mmid)
values (2, 3, null, 7);
insert into T_REF_USERMENU (umid, muid, params1, mmid)
values (2, 4, null, 8);
commit;
prompt 8 records loaded
prompt Loading T_USERINFO...
insert into T_USERINFO (userid, usercode, adminpwd, params1, status, last_login_time, salt, ipaddress, createtime, username, validatecode, outedate, email, mobile, spare01, spare02, spare03)
values ('1', 'admin', 'bceda0f373bf881a512f7bffe2a18b75', '¹ÜÀíÔ±1', '1', '2017-03-05 19:47:09', '37209e4be0b3c0e8bed34129964a5976', '0:0:0:0:0:0:0:1', '2017-03-03 01:43:41', 'Ò¶Âú1', null, null, 'hb_yeman@163.com', '130806405672', null, null, null);
insert into T_USERINFO (userid, usercode, adminpwd, params1, status, last_login_time, salt, ipaddress, createtime, username, validatecode, outedate, email, mobile, spare01, spare02, spare03)
values ('205086445', 'yeman02', '9955055a608900d47dd3ac4ed55af473', 'Ò¶Âú02', '1', '2017-03-03 21:29:16', 'e6f6a0ddf1c7a961429f55e95e40e668', '0:0:0:0:0:0:0:1', null, 'Ò¶Âú11', null, null, '792336395@qq.com', '13080640672', null, null, null);
insert into T_USERINFO (userid, usercode, adminpwd, params1, status, last_login_time, salt, ipaddress, createtime, username, validatecode, outedate, email, mobile, spare01, spare02, spare03)
values ('625057203', 'yeman01', 'a68572ffd11a81cfd3ace373e51e996b', 'Ò¶Âú01', '1', '2017-03-03 23:35:41', 'fdc817c7a9f36fe5eba29265025473ee', '0:0:0:0:0:0:0:1', null, 'Ò¶Âú01', null, null, '1172882148@qq.com', '13080640672', null, null, null);
insert into T_USERINFO (userid, usercode, adminpwd, params1, status, last_login_time, salt, ipaddress, createtime, username, validatecode, outedate, email, mobile, spare01, spare02, spare03)
values ('563662777', 'yeman03', '9f5e098cd85c5052b48f3e2fbcae3b06', 'Ò¶Âú03', '1', null, '69b228ab7845b4d211b9158d4c00a0a7', null, null, 'Ò¶Âú03', null, null, '1172882148@qq.com', '13080640672', null, null, null);
insert into T_USERINFO (userid, usercode, adminpwd, params1, status, last_login_time, salt, ipaddress, createtime, username, validatecode, outedate, email, mobile, spare01, spare02, spare03)
values ('831353540', 'yeman04', '15e02facacb3fd61a6c33626a4572dcb', 'Ò¶Âú04', '1', null, '96b0dcabca8885b95925352ceeefd6ac', null, null, 'Ò¶Âú04', null, null, '1172882148@qq.com', '13080640672', null, null, null);
insert into T_USERINFO (userid, usercode, adminpwd, params1, status, last_login_time, salt, ipaddress, createtime, username, validatecode, outedate, email, mobile, spare01, spare02, spare03)
values ('156542048', 'yeman05', 'f3b1f0019d4784225a024c85a6c06733', 'Ò¶Âú05', '1', null, 'ba1a64cba5ebff862ed2ec72250d2eb1', null, null, 'Ò¶Âú05', null, null, '1172882148@qq.com', '13080640672', null, null, null);
insert into T_USERINFO (userid, usercode, adminpwd, params1, status, last_login_time, salt, ipaddress, createtime, username, validatecode, outedate, email, mobile, spare01, spare02, spare03)
values ('648986243', 'yeman06', 'f20479654ea21b9cffcff01638822f2d', 'Ò¶Âú06', '1', null, 'e9c655834212aec31dc3c417dc19fbad', null, null, 'Ò¶Âú06', null, null, '1172882148@qq.com', '13080640672', null, null, null);
insert into T_USERINFO (userid, usercode, adminpwd, params1, status, last_login_time, salt, ipaddress, createtime, username, validatecode, outedate, email, mobile, spare01, spare02, spare03)
values ('841040617', 'yeman07', '4338c102f822ffbdd52b99df04caba89', 'Ò¶Âú07', '1', null, '5952313288add989d6449e71e529a8e1', null, null, 'Ò¶Âú07', null, null, '1172882148@qq.com', '13080640672', null, null, null);
insert into T_USERINFO (userid, usercode, adminpwd, params1, status, last_login_time, salt, ipaddress, createtime, username, validatecode, outedate, email, mobile, spare01, spare02, spare03)
values ('158332625', 'yeman08', '514cfe91173555c70395bce1ed28aff8', 'Ò¶Âú08', '1', null, '30f3f61c8c647284c441cbc1261954db', null, null, 'Ò¶Âú08', null, null, 'Ò¶Âú08', '13080640672', null, null, null);
insert into T_USERINFO (userid, usercode, adminpwd, params1, status, last_login_time, salt, ipaddress, createtime, username, validatecode, outedate, email, mobile, spare01, spare02, spare03)
values ('673873388', 'yeman09', 'c28320e667f2f6d578711da5be3b3fe6', 'Ò¶Âú09', '1', null, '581295f60bd0bb8e0992cc4844b269ea', null, null, 'Ò¶Âú09', null, null, '1172882148@qq.com', '13080640672', null, null, null);
insert into T_USERINFO (userid, usercode, adminpwd, params1, status, last_login_time, salt, ipaddress, createtime, username, validatecode, outedate, email, mobile, spare01, spare02, spare03)
values ('610262676', 'yeman10', '2e4a3018144c1a4e25e7866e905940b4', 'Ò¶Âú10', '1', '2017-03-03 21:28:19', 'd73d5f8648108ed61b79c43a17d8efb3', '0:0:0:0:0:0:0:1', null, 'Ò¶Âú10', null, null, '1172882148@qq.com', '13080640672', null, null, null);
commit;
prompt 11 records loaded
prompt Loading T_YIYUANINFO...
prompt Table is empty
prompt Loading T_YXBTOTALNUMINFO...
prompt Table is empty
prompt Loading T_ZJINFO...
prompt Table is empty
prompt Enabling triggers for TBL_FINDPWD_LOG...
alter table TBL_FINDPWD_LOG enable all triggers;
prompt Enabling triggers for T_CHZBINFO...
alter table T_CHZBINFO enable all triggers;
prompt Enabling triggers for T_CUSTOMERINFO...
alter table T_CUSTOMERINFO enable all triggers;
prompt Enabling triggers for T_GOODS...
alter table T_GOODS enable all triggers;
prompt Enabling triggers for T_GWCINFO...
alter table T_GWCINFO enable all triggers;
prompt Enabling triggers for T_MENUINFO...
alter table T_MENUINFO enable all triggers;
prompt Enabling triggers for T_PURCHASEDGOODSINFO...
alter table T_PURCHASEDGOODSINFO enable all triggers;
prompt Enabling triggers for T_REF_USERMENU...
alter table T_REF_USERMENU enable all triggers;
prompt Enabling triggers for T_USERINFO...
alter table T_USERINFO enable all triggers;
prompt Enabling triggers for T_YIYUANINFO...
alter table T_YIYUANINFO enable all triggers;
prompt Enabling triggers for T_YXBTOTALNUMINFO...
alter table T_YXBTOTALNUMINFO enable all triggers;
prompt Enabling triggers for T_ZJINFO...
alter table T_ZJINFO enable all triggers;
set feedback on
set define on
prompt Done.
