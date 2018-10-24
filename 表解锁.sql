--查看被锁的表?

select b.owner,b.object_name,a.session_id,a.locked_mode from v$locked_object a,dba_objects b where b.object_id = a.object_id;


--查看是哪个session引起的

select b.username,b.sid,b.serial#,logon_time from v$locked_object a,v$session b where a.session_id = b.sid order by b.logon_time; 


--解锁
alter system kill session'3968,43153';
SID:1025
SERIAL#:41
