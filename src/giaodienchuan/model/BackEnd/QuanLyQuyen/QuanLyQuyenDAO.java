package giaodienchuan.model.BackEnd.QuanLyQuyen;

import giaodienchuan.model.BackEnd.common.CommonDAO;

import java.util.ArrayList;
import java.util.Map;

public class QuanLyQuyenDAO extends CommonDAO<Quyen> {

    public QuanLyQuyenDAO() {
        super(Quyen.class);
    }

    public ArrayList<Quyen> readDB() {
        return super.readDB();
    }

    public Boolean add(Quyen q) {
        return super.add(q);
    }

    public Boolean delete(String maq) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maQuyen", maq}
        });
        return super.delete(dieuKien);
    }

    public Boolean update(String maq, String tenquyen, String chitietquyen) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maQuyen", maq}
        });
        Map<String, Object> truong = toMap(new Object[][]{
                {"tenQuyen", tenquyen},
                {"chiTietQuyen", chitietquyen}
        });
        return super.update(dieuKien, truong);
    }

}
