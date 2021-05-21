package BUS;

import java.util.ArrayList;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoan;

public class TaiKhoanBUS {
	TaiKhoanDAO tkDAO =new TaiKhoanDAO();
	public ArrayList<TaiKhoan> getAllTaiKhoan() {
		return tkDAO.getAllTaiKhoan();
	}
	public boolean checkTK(String taikhoan) {
		return tkDAO.checkTK(taikhoan);
	}
	public boolean checkID(String id) {
		return tkDAO.checkID(id);
	}
	public int checkLogin(String taikhoan,String matkhau) {
		return tkDAO.checkLogin(taikhoan, matkhau);
	}
	public String getID(int ma, int role) {
		return tkDAO.getID(ma, role);
	}
	public int creatTK(TaiKhoan tk) {
		return tkDAO.creatTK(tk);
	}
	public int updateMK(TaiKhoan tk) {
		return tkDAO.updateMK(tk);
	}
	public int deleteTK(TaiKhoan tk) {
		return tkDAO.deleteTK(tk);
	}
	public int getROLEbyTK(String tk) {
		return tkDAO.getROLEbyTK(tk);
	}
}
