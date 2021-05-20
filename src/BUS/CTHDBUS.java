package BUS;

import java.util.ArrayList;

import DTO.CTHD;
import DAO.CTHDDAO;

public class CTHDBUS {
	 CTHDDAO cthd = new CTHDDAO();
	
	 public ArrayList<CTHD> getAllCTHD(){
		 return cthd.getAllCTHD();
	 }
	 public ArrayList<CTHD> getAllCTHDbyMaHD(CTHD hoadon){
		 return cthd.getAllCTHDbyMaHD(hoadon);
	 }

	 public ArrayList<CTHD> getAllCTHDbyMaVe(CTHD hoadon){
		 return cthd.getAllCTHDbyMaVe(hoadon);
	 }

	 public int deleteCTHD(CTHD hoadon) {
		 return cthd.deleteCTHD(hoadon);
	 }
	 
	 public int insertCTHD(CTHD hoadon) {
		 return cthd.insertCTHD(hoadon);
	 }

}
