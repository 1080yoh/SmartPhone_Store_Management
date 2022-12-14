/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodienchuan.model.FrontEnd.FormQuanLy.ThongKe;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import giaodienchuan.model.BackEnd.PriceFormatter;
import giaodienchuan.model.BackEnd.QuanLyChiTietHoaDon.ChiTietHoaDon;
import giaodienchuan.model.BackEnd.QuanLyChiTietHoaDon.QuanLyChiTietHoaDonBUS;
import giaodienchuan.model.BackEnd.QuanLyChiTietPN.ChiTietPhieuNhap;
import giaodienchuan.model.BackEnd.QuanLyChiTietPN.QuanLyChiTietPhieuNhapBUS;
import giaodienchuan.model.BackEnd.QuanLyHoaDon.HoaDon;
import giaodienchuan.model.BackEnd.QuanLyHoaDon.QuanLyHoaDonBUS;
import giaodienchuan.model.BackEnd.QuanLyKhachHang.KhachHang;
import giaodienchuan.model.BackEnd.QuanLyKhachHang.QuanLyKhachHangBUS;
import giaodienchuan.model.BackEnd.QuanLyNCC.NhaCungCap;
import giaodienchuan.model.BackEnd.QuanLyNCC.QuanLyNhaCungCapBUS;
import giaodienchuan.model.BackEnd.QuanLyNhanVien.NhanVien;
import giaodienchuan.model.BackEnd.QuanLyNhanVien.QuanLyNhanVienBUS;
import giaodienchuan.model.BackEnd.QuanLyPhieuNhap.PhieuNhap;
import giaodienchuan.model.BackEnd.QuanLyPhieuNhap.QuanLyPhieuNhapBUS;
import giaodienchuan.model.BackEnd.QuanLySanPham.QuanLySanPhamBUS;
import giaodienchuan.model.BackEnd.QuanLySanPham.SanPham;
import giaodienchuan.model.FrontEnd.GiaoDienChuan.MyTable;
import giaodienchuan.model.FrontEnd.MyButton.DateButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ThongKeHuuForm {

}

class ThongKeSanPham extends JPanel {

    QuanLyChiTietHoaDonBUS qlcthdBUS = new QuanLyChiTietHoaDonBUS();
    QuanLyHoaDonBUS qlhdBUS = new QuanLyHoaDonBUS();
    QuanLySanPhamBUS qlspBUS = new QuanLySanPhamBUS();
    QuanLyPhieuNhapBUS qlpnBUS = new QuanLyPhieuNhapBUS();
    QuanLyChiTietPhieuNhapBUS qlctpnBUS = new QuanLyChiTietPhieuNhapBUS();
    QuanLyNhaCungCapBUS qlnccBUS = new QuanLyNhaCungCapBUS();
    QuanLyNhanVienBUS qlnvBUS = new QuanLyNhanVienBUS();

    JTextField txKhoangNgayTu = new JTextField(15);
    JTextField txKhoangNgayDen = new JTextField(15);
    DatePicker dPicker1;
    DatePicker dPicker2;

    JComboBox cbTieuChi;
    JButton btnRefresh = new JButton("L??m m???i");
    MyTable tb;

