package giaodienchuan.model.BackEnd.Repo;

import giaodienchuan.model.BackEnd.ConnectionDB.ConnectionDB;
import giaodienchuan.model.BackEnd.QuanLyChiTietHoaDon.ChiTietHoaDon;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuanLyChiTietHoaDonRepo {

    ConnectionDB connection;

    public QuanLyChiTietHoaDonRepo() {
    }

    public ArrayList<ChiTietHoaDon> readDB() {
        connection = new ConnectionDB();
        ArrayList<ChiTietHoaDon> dshd = new ArrayList<>();
        try {
            String qry = "SELECT * FROM chitiethoadon";
            ResultSet rs = connection.sqlQuery(qry);
            if (rs != null) {
                while (rs.next()) {
                    ChiTietHoaDon hd = new ChiTietHoaDon(rs.getString("MaHD"), rs.getString("MaSP"), rs.getInt("SoLuong"), rs.getFloat("DonGia"));
                    dshd.add(hd);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu !!");
        } finally {
            connection.closeConnect();
        }
        return dshd;
    }

    public Boolean add(ChiTietHoaDon hd) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("INSERT INTO chitiethoadon(MaHD,MaSP,SoLuong,DonGia) VALUES ('" 
                + hd.getMaHoaDon() + "','" 
                + hd.getMaSanPham() + "','" 
                + hd.getSoLuong() + "','" 
                + hd.getDonGia() + "');");
        connection.closeConnect();
        return success;
    }

    public Boolean delete(String _mahd, String _masp) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("DELETE FROM chitiethoadon WHERE "
                + "MaHD='" + _mahd
                + "' AND MaSP='" + _masp + "';");
        connection.closeConnect();
        return success;
    }

    public Boolean deleteAll(String _mahd) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("DELETE FROM chitiethoadon WHERE MaHD='" + _mahd + "';");
        connection.closeConnect();
        return success;
    }

    public Boolean update(ChiTietHoaDon ct) {
        connection = new ConnectionDB();
        Boolean success = connection.sqlUpdate("UPDATE chitiethoadon set "
                + "SoLuong='" + ct.getSoLuong()
                + "', DonGia='" + ct.getDonGia()
                + "' WHERE MaHD='" + ct.getMaHoaDon() + "' AND MaSP='" + ct.getMaSanPham() + "';");
        connection.closeConnect();
        return success;
    }

    public Boolean update(String maHoaDon, String maSanPham, int soLuong, float donGia) {
        ChiTietHoaDon hd = new ChiTietHoaDon(maHoaDon, maSanPham, soLuong, donGia);
        return update(hd);
    }

    public void closeConnection() {
        connection.closeConnect();
    }
}
