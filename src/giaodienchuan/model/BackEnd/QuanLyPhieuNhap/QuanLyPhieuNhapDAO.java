/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodienchuan.model.BackEnd.QuanLyPhieuNhap;

import giaodienchuan.model.BackEnd.common.CommonDAO;

import java.util.ArrayList;
import java.util.Map;

public class QuanLyPhieuNhapDAO extends CommonDAO<PhieuNhap> {


    public QuanLyPhieuNhapDAO() {
        super(PhieuNhap.class);
    }

    public ArrayList<PhieuNhap> readDB() {
        return super.readDB();
    }

    public Boolean add(PhieuNhap pn) {
        return super.add(pn);
    }

    public Boolean delete(String mapn) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maPN", mapn}
        });
        return super.delete(dieuKien);
    }

    public Boolean update(PhieuNhap pn) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maPN", pn.getMaPN()}
        });
        return super.update(dieuKien, pn);
    }

    public Boolean updateTongTien(String _mapn, float _tongTien) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maPN", _mapn}
        });
        Map<String, Object> truong = toMap(new Object[][]{
                {"tongTien", _tongTien}
        });
        return super.update(dieuKien, truong);
    }

}
