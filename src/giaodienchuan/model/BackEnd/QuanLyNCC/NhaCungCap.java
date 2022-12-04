/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodienchuan.model.BackEnd.QuanLyNCC;

import org.springframework.data.annotation.Id;

public class NhaCungCap {
    @Id
    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private String sdt;
    private String fax;
    
    public NhaCungCap(){
        
    }
    public NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdt, String Fax)
    {
        this.maNCC=maNCC;
        this.tenNCC=tenNCC;
        this.diaChi=diaChi;
        this.sdt = sdt;
        this.fax =Fax;
    }
    public NhaCungCap(NhaCungCap n)
    {
        this.maNCC=n.maNCC;
        this.tenNCC=n.tenNCC;
        this.diaChi=n.diaChi;
        this.sdt =n.sdt;
        this.fax =n.fax;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public String getFax() {
        return fax;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setFax(String Fax) {
        this.fax = Fax;
    }
        
    
}
