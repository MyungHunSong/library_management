select user(), database();

use library_management;

select *
	from rent_return;
	
desc rent_return;

alter table rent_return change column memberNo memberNo1 int(11);

alter table rent_return change column rentNo rentNo1 int(11);  




