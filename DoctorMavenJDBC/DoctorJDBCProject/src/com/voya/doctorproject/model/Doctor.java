package com.voya.doctorproject.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Doctor {

    private Integer doctorId;
    private String doctorName;
    private String speciality;
    private double fees;
    private int ratings;
    private int experience;

}