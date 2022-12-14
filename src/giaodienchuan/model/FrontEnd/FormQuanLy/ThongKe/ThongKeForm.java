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
import giaodienchuan.model.FrontEnd.FormChon.ChonKhachHangForm;
import giaodienchuan.model.FrontEnd.FormChon.ChonNhaCungCapForm;
import giaodienchuan.model.FrontEnd.FormChon.ChonNhanVienForm;
import giaodienchuan.model.FrontEnd.FormChon.ChonSanPhamForm;
import giaodienchuan.model.FrontEnd.GiaoDienChuan.MyTable;
import giaodienchuan.model.FrontEnd.MyButton.DateButton;
import giaodienchuan.model.FrontEnd.MyButton.MoreButton;
import giaodienchuan.model.FrontEnd.MyButton.RefreshButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ThongKeForm extends JPanel {

    public static final int width = 1120, height = 740;

    public ThongKeForm() {
        this.setBackground(Color.darkGray);

        ThongKe_Hoang tkH = new ThongKe_Hoang();
        ThongKeForm_NewVersion tk2 = new ThongKeForm_NewVersion();

        JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);
        tabs.setPreferredSize(new Dimension(width, height));

        //add tab thong ke san pham
//        tabs.addTab("Th???ng k?? ver2", getIcon("icons8_company_30px.png"), tk2);
        tabs.addTab("Th???ng k?? t???ng qu??t", getIcon("icons8_pie_chart_30px.png"), tkH);
        tabs.addTab("S???n ph???m", getIcon("icons8_multiple_smartphones_30px.png"), null);
        tabs.addTab("Nh??n vi??n", getIcon("icons8_assistant_30px.png"), null);
        tabs.addTab("Kh??ch h??ng", getIcon("icons8_user_30px.png"), null);

        tabs.addChangeListener((ce) -> {
            int i = tabs.getSelectedIndex();
            if (tabs.getComponentAt(i) == null) {
                switch (tabs.getTitleAt(i)) {
                    case "S???n ph???m":
                        tabs.setComponentAt(i, new ThongKeSanPham());
                        break;
                    case "Nh??n vi??n":
                        tabs.setComponentAt(i, new ThongKeNhanVien());
                        break;
                    case "Kh??ch h??ng":
                        tabs.setComponentAt(i, new ThongKeKhachHang());
                        break;
                }
            }
        });

        this.add(tabs);
    }

    private ImageIcon getIcon(String filename) {
        return new ImageIcon(getClass().getResource("/giaodienchuan/images/" + filename));
    }
}

class ThongKe_Hoang extends JPanel {

    QuanLyHoaDonBUS qlhdBUS = new QuanLyHoaDonBUS();
    QuanLySanPhamBUS qlspBUS = new QuanLySanPhamBUS();
    QuanLyNhanVienBUS qlnvBUS = new QuanLyNhanVienBUS();
    QuanLyKhachHangBUS qlkhBUS = new QuanLyKhachHangBUS();
    QuanLyPhieuNhapBUS qlpnBUS = new QuanLyPhieuNhapBUS();
    QuanLyNhaCungCapBUS qlnccBUS = new QuanLyNhaCungCapBUS();
    QuanLyChiTietHoaDonBUS qlcthdBUS = new QuanLyChiTietHoaDonBUS();
    QuanLyChiTietPhieuNhapBUS qlctpnBUS = new QuanLyChiTietPhieuNhapBUS();

    JTextField txNgay1 = new JTextField(7);
    JTextField txNgay2 = new JTextField(7);
    JTextField txNhanVien = new JTextField(10);
    JTextField txKhachHang = new JTextField(10);
    JTextField txNhaCC = new JTextField(10);
    JTextField txSanPham = new JTextField(10);

    DatePicker dPicker1;
    DatePicker dPicker2;
    MoreButton btnChonNhanVien = new MoreButton();
    MoreButton btnChonKhachHang = new MoreButton();
//    MoreButton btnChonNhaCC = new MoreButton();
    MoreButton btnChonSanPham = new MoreButton();

    JTabbedPane tabDoiTuongThongKe = new JTabbedPane();
    JPanel plThongKeHoaDon = new JPanel();
    JPanel plThongKePhieuNhap = new JPanel();
    JPanel plThongKeSoLuong = new JPanel();

