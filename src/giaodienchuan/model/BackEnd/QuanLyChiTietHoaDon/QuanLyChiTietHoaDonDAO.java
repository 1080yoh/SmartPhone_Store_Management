package giaodienchuan.model.BackEnd.QuanLyChiTietHoaDon;

import giaodienchuan.model.BackEnd.common.CommonDAO;

import java.util.ArrayList;
import java.util.Map;

public class QuanLyChiTietHoaDonDAO extends CommonDAO<ChiTietHoaDon> {

    public QuanLyChiTietHoaDonDAO() {
        super(ChiTietHoaDon.class);
    }

    @Override
    public ArrayList<ChiTietHoaDon> readDB() {
        return super.readDB();
    }

    @Override
    public Boolean add(ChiTietHoaDon dto) {
        return super.add(dto);
    }

    public Boolean delete(String _mahd, String _masp) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maHoaDon", _mahd},
                {"maSanPham", _masp}
        });
        return super.delete(dieuKien);
    }

    public Boolean deleteAll(String _mahd) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maHoaDon", _mahd}
        });
        return super.delete(dieuKien);
    }

    public Boolean update(ChiTietHoaDon ct) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maHoaDon", ct.getMaHoaDon()},
                {"maSanPham", ct.getMaSanPham()}
        });
        return super.update(dieuKien, ct);
    }

    public Boolean update(String maHoaDon, String maSanPham, int soLuong, float donGia) {
        ChiTietHoaDon hd = new ChiTietHoaDon(maHoaDon, maSanPham, soLuong, donGia);
        return update(hd);
    }

}
