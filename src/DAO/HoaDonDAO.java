package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.HoaDon;
import utils.DBUtils;

public class HoaDonDAO {
	private DBUtils dbUltils = null;
	 private Connection connection = null;
	 private PreparedStatement preparedStatement = null;
	 private ResultSet resultSet = null;
	 
	 public ArrayList<HoaDon> getAllHD(){
		 ArrayList<HoaDon> result = new ArrayList<HoaDon>();
		 String sqlSelectAll = "select * from HOA_DON,KHACH_HANG where HOA_DON.MA_KH = KHACH_HANG.MA_KH and KHACH_HANG.TINH_TRANG <> 0 ";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 HoaDon hd = new HoaDon();
		        	 hd.setMaHD(resultSet.getString("MA_HD"));
		        	 hd.setMaKH(resultSet.getInt("MA_KH"));
		        	 hd.setMaNV(resultSet.getInt("MA_NV"));
		        	 hd.setNgayMua(resultSet.getString("NGAY_MUA"));
		        	 hd.setTongTien(resultSet.getInt("TONG_TIEN"));
		        	 hd.setTinhTrangn(resultSet.getInt("TINH_TRANG"));
		        	 hd.setKM(resultSet.getInt("KM"));
			         result.add(hd);
	        	 }
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
	 public ArrayList<HoaDon> getAllDoanhThu(){
		 ArrayList<HoaDon> result = new ArrayList<HoaDon>();
		 String sqlSelectAll = "select * from HOA_DON,KHACH_HANG where HOA_DON.MA_KH = KHACH_HANG.MA_KH and KHACH_HANG.TINH_TRANG <> 0 and TONG_TIEN >0 and HOA_DON.TINH_TRANG =2 ";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 HoaDon hd = new HoaDon();
		        	 hd.setMaHD(resultSet.getString("MA_HD"));
		        	 hd.setMaKH(resultSet.getInt("MA_KH"));
		        	 hd.setMaNV(resultSet.getInt("MA_NV"));
		        	 hd.setNgayMua(resultSet.getString("NGAY_MUA"));
		        	 hd.setTongTien(resultSet.getInt("TONG_TIEN"));
		        	 hd.setTinhTrangn(resultSet.getInt("TINH_TRANG"));
		        	 hd.setKM(resultSet.getInt("KM"));
			         result.add(hd);
	        	 }
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
	 public ArrayList<HoaDon> getDoanhThuGiam(){
		 ArrayList<HoaDon> result = new ArrayList<HoaDon>();
		 String sqlSelectAll = "select * from HOA_DON,KHACH_HANG where HOA_DON.MA_KH = KHACH_HANG.MA_KH and KHACH_HANG.TINH_TRANG <> 0 and TONG_TIEN >0 and HOA_DON.TINH_TRANG=2  ORDER BY TONG_TIEN DESC";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 HoaDon hd = new HoaDon();
		        	 hd.setMaHD(resultSet.getString("MA_HD"));
		        	 hd.setMaKH(resultSet.getInt("MA_KH"));
		        	 hd.setMaNV(resultSet.getInt("MA_NV"));
		        	 hd.setNgayMua(resultSet.getString("NGAY_MUA"));
		        	 hd.setTongTien(resultSet.getInt("TONG_TIEN"));
		        	 hd.setTinhTrangn(resultSet.getInt("TINH_TRANG"));
		        	 hd.setKM(resultSet.getInt("KM"));
			         result.add(hd);
	        	 }
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
	 public ArrayList<HoaDon> getDoanhThuTang(){
		 ArrayList<HoaDon> result = new ArrayList<HoaDon>();
		 String sqlSelectAll = "select * from HOA_DON,KHACH_HANG where HOA_DON.MA_KH = KHACH_HANG.MA_KH and KHACH_HANG.TINH_TRANG <> 0 and TONG_TIEN >0 and HOA_DON.TINH_TRANG =2  ORDER BY TONG_TIEN ASC";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 HoaDon hd = new HoaDon();
		        	 hd.setMaHD(resultSet.getString("MA_HD"));
		        	 hd.setMaKH(resultSet.getInt("MA_KH"));
		        	 hd.setMaNV(resultSet.getInt("MA_NV"));
		        	 hd.setNgayMua(resultSet.getString("NGAY_MUA"));
		        	 hd.setTongTien(resultSet.getInt("TONG_TIEN"));
		        	 hd.setTinhTrangn(resultSet.getInt("TINH_TRANG"));
		        	 hd.setKM(resultSet.getInt("KM"));
			         result.add(hd);
	        	 }
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
	 
