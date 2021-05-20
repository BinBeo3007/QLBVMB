package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ChuyenBay;
import DTO.Ve;
import utils.DBUtils;

public class VeDAO {
	private DBUtils dbUltils = null;
	 private Connection connection = null;
	 private PreparedStatement preparedStatement = null;
	 private ResultSet resultSet = null;
	 
	 public ArrayList<Ve> getAllVe(){
		 ArrayList<Ve> result = new ArrayList<Ve>();
		 String sqlSelectAll = "select * from VE";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 Ve ve = new Ve();
		        	 ve.setMaCB(resultSet.getString("MA_CB"));
		        	 ve.setMaVe(resultSet.getString("MA_VE"));
		        	 ve.setMaKH(resultSet.getInt("MA_KH"));
		        	 ve.setNgayDat(resultSet.getString("NGAY_DAT"));
		        	 ve.setLoaiGhe(resultSet.getInt("LOAI_VE"));
		        	 ve.setGiaTien(resultSet.getInt("GIA_TIEN"));
		        	 ve.setTinhTrang(resultSet.getInt("TINH_TRANG"));
			         result.add(ve);
	        	 }
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
	 public ArrayList<Ve> getVebymaVe(Ve v){
		 ArrayList<Ve> result = new ArrayList<Ve>();
		 String sqlSelectAll = "select * from VE where MA_VE= ?";

		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, v.getMaVe());
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){ 
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 Ve ve = new Ve();
		        	 ve.setMaCB(resultSet.getString("MA_CB"));
		        	 ve.setMaVe(resultSet.getString("MA_VE"));
		        	 ve.setMaKH(resultSet.getInt("MA_KH"));
		        	 ve.setNgayDat(resultSet.getString("NGAY_DAT"));
		        	 ve.setLoaiGhe(resultSet.getInt("LOAI_VE"));
		        	 ve.setGiaTien(resultSet.getInt("GIA_TIEN"));
		        	 ve.setTinhTrang(resultSet.getInt("TINH_TRANG"));
			         result.add(ve);
	        	 }
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
	 public ArrayList<Ve> getVebymaCB(Ve v){
		 ArrayList<Ve> result = new ArrayList<Ve>();
		 String sqlSelectAll = "select * from VE where MA_CB= ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, v.getMaCB());
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 Ve ve = new Ve();
		        	 ve.setMaCB(resultSet.getString("MA_CB"));
		        	 ve.setMaVe(resultSet.getString("MA_VE"));
		        	 ve.setMaKH(resultSet.getInt("MA_KH"));
		        	 ve.setNgayDat(resultSet.getString("NGAY_DAT"));
		        	 ve.setLoaiGhe(resultSet.getInt("LOAI_VE"));
		        	 ve.setGiaTien(resultSet.getInt("GIA_TIEN"));
		        	 ve.setTinhTrang(resultSet.getInt("TINH_TRANG"));
			         result.add(ve);
	        	 }
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
	 public ArrayList<Ve> getVebymaCBKH(Ve v){
		 ArrayList<Ve> result = new ArrayList<Ve>();
		 String sqlSelectAll = "select * from VE where MA_VE= ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, v.getMaVe());
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 Ve ve = new Ve();
		        	 ve.setMaCB(resultSet.getString("MA_CB"));
		        	 ve.setMaVe(resultSet.getString("MA_VE"));
		        	 ve.setMaKH(resultSet.getInt("MA_KH"));
		        	 ve.setNgayDat(resultSet.getString("NGAY_DAT"));
		        	 ve.setLoaiGhe(resultSet.getInt("LOAI_VE"));
		        	 ve.setGiaTien(resultSet.getInt("GIA_TIEN"));
		        	 ve.setTinhTrang(resultSet.getInt("TINH_TRANG"));
			         result.add(ve);
	        	 }
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
	 
	 public int getGiabyLoai(Ve v){
		 int result=0;
		 String sqlSelectAll = "select * from VE where LOAI_VE= ? and MA_CB =?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setInt(1, v.getLoaiGhe());
	         preparedStatement.setString(2, v.getMaCB());
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 result=resultSet.getInt("GIA_TIEN");
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
	 
	 public Ve getGiabyMaCBLoai(Ve v){
		 Ve result=new Ve();
		 String sqlSelectAll = "select * from VE where LOAI_VE= ? and MA_CB =?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setInt(1, v.getLoaiGhe());
	         preparedStatement.setString(2, v.getMaCB());
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
		        	 result.setMaCB(resultSet.getString("MA_CB"));
		        	 result.setMaVe(resultSet.getString("MA_VE"));
		        	 result.setMaKH(resultSet.getInt("MA_KH"));
		        	 result.setNgayDat(resultSet.getString("NGAY_DAT"));
		        	 result.setLoaiGhe(resultSet.getInt("LOAI_VE"));
		        	 result.setGiaTien(resultSet.getInt("GIA_TIEN"));
		        	 result.setTinhTrang(resultSet.getInt("TINH_TRANG"));
		        	 return result;
	        	 }
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
	 
	 public ArrayList<Ve> getVebymaKH(Ve v){
		 ArrayList<Ve> result = new ArrayList<Ve>();
		 String sqlSelectAll = "select * from VE where MA_KH= ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setInt(1, v.getMaKH());
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 Ve ve = new Ve();
		        	 ve.setMaCB(resultSet.getString("MA_CB"));
		        	 ve.setMaVe(resultSet.getString("MA_VE"));
		        	 ve.setMaKH(resultSet.getInt("MA_KH"));
		        	 ve.setNgayDat(resultSet.getString("NGAY_DAT"));
		        	 ve.setLoaiGhe(resultSet.getInt("LOAI_VE"));
		        	 ve.setGiaTien(resultSet.getInt("GIA_TIEN"));
		        	 ve.setTinhTrang(resultSet.getInt("TINH_TRANG"));
			         result.add(ve);
	        	 }
	        	 
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
	 

	 
	 public int updateVe(Ve ve){
		 int result = 0;
		 String sql = "update   VE set MA_KH=?,NGAY_DAT=?,TINH_TRANG=?  where MA_VE= ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sql);
	         preparedStatement.setInt(1, ve.getMaKH());
	         preparedStatement.setString(2, ve.getNgayDat());
	         preparedStatement.setInt(3, ve.getTinhTrang());
	         preparedStatement.setString(4, ve.getMaVe());
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
	 
	 public int updateGiaVe(Ve ve){
		 int result = 0;
		 String sql = "update   VE set GIA_TIEN=?  where MA_CB= ? and LOAI_VE=?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sql);
	         preparedStatement.setInt(1, ve.getGiaTien());
	         preparedStatement.setString(2, ve.getMaCB());
	         preparedStatement.setInt(3, ve.getLoaiGhe());
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
	 
	 
	 
	 public int insertVe(Ve ve){
		 int result = 0;
		 String sql = "insert into VE(MA_VE, MA_CB, MA_KH,NGAY_DAT,LOAI_VE,GIA_TIEN,TINH_TRANG) values (?, ?, ?,?,?,?,? )";

		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
			 preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setString(1, ve.getMaVe());
			 preparedStatement.setString(2, ve.getMaCB());
			 preparedStatement.setInt(3, ve.getMaKH());
	         preparedStatement.setString(4, ve.getNgayDat());
	         preparedStatement.setInt(5, ve.getLoaiGhe());
	         preparedStatement.setInt(6, ve.getGiaTien());
	         preparedStatement.setInt(7, ve.getTinhTrang());
	         
	         
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
	 
	 public int deleteVe(Ve ve){
		 int result = 0;
		 String sqlDelete = "update   VE set TINH_TRANG=0  where MA_CB = ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlDelete);
	         preparedStatement.setString(1, ve.getMaCB());
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
	 
	 public int deleteVebymave(Ve ve){
		 int result = 0;
		 String sqlDelete = "update   VE set TINH_TRANG=0  where MA_VE = ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlDelete);
	         preparedStatement.setString(1, ve.getMaVe());
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
	 
	 
	 public int getsoghedadatByloaimaMB(Ve v) {
		 int result=0;
		 String sqlSelectAll = "select * from VE where LOAI_VE= ? and MA_CB =? ";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setInt(1, v.getLoaiGhe());
	         preparedStatement.setString(2, v.getMaCB());
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 int temp= resultSet.getInt("MA_KH");
		        	 if(temp!= 0)
		        		 result++;
	        	 }
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
		 System.out.print(result);
		 return result;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
