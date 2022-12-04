package giaodienchuan.model.BackEnd.QuanLyChiTietHoaDon;

import giaodienchuan.model.BackEnd.common.CommonDTO;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("chitiethoadon")
public class ChiTietHoaDon extends CommonDTO {

    private String maHoaDon;

    private String maSanPham;
    private int soLuong;
    private float donGia;

    @Builder
    public ChiTietHoaDon(String maHoaDon, String maSanPham, int soLuong, float donGia) {
        this.maHoaDon = maHoaDon;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

}
