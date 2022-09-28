create table teacher
(
    id               bigserial
        constraint teacher_pk primary key                   ,
    full_name        varchar(255)                           ,
    phone            varchar(100)                           ,
    email            varchar(255)                           ,
    date_of_birth    timestamp                              ,
    gender           varchar(100)                           ,
    address          varchar(500)                           ,
    status           varchar(100)                           ,
    create_date      timestamp    default current_timestamp ,
    create_by        varchar(255) default 'system'          ,
    update_date      timestamp                              ,
    update_by        varchar(255)
);