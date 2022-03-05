package models;

public class ReimbursementsModel {

    private int reimbursementsID;
    private double reimbursementsAmount;
    private String reimbursementsSubmitTime;
    private String reimbursementsResolvedTime;
    private String reimbursementsDescription;
    private int reimbursementsApplicantID;
    private int reimbursementsStatusID;


    public ReimbursementsModel() {
        super();
    }

    public ReimbursementsModel(int reimbursementsID, double reimbursementsAmount, String reimbursementsSubmitTime, String reimbursementsResolvedTime, String reimbursementsDescription, int reimbursementsApplicantID, int reimbursementsStatusID) {
        this.reimbursementsID = reimbursementsID;
        this.reimbursementsAmount = reimbursementsAmount;
        this.reimbursementsSubmitTime = reimbursementsSubmitTime;
        this.reimbursementsResolvedTime = reimbursementsResolvedTime;
        this.reimbursementsDescription = reimbursementsDescription;
        this.reimbursementsApplicantID = reimbursementsApplicantID;
        this.reimbursementsStatusID = reimbursementsStatusID;
    }

    public int getReimbursementsID() {
        return reimbursementsID;
    }

    public void setReimbursementsID(int reimbursementsID) {
        this.reimbursementsID = reimbursementsID;
    }

    public double getReimbursementsAmount() {
        return reimbursementsAmount;
    }

    public void setReimbursementsAmount(double reimbursementsAmount) {
        this.reimbursementsAmount = reimbursementsAmount;
    }

    public String getReimbursementsSubmitTime() {
        return reimbursementsSubmitTime;
    }

    public void setReimbursementsSubmitTime(String reimbursementsSubmitTime) {
        this.reimbursementsSubmitTime = reimbursementsSubmitTime;
    }

    public String getReimbursementsResolvedTime() {
        return reimbursementsResolvedTime;
    }

    public void setReimbursementsResolvedTime(String reimbursementsResolvedTime) {
        this.reimbursementsResolvedTime = reimbursementsResolvedTime;
    }

    public String getReimbursementsDescription() {
        return reimbursementsDescription;
    }

    public void setReimbursementsDescription(String reimbursementsDescription) {
        this.reimbursementsDescription = reimbursementsDescription;
    }

    public int getReimbursementsApplicantID() {
        return reimbursementsApplicantID;
    }

    public void setReimbursementsApplicantID(int reimbursementsApplicantID) {
        this.reimbursementsApplicantID = reimbursementsApplicantID;
    }

    public int getReimbursementsStatusID() {
        return reimbursementsStatusID;
    }

    public void setReimbursementsStatusID(int reimbursementsStatusID) {
        this.reimbursementsStatusID = reimbursementsStatusID;
    }
}

