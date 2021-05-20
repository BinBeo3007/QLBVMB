package DTO;


public class HoaDon {
    private String maHD;
    private String ngayMua;
    private int tongTien,maNV,tinhTrang,maKH,km;

    public HoaDon() {
    	this.maHD = null;
        this.maKH = 0;
        this.maNV = 0;
        this.ngayMua = null;
        this.tongTien = 0;
        this.km=0;
        this.tinhTrang=1;
    }

    public HoaDon(String maHD, int maKH, int maNV, String ngayMua, int tongTien,int tinhTrang) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayMua = ngayMua;
        this.tongTien = tongTien;
        this.tinhTrang=tinhTrang;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrangn(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    public int getKM() {
        return km;
    }

    public void setKM(int km) {
        this.km = km;
    }
}
