package com.hexaware.career.dao;

import com.hexaware.career.entity.JobApplication;
import java.sql.SQLException;
import java.util.List;

public interface JobApplicationDao {
    void insertJobApplication(JobApplication jobApplication) throws SQLException;
    List<JobApplication> getAllJobApplications() throws SQLException;
    JobApplication getJobApplicationById(int applicationID) throws SQLException;
    void updateJobApplication(JobApplication jobApplication) throws SQLException;
    void deleteJobApplication(int applicationID) throws SQLException;
}
