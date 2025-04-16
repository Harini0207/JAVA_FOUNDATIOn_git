package com.hexaware.career.service;

import com.hexaware.career.entity.JobApplication;

import java.util.List;

public interface JobApplicationService {
    void insertJobApplication(JobApplication jobApplication);
    List<JobApplication> getAllJobApplications();
    JobApplication getJobApplicationById(int jobApplicationId);
}
