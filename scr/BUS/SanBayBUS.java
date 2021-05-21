package BUS;

import java.util.ArrayList;

import DAO.SanBayDAO;
import DTO.SanBay;

public class SanBayBUS {
	SanBayDAO sbDAO = new SanBayDAO();

	 public ArrayList<SanBay> getAllSB() {
		 return sbDAO.getAllSB();
	 }
	 public ArrayList<SanBay> getSB(String maSB) {
		 return sbDAO.getSB(maSB);
	 }
	 
	 public ArrayList<SanBay> getSBbyDD(String madd) {
		 return sbDAO.getSBbyDD(madd);
	 }
	 
	 public String getSBByMaSB(String masb) {
		 return sbDAO.getSBByMaSB(masb);
	 }
	 
	 public String getDDByMaSB(String masb) {
		 return sbDAO.getDDByMaSB(masb);
	 }
	
	
	 public int deleteSanBay(SanBay sanbay) {
		 int result = sbDAO.deleteSanBay(sanbay);
		 return result;
	 }
	 
	 public int insertSanBay(SanBay sanbay){
		 int result = sbDAO.insertSanBay(sanbay);
		 return result;
	 }
	 
	 public int updateSanBay(SanBay sanbay) {
		 int result = sbDAO.updateSanBay(sanbay);
		 return result;
	 }
	 
	 public ArrayList<String> getALLMaSB(){
		 return sbDAO.getALLMASB();
	 }
	 public ArrayList<String> getALLMaSB2(String masb){
		 return sbDAO.getALLMASB2(masb);
	 }
	 public String getSBByDD(String madd) {
		 return sbDAO.getSBByDD(madd);
	 }

}
