package DTO;

public class KM {
    private String makm,batdau,ketthuc;
    private int phantram;

    public KM(){
        makm=null;
        batdau=null;
        ketthuc=null;
        phantram=0;
    }

    public String getMakm() {
        return makm;
    }

    public void setMakm(String makm) {
        this.makm = makm;
    }

    public String getBatdau() {
        return batdau;
    }

    public void setBatdau(String batdau) {
        this.batdau = batdau;
    }

    public String getKetthuc() {
        return ketthuc;
    }

    public void setKetthuc(String ketthuc) {
        this.ketthuc = ketthuc;
    }

    public int getPhantram() {
        return phantram;
    }

    public void setPhantram(int phantram) {
        this.phantram = phantram;
    }
}
