package giaodienchuan.model.BackEnd.QuanLyTaiKhoan;

import giaodienchuan.model.BackEnd.common.CommonDAO;

import java.util.ArrayList;
import java.util.Map;

public class QuanLyTaiKhoanDAO extends CommonDAO<TaiKhoan> {

    public QuanLyTaiKhoanDAO() {
        super(TaiKhoan.class);
    }

    public ArrayList<TaiKhoan> readDB() {
        return super.readDB();
    }

    public Boolean add(TaiKhoan tk) {
        return super.add(tk);
    }

    public Boolean delete(String username) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"username", username}
        });
        return super.delete(dieuKien);
    }

    public Boolean update(String username, String pass, String maNV, String maQuyen) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"username", username}
        });
        Map<String, Object> truong = toMap(new Object[][]{
                {"password", pass},
                {"maNV", maNV},
                {"maQuyen", maQuyen},
        });
        return super.update(dieuKien, truong);
    }

}
