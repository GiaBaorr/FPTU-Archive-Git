/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import pe.utils.DBUtils;

/**
 *
 * @author baoza
 */
public class UserDAO {

    public UserDTO checkLogin(String userId, String password) throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        UserDTO result = null;

        try {
            //1.Make connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2.Create SQL String
                String sql = "SELECT fullName, roleID, status "
                        + "FROM tblUsers "
                        + "WHERE userID= ? "
                        + "AND password= ?";
                //3.Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, userId);
                stm.setString(2, password);
                //4.Execute Query to get Result Set
                rs = stm.executeQuery();
                //5.Process
                if (rs.next()) {
                    result = new UserDTO();
                    result.setUserID(userId);
                    result.setFullname(rs.getString("fullName"));
                    result.setPassword(password);
                    result.setRoleID(rs.getString("roleID"));
                    result.setStatus(rs.getBoolean("status"));
                }
            }//end connection had e

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public List<UserDTO> searchByFullName(String fullname) throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<UserDTO> result = new ArrayList<>();

        try {
            //1.Make connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2.Create SQL String
                String sql = "SELECT userID, password, fullName, roleID, status "
                        + "FROM tblUsers "
                        + "WHERE fullName like ? ";
                //3.Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + fullname + "%");
                //4.Execute Query to get Result Set
                rs = stm.executeQuery();
                //5.Process
                while (rs.next()) {
                    UserDTO dto = new UserDTO();
                    dto.setUserID(rs.getString("userID"));
                    dto.setFullname(rs.getString("fullName"));
                    dto.setPassword(rs.getString("password"));
                    dto.setRoleID(rs.getString("roleID"));
                    dto.setStatus(rs.getBoolean("status"));

                    result.add(dto);
                }
            }//end connection had e

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    
    public boolean updateUser(String userID, String fullname, String roleID) throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            //1.Make connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2.Create SQL String
                String sql = "UPDATE tblUsers "
                        + "SET fullName = ? ,"
                        + "roleID = ? "
                        + "WHERE userID = ?";
                //3.Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, fullname);
                stm.setString(2, roleID);
                stm.setString(3, userID);
                //4.Execute Query to get Result Set
                int eR = stm.executeUpdate();
                if(eR > 0){
                    result = true;
                }
            }//end connection had e

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
