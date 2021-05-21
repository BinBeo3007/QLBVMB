package DTO.Thongke;

public class TKNV {
    int manv,slve;
    String hoten;

    public TKNV() {
        manv=0;
        slve=0;
        hoten=null;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public int getSlve() {
        return slve;
    }

    public void setSlve(int slve) {
        this.slve = slve;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
}
