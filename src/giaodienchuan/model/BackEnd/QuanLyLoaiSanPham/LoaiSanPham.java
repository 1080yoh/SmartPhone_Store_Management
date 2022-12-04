package giaodienchuan.model.BackEnd.QuanLyLoaiSanPham;

import org.springframework.data.annotation.Id;

public class LoaiSanPham {
    @Id
    String maLSP;
    String tenLSP, moTa;

    public LoaiSanPham(String MaLSP, String TenLSP, String MoTa) {
        this.maLSP = MaLSP;
        this.tenLSP = TenLSP;
        this.moTa = MoTa;
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
