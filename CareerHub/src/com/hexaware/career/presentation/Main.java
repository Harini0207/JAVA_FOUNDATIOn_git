package com.hexaware.career.presentation;

import com.hexaware.career.dao.CompanyDaoImpl;
import com.hexaware.career.dao.JobListingsDaoImpl;
import com.hexaware.career.dao.ApplicantDaoImpl;
import com.hexaware.career.dao.JobApplicationDaoImpl;
import com.hexaware.career.entity.*;
import com.hexaware.career.exception.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize DAOs inside try-catch block to handle SQLException
        CompanyDaoImpl companyDao = null;
        JobListingsDaoImpl jobDao = null;
        ApplicantDaoImpl applicantDao = null;
        JobApplicationDaoImpl applicationDao = null;

        try {
            companyDao = new CompanyDaoImpl();
            jobDao = new JobListingsDaoImpl();
            applicantDao = new ApplicantDaoImpl();
            applicationDao = new JobApplicationDaoImpl();
        } catch (SQLException e) {
            System.out.println("❌ Failed to initialize DAOs: " + e.getMessage());
            e.printStackTrace();
            return; // Exit the application if DAOs fail to initialize
        }

        // Menu loop
        while (true) {
            System.out.println("\n===== CareerHub Job Board =====");
            System.out.println("1. Create Company");
            System.out.println("2. Post a Job");
            System.out.println("3. Register Applicant");
            System.out.println("4. Apply for Job");
            System.out.println("5. View All Jobs");
            System.out.println("6. View All Applicants");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Company ID: ");
                        int companyId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Company Name: ");
                        String companyName = scanner.nextLine();
                        System.out.print("Enter Location: ");
                        String companyLocation = scanner.nextLine();
                        Company company = new Company(companyId, companyName, companyLocation);
                        companyDao.insertCompany(company);
                        System.out.println(" Company created successfully.");
                        break;

                    case 2:
                        System.out.print("Enter Job ID: ");
                        int jobId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Company ID: ");
                        int cid = Integer.parseInt(scanner.nextLine());
                        System.out.print("Job Title: ");
                        String jtitle = scanner.nextLine();
                        System.out.print("Description: ");
                        String jdesc = scanner.nextLine();
                        System.out.print("Location: ");
                        String jloc = scanner.nextLine();
                        System.out.print("Salary: ");
                        double salary = Double.parseDouble(scanner.nextLine());
                        if (salary < 0) throw new NegativeSalaryException(" Salary cannot be negative!");
                        System.out.print("Job Type: ");
                        String jtype = scanner.nextLine();

                        JobListing job = new JobListing(jobId, cid, jtitle, jdesc, jloc, salary, jtype, LocalDateTime.now());
                        jobDao.insertJobListing(job);
                        System.out.println(" Job posted successfully.");
                        break;

                    case 3:
                        System.out.print("Enter Applicant ID: ");
                        int appId = Integer.parseInt(scanner.nextLine());
                        System.out.print("First Name: ");
                        String fname = scanner.nextLine();
                        System.out.print("Last Name: ");
                        String lname = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        if (!email.contains("@") || !email.contains(".")) {
                            throw new InvalidEmailFormatException(" Invalid email format!");
                        }
                        System.out.print("Phone: ");
                        String phone = scanner.nextLine();
                        System.out.print("Resume File (pdf/docx): ");
                        String resume = scanner.nextLine();
                        if (!resume.endsWith(".pdf") && !resume.endsWith(".docx")) {
                            throw new FileUploadException("❌ Only .pdf and .docx resumes allowed.");
                        }

                        Applicant applicant = new Applicant(appId, fname, lname, email, phone, resume);
                        applicantDao.insertApplicant(applicant);
                        System.out.println("Applicant registered successfully.");
                        break;

                    case 4:
                        System.out.print("Enter Application ID: ");
                        int applicationId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Job ID: ");
                        int jobID = Integer.parseInt(scanner.nextLine());
                        System.out.print("Applicant ID: ");
                        int applicantID = Integer.parseInt(scanner.nextLine());

                        JobApplication application = new JobApplication(applicationId, jobID, applicantID, LocalDateTime.now());
                        applicationDao.insertJobApplication(application);
                        System.out.println("Job application submitted successfully.");
                        break;

                    case 5:
                        List<JobListing> jobs = jobDao.getAllJobListings();
                        if (jobs.isEmpty()) {
                            System.out.println(" No jobs available.");
                        } else {
                            for (JobListing j : jobs) {
                                System.out.println(j);
                            }
                        }
                        break;

                    case 6:
                        List<Applicant> applicants = applicantDao.getAllApplicants();
                        if (applicants.isEmpty()) {
                            System.out.println(" No applicants registered.");
                        } else {
                            for (Applicant a : applicants) {
                                System.out.println(a);
                            }
                        }
                        break;

                    case 7:
                        System.out.println(" Exiting.. Thank you!");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice! Please select a valid option.");
                }
            } catch (InvalidEmailFormatException | FileUploadException |
                     NegativeSalaryException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (SQLException ex) {
                System.out.println("Database error: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Something went wrong: " + ex.getMessage());
            }
        }
    }
}
