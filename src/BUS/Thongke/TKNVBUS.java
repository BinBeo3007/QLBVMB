package BUS.Thongke;

import java.util.ArrayList;

import DAO.Thongke.TKNVDAO;
import DTO.Thongke.TKNV;

public class TKNVBUS {
	TKNVDAO nvDAO =new TKNVDAO();
	
	public ArrayList<TKNV> getAll(){
		return nvDAO.getAll();
	}
	public ArrayList<TKNV> getAllbyma(int makh){
		return nvDAO.getAllbyma(makh);
	}
	public ArrayList<TKNV> getAllGiam(){
		return nvDAO.getAllGiam();
	}
	public ArrayList<TKNV> getAllTang(){
		return nvDAO.getAllTang();
	}

}
