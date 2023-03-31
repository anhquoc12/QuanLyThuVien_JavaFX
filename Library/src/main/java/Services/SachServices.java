/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import conf.JdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pojo.Sach;

/**
 *
 * @author dell
 */
public class SachServices {
    public List<Sach> SachList() throws SQLException
    {
        List<Sach> books = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn())
        {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Sach");
            
            while (rs.next())
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
                String description = rs.getString("motaSach")== ""?rs.getString("motaSach"): "Không có";
                
                Sach s = new Sach(id, name, tacgia, danhmuc, namXB, noiXB, ngayNhap,
                position, state, description);
                books.add(s);
                
            }
        }
        return books;
    }
}
