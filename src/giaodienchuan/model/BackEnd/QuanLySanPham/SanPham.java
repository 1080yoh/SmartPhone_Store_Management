package giaodienchuan.model.BackEnd.QuanLySanPham;

import lombok.Builder;

public class SanPham {

    String maSP;
    String maLSP, tenSP, fileNameHinhAnh;
    float donGia;
    int soLuong, trangThai;

    @Builder
    public SanPham(String MaSP, String MaLSP, String TenSP, float DonGia, int SoLuong, String url, int TrangThai) {
        this.maSP = MaSP;
        this.maLSP = MaLSP;
        this.tenSP = TenSP;
        this.donGia = DonGia;
        this.soLuong = SoLuong;
        this.fileNameHinhAnh = url;
        this.trangThai = TrangThai;
    }

    public String getFileNameHinhAnh() {
        return fileNameHinhAnh;
    }

    public void setFileNameHinhAnh(String fileNameHinhAnh) {
        this.fileNameHinhAnh = fileNameHinhAnh;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String MaSP) {
        this.maSP = MaSP;
    }

    public String getMaLSP() {
        return maLSP;
    }

    public void setMaLSP(String MaLSP) {
        this.maLSP = MaLSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String TenSP) {
        this.tenSP = TenSP;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float DonGia) {
        this.donGia = DonGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.soLuong = SoLuong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.trangThai = TrangThai;
    }
}
