package dao;

import models.ReimbursementsModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAO {

    private PreparedStatement ps;

    private DBUtil dbutil = DBUtil.getConnectionFactory();
    Connection connection = dbutil.getConnection();

    //----------------------------------------------Employee----------------------------------------------
    /*
    addReimbursementsCase() will add data if
    return true if adding Reimbursements Case to database successfully
    return false if adding unsuccessful
     */
    public Boolean addReimbursementsCase(ReimbursementsModel reimbursement) {
        boolean flag = false;

        String sql = "INSERT INTO reimbursement(reimbursement_amount , reimbursement_description , " +
                "reimbursement_applicant_id , reimbursement_status_id)" +
                "values(? , ? , ? , ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setDouble(1 , reimbursement.getReimbursementsAmount());
            ps.setString(2 , reimbursement.getReimbursementsDescription());
            ps.setInt(3 , reimbursement.getReimbursementsApplicantID());
            ps.setInt(4 , reimbursement.getReimbursementsStatusID());

            int info = ps.executeUpdate();
            //It means we get the info from database and see do we add any new case ?
            if (info != 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<ReimbursementsModel> employeeCheckReimList(int userid , int statusid) {
        List<ReimbursementsModel> reimbursementsList = new ArrayList<ReimbursementsModel>();
        try {
            String sql = "";
            //If we have userid , we select the info
            if (userid != 0) {

                sql = "SELECT * FROM reimbursement WHERE reimbursement_applicant_id = ? AND reimbursement_status_id = ?";
                ps = connection.prepareStatement(sql);
                ps.setInt(1 , userid);
                ps.setInt(2 ,  statusid);
            } else {
                //if no user id , just simply check Do we have any info from reimbursement
                sql = "SELECT * FROM reimbursement";
                ps = connection.prepareStatement(sql);
            }

            //adding info from database to Reimbursements class
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                ReimbursementsModel reimbursements = new ReimbursementsModel();
                reimbursements.setReimbursementsID(resultSet.getInt(1));
                reimbursements.setReimbursementsAmount(resultSet.getDouble(2));
                reimbursements.setReimbursementsSubmitTime(resultSet.getString(3));
                reimbursements.setReimbursementsResolvedTime(resultSet.getString(4));
                reimbursements.setReimbursementsDescription(resultSet.getString(5));
                reimbursements.setReimbursementsApplicantID(resultSet.getInt(6));
                reimbursements.setReimbursementsStatusID(resultSet.getInt(7));

                reimbursementsList.add(reimbursements);
            }

            //sql = SELECT * FROM reimbursement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursementsList;
    }



    //----------------------------------------------Manager----------------------------------------------
    /*
    getReimbursementList() method will return all Reimbursement case list base on user id
     */
    public List<ReimbursementsModel> getReimbursementList(int userid , int statusid) {
        List<ReimbursementsModel> reimbursementsList = new ArrayList<ReimbursementsModel>();
        try {
            String sql = "";
            //If we have userid , we select the info
            if (userid != 0) {

                sql = "SELECT * FROM reimbursement WHERE reimbursement_applicant_id = ? AND reimbursement_status_id = ?";
                ps = connection.prepareStatement(sql);
                ps.setInt(1 , userid);
                ps.setInt(2 ,  statusid);
            } else {
                //if no user id , just simply check Do we have any info from reimbursement
                sql = "SELECT * FROM reimbursement";
                ps = connection.prepareStatement(sql);
            }

            //adding info from database to Reimbursements class
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                ReimbursementsModel reimbursements = new ReimbursementsModel();
                reimbursements.setReimbursementsID(resultSet.getInt(1));
                reimbursements.setReimbursementsAmount(resultSet.getDouble(2));
                reimbursements.setReimbursementsSubmitTime(resultSet.getString(3));
                reimbursements.setReimbursementsResolvedTime(resultSet.getString(4));
                reimbursements.setReimbursementsDescription(resultSet.getString(5));
                reimbursements.setReimbursementsApplicantID(resultSet.getInt(6));
                reimbursements.setReimbursementsStatusID(resultSet.getInt(7));

                reimbursementsList.add(reimbursements);
            }

            //sql = SELECT * FROM reimbursement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursementsList;
    }

    public List<ReimbursementsModel> viewReimbursement(int statusid) {
        List<ReimbursementsModel> reimbursementsList = new ArrayList<ReimbursementsModel>();
        String sql = "";
        try {
            if (statusid != 0) {
                //maybe try add users_role_id = 1 ?
                sql = "SELECT * FROM reimbursement WHERE reimbursement_status_id = ?";
                ps = connection.prepareStatement(sql);
                ps.setInt(1 ,  statusid);
            }

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                ReimbursementsModel reimbursements = new ReimbursementsModel();
                reimbursements.setReimbursementsID(resultSet.getInt(1));
                reimbursements.setReimbursementsAmount(resultSet.getDouble(2));
                reimbursements.setReimbursementsSubmitTime(resultSet.getString(3));
                reimbursements.setReimbursementsResolvedTime(resultSet.getString(4));
                reimbursements.setReimbursementsDescription(resultSet.getString(5));
                reimbursements.setReimbursementsApplicantID(resultSet.getInt(6));
                reimbursements.setReimbursementsStatusID(resultSet.getInt(7));

                reimbursementsList.add(reimbursements);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursementsList;
    }

    public List<ReimbursementsModel> viewAllReimbursement() {
        List<ReimbursementsModel> reimbursementsList = new ArrayList<ReimbursementsModel>();
        String sql = "SELECT * FROM reimbursement";
        try {
            ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                ReimbursementsModel reimbursements = new ReimbursementsModel();
                reimbursements.setReimbursementsID(resultSet.getInt(1));
                reimbursements.setReimbursementsAmount(resultSet.getDouble(2));
                reimbursements.setReimbursementsSubmitTime(resultSet.getString(3));
                reimbursements.setReimbursementsResolvedTime(resultSet.getString(4));
                reimbursements.setReimbursementsDescription(resultSet.getString(5));
                reimbursements.setReimbursementsApplicantID(resultSet.getInt(6));
                reimbursements.setReimbursementsStatusID(resultSet.getInt(7));

                reimbursementsList.add(reimbursements);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursementsList;
    }

    /*
    updateReimbursementsCase() will check if:
    return true if Reimbursements status update successfully
    return false if update unsuccessful
    */
    public boolean updateReimbursementsCase(ReimbursementsModel reimbursement) {
        Boolean flag = false;

        //This sql will update the info base on status id , time and reimbursement id
        String sql = "UPDATE reimbursement set reimbursement_status_id = ? , " +
                "reimbursement_resolved_time = CURRENT_TIMESTAMP WHERE reimbursement_id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1 , reimbursement.getReimbursementsStatusID());
            ps.setInt(2 , reimbursement.getReimbursementsID());

            int info = ps.executeUpdate();

            if (info != 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public boolean deleteReimbursementsCase(ReimbursementsModel reimbursement) {
        Boolean flag = false;

        String sql = "DELETE FROM reimbursement WHERE reimbursement_applicant_id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1 , reimbursement.getReimbursementsID());

            int info = ps.executeUpdate();
            if (info == 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}

