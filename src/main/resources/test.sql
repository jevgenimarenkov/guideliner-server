create table Evaluation_Result (
  id serial primary key,
  element_Type varchar(1000),
	result varchar(1000),
	description varchar(1000),
  guideline_code varchar(1000)
);

create table guideline_test (
  id serial primary key,
  code varchar(1000),
	name varchar(1000),
	description varchar(1000),
   Evaluation_Result_id integer REFERENCES Evaluation_Result(id)
);

create table Failed_Element (
  id serial primary key,
	type varchar(1000),
	text varchar(1000),
	description varchar(1000),
	path_To_Element varchar(1000),
	Evaluation_Result_id integer REFERENCES Evaluation_Result(id)
);
