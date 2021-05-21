package BUS;

import java.util.ArrayList;

import DAO.MayBayDAO;
import DTO.MayBay;

public class MayBayBUS {
	MayBayDAO mbDAO =new MayBayDAO();
	
	 public ArrayList<MayBay> getALLMB(){
		 return mbDAO.getALLMB();
	 }
	 public String[] getAllmaMB() {
		 return mbDAO.getAllmaMB();
	 }
	 public ArrayList<MayBay> getMBbyMaMB(MayBay maybay){
		 return mbDAO.getMBbyMaMB(maybay);
	 }
	 
	 public ArrayList<MayBay> getMBbyMaMB2(String maMB){
		 return mbDAO.getMBbyMaMB2(maMB);
	 }
	 public ArrayList<MayBay> getMBbySX(String hangSX){
		 return mbDAO.getMBbySX(hangSX);
	 }
	 public ArrayList<MayBay> getMBbyTongGhe(int tongghe){
		 return mbDAO.getMBbyTongGhe(tongghe);
	 }
	 public int deleteMayBay(MayBay maybay) {
		 int result =mbDAO.deleteMayBay(maybay);
		 return result;
	 }
	 public int insertMayBay(MayBay maybay) {
		 int result =mbDAO.insertMayBay(maybay);
		 return result;
	 }
	 public int updateMayBay(MayBay maybay) {
		 int result =mbDAO.updateMayBay(maybay);
		 return result;
	 }
	 public int checkTF(String maMB) {
		 return mbDAO.checkTF(maMB);
	 }
}