    public ThongKeSanPham() {
        this.setLayout(new BorderLayout());

        DatePickerSettings pickerSettings = new DatePickerSettings();
        pickerSettings.setVisibleDateTextField(false);
        dPicker1 = new DatePicker(pickerSettings);
        dPicker1.addDateChangeListener((dce) -> {
            txKhoangNgayTu.setText(dPicker1.getDateStringOrEmptyString());
        });
        dPicker2 = new DatePicker(pickerSettings.copySettings());
        dPicker2.addDateChangeListener((dce) -> {
            txKhoangNgayDen.setText(dPicker2.getDateStringOrEmptyString());
        });

        DateButton db = new DateButton(dPicker1);
        DateButton db2 = new DateButton(dPicker2);

        //Panel tieu chi
        JPanel plTieuchi = new JPanel();
        plTieuchi.setLayout(new FlowLayout());

        cbTieuChi = new JComboBox(new String[]{"S??? l?????ng nh???p", "S??? l?????ng b??n"});
        cbTieuChi.addActionListener((ae) -> {
            cbSearchOnChange();
        });
        plTieuchi.add(cbTieuChi);

        JPanel plKhoangNgay1 = new JPanel();
        txKhoangNgayTu.setBorder(BorderFactory.createTitledBorder("T???:"));
        addDocumentListener(txKhoangNgayTu);
        plKhoangNgay1.add(txKhoangNgayTu);
        plKhoangNgay1.add(dPicker1);
        JPanel plKhoangNgay2 = new JPanel();
        txKhoangNgayDen.setBorder(BorderFactory.createTitledBorder("?????n"));
        addDocumentListener(txKhoangNgayDen);
        plKhoangNgay2.add(txKhoangNgayDen);
        plKhoangNgay2.add(dPicker2);

        btnRefresh.setIcon(new ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_data_backup_30px.png")));
        btnRefresh.addActionListener((ae) -> {
            qlspBUS.readDB();
            qlpnBUS.readDB();
            qlctpnBUS.readDB();
            qlnccBUS.readDB();
            qlnvBUS.readDB();
            qlhdBUS.readDB();
            qlcthdBUS.readDB();
            txKhoangNgayTu.setText("");
            txKhoangNgayDen.setText("");
            dPicker1.setDate(null);
            dPicker2.setDate(null);
            cbSearchOnChange();
        });

        plTieuchi.add(plKhoangNgay1);
        plTieuchi.add(plKhoangNgay2);
        plTieuchi.add(btnRefresh);

        this.add(plTieuchi, BorderLayout.NORTH);

        //Table thong ke
        tb = new MyTable();
        cbSearchOnChange();
        this.add(tb, BorderLayout.CENTER);
    }

//    private void soLuongSanPhamNhap() {
//        tb.clear();
//        tb.setHeaders(new String[]{"M?? s???n ph???m", "T??n s???n ph???m", "M?? phi???u nh???p", "T??n nh?? cung c???p", "Ng??y nh???p", "S??? l?????ng"});
//
//        MyCheckDate mcd = new MyCheckDate(txKhoangNgayTu, txKhoangNgayDen);
//
//        int tongTatCa = 0;
//        for (SanPham sp : qlspBUS.getDssp()) {
//            int tongSoLuong = 0;
//            tb.addRow(new String[]{sp.getMaSP(), sp.getTenSP(), "", "", "", ""});
//
//            for (PhieuNhap pn : qlpnBUS.search("T???t c???", "", mcd.getNgayTu(), mcd.getNgayDen(), -1, -1)) {
//                ChiTietPhieuNhap ctpn = qlctpnBUS.getChiTiet(pn.getMaPN(), sp.getMaSP());
//                if (ctpn != null) {
//                    tb.addRow(new String[]{"", "",
//                        pn.getMaPN(),
//                        qlnccBUS.getNhaCungCap(pn.getMaNCC()).getTenNCC(),
//                        String.valueOf(pn.getNgayNhap()),
//                        String.valueOf(ctpn.getSoLuong())
//                    });
//                    tongSoLuong += ctpn.getSoLuong();
//                }
//            }
//            
//            tb.addRow(new String[]{"", "", "", "", mcd.getKhoangTG(), String.valueOf(tongSoLuong)});
//            tb.addRow(new String[]{"", "", "", "", "", ""});
//
//            tongTatCa += tongSoLuong;
//        }
//        tb.addRow(new String[]{"", "", "", "", "T???ng t???t c???", String.valueOf(tongTatCa)});
//    }
//
//    private void soLuongSanPhamBan() {
//        tb.clear();
//        tb.setHeaders(new String[]{"M?? s???n ph???m", "T??n s???n ph???m", "M?? h??a ????n", "T??n nh??n vi??n", "Ng??y l???p", "S??? l?????ng"});
//
//        MyCheckDate mcd = new MyCheckDate(txKhoangNgayTu, txKhoangNgayDen);
//
//        int tongTatCa = 0;
//        for (SanPham sp : qlspBUS.getDssp()) {
//            int tongSoLuong = 0;
//            tb.addRow(new String[]{sp.getMaSP(), sp.getTenSP(), "", "", "", ""});
//
//            for (HoaDon hd : qlhdBUS.search("T???t c???", "", mcd.getNgayTu(), mcd.getNgayTu(), -1, -1)) {
//                ChiTietHoaDon cthd = qlcthdBUS.getChiTiet(hd.getMaHoaDon(), sp.getMaSP());
//                if (cthd != null) {
//                    tb.addRow(new String[]{"", "",
//                        hd.getMaHoaDon(),
//                        qlnvBUS.getNhanVien(hd.getMaNhanVien()).getTenNV(),
//                        String.valueOf(hd.getNgayLap()),
//                        String.valueOf(cthd.getSoLuong())
//                    });
//                    tongSoLuong += cthd.getSoLuong();
//                }
//            }
//            tb.addRow(new String[]{"", "", "", "", mcd.getKhoangTG(), String.valueOf(tongSoLuong)});
//            tb.addRow(new String[]{"", "", "", "", "", ""});
//            tongTatCa += tongSoLuong;
//        }
//
//        tb.addRow(new String[]{"", "", "", "", "T???ng t???t c???", String.valueOf(tongTatCa)});
//    }
    private void soLuongSanPhamNhap() {
        tb.clear();
//        tb.setHeaders(new String[]{"M?? s???n ph???m", "T??n s???n ph???m", "M?? phi???u nh???p", "T??n nh?? cung c???p", "Ng??y nh???p", "S??? l?????ng", "????n gi??", "T???ng ti???n"});
        tb.setHeaders(new String[]{"M?? s???n ph???m", "T??n s???n ph???m", "Ng??y nh???p", "S??? l?????ng", "????n gi??", "T???ng ti???n"});

        MyCheckDate mcd = new MyCheckDate(txKhoangNgayTu, txKhoangNgayDen);

        int tongTatCa = 0;
        float tongTien = 0;
        for (SanPham sp : qlspBUS.getDssp()) {
            int tongSoLuong = 0;
            float tongTienPhieuNhapCuaMoiSanPham = 0;
            tb.addRow(new String[]{sp.getMaSP(), sp.getTenSP(), "", "", String.valueOf(sp.getDonGia()), ""});

            for (PhieuNhap pn : qlpnBUS.search("T???t c???", "", mcd.getNgayTu(), mcd.getNgayDen(), -1, -1)) {
                ChiTietPhieuNhap ctpn = qlctpnBUS.getChiTiet(pn.getMaPN(), sp.getMaSP());

                if (ctpn != null) {
                    tb.addRow(new String[]{"", "",
//                        pn.getMaPN(),
//                        qlnccBUS.getNhaCungCap(pn.getMaNCC()).getTenNCC(),
                        String.valueOf(pn.getNgayNhap()),
                        String.valueOf(ctpn.getSoLuong()),
                        "",
                        String.valueOf(ctpn.getSoLuong() * ctpn.getDonGia())

                    });
                    tongSoLuong += ctpn.getSoLuong();
                    tongTienPhieuNhapCuaMoiSanPham += ctpn.getSoLuong() * ctpn.getDonGia();
                }
            }

//            tb.addRow(new String[]{"", "", "", "", mcd.getKhoangTG(), String.valueOf(tongSoLuong), "", String.valueOf(tongTienPhieuNhapCuaMoiSanPham)});
//            tb.addRow(new String[]{"", "", "", "", "", "", "", ""});

            tb.addRow(new String[]{"", "", mcd.getKhoangTG(), String.valueOf(tongSoLuong), "", String.valueOf(tongTienPhieuNhapCuaMoiSanPham)});
            tb.addRow(new String[]{"", "", "", "", "", ""});

            tongTatCa += tongSoLuong;
            tongTien += tongTienPhieuNhapCuaMoiSanPham;
        }
//        tb.addRow(new String[]{"", "", "", "", "T???ng t???t c???", String.valueOf(tongTatCa), "", String.valueOf(tongTien)});
        tb.addRow(new String[]{"", "", "T???ng t???t c???", String.valueOf(tongTatCa), "", String.valueOf(tongTien)});
    }

    private void soLuongSanPhamBan() {
        tb.clear();
        tb.setHeaders(new String[]{"M?? s???n ph???m", "T??n s???n ph???m", "M?? h??a don", "T??n nh??n vi??n", "Ng??y l???p", "S??? l?????ng", "????n gi??", "T???ng ti???n"});

        MyCheckDate mcd = new MyCheckDate(txKhoangNgayTu, txKhoangNgayDen);

        int tongTatCa = 0;
        float tongTien = 0;
        for (SanPham sp : qlspBUS.getDssp()) {
            int tongSoLuong = 0;
            float tongTienHoaDonTungSanPham = 0;
            tb.addRow(new String[]{sp.getMaSP(), sp.getTenSP(), "", "", "", "", String.valueOf(sp.getDonGia()), ""});

            for (HoaDon hd : qlhdBUS.search("T???t c???", "", mcd.getNgayTu(), mcd.getNgayTu(), -1, -1)) {
                ChiTietHoaDon cthd = qlcthdBUS.getChiTiet(hd.getMaHoaDon(), sp.getMaSP());
                if (cthd != null) {
                    tb.addRow(new String[]{"", "",
                        hd.getMaHoaDon(),
                        qlnvBUS.getNhanVien(hd.getMaNhanVien()).getTenNV(),
                        String.valueOf(hd.getNgayLap()),
                        String.valueOf(cthd.getSoLuong()), "", String.valueOf(cthd.getSoLuong() * cthd.getDonGia())
                    });
                    tongSoLuong += cthd.getSoLuong();
                    tongTienHoaDonTungSanPham += cthd.getSoLuong() * cthd.getDonGia();
                }
            }

            tb.addRow(new String[]{"", "", "", "", mcd.getKhoangTG(), String.valueOf(tongSoLuong), "", String.valueOf(tongTienHoaDonTungSanPham)});
            tb.addRow(new String[]{"", "", "", "", "", ""});
            tongTatCa += tongSoLuong;
            tongTien += tongTienHoaDonTungSanPham;
        }

        tb.addRow(new String[]{"", "", "", "", "T?ng t?t c?", String.valueOf(tongTatCa), "", String.valueOf(tongTien)});
    }

    private void addDocumentListener(JTextField txField) {
        txField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                cbSearchOnChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                cbSearchOnChange();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                cbSearchOnChange();
            }
        });
    }

    public void cbSearchOnChange() {
        if (cbTieuChi.getSelectedItem().equals("S??? l?????ng nh???p")) {
            soLuongSanPhamNhap();
        }
        if (cbTieuChi.getSelectedItem().equals("S??? l?????ng b??n")) {
            soLuongSanPhamBan();
        }
    }
}

