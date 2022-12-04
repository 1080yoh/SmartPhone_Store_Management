package giaodienchuan.model.BackEnd.QuanLyTaiKhoan;

import giaodienchuan.model.BackEnd.common.CommonDTO;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("taikhoan")
@ToString
public class TaiKhoan extends CommonDTO {
    String username;
    String password, maNV, maQuyen;

    public TaiKhoan(String username, String password, String maNV, String maQuyen) {
        this.username = username;
        this.password = password;
        this.maNV = maNV;
        this.maQuyen = maQuyen;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }

}
