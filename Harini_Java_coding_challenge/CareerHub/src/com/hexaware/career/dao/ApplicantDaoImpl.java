package com.hexaware.career.dao;

import com.hexaware.career.entity.Applicant;
import com.hexaware.career.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicantDaoImpl implements ApplicantDao {
    private Connection conn;

    public ApplicantDaoImpl() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public void insertApplicant(Applicant applicant) throws SQLException {
        String sql = "INSERT INTO Applicants (applicantID, firstname,lastname, email, phone, resume) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, applicant.getApplicantID());
        ps.setString(2, applicant.getFirstName());
        ps.setString(3, applicant.getLastName());
        ps.setString(4, applicant.getEmail());
        ps.setString(5, applicant.getPhone());
        ps.setString(6, applicant.getResume());
        ps.executeUpdate();
    }

    @Override
    public List<Applicant> getAllApplicants() throws SQLException {
        String sql = "SELECT * FROM Applicants";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Applicant> applicants = new ArrayList<>();
        while (rs.next()) {
            Applicant applicant = new Applicant(
                    rs.getInt("applicantID"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("resume")
            );
            applicants.add(applicant);
        }
        return applicants;
    }

    @Override
    public Applicant getApplicantById(int applicantID) throws SQLException {
        String sql = "SELECT * FROM Applicants WHERE applicantID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, applicantID);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Applicant(
                    rs.getInt("applicantID"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("resume")
            );
        }
        return null;
    }

    @Override
    public void updateApplicant(Applicant applicant) throws SQLException {
        String sql = "UPDATE Applicants SET Firstname = ?,Lastname=?, email = ?, phone = ?, resume = ? WHERE applicantID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, applicant.getApplicantID());
        ps.setString(2, applicant.getFirstName());
        ps.setString(3, applicant.getLastName());
        ps.setString(4, applicant.getEmail());
        ps.setString(5, applicant.getPhone());
        ps.setString(6, applicant.getResume());
        ps.executeUpdate();
    }

    @Override
    public void deleteApplicant(int applicantID) throws SQLException {
        String sql = "DELETE FROM Applicants WHERE applicantID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, applicantID);
        ps.executeUpdate();
    }
}
