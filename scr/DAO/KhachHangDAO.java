package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.KhachHang;
import utils.DBUtils;

public class KhachHangDAO {
	private DBUtils dbUtils = null;
	private Connection connection =null;
	private PreparedStatement preparedstatement =null;
	private ResultSet resultset = null;
	
	public ArrayList<KhachHang> getAllKhachHang(){
		ArrayList<KhachHang> result = new ArrayList<KhachHang>();
		String sqlSelectAll ="select * from KHACH_HANG";
		try {
			dbUtils = new DBUtils();
			connection = dbUtils.getConnection();
			preparedstatement = connection.prepareStatement(sqlSelectAll);
			resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				if(resultset.getInt("TINH_TRANG")!=0) {
					KhachHang kh = new KhachHang();
					kh.setMaKH(resultset.getInt("MA_KH"));
					kh.setCmnd(resultset.getString("CMND"));
					kh.setHoKH(resultset.getString("HO"));
					kh.setLotKH(resultset.getString("LOT"));
					kh.setTenKH(resultset.getString("TEN"));
					kh.setSdt(resultset.getString("SDT"));
					kh.setDiaChi(resultset.getString("DIA_CHI"));
					kh.setNamSinh(resultset.getInt("NAM_SINH"));
					kh.setTT(resultset.getInt("TINH_TRANG"));
					result.add(kh);
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
	public ArrayList<KhachHang> getKhachHangbyMaKH(KhachHang khang){
		ArrayList<KhachHang> result = new ArrayList<KhachHang>();
		String sqlSelectbyMANV ="select * from KHACH_HANG where  MA_KH = ?";
		try {
			dbUtils = new DBUtils();
			connection = dbUtils.getConnection();
			preparedstatement = connection.prepareStatement(sqlSelectbyMANV);
			preparedstatement.setInt(1, khang.getMaKH());
			resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				if(resultset.getInt("TINH_TRANG")!=0) {
					KhachHang kh = new KhachHang();
					kh.setMaKH(resultset.getInt("MA_KH"));
					kh.setCmnd(resultset.getString("CMND"));
					kh.setHoKH(resultset.getString("HO"));
					kh.setLotKH(resultset.getString("LOT"));
					kh.setTenKH(resultset.getString("TEN"));
					kh.setDiaChi(resultset.getString("DIA_CHI"));
					kh.setSdt(resultset.getString("SDT"));
					kh.setNamSinh(resultset.getInt("NAM_SINH"));
					kh.setTT(resultset.getInt("TINH_TRANG"));
					result.add(kh);
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
	public KhachHang getKhachHangbyMaKH(int maKH){
		KhachHang kh = new KhachHang();
		String sqlSelectbyMANV ="select * from KHACH_HANG where  MA_KH = ?";
		try {
			dbUtils = new DBUtils();
			connection = dbUtils.getConnection();
			preparedstatement = connection.prepareStatement(sqlSelectbyMANV);
			preparedstatement.setInt(1, maKH);
			resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				if(resultset.getInt("TINH_TRANG")!=0) {
					kh.setMaKH(resultset.getInt("MA_KH"));
					kh.setCmnd(resultset.getString("CMND"));
					kh.setHoKH(resultset.getString("HO"));
					kh.setLotKH(resultset.getString("LOT"));
					kh.setTenKH(resultset.getString("TEN"));
					kh.setSdt(resultset.getString("SDT"));
					kh.setDiaChi(resultset.getString("DIA_CHI"));
					kh.setNamSinh(resultset.getInt("NAM_SINH"));
					kh.setTT(resultset.getInt("TINH_TRANG"));
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
		return kh;
	}
	
	public ArrayList<KhachHang> getKhachHangbyCMND(String cmnd){
		ArrayList<KhachHang> result = new ArrayList<KhachHang>();
		String sqlSelectbyMANV ="select * from KHACH_HANG where  CMND = ?";
		try {
			dbUtils = new DBUtils();
			connection = dbUtils.getConnection();
			preparedstatement = connection.prepareStatement(sqlSelectbyMANV);
			preparedstatement.setString(1, cmnd);
			resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				if(resultset.getInt("TINH_TRANG")!=0) {
					KhachHang kh = new KhachHang();
					kh.setMaKH(resultset.getInt("MA_KH"));
					kh.setCmnd(resultset.getString("CMND"));
					kh.setHoKH(resultset.getString("HO"));
					kh.setLotKH(resultset.getString("LOT"));
					kh.setTenKH(resultset.getString("TEN"));
					kh.setSdt(resultset.getString("SDT"));
					kh.setDiaChi(resultset.getString("DIA_CHI"));
					kh.setNamSinh(resultset.getInt("NAM_SINH"));
					kh.setTT(resultset.getInt("TINH_TRANG"));
					result.add(kh);
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
	
	
	public ArrayList<KhachHang> getKhachHangbyHo(String ho){
		ArrayList<KhachHang> result = new ArrayList<KhachHang>();
		String sqlSelectbyMANV ="select * from KHACH_HANG where  HO= ?";
		try {
			dbUtils = new DBUtils();
			connection = dbUtils.getConnection();
			preparedstatement = connection.prepareStatement(sqlSelectbyMANV);
			preparedstatement.setString(1, ho);
			resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				if(resultset.getInt("TINH_TRANG")!=0) {
					KhachHang kh = new KhachHang();
					kh.setMaKH(resultset.getInt("MA_KH"));
					kh.setCmnd(resultset.getString("CMND"));
					kh.setHoKH(resultset.getString("HO"));
					kh.setLotKH(resultset.getString("LOT"));
					kh.setTenKH(resultset.getString("TEN"));
					kh.setDiaChi(resultset.getString("DIA_CHI"));
					kh.setSdt(resultset.getString("SDT"));
					kh.setNamSinh(resultset.getInt("NAM_SINH"));
					kh.setTT(resultset.getInt("TINH_TRANG"));
					result.add(kh);
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
	
	public ArrayList<KhachHang> getKhachHangbyTen(String ten){
		ArrayList<KhachHang> result = new ArrayList<KhachHang>();
		String sqlSelectbyMANV ="select * from KHACH_HANG where  TEN= ?";
		try {
			dbUtils = new DBUtils();
			connection = dbUtils.getConnection();
			preparedstatement = connection.prepareStatement(sqlSelectbyMANV);
			preparedstatement.setString(1, ten);
			resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				if(resultset.getInt("TINH_TRANG")!=0) {
					KhachHang kh = new KhachHang();
					kh.setMaKH(resultset.getInt("MA_KH"));
					kh.setCmnd(resultset.getString("CMND"));
					kh.setHoKH(resultset.getString("HO"));
					kh.setLotKH(resultset.getString("LOT"));
					kh.setTenKH(resultset.getString("TEN"));
					kh.setSdt(resultset.getString("SDT"));
					kh.setDiaChi(resultset.getString("DIA_CHI"));
					kh.setNamSinh(resultset.getInt("NAM_SINH"));
					kh.setTT(resultset.getInt("TINH_TRANG"));
					result.add(kh);
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
	
	
	public int updateKhachHang(KhachHang khachhang) {
		int result = 0;
		 String sqlUpdate = "update KHACH_HANG set CMND = ?, HO = ?, LOT = ?, TEN = ?, SDT = ?, NAM_SINH = ? ,DIA_CHI = ?  where MA_KH = ?";
		 try {
			 dbUtils = new DBUtils();
			 connection = dbUtils.getConnection();
			 preparedstatement = connection.prepareStatement(sqlUpdate);
			 preparedstatement.setString(1, khachhang.getCmnd());
			 preparedstatement.setString(2, khachhang.getHoKH());
			 preparedstatement.setString(3, khachhang.getLotKH());
			 preparedstatement.setString(4, khachhang.getTenKH());
			 preparedstatement.setString(5, khachhang.getSdt());
			 preparedstatement.setInt(6, khachhang.getNamSinh());
			 preparedstatement.setInt(8, khachhang.getMaKH());
			 preparedstatement.setString(7, khachhang.getDiaChi());
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
	
	public int updateTT(KhachHang khachhang) {
		int result = 0;
		 String sqlUpdate = "update KHACH_HANG set TINH_TRANG = ?   where MA_KH = ?";
		 try {
			 dbUtils = new DBUtils();
			 connection = dbUtils.getConnection();
			 preparedstatement = connection.prepareStatement(sqlUpdate);
			 preparedstatement.setInt(1, khachhang.getTT());
			 preparedstatement.setInt(2, khachhang.getMaKH());
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
	
	public int deleteKhachHang(KhachHang khachhang) {
		int result = 0;
		 String sqlDelete = "delete from KHACH_HANG where MA_KH = ?";
		 try {
			 dbUtils = new DBUtils();
			 connection = dbUtils.getConnection();
			 preparedstatement = connection.prepareStatement(sqlDelete);
			 preparedstatement.setInt(1, khachhang.getMaKH());
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
	
	public int insertKhachHang(KhachHang khachhang) {
		int result = 0;
		 String sqlInsert = "insert into KHACH_HANG(CMND, HO, LOT, TEN, SDT, NAM_SINH,TINH_TRANG,DIA_CHI) values (?, ?, ?, ?, ?, ?,?,?)";
		 try {
			 dbUtils = new DBUtils();
			 connection = dbUtils.getConnection();
			 preparedstatement = connection.prepareStatement(sqlInsert);
			 preparedstatement.setString(1, khachhang.getCmnd());
			 preparedstatement.setString(2, khachhang.getHoKH());
			 preparedstatement.setString(3, khachhang.getLotKH());
			 preparedstatement.setString(4, khachhang.getTenKH());
			 preparedstatement.setString(5, khachhang.getSdt());
			 preparedstatement.setInt(6, khachhang.getNamSinh());
			 preparedstatement.setInt(7, 1);
			 preparedstatement.setString(8, khachhang.getDiaChi());
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
	
	public int checkTF(KhachHang kh){
		int result = 0;
		String sqlSelectbyMANV ="select * from KHACH_HANG where  MA_KH = ? AND TINH_TRANG <> 0";
		try {
			dbUtils = new DBUtils();
			connection = dbUtils.getConnection();
			preparedstatement = connection.prepareStatement(sqlSelectbyMANV);
			preparedstatement.setInt(1, kh.getMaKH());
			resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				if(resultset.getInt("TINH_TRANG")!=0)
					result=1;
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
			

}
