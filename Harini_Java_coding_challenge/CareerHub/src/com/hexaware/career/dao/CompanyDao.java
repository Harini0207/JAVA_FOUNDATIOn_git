package com.hexaware.career.dao;

import com.hexaware.career.entity.Company;
import java.sql.SQLException;
import java.util.List;

public interface CompanyDao {
    void insertCompany(Company company) throws SQLException;
    List<Company> getAllCompanies() throws SQLException;
    Company getCompanyById(int companyID) throws SQLException;
    void updateCompany(Company company) throws SQLException;
    void deleteCompany(int companyID) throws SQLException;
}