	 public ArrayList<HoaDon> getHDbyMaHD(HoaDon hoadon){
		 ArrayList<HoaDon> result = new ArrayList<HoaDon>();
		 String sqlSelectAll = "select * from HOA_DON,KHACH_HANG where HOA_DON.MA_KH = KHACH_HANG.MA_KH and KHACH_HANG.TINH_TRANG <> 0 and MA_HD =?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setString(1, hoadon.getMaHD());
	         
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 HoaDon hd = new HoaDon();
		        	 hd.setMaHD(resultSet.getString("MA_HD"));
		        	 hd.setMaKH(resultSet.getInt("MA_KH"));
		        	 hd.setMaNV(resultSet.getInt("MA_NV"));
		        	 hd.setNgayMua(resultSet.getString("NGAY_MUA"));
		        	 hd.setTongTien(resultSet.getInt("TONG_TIEN"));
		        	 hd.setTinhTrangn(resultSet.getInt("TINH_TRANG"));
		        	 hd.setKM(resultSet.getInt("KM"));
			         result.add(hd);
	        	 }
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
	 
	 public ArrayList<HoaDon> getHDbyTT(int TT){
		 ArrayList<HoaDon> result = new ArrayList<HoaDon>();
		 String sqlSelectAll = "select * from HOA_DON where TINH_TRANG=?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setInt(1, TT);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 HoaDon hd = new HoaDon();
		        	 hd.setMaHD(resultSet.getString("MA_HD"));
		        	 hd.setMaKH(resultSet.getInt("MA_KH"));
		        	 hd.setMaNV(resultSet.getInt("MA_NV"));
		        	 hd.setNgayMua(resultSet.getString("NGAY_MUA"));
		        	 hd.setTongTien(resultSet.getInt("TONG_TIEN"));
		        	 hd.setTinhTrangn(resultSet.getInt("TINH_TRANG"));
		        	 hd.setKM(resultSet.getInt("KM"));
			         result.add(hd);
	        	 }
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
	 
	 public ArrayList<HoaDon> getHDbyMaKH(HoaDon hoadon){
		 ArrayList<HoaDon> result = new ArrayList<HoaDon>();
		 String sqlSelectAll = "select * from HOA_DON where MA_KH=?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setInt(1, hoadon.getMaKH());
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 HoaDon hd = new HoaDon();
		        	 hd.setMaHD(resultSet.getString("MA_HD"));
		        	 hd.setMaKH(resultSet.getInt("MA_KH"));
		        	 hd.setMaNV(resultSet.getInt("MA_NV"));
		        	 hd.setNgayMua(resultSet.getString("NGAY_MUA"));
		        	 hd.setTongTien(resultSet.getInt("TONG_TIEN"));
		        	 hd.setTinhTrangn(resultSet.getInt("TINH_TRANG"));
		        	 hd.setKM(resultSet.getInt("KM"));
			         result.add(hd);
	        	 }
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
	 
	 public ArrayList<HoaDon> getHDbyMaNV(HoaDon hoadon){
		 ArrayList<HoaDon> result = new ArrayList<HoaDon>();
		 String sqlSelectAll = "select * from HOA_DON where MA_NV=?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setInt(1, hoadon.getMaNV());
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 HoaDon hd = new HoaDon();
		        	 hd.setMaHD(resultSet.getString("MA_HD"));
		        	 hd.setMaKH(resultSet.getInt("MA_KH"));
		        	 hd.setMaNV(resultSet.getInt("MA_NV"));
		        	 hd.setNgayMua(resultSet.getString("NGAY_MUA"));
		        	 hd.setTongTien(resultSet.getInt("TONG_TIEN"));
		        	 hd.setTinhTrangn(resultSet.getInt("TINH_TRANG"));
		        	 hd.setKM(resultSet.getInt("KM"));
			         result.add(hd);
	        	 }
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
	 
