create table employee (
    id serial not null primary key,
    name text not null,
    code text not null,
    designation text
);

create table attendance_log (
    id serial not null primary key,
    employee_id integer not null references employee(id),
	attendance_date date not null,
	duration integer not null
);

create table attendance_log_entry (
    id serial NOT NULL primary key,
    attendance_id integer not null references attendance_log(id),
	punch_in timestamp not null,
	punch_out timestamp,
	duration integer not null,
	status integer not null
);

create view attendance_log_view as 
	select al.*, e.name, e.code 
	from attendance_log al 
	join employee e
	on al.employee_id = e.id;