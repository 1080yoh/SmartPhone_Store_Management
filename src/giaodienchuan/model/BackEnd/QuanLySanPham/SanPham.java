package giaodienchuan.model.BackEnd.QuanLySanPham;

import giaodienchuan.model.BackEnd.common.CommonDTO;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("sanpham")
public class SanPham extends CommonDTO {

    String maSP;
    String maLSP, tenSP, fileNameHinhAnh;
    float donGia;
    int soLuong, trangThai;

    @Builder
    public SanPham(String maSP, String maLSP, String tenSP, float donGia, int soLuong, String fileNameHinhAnh, int trangThai) {
        this.maSP = maSP;
        this.maLSP = maLSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.fileNameHinhAnh = fileNameHinhAnh;
        this.trangThai = trangThai;
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
