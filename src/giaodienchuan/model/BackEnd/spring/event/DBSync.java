package giaodienchuan.model.BackEnd.spring.event;

import giaodienchuan.model.BackEnd.QuanLyChiTietHoaDon.ChiTietHoaDon;
import giaodienchuan.model.BackEnd.QuanLyChiTietPN.ChiTietPhieuNhap;
import giaodienchuan.model.BackEnd.QuanLyHoaDon.HoaDon;
import giaodienchuan.model.BackEnd.QuanLyKhachHang.KhachHang;
import giaodienchuan.model.BackEnd.QuanLyKhuyenMai.KhuyenMai;
import giaodienchuan.model.BackEnd.QuanLyLoaiSanPham.LoaiSanPham;
import giaodienchuan.model.BackEnd.QuanLyNCC.NhaCungCap;
import giaodienchuan.model.BackEnd.QuanLyNhanVien.NhanVien;
import giaodienchuan.model.BackEnd.QuanLyPhieuNhap.PhieuNhap;
import giaodienchuan.model.BackEnd.QuanLyQuyen.Quyen;
import giaodienchuan.model.BackEnd.QuanLySanPham.SanPham;
import giaodienchuan.model.BackEnd.QuanLyTaiKhoan.TaiKhoan;
import giaodienchuan.model.BackEnd.Repo.*;
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

        QuanLyChiTietHoaDonRepo dao = new QuanLyChiTietHoaDonRepo();
        List<ChiTietHoaDon> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncChiTietHoaDon] -- END -- ");
    }

    private void syncChiTietPhieuNhap() {
        logger.info("[syncChiTietPhieuNhap] -- START -- ");
        mongoTemplate.dropCollection(ChiTietPhieuNhap.class);

        QuanLyChiTietPhieuNhapRepo dao = new QuanLyChiTietPhieuNhapRepo();
        List<ChiTietPhieuNhap> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncChiTietPhieuNhap] -- END -- ");
    }

    private void syncHoaDon() {
        logger.info("[syncHoaDon] -- START -- ");
        mongoTemplate.dropCollection(HoaDon.class);

        QuanLyHoaDonRepo dao = new QuanLyHoaDonRepo();
        List<HoaDon> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncHoaDon] -- END -- ");
    }

    private void syncKhachHang() {
        logger.info("[syncKhachHang] -- START -- ");
        mongoTemplate.dropCollection(KhachHang.class);

        QuanLyKhachHangRepo dao = new QuanLyKhachHangRepo();
        List<KhachHang> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncKhachHang] -- END -- ");
    }

    private void syncKhuyenMai() {
        logger.info("[syncKhuyenMai] -- START -- ");
        mongoTemplate.dropCollection(KhuyenMai.class);

        QuanLyKhuyenMaiRepo dao = new QuanLyKhuyenMaiRepo();
        List<KhuyenMai> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncKhuyenMai] -- END -- ");
    }

    private void syncLoaiSanPham() {
        logger.info("[syncLoaiSanPham] -- START -- ");
        mongoTemplate.dropCollection(LoaiSanPham.class);

        QuanLyLoaiSanPhamRepo dao = new QuanLyLoaiSanPhamRepo();
        List<LoaiSanPham> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncLoaiSanPham] -- END -- ");
    }

    private void syncNhaCungCap() {
        logger.info("[syncNhaCungCap] -- START -- ");
        mongoTemplate.dropCollection(NhaCungCap.class);

        QuanLyNhaCungCapRepo dao = new QuanLyNhaCungCapRepo();
        List<NhaCungCap> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncNhaCungCap] -- END -- ");
    }

    private void syncNhanVien() {
        logger.info("[syncNhanVien] -- START -- ");
        mongoTemplate.dropCollection(NhanVien.class);

        QuanLyNhanVienRepo dao = new QuanLyNhanVienRepo();
        List<NhanVien> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncNhanVien] -- END -- ");
    }

    private void syncPhieuNhap() {
        logger.info("[syncPhieuNhap] -- START -- ");
        mongoTemplate.dropCollection(PhieuNhap.class);

        QuanLyPhieuNhapRepo dao = new QuanLyPhieuNhapRepo();
        List<PhieuNhap> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncPhieuNhap] -- END -- ");
    }

    private void syncPhanQuyen() {
        logger.info("[syncPhanQuyen] -- START -- ");
        mongoTemplate.dropCollection(Quyen.class);

        QuanLyQuyenRepo dao = new QuanLyQuyenRepo();
        List<Quyen> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncPhanQuyen] -- END -- ");
    }

    private void syncSanPham() {
        logger.info("[syncSanPham] -- START -- ");
        mongoTemplate.dropCollection(SanPham.class);

        QuanLySanPhamRepo dao = new QuanLySanPhamRepo();
        List<SanPham> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncSanPham] -- END -- ");
    }

    private void syncTaiKhoan() {
        logger.info("[syncTaiKhoan] -- START -- ");
        mongoTemplate.dropCollection(TaiKhoan.class);

        QuanLyTaiKhoanRepo dao = new QuanLyTaiKhoanRepo();
        List<TaiKhoan> data = dao.readDB();
        logger.info("Data: " + data.size());

        Collection<?> saved = mongoTemplate.insertAll(data);
        logger.info("Sync: " + saved.size());
        logger.info("[syncTaiKhoan] -- END -- ");
    }

}
