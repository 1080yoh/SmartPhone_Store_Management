package giaodienchuan.model.BackEnd.QuanLySanPham;

import giaodienchuan.model.BackEnd.common.CommonDAO;

import java.util.ArrayList;
import java.util.Map;

public class QuanLySanPhamDAO extends CommonDAO<SanPham> {

    public QuanLySanPhamDAO() {
        super(SanPham.class);
    }

    public ArrayList<SanPham> readDB() {
        return super.readDB();
    }

    public ArrayList<SanPham> search(String columnName, String value) {
        return super.searchLike(columnName, value);
    }

    public Boolean add(SanPham sp) {
        return super.add(sp);
    }

    public Boolean delete(String masp) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maSP", masp}
        });
        return super.delete(dieuKien);
    }

    public Boolean update(String MaSP, String MaLSP, String TenSP, float DonGia, int SoLuong, String filename, int trangthai) {
        SanPham sanPham = SanPham.builder()
                .maSP(MaSP)
                .maLSP(MaLSP)
                .tenSP(TenSP)
                .donGia(DonGia)
                .soLuong(SoLuong)
                .fileNameHinhAnh(filename)
                .trangThai(trangthai)
                .build();
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maSP", MaSP}
        });
        return super.update(dieuKien, sanPham);
    }

    public Boolean updateSoLuong(String MaSP, int SoLuong) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maSP", MaSP}
        });
        Map<String, Object> truong = toMap(new Object[][]{
                {"soLuong", SoLuong}
        });
        return super.update(dieuKien, truong);
    }

    public Boolean updateTrangThai(String MaSP, int trangthai) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maSP", MaSP}
        });
        Map<String, Object> truong = toMap(new Object[][]{
                {"trangThai", trangthai}
        });
        return super.update(dieuKien, truong);
    }

}
