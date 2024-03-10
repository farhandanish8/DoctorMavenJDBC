package com.voya.doctorproject.repository;
import com.voya.doctorProject.model.Doctor;
import com.voya.doctorProject.util.DoctorDb;
import com.voya.doctorProject.util.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorRespositoryImpl  implements IDoctorRepository {

    @Override
    public void addDoctor(Doctor doctor) {
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.InsertQuery);) {
            statement.setString(1, doctor.getDoctorName());
            statement.setString(2, doctor.getSpeciality());
            statement.setInt(3, doctor.getExperience());
            statement.setInt(4, doctor.getRatings());
            statement.setDouble(5, doctor.getFees());
            // call execute
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0)
                System.out.println("One row inserted s");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDoctor(int doctorId, double fees) {

        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.UpdateQuery);) {
            statement.setDouble(1, fees);
            statement.setInt(2, doctorId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0)
                System.out.println("One row updated successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDoctor(int doctorId) {

        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.DeleteQuery);) {
            statement.setInt(1, doctorId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0)
                System.out.println("One row deleted successfully.");
            else
                System.out.println("Delete operation failed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Doctor findById(int doctorId) {

        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.FindById);) {
            statement.setInt(1, doctorId);
            try (ResultSet resultSet = statement.executeQuery();) {
                if (resultSet.next()) {
                    String doctorName = resultSet.getString("doctor_name");
                    String speciality = resultSet.getString("speciality");
                    int experience = resultSet.getInt("experience");
                    int ratings = resultSet.getInt("ratings");
                    double fees = resultSet.getDouble("fees");
                    Doctor  doctor = new Doctor(doctorId, doctorName, speciality, fees, ratings, experience);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Doctor> findAll() {

        List<Doctor> doctorList = new ArrayList<>();

        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.FindAllQuery);
             ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {
                int doctorId = resultSet.getInt("doctor_id");
                String doctorName = resultSet.getString("doctor_name");
                String speciality = resultSet.getString("speciality");
                int experience = resultSet.getInt("experience");
                int ratings = resultSet.getInt("ratings");
                double fees = resultSet.getDouble("fees");
                Doctor doctor = new Doctor(doctorId, doctorName, speciality, fees, ratings, experience);
                doctorList.add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorList;
    }

    @Override
    public List<Doctor> findBySpeciality(String speciality) {
        List<Doctor> doctorList = new ArrayList<>();


        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.FindBySpeciality);) {
            statement.setString(1, speciality);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    int doctorId = resultSet.getInt("doctor_id");
                    String doctorName = resultSet.getString("doctor_name");
                    int experience = resultSet.getInt("experience");
                    int ratings = resultSet.getInt("ratings");
                    double fees = resultSet.getDouble("fees");
                    Doctor doctor = new Doctor(doctorId, doctorName, speciality, fees, ratings, experience);
                    doctorList.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorList;
    }

    @Override
    public List<Doctor> findBySpecialityAndExp(String speciality, int experience) {
        List<Doctor> doctorList = new ArrayList<>();
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.FindBYSpecialityAndExperience);) {
            statement.setString(1, speciality);
            statement.setInt(2, experience);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    int doctorId = resultSet.getInt("doctor_id");
                    String doctorName = resultSet.getString("doctor_name");
                    int ratings = resultSet.getInt("ratings");
                    double fees = resultSet.getDouble("fees");
                    Doctor doctor = new Doctor(doctorId, doctorName, speciality, fees, ratings, experience);
                    doctorList.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorList;
    }

    @Override
    public List<Doctor> findBySpecialityAndLessFees(String speciality, double fees) {
        List<Doctor> doctorList = new ArrayList<>();
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.FindBySpecialityAndFees);) {
            statement.setString(1, speciality);
            statement.setDouble(2, fees);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    int doctorId = resultSet.getInt("doctor_id");
                    String doctorName = resultSet.getString("doctor_name");
                    int experience = resultSet.getInt("experience");
                    int ratings = resultSet.getInt("ratings");
                    Doctor doctor = new Doctor(doctorId, doctorName, speciality, fees, ratings, experience);
                    doctorList.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorList;
    }

    @Override
    public List<Doctor> findBySpecialityAndRatings(String speciality, int ratings) {
        List<Doctor> doctorList = new ArrayList<>();
        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.FindBySpecialityAndRatings);) {
            statement.setString(1, speciality);
            statement.setInt(2, ratings);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    int doctorId = resultSet.getInt("doctor_id");
                    String doctorName = resultSet.getString("doctor_name");
                    int experience = resultSet.getInt("experience");
                    double fees = resultSet.getDouble("fees");
                    Doctor doctor = new Doctor(doctorId, doctorName, speciality, fees, ratings, experience);
                    doctorList.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorList;
    }

    @Override
    public List<Doctor> findBySpecialityAndNameContains(String speciality, String doctorName) {


        List<Doctor> doctorList = new ArrayList<>();

        try (Connection connection = DoctorDb.openConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.FindBySpecialityAndName);) {
            statement.setString(1, speciality);
            statement.setString(2, "%" + doctorName + "%");
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    int doctorId = resultSet.getInt("doctor_id");
                    String docName = resultSet.getString("doctor_name");
                    int experience = resultSet.getInt("experience");
                    int ratings = resultSet.getInt("ratings");
                    double fees = resultSet.getDouble("fees");
                    Doctor doctor = new Doctor(doctorId, docName, speciality, fees, ratings, experience);
                    doctorList.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorList;
    }
}
