package com.voya.doctorproject.client;
import com.voya.doctorProject.exceprion.DoctorNotFoundException;
import com.voya.doctorProject.exceprion.IdNotFoundException;

import com.voya.doctorProject.model.Doctor;
import com.voya.doctorProject.model.Specialization;
import com.voya.doctorProject.service.DoctorServiceImpl;

import java.util.List;
public class UserMain {
    public static void main(String[] args) {
        DoctorServiceImpl doctorService = new DoctorServiceImpl();

        // enum
        Specialization specialization = Specialization.DERMA;
        String speciality = specialization.getSpeciality();

        // Add a doctor using enum constant
        Doctor doctor = new Doctor();
        doctor.setDoctorName("Prabhakar B K");
        doctor.setSpeciality(speciality);
        doctor.setExperience(2);
        doctor.setRatings(5);
        doctor.setFees(2000.0);
        doctorService.addDoctor(doctor);


        // Update doctor
        int doctorIdToUpdate = 1;
        double newFees = 2500.0;
        doctorService.updateDoctor(doctorIdToUpdate, newFees);

        // Delete doctor
        int doctorIdToDelete = 2;
        doctorService.deleteDoctor(doctorIdToDelete);

        // Find doctor by ID
        int doctorIdToFind = 1;
        try {
            Doctor foundDoctor = doctorService.getById(doctorIdToFind);
            System.out.println(" Id: " + foundDoctor);
        } catch (IdNotFoundException e) {
            System.out.println("Doctor not found.");
        }

        // Get all doctors
        List<Doctor> allDoctors = doctorService.getAll();
        System.out.println("All doctors:");
        for (Doctor doc : allDoctors) {
            System.out.println(doc);
        }

        // Find doctors by specialty
        String specialityToFind = Specialization.GYNAEC.getSpeciality();
        try {
            List<Doctor> doctorsBySpeciality = doctorService.getBySpeciality(specialityToFind);

            for (Doctor doc : doctorsBySpeciality) {
                System.out.println(doc);
            }
        } catch (DoctorNotFoundException e) {
            System.out.println("Doctors with specialty not found.");
        }

        // Find doctors by specialty and experience
        int experienceToFind = 2;
        try {
            List<Doctor> doctorsBySpecialityAndExp = doctorService.getBySpecialityAndExp(specialityToFind, experienceToFind);

            for (Doctor doc : doctorsBySpecialityAndExp) {
                System.out.println(doc);
            }
        } catch (DoctorNotFoundException e) {
            System.out.println("Doctors not found.");
        }

        // Find doctors by specialty and fees less than
        double maxFees = 2000.0;
        try {
            List<Doctor> doctorsBySpecialityAndLessFees = doctorService.getBySpecialityAndLessFees(specialityToFind, maxFees);

            for (Doctor doc : doctorsBySpecialityAndLessFees) {
                System.out.println(doc);
            }
        } catch (DoctorNotFoundException e) {
            System.out.println("Doctors not found.");
        }

        // Find doctors by specialty and ratings
        int minRatings = 4;
        try {
            List<Doctor> doctorsBySpecialityAndRatings = doctorService.getBySpecialityAndRatings(specialityToFind, minRatings);

            for (Doctor doc : doctorsBySpecialityAndRatings) {
                System.out.println(doc);
            }
        } catch (DoctorNotFoundException e) {
            System.out.println("Doctors  not found.");
        }

        // Find doctors by specialty and name contains
        String doctorNameContains = "Prabhakar";
        try {
            List<Doctor> doctorsBySpecialityAndNameContains = doctorService.getBySpecialityAndNameContains(specialityToFind, doctorNameContains);

            for (Doctor doctor1 : doctorsBySpecialityAndNameContains) {
                System.out.println(doctor1);
            }
        } catch (DoctorNotFoundException e) {
            System.out.println("Doctorsnot found.");
        }



    }
}

