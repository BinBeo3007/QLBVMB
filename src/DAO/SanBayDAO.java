package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.SanBay;
import utils.DBUtils;

public class SanBayDAO {

	 private DBUtils dbUltils = null;
	 private Connection connection = null;
	 private PreparedStatement preparedStatement = null;
	 private ResultSet resultSet = null;
	 

	 public ArrayList<SanBay> getAllSB(){
		 ArrayList<SanBay> result = new ArrayList<SanBay>();
		 String sqlSelectAll = "select * from SAN_BAY";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 SanBay sb = new SanBay();
	        	 sb.setMaSB(resultSet.getString("MA_SB"));
	        	 sb.setTenSB(resultSet.getString("TEN_SB"));
	        	 sb.setMaDD(resultSet.getString("MA_DD"));
		         result.add(sb);
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
	 
	 public ArrayList<SanBay> getSB(String maSB){
		 ArrayList<SanBay> result = new ArrayList<SanBay>();
		 String sqlSelectAll = "select * from SAN_BAY where MA_SB = ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, maSB);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 SanBay sb = new SanBay();
	        	 sb.setMaSB(resultSet.getString("MA_SB"));
	        	 sb.setTenSB(resultSet.getString("TEN_SB"));
	        	 sb.setMaDD(resultSet.getString("MA_DD"));
		         result.add(sb);
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
	 
	 public ArrayList<SanBay> getSBbyDD(String madd){
		 ArrayList<SanBay> result = new ArrayList<SanBay>();
		 String sqlSelectAll = "select * from SAN_BAY where MA_DD = ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, madd);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 SanBay sb = new SanBay();
	        	 sb.setMaSB(resultSet.getString("MA_SB"));
	        	 sb.setTenSB(resultSet.getString("TEN_SB"));
	        	 sb.setMaDD(resultSet.getString("MA_DD"));
		         result.add(sb);
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
	 

	 public String getSBByMaSB(String masb){
		 String temp="";
		 ArrayList<SanBay> result = new ArrayList<SanBay>();
		 String sqlSelectById = "select * from SAN_BAY where MA_SB = ?";
	        
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectById);
	         preparedStatement.setString(1, masb);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 SanBay sb = new SanBay();
	        	 sb.setMaSB(resultSet.getString("MA_SB"));
	        	 sb.setTenSB(resultSet.getString("TEN_SB"));
	        	 temp=sb.getTenSB();
	        	 sb.setMaDD(resultSet.getString("MA_DD"));
		         result.add(sb);
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
	 
	 public String getDDByMaSB(String masb){
		 String temp="";
		 ArrayList<SanBay> result = new ArrayList<SanBay>();
		 String sqlSelectById = "select * from SAN_BAY where MA_SB = ?";
	        
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectById);
	         preparedStatement.setString(1, masb);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 SanBay sb = new SanBay();
	        	 sb.setMaSB(resultSet.getString("MA_SB"));
	        	 sb.setTenSB(resultSet.getString("TEN_SB"));
	        	 sb.setMaDD(resultSet.getString("MA_DD"));
	        	 temp=sb.getMaDD();
		         result.add(sb);
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
	 
	 public String getSBByDD(String dd){
		 String result="";
		 String sqlSelectById = "select * from SAN_BAY where MA_DD = ?";
	        
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectById);
	         preparedStatement.setString(1, dd);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 result=resultSet.getString("MA_SB");
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
	 
	 
	 public ArrayList<String> getALLMASB(){
		 
		 ArrayList<String> result = new ArrayList<String>();
		 String sqlSelectById = "select * from SAN_BAY ";
	        
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectById);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 SanBay sb = new SanBay();
	        	 sb.setMaSB(resultSet.getString("MA_SB"));
	        	 sb.setTenSB(resultSet.getString("TEN_SB"));
	        	 sb.setMaDD(resultSet.getString("MA_DD"));
		         result.add(sb.getMaSB());
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
	 
	 public ArrayList<String> getALLMASB2(String maSB){
		 
		 ArrayList<String> result = new ArrayList<String>();
		 String sqlSelectById = "select * from SAN_BAY where MA_SB <> ? ";
	        
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectById);
	         preparedStatement.setString(1, maSB);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 SanBay sb = new SanBay();
	        	 sb.setMaSB(resultSet.getString("MA_SB"));
	        	 sb.setTenSB(resultSet.getString("TEN_SB"));
	        	 sb.setMaDD(resultSet.getString("MA_DD"));
		         result.add(sb.getMaSB());
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

	 public int deleteSanBay(SanBay sanbay){
		 int result = 0;
		 String sqlDelete = "delete from SAN_BAY where MA_SB = ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlDelete);
	         preparedStatement.setString(1, sanbay.getMaSB());
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
	 
	 public int insertSanBay(SanBay sanbay){
		 int result = 0;
		 String sqlInsert = "insert into SAN_BAY(MA_SB, TEN_SB, MA_DD) values (?, ?, ?)";

		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlInsert);
	         preparedStatement.setString(1, sanbay.getMaSB());
	         preparedStatement.setString(2, sanbay.getTenSB());
	         preparedStatement.setString(3, sanbay.getMaDD());
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
	 
	 public int updateSanBay(SanBay sanbay){
		 int result = 0;
		 String sqlUpdate = "update  SAN_BAY  set TEN_SB = ?, MA_DD = ? where MA_SB = ?";

		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlUpdate);
	         preparedStatement.setString(1, sanbay.getTenSB());
	         preparedStatement.setString(2, sanbay.getMaDD());
	         preparedStatement.setString(3, sanbay.getMaSB());
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
