package giaodienchuan.model.FrontEnd.FormQuanLy;

import giaodienchuan.model.BackEnd.QuanLyKhachHang.QuanLyKhachHangBUS;
import giaodienchuan.model.BackEnd.WorkWithExcel.DocExcel;
import giaodienchuan.model.BackEnd.WorkWithExcel.XuatExcel;
import giaodienchuan.model.FrontEnd.FormHienThi.HienThiKhachHang;
import giaodienchuan.model.FrontEnd.FormThemSua.ThemSuaKhachHangForm;
import giaodienchuan.model.FrontEnd.GiaoDienChuan.LoginForm;
import giaodienchuan.model.FrontEnd.MyButton.ExportExcelButton;
import giaodienchuan.model.FrontEnd.MyButton.ImportExcelButton;
import giaodienchuan.model.FrontEnd.MyButton.SuaButton;
import giaodienchuan.model.FrontEnd.MyButton.ThemButton;
import giaodienchuan.model.FrontEnd.MyButton.XoaButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class QuanLyKhachHangForm extends JPanel {

    HienThiKhachHang formHienThi = new HienThiKhachHang();

    ThemButton btnThem = new ThemButton();
    SuaButton btnSua = new SuaButton();
    XoaButton btnXoa = new XoaButton();
    
    ExportExcelButton btnXuatExcel = new ExportExcelButton();
    ImportExcelButton btnNhapExcel = new ImportExcelButton();

    public QuanLyKhachHangForm() {
        setLayout(new BorderLayout());

        // buttons
        if (!LoginForm.quyenLogin.getChiTietQuyen().contains("qlKhachHang")) {
            btnThem.setEnabled(false);
            btnXoa.setEnabled(false);
            btnSua.setEnabled(false);
            btnNhapExcel.setEnabled(false);
        }

        JPanel plBtn = new JPanel();
        plBtn.add(btnThem);
        plBtn.add(btnXoa);
        plBtn.add(btnSua);
//        plBtn.add(btnXuatExcel);
//        plBtn.add(btnNhapExcel);

        this.add(plBtn, BorderLayout.NORTH);
        this.add(formHienThi, BorderLayout.CENTER);

        // actionlistener
        btnThem.addActionListener((ActionEvent ae) -> {
            btnThemMouseClicked();
        });
        btnXoa.addActionListener((ActionEvent ae) -> {
            btnXoaMouseClicked();
        });
        btnSua.addActionListener((ActionEvent ae) -> {
            btnSuaMouseClicked();
        });
        btnXuatExcel.addActionListener((ActionEvent ae) -> {
            new XuatExcel().xuatFileExcelKhachHang();
        });
        btnNhapExcel.addActionListener((ActionEvent ae) -> {
            new DocExcel().docFileExcelKhachhang();
        });
    }

    private void btnSuaMouseClicked() {
        String makh = formHienThi.getSelectedRow(1);
        if (makh != null) {
            ThemSuaKhachHangForm suakh = new ThemSuaKhachHangForm("S???a", makh);

            // https://stackoverflow.com/questions/4154780/jframe-catch-dispose-event
            suakh.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    formHienThi.refresh();
                }
            });

        } else {
            JOptionPane.showMessageDialog(null, "Ch??a ch???n kh??ch h??ng n??o ????? s???a");
        }
    }

    private void btnXoaMouseClicked() {
        String makh = formHienThi.getSelectedRow(1);
        if (makh != null) {
            QuanLyKhachHangBUS qlkhBUS = new QuanLyKhachHangBUS();
            if (qlkhBUS.getKhachHang(makh).getTrangThai() == 0) {
                if (JOptionPane.showConfirmDialog(null, "B???n c?? ch???c mu???n x??a kh??ch h??ng " + makh + " ? "
                        + "Nh??n vi??n s??? ???????c T???M ???N", "Ch?? ??", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                    qlkhBUS.updateTrangThai(makh, 1);
                    formHienThi.refresh();
                }
            } else {
                if (JOptionPane.showConfirmDialog(null, "B???n c?? ch???c mu???n X??A HO??N TO??N kh??ch h??ng " + makh + " ?",
                        "Ch?? ??", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                    qlkhBUS.delete(makh);
                    formHienThi.refresh();
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ch??a ch???n kh??ch h??ng n??o ????? x??a");
        }
    }

    private void btnThemMouseClicked() {
        ThemSuaKhachHangForm themkh = new ThemSuaKhachHangForm("Th??m", "");
        themkh.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                formHienThi.refresh();
            }
        });
    }
}
