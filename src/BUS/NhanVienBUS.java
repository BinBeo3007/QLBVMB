package BUS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DAO.NhanVienDAO;
import DTO.KhachHang;
import DTO.NhanVien;

public class NhanVienBUS {
	NhanVienDAO nhanvienDAO = new NhanVienDAO();
	
	public ArrayList<NhanVien> getAllNhanVien() {
		 return nhanvienDAO.getAllNhanVien();
	 }
	public String[] getMaNV() {
		return nhanvienDAO.getMaNV();
	}
	
	 public ArrayList<NhanVien> getNhanVienbyMaNV(NhanVien nhanvien) {
		 return nhanvienDAO.getNhanVienbyMaNV(nhanvien);
	 }
	 public ArrayList<NhanVien> getNhanVienbyChucVu(String nhanvien) {
		 return nhanvienDAO.getNhanVienbyChucVu(nhanvien);
	 }
	 public ArrayList<NhanVien> getNhanVienbyHoNV(String nhanvien) {
		 return nhanvienDAO.getNhanVienbyHoNV(nhanvien);
	 }
	 public ArrayList<NhanVien> getNhanVienbyTenNV(String nhanvien) {
		 return nhanvienDAO.getNhanVienbyTenNV(nhanvien);
	 }
	
	 public int updateNhanVien(NhanVien nhanvien) {
		 int result = nhanvienDAO.updateNhanVien(nhanvien);
		 return result;
	 }
	
	 public int deleteNhanVien(NhanVien nhanvien) {
		 int result = nhanvienDAO.deleteNhanVien(nhanvien);
		 return result;
	 }
	 
	 public int insertNhanVien(NhanVien nhanvien){
		 int result = nhanvienDAO.insertNhanVien(nhanvien);
		 return result;
	 }
	 public String getTenbyMaNV(int manv) {
		 return nhanvienDAO.getTenbyMaNV(manv);
	 }

	 public int updateTT(NhanVien nhanvien) {
		 return nhanvienDAO.updateTT(nhanvien);
	 }
	 
	
}