	 public ArrayList<HoaDon> getHDbyT(HoaDon hoadon){
		 ArrayList<HoaDon> result = new ArrayList<HoaDon>();
		 String sqlSelectAll = "select * from HOA_DON where TONG_TIEN >= ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlSelectAll);
	         preparedStatement.setInt(1, hoadon.getTongTien());
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()){
	        	 if(resultSet.getInt("TINH_TRANG")!=0) {
	        		 HoaDon hd = new HoaDon();
		        	 hd.setMaHD(resultSet.getString("MA_HD"));
		        	 hd.setMaKH(resultSet.getInt("MA_KH"));
		        	 hd.setMaNV(resultSet.getInt("MA_NV"));
		        	 hd.setNgayMua(resultSet.getString("NGAY_MUA"));
		        	 hd.setTongTien(resultSet.getInt("TONG_TIEN"));
		        	 hd.setTinhTrangn(resultSet.getInt("TINH_TRANG"));
		        	 hd.setKM(resultSet.getInt("KM"));
			         result.add(hd);
	        	 }
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
	 
	 public int deleteHD(HoaDon hoadon){
		 int result = 0;
		 String sqlDelete = "delete from HOA_DON where MA_HD = ?";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlDelete);
	         preparedStatement.setString(1, hoadon.getMaHD());
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
	 
	 public int updateHD(HoaDon hoadon){
		 int result = 0;
		 String sqlUpdate = "update  HOA_DON  set NGAY_MUA = ?, MA_NV = ?,TINH_TRANG = ? where MA_HD = ?";

		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlUpdate);
	         preparedStatement.setString(4, hoadon.getMaHD());
	         preparedStatement.setInt(3, hoadon.getTinhTrang());
	         preparedStatement.setInt(2, hoadon.getMaNV());
	         preparedStatement.setString(1, hoadon.getNgayMua());
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
	 public int updateKM(HoaDon hoadon){
		 int result = 0;
		 String sqlUpdate = "update  HOA_DON  set KM =?, TONG_TIEN=?  where MA_HD = ?";

		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlUpdate);
	         preparedStatement.setInt(2, hoadon.getTongTien());
	         preparedStatement.setInt(1, hoadon.getKM());
	         preparedStatement.setString(3, hoadon.getMaHD());
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
	 public int updateTT(HoaDon hoadon){
		 int result = 0;
		 String sqlUpdate = "update  HOA_DON  set TINH_TRANG =? where MA_HD = ?";

		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sqlUpdate);
	         preparedStatement.setInt(1, 0);
	         preparedStatement.setString(2, hoadon.getMaHD());
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
	 public int insertHD(HoaDon hoadon){
		 int result = 0;
		 String sql = "	insert into HOA_DON (MA_HD,MA_KH,TINH_TRANG) values (?,?,?)";
		
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sql);
	         preparedStatement.setString(1, hoadon.getMaHD());
	         preparedStatement.setInt(2, hoadon.getMaKH());
	         preparedStatement.setInt(3, hoadon.getTinhTrang());
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
	 
	 public int getSLHD() {
		 int result=0;
		 String sql="SELECT COUNT(MA_HD) as SLHD FROM HOA_DON";
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sql);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()) {
	        	 result=resultSet.getInt("SLHD");
	         }
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
	 public int getSLHDbymaKH(int makh) {
		 int result=0;
		 String sql="SELECT COUNT(MA_HD) as SLHD FROM HOA_DON where MA_KH= ?";
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sql);
	         preparedStatement.setInt(1, makh);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()) {
	        	 result=resultSet.getInt("SLHD");
	         }
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
	 
	 public int getSLHDbymanv(int manv) {
		 int result=0;
		 String sql="SELECT COUNT(MA_HD) as SLHD FROM HOA_DON where MA_NV= ?";
		 try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	         preparedStatement = connection.prepareStatement(sql);
	         preparedStatement.setInt(1, manv);
	         resultSet = preparedStatement.executeQuery();
	         while(resultSet.next()) {
	        	 result=resultSet.getInt("SLHD");
	         }
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
