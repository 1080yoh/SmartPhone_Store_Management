package giaodienchuan.model.BackEnd.QuanLyLoaiSanPham;

import giaodienchuan.model.BackEnd.common.CommonDTO;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("loaisanpham")
public class LoaiSanPham extends CommonDTO {

    String maLSP;
    String tenLSP, moTa;

    public LoaiSanPham(String maLSP, String tenLSP, String moTa) {
        this.maLSP = maLSP;
        this.tenLSP = tenLSP;
        this.moTa = moTa;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String MoTa) {
        this.moTa = MoTa;
    }

    public String getMaLSP() {
        return maLSP;
    }

    public void setMaLSP(String MaLSP) {
        this.maLSP = MaLSP;
    }

    public String getTenLSP() {
        return tenLSP;
    }

    public void setTenLSP(String TenLSP) {
        this.tenLSP = TenLSP;
    }
}
