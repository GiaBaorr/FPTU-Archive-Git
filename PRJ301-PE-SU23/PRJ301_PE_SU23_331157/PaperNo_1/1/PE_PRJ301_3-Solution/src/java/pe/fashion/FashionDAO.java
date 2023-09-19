/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.fashion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

/**
 *
 * @author baoza
 */
public class FashionDAO {

    public List<FashionDTO> searchFashion(String name) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<FashionDTO> result = null;

        try {
            //1.Make connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2.Create SQL String
                String sql = "SELECT id, name, description, price, size, status "
                        + "FROM tblFashion "
                        + "WHERE name like ? "
                        + "AND status = 1 ";
                //3.Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                //4.Execute Query to get Result Set
                rs = stm.executeQuery();
                //5.Process
                while (rs.next()) {
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    FashionDTO dto = new FashionDTO();
                    dto.setId(rs.getString("id"));
                    dto.setName(rs.getString("name"));
                    dto.setDescription(rs.getString("description"));
                    dto.setPrice(rs.getDouble("price"));
                    dto.setSize(rs.getString("size"));
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

    public boolean deleteFashion(String id) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;

        try {
            //1.Make connection
            con = DBUtils.getConnection();
            if (con != null) {
                //2.Create SQL String
                String sql = "UPDATE tblFashion "
                        + "SET status = 0 "
                        + "WHERE id = ? ";
                //3.Create Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                //4.Execute Query to get Result Set
                int e = stm.executeUpdate();
                if (e > 0) {
                    result = true;
                }
                //5.Process

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
