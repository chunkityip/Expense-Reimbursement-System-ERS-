package dao;

import models.UsersModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {

        private PreparedStatement ps;

        private DBUtil dbutil = DBUtil.getConnectionFactory();
        Connection connection = dbutil.getConnection();

        /*
        checkLogin() will check if:
        return true if username and password are valid
        return false if not valid
         */
        public Boolean checkLogin(String uname, String upass) {
            Boolean flag = false;

            try {
                String sql = "SELECT * FROM users WHERE users_name = ? AND password = ?";

                ps = connection.prepareStatement(sql);
                ps.setString(1, uname);
                ps.setString(2, upass);

                ResultSet resultSet = ps.executeQuery();

                if (resultSet.next()) {
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return flag;
        }

        /*
        getUser() method will get all the user details base on the username and password
         */
        public UsersModel getUser(String uname, String upass) throws SQLException {
            UsersModel user = new UsersModel();

            String sql = "SELECT * FROM users WHERE users_name = ? AND password = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, upass);


            ResultSet resultSet = ps.executeQuery();
            //adding info from database to Users class
            if (resultSet.next()) {
                user.setUserID(resultSet.getInt(1));
                user.setUserName(resultSet.getString(2));
                //we are skipping password
                user.setFirstName(resultSet.getString(4));
                user.setLastName(resultSet.getString(5));
                user.setEmail(resultSet.getString(6));
                user.setRoleID(resultSet.getInt(7));
            }

            return user;
        }

        /*
        checkUniqueUser() will check if:
        return true if it is new user
        return false if user already in the database
         */
        public Boolean checkUniqueUser(UsersModel user) {
            boolean flag = true;

            //We are checking username and user email. Are they already in the db?
            String sql = "SELECT * FROM users WHERE users_name = ? OR email = ?";

            try {
                ps = connection.prepareStatement(sql);
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getEmail());

                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    flag = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
            return flag;
        }

        /*
        addUser() will add if:
        return true if user adding is successful
        return false if adding unsuccessful
         */
        public Boolean addUser(UsersModel user) {
            boolean flag = false;

            String sql = "INSERT INTO users (first_name , last_name , email , users_name , password , users_role_id) " +
                    "values(? , ? , ? , ? , ? ,?)";

            try {
                ps = connection.prepareStatement(sql);
                ps.setString(1, user.getFirstName());
                ps.setString(2, user.getLastName());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getUserName());
                ps.setString(5, user.getUserPassword());
                ps.setInt(6, 1);

                int info = ps.executeUpdate();
                if (info != 0) {
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
                return false;
            }
            return flag;
        }

        public List<UsersModel> viewInfo (UsersModel user) {
            List<UsersModel> usersList = new ArrayList<UsersModel>();
            try {
                String sql =  "SELECT users_id , users_name , first_name, last_name , email FROM users";
                ps = connection.prepareStatement(sql);

                //adding info from database to user class
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    UsersModel users = new UsersModel();
                    users.setUserID(resultSet.getInt(1));
                    users.setUserName(resultSet.getString(2));
                    users.setFirstName(resultSet.getString(3));
                    users.setLastName(resultSet.getString(4));
                    users.setEmail(resultSet.getString(5));
                    usersList.add(users);
                }

                //sql = SELECT * FROM reimbursement;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return usersList;
        }

        public boolean updateUser(UsersModel userid) {
            boolean flag = false;

            String sql = "UPDATE users SET email = ? WHERE users_id = ?";
            try {
                ps = connection.prepareStatement(sql);
                ps.setString(1, userid.getEmail());

                int info = ps.executeUpdate();
                if (info != 0) {
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
                return false;
            }
            return flag;
        }
}
