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
import pojo.PhieuMuon;

/**
 *
 * @author Admin
 */
public class PhieuMuonServices {
    public boolean checkDocGiaByID(String id) throws SQLException{
        List<PhieuMuon> pms = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            String sql = "select * from phieumuon";
            if(id != null && !id.isEmpty())
                sql += "where trangThai = 'CHUA_TRA' and maDocGia like concat('%', ?, '%')";
            PreparedStatement stm = conn.prepareCall(sql);
            if(id != null && !id.isEmpty())
                stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                String maPhieuMuon = rs.getString("maPhieuMuon");
                String maDocGia = rs.getString("maDocGia");
                Date ngayMuon = rs.getDate("ngayMuon");
                PhieuMuon.StateOfPM trangThai = PhieuMuon.StateOfPM.valueOf(rs.getString("trangThai"));
                PhieuMuon pm = new PhieuMuon(maPhieuMuon, maDocGia, ngayMuon, trangThai);
                pms.add(pm);
            }
            if(pms.size() >= 1)
                return false;
        }
        return true;
    }
    public void luuPhieuMuon(){
        
    }
}
