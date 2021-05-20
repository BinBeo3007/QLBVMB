package BUS;

import DTO.HoaDon;

import java.util.ArrayList;

import DAO.HoaDonDAO;
public class HoaDonBUS {
	HoaDonDAO hdDAO = new HoaDonDAO();
	
	public ArrayList<HoaDon> getAllHD(){
		return hdDAO.getAllHD();
	}
	
	public ArrayList<HoaDon> getHDbyMaHD(HoaDon hd){
		return hdDAO.getHDbyMaHD(hd);
	}
	
	public ArrayList<HoaDon> getHDbyMaKH(HoaDon hd){
		return hdDAO.getHDbyMaKH(hd);
	}
	public ArrayList<HoaDon> getHDbyMaNV(HoaDon hd){
		return hdDAO.getHDbyMaNV(hd);
	}
	public ArrayList<HoaDon> getHDbyT(HoaDon hd){
		return hdDAO.getHDbyT(hd);
	}
	
	 public int deleteHD(HoaDon hoadon) {
		 return hdDAO.deleteHD(hoadon);
	 }
	 
	 public int updateHD(HoaDon hoadon) {
		 return hdDAO.updateHD(hoadon);
	 }
	 public int updateKM(HoaDon hoadon) {
		 return hdDAO.updateKM(hoadon);
	 }
	 public int updateTT(HoaDon hoadon) {
		 return hdDAO.updateTT(hoadon);
	 }
	 public int insertHD(HoaDon hoadon) {
		 return hdDAO.insertHD(hoadon);
	 }
	 public int getSLHD() {
		 return hdDAO.getSLHD();
	 }
	 

	 public int getSLHDbymakh(int makh) {
		 return hdDAO.getSLHDbymaKH(makh);
	 }
	 
	 public int getSLHDbymanv(int manv) {
		 return hdDAO.getSLHDbymanv(manv);
	 }
	 public ArrayList<HoaDon> getHDbyTT(int TT){
		 return hdDAO.getHDbyTT(TT);
	 }
	 
	 public ArrayList<HoaDon> getAllDoanhThu(){
		 return hdDAO.getAllDoanhThu();
	 }
	 
	 public ArrayList<HoaDon> getDoanhThuTang(){
		 return hdDAO.getDoanhThuTang();
	 }
	 
	 public ArrayList<HoaDon> getDoanhThuGiam(){
		 return hdDAO.getDoanhThuGiam();
	 }

}
