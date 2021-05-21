package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.MayBay;
import utils.DBUtils;

public class MayBayDAO {

	 private DBUtils dbUltils = null;
	 private Connection connection = null;
	 private PreparedStatement preparedStatement = null;
	 private ResultSet resultSet = null;
	 
	 public ArrayList<MayBay> getALLMB(){
		 ArrayList<MayBay> result = new ArrayList<MayBay>();
		 String sqlSelectAll="select * from MAY_BAY";
		 try {
			 dbUltils= new DBUtils();
			 connection = dbUltils.getConnection();
			 preparedStatement =connection.prepareStatement(sqlSelectAll);
			 resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				MayBay mb =new MayBay();
				mb.setMaMB(resultSet.getString("MA_MB"));
				mb.setTenMB(resultSet.getString("TEN_MB"));
				mb.setHang_SX(resultSet.getString("HANG_SX"));
				mb.setGheloai1(resultSet.getInt("SO_GHE_LOAI_1"));
				mb.setGheloai2(resultSet.getInt("SO_GHE_LOAI_2"));
				mb.setTongghe(resultSet.getInt("TONG_GHE"));
				result.add(mb);
			 }
			 
		 }catch(SQLException e){
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
	 public String[] getAllmaMB(){
		 String[]  result = new String[99];
		 String sqlSelectAll="select * from MAY_BAY";
		 try {
			 dbUltils= new DBUtils();
			 connection = dbUltils.getConnection();
			 preparedStatement =connection.prepareStatement(sqlSelectAll);
			 resultSet = preparedStatement.executeQuery();
			 int i=0;
			 while(resultSet.next()) {
				result[i]=resultSet.getString("MA_MB").trim();
				i++;
			 }
			 
		 }catch(SQLException e){
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
	 
	 public ArrayList<MayBay> getMBbyMaMB(MayBay maybay){
		 ArrayList<MayBay> result = new ArrayList<MayBay>();
		 String sqlSelect="select * from MAY_BAY where MA_MB= ?";
		 try {
			 dbUltils= new DBUtils();
			 connection = dbUltils.getConnection();
			 preparedStatement =connection.prepareStatement(sqlSelect);
			 preparedStatement.setString(1, maybay.getMaMB());
			 resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				MayBay mb =new MayBay();
				mb.setMaMB(resultSet.getString("MA_MB"));
				mb.setTenMB(resultSet.getString("TEN_MB"));
				mb.setHang_SX(resultSet.getString("HANG_SX"));
				mb.setGheloai1(resultSet.getInt("SO_GHE_LOAI_1"));
				mb.setGheloai2(resultSet.getInt("SO_GHE_LOAI_2"));
				mb.setTongghe(resultSet.getInt("TONG_GHE"));
				result.add(mb);
			 }
			 
		 }catch(SQLException e){
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
	 
	 public ArrayList<MayBay> getMBbyMaMB2(String maMB){
		 ArrayList<MayBay> result = new ArrayList<MayBay>();
		 String sqlSelect="select * from MAY_BAY where MA_MB= ?";
		 try {
			 dbUltils= new DBUtils();
			 connection = dbUltils.getConnection();
			 preparedStatement =connection.prepareStatement(sqlSelect);
			 preparedStatement.setString(1, maMB);
			 resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				MayBay mb =new MayBay();
				mb.setMaMB(resultSet.getString("MA_MB"));
				mb.setTenMB(resultSet.getString("TEN_MB"));
				mb.setHang_SX(resultSet.getString("HANG_SX"));
				mb.setGheloai1(resultSet.getInt("SO_GHE_LOAI_1"));
				mb.setGheloai2(resultSet.getInt("SO_GHE_LOAI_2"));
				mb.setTongghe(resultSet.getInt("TONG_GHE"));
				result.add(mb);
			 }
			 
		 }catch(SQLException e){
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
	 
	 public ArrayList<MayBay> getMBbySX(String hangSX){
		 ArrayList<MayBay> result = new ArrayList<MayBay>();
		 String sqlSelect="select * from MAY_BAY where HANG_SX= ?";
		 try {
			 dbUltils= new DBUtils();
			 connection = dbUltils.getConnection();
			 preparedStatement =connection.prepareStatement(sqlSelect);
			 preparedStatement.setString(1, hangSX);
			 resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				MayBay mb =new MayBay();
				mb.setMaMB(resultSet.getString("MA_MB"));
				mb.setTenMB(resultSet.getString("TEN_MB"));
				mb.setHang_SX(resultSet.getString("HANG_SX"));
				mb.setGheloai1(resultSet.getInt("SO_GHE_LOAI_1"));
				mb.setGheloai2(resultSet.getInt("SO_GHE_LOAI_2"));
				mb.setTongghe(resultSet.getInt("TONG_GHE"));
				result.add(mb);
			 }
			 
		 }catch(SQLException e){
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
	 
	 public ArrayList<MayBay> getMBbyTongGhe(int tongghe){
		 ArrayList<MayBay> result = new ArrayList<MayBay>();
		 String sqlSelect="select * from MAY_BAY where TONG_GHE= ?";
		 try {
			 dbUltils= new DBUtils();
			 connection = dbUltils.getConnection();
			 preparedStatement =connection.prepareStatement(sqlSelect);
			 preparedStatement.setInt(1, tongghe);
			 resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				MayBay mb =new MayBay();
				mb.setMaMB(resultSet.getString("MA_MB"));
				mb.setTenMB(resultSet.getString("TEN_MB"));
				mb.setHang_SX(resultSet.getString("HANG_SX"));
				mb.setGheloai1(resultSet.getInt("SO_GHE_LOAI_1"));
				mb.setGheloai2(resultSet.getInt("SO_GHE_LOAI_2"));
				mb.setTongghe(resultSet.getInt("TONG_GHE"));
				result.add(mb);
			 }
			 
		 }catch(SQLException e){
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
	 
	 public int deleteMayBay(MayBay maybbay) {
		 int result =0;
		 String sqlDelete = "delete from MAY_BAY where MA_MB = ?";
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlDelete);
	         preparedStatement.setString(1, maybbay.getMaMB());
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
	 
	 public int insertMayBay(MayBay maybbay) {
		 int result =0;
		 String sqlinsert = "insert into MAY_BAY(MA_MB, TEN_MB, HANG_SX, SO_GHE_LOAI_1, SO_GHE_LOAI_2, TONG_GHE) values (?, ?, ?, ?, ?, ?)";
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlinsert);
	         preparedStatement.setString(1, maybbay.getMaMB());
	         preparedStatement.setString(2, maybbay.getTenMB());
	         preparedStatement.setString(3, maybbay.getHang_SX());
	         preparedStatement.setInt(4, maybbay.getGheloai1());
	         preparedStatement.setInt(5, maybbay.getGheloai2());
	         preparedStatement.setInt(6, maybbay.getTongghe());
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
	 
	 public int updateMayBay(MayBay maybbay) {
		 int result =0;
		 String sqlinsert = "update   MAY_BAY set  TEN_MB= ?, HANG_SX =? , SO_GHE_LOAI_1= ?, SO_GHE_LOAI_2 = ? , TONG_GHE =? where MA_MB= ?";
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlinsert);
	         preparedStatement.setString(6, maybbay.getMaMB());
	         preparedStatement.setString(1, maybbay.getTenMB());
	         preparedStatement.setString(2, maybbay.getHang_SX());
	         preparedStatement.setInt(3, maybbay.getGheloai1());
	         preparedStatement.setInt(4, maybbay.getGheloai2());
	         preparedStatement.setInt(5, maybbay.getTongghe());
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
	 
	 public int checkTF(String maMB) {
		 int result =0;
		 String sqlSelectAll = "select * from MAY_BAY where MA_MB = ?";
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, maMB);
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
