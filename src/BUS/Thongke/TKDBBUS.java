package BUS.Thongke;

import java.util.ArrayList;

import DAO.Thongke.TKDBDAO;
import DTO.Thongke.TKDB;

public class TKDBBUS {
	TKDBDAO dbDAO =new TKDBDAO();
	
	public ArrayList<TKDB> getAll(){
		return dbDAO.getAll();
	}
	public ArrayList<TKDB> getAllbyma(String maDB){
		return dbDAO.getAllbyma(maDB);
	}
	public ArrayList<TKDB> getAllGiam(){
		return dbDAO.getAllGiam();
	}
	public ArrayList<TKDB> getAllTang(){
		return dbDAO.getAllTang();
	}
}
