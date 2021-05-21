package DAO.Thongke;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Thongke.TKDB;
import utils.DBUtils;

public class TKDBDAO {
	private DBUtils dbUltils = null;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public ArrayList<TKDB> getAll(){
		 ArrayList<TKDB> result = new ArrayList<TKDB>();
		 String sqlSelectAll = "select DB.MA_DB, COUNT( MA_VE ) as SL \r\n"
		 		+ "from CHUYEN_BAY as CB ,DUONG_BAY as DB,VE\r\n"
		 		+ "where\r\n"
		 		+ "	DB.MA_DB= CB.MA_DB and CB.MA_CB= VE.MA_CB and VE.MA_KH <> 0 and VE.TINH_TRANG <> 0 \r\n"
		 		+ "group by DB.MA_DB";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 TKDB db=new TKDB();
	        	 db.setMaDB(resultSet.getString("MA_DB"));
	        	 db.setSlve(resultSet.getInt("SL"));
			         result.add(db);
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
    public ArrayList<TKDB> getAllGiam(){
    	ArrayList<TKDB> result = new ArrayList<TKDB>();
		 String sqlSelectAll = "select DB.MA_DB, COUNT( MA_VE ) as SL \r\n"
		 		+ "from CHUYEN_BAY as CB ,DUONG_BAY as DB,VE\r\n"
		 		+ "where\r\n"
		 		+ "	DB.MA_DB= CB.MA_DB and CB.MA_CB= VE.MA_CB and VE.MA_KH <> 0 and VE.TINH_TRANG <> 0\r\n"
		 		+ "group by DB.MA_DB order by SL DESC";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 TKDB db=new TKDB();
	        	 db.setMaDB(resultSet.getString("MA_DB"));
	        	 db.setSlve(resultSet.getInt("SL"));
			         result.add(db);
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
    public ArrayList<TKDB> getAllTang(){
    	ArrayList<TKDB> result = new ArrayList<TKDB>();
		 String sqlSelectAll = "select DB.MA_DB, COUNT( MA_VE ) as SL \r\n"
			 		+ "from CHUYEN_BAY as CB ,DUONG_BAY as DB,VE\r\n"
			 		+ "where\r\n"
			 		+ "	DB.MA_DB= CB.MA_DB and CB.MA_CB= VE.MA_CB and VE.MA_KH <> 0 and  VE.TINH_TRANG <> 0\r\n"
			 		+ "group by DB.MA_DB order by SL ASC";
			
			 try {
				 dbUltils = new DBUtils();
				 connection = dbUltils.getConnection();
		         preparedStatement = connection.prepareStatement(sqlSelectAll);
		         resultSet = preparedStatement.executeQuery();
		         while(resultSet.next()){
		        	 TKDB db=new TKDB();
		        	 db.setMaDB(resultSet.getString("MA_DB"));
		        	 db.setSlve(resultSet.getInt("SL"));
				         result.add(db);
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
    public ArrayList<TKDB> getAllbyma(String madb){
    	ArrayList<TKDB> result = new ArrayList<TKDB>();
		 String sqlSelectAll = "select DB.MA_DB, COUNT( MA_VE ) as SL \r\n"
		 		+ "from CHUYEN_BAY as CB ,DUONG_BAY as DB,VE \r\n"
		 		+ "where\r\n"
		 		+ "	DB.MA_DB= CB.MA_DB and CB.MA_CB= VE.MA_CB and VE.MA_KH <> 0 and DB.MA_DB= ? and VE.TINH_TRANG <> 0\r\n"
		 		+ "group by DB.MA_DB";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, madb);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 TKDB db=new TKDB();
	        	 db.setMaDB(resultSet.getString("MA_DB"));
	        	 db.setSlve(resultSet.getInt("SL"));
			         result.add(db);
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
