package giaodienchuan.model.BackEnd.QuanLyHoaDon;

import giaodienchuan.model.BackEnd.common.CommonDAO;

import java.util.ArrayList;
import java.util.Map;

public class QuanLyHoaDonDAO extends CommonDAO<HoaDon> {

    public QuanLyHoaDonDAO() {
        super(HoaDon.class);
    }

    public ArrayList<HoaDon> readDB() {
        return super.readDB();
    }

    public Boolean add(HoaDon hd) {
        return super.add(hd);
    }

    public Boolean delete(String mahd) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maHoaDon", mahd}
        });
        return super.delete(dieuKien);
    }

    public Boolean update(HoaDon hd) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maHoaDon", hd.getMaHoaDon()}
        });
        return super.update(dieuKien, hd);
    }

    public Boolean updateTongTien(String _mahd, float _tongTien) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maHoaDon", _mahd}
        });
        Map<String, Object> truong = toMap(new Object[][]{
                {"tongTien", _tongTien}
        });
        return super.update(dieuKien, truong);
    }

}
