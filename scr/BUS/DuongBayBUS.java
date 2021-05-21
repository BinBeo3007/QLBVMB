package BUS;

import java.util.ArrayList;

import DAO.DuongBayDAO;
import DTO.DuongBay;

public class DuongBayBUS {
	DuongBayDAO dbDAO =new DuongBayDAO();
	
	public ArrayList<DuongBay> getAllDB(){
		return dbDAO.getAllDB();
	}
	
	public String[] getMaDB() {
		return dbDAO.getMaDB();
	}
	
	public ArrayList<DuongBay> getDB(String maDB){
		return dbDAO.getDB(maDB);
	}
	
	public ArrayList<DuongBay> getDBbySBDi(String masbDi){
		return dbDAO.getDBbySBDi(masbDi);
	}
	
	public ArrayList<DuongBay> getDBbySBDen(String masbDen){
		return dbDAO.getDBbySBDen(masbDen);
	}
	
	public ArrayList<DuongBay> getDBbySB( String masbDi,String masbDen){
		return dbDAO.getDBbySB(masbDi, masbDen);
	}
	
	public String getDDByMaSBDi(String masb) {
		return dbDAO.getDDByMaSBDi(masb);
	}
	
	public String getDDByMaSBDen(String masb) {
		return dbDAO.getDDByMaSBDen(masb);
	}
	
	
	public int deleteDuongBay(DuongBay duongbay) {
		int result = dbDAO.deleteDuongBay(duongbay);
		return result;
	}
	
	public int insertDuongBay(DuongBay duongbay) {
		int result = dbDAO.insertDuongBay(duongbay);
		return result;
	}
	
	public int updateDuongBay(DuongBay duongbay) {
		int result = dbDAO.updateDuongBay(duongbay);
		return result;
	}
	public DuongBay getDBbySB2(String masbDi,String masbDen) {
		return dbDAO.getDBbySB2(masbDi, masbDen);
	}
	public int checkTF(String maDB) {
		int result= dbDAO.checkTF(maDB);
		return  result;
	}
}
