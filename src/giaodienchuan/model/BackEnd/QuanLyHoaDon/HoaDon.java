package giaodienchuan.model.BackEnd.QuanLyHoaDon;

import giaodienchuan.model.BackEnd.common.CommonDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Document("hoadon")
public class HoaDon extends CommonDTO {

    private String maHoaDon;
    private String maNhanVien = "";
    private String maKhachHang = "";
    private String maKhuyenMai = "";
    private LocalDate ngayLap;
    private LocalTime gioLap;
    private float tongTien = 0;

    public HoaDon() {
        ngayLap = LocalDate.now();
        gioLap = LocalTime.now();
    }

    public HoaDon(String maHoaDon, String maNhanVien, String maKhachHang, String maKhuyenMai, LocalDate ngayLap, LocalTime gioLap, float tongTien) {
        this.maHoaDon = maHoaDon;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.maKhuyenMai = maKhuyenMai;
        this.ngayLap = ngayLap;
        this.gioLap = gioLap;
        this.tongTien = tongTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public LocalTime getGioLap() {
        return gioLap;
    }

    public void setGioLap(LocalTime gioLap) {
        this.gioLap = gioLap;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float TongTien) {
        this.tongTien = TongTien;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }
}
