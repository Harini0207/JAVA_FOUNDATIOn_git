package com.hexaware.career.service;

import com.hexaware.career.dao.ApplicantDao;
import com.hexaware.career.dao.ApplicantDaoImpl;
import com.hexaware.career.entity.Applicant;

import java.sql.SQLException;
import java.util.List;

public class ApplicantServiceImpl implements ApplicantService {
    private ApplicantDao applicantDao;

    public ApplicantServiceImpl() {
        try {
            applicantDao = new ApplicantDaoImpl();  // This may throw SQLException
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception or log it
        }
    }

    @Override
    public void insertApplicant(Applicant applicant) {
        try {
            applicantDao.insertApplicant(applicant);  // Calls the DAO method to insert Applicant
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception or log it
        }
    }

    @Override
    public List<Applicant> getAllApplicants() {
        try {
            return applicantDao.getAllApplicants();  // Fetch all applicants using DAO
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception or log it
        }
        return null;
    }

    @Override
    public Applicant getApplicantById(int applicantId) {
        try {
            return applicantDao.getApplicantById(applicantId);  // Fetch applicant by ID using DAO
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception or log it
        }
        return null;
    }
}
