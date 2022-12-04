package giaodienchuan.model.BackEnd.QuanLyNhanVien;

import giaodienchuan.model.BackEnd.common.CommonDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("nhanvien")
public class NhanVien extends CommonDTO {

    String maNV;
    String tenNV, diaChi, sdt;
    LocalDate ngaySinh;
    int trangThai;

    public NhanVien(String maNV, String tenNV, LocalDate ngaySinh, String diaChi, String sdt, int trangThai) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
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
