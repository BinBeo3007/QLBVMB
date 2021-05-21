package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DiaDiem;
import utils.DBUtils;


public class DiaDiemDAO {
	
	 
	 private DBUtils dbUltils = null;
	 private Connection connection = null;
	 private PreparedStatement preparedStatement = null;
	 private ResultSet resultSet = null;
	 

	 public ArrayList<DiaDiem> getAllDiaDiem(){
		 ArrayList<DiaDiem> result = new ArrayList<DiaDiem>();
		 String sqlSelectAll = "select * from DIA_DIEM";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 DiaDiem dd = new DiaDiem();
	        	 dd.setMaDD(resultSet.getString("MA_DD"));
	        	 dd.setTenDD(resultSet.getString("TEN_DD"));
	        	 dd.setMuiGio(resultSet.getString("MUI_GIO"));
		         result.add(dd);
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
	 public String[] getAllDiaDiem2(){
		 String[] result = new String[20];
		 String sqlSelectAll = "select * from DIA_DIEM";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         int i=0;
	         while(resultSet.next()){
		         result[i]=resultSet.getString("TEN_DD");
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
	 public String getmaDD(String ten){
		 String result = "";
		 String sqlSelectAll = "select * from DIA_DIEM where TEN_DD=?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, ten);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 result=resultSet.getString("MA_DD");
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
	 public ArrayList<DiaDiem> getDD(String madd){
		 ArrayList<DiaDiem> result = new ArrayList<DiaDiem>();
		 String sqlSelectById = "select * from DIA_DIEM where MA_DD = ?";
	        
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectById);
	         preparedStatement.setString(1, madd);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 DiaDiem dd = new DiaDiem();
	        	 dd.setMaDD(resultSet.getString("MA_DD"));
	        	 dd.setTenDD(resultSet.getString("TEN_DD"));
	        	 dd.setMuiGio(resultSet.getString("MUI_GIO"));
		         result.add(dd);
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
	 
	 public String getMaDDByDD(String diadiem){
		 String temp="";
		 ArrayList<DiaDiem> result = new ArrayList<DiaDiem>();
		 String sqlSelectById = "select * from DIA_DIEM where TEN_DD = ?";
	        
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectById);
	         preparedStatement.setString(1, diadiem);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 DiaDiem dd = new DiaDiem();
	        	 dd.setMaDD(resultSet.getString("MA_DD"));
	        	 temp=dd.getMaDD();
	        	 dd.setTenDD(resultSet.getString("TEN_DD"));
	        	 
	        	 dd.setMuiGio(resultSet.getString("MUI_GIO"));
		         result.add(dd);
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

	 public String getDDByMaDD(String madd){
		 String temp="";
		 ArrayList<DiaDiem> result = new ArrayList<DiaDiem>();
		 String sqlSelectById = "select * from DIA_DIEM where MA_DD = ?";
	        
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectById);
	         preparedStatement.setString(1, madd);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 DiaDiem dd = new DiaDiem();
	        	 dd.setMaDD(resultSet.getString("MA_DD"));
	        	 dd.setTenDD(resultSet.getString("TEN_DD"));
	        	 temp=dd.getTenDD();
	        	 dd.setMuiGio(resultSet.getString("MUI_GIO"));
		         result.add(dd);
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
	 
	 public String getGioByMaDD(String madd){
		 String temp="";
		 ArrayList<DiaDiem> result = new ArrayList<DiaDiem>();
		 String sqlSelectById = "select * from DIA_DIEM where MA_DD = ?";
	        
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectById);
	         preparedStatement.setString(1, madd);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 DiaDiem dd = new DiaDiem();
	        	 dd.setMaDD(resultSet.getString("MA_DD"));
	        	 dd.setTenDD(resultSet.getString("TEN_DD"));	        	 
	        	 dd.setMuiGio(resultSet.getString("MUI_GIO"));
	        	 temp=dd.getMuiGio();
		         result.add(dd);
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

	 public int deleteDiaDiem(DiaDiem diadiem){
		 int result = 0;
		 String sqlDelete = "delete from DIA_DIEM where MA_DD = ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlDelete);
	         preparedStatement.setString(1, diadiem.getMaDD());
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
	 
	 public int insertDiaDiem(DiaDiem diadiem){
		 int result = 0;
		 String sqlInsert = "insert into DIA_DIEM(MA_DD, TEN_DD, MUI_GIO) values (?, ?, ?)";

		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlInsert);
	         preparedStatement.setString(1, diadiem.getMaDD());
	         preparedStatement.setString(2, diadiem.getTenDD());
	         preparedStatement.setString(3, diadiem.getMuiGio());
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