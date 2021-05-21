package BUS.Thongke;

import java.util.ArrayList;

import DAO.Thongke.TKKHDAO;
import DTO.Thongke.TKKH;

public class TKHBUS {
	TKKHDAO khDAO =new TKKHDAO();
	
	public ArrayList<TKKH> getAll(){
		return khDAO.getAll();
	}
	public ArrayList<TKKH> getAllbyma(int makh){
		return khDAO.getAllbyma(makh);
	}
	public ArrayList<TKKH> getAllGiam(){
		return khDAO.getAllGiam();
	}
	public ArrayList<TKKH> getAllTang(){
		return khDAO.getAllTang();
	}

}