    MyTable tbThongKeHoaDon = new MyTable();
    MyTable tbThongKePhieuNhap = new MyTable();

    MyTable tbKetQuaHoaDon = new MyTable();
    MyTable tbKetQuaPhieuNhap = new MyTable();

    JPanel plSanPham, plNhanVien, plKhachHang, plNhaCC;
    RefreshButton btnRefresh = new RefreshButton();

    public ThongKe_Hoang() {
        setLayout(new BorderLayout());

        // panel chon ngay
        DatePickerSettings ds = new DatePickerSettings();
        ds.setVisibleDateTextField(false);
        dPicker1 = new DatePicker(ds);
        dPicker2 = new DatePicker(ds.copySettings());
        dPicker1.addDateChangeListener((dce) -> {
            txNgay1.setText(dPicker1.getDateStringOrEmptyString());
        });
        dPicker2.addDateChangeListener((dce) -> {
            txNgay2.setText(dPicker2.getDateStringOrEmptyString());
        });
        DateButton db = new DateButton(dPicker1);
        DateButton db2 = new DateButton(dPicker2);
        
        txNgay1.setBorder(BorderFactory.createTitledBorder("T???"));
        txNgay2.setBorder(BorderFactory.createTitledBorder("?????n"));

        JPanel plChonNgay = new JPanel();
        plChonNgay.setBorder(BorderFactory.createTitledBorder("Kho???ng ng??y"));

        addDocumentListener(txNgay1);
        addDocumentListener(txNgay2);
        plChonNgay.add(txNgay1);
        plChonNgay.add(dPicker1);
        plChonNgay.add(txNgay2);
        plChonNgay.add(dPicker2);
        
        // event
        btnChonSanPham.addActionListener((ae) -> {
            ChonSanPhamForm cnv = new ChonSanPhamForm(txSanPham, null, null, null, null);
        });
        btnChonNhanVien.addActionListener((ae) -> {
            ChonNhanVienForm cnv = new ChonNhanVienForm(txNhanVien);
        });
        btnChonKhachHang.addActionListener((ae) -> {
            ChonKhachHangForm ckh = new ChonKhachHangForm(txKhachHang);
        });
//        btnChonNhaCC.addActionListener((ae) -> {
//            ChonNhaCungCapForm cnv = new ChonNhaCungCapForm(txNhaCC);
//        });
        btnRefresh.addActionListener((ae) -> {
            refresh();
        });

        plSanPham = getPanelTieuChi("S???n ph???m", txSanPham, btnChonSanPham);
        plNhanVien = getPanelTieuChi("Nh??n vi??n", txNhanVien, btnChonNhanVien);
        plKhachHang = getPanelTieuChi("Kh??ch h??ng", txKhachHang, btnChonKhachHang);
//        plNhaCC = getPanelTieuChi("Nh?? cung c???p", txNhaCC, btnChonNhaCC);

        // panel chon tieu chi
        JPanel plChonTieuChi = new JPanel();
        plChonTieuChi.add(plChonNgay);
        plChonTieuChi.add(plSanPham);
        plChonTieuChi.add(plNhanVien);
        plChonTieuChi.add(plKhachHang);
//        plChonTieuChi.add(plNhaCC);
        plChonTieuChi.add(btnRefresh);
        this.add(plChonTieuChi, BorderLayout.NORTH);

        // panel thong ke hoa don (ban duoc)
        plThongKeHoaDon.setLayout(new BorderLayout());
        tbThongKeHoaDon.setHeaders(new String[]{"H??a ????n", "T??n nh??n vi??n", "T??n kh??ch h??ng", "T??n s???n ph???m", "S??? l?????ng", "????n gi??", "Th??nh ti???n"});
        tbThongKeHoaDon.setAlignment(0, JLabel.CENTER);
        tbThongKeHoaDon.setAlignment(4, JLabel.CENTER);
        tbThongKeHoaDon.setAlignment(5, JLabel.RIGHT);
        tbThongKeHoaDon.setAlignment(6, JLabel.RIGHT);
        plThongKeHoaDon.add(tbThongKeHoaDon, BorderLayout.CENTER);

        tbKetQuaHoaDon.setHeaders(new String[]{"T???NG T???T C???", "", "", "", "", "", "T???NG B??N RA"});
        tbKetQuaHoaDon.setPreferredSize(new Dimension(ThongKeForm.width, 75));
        tbKetQuaHoaDon.setAlignment(0, JLabel.CENTER);
        tbKetQuaHoaDon.setAlignment(4, JLabel.CENTER);
        tbKetQuaHoaDon.setAlignment(5, JLabel.RIGHT);
        tbKetQuaHoaDon.setAlignment(6, JLabel.RIGHT);
        plThongKeHoaDon.add(tbKetQuaHoaDon, BorderLayout.SOUTH);

        // panal thong ke phieu nhap (nhap kho)
        plThongKePhieuNhap.setLayout(new BorderLayout());
        tbThongKePhieuNhap.setHeaders(new String[]{"Phi???u nh???p", "T??n nh??n vi??n", "T??n nh?? cung c???p", "T??n s???n ph???m", "S??? l?????ng", "????n gi??", "Th??nh ti???n"});
        tbThongKePhieuNhap.setAlignment(0, JLabel.CENTER);
        tbThongKePhieuNhap.setAlignment(4, JLabel.CENTER);
        tbThongKePhieuNhap.setAlignment(5, JLabel.RIGHT);
        tbThongKePhieuNhap.setAlignment(6, JLabel.RIGHT);
        plThongKePhieuNhap.add(tbThongKePhieuNhap, BorderLayout.CENTER);

        tbKetQuaPhieuNhap.setHeaders(new String[]{"T???NG T???T C???", "", "", "", "", "", "T???NG NH???P V??O"});
        tbKetQuaPhieuNhap.setPreferredSize(new Dimension(ThongKeForm.width, 75));
        tbKetQuaPhieuNhap.setAlignment(0, JLabel.CENTER);
        tbKetQuaPhieuNhap.setAlignment(4, JLabel.CENTER);
        tbKetQuaPhieuNhap.setAlignment(5, JLabel.RIGHT);
        tbKetQuaPhieuNhap.setAlignment(6, JLabel.RIGHT);
        plThongKePhieuNhap.add(tbKetQuaPhieuNhap, BorderLayout.SOUTH);
        
        // panel thong ke tong so
        plThongKeSoLuong = new JPanel();
        setDataToPanelTong();

        // tabpane doi tuong thong ke
        tabDoiTuongThongKe.setBackground(Color.yellow);
        tabDoiTuongThongKe.addTab("T???ng", getIcon("icons8_futures_30px.png"), plThongKeSoLuong);
        tabDoiTuongThongKe.addTab("B??n ra", getIcon("icons8_small_business_30px_3.png"), plThongKeHoaDon);
//        tabDoiTuongThongKe.addTab("Nh???p v??o", getIcon("icons8_downloads_30px.png"), plThongKePhieuNhap);

        // event chuyen tab
        // tab ban dau la hoa don, nen c???n ???n nha cung cap 
//        plNhaCC.setVisible(false);
        // event
        tabDoiTuongThongKe.addChangeListener((ce) -> {
            Boolean HoaDon_isSelected = (tabDoiTuongThongKe.getSelectedComponent() == plThongKeHoaDon);
//            plNhaCC.setVisible(!HoaDon_isSelected);
            plKhachHang.setVisible(HoaDon_isSelected);
        });

        this.add(tabDoiTuongThongKe, BorderLayout.CENTER);

        // show gi?? tr??? ?????u
        onChangeThongKeBanHang();
        onChangeThongKeNhapHang();
    }
    
