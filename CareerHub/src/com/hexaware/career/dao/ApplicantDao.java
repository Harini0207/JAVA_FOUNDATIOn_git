package com.hexaware.career.dao;

import com.hexaware.career.entity.Applicant;
import java.sql.SQLException;
import java.util.List;

public interface ApplicantDao {
    void insertApplicant(Applicant applicant) throws SQLException;
    List<Applicant> getAllApplicants() throws SQLException;
    Applicant getApplicantById(int applicantID) throws SQLException;
    void updateApplicant(Applicant applicant) throws SQLException;
    void deleteApplicant(int applicantID) throws SQLException;
}
