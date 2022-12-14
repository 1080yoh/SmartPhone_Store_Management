/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodienchuan.model.BackEnd.QuanLyPhieuNhap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Document("phieunhap")
public class PhieuNhap {

    @Id
    String maPN;
    String maNCC;
    String maNV;
    LocalDate ngayNhap;
    LocalTime gioNhap;
    float tongTien = 0F;

    public PhieuNhap() {
        this.ngayNhap = LocalDate.now();
        this.gioNhap = LocalTime.now();
    }

    public PhieuNhap(String maPN, String maNCC, String maNV, LocalDate ngayNhap, LocalTime gioNhap, float tongTien) {

        this.maPN = maPN;
        this.maNCC = maNCC;
        this.maNV = maNV;
        this.ngayNhap = ngayNhap;
        this.gioNhap = gioNhap;
        this.tongTien = tongTien;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public LocalTime getGioNhap() {
        return gioNhap;
    }

    public void setGioNhap(LocalTime gioNhap) {
        this.gioNhap = gioNhap;
    }

    public Float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

}
