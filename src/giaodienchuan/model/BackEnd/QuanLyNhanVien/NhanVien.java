package giaodienchuan.model.BackEnd.QuanLyNhanVien;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("nhanvien")
public class NhanVien {

    @Id
    String maNV;
    String tenNV, diaChi, sdt;
    LocalDate ngaySinh;
    int trangThai;

    public NhanVien(String MaNV, String TenNV, LocalDate NgaySinh, String DiaChi, String sdt, int trangthai) {
        this.maNV = MaNV;
        this.tenNV = TenNV;
        this.ngaySinh = NgaySinh;
        this.diaChi = DiaChi;
        this.sdt = sdt;
        this.trangThai = trangthai;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String MaNV) {
        this.maNV = MaNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String TenNV) {
        this.tenNV = TenNV;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate NgaySinh) {
        this.ngaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.diaChi = DiaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.trangThai = TrangThai;
    }
}
