use fraud-management-system;
drop table user;
create table user( 
    id int primary key AUTO_INCREMENT, 
    user_id varchar(20),
    first_name varchar(30),
    last_name varchar(20),
    dob date,
    gender varchar(20),
    contact_no varchar(10),
    email varchar(30),
    password varchar(30),
    is_authorized int,
    role varchar(30),
    first_answer varchar(30),
    second_answer varchar(30),
    thir_answer varchar(30)
);