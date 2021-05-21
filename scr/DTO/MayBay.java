package DTO;

public class MayBay {
    private String maMB,tenMB,Hang_SX;
    private int gheloai1,gheloai2,tongghe;

    public MayBay(String maMB, String tenMB, String hang_SX, int gheloai1, int gheloai2, int tongghe) {
        this.maMB = maMB;
        this.tenMB = tenMB;
        Hang_SX = hang_SX;
        this.gheloai1 = gheloai1;
        this.gheloai2 = gheloai2;
        this.tongghe = tongghe;
    }

    public MayBay(){

    }

    public String getMaMB() {
        return maMB;
    }

    public void setMaMB(String maMB) {
        this.maMB = maMB;
    }

    public String getTenMB() {
        return tenMB.trim();
    }

    public void setTenMB(String tenMB) {
        this.tenMB = tenMB;
    }

    public String getHang_SX() {
        return Hang_SX;
    }

    public void setHang_SX(String hang_SX) {
        Hang_SX = hang_SX.trim();
    }

    public int getGheloai1() {
        return gheloai1;
    }

    public void setGheloai1(int gheloai1) {
        this.gheloai1 = gheloai1;
    }

    public int getGheloai2() {
        return gheloai2;
    }

    public void setGheloai2(int gheloai2) {
        this.gheloai2 = gheloai2;
    }

    public int getTongghe() {
        return tongghe;
    }

    public void setTongghe(int tongghe) {
        this.tongghe = tongghe;
    }
}
