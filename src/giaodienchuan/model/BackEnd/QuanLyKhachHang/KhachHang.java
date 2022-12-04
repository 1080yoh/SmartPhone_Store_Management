package giaodienchuan.model.BackEnd.QuanLyKhachHang;


import giaodienchuan.model.BackEnd.common.CommonDTO;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("khachhang")
public class KhachHang extends CommonDTO {
    String maKH;
    String tenKH, diaChi, sdt;
    int trangThai;

    public KhachHang(String maKH, String tenKH, String diaChi, String sdt, int trangThai) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String MaKH) {
        this.maKH = MaKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String TenKH) {
        this.tenKH = TenKH;
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
