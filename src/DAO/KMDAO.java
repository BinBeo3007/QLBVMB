package DAO;

import DTO.KM;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KMDAO {
    private DBUtils dbUltils = null;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public ArrayList<KM> getAllKM(){
        ArrayList<KM> result = new ArrayList<KM>();
        String sqlSelectAll = "select * from KM";
        try {
            dbUltils = new DBUtils();
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(sqlSelectAll);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                KM km = new KM();
                km.setMakm(resultSet.getString("MA_KM"));
                km.setBatdau(resultSet.getString("BD"));
                km.setKetthuc(resultSet.getString("KT"));
                km.setPhantram(resultSet.getInt("SO"));
                result.add(km);
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
    public ArrayList<KM> getAllKMbyMaKM(String maKH){
        ArrayList<KM> result = new ArrayList<KM>();
        String sqlSelectAll = "select * from KM where MA_KM =?";
        try {
            dbUltils = new DBUtils();
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(sqlSelectAll);
            preparedStatement.setString(1,maKH);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                KM km = new KM();
                km.setMakm(resultSet.getString("MA_KM"));
                km.setBatdau(resultSet.getString("BD"));
                km.setKetthuc(resultSet.getString("KT"));
                km.setPhantram(resultSet.getInt("SO"));
                result.add(km);
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
    public KM getKMbyMaKM(String maKH){
        String sqlSelectAll = "select * from KM where MA_KM =?";
    	KM km = new KM();
        try {
        	 
            dbUltils = new DBUtils();
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(sqlSelectAll);
            preparedStatement.setString(1,maKH);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                km.setMakm(resultSet.getString("MA_KM"));
                km.setBatdau(resultSet.getString("BD"));
                km.setKetthuc(resultSet.getString("KT"));
                km.setPhantram(resultSet.getInt("SO"));
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
        return km;
    }
    public int getPhanTram(String maKH){
        int result = 0;
        String sqlSelectAll = "select * from KM where MA_KM =?";
        try {
            dbUltils = new DBUtils();
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(sqlSelectAll);
            preparedStatement.setString(1,maKH);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                result=resultSet.getInt("SO");
                return result;
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
    public int insertKM(KM km){
        int result=0;
        String sqlSelectAll = "insert into KM(MA_KM, BD, KT,SO) values ( ?, ?,?,?)";
        try {
            dbUltils = new DBUtils();
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(sqlSelectAll);
            preparedStatement.setString(1,km.getMakm());
            preparedStatement.setString(2,km.getBatdau());
            preparedStatement.setString(3,km.getKetthuc());
            preparedStatement.setInt(4,km.getPhantram());
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

    public int updateKM(KM km){
        int result=0;
        String sqlSelectAll = "update KM set  BD =? , KT =?,SO = ? where MA_KM = ?";
        try {
            dbUltils = new DBUtils();
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(sqlSelectAll);
            preparedStatement.setString(4,km.getMakm());
            preparedStatement.setString(1,km.getBatdau());
            preparedStatement.setString(2,km.getKetthuc());
            preparedStatement.setInt(3,km.getPhantram());
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
    public int deleteKM(String km){
        int result=0;
        String sqlSelectAll = "delete from KM where MA_KM = ?";
        try {
            dbUltils = new DBUtils();
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(sqlSelectAll);
            preparedStatement.setString(1,km);
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
