package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ChuyenBay;
import utils.DBUtils;

public class ChuyenBayDAO {
	private DBUtils dbUltils = null;
	 private Connection connection = null;
	 private PreparedStatement preparedStatement = null;
	 private ResultSet resultSet = null;
	 
	 public ArrayList<ChuyenBay> getAllCB(){
		 ArrayList<ChuyenBay> result = new ArrayList<ChuyenBay>();
		 String sqlSelectAll = "select * from CHUYEN_BAY";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 ChuyenBay cb = new ChuyenBay();
		        	 cb.setMaCB(resultSet.getString("MA_CB"));
		        	 cb.setMaMB(resultSet.getString("MA_MB"));
		        	 cb.setMaDB(resultSet.getString("MA_DB"));
		        	 cb.setGioBay(resultSet.getString("GIO_BAY"));
		        	 cb.setNgayDi(resultSet.getString("NGAY_DI"));
		        	 cb.setNgayDen(resultSet.getString("NGAY_DEN"));
		        	 cb.setSogheloai1(resultSet.getInt("SO_GHE_LOAI_1"));
		        	 cb.setSogheloa2(resultSet.getInt("SO_GHE_LOAI_2"));
		        	 cb.setTT(resultSet.getInt("TINH_TRANG"));
			         result.add(cb);
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
	 public int getslCB(){
		 int result = 0;
		 String sqlSelectAll = "select * from CHUYEN_BAY";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	result++;
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
	 public ChuyenBay getAllCBbymaCB(String maCB){
		ChuyenBay cb = new ChuyenBay();
		 String sqlSelectAll = "select * from CHUYEN_BAY where MA_CB= ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, maCB);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
		        	 cb.setMaCB(resultSet.getString("MA_CB"));
		        	 cb.setMaMB(resultSet.getString("MA_MB"));
		        	 cb.setMaDB(resultSet.getString("MA_DB"));
		        	 cb.setGioBay(resultSet.getString("GIO_BAY"));
		        	 cb.setNgayDi(resultSet.getString("NGAY_DI"));
		        	 cb.setNgayDen(resultSet.getString("NGAY_DEN"));
		        	 cb.setSogheloai1(resultSet.getInt("SO_GHE_LOAI_1"));
		        	 cb.setSogheloa2(resultSet.getInt("SO_GHE_LOAI_2"));
		        	 cb.setTT(resultSet.getInt("TINH_TRANG"));
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
		 return cb;
	 }
	 
	 public ArrayList<ChuyenBay> getAllCBbymaDB(ChuyenBay chuyenbay){
		 ArrayList<ChuyenBay> result = new ArrayList<ChuyenBay>();
		 String sqlSelectAll = "select * from CHUYEN_BAY where MA_DB= ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, chuyenbay.getMaDB());
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 ChuyenBay cb = new ChuyenBay();
		        	 cb.setMaCB(resultSet.getString("MA_CB"));
		        	 cb.setMaMB(resultSet.getString("MA_MB"));
		        	 cb.setMaDB(resultSet.getString("MA_DB"));
		        	 cb.setGioBay(resultSet.getString("GIO_BAY"));
		        	 cb.setNgayDi(resultSet.getString("NGAY_DI"));
		        	 cb.setNgayDen(resultSet.getString("NGAY_DEN"));
		        	 cb.setSogheloai1(resultSet.getInt("SO_GHE_LOAI_1"));
		        	 cb.setSogheloa2(resultSet.getInt("SO_GHE_LOAI_2"));
		        	 cb.setTT(resultSet.getInt("TINH_TRANG"));
			         result.add(cb);
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
	 
	 public ArrayList<ChuyenBay> getAllCBbymaDBDi(ChuyenBay chuyenbay){
		 ArrayList<ChuyenBay> result = new ArrayList<ChuyenBay>();
		 String sqlSelectAll = "select * from CHUYEN_BAY where MA_DB= ? and NGAY_DI=?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, chuyenbay.getMaDB());
	         preparedStatement.setString(2, chuyenbay.getNgayDi());
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 ChuyenBay cb = new ChuyenBay();
		        	 cb.setMaCB(resultSet.getString("MA_CB"));
		        	 cb.setMaMB(resultSet.getString("MA_MB"));
		        	 cb.setMaDB(resultSet.getString("MA_DB"));
		        	 cb.setGioBay(resultSet.getString("GIO_BAY"));
		        	 cb.setNgayDi(resultSet.getString("NGAY_DI"));
		        	 cb.setNgayDen(resultSet.getString("NGAY_DEN"));
		        	 cb.setSogheloai1(resultSet.getInt("SO_GHE_LOAI_1"));
		        	 cb.setSogheloa2(resultSet.getInt("SO_GHE_LOAI_2"));
		        	 cb.setTT(resultSet.getInt("TINH_TRANG"));
			         result.add(cb);
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
	 
	 public ArrayList<ChuyenBay> getAllCBbyngayDi(ChuyenBay chuyenbay){
		 ArrayList<ChuyenBay> result = new ArrayList<ChuyenBay>();
		 String sqlSelectAll = "select * from CHUYEN_BAY where NGAY_DI= ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, chuyenbay.getNgayDi());
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 ChuyenBay cb = new ChuyenBay();
		        	 cb.setMaCB(resultSet.getString("MA_CB"));
		        	 cb.setMaMB(resultSet.getString("MA_MB"));
		        	 cb.setMaDB(resultSet.getString("MA_DB"));
		        	 cb.setGioBay(resultSet.getString("GIO_BAY"));
		        	 cb.setNgayDi(resultSet.getString("NGAY_DI"));
		        	 cb.setNgayDen(resultSet.getString("NGAY_DEN"));
		        	 cb.setSogheloai1(resultSet.getInt("SO_GHE_LOAI_1"));
		        	 cb.setSogheloa2(resultSet.getInt("SO_GHE_LOAI_2"));
		        	 cb.setTT(resultSet.getInt("TINH_TRANG"));
			         result.add(cb);
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
	 
	 public ArrayList<ChuyenBay> getAllCBbyngayDi_MaCB(ChuyenBay chuyenbay){
		 ArrayList<ChuyenBay> result = new ArrayList<ChuyenBay>();
		 String sqlSelectAll = "select * from CHUYEN_BAY where NGAY_DI= ? and MA_CB= ? ";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, chuyenbay.getNgayDi());
	         preparedStatement.setString(2, chuyenbay.getNgayDi());
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 ChuyenBay cb = new ChuyenBay();
		        	 cb.setMaCB(resultSet.getString("MA_CB"));
		        	 cb.setMaMB(resultSet.getString("MA_MB"));
		        	 cb.setMaDB(resultSet.getString("MA_DB"));
		        	 cb.setGioBay(resultSet.getString("GIO_BAY"));
		        	 cb.setNgayDi(resultSet.getString("NGAY_DI"));
		        	 cb.setNgayDen(resultSet.getString("NGAY_DEN"));
		        	 cb.setSogheloai1(resultSet.getInt("SO_GHE_LOAI_1"));
		        	 cb.setSogheloa2(resultSet.getInt("SO_GHE_LOAI_2"));
		        	 cb.setTT(resultSet.getInt("TINH_TRANG"));
			         result.add(cb);
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
	 
	 public int deleteChuyenBay(ChuyenBay chuyenbay){
		 int result = 0;
		 String sqlDelete = "update CHUYEN_BAY  set TINH_TRANG = ? where MA_CB = ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlDelete);
	         preparedStatement.setInt(1, 0);
	         preparedStatement.setString(2, chuyenbay.getMaCB());
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
	 
	 public int insertChuyenBay(ChuyenBay chuyenbay){
		 int result = 0;
		 String sql = "insert into CHUYEN_BAY (MA_CB,MA_MB,MA_DB,GIO_BAY,NGAY_DI,NGAY_DEN,SO_GHE_LOAI_1,SO_GHE_LOAI_2,TINH_TRANG ) values (?, ?, ?,?,?,?,?,?,?)";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sql);
	         preparedStatement.setString(1, chuyenbay.getMaCB());
	         preparedStatement.setString(2, chuyenbay.getMaMB());
	         preparedStatement.setString(3, chuyenbay.getMaDB());
	         preparedStatement.setString(4, chuyenbay.getGioBay());
	         preparedStatement.setString(5, chuyenbay.getNgayDi());
	         preparedStatement.setString(6, chuyenbay.getNgayDen());
	         preparedStatement.setInt(7, chuyenbay.getSogheloai1());
	         preparedStatement.setInt(8, chuyenbay.getSogheloa2());
	         preparedStatement.setInt(9, 1);
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
	 
	 public int updateChuyenBay(ChuyenBay chuyenbay){
		 int result = 0;
		 String sql = "update   CHUYEN_BAY set MA_MB=?,MA_DB=?,GIO_BAY=?,NGAY_DI=?,NGAY_DEN=?,SO_GHE_LOAI_1=?,SO_GHE_LOAI_2=?  where MA_CB= ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sql);
	         preparedStatement.setString(8, chuyenbay.getMaCB());
	         preparedStatement.setString(1, chuyenbay.getMaMB());
	         preparedStatement.setString(2, chuyenbay.getMaDB());
	         preparedStatement.setString(3, chuyenbay.getGioBay());
	         preparedStatement.setString(4, chuyenbay.getNgayDi());
	         preparedStatement.setString(5, chuyenbay.getNgayDen());
	         preparedStatement.setInt(6, chuyenbay.getSogheloai1());
	         preparedStatement.setInt(7, chuyenbay.getSogheloa2());
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
	  public int checkTF(ChuyenBay cb) {
		  int result =0;
		  String sqlSelectAll = "select * from CHUYEN_BAY where MA_CB= ?";
			
			 try {
				 dbUltils = new DBUtils();
				 connection = dbUltils.getConnection();
		         preparedStatement = connection.prepareStatement(sqlSelectAll);
		         preparedStatement.setString(1, cb.getMaCB());
		         resultSet = preparedStatement.executeQuery();
		         while(resultSet.next()){
		        	 result=1;
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

}
