/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodienchuan.model.BackEnd.QuanLyKhuyenMai;

import giaodienchuan.model.BackEnd.common.CommonDTO;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("khuyenmai")
public class KhuyenMai extends CommonDTO {

    String maKM;
    String tenKM;
    float dieuKienKM, phanTramKM;
    LocalDate ngayBD, ngayKT;

    @Builder
    public KhuyenMai(String maKM, String tenKM, float dieuKienKM, float phanTramKM, LocalDate ngayBD, LocalDate ngayKT) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.dieuKienKM = dieuKienKM;
        this.phanTramKM = phanTramKM;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
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
