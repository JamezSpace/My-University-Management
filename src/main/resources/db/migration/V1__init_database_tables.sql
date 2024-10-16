create table applicants (
    application_id bigint PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    date_of_birth TIMESTAMP,
    gender VARCHAR(6),
    student_email varchar(50) unique NOT NULL,
    phone_num varchar(15),
    nationality varchar(20),
    "address" varchar(100)
);

create table admissions (
    sn int NOT NULL,
    applicationId int foreign key references applicants(application_id),
    application_date timestamp(6),
    admission_status varchar(8),
    application_type varchar(12),
);

create table programs (
    program_id VARCHAR(10) unique primary key,
    program_name VARCHAR(50),
    program_level VARCHAR(15),
    duration SMALLINT
)

create table entry_requirements (
    id int NOT NULL PRIMARY KEY,
    program_id VARCHAR(10) foreign key references programs(program_id),
    entry_type VARCHAR(12),
    credits smallint,
)