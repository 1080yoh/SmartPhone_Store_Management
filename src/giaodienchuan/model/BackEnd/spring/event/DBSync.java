package giaodienchuan.model.BackEnd.spring.event;

import giaodienchuan.model.BackEnd.QuanLyChiTietHoaDon.ChiTietHoaDon;
import giaodienchuan.model.BackEnd.QuanLyChiTietHoaDon.QuanLyChiTietHoaDonDAO;
import giaodienchuan.model.BackEnd.QuanLyChiTietPN.ChiTietPhieuNhap;
import giaodienchuan.model.BackEnd.QuanLyChiTietPN.QuanLyChiTietPhieuNhapDAO;
import giaodienchuan.model.BackEnd.QuanLyHoaDon.HoaDon;
import giaodienchuan.model.BackEnd.QuanLyHoaDon.QuanLyHoaDonDAO;
import giaodienchuan.model.BackEnd.QuanLyKhachHang.KhachHang;
import giaodienchuan.model.BackEnd.QuanLyKhachHang.QuanLyKhachHangDAO;
import giaodienchuan.model.BackEnd.QuanLyKhuyenMai.KhuyenMai;
import giaodienchuan.model.BackEnd.QuanLyKhuyenMai.QuanLyKhuyenMaiDAO;
import giaodienchuan.model.BackEnd.QuanLyLoaiSanPham.LoaiSanPham;
import giaodienchuan.model.BackEnd.QuanLyLoaiSanPham.QuanLyLoaiSanPhamDAO;
import giaodienchuan.model.BackEnd.QuanLyNCC.NhaCungCap;
import giaodienchuan.model.BackEnd.QuanLyNCC.QuanLyNhaCungCapDAO;
import giaodienchuan.model.BackEnd.QuanLyNhanVien.NhanVien;
import giaodienchuan.model.BackEnd.QuanLyNhanVien.QuanLyNhanVienDAO;
import giaodienchuan.model.BackEnd.QuanLyPhieuNhap.PhieuNhap;
import giaodienchuan.model.BackEnd.QuanLyPhieuNhap.QuanLyPhieuNhapDAO;
import giaodienchuan.model.BackEnd.QuanLyQuyen.QuanLyQuyenDAO;
import giaodienchuan.model.BackEnd.QuanLyQuyen.Quyen;
import giaodienchuan.model.BackEnd.QuanLySanPham.QuanLySanPhamDAO;
import giaodienchuan.model.BackEnd.QuanLySanPham.SanPham;
import giaodienchuan.model.BackEnd.QuanLyTaiKhoan.QuanLyTaiKhoanDAO;
import giaodienchuan.model.BackEnd.QuanLyTaiKhoan.TaiKhoan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class DBSync {

    private static final Logger logger = LoggerFactory.getLogger(DBSync.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @EventListener(ApplicationReadyEvent.class)
    public void sync() {
        if (!"true".equalsIgnoreCase(System.getProperty("application.sync.db"))) {
            return;
        }
        syncChiTietHoaDon();
        syncChiTietPhieuNhap();
        syncHoaDon();
        syncKhachHang();
        syncKhuyenMai();
        syncLoaiSanPham();
        syncNhaCungCap();
        syncNhanVien();
        syncPhieuNhap();
        syncPhanQuyen();
        syncSanPham();
        syncTaiKhoan();
    }

    private void syncChiTietHoaDon() {
        logger.info("[syncChiTietHoaDon] -- START -- ");
        mongoTemplate.dropCollection(ChiTietHoaDon.class);

        QuanLyChiTietHoaDonDAO dao = new QuanLyChiTietHoaDonDAO();
        List<ChiTietHoaDon> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncChiTietHoaDon] -- END -- ");
    }

    private void syncChiTietPhieuNhap() {
        logger.info("[syncChiTietPhieuNhap] -- START -- ");
        mongoTemplate.dropCollection(ChiTietPhieuNhap.class);

        QuanLyChiTietPhieuNhapDAO dao = new QuanLyChiTietPhieuNhapDAO();
        List<ChiTietPhieuNhap> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncChiTietPhieuNhap] -- END -- ");
    }

    private void syncHoaDon() {
        logger.info("[syncHoaDon] -- START -- ");
        mongoTemplate.dropCollection(HoaDon.class);

        QuanLyHoaDonDAO dao = new QuanLyHoaDonDAO();
        List<HoaDon> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncHoaDon] -- END -- ");
    }

    private void syncKhachHang() {
        logger.info("[syncKhachHang] -- START -- ");
        mongoTemplate.dropCollection(KhachHang.class);

        QuanLyKhachHangDAO dao = new QuanLyKhachHangDAO();
        List<KhachHang> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncKhachHang] -- END -- ");
    }

    private void syncKhuyenMai() {
        logger.info("[syncKhuyenMai] -- START -- ");
        mongoTemplate.dropCollection(KhuyenMai.class);

        QuanLyKhuyenMaiDAO dao = new QuanLyKhuyenMaiDAO();
        List<KhuyenMai> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncKhuyenMai] -- END -- ");
    }

    private void syncLoaiSanPham() {
        logger.info("[syncLoaiSanPham] -- START -- ");
        mongoTemplate.dropCollection(LoaiSanPham.class);

        QuanLyLoaiSanPhamDAO dao = new QuanLyLoaiSanPhamDAO();
        List<LoaiSanPham> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncLoaiSanPham] -- END -- ");
    }

    private void syncNhaCungCap() {
        logger.info("[syncNhaCungCap] -- START -- ");
        mongoTemplate.dropCollection(NhaCungCap.class);

        QuanLyNhaCungCapDAO dao = new QuanLyNhaCungCapDAO();
        List<NhaCungCap> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncNhaCungCap] -- END -- ");
    }

    private void syncNhanVien() {
        logger.info("[syncNhanVien] -- START -- ");
        mongoTemplate.dropCollection(NhanVien.class);

        QuanLyNhanVienDAO dao = new QuanLyNhanVienDAO();
        List<NhanVien> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncNhanVien] -- END -- ");
    }

    private void syncPhieuNhap() {
        logger.info("[syncPhieuNhap] -- START -- ");
        mongoTemplate.dropCollection(PhieuNhap.class);

        QuanLyPhieuNhapDAO dao = new QuanLyPhieuNhapDAO();
        List<PhieuNhap> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncPhieuNhap] -- END -- ");
    }

    private void syncPhanQuyen() {
        logger.info("[syncPhanQuyen] -- START -- ");
        mongoTemplate.dropCollection(Quyen.class);

        QuanLyQuyenDAO dao = new QuanLyQuyenDAO();
        List<Quyen> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncPhanQuyen] -- END -- ");
    }

    private void syncSanPham() {
        logger.info("[syncSanPham] -- START -- ");
        mongoTemplate.dropCollection(SanPham.class);

        QuanLySanPhamDAO dao = new QuanLySanPhamDAO();
        List<SanPham> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncSanPham] -- END -- ");
    }

    private void syncTaiKhoan() {
        logger.info("[syncTaiKhoan] -- START -- ");
        mongoTemplate.dropCollection(TaiKhoan.class);

        QuanLyTaiKhoanDAO dao = new QuanLyTaiKhoanDAO();
        List<TaiKhoan> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncTaiKhoan] -- END -- ");
    }

}
