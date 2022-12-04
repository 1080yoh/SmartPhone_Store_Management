/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodienchuan.model.BackEnd.QuanLyKhuyenMai;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("khuyenmai")
public class KhuyenMai {

    @Id
    String maKM;
    String tenKM;
    float dieuKienKM, phanTramKM;
    LocalDate ngayBD, ngayKT;

    public KhuyenMai(String makm, String tenkm, float dkkm, float phantramkm, LocalDate ngaybd, LocalDate ngaykt) {
        this.maKM = makm;
        this.tenKM = tenkm;
        this.dieuKienKM = dkkm;
        this.phanTramKM = phantramkm;
        this.ngayBD = ngaybd;
        this.ngayKT = ngaykt;
    }

    public String getTrangThai() {
        LocalDate now = LocalDate.now();
        if (now.isBefore(this.ngayBD)) {
            return "Chưa bắt đầu";
        } else if (now.isAfter(this.ngayKT)) {
            return "Đã kết thúc";
        } else {
            return "Đang diễn ra";
        }
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String MaKM) {
        this.maKM = MaKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String TenKM) {
        this.tenKM = TenKM;
    }

    public float getDieuKienKM() {
        return dieuKienKM;
    }

    public void setDieuKienKM(float DieuKienKM) {
        this.dieuKienKM = DieuKienKM;
    }

    public float getPhanTramKM() {
        return phanTramKM;
    }

    public void setPhanTramKM(float PhanTramKM) {
        this.phanTramKM = PhanTramKM;
    }

    public LocalDate getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(LocalDate NgayBD) {
        this.ngayBD = NgayBD;
    }

    public LocalDate getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(LocalDate NgayKT) {
        this.ngayKT = NgayKT;
    }

}
