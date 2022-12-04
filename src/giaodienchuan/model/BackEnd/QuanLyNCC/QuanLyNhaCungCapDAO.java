/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodienchuan.model.BackEnd.QuanLyNCC;

import giaodienchuan.model.BackEnd.common.CommonDAO;

import java.util.ArrayList;
import java.util.Map;


public class QuanLyNhaCungCapDAO extends CommonDAO<NhaCungCap> {

    public QuanLyNhaCungCapDAO() {
        super(NhaCungCap.class);
    }

    public ArrayList<NhaCungCap> readDB() {
        return super.readDB();
    }

    public Boolean add(NhaCungCap ncc) {
        return super.add(ncc);
    }

    public Boolean delete(String mancc) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maNCC", mancc}
        });
        return super.delete(dieuKien);
    }

    public Boolean update(String ma, String ten, String diachi, String sdt, String fax) {
        Map<String, Object> dieuKien = toMap(new Object[][]{
                {"maNCC", ma}
        });
        Map<String, Object> truong = toMap(new Object[][]{
                {"tenNCC", ten},
                {"diaChi", diachi},
                {"sdt", sdt},
                {"fax", fax}
        });
        return super.update(dieuKien, truong);
    }

}
