package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
 
 private String db_url = null;
 private String db_user = null;
 private String db_password = null;
 private String db_driver = null;
 private Connection con;
 
 public Connection getConnection(){
	 Properties p = new Properties();
	 try {
		 p.load(new FileInputStream("database.properties"));
		 db_url = p.getProperty("db_url");
		 db_user = p.getProperty("db_user");
		 db_password = p.getProperty("db_password");
		 db_driver = p.getProperty("db_driver");
		 Class.forName(db_driver);
		 con = DriverManager.getConnection(db_url, db_user, db_password);
	 } catch (FileNotFoundException e) {
	 System.err.println("Không thấy tệp tín database.properties.");
	 } catch (IOException e) {
	 System.err.println("Đọc tệp tin có lỗi.");
	 } catch (ClassNotFoundException e) {
	 System.err.println("Không tìm thấy class.");
	 } catch (SQLException e) {
	 System.err.println("Lỗi kết nối cơ sở dư liệu.");
	 }
	 if (con == null) {
	 throw new NullPointerException("Kết nối không thành công.");
	 }

  return con;
 }
} 