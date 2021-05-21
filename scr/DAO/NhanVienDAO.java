package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.NhanVien;
import utils.DBUtils;

public class NhanVienDAO {
	
	private DBUtils dbUtils = null;
	private Connection connection =null;
	private PreparedStatement preparedstatement =null;
	private ResultSet resultset = null;
	
	public ArrayList<NhanVien> getAllNhanVien(){
		ArrayList<NhanVien> result = new ArrayList<NhanVien>();
		String sqlSelectAll ="select * from NHAN_VIEN";
		try {
			dbUtils = new DBUtils();
			connection = dbUtils.getConnection();
			preparedstatement = connection.prepareStatement(sqlSelectAll);
			resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				if(resultset.getInt("TINH_TRANG")!=0) {
					NhanVien nv = new NhanVien();
					nv.setMaNV(resultset.getInt("MA_NV"));
					nv.setHoNV(resultset.getString("HO"));
					nv.setLotNV(resultset.getString("LOT"));
					nv.setTenNV(resultset.getString("TEN"));
					nv.setMaCV(resultset.getString("MA_CV"));
					nv.setCMND(resultset.getString("CMND"));
					nv.setDiachi(resultset.getString("DIA_CHI"));
					nv.setSdt(resultset.getString("SDT"));
					nv.setNamsinh(resultset.getInt("NAM_SINH"));
					nv.setTT(resultset.getInt("TINH_TRANG"));
					result.add(nv);
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				preparedstatement.close();
				resultset.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public String[] getMaNV(){
		String[] result = new String[99];
		String sqlSelectAll ="select * from NHAN_VIEN";
		try {
			dbUtils = new DBUtils();
			connection = dbUtils.getConnection();
			preparedstatement = connection.prepareStatement(sqlSelectAll);
			resultset = preparedstatement.executeQuery();
			int i=0;
			while(resultset.next()) {
				if(resultset.getInt("TINH_TRANG")!=0) {
					result[i]=""+resultset.getInt("MA_NV");
					i++;
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				preparedstatement.close();
				resultset.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public ArrayList<NhanVien> getNhanVienbyMaNV(NhanVien manv){
		ArrayList<NhanVien> result = new ArrayList<NhanVien>();
		String sqlSelectbyMANV ="select * from NHAN_VIEN where  MA_NV = ?";
		try {
			dbUtils = new DBUtils();
			connection = dbUtils.getConnection();
			preparedstatement = connection.prepareStatement(sqlSelectbyMANV);
			preparedstatement.setInt(1, manv.getMaNV());
			resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				if(resultset.getInt("TINH_TRANG")!=0) {
					NhanVien nv = new NhanVien();
					nv.setMaNV(resultset.getInt("MA_NV"));
					nv.setHoNV(resultset.getString("HO"));
					nv.setLotNV(resultset.getString("LOT"));
					nv.setTenNV(resultset.getString("TEN"));
					nv.setMaCV(resultset.getString("MA_CV"));
					nv.setCMND(resultset.getString("CMND"));
					nv.setDiachi(resultset.getString("DIA_CHI"));
					nv.setSdt(resultset.getString("SDT"));
					nv.setNamsinh(resultset.getInt("NAM_SINH"));
					nv.setTT(resultset.getInt("TINH_TRANG"));
					result.add(nv);
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				preparedstatement.close();
				resultset.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	public String getTenbyMaNV(int manv){
		String result ="";
		String sqlSelectbyMANV ="select * from NHAN_VIEN where  MA_NV = ?";
		try {
			dbUtils = new DBUtils();
			connection = dbUtils.getConnection();
			preparedstatement = connection.prepareStatement(sqlSelectbyMANV);
			preparedstatement.setInt(1, manv);
			resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				if(resultset.getInt("TINH_TRANG")!=0) {
					NhanVien nv = new NhanVien();
					nv.setMaNV(resultset.getInt("MA_NV"));
					nv.setHoNV(resultset.getString("HO"));
					nv.setLotNV(resultset.getString("LOT"));
					nv.setTenNV(resultset.getString("TEN"));
					nv.setMaCV(resultset.getString("MA_CV"));
					nv.setCMND(resultset.getString("CMND"));
					nv.setDiachi(resultset.getString("DIA_CHI"));
					nv.setSdt(resultset.getString("SDT"));
					nv.setNamsinh(resultset.getInt("NAM_SINH"));
					nv.setTT(resultset.getInt("TINH_TRANG"));
					result=nv.getHoTen();
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				preparedstatement.close();
				resultset.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public ArrayList<NhanVien> getNhanVienbyHoNV(String ho){
		ArrayList<NhanVien> result = new ArrayList<NhanVien>();
		String sqlSelectbyMANV ="select * from NHAN_VIEN where  HO= ?";
		try {
			dbUtils = new DBUtils();
			connection = dbUtils.getConnection();
			preparedstatement = connection.prepareStatement(sqlSelectbyMANV);
			preparedstatement.setString(1, ho);
			resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				if(resultset.getInt("TINH_TRANG")!=0) {
					NhanVien nv = new NhanVien();
					nv.setMaNV(resultset.getInt("MA_NV"));
					nv.setHoNV(resultset.getString("HO"));
					nv.setLotNV(resultset.getString("LOT"));
					nv.setTenNV(resultset.getString("TEN"));
					nv.setMaCV(resultset.getString("MA_CV"));
					nv.setCMND(resultset.getString("CMND"));
					nv.setDiachi(resultset.getString("DIA_CHI"));
					nv.setSdt(resultset.getString("SDT"));
					nv.setNamsinh(resultset.getInt("NAM_SINH"));
					nv.setTT(resultset.getInt("TINH_TRANG"));
					result.add(nv);
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				preparedstatement.close();
				resultset.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public ArrayList<NhanVien> getNhanVienbyTenNV(String ten){
		ArrayList<NhanVien> result = new ArrayList<NhanVien>();
		String sqlSelectbyMANV ="select * from NHAN_VIEN where  TEN= ?";
		try {
			dbUtils = new DBUtils();
			connection = dbUtils.getConnection();
			preparedstatement = connection.prepareStatement(sqlSelectbyMANV);
			preparedstatement.setString(1, ten);
			resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				if(resultset.getInt("TINH_TRANG")!=0) {
					NhanVien nv = new NhanVien();
					nv.setMaNV(resultset.getInt("MA_NV"));
					nv.setHoNV(resultset.getString("HO"));
					nv.setLotNV(resultset.getString("LOT"));
					nv.setTenNV(resultset.getString("TEN"));
					nv.setMaCV(resultset.getString("MA_CV"));
					nv.setCMND(resultset.getString("CMND"));
					nv.setDiachi(resultset.getString("DIA_CHI"));
					nv.setSdt(resultset.getString("SDT"));
					nv.setNamsinh(resultset.getInt("NAM_SINH"));
					nv.setTT(resultset.getInt("TINH_TRANG"));
					result.add(nv);
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				preparedstatement.close();
				resultset.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public ArrayList<NhanVien> getNhanVienbyChucVu(String chucvu){
		ArrayList<NhanVien> result = new ArrayList<NhanVien>();
		String sqlSelectbyMANV ="select * from NHAN_VIEN where  NHAN_VIEN.MA_CV = ?";
		try {
			dbUtils = new DBUtils();
			connection = dbUtils.getConnection();
			preparedstatement = connection.prepareStatement(sqlSelectbyMANV);
			preparedstatement.setString(1, chucvu);
			resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				if(resultset.getInt("TINH_TRANG")!=0) {
					NhanVien nv = new NhanVien();
					nv.setMaNV(resultset.getInt("MA_NV"));
					nv.setHoNV(resultset.getString("HO"));
					nv.setLotNV(resultset.getString("LOT"));
					nv.setTenNV(resultset.getString("TEN"));
					nv.setMaCV(resultset.getString("MA_CV"));
					nv.setCMND(resultset.getString("CMND"));
					nv.setDiachi(resultset.getString("DIA_CHI"));
					nv.setSdt(resultset.getString("SDT"));
					nv.setNamsinh(resultset.getInt("NAM_SINH"));
					nv.setTT(resultset.getInt("TINH_TRANG"));
					result.add(nv);
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				preparedstatement.close();
				resultset.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateNhanVien(NhanVien nhanvien) {
		int result = 0;
		 String sqlUpdate = "update NHAN_VIEN set HO = ?, LOT = ?, TEN = ?, MA_CV = ?, CMND = ? , DIA_CHI = ?, SDT = ?  , NAM_SINH = ?   where MA_NV = ?";
		 try {
			 dbUtils = new DBUtils();
			 connection = dbUtils.getConnection();
			 preparedstatement = connection.prepareStatement(sqlUpdate);
			 preparedstatement.setString(1, nhanvien.getHoNV());
			 preparedstatement.setString(2, nhanvien.getLotNV());
			 preparedstatement.setString(3, nhanvien.getTenNV());
			 preparedstatement.setString(4, nhanvien.getMaCV());
			 preparedstatement.setString(5, nhanvien.getCMND());
			 preparedstatement.setString(6, nhanvien.getDiachi());
			 preparedstatement.setString(7, nhanvien.getSdt());
			 preparedstatement.setInt(8, nhanvien.getNamsinh());
			 preparedstatement.setInt(9, nhanvien.getMaNV());
	         result = preparedstatement.executeUpdate();
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		 finally{
			 try {
				 connection.close();
				 preparedstatement.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
		 return result;
		
	}
	
	public int updateTT(NhanVien nhanvien) {
		int result = 0;
		 String sqlUpdate = "update NHAN_VIEN set TINH_TRANG = ?   where MA_NV = ?";
		 try {
			 dbUtils = new DBUtils();
			 connection = dbUtils.getConnection();
			 preparedstatement = connection.prepareStatement(sqlUpdate);
			 preparedstatement.setInt(1, nhanvien.getTT());
			 preparedstatement.setInt(2, nhanvien.getMaNV());
	         result = preparedstatement.executeUpdate();
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		 finally{
			 try {
				 connection.close();
				 preparedstatement.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
		 return result;
		
	}
	
	public int deleteNhanVien(NhanVien nhanvien) {
		int result = 0;
		 String sqlDelete = "delete from NHAN_VIEN where MA_NV = ?";
		 try {
			 dbUtils = new DBUtils();
			 connection = dbUtils.getConnection();
			 preparedstatement = connection.prepareStatement(sqlDelete);
			 preparedstatement.setInt(1, nhanvien.getMaNV());
	         result = preparedstatement.executeUpdate();
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		 finally{
			 try {
				 connection.close();
				 preparedstatement.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
		 return result;
		
	}
	
	
	
	public int insertNhanVien(NhanVien nhanvien) {
		int result = 0;
		 String sqlInsert = "insert into NHAN_VIEN(HO, LOT, TEN, MA_CV, CMND, DIA_CHI, SDT, NAM_SINH,TINH_TRANG) values (?, ?, ?, ?, ?, ?, ?, ?,?)";

		 try {
			 dbUtils = new DBUtils();
			 connection = dbUtils.getConnection();
			 preparedstatement = connection.prepareStatement(sqlInsert);
	         preparedstatement.setString(1, nhanvien.getHoNV());
			 preparedstatement.setString(2, nhanvien.getLotNV());
			 preparedstatement.setString(3, nhanvien.getTenNV());
			 preparedstatement.setString(4, nhanvien.getMaCV());
			 preparedstatement.setString(5, nhanvien.getCMND());
			 preparedstatement.setString(6, nhanvien.getDiachi());
			 preparedstatement.setString(7, nhanvien.getSdt());
			 preparedstatement.setInt(8, nhanvien.getNamsinh());
			 preparedstatement.setInt(9, 1);
	         result = preparedstatement.executeUpdate();
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		 finally{
			 try {
			 connection.close();
			 preparedstatement.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
		 return result;
		
	}
			

}
