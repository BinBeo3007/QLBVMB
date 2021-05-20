package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.DBUtils;

public class frmMain {

 /**
  * Kết nối cơ sở dữ liệu và xuất dữ liệu trong bảng Users ra màn hình
  * @param args (not use)
  */
 
 public static void main(String[] args) {
 DBUtils dbUltils = null;
 Connection dbConn = null;
 Statement statement = null ;
 ResultSet rs = null;
 try {
 dbUltils = new DBUtils();
 dbConn = dbUltils.getConnection();
 statement = dbConn.createStatement();
 rs = statement.executeQuery("select * from CHUC_VU");
 System.out.println("MaCV" +"     	 		  "+ "Ten CV" +"       			   "+ "Luong");
 while (rs.next()) {
 String macv = rs.getString("MA_CV");
 String tencv = rs.getString("TEN_CV");
 String luong = rs.getString("LUONG");
 System.out.println(macv +"          "+ tencv +"          "+ luong);
 }
 } catch (SQLException e) {
 e.printStackTrace();
 }
 finally{
 if(dbConn != null){
 try {
 dbConn.close();
 } catch (SQLException e) {
 e.printStackTrace();
 }
 }
 if(statement != null){
 try {
 statement.close();
 } catch (SQLException e) {
 e.printStackTrace();
 }
 }
 if(rs != null){
 try {
 rs.close();
 } catch (SQLException e) {
 e.printStackTrace();
 }
 }
 }
 }

}