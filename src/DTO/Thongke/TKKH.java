package DTO.Thongke;

public class TKKH {
    int makh,slve;
    String hoten;

    public TKKH() {
        makh=0;
        slve=0;
        hoten=null;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
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
