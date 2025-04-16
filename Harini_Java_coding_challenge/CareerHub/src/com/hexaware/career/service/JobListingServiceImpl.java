package com.hexaware.career.service;

import com.hexaware.career.dao.JobListingsDao;
import com.hexaware.career.dao.JobListingsDaoImpl;
import com.hexaware.career.entity.JobListing;

import java.sql.SQLException;
import java.util.List;

public class JobListingServiceImpl implements JobListingService {
    private JobListingsDao jobListingDao;

    public JobListingServiceImpl() {
        try {
            jobListingDao = new JobListingsDaoImpl();  // This may throw SQLException
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception or log it
        }
    }

    @Override
    public void insertJobListing(JobListing jobListing) {
        try {
            jobListingDao.insertJobListing(jobListing);  // Calls the DAO method to insert JobListing
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception or log it
        }
    }

    @Override
    public List<JobListing> getAllJobListings() {
        try {
            return jobListingDao.getAllJobListings();  // Fetch all job listings using DAO
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception or log it
        }
        return null;
    }

    @Override
    public JobListing getJobListingById(int jobListingId) {
        try {
            return jobListingDao.getJobListingById(jobListingId);  // Fetch job listing by ID using DAO
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception or log it
        }
        return null;
    }
}
