package com.voya.doctorproject.service;
import com.voya.doctorProject.exceprion.DoctorNotFoundException;
import com.voya.doctorProject.exceprion.IdNotFoundException;
import com.voya.doctorProject.model.Doctor;
import com.voya.doctorProject.repository.DoctorRepositoryImpl;
import com.voya.doctorProject.repository.IDoctorRepository;

import java.util.Collections;
import java.util.List;

public class DoctorServiceImpl implements IDoctorService{

    private IDoctorRepository doctorRepository = new DoctorRepositoryImpl();


    @Override
    public void addDoctor(Doctor doctor) {

        doctorRepository.addDoctor(doctor);

    }

    @Override
    public void updateDoctor(int doctorId, double fees) {
        doctorRepository.updateDoctor(doctorId,fees);
    }

    @Override
    public void deleteDoctor(int doctorId) {
        doctorRepository.deleteDoctor(doctorId);
    }

    @Override
    public Doctor getById(int doctorId) throws IdNotFoundException {

        Doctor doctor = doctorRepository.findById(doctorId);
        if(doctor==null) {
            throw new IdNotFoundException("id not found");
        }
        return doctor;
    }

    @Override
    public List<Doctor> getAll() {

        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException {

        List<Doctor> doctorList = doctorRepository.findBySpeciality(speciality);
        if (doctorList.isEmpty()) {
            throw new DoctorNotFoundException("doctor not found with  speciality ");
        }
        Collections.sort(doctorList,(d1, d2)->d1.getDoctorName().compareTo(d2.getDoctorName()));
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
        List<Doctor> doctorList = doctorRepository
                .findBySpecialityAndExp(speciality,experience);
        if (doctorList.isEmpty()) {
            throw new DoctorNotFoundException("doctor  not found with this spe anf experience");
        }
        Collections.sort(doctorList,(d1,d2)-> ((Integer)(d2.getExperience())).compareTo(d1.getExperience()));
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecialityAndLessFees(String speciality, double fees) throws DoctorNotFoundException{
        List<Doctor> doctorList = doctorRepository
                .findBySpecialityAndLessFees(speciality, fees);
        if (doctorList.isEmpty()) {
            throw new DoctorNotFoundException("doctor not found");
        }
        Collections.sort(doctorList,(d1,d2)-> ((Double)(d1.getFees())).compareTo(d2.getFees()));
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecialityAndRatings(String speciality, int ratings) throws DoctorNotFoundException{
        List<Doctor> doctorList = doctorRepository
                .findBySpecialityAndRatings(speciality, ratings);
        if (doctorList.isEmpty()) {
            throw new DoctorNotFoundException("doctor  not found");
        }
        Collections.sort(doctorList,(d1,d2)-> ((Integer)(d1.getRatings())).compareTo(d1.getRatings()));
        return doctorList;
    }

    @Override
    public List<Doctor> getBySpecialityAndNameContains(String speciality, String doctorName)throws DoctorNotFoundException {
        List<Doctor> doctorList = doctorRepository
                .findBySpecialityAndNameContains(speciality, doctorName);
        if (doctorList.isEmpty()) {
            throw new DoctorNotFoundException("doctor not found");
        }
        Collections.sort(doctorList,(d1,d2)-> (d2.getDoctorName().compareTo(d2.getDoctorName())));
        return doctorList;
    }
}

