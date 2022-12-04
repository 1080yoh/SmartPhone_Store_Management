/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodienchuan.model.BackEnd.QuanLyChiTietPN;

import giaodienchuan.model.BackEnd.ConnectionDB.ConnectionDB;
import giaodienchuan.model.BackEnd.common.CommonDAO;

import java.util.ArrayList;
import java.util.Map;

public class QuanLyChiTietPhieuNhapDAO extends CommonDAO<ChiTietPhieuNhap> {

    ConnectionDB qlctpnConnection;

    public QuanLyChiTietPhieuNhapDAO() {
        super(ChiTietPhieuNhap.class);
    }

    public ArrayList<ChiTietPhieuNhap> readDB() {
        return super.readDB();
    }

    public ArrayList<ChiTietPhieuNhap> search(String columName, String value) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {columName, value}
        });
        return super.search(null, dieuKien);

    }

    public Boolean add(ChiTietPhieuNhap ctpn) {
        return super.add(ctpn);
    }

    public Boolean deleteAll(String _mapn) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maPN", _mapn}
        });
        return super.delete(dieuKien);
    }

    public Boolean delete(String _mapn, String _masp) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maPN", _mapn},
                {"maSP", _masp},
        });
        return super.delete(dieuKien);
    }

    public boolean update(String mapn, String masp, int soluong, float dongia) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maPN", mapn},
                {"maSP", masp},
        });
        Map<String, Object> truong = toMap(new Object[][]{
                {"soLuong", soluong},
                {"donGia", dongia},
        });
        return super.update(dieuKien, truong);
    }
}