class ThongKeNhanVien extends JPanel {

    QuanLyChiTietHoaDonBUS qlcthdBUS = new QuanLyChiTietHoaDonBUS();
    QuanLyHoaDonBUS qlhdBUS = new QuanLyHoaDonBUS();
    QuanLySanPhamBUS qlspBUS = new QuanLySanPhamBUS();
    QuanLyNhanVienBUS qlnvBUS = new QuanLyNhanVienBUS();

    JTextField txKhoangNgayTu = new JTextField(15);
    JTextField txKhoangNgayDen = new JTextField(15);
    DatePicker dPicker1;
    DatePicker dPicker2;

    JComboBox cbTieuChi;
    JButton btnRefresh = new JButton("L??m m???i");
    MyTable tb;

    public ThongKeNhanVien() {
        this.setLayout(new BorderLayout());

        DatePickerSettings pickerSettings = new DatePickerSettings();
        pickerSettings.setVisibleDateTextField(false);
        dPicker1 = new DatePicker(pickerSettings);
        dPicker1.addDateChangeListener((dce) -> {
            txKhoangNgayTu.setText(dPicker1.getDateStringOrEmptyString());
        });
        dPicker2 = new DatePicker(pickerSettings.copySettings());
        dPicker2.addDateChangeListener((dce) -> {
            txKhoangNgayDen.setText(dPicker2.getDateStringOrEmptyString());
        });

        DateButton db = new DateButton(dPicker1);
        DateButton db2 = new DateButton(dPicker2);

        //Panel tieu chi
        JPanel plTieuchi = new JPanel();
        plTieuchi.setLayout(new FlowLayout());

        cbTieuChi = new JComboBox(new String[]{"T???ng ti???n", "S??? l?????ng s???n ph???m"});
        cbTieuChi.addActionListener((ae) -> {
            cbSearchOnChange();
        });
        plTieuchi.add(cbTieuChi);

        JPanel plKhoangNgay1 = new JPanel();
        txKhoangNgayTu.setBorder(BorderFactory.createTitledBorder("T???:"));
        addDocumentListener(txKhoangNgayTu);
        plKhoangNgay1.add(txKhoangNgayTu);
        plKhoangNgay1.add(dPicker1);
        JPanel plKhoangNgay2 = new JPanel();
        txKhoangNgayDen.setBorder(BorderFactory.createTitledBorder("?????n"));
        addDocumentListener(txKhoangNgayDen);
        plKhoangNgay2.add(txKhoangNgayDen);
        plKhoangNgay2.add(dPicker2);

        btnRefresh.setIcon(new ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_data_backup_30px.png")));
        btnRefresh.addActionListener((ae) -> {
            qlspBUS.readDB();
            qlnvBUS.readDB();
            qlhdBUS.readDB();
            qlcthdBUS.readDB();
            txKhoangNgayTu.setText("");
            txKhoangNgayDen.setText("");
            dPicker1.setDate(null);
            dPicker2.setDate(null);
            cbSearchOnChange();
        });

        plTieuchi.add(plKhoangNgay1);
        plTieuchi.add(plKhoangNgay2);
        plTieuchi.add(btnRefresh);

        this.add(plTieuchi, BorderLayout.NORTH);

        //Table thong ke
        tb = new MyTable();
        cbSearchOnChange();
        this.add(tb, BorderLayout.CENTER);
    }

    public void tongTienTungNhanVien_searchOnChange() {
        tb.clear();
        tb.setHeaders(new String[]{"M?? nh??n vi??n", "T??n nh??n vi??n", "M?? h??a ????n", "Ng??y l???p", "T???ng ti???n h??a ????n"});

        MyCheckDate mcd = new MyCheckDate(txKhoangNgayTu, txKhoangNgayDen);

        //Tim hoa don cua tung nhan vien, sau do xuat tong tien cac hoa don len table
        float tongTatCa = 0;
        for (NhanVien nv : qlnvBUS.getDsnv()) {
            float tongTien = 0;
            tb.addRow(new String[]{nv.getMaNV(), nv.getTenNV(), "", ""});

            for (HoaDon hd : qlhdBUS.search("T???t c???", "", mcd.getNgayTu(), mcd.getNgayDen(), -1, -1)) {
                if (nv.getMaNV().equals(hd.getMaNhanVien())) {
                    tb.addRow(new String[]{"", "",
                        hd.getMaHoaDon(),
                        String.valueOf(hd.getNgayLap()),
                        PriceFormatter.format(hd.getTongTien())
                    });
                    tongTien += hd.getTongTien();
                }
            }
            tb.addRow(new String[]{"", "", "", mcd.getKhoangTG(), PriceFormatter.format(tongTien)});
            tb.addRow(new String[]{"", "", "", "", "", ""});

            tongTatCa += tongTien;
        }
        tb.addRow(new String[]{"", "", "", "T???ng t???t c???", PriceFormatter.format(tongTatCa)});
    }

    public void sanPhamCuaTungNhanVien_searchOnChange() {
        tb.setHeaders(new String[]{"M?? nh??n vi??n", "T??n nh??n vi??n", "M?? h??a ????n", "Ng??y l???p", "M?? s???n ph???m", "T??n s???n ph???m", "S??? l?????ng s???n ph???m"});
        tb.clear();

        MyCheckDate mcd = new MyCheckDate(txKhoangNgayTu, txKhoangNgayDen);

        //Tim hoa don cua tung nhan vien, sau do xuat tong tien cac hoa don len table
        int tongTatCa = 0;

        for (NhanVien nv : qlnvBUS.getDsnv()) {
            float tongSoLuong = 0;
            tb.addRow(new String[]{nv.getMaNV(), nv.getTenNV(), "", "", "", "", ""});

            for (HoaDon hd : qlhdBUS.search("M?? nh??n vi??n", nv.getMaNV(), mcd.getNgayTu(), mcd.getNgayDen(), -1, -1)) { // t????ng ?????i -> sai
                tb.addRow(new String[]{"", "", hd.getMaHoaDon(), String.valueOf(hd.getNgayLap()), "", "", ""});

                for (ChiTietHoaDon cthd : qlcthdBUS.search("M?? h??a ????n", hd.getMaHoaDon(), -1, -1, -1, -1)) { // t????ng ?????i -> sai
                    tongSoLuong += cthd.getSoLuong();
                    tb.addRow(new String[]{"", "", "", "",
                        cthd.getMaSanPham(),
                        qlspBUS.getSanPham(cthd.getMaSanPham()).getTenSP(),
                        String.valueOf(cthd.getSoLuong())
                    });
                }
            }
            tb.addRow(new String[]{"", "", "", mcd.getKhoangTG(), "", "T???ng s??? s???n ph???m", String.valueOf(tongSoLuong)});
            tb.addRow(new String[]{"", "", "", "", "", ""});

            tongTatCa += tongSoLuong;
        }
        tb.addRow(new String[]{"", "", "", "", "", "T???ng t???t c???", String.valueOf(tongTatCa)});
    }

    public void cbSearchOnChange() {
        if (cbTieuChi.getSelectedItem().equals("T???ng ti???n")) {
            tongTienTungNhanVien_searchOnChange();
        }
        if (cbTieuChi.getSelectedItem().equals("S??? l?????ng s???n ph???m")) {
            sanPhamCuaTungNhanVien_searchOnChange();
        }
    }

    private void addDocumentListener(JTextField txField) {
        txField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                cbSearchOnChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                cbSearchOnChange();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                cbSearchOnChange();
            }
        });
    }
}

