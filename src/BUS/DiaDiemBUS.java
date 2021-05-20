package BUS;

import java.util.ArrayList;

import DAO.DiaDiemDAO;
import DTO.DiaDiem;

public class DiaDiemBUS {
	DiaDiemDAO ddDAO = new DiaDiemDAO();

	 public ArrayList<DiaDiem> getAllDiaDiem() {
		 return ddDAO.getAllDiaDiem();
	 }
	 public ArrayList<DiaDiem> getDD(String madd) {
		 return ddDAO.getDD(madd);
	 }
	
	 public String getDDByMaDD(String madd) {
		 return ddDAO.getDDByMaDD(madd);
	 }
	 
	 public String getGioByMaDD(String madd) {
		 return ddDAO.getGioByMaDD(madd);
	 }
	
	 public String getMaDDByDD(String diadiem) {
		 return ddDAO.getMaDDByDD(diadiem);
	 }
	
	
	 public int deleteDiaDiem(DiaDiem dd) {
		 int result = ddDAO.deleteDiaDiem(dd);
		 return result;
	 }
	 
	 public int insertDiaDiem(DiaDiem dd){
		 int result = ddDAO.insertDiaDiem(dd);
		 return result;
		 
	 }
	 public String[] getAllDiaDiem2() {
		 return ddDAO.getAllDiaDiem2();
	 }
	 public String getmaDD(String ten) {
		 return ddDAO.getmaDD(ten);
	 }


}
