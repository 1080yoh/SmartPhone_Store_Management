package giaodienchuan.model.BackEnd.QuanLyNhanVien;

import giaodienchuan.model.BackEnd.common.CommonDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class QuanLyNhanVienDAO extends CommonDAO<NhanVien> {


    public QuanLyNhanVienDAO() {
        super(NhanVien.class);
    }

    public ArrayList<NhanVien> readDB() {
        return super.readDB();
    }

    public Boolean add(NhanVien nv) {
        return super.add(nv);
    }

    public Boolean delete(String manv) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maNV", manv}
        });
        return super.delete(dieuKien);
    }

    public Boolean update(String MaNV, String TenNV, LocalDate NgaySinh, String DiaChi, String SDT, int trangthai) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maNV", MaNV}
        });
        Map<String, Object> truong = toMap(new Object[][]{
                {"tenNV", TenNV},
                {"diaChi", DiaChi},
                {"sdt", SDT},
                {"ngaySinh", NgaySinh},
                {"trangThai", trangthai}
        });
        return super.update(dieuKien, truong);
    }

    public Boolean updateTrangThai(String manv, int trangthai) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maNV", manv}
        });
        Map<String, Object> truong = toMap(new Object[][]{
                {"trangThai", trangthai}
        });
        return super.update(dieuKien, truong);
    }

}
