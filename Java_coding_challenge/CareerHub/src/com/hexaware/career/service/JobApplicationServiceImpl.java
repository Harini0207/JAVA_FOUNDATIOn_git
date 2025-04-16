package com.hexaware.career.service;

import com.hexaware.career.dao.JobApplicationDao;
import com.hexaware.career.dao.JobApplicationDaoImpl;
import com.hexaware.career.entity.JobApplication;

import java.sql.SQLException;
import java.util.List;

public class JobApplicationServiceImpl implements JobApplicationService {
    private JobApplicationDao jobApplicationDao;

    public JobApplicationServiceImpl() {
        try {
            jobApplicationDao = new JobApplicationDaoImpl();  // This may throw SQLException
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception or log it
        }
    }

    @Override
    public void insertJobApplication(JobApplication jobApplication) {
        try {
            jobApplicationDao.insertJobApplication(jobApplication);  // Calls the DAO method to insert JobApplication
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception or log it
        }
    }

    @Override
    public List<JobApplication> getAllJobApplications() {
        try {
            return jobApplicationDao.getAllJobApplications();  // Fetch all job applications using DAO
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception or log it
        }
        return null;
    }

    @Override
    public JobApplication getJobApplicationById(int jobApplicationId) {
        try {
            return jobApplicationDao.getJobApplicationById(jobApplicationId);  // Fetch job application by ID using DAO
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception or log it
        }
        return null;
    }
}
