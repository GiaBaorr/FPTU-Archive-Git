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
import pe.utils.DBUtils;

/**
 *
 * @author baoza
 */
public class UserDAO {
    
    public UserDTO checkLogin(String userID, String password) throws SQLException, ClassNotFoundException {
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
                stm.setString(1, userID);
                stm.setString(2, password);
                //4.Execute Query to get Result Set
                rs = stm.executeQuery();
                //5.Process
                if (rs.next()) {
                    result = new UserDTO();
                    result.setUserID(userID);
                    result.setFullName(rs.getString("fullName"));
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
}
