package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ChucVu;
import utils.DBUtils;

public class ChucVuDAO {
	
 
 private DBUtils dbUltils = null;
 private Connection connection = null;
 private PreparedStatement preparedStatement = null;
 private ResultSet resultSet = null;
 

 public ArrayList<ChucVu> getAllChucVu(){
	 ArrayList<ChucVu> result = new ArrayList<ChucVu>();
	 String sqlSelectAll = "select * from CHUC_VU";
	
	 try {
		 dbUltils = new DBUtils();
		 connection = dbUltils.getConnection();
         preparedStatement = connection.prepareStatement(sqlSelectAll);
         resultSet = preparedStatement.executeQuery();
         while(resultSet.next()){
	         ChucVu cv = new ChucVu();
	         cv.setMaCV(resultSet.getString("MA_CV"));
	         cv.setTenCV(resultSet.getString("TEN_CV"));
	         cv.setLuong(resultSet.getInt("LUONG"));
	         result.add(cv);
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
 
 public String[] getChucVu(){
	 String[] result = new String[99];
	 String sqlSelectAll = "select * from CHUC_VU";
	
	 try {
		 dbUltils = new DBUtils();
		 connection = dbUltils.getConnection();
         preparedStatement = connection.prepareStatement(sqlSelectAll);
         resultSet = preparedStatement.executeQuery();
         int i=0;
         while(resultSet.next()){
	         result[i]=resultSet.getString("TEN_CV");
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
 

 public String getChucVuByMaCV(String chucvu){
	 String temp="";
	 String sqlSelectById = "select * from CHUC_VU where MA_CV = ?";
        
	 try {
		 dbUltils = new DBUtils();
		 connection = dbUltils.getConnection();
         preparedStatement = connection.prepareStatement(sqlSelectById);
         preparedStatement.setString(1, chucvu);
         resultSet = preparedStatement.executeQuery();
         while(resultSet.next()){
		      temp=resultSet.getString("TEN_CV");
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
 
 public String getMaCVbyTenCV(String chucvu){
	 String temp="";
	 String sqlSelectById = "select * from CHUC_VU where TEN_CV = ?";
	 try {
		 dbUltils = new DBUtils();
		 connection = dbUltils.getConnection();
         preparedStatement = connection.prepareStatement(sqlSelectById);
         preparedStatement.setString(1, chucvu);
         resultSet = preparedStatement.executeQuery();
         while(resultSet.next()){
		      temp=resultSet.getString("MA_CV");
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

 public int updateChucVu(ChucVu chucvu){
	 int result = 0;
	 String sqlUpdate = "update CHUC_VU set MA_CV = ?, TEN_CV = ?, LUONG = ? where MA_CV = ?";

	 try {
		 dbUltils = new DBUtils();
		 connection = dbUltils.getConnection();
         preparedStatement = connection.prepareStatement(sqlUpdate);
         preparedStatement.setString(1, chucvu.getMaCV());
         preparedStatement.setString(2, chucvu.getTenCV());
         preparedStatement.setInt(3, chucvu.getLuong());
         preparedStatement.setString(4, chucvu.getMaCV());
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
 
 public int deleteChucVu(ChucVu chucvu){
	 int result = 0;
	 String sqlDelete = "delete from CHUC_VU where MA_CV = ?";
	
	 try {
		 dbUltils = new DBUtils();
		 connection = dbUltils.getConnection();
         preparedStatement = connection.prepareStatement(sqlDelete);
         preparedStatement.setString(1, chucvu.getMaCV());
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
 
 public int insertChucVu(ChucVu chucvu){
	 int result = 0;
	 String sqlInsert = "insert into CHUC_VU(MA_CV, TEN_CV, LUONG) values (?, ?, ?)";

	 try {
		 dbUltils = new DBUtils();
		 connection = dbUltils.getConnection();
         preparedStatement = connection.prepareStatement(sqlInsert);
         preparedStatement.setString(1, chucvu.getMaCV());
         preparedStatement.setString(2, chucvu.getTenCV());
         preparedStatement.setInt(3, chucvu.getLuong());
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
 public int checkTF(String macv) {
	 int temp=0;
	 ArrayList<ChucVu> result = new ArrayList<ChucVu>();
	 String sqlSelectById = "select * from NHAN_VIEN,CHUC_VU where CHUC_VU.MA_CV = ? and NHAN_VIEN.MA_CV =CHUC_VU.MA_CV";
        
	 try {
		 dbUltils = new DBUtils();
		 connection = dbUltils.getConnection();
         preparedStatement = connection.prepareStatement(sqlSelectById);
         preparedStatement.setString(1, macv);
         resultSet = preparedStatement.executeQuery();
         while(resultSet.next()){
	          ChucVu cv = new ChucVu();
	          cv.setMaCV(resultSet.getString("MA_CV"));
		      cv.setTenCV(resultSet.getString("TEN_CV"));
		      cv.setLuong(resultSet.getInt("LUONG"));
	          result.add(cv);
	          temp=1;
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
}
