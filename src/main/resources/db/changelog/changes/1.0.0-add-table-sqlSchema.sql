create sequence hibernate_sequence start 1 increment 1;
  create table actions (
       id int4 not null,
        description varchar(255),
        destination_name varchar(255),
        result varchar(255),
        type_action varchar(255),
        event_id int4,
        primary key (id)
    );
	 create table credentials (
       id int4 not null,
        email varchar(255) not null,
        password varchar(30) not null,
        primary key (id)
    );
	create table diagnosis (
       id int4 not null,
        date timestamp,
        name varchar(255),
        patient_details_id int4,
        primary key (id)
    );
	create table doctor_ditales (
       id int4 not null,
        name varchar(255) not null,
        doctor_id int4,
        primary key (id)
    );
	 create table event (
       id int4 not null,
        end_time_work time,
        start_time_work time,
        stat_events varchar(255),
        type_events varchar(255),
        patient_details_id int4,
        working_day_id int4,
        primary key (id)
    );
	
	 create table patient_details (
       id int4 not null,
        status varchar(255),
        patient_id int4,
        primary key (id)
    );
	 create table users (
       id int4 not null,
        avatar_file_name varchar(255),
        first_name varchar(255) not null,
        last_name varchar(255) not null,
        position varchar(255),
        credential_id int4,
        primary key (id)
    );
	create table working_day (
       id int4 not null,
        day_of_week varchar(255),
        end_time_work time,
        start_time_work time,
        doctor_details_id int4,
        primary key (id)
    );
    alter table credentials 
       add constraint UK_6pka8top3ggqmjvppakv4ygl8 unique (email);
    alter table actions 
       add constraint FKpja73e2sx575yr6sqixr95kcj 
       foreign key (event_id) 
       references event;
    alter table diagnosis 
       add constraint FKm1g28xre5i2om31jorg6cu5i1 
       foreign key (patient_details_id) 
       references patient_details;
    alter table doctor_ditales 
       add constraint FK8otoqm5qsn5dlgmc5qg0qrikv 
       foreign key (doctor_id) 
       references users;
    alter table event 
       add constraint FKnouyip57rjqi8tmq5p2yvfy60 
       foreign key (patient_details_id) 
       references patient_details;
    alter table event 
       add constraint FKlh032oihqc4oypol3xhgj6o7y 
       foreign key (working_day_id) 
       references working_day;
    alter table patient_details 
       add constraint FK2hgl27xxfpx1u4ja3xx9o0n6h 
       foreign key (patient_id) 
       references users;
    alter table users 
       add constraint FK45ch6clbute36imxcljd6njiw 
       foreign key (credential_id) 
       references credentials;
    alter table working_day 
       add constraint FK7rx2jnfdkr7whyueuloaly1f3 
       foreign key (doctor_details_id) 
       references doctor_ditales;
