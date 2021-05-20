package DTO;

public class DuongBay {
    private String maDB,maSBDen,maSBdi;

    public DuongBay(String maDB, String maSBDen, String maSBdi) {
        this.maDB = maDB;
        this.maSBDen = maSBDen;
        this.maSBdi = maSBdi;
    }

    public DuongBay() {
    }

    public String getMaDB() {
        return maDB.trim();
    }

    public void setMaDB(String maDB) {
        this.maDB = maDB;
    }

    public String getMaSBDen() {
        return maSBDen;
    }

    public void setMaSBDen(String maSBDen) {
        this.maSBDen = maSBDen;
    }

    public String getMaSBdi() {
        return maSBdi.trim();
    }

    public void setMaSBdi(String maSBdi) {
        this.maSBdi = maSBdi;
    }
}
