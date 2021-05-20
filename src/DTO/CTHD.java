package DTO;

public class CTHD {
    private String maHD,mave;
    private int sl,donGia,thanhTien;

    public CTHD(String maHD, String maCB, int sl, int donGia, int thanhTien) {
        this.maHD = maHD;
        this.mave = maCB;
        this.sl = sl;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public CTHD() {
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMave() {
        return mave;
    }

    public void setMave(String maCB) {
        this.mave = maCB;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
}
