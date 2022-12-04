package giaodienchuan.model.BackEnd.QuanLyQuyen;

import giaodienchuan.model.BackEnd.common.CommonDTO;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("phanquyen")
public class Quyen  extends CommonDTO {

    String maQuyen;
    String tenQuyen, chiTietQuyen;

    public Quyen(String maQuyen, String tenQuyen, String chiTietQuyen) {
        this.maQuyen = maQuyen;
        this.tenQuyen = tenQuyen;
        this.chiTietQuyen = chiTietQuyen;
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
