package DTO;

public class DiaDiem {
    private String maDD,tenDD,muiGio;

    public DiaDiem(String maDD, String tenDD, String muiGio) {
        this.maDD = maDD;
        this.tenDD = tenDD;
        this.muiGio = muiGio;
    }

    public DiaDiem() {
    }

    public String getMaDD() {
        return maDD.trim();
    }

    public void setMaDD(String maDD) {
        this.maDD = maDD;
    }

    public String getTenDD() {
        return tenDD.trim();
    }

    public void setTenDD(String tenDD) {
        this.tenDD = tenDD;
    }

    public String getMuiGio() {
        return muiGio.trim();
    }

    public void setMuiGio(String muiGio) {
        this.muiGio = muiGio;
    }
}
