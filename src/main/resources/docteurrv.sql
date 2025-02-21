create database MediCare;

use medicare;

create table(
    patient_id INT PRIMARY KEY auto_increment,
    name varchar(100)not null ,
    email varchar(100)not null ,
    phone varchar(20) not null ,
    motif varchar(100) not null
);

create table Doctor (
                        Doctor_ID INT PRIMARY key auto_increment,
                        Name varchar(100) not null,
                        Speciality varchar(100) not null
);



create table Rendez_vous (
                             RendV_ID INT PRIMARY key auto_increment,
                             Appoinment_Date DATE,
                             Patient_ID INT,
                             Doctor_ID INT ,
                             time TIME NOT NULL,
                             foreign key (Patient_ID) references Patient(Patient_ID),
                             foreign key (Doctor_ID) references Doctor(Doctor_ID)
);
