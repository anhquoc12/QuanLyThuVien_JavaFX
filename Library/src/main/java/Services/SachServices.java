/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Utils.General;
import conf.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pojo.Sach;

/**
 *
 * @author dell
 */
public class SachServices {

    public List<Sach> SachList() throws SQLException {
        List<Sach> books = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT* FROM Sach");

            while (rs.next()) {
                String id = rs.getString("maSach");
                String name = rs.getString("tenSach");
                String tacgia = rs.getString("tacGia");
                String danhmuc = rs.getString("theLoai");
                int namXB = rs.getInt("namXB");
                String noiXB = rs.getString("noiXB");
                Date ngayNhap = rs.getDate("ngayNhap");
                String position = rs.getString("viTri");
                Sach.StateOfBook state = Sach.StateOfBook.valueOf(rs.getString("trangThai"));
                String description = rs.getString("motaSach") == "" ? rs.getString("motaSach") : "Không có";

                Sach s = new Sach(id, name, tacgia, danhmuc, namXB, noiXB, ngayNhap,
                        position, state, description);
                books.add(s);

            }
        }
        return books;
    }
    
    public List<Sach> GetBookByName(String keywords) throws SQLException
    {
        List<Sach> books = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT* FROM Sach";
             if (keywords != null && !keywords.isEmpty())
                sql += " WHERE tenSach like concat('%', ?, '%')";
            
            PreparedStatement stm = conn.prepareCall(sql);
            if (keywords != null && !keywords.isEmpty())
                stm.setString(1, keywords);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String id = rs.getString("maSach");
                String name = rs.getString("tenSach");
                String tacgia = rs.getString("tacGia");
                String danhmuc = rs.getString("theLoai");
                int namXB = rs.getInt("namXB");
                String noiXB = rs.getString("noiXB");
                Date ngayNhap = rs.getDate("ngayNhap");
                String position = rs.getString("viTri");
                Sach.StateOfBook state = Sach.StateOfBook.valueOf(rs.getString("trangThai"));
                String description = rs.getString("motaSach") == "" ? rs.getString("motaSach") : "Không có";

                Sach s = new Sach(id, name, tacgia, danhmuc, namXB, noiXB, ngayNhap,
                        position, state, description);
                books.add(s);

            }
        }
        return books;
    }
    
    public List<Sach> GetBookByTacGia(String keywords) throws SQLException
    {
        List<Sach> books = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT* FROM Sach";
             if (keywords != null && !keywords.isEmpty())
                sql += " WHERE tacGia like concat('%', ?, '%')";
            
            PreparedStatement stm = conn.prepareCall(sql);
            if (keywords != null && !keywords.isEmpty())
                stm.setString(1, keywords);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String id = rs.getString("maSach");
                String name = rs.getString("tenSach");
                String tacgia = rs.getString("tacGia");
                String danhmuc = rs.getString("theLoai");
                int namXB = rs.getInt("namXB");
                String noiXB = rs.getString("noiXB");
                Date ngayNhap = rs.getDate("ngayNhap");
                String position = rs.getString("viTri");
                Sach.StateOfBook state = Sach.StateOfBook.valueOf(rs.getString("trangThai"));
                String description = rs.getString("motaSach") == "" ? rs.getString("motaSach") : "Không có";

                Sach s = new Sach(id, name, tacgia, danhmuc, namXB, noiXB, ngayNhap,
                        position, state, description);
                books.add(s);

            }
        }
        return books;
    }
    
    public List<Sach> GetBookByNamXB(String keywords) throws SQLException
    {
        List<Sach> books = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT* FROM Sach";
             if (keywords != null && !keywords.isEmpty())
                sql += " WHERE namXB = ?";
            
            PreparedStatement stm = conn.prepareCall(sql);
            if (keywords != null && !keywords.isEmpty())
                stm.setString(1, keywords);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String id = rs.getString("maSach");
                String name = rs.getString("tenSach");
                String tacgia = rs.getString("tacGia");
                String danhmuc = rs.getString("theLoai");
                int namXB = rs.getInt("namXB");
                String noiXB = rs.getString("noiXB");
                Date ngayNhap = rs.getDate("ngayNhap");
                String position = rs.getString("viTri");
                Sach.StateOfBook state = Sach.StateOfBook.valueOf(rs.getString("trangThai"));
                String description = rs.getString("motaSach") == "" ? rs.getString("motaSach") : "Không có";

                Sach s = new Sach(id, name, tacgia, danhmuc, namXB, noiXB, ngayNhap,
                        position, state, description);
                books.add(s);

            }
        }
        return books;
    }
    
    public List<Sach> GetBookByDanhMuc(String keywords) throws SQLException
    {
        List<Sach> books = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT* FROM Sach";
             if (keywords != null && !keywords.isEmpty())
                sql += " WHERE theLoai like concat('%', ?, '%')";
            
            PreparedStatement stm = conn.prepareCall(sql);
            if (keywords != null && !keywords.isEmpty())
                stm.setString(1, keywords);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                String id = rs.getString("maSach");
                String name = rs.getString("tenSach");
                String tacgia = rs.getString("tacGia");
                String danhmuc = rs.getString("theLoai");
                int namXB = rs.getInt("namXB");
                String noiXB = rs.getString("noiXB");
                Date ngayNhap = rs.getDate("ngayNhap");
                String position = rs.getString("viTri");
                Sach.StateOfBook state = Sach.StateOfBook.valueOf(rs.getString("trangThai"));
                String description = rs.getString("motaSach") == "" ? rs.getString("motaSach") : "Không có";

                Sach s = new Sach(id, name, tacgia, danhmuc, namXB, noiXB, ngayNhap,
                        position, state, description);
                books.add(s);

            }
        }
        return books;
    }
    
    public String AddBook(Sach s) throws SQLException
    {
        try (Connection conn = JdbcUtils.getConn())
        {
            conn.setAutoCommit(false);
            
            String sql = "INSERT INTO Sach(maSach, tenSach, tacGia, theLoai, namXB, noiXB, ngayNhap, viTri, trangThai, motaSach)";
            sql += " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, s.getMaSach());
            stm.setString(2, s.getTenSach());
            stm.setString(3, s.getTacGia());
            stm.setString(4, s.getTheLoai());
            stm.setInt(5, s.getNamXB());
            stm.setString(6, s.getNoiXB());
            stm.setDate(7, (java.sql.Date) s.getNgayNhap());
            stm.setString(8, s.getViTri());
            stm.setString(9, s.getTrangThai().name());
            stm.setString(10, s.getMotaSach());
            int r = stm.executeUpdate();
            return "Success";
        }
        catch(Exception ex) {return ex.getMessage();}
    }
    
    public String LastKey_Book() throws SQLException
    {
        try (Connection conn = JdbcUtils.getConn())
        {
            String sql = "SELECT maSach FROM qltv_db.Sach ORDER BY maSach DESC LIMIT 1;";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next())
            {
                return rs.getString("maSach");
            }
            else
                return null;
        }
    }
    
    public Sach FirstBook() throws SQLException
    {
        try (Connection conn = JdbcUtils.getConn())
        {
            
            String sql = "SELECT * FROM Sach LIMIT 1;";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next())
            {
                String id = rs.getString("maSach");
                String name = rs.getString("tenSach");
                String tacgia = rs.getString("tacGia");
                String danhmuc = rs.getString("theLoai");
                int namXB = rs.getInt("namXB");
                String noiXB = rs.getString("noiXB");
                Date ngayNhap = rs.getDate("ngayNhap");
                String position = rs.getString("viTri");
                Sach.StateOfBook state = Sach.StateOfBook.valueOf(rs.getString("trangThai"));
                String description = rs.getString("motaSach") == "" ? rs.getString("motaSach") : "Không có";

                return new Sach(id, name, tacgia, danhmuc, namXB, noiXB, ngayNhap,
                        position, state, description);
            }
            else
                return null;
        }
    }
    
    public static void main(String[] args) throws SQLException {
        // new General().ConvertDateToLocalDate(new SachServices().FirstBook().getNgayNhap())
        
    }
}
