select * from nls_database_parameters;
select * from v$version
select * from v$tablespace;
select name from v$datafile;

CREATE USER hero_indiana IDENTIFIED BY hero_indiana DEFAULT TABLESPACE DATA01;
select * from dba_users ;
grant connect,resource to hero_indiana;
grant create database link to hero_indiana;
grant select any sequence,create materialized view to hero_indiana;
grant dba to hero_indiana;
revoke dba from hero_indiana
create tablespace DATA01
logging
datafile 'E:\APP\YE\ORADATA\ORCL\hero_indiana1.DBF'
size 1024m
autoextend on
next 32m maxsize 20096m
extent management local;

imp hero_indiana/hero_indiana@orcl file= 'E:\yuanhao\11.dmp' buffer=102400 FROMUSER=HERO_INDIANA touser=hero_indiana log= 'E:\yuanhao\Furnish_20170220.log' 
