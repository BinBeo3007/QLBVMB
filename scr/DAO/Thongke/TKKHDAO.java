package DAO.Thongke;

import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Thongke.TKKH;

public class TKKHDAO {
    private DBUtils dbUltils = null;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public ArrayList<TKKH> getAll(){
		 ArrayList<TKKH> result = new ArrayList<TKKH>();
		 String sqlSelectAll = "select KH.MA_KH,HO,LOT,TEN, COUNT(MA_VE) as \"SL\" from KHACH_HANG as \"KH\" inner join VE on KH.MA_KH=VE.MA_KH and VE.TINH_TRANG <> 0 and KH.TINH_TRANG <> 0 "
		 		+ "group by KH.MA_KH,HO,LOT,TEN";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        		TKKH kh=new TKKH();
	        		kh.setMakh(resultSet.getInt("MA_KH"));
	        		kh.setHoten(""+resultSet.getString("HO")+" "+resultSet.getString("LOT")+" "+resultSet.getString("TEN"));
	        		kh.setSlve(resultSet.getInt("SL"));
			         result.add(kh);
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
    public ArrayList<TKKH> getAllGiam(){
		 ArrayList<TKKH> result = new ArrayList<TKKH>();
		 String sqlSelectAll = "select KH.MA_KH,HO,LOT,TEN, COUNT(MA_VE) as \"SL\" from KHACH_HANG as \"KH\" inner join VE on KH.MA_KH=VE.MA_KH and VE.TINH_TRANG <> 0 and KH.TINH_TRANG <> 0 "
		 		+ "group by KH.MA_KH,HO,LOT,TEN ORDER BY SL DESC";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){

	        		TKKH kh=new TKKH();
	        		kh.setMakh(resultSet.getInt("MA_KH"));
	        		kh.setHoten(""+resultSet.getString("HO")+" "+resultSet.getString("LOT")+" "+resultSet.getString("TEN"));
	        		kh.setSlve(resultSet.getInt("SL"));
			         result.add(kh);

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
    public ArrayList<TKKH> getAllTang(){
		 ArrayList<TKKH> result = new ArrayList<TKKH>();
		 String sqlSelectAll = "select KH.MA_KH,HO,LOT,TEN, COUNT(MA_VE) as \"SL\" from KHACH_HANG as \"KH\" inner join VE on KH.MA_KH=VE.MA_KH and VE.TINH_TRANG <> 0 and KH.TINH_TRANG <> 0 "
		 		+ "group by KH.MA_KH,HO,LOT,TEN ORDER BY SL ASC";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 
	        		TKKH kh=new TKKH();
	        		kh.setMakh(resultSet.getInt("MA_KH"));
	        		kh.setHoten(""+resultSet.getString("HO")+" "+resultSet.getString("LOT")+" "+resultSet.getString("TEN"));
	        		kh.setSlve(resultSet.getInt("SL"));
			         result.add(kh);
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
    public ArrayList<TKKH> getAllbyma(int makh){
		 ArrayList<TKKH> result = new ArrayList<TKKH>();
		 String sqlSelectAll = "select KH.MA_KH,HO,LOT,TEN, COUNT(MA_VE) as \"SL\" from KHACH_HANG as \"KH\" inner join VE on KH.MA_KH=VE.MA_KH and KH.MA_KH=? "
		 		+ "and VE.TINH_TRANG <> 0 and KH.TINH_TRANG <> 0 "
		 		+ "group by KH.MA_KH,HO,LOT,TEN";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setInt(1, makh);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        		TKKH kh=new TKKH();
	        		kh.setMakh(resultSet.getInt("MA_KH"));
	        		kh.setHoten(""+resultSet.getString("HO")+" "+resultSet.getString("LOT")+" "+resultSet.getString("TEN"));
	        		kh.setSlve(resultSet.getInt("SL"));
			         result.add(kh);

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
