package DTO;

public class ChuyenBay {
    private String maCB,maDB,maMB,gioBay;
    private String ngayDi,NgayDen;
    private int sogheloai1,sogheloa2,tinhtrang;

    public ChuyenBay(String maCB, String maDB, String maMB, String gioBay, String ngayDi, String ngayDen, int sogheloai1, int sogheloa2) {
        this.maCB = maCB;
        this.maDB = maDB;
        this.maMB = maMB;
        this.gioBay = gioBay;
        this.ngayDi = ngayDi;
        NgayDen = ngayDen;
        this.sogheloai1 = sogheloai1;
        this.sogheloa2 = sogheloa2;
        tinhtrang=1;
    }

    public static boolean gio(String gio) {
    	boolean result=true;
    	result=gio.matches("\\d{2}:\\d{2}");
    	if(result==false)
            return false;
    	String s1,s2;
    	int hh,mm;
    	s1=gio.substring(0,2);
    	s2=gio.substring(3);
    	if(s1!=""&&s2!="") {
    		hh=Integer.parseInt(s1);
    		mm=Integer.parseInt(s2);
    		if(hh<0 ||hh>23)
    			return false;
    		if(mm<0||mm>59)
    			return false;
    	}
    	return result;
    		
    }

    public static boolean ngaythang(int ngay, int thang,int nam){
        if(thang<1 || thang >12)
            return false;
        int temp=0;
        switch (thang){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                temp=31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                temp=30;
                break;
            case 2:
                if ((nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0)) {
                    temp=29;
                } else {
                    temp=28;
                }
                break;
            default:
                temp=-1;
                break;
        }

        if(ngay>temp||ngay<1)
            return false;
        return  true;
    }
    
    public int getTT() {
        return tinhtrang;
    }

    public void setTT(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public static boolean checkNgay(String di, String den) {
    	boolean result=true;
    	result=di.matches("\\d{2}-\\d{2}-\\d{4}$");
        if(result==false)
            return false;
       
    	result=den.matches("\\d{2}-\\d{2}-\\d{4}$");
    	if(result==false)
    		return false;

    	String s1=di.substring(6);
        String s2=den.substring(6);
        String s3,s4,s5,s6;
        s3=di.substring(3,5);
        s4=den.substring(3,5);
        s5=di.substring(0,2);
        s6=den.substring(0,2);
        int nam1,nam2,thang1,thang2,ngay1,ngay2;
        if(s1!="" && s2 !=""&&s3!=""&&s4!=""&&s5!=""&&s6!=""){
            nam1=Integer.parseInt(s1);
            nam2=Integer.parseInt(s2);
            if(nam1>nam2)
                return  false;
            if(nam1<nam2)
            	return true;
            thang1=Integer.parseInt(s3);
            thang2=Integer.parseInt(s4);
            ngay1=Integer.parseInt(s5);
            ngay2=Integer.parseInt(s6);

            result=ChuyenBay.ngaythang(ngay1,thang1,nam1);
            result=ChuyenBay.ngaythang(ngay2,thang2,nam2);

            if(thang1>thang2)
                return false;
            else{
                if (thang1==thang2)
                    if(ngay1>ngay2)
                        return false;
            }

        }

    	return result;
    }
    
    public ChuyenBay(){

    }

    public String getMaCB() {
        return maCB.trim();
    }

    public void setMaCB(String maCB) {
        this.maCB = maCB;
    }

    public String getMaDB() {
        return maDB.trim();
    }

    public void setMaDB(String maDB) {
        this.maDB = maDB;
    }

    public String getMaMB() {
        return maMB.trim();
    }

    public void setMaMB(String maMB) {
        this.maMB = maMB;
    }

    public String getGioBay() {
        return gioBay.trim();
    }

    public void setGioBay(String gioBay) {
        this.gioBay = gioBay;
    }

    public String getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(String ngayDi) {
        this.ngayDi = ngayDi;
    }

    public String getNgayDen() {
        return NgayDen;
    }

    public void setNgayDen(String ngayDen) {
        NgayDen = ngayDen;
    }

    public int getSogheloai1() {
        return sogheloai1;
    }

    public void setSogheloai1(int sogheloai1) {
        this.sogheloai1 = sogheloai1;
    }

    public int getSogheloa2() {
        return sogheloa2;
    }

    public void setSogheloa2(int sogheloa2) {
        this.sogheloa2 = sogheloa2;
    }

    @Override
    public String toString() {
        return "ChuyenBay{" +
                "maCB='" + maCB + '\'' +
                ", maDB='" + maDB + '\'' +
                ", maMB='" + maMB + '\'' +
                ", gioBay='" + gioBay + '\'' +
                ", ngayDi='" + ngayDi + '\'' +
                ", NgayDen='" + NgayDen + '\'' +
                ", sogheloai1=" + sogheloai1 +
                ", sogheloa2=" + sogheloa2 +
                '}';
    }
}
