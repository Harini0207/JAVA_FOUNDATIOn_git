package com.hexaware.career.service;

import com.hexaware.career.entity.JobListing;

import java.util.List;

public interface JobListingService {
    void insertJobListing(JobListing jobListing);
    List<JobListing> getAllJobListings();
    JobListing getJobListingById(int jobListingId);
}
