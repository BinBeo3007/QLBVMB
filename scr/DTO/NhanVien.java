package DTO;

public class NhanVien {
    private String hoNV,lotNV,tenNV,sdt,maCV,diachi,cmnd;
    private int maNV,namsinh,luong,tinhtrang;

    public NhanVien(int maNV, String hoNV, String lotNV, String tenNV, String sdt, String maCV, String diachi,String cmnd,int namsinh,int luong) {
        this.maNV = maNV;
        this.hoNV = hoNV;
        this.lotNV = lotNV;
        this.tenNV = tenNV;
        this.sdt = sdt;
        this.maCV = maCV;
        this.diachi = diachi;
        this.cmnd=cmnd;
        this.namsinh=namsinh;
        this.luong=luong;
    }

    public NhanVien() {
    	this.maNV = 0;
        this.hoNV = null;
        this.lotNV = null;
        this.tenNV = null;
        this.sdt = null;
        this.maCV = null;
        this.diachi = null;
        this.cmnd=null;
        this.namsinh=1920;
        luong=0;
        tinhtrang=1;
    }
    
    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }
    
    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }
    
    public int getTT() {
        return tinhtrang;
    }

    public void setTT(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getHoNV() {
        return hoNV.trim();
    }

    public void setHoNV(String hoNV) {
        this.hoNV = hoNV;
    }

    public String getLotNV() {
        return lotNV.trim();
    }

    public void setLotNV(String lotNV) {
        this.lotNV = lotNV;
    }

    public String getTenNV() {
        return tenNV.trim();
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSdt() {
        return sdt.trim();
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMaCV() {
        return maCV.trim();
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getDiachi() {
        return diachi.trim();
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    public String getCMND() {
        return cmnd.trim();
    }

    public void setCMND(String cmnd) {
        this.cmnd = cmnd;
    }
    
    public String getHoTen() {
    	String s=""+hoNV+" "+lotNV+" "+tenNV;
    	s=s.replaceAll("\\s\\s+", " ").trim();
    	return s;
    }

    
}
