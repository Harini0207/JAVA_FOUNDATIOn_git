package com.hexaware.career.dao;

import com.hexaware.career.entity.JobListing;
import com.hexaware.career.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobListingsDaoImpl implements JobListingsDao {
    private Connection conn;

    public JobListingsDaoImpl() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public void insertJobListing(JobListing jobListing) throws SQLException {
        String sql = "INSERT INTO JobListings (jobID, companyID, jobTitle, jobDescription, jobLocation, salary, jobType, postedDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, jobListing.getJobID());
        ps.setInt(2, jobListing.getCompanyID());
        ps.setString(3, jobListing.getJobTitle());
        ps.setString(4, jobListing.getJobDescription());
        ps.setString(5, jobListing.getJobLocation());
        ps.setDouble(6, jobListing.getSalary());
        ps.setString(7, jobListing.getJobType());
        ps.setTimestamp(8, Timestamp.valueOf(jobListing.getPostedDate()));
        ps.executeUpdate();
    }

    @Override
    public List<JobListing> getAllJobListings() throws SQLException {
        String sql = "SELECT * FROM JobListings";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<JobListing> jobListings = new ArrayList<>();
        while (rs.next()) {
            JobListing jobListing = new JobListing(
                rs.getInt("jobID"),
                rs.getInt("companyID"),
                rs.getString("jobTitle"),
                rs.getString("jobDescription"),
                rs.getString("jobLocation"),
                rs.getDouble("salary"),
                rs.getString("jobType"),
                rs.getTimestamp("postedDate").toLocalDateTime()
            );
            jobListings.add(jobListing);
        }
        return jobListings;
    }

    @Override
    public JobListing getJobListingById(int jobID) throws SQLException {
        String sql = "SELECT * FROM JobListings WHERE jobID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, jobID);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new JobListing(
                rs.getInt("jobID"),
                rs.getInt("companyID"),
                rs.getString("jobTitle"),
                rs.getString("jobDescription"),
                rs.getString("jobLocation"),
                rs.getDouble("salary"),
                rs.getString("jobType"),
                rs.getTimestamp("postedDate").toLocalDateTime()
            );
        }
        return null;
    }

    @Override
    public void updateJobListing(JobListing jobListing) throws SQLException {
        String sql = "UPDATE JobListings SET companyID = ?, jobTitle = ?, jobDescription = ?, jobLocation = ?, salary = ?, jobType = ?, postedDate = ? WHERE jobID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, jobListing.getCompanyID());
        ps.setString(2, jobListing.getJobTitle());
        ps.setString(3, jobListing.getJobDescription());
        ps.setString(4, jobListing.getJobLocation());
        ps.setDouble(5, jobListing.getSalary());
        ps.setString(6, jobListing.getJobType());
        ps.setTimestamp(7, Timestamp.valueOf(jobListing.getPostedDate()));
        ps.setInt(8, jobListing.getJobID());
        ps.executeUpdate();
    }

    @Override
    public void deleteJobListing(int jobID) throws SQLException {
        String sql = "DELETE FROM JobListings WHERE jobID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, jobID);
        ps.executeUpdate();
    }
}
