package GUI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import BUS.ChuyenBayBUS;
import BUS.DuongBayBUS;
import BUS.MayBayBUS;
import BUS.VeBUS;
import DTO.ChuyenBay;
import DTO.MayBay;
import DTO.Ve;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;

public class thongtin_chuyenbay extends JPanel {
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
	private JTextField txt1;
	private JTextField txt2;
	public thongtin_chuyenbay() {
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
		 txtve.setEditable(false);
		 txtve.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtve.setColumns(10);
		 txtve.setBounds(363, 57, 90, 20);
		 pnlInforUser.add(txtve);
		 
		 txtdi = new JTextField();
		 txtdi.setEditable(false);
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
		 
		 txtloai1 = new JTextField();
		 txtloai1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtloai1.setEditable(false);
		 txtloai1.setColumns(10);
		 txtloai1.setBounds(363, 86, 90, 20);
		 pnlInforUser.add(txtloai1);
		 
		 txtgio = new JTextField();
		 txtgio.setEditable(false);
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
		 
		 txt1 = new JTextField();
		 txt1.setEditable(false);
		 txt1.setBounds(476, 86, 90, 20);
		 pnlInforUser.add(txt1);
		 
		 txt2 = new JTextField();
		 txt2.setEditable(false);
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
						 txt1.setText(""+t);
						 ve.setLoaiGhe(2);
						  t=vBUS.getGiabyLoai(ve);
						 txt2.setText(""+t);
						 


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
}
