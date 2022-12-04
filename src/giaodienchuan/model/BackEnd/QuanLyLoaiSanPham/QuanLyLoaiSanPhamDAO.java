package giaodienchuan.model.BackEnd.QuanLyLoaiSanPham;

import giaodienchuan.model.BackEnd.common.CommonDAO;

import java.util.ArrayList;
import java.util.Map;

public class QuanLyLoaiSanPhamDAO extends CommonDAO<LoaiSanPham> {

    public QuanLyLoaiSanPhamDAO() {
        super(LoaiSanPham.class);
    }

    public ArrayList<LoaiSanPham> readDB() {
        return super.readDB();
    }

    public Boolean add(LoaiSanPham lsp) {
        return super.add(lsp);
    }

    public Boolean delete(String malsp) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maLSP", malsp}
        });
        return super.delete(dieuKien);
    }

    public Boolean update(String MaLSP, String TenLSP, String Mota) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maLSP", MaLSP}
        });
        Map<String, Object> truong = toMap(new Object[][]{
                {"tenLSP", TenLSP},
                {"moTa", Mota}
        });
        return super.update(dieuKien, truong);
    }

}
