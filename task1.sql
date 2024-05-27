create table task(
	id serial primary key,
	name text,
	done boolean,
	hours int
);
insert into task (name, done, hours) values ('Test', true, 6);
update task set hours = 3;
select * from task;
delete from task;
