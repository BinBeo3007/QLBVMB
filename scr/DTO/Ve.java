package DTO;

public class Ve {
    private String maVe,maCB;
    private String ngayDat;
    private int loaiGhe,giaTien,tinhTrang,maKH;

    public Ve() {
    	this.maVe = null;
        this.maCB = null;
        this.maKH = 0;
        this.ngayDat = null;
        this.loaiGhe = 0;
        this.giaTien = 0;
        this.tinhTrang = 1;
    }

    public Ve(String maVe, String maCB, int maKH, String ngayDat, int loaiGhe, int giaTien, int tinhTrang) {
        this.maVe = maVe;
        this.maCB = maCB;
        this.maKH = maKH;
        this.ngayDat = ngayDat;
        this.loaiGhe = loaiGhe;
        this.giaTien = giaTien;
        this.tinhTrang = tinhTrang;
    }

    public String getMaVe() {
        return maVe.trim();
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getMaCB() {
        return maCB;
    }

    public void setMaCB(String maCB) {
        this.maCB = maCB;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public int getLoaiGhe() {
        return loaiGhe;
    }

    public void setLoaiGhe(int loaiGhe) {
        this.loaiGhe = loaiGhe;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
