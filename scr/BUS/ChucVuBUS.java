package BUS;

import java.util.ArrayList;

import DAO.ChucVuDAO;
import DTO.ChucVu;

public class ChucVuBUS { 
	ChucVuDAO chucvuDAO = new ChucVuDAO();

	 public ArrayList<ChucVu> getAllChucVu() {
		 return chucvuDAO.getAllChucVu();
	 }
	 
	 public String[] getChucVu(){
		 return chucvuDAO.getChucVu();
	 }
	
	 public String getChucVuByMaCV(String chucvu) {
		 return chucvuDAO.getChucVuByMaCV(chucvu);
	 }
	 public String getMaCVbyTenCV(String chucvu) {
		 return chucvuDAO.getMaCVbyTenCV(chucvu);
	 }
	
	 public int updateChucVu(ChucVu chucvu) {
		 int result = chucvuDAO.updateChucVu(chucvu);
		 return result;
	 }
	
	 public int deleteChucVu(ChucVu chucvu) {
		 int result = chucvuDAO.deleteChucVu(chucvu);
		 return result;
	 }
	 
	 public int insertChucVu(ChucVu chucvu){
		 int result = chucvuDAO.insertChucVu(chucvu);
		 return result;
	 }
	 public int checkTF(String macv) {
		 int result= chucvuDAO.checkTF(macv);
		 return result;
	 }
}