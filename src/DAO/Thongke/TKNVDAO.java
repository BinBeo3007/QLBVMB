package DAO.Thongke;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Thongke.TKNV;
import utils.DBUtils;
public class TKNVDAO {
	 private DBUtils dbUltils = null;
	    private Connection connection = null;
	    private PreparedStatement preparedStatement = null;
	    private ResultSet resultSet = null;

	    public ArrayList<TKNV> getAll(){
			 ArrayList<TKNV> result = new ArrayList<TKNV>();
			 String sqlSelectAll = "select NHAN_VIEN.MA_NV,HO,LOT,TEN, COUNT(MA_HD) as \"SL\" from NHAN_VIEN  inner join HOA_DON on NHAN_VIEN.MA_NV=HOA_DON.MA_NV and HOA_DON.TINH_TRANG <>0 "
			 		+ " and NHAN_VIEN.TINH_TRANG <>0  group by NHAN_VIEN.MA_NV,HO,LOT,TEN";
			
			 try {
				 dbUltils = new DBUtils();
				 connection = dbUltils.getConnection();
		         preparedStatement = connection.prepareStatement(sqlSelectAll);
		         resultSet = preparedStatement.executeQuery();
		         while(resultSet.next()){
		        	 TKNV nv=new TKNV();
		        	 nv.setManv(resultSet.getInt("MA_NV"));
		        	 nv.setHoten(""+resultSet.getString("HO")+" "+resultSet.getString("LOT")+" "+resultSet.getString("TEN"));
		        	 nv.setSlve(resultSet.getInt("SL"));
				         result.add(nv);
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
	    public ArrayList<TKNV> getAllGiam(){
	    	ArrayList<TKNV> result = new ArrayList<TKNV>();
			 String sqlSelectAll = "select NHAN_VIEN.MA_NV,HO,LOT,TEN, COUNT(MA_HD) as \"SL\" from NHAN_VIEN  inner join HOA_DON on NHAN_VIEN.MA_NV=HOA_DON.MA_NV and HOA_DON.TINH_TRANG <>0 "
			 		+ " and NHAN_VIEN.TINH_TRANG <>0 group by NHAN_VIEN.MA_NV,HO,LOT,TEN order by SL DESC";
			
			 try {
				 dbUltils = new DBUtils();
				 connection = dbUltils.getConnection();
		         preparedStatement = connection.prepareStatement(sqlSelectAll);
		         resultSet = preparedStatement.executeQuery();
		         while(resultSet.next()){
		        	 TKNV nv=new TKNV();
		        	 nv.setManv(resultSet.getInt("MA_NV"));
		        	 nv.setHoten(""+resultSet.getString("HO")+" "+resultSet.getString("LOT")+" "+resultSet.getString("TEN"));
		        	 nv.setSlve(resultSet.getInt("SL"));
				         result.add(nv);
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
	    public ArrayList<TKNV> getAllTang(){
	    	ArrayList<TKNV> result = new ArrayList<TKNV>();
			 String sqlSelectAll = "select NHAN_VIEN.MA_NV,HO,LOT,TEN, COUNT(MA_HD) as \"SL\" from NHAN_VIEN  inner join HOA_DON on NHAN_VIEN.MA_NV=HOA_DON.MA_NV and HOA_DON.TINH_TRANG <>0 "
			 		+ " and NHAN_VIEN.TINH_TRANG <>0 group by NHAN_VIEN.MA_NV,HO,LOT,TEN order by SL ASC";
			
			 try {
				 dbUltils = new DBUtils();
				 connection = dbUltils.getConnection();
		         preparedStatement = connection.prepareStatement(sqlSelectAll);
		         resultSet = preparedStatement.executeQuery();
		         while(resultSet.next()){
		        	 TKNV nv=new TKNV();
		        	 nv.setManv(resultSet.getInt("MA_NV"));
		        	 nv.setHoten(""+resultSet.getString("HO")+" "+resultSet.getString("LOT")+" "+resultSet.getString("TEN"));
		        	 nv.setSlve(resultSet.getInt("SL"));
				         result.add(nv);
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
	    public ArrayList<TKNV> getAllbyma(int manv){
	    	ArrayList<TKNV> result = new ArrayList<TKNV>();
			 String sqlSelectAll = "select NHAN_VIEN.MA_NV,HO,LOT,TEN, COUNT(MA_HD) as \"SL\" from NHAN_VIEN  inner join HOA_DON on NHAN_VIEN.MA_NV=HOA_DON.MA_NV and HOA_DON.TINH_TRANG <>0 and NHAN_VIEN.MA_NV = ? "
			 		+ "  and NHAN_VIEN.TINH_TRANG <>0 group by NHAN_VIEN.MA_NV,HO,LOT,TEN";
			
			 try {
				 dbUltils = new DBUtils();
				 connection = dbUltils.getConnection();
		         preparedStatement = connection.prepareStatement(sqlSelectAll);
		         preparedStatement.setInt(1, manv);
		         resultSet = preparedStatement.executeQuery();
		         while(resultSet.next()){
		        	 TKNV nv=new TKNV();
		        	 nv.setManv(resultSet.getInt("MA_NV"));
		        	 nv.setHoten(""+resultSet.getString("HO")+" "+resultSet.getString("LOT")+" "+resultSet.getString("TEN"));
		        	 nv.setSlve(resultSet.getInt("SL"));
				         result.add(nv);
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
