package DAO;

import DTO.TaiKhoan;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaiKhoanDAO {

    private DBUtils dbUltils = null;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public ArrayList<TaiKhoan> getAllTaiKhoan(){
        ArrayList<TaiKhoan> result = new ArrayList<TaiKhoan>();
        String sqlSelectAll = "select * from TAI_KHOAN where ROLE <> 0";
        try {
            dbUltils = new DBUtils();
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(sqlSelectAll);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                TaiKhoan tk = new TaiKhoan();
                tk.setID(resultSet.getString("ID"));
                tk.setMa(resultSet.getInt("MA"));
                tk.setTk(resultSet.getString("TK"));
                tk.setMk(resultSet.getString("MK"));
                tk.setRole(resultSet.getInt("ROLE"));
                result.add(tk);
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
    
    public boolean checkTK(String taikhoan) {
    	String sqlSelectAll = "select * from TAI_KHOAN where TK = ?";
        try {
            dbUltils = new DBUtils();
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(sqlSelectAll);
            preparedStatement.setString(1, taikhoan);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                	return true;
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
        return false;
    }
    public int checkLogin(String taikhoan,String matkhau) {
    	String sqlSelectAll = "select * from TAI_KHOAN where ROLE <> 0";
        try {
            dbUltils = new DBUtils();
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(sqlSelectAll);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                if(taikhoan.equals(resultSet.getString("TK").trim())&&matkhau.equals(resultSet.getString("MK").trim()))
                	return resultSet.getInt("ROLE");
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
        return 0;
    }
    public String getID(int ma, int role) {
    	String s="";
    	if(role==0)
    		return s;
    	if(role==1)
    		s+="KH"+ma;
    	else
    		s+="NV"+ma;
    	String sqlSelectAll = "select * from TAI_KHOAN";
        try {
            dbUltils = new DBUtils();
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(sqlSelectAll);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                if(s==resultSet.getString("ID"))
                	return s;
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
        return "";
    }
    
    public boolean checkID(String id) {
    	String sqlSelectAll = "select * from TAI_KHOAN where ID = ?";
        try {
            dbUltils = new DBUtils();
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(sqlSelectAll);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
               return false;
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
        return true;
    }
    
    public int creatTK(TaiKhoan tk) {
    	int result=0;
    	String sql = "insert into TAI_KHOAN(ID, MA, TK,MK, ROLE) values (?, ?, ?,?,?)";
    	try {
            dbUltils = new DBUtils();
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tk.getID());
            preparedStatement.setInt(2, tk.getMa());
            preparedStatement.setString(3,tk.getTk());
            preparedStatement.setString(4, tk.getMk());
            preparedStatement.setInt(5 , tk.getRole());
            result = preparedStatement.executeUpdate();

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
    
    public int updateMK(TaiKhoan tk) {
    	int result = 0;
	   	 String sqlUpdate = "update TAI_KHOAN set MK = ? where ID = ?";
	   	try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	        preparedStatement = connection.prepareStatement(sqlUpdate);
	        preparedStatement.setString(1, tk.getMk());
	        preparedStatement.setString(2, tk.getID());
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
    public int deleteTK(TaiKhoan tk) {
    	int result = 0;
	   	 String sqlUpdate = "update TAI_KHOAN set ROLE = 0 where ID = ?";
	   	try {
			 dbUltils = new DBUtils();
			 connection = dbUltils.getConnection();
	        preparedStatement = connection.prepareStatement(sqlUpdate);
	        preparedStatement.setString(1, tk.getID());
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
    public int getROLEbyTK(String tk) {
    	String sqlSelectAll = "select * from TAI_KHOAN where ROLE <> 0 and TK=?";
        try {
            dbUltils = new DBUtils();
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(sqlSelectAll);
            preparedStatement.setString(1, tk);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                return resultSet.getInt("ROLE");
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
        return 0;
    }

}
