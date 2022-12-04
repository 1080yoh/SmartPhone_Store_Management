package giaodienchuan.model.BackEnd.QuanLyQuyen;

import org.springframework.data.annotation.Id;

public class Quyen {

    @Id
    String maQuyen;
    String tenQuyen, chiTietQuyen;
    
    public Quyen(String maquyen, String tenquyen, String chitietquyen) {
        this.maQuyen = maquyen;
        this.tenQuyen = tenquyen;
        this.chiTietQuyen = chitietquyen;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String TenQuyen) {
        this.tenQuyen = TenQuyen;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String MaQuyen) {
        this.maQuyen = MaQuyen;
    }

    public String getChiTietQuyen() {
        return chiTietQuyen;
    }

    public void setChiTietQuyen(String ChiTietQuyen) {
        this.chiTietQuyen = ChiTietQuyen;
    }
}
