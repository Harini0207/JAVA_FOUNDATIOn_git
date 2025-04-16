package com.hexaware.career.service;

import com.hexaware.career.dao.CompanyDao;
import com.hexaware.career.dao.CompanyDaoImpl;
import com.hexaware.career.entity.Company;

import java.sql.SQLException;
import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    private CompanyDao companyDao;

    // Constructor with exception handling
    public CompanyServiceImpl() {
        try {
            companyDao = new CompanyDaoImpl();  // This may throw SQLException
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception or log it
        }
    }

    @Override
    public void insertCompany(Company company) {
        try {
            companyDao.insertCompany(company);  // Calls the DAO method to insert company
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception or log it
        }
    }

    @Override
    public List<Company> getAllCompanies() {
        try {
            return companyDao.getAllCompanies();  // Fetch all companies using DAO
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception or log it
        }
        return null;
    }

    @Override
    public Company getCompanyById(int companyId) {
        try {
            return companyDao.getCompanyById(companyId);  // Fetch company by ID using DAO
        } catch (SQLException e) {
            e.printStackTrace();  // Handle exception or log it
        }
        return null;
    }
}
