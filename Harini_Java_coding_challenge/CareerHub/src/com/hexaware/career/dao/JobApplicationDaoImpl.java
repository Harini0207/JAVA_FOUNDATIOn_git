package com.hexaware.career.dao;

import com.hexaware.career.entity.JobApplication;
import com.hexaware.career.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobApplicationDaoImpl implements JobApplicationDao {
    private Connection conn;

    public JobApplicationDaoImpl() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public void insertJobApplication(JobApplication jobApplication) throws SQLException {
        String sql = "INSERT INTO JobApplications (applicationID, applicantID, jobID, applicationDate) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, jobApplication.getApplicationID());
        ps.setInt(2, jobApplication.getApplicantID());
        ps.setInt(3, jobApplication.getJobID());
        ps.setTimestamp(4, Timestamp.valueOf(jobApplication.getApplicationDate()));
        ps.executeUpdate();
    }

    @Override
    public List<JobApplication> getAllJobApplications() throws SQLException {
        String sql = "SELECT * FROM JobApplications";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<JobApplication> jobApplications = new ArrayList<>();
        while (rs.next()) {
            JobApplication jobApplication = new JobApplication(
                    rs.getInt("applicationID"),
                    rs.getInt("applicantID"),
                    rs.getInt("jobID"),
                    rs.getTimestamp("applicationDate").toLocalDateTime()
            );
            jobApplications.add(jobApplication);
        }
        return jobApplications;
    }

    @Override
    public JobApplication getJobApplicationById(int applicationID) throws SQLException {
        String sql = "SELECT * FROM JobApplications WHERE applicationID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, applicationID);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new JobApplication(
                    rs.getInt("applicationID"),
                    rs.getInt("applicantID"),
                    rs.getInt("jobID"),
                    rs.getTimestamp("applicationDate").toLocalDateTime()
            );
        }
        return null;
    }

    @Override
    public void updateJobApplication(JobApplication jobApplication) throws SQLException {
        String sql = "UPDATE JobApplications SET applicantID = ?, jobID = ?, applicationDate = ? WHERE applicationID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, jobApplication.getApplicantID());
        ps.setInt(2, jobApplication.getJobID());
        ps.setTimestamp(3, Timestamp.valueOf(jobApplication.getApplicationDate()));
        ps.setInt(4, jobApplication.getApplicationID());
        ps.executeUpdate();
    }

    @Override
    public void deleteJobApplication(int applicationID) throws SQLException {
        String sql = "DELETE FROM JobApplications WHERE applicationID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, applicationID);
        ps.executeUpdate();
    }
}
