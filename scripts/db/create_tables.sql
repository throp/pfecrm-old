USE bennort_crm;

CREATE TABLE action_log
(
	action_log_id int primary key,
	description_tx text not null,
	employee_id int not null
);

CREATE TABLE chemical
(
	chemical_id int primary key,
	name_tx varchar(30) not null,
	abbreviation_tx varchar(5) not null,
	is_active_bn boolean default 1
);

CREATE TABLE contact
(
	contact_id int primary key,
	first_name_tx varchar(30) not null,
	last_name_tx varchar(30) not null,
	title_tx varchar(30) not null,
	email_address_tx varchar(50),
	phone_number_tx varchar(12)	
);

create table crm_user_role
(
		crm_user_role_id int primary key,
		employee_id int not null,
    user_name_tx varchar(15) not null,
    role_name_tx varchar(15) not null
);

CREATE TABLE customer_note
(
	customer_note_id int primary key,
	customer_id int not null,
	note_tx text not null,
	employee_id int not null,
	entered_dt date not null
);

CREATE TABLE customer
(
	customer_id int primary key,
	name_tx varchar(50) not null,
	address1_tx varchar(50) not null,
	address2_tx varchar(50),
	address3_tx varchar(50),
	city_tx varchar(25) not null,
	zip_tx varchar(10),
	state_tx varchar(2),
	primary_contact_id int,
	secondary_contact_id int,
	fax_number_tx varchar(12),
	status_id int not null, 
	office_id int not null,
	blanket_po_tx varchar(30),
	primary_contact_first_name_tx varchar(30) not null,
	primary_contact_last_name_tx varchar(30) not null,
	primary_contact_title_tx varchar(30) not null,
	primary_contact_email_address_tx varchar(50),
	primary_contact_phone_number_tx varchar(12),
	primary_contact_phone_ext_tx varchar(12),
	secondary_contact_first_name_tx varchar(30) not null,
	secondary_contact_last_name_tx varchar(30) not null,
	secondary_contact_title_tx varchar(30) not null,
	secondary_contact_email_address_tx varchar(50),
	secondary_contact_phone_number_tx varchar(12),		
	secondary_contact_phone_ext_tx varchar(12)		
);

CREATE TABLE employee
(
	employee_id int primary key,
	first_name_tx varchar(15) not null,
	last_name_tx varchar(25) not null,
	employee_type_id int not null,
	is_active_bn boolean default 1,
	user_name_tx varchar(15) not null,
	user_password_tx varchar(15) not null
);

CREATE TABLE inventory_item
(
	inventory_item_id int primary key,
	type_tx varchar(20) not null,
	manufacturer_id int not null,
	chemical_id int not null,
	year_num int not null,
	weight_id int not null,
	floor_num int,
	location_tx text,
	service_id int not null,
	locked_bool tinyint,
	service_type_num int,
	test_type_num int,
	test_year_num int
);

CREATE TABLE job
(
	job_id int  primary key,
	in_road_tech_queue_dt date,
	in_shop_tech_queue_dt date,
	in_return_tech_queue_dt date,
	ready_for_return_dt date,
	completed_dt date,
	billed_dt date,
	service_id int not null,
	road_tech_employee_id int,
	shop_tech_employee_id int,
	return_tech_employee_id int,
	credited_tech_employee_id int, 
	invoice_am float default 0,
	invoice_number_tx varchar(30), 
	service_call_id int,
	month_due_num int,
	year_due_num int
);

CREATE TABLE location_note
(
	location_note_id int primary key,
	location_id int not null,
	note_tx text not null,
	employee_id int not null,
	entered_dt date not null
);

CREATE TABLE location
(
	location_id int primary key,
	name_tx varchar(50) not null,
	address1_tx varchar(50) not null,
	address2_tx varchar(50),
	address3_tx varchar(50),
	city_tx varchar(25) not null,
	zip_tx varchar(10) not null,
	state_tx varchar(2) not null,
	contact_id int,
	customer_id int not null,
	po_tx varchar(30),
	is_blanket_po_bn bool default 0, 
	is_use_customer_address_bn bool default 0,
	is_use_customer_contact_bn bool default 0,
	contact_first_name_tx varchar(30) not null,
	contact_last_name_tx varchar(30) not null,
	contact_title_tx varchar(30) not null,
	contact_email_address_tx varchar(50),
	contact_phone_number_tx varchar(12),
	contact_phone_ext_tx varchar(12)
);

CREATE TABLE manufacturer
(
	manufacturer_id int primary key,
	name_tx varchar(30) not null,
	abbreviation_tx varchar(7) not null,
	fire_extinguisher_bool tinyint,
	is_active_bn boolean default 1
);


CREATE TABLE office
(
	office_id int primary key,
	name_tx varchar(50) not null,
	is_active_bn boolean default 1
);

CREATE TABLE service_call
(
	service_call_id int  primary key,
	service_id int not null,
	notes_tx text,
	placed_dt date not null,
	employee_id int not null
);

CREATE TABLE service
(
	service_id int  primary key,
	service_month_id int not null,
	service_frequency_id int not null,
	location_id int not null,
	service_type_id int not null,
	notes_tx text,
	inventory_items_num int default 0
);

CREATE TABLE weight
(
	weight_id int primary key,
	pounds_qt float not null,
	is_active_bn boolean default 1
);