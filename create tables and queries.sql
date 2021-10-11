CREATE DATABASE `testdb` /*!40100 DEFAULT CHARACTER SET utf8 */
create table testdb.roleslookup  (role_id smallint(2) primary key , rolename varchar(128) not null unique);
Create table testdb.employees(id int(4)  primary key auto_increment , name varchar(128) not null , email varchar(128) unique NOT null ,phone varchar(12) unique not null ,age tinyint(2) ,national_id varchar(14) unique not NULL, role_id SMALLINT(2) , FOREIGN KEY(role_id) REFERENCES roleslookup(role_id));
Create table testdb.projects( _id int(4)  primary key auto_increment , name varchar(128) not null  , start_date date  not null , project_manager int(4), foreign key (project_manager) references employees(id) );
create table testdb.employees_projects ( employee_id  int(4) , project_id int(4)  , Constraint foreign key (employee_id) references employees(id) ,Constraint foreign key (project_id) references projects(_id));

select * from testdb.employees e join testdb.roleslookup r on e.role_id = r.role_id ;

select * from testdb.employees e  join employees_projects ep on e.id = ep.employee_id where ep.project_id = 1;
insert into employees_projects(employee_id ,project_id  ) values (1,2);