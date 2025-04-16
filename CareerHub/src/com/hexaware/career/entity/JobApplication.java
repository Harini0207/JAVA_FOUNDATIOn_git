package com.hexaware.career.entity;

import java.time.LocalDateTime;

public class JobApplication {
    private int applicationID;
    private int jobID;
    private int applicantID;
    private LocalDateTime applicationDate;
    private String resume;
    private String status;

  
    public JobApplication() {
    }

        public JobApplication(int applicationID, int jobID, int applicantID, LocalDateTime applicationDate, String resume, String status) {
        this.applicationID = applicationID;
        this.jobID = jobID;
        this.applicantID = applicantID;
        this.applicationDate = applicationDate;
        this.resume = resume;
        this.status = status;
    }

        public JobApplication(int applicationID, int jobID, int applicantID, LocalDateTime applicationDate) {
            this.applicationID = applicationID;
            this.jobID = jobID;
            this.applicantID = applicantID;
            this.applicationDate = applicationDate;
        }

    public int getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public int getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(int applicantID) {
        this.applicantID = applicantID;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "applicationID=" + applicationID +
                ", jobID=" + jobID +
                ", applicantID=" + applicantID +
                ", applicationDate=" + applicationDate +
                ", resume='" + resume + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
