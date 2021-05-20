package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DuongBay;
import utils.DBUtils;

public class DuongBayDAO {
	 private DBUtils dbUltils = null;
	 private Connection connection = null;
	 private PreparedStatement preparedStatement = null;
	 private ResultSet resultSet = null;
	 

	 public ArrayList<DuongBay> getAllDB(){
		 ArrayList<DuongBay> result = new ArrayList<DuongBay>();
		 String sqlSelectAll = "select * from DUONG_BAY";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 DuongBay db = new DuongBay();
	        	 db.setMaDB(resultSet.getString("MA_DB"));
	        	 db.setMaSBdi(resultSet.getString("MA_SB_DI"));
	        	 db.setMaSBDen(resultSet.getString("MA_SB_DEN"));
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
	 public String[] getMaDB(){
		 String[] result = new String[99];
		 String sqlSelectAll = "select * from DUONG_BAY";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         int i=0;
	         while(resultSet.next()){
	        	result[i]=resultSet.getString("MA_DB").trim();
	        	i++;
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
	 
	 public ArrayList<DuongBay> getDB(String maDB){
		 ArrayList<DuongBay> result = new ArrayList<DuongBay>();
		 String sqlSelectAll = "select * from DUONG_BAY where MA_DB = ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, maDB);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 DuongBay db = new DuongBay();
	        	 db.setMaDB(resultSet.getString("MA_DB"));
	        	 db.setMaSBdi(resultSet.getString("MA_SB_DEN"));
	        	 db.setMaSBDen(resultSet.getString("MA_SB_DI"));
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
	 
	 public ArrayList<DuongBay> getDBbySBDi(String masbDi){
		 ArrayList<DuongBay> result = new ArrayList<DuongBay>();
		 String sqlSelectAll = "select * from DUONG_BAY where MA_SB_DI = ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, masbDi);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 DuongBay db = new DuongBay();
	        	 db.setMaDB(resultSet.getString("MA_DB"));
	        	 db.setMaSBdi(resultSet.getString("MA_SB_DEN"));
	        	 db.setMaSBDen(resultSet.getString("MA_SB_DI"));
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
	 
	 public ArrayList<DuongBay> getDBbySBDen(String masbVe){
		 ArrayList<DuongBay> result = new ArrayList<DuongBay>();
		 String sqlSelectAll = "select * from DUONG_BAY where MA_SB_DEN = ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, masbVe);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 DuongBay db = new DuongBay();
	        	 db.setMaDB(resultSet.getString("MA_DB"));
	        	 db.setMaSBdi(resultSet.getString("MA_SB_DI"));
	        	 db.setMaSBDen(resultSet.getString("MA_SB_DEN"));
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
	 
	 public ArrayList<DuongBay> getDBbySB(String masbDi,String masbDen){
		 ArrayList<DuongBay> result = new ArrayList<DuongBay>();
		 String sqlSelectAll = "select * from DUONG_BAY where MA_SB_DI = ? and MA_SB_VE = ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, masbDi);
	         preparedStatement.setString(2, masbDen);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 DuongBay db = new DuongBay();
	        	 db.setMaDB(resultSet.getString("MA_DB"));
	        	 db.setMaSBdi(resultSet.getString("MA_SB_DI"));
	        	 db.setMaSBDen(resultSet.getString("MA_SB_DEN"));
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

	 public DuongBay getDBbySB2(String masbDi,String masbDen){
		 String sqlSelectAll = "select * from DUONG_BAY where MA_SB_DI = ? and MA_SB_DEN = ?";
		 DuongBay db =null;
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, masbDi);
	         preparedStatement.setString(2, masbDen);
	         resultSet = preparedStatement.executeQuery();
	         
	         while(resultSet.next()){
	        	 db=new DuongBay();
	        	 db.setMaDB(resultSet.getString("MA_DB"));
	        	 db.setMaSBdi(resultSet.getString("MA_SB_DI"));
	        	 db.setMaSBDen(resultSet.getString("MA_SB_DEN"));
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
		 return db;
	 }
	 

	 public String getDDByMaSBDi(String masb){
		 String temp="";
		 String sqlSelectById = "select * from DUONG_BAY,SAN_BAY,DIA_DIEM where MA_SB_DI = ? and MA_SB_DI =MA_SB and DIA_DIEM.MA_DD=SAN_BAY.MA_DD";
	        
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectById);
	         preparedStatement.setString(1, masb);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 temp=resultSet.getString("TEN_DD");
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
		 return temp;
	 }
	 
	 public String getDDByMaSBDen(String masb){
		 String temp="";
		 String sqlSelectById = "select * from DUONG_BAY,SAN_BAY,DIA_DIEM where MA_SB_DEN = ? and MA_SB_DEN =MA_SB and DIA_DIEM.MA_DD=SAN_BAY.MA_DD";
	        
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectById);
	         preparedStatement.setString(1, masb);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 temp=resultSet.getString("TEN_DD");
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
		 return temp;
	 }
	 
	 

	 public int deleteDuongBay(DuongBay duongbay){
		 int result = 0;
		 String sqlDelete = "delete from DUONG_BAY where MA_DB = ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlDelete);
	         preparedStatement.setString(1, duongbay.getMaDB());
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
	 
	 public int insertDuongBay(DuongBay duongbay){
		 int result = 0;
		 String sqlInsert = "insert into DUONG_BAY (MA_DB, MA_SB_DI, MA_SB_DEN) values (?, ?, ?)";

		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlInsert);
	         preparedStatement.setString(1, duongbay.getMaDB());
	         preparedStatement.setString(2, duongbay.getMaSBdi());
	         preparedStatement.setString(3, duongbay.getMaSBDen());
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
	 
	 public int updateDuongBay(DuongBay duongbay){
		 int result = 0;
		 String sqlUpdate = "update   DUONG_BAY set MA_SB_DI = ?,  MA_SB_DEN = ? where MA_DB = ?";

		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlUpdate);
	         preparedStatement.setString(1, duongbay.getMaSBdi());
	         preparedStatement.setString(2, duongbay.getMaSBDen());
	         preparedStatement.setString(3, duongbay.getMaDB());
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
	 
	 public int checkTF(String maDB) {
		 int result =0;
		 String sqlSelectAll = "select * from DUONG_BAY where MA_DB = ?";
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, maDB);
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