    private void setDataToPanelTong() {
        plThongKeSoLuong.removeAll();
        plThongKeSoLuong.add(getJPanelTong("S???N PH???M", "icons8_google_mobile_100px.png", qlspBUS.getDssp().size(), Color.BLUE));
        plThongKeSoLuong.add(getJPanelTong("NH??N VI??N", "icons8_assistant_100px.png", qlnvBUS.getDsnv().size(), Color.BLUE));
        plThongKeSoLuong.add(getJPanelTong("KH??CH H??NG", "icons8_person_male_100px.png", qlkhBUS.getDskh().size(), Color.BLUE));
//        plThongKeSoLuong.add(getJPanelTong("NH?? CUNG C???P", "icons8_company_100px.png", qlnccBUS.getDsncc().size(), Color.BLUE));
    }

    public void refresh() {
        qlcthdBUS.readDB();
        qlhdBUS.readDB();
        qlkhBUS.readDB();
        qlnccBUS.readDB();
        qlnvBUS.readDB();
        qlspBUS.readDB();
        dPicker1.setDate(null);
        dPicker2.setDate(null);
        txSanPham.setText("");
        txNhanVien.setText("");
        txKhachHang.setText("");
//        txNhaCC.setText("");

        Boolean HoaDon_isSelected = (tabDoiTuongThongKe.getSelectedComponent() == plThongKeHoaDon);
        if (HoaDon_isSelected) {
            onChangeThongKeBanHang();
        } else {
            onChangeThongKeNhapHang();
        }
        setDataToPanelTong();
    }

