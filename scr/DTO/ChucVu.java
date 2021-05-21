package DTO;

public class ChucVu {
    private String maCV,tenCV;
    private int luong;

    public ChucVu(String maCV, String tenCV,int luong) {
        this.maCV = maCV;
        this.tenCV = tenCV;
        this.luong=luong;
    }

    public ChucVu() {
    	maCV=null;
    	tenCV=null;
    	luong=0;
    }

    public String getMaCV() {
        return maCV.trim();
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV.trim();
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }
    
    public int getLuong() {
        return luong; 
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

}
