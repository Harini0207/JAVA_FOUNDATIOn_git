package com.hexaware.career.dao;

import com.hexaware.career.entity.Company;
import com.hexaware.career.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoImpl implements CompanyDao {
    private Connection conn;

    public CompanyDaoImpl() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public void insertCompany(Company company) throws SQLException {
        String sql = "INSERT INTO Companies (companyID, name, location) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, company.getCompanyID());
        ps.setString(2, company.getCompanyName());
        ps.setString(3, company.getLocation());
       
        ps.executeUpdate();
    }

    @Override
    public List<Company> getAllCompanies() throws SQLException {
        String sql = "SELECT * FROM Companies";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Company> companies = new ArrayList<>();
        while (rs.next()) {
            Company company = new Company(
                rs.getInt("companyID"),
                rs.getString("companyName"),
                rs.getString("location")
               
            );
            companies.add(company);
        }
        return companies;
    }

    @Override
    public Company getCompanyById(int companyID) throws SQLException {
        String sql = "SELECT * FROM Companies WHERE companyID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, companyID);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Company(
                rs.getInt("companyID"),
                rs.getString("name"),
                rs.getString("location")
              
            );
        }
        return null;
    }

    @Override
    public void updateCompany(Company company) throws SQLException {
        String sql = "UPDATE Companies SET name = ?, location = ? WHERE companyID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, company.getCompanyName());
        ps.setString(2, company.getLocation());
       
        ps.setInt(5, company.getCompanyID());
        ps.executeUpdate();
    }

    @Override
    public void deleteCompany(int companyID) throws SQLException {
        String sql = "DELETE FROM Companies WHERE companyID = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, companyID);
        ps.executeUpdate();
    }
}