    private JPanel getPanelTieuChi(String name, JTextField tx, MoreButton b) {
        JPanel result = new JPanel();
        result.setBorder(BorderFactory.createTitledBorder(name));
        tx.setBorder(BorderFactory.createTitledBorder(" "));

        addDocumentListener(tx);

        result.add(tx);
        result.add(b);

        return result;
    }

    private void addDocumentListener(JTextField txField) {
        txField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                Boolean HoaDon_isSelected = (tabDoiTuongThongKe.getSelectedComponent() == plThongKeHoaDon);
                if (HoaDon_isSelected) {
                    onChangeThongKeBanHang();
                } else {
                    onChangeThongKeNhapHang();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }
        });
    }

    private ImageIcon getIcon(String filename) {
        return new ImageIcon(getClass().getResource("/giaodienchuan/images/" + filename));
    }

    private void onChangeThongKeBanHang() {
        tbThongKeHoaDon.clear();

        int tongSLHoaDon = 0;
        int tongSLSanPham = 0;
        float tongTatCaTien = 0;

        String maspLoc = txSanPham.getText();
        String manvLoc = txNhanVien.getText();
        String makhLoc = txKhachHang.getText();

        ArrayList<NhanVien> dsnv = new ArrayList<>(); // danh s??ch l??u c??c nh??n vi??n c?? l??m h??a ????n
        ArrayList<KhachHang> dskh = new ArrayList<>(); // danh s??ch l??u c??c kh??ch h??ng c?? l??m h??a ????n
        ArrayList<SanPham> dssp = new ArrayList<>(); // l??u c??c s???n ph???m

        MyCheckDate mcd = new MyCheckDate(txNgay1, txNgay2);

        for (HoaDon hd : qlhdBUS.search("T???t c???", "", mcd.getNgayTu(), mcd.getNgayDen(), -1, -1)) {
            float tongTien = 0;
            ArrayList<ChiTietHoaDon> dscthd = qlcthdBUS.getAllChiTiet(hd.getMaHoaDon());

            if (dscthd.size() > 0) {
                NhanVien nv = qlnvBUS.getNhanVien(hd.getMaNhanVien());
                KhachHang kh = qlkhBUS.getKhachHang(hd.getMaKhachHang());

                // l???c theo textfield m??
                // b??? qua l???n l???p for n??y n???u nh??n vi??n ho???c kh??ch h??ng ko th???a b??? l???c
                if (!manvLoc.equals("") && !nv.getMaNV().equals(manvLoc)
                        || !makhLoc.equals("") && !kh.getMaKH().equals(makhLoc)) {
                    continue; // continue n??y s??? l???y v??ng l???p HoaDon ti???p theo
                }

                // th??m v??o arraylist ????? ?????m
                if (!dsnv.contains(nv)) {
                    dsnv.add(nv); // th??m v??o n???u ch??a c??
                }
                if (!dskh.contains(kh)) {
                    dskh.add(kh); // th??m v??o n???u ch??a c??
                }

                tbThongKeHoaDon.addRow(new String[]{
                    hd.getMaHoaDon() + " (" + hd.getNgayLap().toString() + ")",
                    nv.getTenNV() + " (" + nv.getMaNV() + ")",
                    kh.getTenKH() + " (" + kh.getMaKH() + ")",
                    "", "", "", ""
                });

                for (ChiTietHoaDon cthd : dscthd) {
                    SanPham sp = qlspBUS.getSanPham(cthd.getMaSanPham());

                    // l???c
                    if (!maspLoc.equals("") && !sp.getMaSP().equals(maspLoc)) {
                        continue; // continue n??y s??? l???y v??ng l???p ChiTietHoaDon ti???p theo
                    }

                    // th??m v??o danh s??ch ????? ?????m
                    if (!dssp.contains(sp)) {
                        dssp.add(sp); // th??m v??o n???u ch??a c??
                    }

                    tbThongKeHoaDon.addRow(new String[]{"", "", "",
                        sp.getTenSP() + " (" + sp.getMaSP() + ")",
                        String.valueOf(cthd.getSoLuong()),
                        PriceFormatter.format(cthd.getDonGia()),
                        PriceFormatter.format(cthd.getSoLuong() * cthd.getDonGia())
                    });

                    tongTien += cthd.getDonGia() * cthd.getSoLuong();
                    tongSLSanPham += cthd.getSoLuong();
                }
            }
            tbThongKeHoaDon.addRow(new String[]{"", "", "", "", "", "T???ng c???ng", PriceFormatter.format(tongTien)});
            tbThongKeHoaDon.addRow(new String[]{"", "", "", "", "", "", ""});

            tongTatCaTien += tongTien;
            tongSLHoaDon++;
        }

        tbKetQuaHoaDon.clear();
        tbKetQuaHoaDon.addRow(new String[]{
            tongSLHoaDon + " h??a ????n",
            dsnv.size() + " nh??n vi??n",
            dskh.size() + " kh??ch h??ng",
            dssp.size() + " m???t h??ng",
            tongSLSanPham + " s???n ph???m",
            "",
            PriceFormatter.format(tongTatCaTien)
        });
    }

    private void onChangeThongKeNhapHang() {
        tbThongKePhieuNhap.clear();

        int tongSLPhieuNhap = 0;
        int tongSLSanPham = 0;
        float tongTatCaTien = 0;

        String maspLoc = txSanPham.getText();
        String manvLoc = txNhanVien.getText();
//        String manccLoc = txNhaCC.getText();

        ArrayList<NhanVien> dsnv = new ArrayList<>(); // danh s??ch l??u c??c nh??n vi??n c?? l??m phi???u nh???p
        ArrayList<NhaCungCap> dsncc = new ArrayList<>(); // danh s??ch l??u c??c ncc c?? l??m phi???u nh???p
        ArrayList<SanPham> dssp = new ArrayList<>(); // l??u c??c s???n ph???m

        MyCheckDate mcd = new MyCheckDate(txNgay1, txNgay2);

        for (PhieuNhap pn : qlpnBUS.search("T???t c???", "", mcd.getNgayTu(), mcd.getNgayDen(), -1, -1)) {
            float tongTien = 0;
            ArrayList<ChiTietPhieuNhap> dsctpn = qlctpnBUS.getAllChiTiet(pn.getMaPN());

            if (dsctpn.size() > 0) {
                NhanVien nv = qlnvBUS.getNhanVien(pn.getMaNV());
                NhaCungCap ncc = qlnccBUS.getNhaCungCap(pn.getMaNCC());

                // l???c theo textfield m??
                // b??? qua l???n l???p for n??y n???u nh??n vi??n ho???c nha cung cap ko th???a b??? l???c
                if (!manvLoc.equals("") && !nv.getMaNV().equals(manvLoc)
//                        || !manccLoc.equals("") && !ncc.getMaNCC().equals(manccLoc)
                ) {
                    continue; // continue n??y s??? l???y v??ng l???p PhieuNhap ti???p theo
                }

                // th??m v??o arraylist ????? ?????m
                if (!dsnv.contains(nv)) {
                    dsnv.add(nv); // th??m v??o n???u ch??a c??
                }
                if (!dsncc.contains(ncc)) {
                    dsncc.add(ncc); // th??m v??o n???u ch??a c??
                }

                tbThongKePhieuNhap.addRow(new String[]{
                    pn.getMaPN() + " (" + pn.getNgayNhap().toString() + ")",
                    nv.getTenNV() + " (" + nv.getMaNV() + ")",
                    ncc.getTenNCC() + " (" + ncc.getMaNCC() + ")",
                    "", "", "", ""
                });

                for (ChiTietPhieuNhap ctpn : dsctpn) {
                    SanPham sp = qlspBUS.getSanPham(ctpn.getMaSP());

                    // l???c
                    if (!maspLoc.equals("") && !sp.getMaSP().equals(maspLoc)) {
                        continue; // continue n??y s??? l???y v??ng l???p ChiTietPhieuNhap ti???p theo
                    }

                    // th??m v??o danh s??ch ????? ?????m
                    if (!dssp.contains(sp)) {
                        dssp.add(sp); // th??m v??o n???u ch??a c??
                    }

                    tbThongKePhieuNhap.addRow(new String[]{"", "", "",
                        sp.getTenSP() + " (" + sp.getMaSP() + ")",
                        String.valueOf(ctpn.getSoLuong()),
                        PriceFormatter.format(ctpn.getDonGia()),
                        PriceFormatter.format(ctpn.getSoLuong() * ctpn.getDonGia())
                    });

                    tongTien += ctpn.getDonGia() * ctpn.getSoLuong();
                    tongSLSanPham += ctpn.getSoLuong();
                }
            }
            tbThongKePhieuNhap.addRow(new String[]{"", "", "", "", "", "T???ng c???ng", PriceFormatter.format(tongTien)});
            tbThongKePhieuNhap.addRow(new String[]{"", "", "", "", "", "", ""});

            tongTatCaTien += tongTien;
            tongSLPhieuNhap++;
        }

        tbKetQuaPhieuNhap.clear();
        tbKetQuaPhieuNhap.addRow(new String[]{
            tongSLPhieuNhap + " phi???u nh???p",
            dsnv.size() + " nh??n vi??n",
            dsncc.size() + " nh?? cung c???p",
            dssp.size() + " m???t h??ng",
            tongSLSanPham + " s???n ph???m",
            "",
            PriceFormatter.format(tongTatCaTien)
        });
    }
    
    private JPanel getJPanelTong(String name, String iconName, int soluong, Color c) {
        JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        result.setPreferredSize(new Dimension(ThongKeForm.width / 4 - 15, 200));
        result.setBorder(BorderFactory.createLineBorder(c));
        
        // hinh anh
        JLabel lbIcon = new JLabel();
        lbIcon.setIcon(getIcon(iconName));
        result.add(lbIcon, BorderLayout.WEST);
        
        // tieu de
        JPanel plLeft = new JPanel();
        
        JLabel lbTieuDe = new JLabel(name, JLabel.CENTER);
        lbTieuDe.setPreferredSize(new Dimension(ThongKeForm.width / 4 - 100, 70));
        lbTieuDe.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        plLeft.add(lbTieuDe);
        
        JLabel lbSoLuong = new JLabel(String.valueOf(soluong), JLabel.CENTER);
        lbSoLuong.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
        lbSoLuong.setForeground(c);
        plLeft.add(lbSoLuong);
        
        result.add(plLeft, BorderLayout.CENTER);
        
        return result;
    }
}

class MyCheckDate {

    LocalDate fromDate = null;
    LocalDate toDate = null;
    String khoangTG = "";

    public MyCheckDate(JTextField txFrom, JTextField txTo) {
        try {
            fromDate = LocalDate.parse(txFrom.getText());
            txFrom.setForeground(Color.black);
            khoangTG += String.valueOf(fromDate);

        } catch (DateTimeParseException e) {
            txFrom.setForeground(Color.red);
            khoangTG += "T??? ng??y ?????u";
        }
        try {
            toDate = LocalDate.parse(txTo.getText());
            txTo.setForeground(Color.black);
            khoangTG += " ?????n " + String.valueOf(toDate);

        } catch (DateTimeParseException e) {
            txTo.setForeground(Color.red);
            khoangTG += " ?????n nay";
        }
    }

    public LocalDate getNgayTu() {
        return fromDate;
    }

    public LocalDate getNgayDen() {
        return toDate;
    }

    public String getKhoangTG() {
        return khoangTG;
    }
}
