package service;

import dao.ReimbursementDAO;
import dao.UsersDAO;
import models.ReimbursementsModel;

import java.util.ArrayList;
import java.util.List;

    public class FinanceManagerServices {

        private ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
        private UsersDAO usersDAO = new UsersDAO();


        public boolean addCaseSuccess(ReimbursementsModel reimbursements) {
            boolean flag = false;

            flag = reimbursementDAO.addReimbursementsCase(reimbursements);

            return flag;
        }


        /*
        updateReimbursement() method will update the status of the reimbursement
        by calling the Reimbursement DAO.
        If update successfully , return true
        else , return false
         */
        public boolean updateReimbursement(ReimbursementsModel reimbursement) {
            boolean flag = false;

            flag = reimbursementDAO.updateReimbursementsCase(reimbursement);

            return flag;
        }

        /*
        checks if user is unique
        return true if is unique
        return false if isn't unique

        public boolean addUniqueUser(UsersModel user) {
            boolean flag = false;

            if (usersDAO.checkUniqueUser(user)) {
                if (usersDA.addUser(user)) {
                    flag = true;
                }
            }
            //System.out.println("(T/F) Is user unique? " + flag);
            return flag;
        }

        /*
        getAllReimbursement() method takes the user id and return the list of Reimbursement for the user
         */
        public List<ReimbursementsModel> getAllReimbursement(int userid, int statusid) {
            List<ReimbursementsModel> reimbursementsList = new ArrayList<ReimbursementsModel>();

            reimbursementsList = reimbursementDAO.getReimbursementList(userid, statusid);

            return reimbursementsList;
        }

        public List<ReimbursementsModel> employeegetList(int userid, int statusid) {
            List<ReimbursementsModel> employeeList = new ArrayList<ReimbursementsModel>();

            employeeList = reimbursementDAO.employeeCheckReimList(userid, statusid);

            return employeeList;

        }

        public List<ReimbursementsModel> getStatusList(int statusid) {
            List<ReimbursementsModel> reimbursementsList = new ArrayList<ReimbursementsModel>();

            reimbursementsList = reimbursementDAO.viewReimbursement(statusid);

            return reimbursementsList;
        }

        public List<ReimbursementsModel> allEmployeeList() {
            List<ReimbursementsModel> reimbursementsList = new ArrayList<ReimbursementsModel>();

            reimbursementsList = reimbursementDAO.viewAllReimbursement();

            return reimbursementsList;
        }
    }

