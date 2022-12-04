/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodienchuan.model.BackEnd.QuanLyNCC;

import giaodienchuan.model.BackEnd.common.CommonDTO;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("nhacungcap")
public class NhaCungCap extends CommonDTO {
    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private String sdt;
    private String fax;

    public NhaCungCap() {

    }

    public NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdt, String fax) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.fax = fax;
    }

    public NhaCungCap(NhaCungCap n) {
        this.maNCC = n.maNCC;
        this.tenNCC = n.tenNCC;
        this.diaChi = n.diaChi;
        this.sdt = n.sdt;
        this.fax = n.fax;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String Fax) {
        this.fax = Fax;
    }


}
