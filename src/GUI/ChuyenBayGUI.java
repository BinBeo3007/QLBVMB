package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import BUS.ChuyenBayBUS;
import BUS.DuongBayBUS;
import DTO.ChuyenBay;
import BUS.MayBayBUS;
import DAO.MayBayDAO;
import DTO.MayBay;
import BUS.VeBUS;
import DTO.Ve;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ChuyenBayGUI extends JPanel {
	JPanel panel;
	private JComboBox cbbmaMB;
	private JTable tblKH;
	private JTextField txtloai2;
	private JComboBox cmbmaDB;
	private JTextField txtve;
	private JTextField txtdi;
	private JTextField txtmaCB;
	JComboBox cbbFind;
	private JTextField txtFind;
	private JTextField txtloai1;
	private JTextField txtgio;
	private JSpinner txt1;
	private JSpinner txt2;
	public ChuyenBayGUI() {
		setLayout(null);

		panel= new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 866, 623);
		add(panel);
		panel.setLayout(null);
		initialize();
		 loadAllUsers();
	}
	
	private void initialize() {
		 JPanel pnlInforUser = new JPanel();
		 pnlInforUser.setBackground(Color.WHITE);
		 pnlInforUser.setBorder(new TitledBorder(UIManager
		 .getBorder("TitledBorder.border"),
		 "Th\u00F4ng tin chuyến bay", TitledBorder.LEADING,
		 TitledBorder.TOP, null, Color.BLUE));
		 pnlInforUser.setBounds(10, 11, 846, 285);
		 
		 panel.add(pnlInforUser);
		 pnlInforUser.setLayout(null);

		 JLabel lblMa = new JLabel("Mã Chuyến Bay");
		 lblMa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblMa.setBounds(10, 35, 96, 14);
		 pnlInforUser.add(lblMa);
		 
		 txtloai2 = new JTextField();
		 txtloai2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtloai2.setBounds(363, 117, 90, 20);
		 pnlInforUser.add(txtloai2);
		 txtloai2.setColumns(10);
		 txtloai2.setEditable(false);

		 JLabel lblLot = new JLabel("Mã Máy Bay");
		 lblLot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblLot.setBounds(10, 60, 71, 14);
		 pnlInforUser.add(lblLot);

		 MayBayBUS mbB= new MayBayBUS();
		 String[] maMB=mbB.getAllmaMB();
		 cbbmaMB = new JComboBox();
		 cbbmaMB.setModel(new DefaultComboBoxModel(maMB));
		 cbbmaMB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 cbbmaMB.setBounds(116, 57, 90, 20);
		 pnlInforUser.add(cbbmaMB);

		 JButton btnAdd = new JButton("Thêm mới");
		 btnAdd.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Actions-list-add-user-icon.png"));
		 btnAdd.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 addCB();
			 }
		 });
		 btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnAdd.setBounds(91, 191, 115, 31);
		 pnlInforUser.add(btnAdd);

		 JButton btnUpdate = new JButton("Cập nhật");
		 btnUpdate.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 updateCB();
			 }
		 });
		 btnUpdate
		 .setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Add-Male-User-icon.png"));
		 btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnUpdate.setBounds(216, 191, 107, 31);
		 pnlInforUser.add(btnUpdate);

		 JButton btnDelete = new JButton("Xóa");
		 btnDelete.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
			deleteCB();
		}
		 });
		 btnDelete
		 .setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Remove-Male-User-icon.png"));
		 btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnDelete.setBounds(346, 191, 107, 31);
		 pnlInforUser.add(btnDelete);
		 
		 JLabel lblTen = new JLabel("Mã Đường Bay");
		 lblTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblTen.setBounds(10, 91, 89, 14);
		 pnlInforUser.add(lblTen);
		 
		 DuongBayBUS dbB= new DuongBayBUS();
		 String[] maDB=dbB.getMaDB();
		 cmbmaDB = new JComboBox();
		 cmbmaDB.setModel(new DefaultComboBoxModel(maDB));
		 cmbmaDB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 cmbmaDB.setBounds(116, 88, 90, 20);
		 pnlInforUser.add(cmbmaDB);
		 
		 JLabel lblnamsinh = new JLabel("Số ghế loại 2");
		 lblnamsinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblnamsinh.setBounds(274, 120, 71, 14);
		 pnlInforUser.add(lblnamsinh);
		 
		 JLabel lblcmnd = new JLabel("Số ghế loại 1");
		 lblcmnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblcmnd.setBounds(274, 91, 79, 14);
		 pnlInforUser.add(lblcmnd);
		 
		 JLabel lblsdt = new JLabel("Giờ Bay");
		 lblsdt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblsdt.setBounds(10, 120, 71, 14);
		 pnlInforUser.add(lblsdt);
		 
		 txtve = new JTextField();
		 txtve.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtve.setColumns(10);
		 txtve.setBounds(363, 57, 90, 20);
		 pnlInforUser.add(txtve);
		 
		 txtdi = new JTextField();
		 txtdi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtdi.setColumns(10);
		 txtdi.setBounds(363, 32, 90, 20);
		 pnlInforUser.add(txtdi);
		 
		 txtmaCB = new JTextField();
		 txtmaCB.setEditable(false);
		 txtmaCB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtmaCB.setColumns(10);
		 txtmaCB.setBounds(116, 32, 90, 20);
		 pnlInforUser.add(txtmaCB);
		 
		 JButton btnGet = new JButton("Tìm kiếm");
		 btnGet.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_documents-07_1622836 (1).png"));
		 btnGet.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		JOptionPane.showMessageDialog(panel,
		 				 "Cập nhật dữ liệu thành công!", "Thông báo",
		 				 JOptionPane.INFORMATION_MESSAGE);
		 				 loadFindNV();
		 	}
		 });
		 btnGet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnGet.setBounds(346, 232, 107, 31);
		 pnlInforUser.add(btnGet);
		 
		 txtFind = new JTextField();
		 txtFind.setBounds(216, 233, 107, 31);
		 pnlInforUser.add(txtFind);
		 txtFind.setColumns(10);
		 
		 cbbFind = new JComboBox();
		 cbbFind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 cbbFind.setModel(new DefaultComboBoxModel(new String[] {"Mã CB", "Mã DB", "Ngày đi"}));
		 cbbFind.setBounds(91, 237, 115, 26);
		 pnlInforUser.add(cbbFind);
		 
		 JButton btnClear = new JButton("Clear");
		 btnClear.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_ilustracoes_04-09_1519785 (1).png"));
		 btnClear.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		txtgio.setText("");
		 		 txtdi.setText("");
		 		 txtmaCB.setText("");
		 		 txtve.setText("");
		 		 txtloai1.setText("");
		 		 txtloai2.setText("");
		 		loadAllUsers();
		 	}
		 });
		 btnClear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnClear.setBounds(364, 148, 89, 23);
		 pnlInforUser.add(btnClear);
		 
		 txtloai1 = new JTextField();
		 txtloai1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtloai1.setEditable(false);
		 txtloai1.setColumns(10);
		 txtloai1.setBounds(363, 86, 90, 20);
		 pnlInforUser.add(txtloai1);
		 
		 txtgio = new JTextField();
		 txtgio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtgio.setColumns(10);
		 txtgio.setBounds(116, 118, 90, 20);
		 pnlInforUser.add(txtgio);
		 
		 JLabel lblNgyKhiHnh = new JLabel("Ngày Đi");
		 lblNgyKhiHnh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblNgyKhiHnh.setBounds(274, 36, 79, 14);
		 pnlInforUser.add(lblNgyKhiHnh);
		 
		 JLabel lblNgyn = new JLabel("Ngày Đến");
		 lblNgyn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblNgyn.setBounds(274, 61, 71, 14);
		 pnlInforUser.add(lblNgyn);
		 
		 txt1 = new JSpinner();
		 txt1.setModel(new SpinnerNumberModel(200000, 200000, 350000, 50000));
		 txt1.setBounds(476, 86, 90, 20);
		 pnlInforUser.add(txt1);
		 
		 txt2 = new JSpinner();
		 txt2.setModel(new SpinnerNumberModel(50000, 50000, 200000, 50000));
		 txt2.setBounds(476, 118, 90, 20);
		 pnlInforUser.add(txt2);
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\plane-icon (2).png"));
		 lblNewLabel.setBounds(578, 21, 246, 223);
		 pnlInforUser.add(lblNewLabel);
		 
		 JLabel lblNewLabel_1 = new JLabel("Giá vé:");
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblNewLabel_1.setBounds(475, 56, 87, 19);
		 pnlInforUser.add(lblNewLabel_1);
		 
		 JButton btnPDF = new JButton("Print");
		 btnPDF.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		print();
		 	}
		 });
		 btnPDF.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\export (1).png"));
		 btnPDF.setBounds(117, 149, 89, 23);
		 pnlInforUser.add(btnPDF);

		 JPanel pnlDataUser = new JPanel();
		 pnlDataUser.setBackground(Color.WHITE);
		 pnlDataUser.setBorder(new TitledBorder(UIManager
		 .getBorder("TitledBorder.border"),
		 "D\u1EEF li\u1EC7u chuyến bay",
		 TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		 pnlDataUser.setBounds(10, 307, 846, 305);
		 panel.add(pnlDataUser);
		 pnlDataUser.setLayout(null);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 22, 826, 272);
		 pnlDataUser.add(scrollPane);
		 
		 	tblKH = new JTable();
		 	scrollPane.setViewportView(tblKH);
		 	tblKH.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		 	tblKH.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 	tblKH.addMouseListener(new MouseAdapter() {
		 		public void mouseClicked(MouseEvent arg0) {
			 		 int row = tblKH.getSelectedRow();
			 		 if (row != -1) {
			 			 txtmaCB.setText(tblKH.getValueAt(row, 0).toString());
			 			 cbbmaMB.setSelectedItem(tblKH.getValueAt(row, 1));
				 		 cmbmaDB.setSelectedItem(tblKH.getValueAt(row, 2));
				 		 txtgio.setText(tblKH.getValueAt(row, 3).toString());
			 			txtdi.setText(tblKH.getValueAt(row, 4).toString());
				 		 txtve.setText(tblKH.getValueAt(row, 5).toString());
				 		 txtloai1.setText(tblKH.getValueAt(row, 6).toString());
				 		 txtloai2.setText(tblKH.getValueAt(row, 7).toString());
				 		 Ve ve= new Ve();
				 		 ve.setMaCB(tblKH.getValueAt(row, 0).toString());
						 VeBUS vBUS= new VeBUS();
						 ve.setLoaiGhe(1);
						 int t=vBUS.getGiabyLoai(ve); 
						 txt1.setModel(new SpinnerNumberModel( t,100000, 350000, 50000));
						 ve.setLoaiGhe(2);
						  t=vBUS.getGiabyLoai(ve);
						 txt2.setModel(new SpinnerNumberModel(t,50000 , 150000, 50000));
						 


			 		 }
		 		 }
		 	});
		 }

		 /**
		  * Get all user to display table.
		  */
		 public void loadAllUsers() {
			 String[] header = {"Mã Chuyễn Bay","Mã Máy Bay",  "Mã Đường Bay" ,"Giờ Bay","Ngày Đi","Ngày Đến ","Số ghế loại 1", "Số ghế loại 2"};
			 DefaultTableModel dtm = new DefaultTableModel(header,0);
			 ArrayList<ChuyenBay> arr = new ArrayList<ChuyenBay>();
			 ChuyenBayBUS cbBUS = new ChuyenBayBUS();
			 arr = cbBUS.getAllCB();
			 ChuyenBay chuyenbay = new ChuyenBay();
			 for (int i = 0; i < arr.size(); i++) {
				 chuyenbay = arr.get(i);
				 if(chuyenbay.getTT()==1) {
					 String maCB =chuyenbay.getMaCB();
					 String maMB =chuyenbay.getMaMB();
					 String maDB =chuyenbay.getMaDB();
					 String gio = chuyenbay.getGioBay();
					 String ngaydi = chuyenbay.getNgayDi();
					 String ngayden =chuyenbay.getNgayDen();
					 String loai1 = ""+chuyenbay.getSogheloai1();
					 String loai2 =""+ chuyenbay.getSogheloa2();
					 Object[] row = {maCB,maMB,maDB, gio, ngaydi,ngayden, loai1, loai2};
					 dtm.addRow(row);
				 }
			 }
			 tblKH.setModel(dtm);
		 }
		 public void loadFindNV() {
			 String[] header = {"Mã Chuyễn Bay","Mã Máy Bay",  "Mã Đường Bay" ,"Giờ Bay","Ngày Đi","Ngày Đến ","Số ghế loại 1", "Số ghế loại 2"};
			 DefaultTableModel dtm = new DefaultTableModel(header,0);
			 ArrayList<ChuyenBay> arr = new ArrayList<ChuyenBay>();
			 ChuyenBayBUS cbBUS = new ChuyenBayBUS();
			 arr = cbBUS.getAllCB();
			 String temp = cbbFind.getSelectedItem().toString();
			 ChuyenBay chuyenbay = new ChuyenBay();
			 ChuyenBay cb = new ChuyenBay();
			 if(temp == "Mã CB") {
				 cb.setMaCB(txtFind.getText());
				 chuyenbay = cbBUS.getAllCBbymaCB(cb.getMaCB());
				 if(chuyenbay.getTT()==1) {
					 String maCB =chuyenbay.getMaCB();
					 String maMB =chuyenbay.getMaMB();
					 String maDB =chuyenbay.getMaDB();
					 String gio = chuyenbay.getGioBay();
					 String ngaydi = chuyenbay.getNgayDi();
					 String ngayden =chuyenbay.getNgayDen();
					 String loai1 = ""+chuyenbay.getSogheloai1();
					 String loai2 =""+ chuyenbay.getSogheloa2();
					 Object[] row = {maCB,maMB,maDB, gio, ngaydi,ngayden, loai1, loai2};
					 dtm.addRow(row);
				 }
			 }else {
				 if(temp == "Mã DB") {
				 cb.setMaDB(txtFind.getText());
				 arr= cbBUS.getAllCBbymaDB(cb);
			 	}
				 
				 else {
					 cb.setNgayDi(txtFind.getText());
					 arr =cbBUS.getAllCBbyngayDi(cb);
				 }
					 
				 
				 for (int i = 0; i < arr.size(); i++) {
					 chuyenbay = arr.get(i);
					 if(chuyenbay.getTT()==1) {
						 String maCB =chuyenbay.getMaCB();
						 String maMB =chuyenbay.getMaMB();
						 String maDB =chuyenbay.getMaDB();
						 String gio = chuyenbay.getGioBay();
						 String ngaydi = chuyenbay.getNgayDi();
						 String ngayden =chuyenbay.getNgayDen();
						 String loai1 = ""+chuyenbay.getSogheloai1();
						 String loai2 =""+ chuyenbay.getSogheloa2();
						 Object[] row = {maCB,maMB,maDB, gio, ngaydi,ngayden, loai1, loai2};
						 dtm.addRow(row);
					 }
				 }
			 }
			 tblKH.setModel(dtm);
		 }
		 public boolean checkTrong() {
			 if(txtdi.getText().equals("")&&txtve.getText().equals("")&&txtgio.getText().equals("")) {
				 JOptionPane.showMessageDialog(panel,
						 "Chưa điền hết thông tin!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
			return true;
		 }
		 public void addCB() {
			 if(checkTrong()) {
				 ChuyenBay chuyenbay = new ChuyenBay();
				 ChuyenBayBUS cbBUS = new ChuyenBayBUS();
				 chuyenbay.setMaCB("CB"+(cbBUS.getslCB()+1));
				 chuyenbay.setMaMB(cbbmaMB.getSelectedItem().toString());
				 chuyenbay.setMaDB(cmbmaDB.getSelectedItem().toString());
				 chuyenbay.setGioBay(txtgio.getText());
				 chuyenbay.setNgayDi(txtdi.getText());
				 chuyenbay.setNgayDen(txtve.getText());
				 MayBay mb =new MayBay();
				 mb.setMaMB(chuyenbay.getMaMB());
				 MayBayBUS mbBUS= new MayBayBUS();
				 ArrayList<MayBay> listmb=mbBUS.getMBbyMaMB(mb);
				 for(int i= 0; i< listmb.size();i++) {
					 mb = listmb.get(i);
					 chuyenbay.setSogheloai1(mb.getGheloai1());
					 chuyenbay.setSogheloa2(mb.getGheloai2());
				 }
				 
				 
				 try {
					 if(ChuyenBay.checkNgay(chuyenbay.getNgayDi(),chuyenbay.getNgayDen())&&ChuyenBay.gio(chuyenbay.getGioBay())) {
						 int result = cbBUS.insertChuyenBay(chuyenbay);
						 JOptionPane.showMessageDialog(panel,
						 "Thêm dữ liệu thành công!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
						 Ve ve= new Ve();
						 VeBUS vBUS= new VeBUS();
						 int ghe1=chuyenbay.getSogheloai1();
						 int ghe2=chuyenbay.getSogheloa2();
						 String s="";
						 for(int i =1; i<=(ghe1+ghe2);i++) {
							 ve.setMaCB(chuyenbay.getMaCB());
							 if(i<10){
								 s="0";
							 }
							 if(i<=ghe1) {
								 ve.setMaVe(""+s+i+"_"+chuyenbay.getMaCB()+"_1");
								 ve.setLoaiGhe(1);
								 ve.setGiaTien((Integer)txt1.getValue()); 
							 }
							 else {
								 ve.setMaVe(""+s+i+"_"+chuyenbay.getMaCB()+"_2");
								 ve.setLoaiGhe(2);
								 ve.setGiaTien((Integer)txt2.getValue()); 
							 }
							 result = vBUS.insertVe(ve);
							 s="";
						 
						 }
					 }
					 else
						 JOptionPane.showMessageDialog(panel,
								 "Nhập ngày / giờ không đúng định dạng!", "Thông báo",
								 JOptionPane.INFORMATION_MESSAGE);
					
				 } catch (Exception ex) {
				     ex.printStackTrace();
				 }
			 }
			 else
				 JOptionPane.showMessageDialog(panel,
						 "Cập nhật liệu thất bại!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
			 loadAllUsers();
		 }
		 public void updateCB() {
			 if(checkTrong()) {
				 ChuyenBay chuyenbay = new ChuyenBay();
				 chuyenbay.setMaCB(txtmaCB.getText());
				 chuyenbay.setMaMB(cbbmaMB.getSelectedItem().toString());
				 chuyenbay.setMaDB(cmbmaDB.getSelectedItem().toString());
				 chuyenbay.setGioBay(txtgio.getText());
				 chuyenbay.setNgayDi(txtdi.getText());
				 chuyenbay.setNgayDen(txtve.getText());
				 MayBay mb =new MayBay();
				 mb.setMaMB(chuyenbay.getMaMB());
				 MayBayBUS mbBUS= new MayBayBUS();
				 ArrayList<MayBay> listmb=mbBUS.getMBbyMaMB(mb);
				 for(int i= 0; i< listmb.size();i++) {
					 mb = listmb.get(i);
					 chuyenbay.setSogheloai1(mb.getGheloai1());
					 chuyenbay.setSogheloa2(mb.getGheloai2());
				 }
				 
				 ChuyenBayBUS cbBUS = new ChuyenBayBUS();
				 try {
					 if(ChuyenBay.checkNgay(chuyenbay.getNgayDi(),chuyenbay.getNgayDen())&&ChuyenBay.gio(chuyenbay.getGioBay())) {

						 cbBUS.updateChuyenBay(chuyenbay);
						 JOptionPane.showMessageDialog(panel,
							 "Cập nhật dữ liệu thành công!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
						 Ve ve= new Ve();
						 VeBUS vBUS= new VeBUS();
						 int ghe1=chuyenbay.getSogheloai1();
						 int ghe2=chuyenbay.getSogheloa2();
						 for(int i =1; i<=(ghe1+ghe2);i++) {
							 ve.setMaCB(chuyenbay.getMaCB());

							 if(i<=ghe1) {						
								 ve.setLoaiGhe(1);
								 ve.setGiaTien((Integer)txt1.getValue());
								 
								 
							 }
							 else {
								 ve.setLoaiGhe(2);
								 ve.setGiaTien((Integer)txt2.getValue()); 
							 }
							 int result = vBUS.updateGiaVe(ve);
						 }
					 }
					 else
						 JOptionPane.showMessageDialog(panel,
								 "Nhập ngày / giờ không đúng định dạng!", "Thông báo",
								 JOptionPane.INFORMATION_MESSAGE);
					 loadAllUsers();
				 } catch (Exception ex) {
				     ex.printStackTrace();
				 }
			 
			 }
			 else
				 JOptionPane.showMessageDialog(panel,
						 "Cập nhật liệu thất bại!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
			 loadAllUsers();
	 
	 	}
			 
		 public void deleteCB() {
			 ChuyenBay chuyenbay = new ChuyenBay();
			 chuyenbay.setMaCB(txtmaCB.getText());
			 ChuyenBayBUS cbBUS = new ChuyenBayBUS();
			 int choice = JOptionPane.showConfirmDialog(panel,
			 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
			 JOptionPane.YES_NO_OPTION);
			 if (choice == JOptionPane.YES_OPTION) {
				 try {
					 JOptionPane.showMessageDialog(panel,
						 "Xóa dữ liệu thành công!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
					 @SuppressWarnings("unused")
					 Ve ve= new Ve();
					 VeBUS vBUS= new VeBUS();
					 ve.setMaCB(chuyenbay.getMaCB());
					 int result=vBUS.deleteVe(ve);
					  result = cbBUS.deleteChuyenBay(chuyenbay);
					 
					 loadAllUsers();
					 } catch (Exception ex) {
						 ex.printStackTrace();
				 }
			 }
		 }
		 public void print() {
			 try {
					String filename="C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\ChuyenBay.pdf";
					Document document =new Document();
					PdfWriter.getInstance(document, new FileOutputStream(filename));
					document.open();
					Paragraph para =new Paragraph("Chuyen Bay");
					para.setAlignment(Element.ALIGN_CENTER);
					document.add(para);
					PdfPTable t = new PdfPTable(6);
					t.setSpacingBefore(25);
					t.setSpacingAfter(25);

					PdfPCell c1 = new PdfPCell(new Phrase("Ma CB"));
					t.addCell(c1);
					PdfPCell c2 = new PdfPCell(new Phrase("Ma DB"));
					t.addCell(c2);
					PdfPCell c3 = new PdfPCell(new Phrase("Ma MB"));
					t.addCell(c3);
					PdfPCell c4 = new PdfPCell(new Phrase("Gio Bay"));
					t.addCell(c4);
					PdfPCell c5 = new PdfPCell(new Phrase("Ngay khoi hanh"));
					t.addCell(c5);
					PdfPCell c6 = new PdfPCell(new Phrase("Ngay den"));
					t.addCell(c6);
					ArrayList<ChuyenBay> arr = new ArrayList<ChuyenBay>();
					 ChuyenBayBUS cbBUS = new ChuyenBayBUS();
					 arr = cbBUS.getAllCB();
					 ChuyenBay chuyenbay = new ChuyenBay();
					 for (int i = 0; i < arr.size(); i++) {
						 chuyenbay = arr.get(i);
						 if(chuyenbay.getTT()==1) {
							 t.addCell(""+chuyenbay.getMaCB());
								t.addCell(""+chuyenbay.getMaDB());
								t.addCell(""+chuyenbay.getMaMB());
								t.addCell(""+chuyenbay.getGioBay());
								t.addCell(""+chuyenbay.getNgayDi());
								t.addCell(""+chuyenbay.getNgayDen());
						 }
					 }
					document.add(t);
					
					
					document.close();
					 JOptionPane.showMessageDialog(panel,
							 "OK!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
}
