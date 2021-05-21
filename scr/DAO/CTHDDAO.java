package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.CTHD;
import utils.DBUtils;

public class CTHDDAO {
	private DBUtils dbUltils = null;
	 private Connection connection = null;
	 private PreparedStatement preparedStatement = null;
	 private ResultSet resultSet = null;
	 
	 public ArrayList<CTHD> getAllCTHD(){
		 ArrayList<CTHD> result = new ArrayList<CTHD>();
		 String sqlSelectAll = "select * from CHI_TIET_HOA_DON";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 CTHD hd = new CTHD();
	        	 hd.setMaHD(resultSet.getString("MA_HD"));
	        	 hd.setMave(resultSet.getString("MA_VE"));
	        	 hd.setSl(resultSet.getInt("SO_LUONG"));
	        	 hd.setDonGia(resultSet.getInt("DON_GIA"));
	        	 hd.setThanhTien(resultSet.getInt("THANH_TIEN"));
		         result.add(hd);
	         }
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		 finally{
			 try {
				 connection.close();
				 preparedStatement.close();
				 resultSet.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
		 return result;
	 }
	 
	 public ArrayList<CTHD> getAllCTHDbyMaHD(CTHD hoadon)
	 {
		 ArrayList<CTHD> result = new ArrayList<CTHD>();
		 String sqlSelectAll = "select * from CHI_TIET_HOA_DON where MA_HD=?";
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, hoadon.getMaHD());
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 CTHD hd = new CTHD();
	        	 hd.setMaHD(resultSet.getString("MA_HD"));
	        	 hd.setMave(resultSet.getString("MA_VE"));
	        	 hd.setSl(resultSet.getInt("SO_LUONG"));
	        	 hd.setDonGia(resultSet.getInt("DON_GIA"));
	        	 hd.setThanhTien(resultSet.getInt("THANH_TIEN"));
		         result.add(hd);
	         }
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		 finally{
			 try {
				 connection.close();
				 preparedStatement.close();
				 resultSet.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
		 return result;
	 }
	 
	 public ArrayList<CTHD> getAllCTHDbyMaVe(CTHD hoadon){
		 ArrayList<CTHD> result = new ArrayList<CTHD>();
		 String sqlSelectAll = "select * from CHI_TIET_HOA_DON where MA_VE=?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, hoadon.getMave());
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 CTHD hd = new CTHD();
	        	 hd.setMaHD(resultSet.getString("MA_HD"));
	        	 hd.setMave(resultSet.getString("MA_VE"));
	        	 hd.setSl(resultSet.getInt("SO_LUONG"));
	        	 hd.setDonGia(resultSet.getInt("DON_GIA"));
	        	 hd.setThanhTien(resultSet.getInt("THANH_TIEN"));
		         result.add(hd);
	         }
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		 finally{
			 try {
				 connection.close();
				 preparedStatement.close();
				 resultSet.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
		 return result;
	 }
	 
	 public int deleteCTHD(CTHD hoadon){
		 int result = 0;
		 String sqlDelete = "delete from CHI_TIET_HOA_DON where MA_HD = ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlDelete);
	         preparedStatement.setString(1, hoadon.getMaHD());
	         result = preparedStatement.executeUpdate();
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		 finally{
			 try {
			 connection.close();
			 preparedStatement.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
		 	}
		 }
		 return result;
	 }
	 	 
	 public int insertCTHD(CTHD hoadon){
		 int result = 0;
		 String sqlUpdate = "insert into CHI_TIET_HOA_DON(MA_HD, MA_VE, SO_LUONG,DON_GIA,THANH_TIEN) values (?, ?, ?,?,? )";

		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlUpdate);
	         preparedStatement.setString(1, hoadon.getMaHD());
	         preparedStatement.setString(2, hoadon.getMave());
	         preparedStatement.setInt(3, hoadon.getSl());
	        
	         preparedStatement.setInt(4 ,hoadon.getDonGia());
	         preparedStatement.setInt(5, hoadon.getDonGia()*hoadon.getSl());
	         
	         result = preparedStatement.executeUpdate();
		 }catch (SQLException e) { 
			 e.printStackTrace();
		 }
		 finally{
			 try {
				 connection.close();
				 preparedStatement.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
		 return result;
	 }

	 
}
