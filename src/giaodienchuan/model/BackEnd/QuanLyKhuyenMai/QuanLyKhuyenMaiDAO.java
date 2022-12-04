/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodienchuan.model.BackEnd.QuanLyKhuyenMai;

import giaodienchuan.model.BackEnd.common.CommonDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class QuanLyKhuyenMaiDAO extends CommonDAO<KhuyenMai> {

    public QuanLyKhuyenMaiDAO() {
        super(KhuyenMai.class);
    }

    public ArrayList<KhuyenMai> readDB() {
        return super.readDB();
    }

    public Boolean add(KhuyenMai km) {
        return super.add(km);
    }

    public Boolean delete(String makm) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maKM", makm}
        });
        return super.delete(dieuKien);
    }

    public Boolean update(String makm, String tenkm, float dkkm, float phantramkm, LocalDate ngaybd, LocalDate ngaykt) {
        KhuyenMai khuyenMai = KhuyenMai.builder()
                .maKM(makm)
                .tenKM(tenkm)
                .dieuKienKM(dkkm)
                .phanTramKM(phantramkm)
                .ngayBD(ngaybd)
                .ngayKT(ngaykt)
                .build();
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maKM", makm}
        });
        return super.update(dieuKien, khuyenMai);
    }

}
