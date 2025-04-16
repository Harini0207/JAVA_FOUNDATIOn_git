package com.hexaware.career.dao;

import com.hexaware.career.entity.JobListing;
import java.sql.SQLException;
import java.util.List;

public interface JobListingsDao {
    void insertJobListing(JobListing jobListing) throws SQLException;
    List<JobListing> getAllJobListings() throws SQLException;
    JobListing getJobListingById(int jobID) throws SQLException;
    void updateJobListing(JobListing jobListing) throws SQLException;
    void deleteJobListing(int jobID) throws SQLException;
}