class ThongKeKhachHang extends JPanel {

    QuanLyHoaDonBUS qlhdBUS = new QuanLyHoaDonBUS();
    QuanLyChiTietHoaDonBUS qlcthdBUS = new QuanLyChiTietHoaDonBUS();
    QuanLySanPhamBUS qlspBUS = new QuanLySanPhamBUS();
    QuanLyKhachHangBUS qlkhBUS = new QuanLyKhachHangBUS();

    JTextField txKhoangNgayTu = new JTextField(15);
    JTextField txKhoangNgayDen = new JTextField(15);
    DatePicker dPicker1;
    DatePicker dPicker2;

    JComboBox cbTieuChi;
    JButton btnRefresh = new JButton("L??m m???i");
    MyTable tb;

    public ThongKeKhachHang() {
        this.setLayout(new BorderLayout());

        DatePickerSettings pickerSettings = new DatePickerSettings();
        pickerSettings.setVisibleDateTextField(false);
        dPicker1 = new DatePicker(pickerSettings);
        dPicker1.addDateChangeListener((dce) -> {
            txKhoangNgayTu.setText(dPicker1.getDateStringOrEmptyString());
        });
        dPicker2 = new DatePicker(pickerSettings.copySettings());
        dPicker2.addDateChangeListener((dce) -> {
            txKhoangNgayDen.setText(dPicker2.getDateStringOrEmptyString());
        });

        DateButton db = new DateButton(dPicker1);
        DateButton db2 = new DateButton(dPicker2);

        //Panel tieu chi
        JPanel plTieuchi = new JPanel();
        plTieuchi.setLayout(new FlowLayout());

        cbTieuChi = new JComboBox(new String[]{"T???ng ti???n", "S??? l?????ng s???n ph???m"});
        cbTieuChi.addActionListener((ae) -> {
            cbSearchOnChange();
        });
        plTieuchi.add(cbTieuChi);

        JPanel plKhoangNgay1 = new JPanel();
        txKhoangNgayTu.setBorder(BorderFactory.createTitledBorder("T???:"));
        addDocumentListener(txKhoangNgayTu);
        plKhoangNgay1.add(txKhoangNgayTu);
        plKhoangNgay1.add(dPicker1);
        JPanel plKhoangNgay2 = new JPanel();
        txKhoangNgayDen.setBorder(BorderFactory.createTitledBorder("?????n"));
        addDocumentListener(txKhoangNgayDen);
        plKhoangNgay2.add(txKhoangNgayDen);
        plKhoangNgay2.add(dPicker2);

        btnRefresh.setIcon(new ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_data_backup_30px.png")));
        btnRefresh.addActionListener((ae) -> {
            qlspBUS.readDB();
            qlcthdBUS.readDB();
            qlhdBUS.readDB();
            qlkhBUS.readDB();
            txKhoangNgayTu.setText("");
            txKhoangNgayDen.setText("");
            dPicker1.setDate(null);
            dPicker2.setDate(null);
            cbSearchOnChange();
        });

        plTieuchi.add(plKhoangNgay1);
        plTieuchi.add(plKhoangNgay2);
        plTieuchi.add(btnRefresh);

        this.add(plTieuchi, BorderLayout.NORTH);

        //Table thong ke
        tb = new MyTable();
        cbSearchOnChange();
        this.add(tb, BorderLayout.CENTER);
    }

    //Thong ke tong tien hoa don cua tung khach hang
    public void tongTienTungKhachHang_searchOnChange() {
        tb.setHeaders(new String[]{"M?? kh??ch h??ng", "T??n kh??ch h??ng", "M?? h??a ????n", "Ng??y l???p", "T???ng ti???n h??a ????n"});
        tb.clear();

        MyCheckDate mcd = new MyCheckDate(txKhoangNgayTu, txKhoangNgayDen);

        //Tim hoa don cua tung nhan vien, sau do xuat tong tien cac hoa don len table
        float tongTatCa = 0;
        for (KhachHang kh : qlkhBUS.getDskh()) {
            float tongTien = 0;
            tb.addRow(new String[]{kh.getMaKH(), kh.getTenKH(), "", "", ""});

            for (HoaDon hd : qlhdBUS.search("T???t c???", "", mcd.getNgayTu(), mcd.getNgayDen(), -1, -1)) {
                if (kh.getMaKH().equals(hd.getMaKhachHang())) {
                    tb.addRow(new String[]{"", "",
                        hd.getMaHoaDon(),
                        String.valueOf(hd.getNgayLap()),
                        PriceFormatter.format(hd.getTongTien())
                    });
                    tongTien += hd.getTongTien();
                }
            }
            tb.addRow(new String[]{"", "", "", mcd.getKhoangTG(), PriceFormatter.format(tongTien)});
            tb.addRow(new String[]{"", "", "", "", "", ""});

            tongTatCa += tongTien;
        }

        tb.addRow(new String[]{"", "", "", "T???ng t???t c???", PriceFormatter.format(tongTatCa)});
    }

    //Thong ke san pham va so luong mua cua tung khach hang
    public void sanPhamCuaTungKhachHang_searchOnChange() {
        tb.clear();
        tb.setHeaders(new String[]{"M?? kh??ch h??ng", "T??n kh??ch h??ng", "M?? h??a ????n", "Ng??y l???p", "M?? s???n ph???m", "T??n s???n ph???m", "S??? l?????ng s???n ph???m"});

        MyCheckDate mcd = new MyCheckDate(txKhoangNgayTu, txKhoangNgayDen);

        //Tim hoa don cua tung nhan vien, sau do xuat tong tien cac hoa don len table
        int tongTatCa = 0;
        for (KhachHang kh : qlkhBUS.getDskh()) {
            int tongSoLuong = 0;
            tb.addRow(new String[]{kh.getMaKH(), kh.getTenKH(), "", "", "", "", ""});

            for (HoaDon hd : qlhdBUS.search("M?? kh??ch h??ng", kh.getMaKH(), mcd.getNgayTu(), mcd.getNgayDen(), -1, -1)) { // t????ng ?????i -> sai 
                tb.addRow(new String[]{"", "", hd.getMaHoaDon(), String.valueOf(hd.getNgayLap()), "", "", ""});

                for (ChiTietHoaDon cthd : qlcthdBUS.search("M?? h??a ????n", hd.getMaHoaDon(), -1, -1, -1, -1)) { // t????ng ?????i -> sai
                    tongSoLuong += cthd.getSoLuong();
                    tb.addRow(new String[]{"", "", "", "",
                        cthd.getMaSanPham(),
                        qlspBUS.getSanPham(cthd.getMaSanPham()).getTenSP(),
                        String.valueOf(cthd.getSoLuong())
                    });
                }
            }
            tb.addRow(new String[]{"", "", "", mcd.getKhoangTG(), "", "T???ng s??? s???n ph???m", String.valueOf(tongSoLuong)});
            tb.addRow(new String[]{"", "", "", "", "", ""});

            tongTatCa += tongSoLuong;
        }
        tb.addRow(new String[]{"", "", "", "", "", "T???ng t???t c???", String.valueOf(tongTatCa)});
    }

    public void cbSearchOnChange() {
        if (cbTieuChi.getSelectedItem().equals("T???ng ti???n")) {
            tongTienTungKhachHang_searchOnChange();
        }
        if (cbTieuChi.getSelectedItem().equals("S??? l?????ng s???n ph???m")) {
            sanPhamCuaTungKhachHang_searchOnChange();
        }
    }

    private void addDocumentListener(JTextField txField) {
        txField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                cbSearchOnChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                cbSearchOnChange();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                cbSearchOnChange();
            }
        });
    }
}

