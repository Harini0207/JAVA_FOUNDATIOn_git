package com.hexaware.career.service;

import com.hexaware.career.entity.Company;

import java.util.List;

public interface CompanyService {
    void insertCompany(Company company);
    List<Company> getAllCompanies();
    Company getCompanyById(int companyId);
}
