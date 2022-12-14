package giaodienchuan.model.FrontEnd.FormQuanLy;

import giaodienchuan.model.BackEnd.QuanLyNhanVien.QuanLyNhanVienBUS;
import giaodienchuan.model.BackEnd.WorkWithExcel.DocExcel;
import giaodienchuan.model.BackEnd.WorkWithExcel.XuatExcel;
import giaodienchuan.model.FrontEnd.FormHienThi.HienThiNhanVien;
import giaodienchuan.model.FrontEnd.FormThemSua.ThemSuaNhanVienForm;
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

public class QuanLyNhanVienForm extends JPanel {

    HienThiNhanVien formHienThi = new HienThiNhanVien();

    ThemButton btnThem = new ThemButton();
    SuaButton btnSua = new SuaButton();
    XoaButton btnXoa = new XoaButton();
    
    ExportExcelButton btnXuatExcel = new ExportExcelButton();
    ImportExcelButton btnNhapExcel = new ImportExcelButton();

    public QuanLyNhanVienForm() {
        setLayout(new BorderLayout());

        // buttons
        if (!LoginForm.quyenLogin.getChiTietQuyen().contains("qlNhanVien")) {
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
            new XuatExcel().xuatFileExcelNhanVien();
        });
        btnNhapExcel.addActionListener((ActionEvent ae) -> {
            new DocExcel().docFileExcelNhanVien();
        });
    }

    private void btnSuaMouseClicked() {
        String manv = formHienThi.getSelectedRow(1);
        if (manv != null) {
            ThemSuaNhanVienForm suanv = new ThemSuaNhanVienForm("S???a", manv);

            // https://stackoverflow.com/questions/4154780/jframe-catch-dispose-event
            suanv.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    formHienThi.refresh();
                }
            });

        } else {
            JOptionPane.showMessageDialog(null, "Ch??a ch???n nh??n vi??n n??o ????? s???a");
        }
    }

    private void btnXoaMouseClicked() {
        String manv = formHienThi.getSelectedRow(1);
        if (manv != null) {
            QuanLyNhanVienBUS qlnvBUS = new QuanLyNhanVienBUS();
            if (qlnvBUS.getNhanVien(manv).getTrangThai() == 0) {
                if (JOptionPane.showConfirmDialog(null, "B???n c?? ch???c mu???n x??a nh??n vi??n " + manv + " ? "
                        + "Nh??n vi??n s??? ???????c T???M ???N", "Ch?? ??", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                    qlnvBUS.updateTrangThai(manv, 1);
                    formHienThi.refresh();
                }
            } else {
                if (JOptionPane.showConfirmDialog(null, "B???n c?? ch???c mu???n X??A HO??N TO??N nh??n vi??n " + manv + " ?",
                        "Ch?? ??", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                    qlnvBUS.delete(manv);
                    formHienThi.refresh();
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ch??a ch???n nh??n vi??n n??o ????? x??a");
        }
    }

    private void btnThemMouseClicked() {
        ThemSuaNhanVienForm themnv = new ThemSuaNhanVienForm("Th??m", "");
        themnv.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                formHienThi.refresh();
            }
        });
    }
}
