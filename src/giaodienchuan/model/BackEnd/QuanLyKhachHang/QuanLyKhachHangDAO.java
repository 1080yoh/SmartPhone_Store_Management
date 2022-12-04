package giaodienchuan.model.BackEnd.QuanLyKhachHang;

import giaodienchuan.model.BackEnd.common.CommonDAO;

import java.util.ArrayList;
import java.util.Map;

public class QuanLyKhachHangDAO extends CommonDAO<KhachHang> {

    public QuanLyKhachHangDAO() {
        super(KhachHang.class);
    }

    public ArrayList<KhachHang> readDB() {
        return super.readDB();
    }

    public ArrayList<KhachHang> search(String columnName, String value) {
        return super.searchLike(columnName, value);
    }

    public Boolean add(KhachHang kh) {
        return super.add(kh);
    }

    public Boolean delete(String makh) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maKH", makh}
        });
        return super.delete(dieuKien);
    }

    public Boolean update(String MaKH, String TenKH, String DiaChi, String SDT, int trangthai) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maKH", MaKH}
        });
        Map<String, Object> truong = toMap(new Object[][]{
                {"tenKH", TenKH},
                {"diaChi", DiaChi},
                {"sdt", SDT},
                {"trangThai", trangthai}
        });
        return super.update(dieuKien, truong);
    }

    public Boolean updateTrangThai(String makh, int trangthai) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maKH", makh}
        });
        Map<String, Object> truong = toMap(new Object[][]{
                {"trangThai", trangthai}
        });
        return super.update(dieuKien, truong);
    }

}
