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
public class DocGia {
    private String maDocGia;
    private String tenDocGia;
    private enum Gender
    {
        NAM,
        NU
    }
    private Date ngaySinh;
    private enum Object
    {
        STUDENT,
        TEACHER,
        EMPLOYEE
    }
    private Object doiTuong;
    private Date ngayLapthe;
    private String SoDT;
    private String diaChi;

    public DocGia() {
    }

    public DocGia(String maDocGia, String tenDocGia, Date ngaySinh, Object doiTuong, Date ngayLapthe, String SoDT, String diaChi) {
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.ngaySinh = ngaySinh;
        this.doiTuong = doiTuong;
        this.ngayLapthe = ngayLapthe;
        this.SoDT = SoDT;
        this.diaChi = diaChi;
    }

    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setDoiTuong(Object doiTuong) {
        this.doiTuong = doiTuong;
    }

    public void setNgayLapthe(Date ngayLapthe) {
        this.ngayLapthe = ngayLapthe;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaDocGia() {
        return maDocGia;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public Object getDoiTuong() {
        return doiTuong;
    }

    public Date getNgayLapthe() {
        return ngayLapthe;
    }

    public String getSoDT() {
        return SoDT;
    }

    public String getDiaChi() {
        return diaChi;
    }
    
    @Override 
    public String toString() {
        return this.tenDocGia;
    }
}
