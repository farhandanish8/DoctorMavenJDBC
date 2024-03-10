package com.voya.doctorproject.util;

public class Queries {
    public static final String InsertQuery = "insert into doctor(doctor_name,speciality,experience,ratings,fees) values(?,?,?,?,?)";
    public static final String UpdateQuery = "UPDATE DOCTOR SET fees=? WHERE doctor_id=?";
    public static final String DeleteQuery ="DELETE FROM DOCTOR WHERE doctor_id=?";
    public static final String FindAllQuery = "SELECT * FROM DOCTOR";
    public static final String FindBySpeciality = "SELECT * FROM DOCTOR WHERE speciality = ?";
    public static final String FindBYSpecialityAndExperience =   "SELECT * FROM DOCTOR WHERE speciality = ? AND experience >= ?";
    public static final String FindBySpecialityAndRatings =    "SELECT * FROM DOCTOR WHERE speciality = ? AND ratings >= ?";
    public static final String FindBySpecialityAndFees =  "SELECT * FROM DOCTOR WHERE speciality = ? AND fees <= ?";
    public static final String FindBySpecialityAndName = "SELECT * FROM DOCTOR WHERE speciality = ? AND doctor_name like ?";
    public static final String FindById = "SELECT * FROM DOCTOR WHERE doctor_id = ?";
}
}
