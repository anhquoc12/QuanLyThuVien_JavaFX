/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import conf.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pojo.DocGia;

/**
 *
 * @author dell
 */
public class DocGiaServices {
    public List<DocGia> listDocGiaByName(String kw) throws SQLException{
        List<DocGia> dgs = new ArrayList<>();
        
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM docgia";
            if (kw != null && !kw.isEmpty())
                sql += " WHERE tenDocGia like concat('%', ?, '%')";
            
            PreparedStatement stm = conn.prepareCall(sql);
            if (kw != null && !kw.isEmpty())
                stm.setString(1, kw);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String maDocGia = rs.getString("maDocGia");
                String tenDocGia = rs.getString("tenDocGia");
                Date ngaySinh = rs.getDate("ngaySinh");
                DocGia.Object object = DocGia.Object.valueOf(rs.getString("doiTuong"));
                Date ngayLapThe = rs.getDate("ngayLapThe");
                String soDT = rs.getString("soDT");
                String diaChi = rs.getString("ngayLapThe");
                DocGia dg = new DocGia(maDocGia, tenDocGia, ngaySinh, object, 
                        ngayLapThe, soDT, diaChi);
                dgs.add(dg);
            }
        }
        
        return dgs;
    }
    public List<DocGia> listDocGiaByID(String kw) throws SQLException{
        List<DocGia> dgs = new ArrayList<>();
        
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM docgia";
            if (kw != null && !kw.isEmpty())
                sql += " WHERE maDocGia like concat('%', ?, '%')";
            
            PreparedStatement stm = conn.prepareCall(sql);
            if (kw != null && !kw.isEmpty())
                stm.setString(1, kw);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String maDocGia = rs.getString("maDocGia");
                String tenDocGia = rs.getString("tenDocGia");
                Date ngaySinh = rs.getDate("ngaySinh");
                DocGia.Object object = DocGia.Object.valueOf(rs.getString("doiTuong"));
                Date ngayLapThe = rs.getDate("ngayLapThe");
                String soDT = rs.getString("soDT");
                String diaChi = rs.getString("ngayLapThe");
                DocGia dg = new DocGia(maDocGia, tenDocGia, ngaySinh, object, 
                        ngayLapThe, soDT, diaChi);
                dgs.add(dg);
            }
        }
        
        return dgs;
    }
}
