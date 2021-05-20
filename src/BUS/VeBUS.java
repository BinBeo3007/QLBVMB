package BUS;

import DTO.Ve;

import java.util.ArrayList;

import DAO.VeDAO;

public class VeBUS {
	VeDAO veDAO= new VeDAO();
	
	 public ArrayList<Ve> getAllVe(){
		 return veDAO.getAllVe();
	 }
	 
	 public ArrayList<Ve> getVebymaVe(Ve ve){
		 return veDAO.getVebymaVe(ve);
	 }
	 public ArrayList<Ve> getVebymaCB(Ve ve){
		 return veDAO.getVebymaCB(ve);
	 }
	 
	 public ArrayList<Ve> getVebymaKH(Ve ve){
		 return veDAO.getVebymaKH(ve);
	 }
	 
	 
	 public int updateVe(Ve ve) {
		 return veDAO.updateVe(ve);
	 }
	 
	 public int insertVe(Ve ve) {
		 return veDAO.insertVe(ve);
	 }
	 
	 public int getGiabyLoai(Ve v){
		 return veDAO.getGiabyLoai(v);
	 }
	 public int updateGiaVe(Ve ve) {
		 return veDAO.updateGiaVe(ve);
	 }
	 
	 public int deleteVe(Ve ve){
		 return veDAO.deleteVe(ve);
	 }

	 
	 public Ve getGiabyMaCBLoai(Ve v) {
		 return veDAO.getGiabyMaCBLoai(v);
	 }
	 
	 public int getsoghedadatByloaimaMB(Ve v) {
		 return veDAO.getsoghedadatByloaimaMB(v);
	 }
	 
	 public int deleteVebymave(Ve ve) {
		 return veDAO.deleteVebymave(ve);
	 }

}
