package DTO;

public class SanBay {
    private String maSB,tenSB,maDD;

    public SanBay(String maSB, String tenSB, String maDD) {
        this.maSB = maSB;
        this.tenSB = tenSB;
        this.maDD = maDD;
    }

    public SanBay() {
    	 this.maSB = null;
         this.tenSB = null;
         this.maDD = null;
    }

    public String getMaSB() {
        return maSB.trim();
    }

    public void setMaSB(String maSB) {
        this.maSB = maSB;
    }

    public String getTenSB() {
        return tenSB.trim();
    }

    public void setTenSB(String tenSB) {
        this.tenSB = tenSB;
    }

    public String getMaDD() {
        return maDD.trim();
    }

    public void setMaDD(String maDD) {
        this.maDD = maDD;
    }
}
