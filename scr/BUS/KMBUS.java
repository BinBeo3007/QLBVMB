package BUS;

import DAO.KMDAO;
import DTO.KM;

import java.util.ArrayList;

public class KMBUS {
    KMDAO kmd=new KMDAO();

    public ArrayList<KM> getAllKM(){
        return kmd.getAllKM();
    }
    public ArrayList<KM> getAllKMbyMaKM(String maKH){
        return kmd.getAllKMbyMaKM(maKH);
    }
    public int getPhanTram(String maKH){
        return kmd.getPhanTram(maKH);
    }
    public int insertKM(KM km){
        return kmd.insertKM(km);
    }
    public int updateKM(KM km){
        return kmd.updateKM(km);
    }
    public int deleteKM(String km){
        return kmd.deleteKM(km);
    }
    public KM getKMbyMaKM(String maKH) {
    	return kmd.getKMbyMaKM(maKH);
    }
}
