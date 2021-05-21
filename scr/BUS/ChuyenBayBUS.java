package BUS;


import java.util.ArrayList;




import DTO.ChuyenBay;

import DAO.ChuyenBayDAO;
public class ChuyenBayBUS {
	ChuyenBayDAO cbDAO= new ChuyenBayDAO();
	public ArrayList<ChuyenBay> getAllCB(){
		return cbDAO.getAllCB();
	}
	
	public ChuyenBay getAllCBbymaCB(String maCB){
		return cbDAO.getAllCBbymaCB(maCB);
	}
	
	public ArrayList<ChuyenBay> getAllCBbymaDB(ChuyenBay cb){
		return cbDAO.getAllCBbymaDB(cb);
	}
	public ArrayList<ChuyenBay> getAllCBbyngayDi(ChuyenBay cb){
		return cbDAO.getAllCBbyngayDi(cb);
	}
	
	public int deleteChuyenBay(ChuyenBay cb) {
		int result =cbDAO.deleteChuyenBay(cb);
		return result;
	}
	
	public int insertChuyenBay(ChuyenBay cb) {
		int result =cbDAO.insertChuyenBay(cb);
		return result;
	}
	
	public int updateChuyenBay(ChuyenBay cb) {
		int result =cbDAO.updateChuyenBay(cb);
		return result;
	}
	
	 public int checkTF(ChuyenBay cb) {
		 int result =cbDAO.checkTF(cb);
			return result;
	 }
	 
	 public ArrayList<ChuyenBay> getAllCBbymaDBDi(ChuyenBay chuyenbay){
		 return cbDAO.getAllCBbymaDBDi(chuyenbay);
	 }
	 public int getslCB() {
		 return cbDAO.getslCB();
	 }
	
	

}
