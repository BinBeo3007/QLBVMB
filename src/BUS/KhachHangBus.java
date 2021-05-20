package BUS;


import java.util.ArrayList;




import DAO.KhachHangDAO;
import DTO.KhachHang;

public class KhachHangBus {
	KhachHangDAO khachhangDAO = new KhachHangDAO();
	
	public ArrayList<KhachHang> getAllKhachHang() {
		 return khachhangDAO.getAllKhachHang();
	 }
	
	public ArrayList<KhachHang> getKhachHangbyMaKH(KhachHang khachhang) {
		 return khachhangDAO.getKhachHangbyMaKH(khachhang);
	 }
	
	public KhachHang getKhachHangbyMaKH(int maKH) {
		return khachhangDAO.getKhachHangbyMaKH(maKH);
	}
	 public ArrayList<KhachHang> getKhachHangbyCMND(String KhachHang) {
		 return khachhangDAO.getKhachHangbyCMND(KhachHang);
	 }
	 public ArrayList<KhachHang> getKhachHangbyHo(String khachhang) {
		 return khachhangDAO.getKhachHangbyHo(khachhang);
	 }
	 public ArrayList<KhachHang> getKhachHangbyTen(String khachhang) {
		 return khachhangDAO.getKhachHangbyTen(khachhang);
	 }
	
	 public int updateKhachHang(KhachHang khachhang) {
		 int result = khachhangDAO.updateKhachHang(khachhang);
		 return result;
	 }
	
	 public int deleteKhachHang(KhachHang khachhang) {
		 int result = khachhangDAO.deleteKhachHang(khachhang);
		 return result;
	 }
	 
	 public int insertKhachHang(KhachHang khachhang){
		 int result = khachhangDAO.insertKhachHang(khachhang);
		 return result;
	 }
	 
	 public int checkTF(KhachHang kh) {
		 int result = khachhangDAO.checkTF(kh);
		 return result;
	 }
	 
	 public int updateTT(KhachHang khachhang) {
		 return khachhangDAO.updateTT(khachhang);
	 }

	 
}
