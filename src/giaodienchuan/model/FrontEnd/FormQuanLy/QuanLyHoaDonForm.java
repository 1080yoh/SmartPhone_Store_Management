package giaodienchuan.model.FrontEnd.FormQuanLy;

import giaodienchuan.model.BackEnd.QuanLyChiTietHoaDon.QuanLyChiTietHoaDonBUS;
import giaodienchuan.model.BackEnd.QuanLyHoaDon.QuanLyHoaDonBUS;
import giaodienchuan.model.BackEnd.WorkWithExcel.DocExcel;
import giaodienchuan.model.BackEnd.WorkWithExcel.XuatExcel;
import giaodienchuan.model.BackEnd.WritePDF.WritePDF;
import giaodienchuan.model.FrontEnd.FormHienThi.HienThiHoaDon;
import giaodienchuan.model.FrontEnd.FormThemSua.ThemSuaHoaDonForm;
import giaodienchuan.model.FrontEnd.GiaoDienChuan.LoginForm;
import giaodienchuan.model.FrontEnd.GiaoDienChuan.MyTable;
import giaodienchuan.model.FrontEnd.MyButton.ExportExcelButton;
import giaodienchuan.model.FrontEnd.MyButton.ImportExcelButton;
import giaodienchuan.model.FrontEnd.MyButton.SuaButton;
import giaodienchuan.model.FrontEnd.MyButton.ThemButton;
import giaodienchuan.model.FrontEnd.MyButton.XoaButton;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;

public class QuanLyHoaDonForm extends JPanel {

    HienThiHoaDon formHienThi = new HienThiHoaDon();
    ThemButton btnThem = new ThemButton();
    SuaButton btnSua = new SuaButton();
    XoaButton btnXoa = new XoaButton();
    ImportExcelButton btnNhapExcel = new ImportExcelButton();
    ExportExcelButton btnXuatExcel = new ExportExcelButton();
    JButton btnPrintPDF = new JButton("In PDF");

    public QuanLyHoaDonForm() {
        setLayout(new BorderLayout());

        // buttons
        if (!LoginForm.quyenLogin.getChiTietQuyen().contains("qlHoaDon")) {
            btnNhapExcel.setEnabled(false);
        }
        btnThem.setEnabled(false);
        btnXoa.setEnabled(false);
        btnSua.setEnabled(false);

        JPanel plBtn = new JPanel();
//        plBtn.add(btnThem);
//        plBtn.add(btnXoa);
//        plBtn.add(btnSua);
//        plBtn.add(btnXuatExcel);
//        plBtn.add(btnNhapExcel);
//        plBtn.add(btnPrintPDF);

        this.add(formHienThi, BorderLayout.CENTER);
        this.add(plBtn, BorderLayout.NORTH);

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
            new XuatExcel().xuatFileExcelHoaDon();
        });
        btnNhapExcel.addActionListener((ActionEvent ae) -> {
            JOptionPane.showMessageDialog(this, "Ch???c n??ng ch??a ho??n th??nh!");
        });
        btnPrintPDF.addActionListener((ae) -> {
            if (formHienThi.getSelectedRow(0) != null) {
                MyTable mtb = formHienThi.getTable();
                new WritePDF().writeHoaDon(String.valueOf(mtb.getTable().getValueAt(mtb.getTable().getSelectedRow(), 1)));
            } else {
                JOptionPane.showMessageDialog(null, "Ch??a ch???n h??a ????n n??o ????? in");
            }
        });
    }

    private void btnSuaMouseClicked() {
        String mahd = formHienThi.getSelectedRow(1);
        if (mahd != null) {
            ThemSuaHoaDonForm tshd = new ThemSuaHoaDonForm("S???a", mahd);
            tshd.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    formHienThi.refresh();
                }
            });
        } else {
            JOptionPane.showMessageDialog(null, "Ch??a ch???n h??a ????n n??o ????? s???a");
        }
    }

    private void btnXoaMouseClicked() {
        String mahd = formHienThi.getSelectedRow(1);
        if (mahd != null) {
            if (JOptionPane.showConfirmDialog(null, "B???n c?? ch???c mu???n x??a h??a ????n " + mahd
                    + " ? M???i chi ti???t trong h??a ????n s??? b??? x??a theo",
                    "Ch?? ??", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

                new QuanLyChiTietHoaDonBUS().deleteAll(mahd);
                new QuanLyHoaDonBUS().delete(mahd);

                formHienThi.refresh();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ch??a ch???n s???n ph???m n??o ????? x??a");
        }
    }

    private void btnThemMouseClicked() {
        ThemSuaHoaDonForm themhd = new ThemSuaHoaDonForm("Th??m", "");
        themhd.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                formHienThi.refresh();
            }
        });
    }
}
