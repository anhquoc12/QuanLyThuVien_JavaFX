/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

import java.util.Date;

/**
 *
 * @author dell
 */
public class PhieuMuon {
    private String maPhieuMuon;
    private String maDocGia;
    private Date ngayMuon;
    public enum StateOfPM {
        CHUA_TRA,
        DANG_DAT,
        DA_TRA
    }
    private StateOfPM trangThai;

    public PhieuMuon() {
    }

    public PhieuMuon(String maPhieuMuon, String maDocGia, Date ngayMuon, StateOfPM trangThai) {
        this.maPhieuMuon = maPhieuMuon;
        this.maDocGia = maDocGia;
        this.ngayMuon = ngayMuon;
        this.trangThai = trangThai;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public StateOfPM getTrangThai() {
        return trangThai;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public void setTrangThai(StateOfPM trangThai) {
        this.trangThai = trangThai;
    }
    
    @Override
    public String toString() {
        return this.maPhieuMuon;
    }
}
