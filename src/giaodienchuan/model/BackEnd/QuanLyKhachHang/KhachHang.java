package giaodienchuan.model.BackEnd.QuanLyKhachHang;


import org.springframework.data.annotation.Id;

public class KhachHang {
    @Id
    String maKH;
    String tenKH, diaChi, sdt;
    int trangThai;

    public KhachHang(String MaKH, String TenKH, String DiaChi, String SDT, int TrangThai) {
        this.maKH = MaKH;
        this.tenKH = TenKH;
        this.diaChi = DiaChi;
        this.sdt = SDT;
        this.trangThai = TrangThai;
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
