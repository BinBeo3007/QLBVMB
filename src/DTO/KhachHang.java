package DTO;

public class KhachHang {
    private String cmnd,hoKH,lotKH,tenKH,sdt,diachi;
    private int namsinh,maKH,tinhtrang;

    public KhachHang(int maKH,String cmnd, String hoKH, String lotKH, String tenKH, String sdt, int namsinh) {
        this.cmnd = cmnd;
        this.hoKH = hoKH;
        this.lotKH = lotKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.namsinh = namsinh;
        this.maKH=maKH;
    }

    public KhachHang() {
    	cmnd=null;
    	hoKH=null;
    	tenKH=null;
    	lotKH=null;
    	sdt=null;
    	namsinh=9999;
    	tinhtrang=1;
    	diachi=null;
    }

    public int getTT() {
        return tinhtrang;
    }

    public void setTT(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
    
    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }
    
    public String getCmnd() {
        return cmnd.trim();
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getHoKH() {
        return hoKH;
    }

    public void setHoKH(String hoKH) {
        this.hoKH = hoKH.trim();
    }

    public String getLotKH() {
        return lotKH.trim();
    }

    public void setLotKH(String lotKH) {
        this.lotKH = lotKH;
    }

    public String getTenKH() {
        return tenKH.trim();
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setDiaChi(String diachi) {
        this.diachi = diachi;
    }

    public String getDiaChi() {
        return diachi.trim();
    }
    
    public String getSdt() {
        return sdt.trim();
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getNamSinh() {
        return namsinh;
    }

    public void setNamSinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getHoTen(){
        String temp=""+hoKH+" "+lotKH+" "+tenKH;
        return temp.replaceAll("\\s\\s+", " ");
    }
}
