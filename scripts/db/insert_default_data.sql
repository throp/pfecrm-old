USE bennort_crm;

insert into employee (
	employee_id,
	first_name_tx,
	last_name_tx,
	employee_type_id,
	is_active_bn,
	user_name_tx,
	user_password_tx) 
values (1, 'Ben', 'Northrop', 1, 1, 'ben', 'ben');
insert into crm_user_role values (1, 1, 'ben', 'pfeUser');
insert into crm_user_role values (2, 1, 'ben', 'admin');
insert into crm_user_role values (3, 1, 'ben', 'manager');


insert into office values (1, 'Pittsburgh', 1);

insert into chemical values (1, 'ABC Dry Chemical',  'ABC', 1);
insert into chemical values (2, 'BC Dry Chemical', 'BC', 1);
insert into chemical values (3, 'Carbon Dioxide', 'CO2', 1);
insert into chemical values (4, 'Halon', 'Halon', 1);

insert into manufacturer values (1, 'Amerex', 'Amerex', 1, 1);
insert into manufacturer values (2, 'Ansul', 'Ansul', 1, 1);
insert into manufacturer values (3, 'Buckeye', 'Buckeye', 1, 1);

insert into weight values (1, 2, 1);
insert into weight values (2, 5, 1);
insert into weight values (3, 9.5, 1);
insert into weight values (4, 10, 1);