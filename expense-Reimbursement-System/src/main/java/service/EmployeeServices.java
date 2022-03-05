package service;

import dao.ReimbursementDAO;
import dao.UsersDAO;
import models.ReimbursementsModel;
import models.UsersModel;

import java.sql.SQLException;

    public class EmployeeServices {

        private UsersModel user = new UsersModel();
        private UsersDAO usersDAO = new UsersDAO();
        private ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
        private ReimbursementsModel reimbursements = new ReimbursementsModel();

        //userLogin() check is user info valid or not by using UsersDAO getUser() method
        //else ,
        public UsersModel userLogin(String userName , String password) throws SQLException {
            if (usersDAO.checkLogin(userName , password)) {
                user = usersDAO.getUser(userName , password);
            } else {
                user = new UsersModel();
            }
            return user;
        }

        /*
        reimbursementsClaim() method take reimbursement class as the argument by using reimbursementDAO addReimbursementsCase() method
        if reimbursement claim is adding successfully , return true
        else , return false
         */
        public boolean reimbursementsClaim(ReimbursementsModel reimbursement) {
            boolean flag = false;
            if (reimbursementDAO.addReimbursementsCase(reimbursement)) {
                flag = true;
            }
            return flag;
        }



        /*
        addUserSuccess() method will add the new user,
        return true if adding successfully
        return false if adding unsuccessfully
        */
        public boolean addUserSuccess(UsersModel user) {
            boolean flag = false;
            if (usersDAO.addUser(user)) {
                flag = true;
            }
            return flag;
        }

        /*
        deleteReimbursements() method will check:
        if reimbursement claim is delete successfully , return true
        else , return false
         */
        public boolean deleteReimbursements(ReimbursementsModel reimbursement) {
            boolean flag = false;
            if (reimbursementDAO.deleteReimbursementsCase(reimbursement)) {
                flag = true;
            }
            return flag;
        }

        //public boolean
    }

