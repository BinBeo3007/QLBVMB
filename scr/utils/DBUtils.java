package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

 private Connection con;
 
 public DBUtils() {
     con = getConnection();
 }
 
 public Connection getConnection(){
	 String status="";
	 try {
         String url = "jdbc:mysql://localhost:3306/qlmb";
         Properties props = new Properties();
         props.setProperty("user","root");
         props.setProperty("password","");
         props.setProperty("ssl","false");
         con = DriverManager.getConnection(url, props);
         status= "Connect successfully";
     } catch (Exception e) {
         status= "Connect failure";
         e.printStackTrace();
     }
	 System.out.print(status);
  return con;
 } 
}