class ThongKeNhaCungCap extends JPanel {

    QuanLySanPhamBUS qlspBUS = new QuanLySanPhamBUS();
    QuanLyPhieuNhapBUS qlpnBUS = new QuanLyPhieuNhapBUS();
    QuanLyChiTietPhieuNhapBUS qlctpnBUS = new QuanLyChiTietPhieuNhapBUS();
    QuanLyNhaCungCapBUS qlnccBUS = new QuanLyNhaCungCapBUS();

    JTextField txKhoangNgayTu = new JTextField(15);
    JTextField txKhoangNgayDen = new JTextField(15);
    DatePicker dPicker1;
    DatePicker dPicker2;

    JComboBox cbTieuChi;
    MyTable tb;
    JButton btnRefresh = new JButton("L??m m???i");

    public ThongKeNhaCungCap() {
        this.setLayout(new BorderLayout());

        DatePickerSettings pickerSettings = new DatePickerSettings();
        pickerSettings.setVisibleDateTextField(false);
        dPicker1 = new DatePicker(pickerSettings);
        dPicker1.addDateChangeListener((dce) -> {
            txKhoangNgayTu.setText(dPicker1.getDateStringOrEmptyString());
        });
        dPicker2 = new DatePicker(pickerSettings.copySettings());
        dPicker2.addDateChangeListener((dce) -> {
            txKhoangNgayDen.setText(dPicker2.getDateStringOrEmptyString());
        });

        DateButton db = new DateButton(dPicker1);
        DateButton db2 = new DateButton(dPicker2);

        //Panel tieu chi
        JPanel plTieuchi = new JPanel();
        plTieuchi.setLayout(new FlowLayout());

        cbTieuChi = new JComboBox(new String[]{"S??? l?????ng s???n ph???m", "T???ng th??nh ti???n"});
        cbTieuChi.addActionListener((ae) -> {
            cbSearchOnChange();
        });
        plTieuchi.add(cbTieuChi);

        JPanel plKhoangNgay1 = new JPanel();
        txKhoangNgayTu.setBorder(BorderFactory.createTitledBorder("T???:"));
        addDocumentListener(txKhoangNgayTu);
        plKhoangNgay1.add(txKhoangNgayTu);
        plKhoangNgay1.add(dPicker1);
        JPanel plKhoangNgay2 = new JPanel();
        txKhoangNgayDen.setBorder(BorderFactory.createTitledBorder("?????n"));
        addDocumentListener(txKhoangNgayDen);
        plKhoangNgay2.add(txKhoangNgayDen);
        plKhoangNgay2.add(dPicker2);

        btnRefresh.setIcon(new ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_data_backup_30px.png")));
        btnRefresh.addActionListener((ae) -> {
            qlspBUS.readDB();
            qlpnBUS.readDB();
            qlctpnBUS.readDB();
            qlnccBUS.readDB();
            txKhoangNgayTu.setText("");
            txKhoangNgayDen.setText("");
            dPicker1.setDate(null);
            dPicker2.setDate(null);
            cbSearchOnChange();
        });

        plTieuchi.add(plKhoangNgay1);
        plTieuchi.add(plKhoangNgay2);
        plTieuchi.add(btnRefresh);
        this.add(plTieuchi, BorderLayout.NORTH);

        //Table thong ke
        tb = new MyTable();
        cbSearchOnChange();
        this.add(tb, BorderLayout.CENTER);
    }

    private void soLuongSanPhamCungCap() {
        tb.clear();
        tb.setHeaders(new String[]{"M?? nh?? cung c???p", "T??n nh?? cung c???p", "M?? phi???u nh???p", "Ng??y l???p", "M?? s???n ph???m", "T??n s???n ph???m", "S??? l?????ng"});

        MyCheckDate mcd = new MyCheckDate(txKhoangNgayTu, txKhoangNgayDen);

        int tongTatCa = 0;

        for (NhaCungCap ncc : qlnccBUS.getDsncc()) {
            int tongSoLuong = 0;
            tb.addRow(new String[]{ncc.getMaNCC(), ncc.getTenNCC(), "", "", "", "", ""});

            for (PhieuNhap pn : qlpnBUS.search("T???t c???", "", mcd.getNgayTu(), mcd.getNgayDen(), -1, -1)) {
                if (pn.getMaNCC().equals(ncc.getMaNCC())) {
                    tb.addRow(new String[]{"", "", pn.getMaPN(), String.valueOf(pn.getNgayNhap()), "", "", ""});

                    for (ChiTietPhieuNhap ctpn : qlctpnBUS.search("M?? phi???u nh???p", pn.getMaPN())) {
                        tongSoLuong += ctpn.getSoLuong();
                        tb.addRow(new String[]{"", "", "", "",
                            ctpn.getMaSP(),
                            qlspBUS.getSanPham(ctpn.getMaSP()).getTenSP(),
                            String.valueOf(ctpn.getSoLuong())
                        });
                    }
                }
            }
            tb.addRow(new String[]{"", "", "", mcd.getKhoangTG(), "", "T???ng s??? l?????ng:", String.valueOf(tongSoLuong)});
            tb.addRow(new String[]{"", "", "", "", "", "", ""});

            tongTatCa += tongSoLuong;
        }
        tb.addRow(new String[]{"", "", "", "", "", "T???ng t???t c???:", String.valueOf(tongTatCa)});
    }

    private void tongTienThanhToan() {
        tb.clear();
        tb.setHeaders(new String[]{"M?? nh?? cung c???p", "T??n nh?? cung c???p", "M?? phi???u nh???p", "Ng??y l???p", "M?? s???n ph???m", "????n gi??", "S??? l?????ng", "Th??nh ti???n"});

        MyCheckDate mcd = new MyCheckDate(txKhoangNgayTu, txKhoangNgayDen);

        float tongTatCa = 0;
        for (NhaCungCap ncc : qlnccBUS.getDsncc()) {
            float tongTien = 0;
            tb.addRow(new String[]{ncc.getMaNCC(), ncc.getTenNCC(), "", "", "", "", "", ""});

            for (PhieuNhap pn : qlpnBUS.search("T???t c???", "", mcd.getNgayTu(), mcd.getNgayDen(), -1, -1)) {
                if (pn.getMaNCC().equals(ncc.getMaNCC())) {
                    tb.addRow(new String[]{"", "", pn.getMaPN(), String.valueOf(pn.getNgayNhap()), "", "", "", ""});

                    for (ChiTietPhieuNhap ctpn : qlctpnBUS.search("M?? phi???u nh???p", pn.getMaPN())) {
                        tongTien += ctpn.getSoLuong() * ctpn.getDonGia();
                        tb.addRow(new String[]{"", "", "", "",
                            ctpn.getMaSP(),
                            String.valueOf(ctpn.getDonGia()),
                            String.valueOf(ctpn.getSoLuong()),
                            PriceFormatter.format(ctpn.getSoLuong() * ctpn.getDonGia())});
                    }
                }
            }
            tb.addRow(new String[]{"", "", "", mcd.getKhoangTG(), "", "", "T???ng th??nh ti???n:", PriceFormatter.format(tongTien)});
            tb.addRow(new String[]{"", "", "", "", "", "", "", ""});

            tongTatCa += tongTien;
        }
        tb.addRow(new String[]{"", "", "", "", "", "", "T???ng t???t c???:", PriceFormatter.format(tongTatCa)});
    }

    private void addDocumentListener(JTextField txField) {
        txField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                cbSearchOnChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                cbSearchOnChange();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                cbSearchOnChange();
            }
        });
    }

    public void cbSearchOnChange() {
        if (cbTieuChi.getSelectedItem().equals("S??? l?????ng s???n ph???m")) {
            soLuongSanPhamCungCap();
        }
        if (cbTieuChi.getSelectedItem().equals("T???ng th??nh ti???n")) {
            tongTienThanhToan();
        }
    }
}
