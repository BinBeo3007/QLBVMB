package GUI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import BUS.ChucVuBUS;
import DTO.NhanVien;
import DTO.TaiKhoan;
import DTO.ChucVu;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

public class NhanVienGUI extends JPanel {
	JPanel panel;
	private JTextField txtmaNV;
	private JTextField txtHo;
	private JTextField txtLot;
	private JComboBox<String> cmbCV;
	private JTable tblNV;
	private JTextField txtTen;
	private JTextField txtNamSinh;
	private JTextField txtcmnd;
	private JTextField txtsdt;
	private JTextField txtdiachi;
	JComboBox cbbFind;
	/**
	 * Create the panel.
	 */
	private JTextField txtFind;
	private JTextField txtmk;
	private JTextField txttaikhoan;
	private JTextField txtmk2;
	
	public NhanVienGUI() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 866, 627);
		add(panel);
		panel.setLayout(null);
		initialize();
		 loadAllUsers();
	}
	 /**
	  * Initialize the contents of the frame.
	  */
	 private void initialize() {
		 JPanel pnlInforUser = new JPanel();
		 pnlInforUser.setBackground(Color.WHITE);
		 pnlInforUser.setBorder(new TitledBorder(UIManager
		 .getBorder("TitledBorder.border"),
		 "Th\u00F4ng tin nhân viên", TitledBorder.LEADING,
		 TitledBorder.TOP, null, Color.BLUE));
		 pnlInforUser.setBounds(10, 11, 846, 285);
		 
		 panel.add(pnlInforUser);
		 pnlInforUser.setLayout(null);

		 JLabel lblMa = new JLabel("Mã NV");
		 lblMa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblMa.setBounds(10, 33, 52, 14);
		 pnlInforUser.add(lblMa);

		 txtmaNV = new JTextField();
		 txtmaNV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtmaNV.setBounds(72, 30, 90, 20);
		 pnlInforUser.add(txtmaNV);
		 txtmaNV.setColumns(10);
		 txtmaNV.setEditable(false);

		 JLabel lblHo = new JLabel("Họ");
		 lblHo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblHo.setBounds(10, 61, 71, 14);
		 pnlInforUser.add(lblHo);

		 txtHo = new JTextField();
		 txtHo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtHo.setColumns(10);
		 txtHo.setBounds(72, 58, 90, 20);
		 pnlInforUser.add(txtHo);

		 JLabel lblLot = new JLabel("Lót");
		 lblLot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblLot.setBounds(10, 89, 52, 14);
		 pnlInforUser.add(lblLot);

		 txtLot = new JTextField();
		 txtLot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtLot.setColumns(10);
		 txtLot.setBounds(72, 86, 90, 20);
		 pnlInforUser.add(txtLot);

		 JLabel lblChucVu = new JLabel("Chức Vụ");
		 lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblChucVu.setBounds(10, 151, 52, 14);
		 pnlInforUser.add(lblChucVu);

		 JButton btnAdd = new JButton("Thêm mới");
		 btnAdd.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Actions-list-add-user-icon.png"));
		 btnAdd.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 addNV();
			 }
		 });
		 btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnAdd.setBounds(10, 191, 115, 31);
		 pnlInforUser.add(btnAdd);

		 JButton btnUpdate = new JButton("Cập nhật");
		 btnUpdate.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				updateNV();
			 
			 }
		 });
		 btnUpdate
		 .setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Add-Male-User-icon.png"));
		 btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnUpdate.setBounds(135, 191, 107, 31);
		 pnlInforUser.add(btnUpdate);

		 JButton btnDelete = new JButton("Xóa");
		 btnDelete.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				deleteNV();
			 }
		 });
		 btnDelete
		 .setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Remove-Male-User-icon.png"));
		 btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnDelete.setBounds(252, 191, 107, 31);
		 pnlInforUser.add(btnDelete);

		 ChucVuBUS cvB= new ChucVuBUS();
		 String[] Chucvu = cvB.getChucVu();
		 cmbCV = new JComboBox<String>();
		 cmbCV.setModel(new DefaultComboBoxModel(Chucvu));
		 cmbCV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 cmbCV.setBounds(72, 148, 90, 20);
		 pnlInforUser.add(cmbCV);
		 
		 JLabel lblTen = new JLabel("Tên");
		 lblTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblTen.setBounds(10, 120, 52, 14);
		 pnlInforUser.add(lblTen);
		 
		 txtTen = new JTextField();
		 txtTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtTen.setColumns(10);
		 txtTen.setBounds(72, 117, 90, 20);
		 pnlInforUser.add(txtTen);
		 
		 JLabel lblnamsinh = new JLabel("Năm sinh");
		 lblnamsinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblnamsinh.setBounds(172, 33, 71, 14);
		 pnlInforUser.add(lblnamsinh);
		 
		 JLabel lblcmnd = new JLabel("CMND");
		 lblcmnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblcmnd.setBounds(172, 61, 71, 14);
		 pnlInforUser.add(lblcmnd);
		 
		 JLabel lblsdt = new JLabel("Số ĐT");
		 lblsdt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblsdt.setBounds(172, 89, 71, 14);
		 pnlInforUser.add(lblsdt);
		 
		 JLabel lblmatkhau = new JLabel("Địa chỉ");
		 lblmatkhau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblmatkhau.setBounds(172, 120, 71, 14);
		 pnlInforUser.add(lblmatkhau);
		 
		 txtNamSinh = new JTextField();
		 txtNamSinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtNamSinh.setColumns(10);
		 txtNamSinh.setBounds(233, 30, 90, 20);
		 pnlInforUser.add(txtNamSinh);
		 
		 txtcmnd = new JTextField();
		 txtcmnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtcmnd.setColumns(10);
		 txtcmnd.setBounds(233, 58, 90, 20);
		 pnlInforUser.add(txtcmnd);
		 
		 txtsdt = new JTextField();
		 txtsdt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtsdt.setColumns(10);
		 txtsdt.setBounds(233, 86, 90, 20);
		 pnlInforUser.add(txtsdt);
		 
		 txtdiachi = new JTextField();
		 txtdiachi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtdiachi.setColumns(10);
		 txtdiachi.setBounds(233, 117, 90, 20);
		 pnlInforUser.add(txtdiachi);
		 
		 JButton btnGet = new JButton("Tìm kiếm");
		 btnGet.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_documents-07_1622836 (1).png"));
		 btnGet.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		JOptionPane.showMessageDialog(panel,
		 				 "Đang tìm kiếm ...!", "Thông báo",
		 				 JOptionPane.INFORMATION_MESSAGE);
		 				 loadFindNV();
		 	}
		 });
		 btnGet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnGet.setBounds(252, 233, 107, 31);
		 pnlInforUser.add(btnGet);
		 
		 txtFind = new JTextField();
		 txtFind.setBounds(135, 233, 107, 31);
		 pnlInforUser.add(txtFind);
		 txtFind.setColumns(10);
		 
		 cbbFind = new JComboBox();
		 cbbFind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 cbbFind.setModel(new DefaultComboBoxModel(new String[] {"Tên", "Mã chức vụ", "Họ","Mã NV"}));
		 cbbFind.setBounds(10, 234, 115, 26);
		 pnlInforUser.add(cbbFind);
		 
		 JButton btnClear = new JButton("Clear");
		 btnClear.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_ilustracoes_04-09_1519785 (1).png"));
		 btnClear.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		clear();
		 		loadAllUsers();
		 	}
		 });
		 btnClear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnClear.setBounds(233, 147, 89, 23);
		 pnlInforUser.add(btnClear);
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\dd.png"));
		 lblNewLabel.setBounds(577, 11, 259, 252);
		 pnlInforUser.add(lblNewLabel);
		 
		 txtmk = new JTextField();
		 txtmk.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtmk.setColumns(10);
		 txtmk.setBounds(427, 58, 90, 20);
		 pnlInforUser.add(txtmk);
		 
		 JLabel lblnamsinh_1 = new JLabel("Tài khoản");
		 lblnamsinh_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblnamsinh_1.setBounds(346, 33, 71, 14);
		 pnlInforUser.add(lblnamsinh_1);
		 
		 JLabel lblnamsinh_2 = new JLabel("Mật khẩu");
		 lblnamsinh_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblnamsinh_2.setBounds(346, 61, 71, 14);
		 pnlInforUser.add(lblnamsinh_2);
		 
		 JLabel lblnamsinh_3 = new JLabel("Xác nhận");
		 lblnamsinh_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblnamsinh_3.setBounds(346, 90, 71, 14);
		 pnlInforUser.add(lblnamsinh_3);
		 
		 txttaikhoan = new JTextField();
		 txttaikhoan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txttaikhoan.setColumns(10);
		 txttaikhoan.setBounds(427, 31, 90, 20);
		 pnlInforUser.add(txttaikhoan);
		 
		 txtmk2 = new JTextField();
		 txtmk2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtmk2.setColumns(10);
		 txtmk2.setBounds(427, 87, 90, 20);
		 pnlInforUser.add(txtmk2);
		 
		 JButton btnNewButton = new JButton("Create");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		addTK();
		 	}
		 });
		 btnNewButton.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_tick_blue_619551 (1).png"));
		 btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		 btnNewButton.setBounds(428, 117, 89, 23);
		 pnlInforUser.add(btnNewButton);
		 
		 JButton btnInport = new JButton("Inport");
		 btnInport.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		NhanVienBUS nvB =new NhanVienBUS();
		 		try {
					importNV();
					JOptionPane.showMessageDialog(panel,
							 "Loading...!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 	}
		 });
		 btnInport.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\import (1).png"));
		 btnInport.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnInport.setBounds(402, 191, 115, 31);
		 pnlInforUser.add(btnInport);
		 
		 JButton btnExport = new JButton("Export");
		 btnExport.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		NhanVienBUS nvB =new NhanVienBUS();
		 		exportNV();
				JOptionPane.showMessageDialog(panel,
						 "Loading...!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
		 	}
		 });
		 btnExport.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\export (1).png"));
		 btnExport.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnExport.setBounds(402, 233, 115, 31);
		 pnlInforUser.add(btnExport);

		 JPanel pnlDataUser = new JPanel();
		 pnlDataUser.setBackground(Color.WHITE);
		 pnlDataUser.setBorder(new TitledBorder(UIManager
		 .getBorder("TitledBorder.border"),
		 "D\u1EEF li\u1EC7u nhân viên",
		 TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		 pnlDataUser.setBounds(10, 307, 846, 309);
		 panel.add(pnlDataUser);
		 pnlDataUser.setLayout(null);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 22, 826, 276);
		 pnlDataUser.add(scrollPane);
		 
		 	tblNV = new JTable();
		 	scrollPane.setViewportView(tblNV);
		 	tblNV.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		 	tblNV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 	tblNV.addMouseListener(new MouseAdapter() {
		 		public void mouseClicked(MouseEvent arg0) {
			 		 int row = tblNV.getSelectedRow();
			 		 if (row != -1) {
				 		 txtmaNV.setText(tblNV.getValueAt(row, 0).toString());
				 		 txtHo.setText(tblNV.getValueAt(row, 1).toString());
				 		 txtLot.setText(tblNV.getValueAt(row, 2).toString());
				 		 txtTen.setText(tblNV.getValueAt(row, 3).toString());
				 		 String temp =tblNV.getValueAt(row, 4).toString().trim();
				 		 ChucVuBUS cvBUS = new ChucVuBUS();
	
				 		 cmbCV.setSelectedItem(cvBUS.getChucVuByMaCV(cvBUS.getMaCVbyTenCV(temp)));
				 		 txtcmnd.setText(tblNV.getValueAt(row, 5).toString());
				 		 txtsdt.setText(tblNV.getValueAt(row, 6).toString());
				 		 txtNamSinh.setText(tblNV.getValueAt(row, 7).toString());
				 		 txtdiachi.setText(tblNV.getValueAt(row, 8).toString());
			 		 }
		 		 }
		 	});
		 }

		 /**
		  * Get all user to display table.
		  */
		 public void loadAllUsers() {
			 String[] header = { "Mã nhân viên", "Họ" ,"Lót", "Tên", "Chức vụ", "CMND"," Số ĐT", "Năm sinh" ,"Địa chỉ"};
			 DefaultTableModel dtm = new DefaultTableModel(header, 0);
			 ArrayList<NhanVien> arr = new ArrayList<NhanVien>();
			 NhanVienBUS nvBUS = new NhanVienBUS();
			 arr = nvBUS.getAllNhanVien();
			 
			 ChucVuBUS chucvuBUS =new ChucVuBUS();
			 NhanVien nhanvien = new NhanVien();
			 for (int i = 0; i < arr.size(); i++) {
				 nhanvien = arr.get(i);
				if(nhanvien.getTT()==1) {
					
					int manv = nhanvien.getMaNV();
					 String ho = nhanvien.getHoNV();
					 String lot = nhanvien.getLotNV();
					 String ten = nhanvien.getTenNV();
					 String tencv = chucvuBUS.getChucVuByMaCV(nhanvien.getMaCV());
					 String cmnd = nhanvien.getCMND();
					 String sdt = nhanvien.getSdt();
					 String diachi = nhanvien.getDiachi();
					 String namsinh = ""+nhanvien.getNamsinh();
					 Object[] row = { manv, ho, lot, ten, tencv, cmnd,sdt,namsinh,diachi };
					 dtm.addRow(row);
				}
				 
			 }
			 tblNV.setModel(dtm);
		 }
		 public void loadFindNV() {
			 String[] header = { "Mã nhân viên", "Họ" ,"Lót", "Tên", "Chức vụ", "CMND"," Số ĐT", "Năm sinh" ,"Địa chỉ"};
			 DefaultTableModel dtm = new DefaultTableModel(header, 0);
			 ArrayList<NhanVien> arr = new ArrayList<NhanVien>();
			 NhanVienBUS nvBUS = new NhanVienBUS();
			 NhanVien nhanvien = new NhanVien();
			 String temp = cbbFind.getSelectedItem().toString();
			 if(temp == "Tên") {
				 arr = nvBUS.getNhanVienbyTenNV(txtFind.getText());
			 }else {
				 if(temp == "Mã chức vụ")
					 arr= nvBUS.getNhanVienbyChucVu(txtFind.getText());
				 else {
					 if(temp=="Họ")
						 arr =nvBUS.getNhanVienbyHoNV(txtFind.getText());
					 else {
						 String s =txtFind.getText();
						 	if(s.matches("\\d+"))
						 		nhanvien.setMaNV(Integer.parseInt(s));
						 	else 
						 		nhanvien.setMaNV(0);
						 	
						 	arr=nvBUS.getNhanVienbyMaNV(nhanvien);
					 }
				 }
					 
			 }
			 ChucVuBUS chucvuBUS =new ChucVuBUS();
			 for (int i = 0; i < arr.size(); i++) {
					 nhanvien = arr.get(i);
					 if(nhanvien.getTT()==1) {
							
							int manv = nhanvien.getMaNV();
							 String ho = nhanvien.getHoNV();
							 String lot = nhanvien.getLotNV();
							 String ten = nhanvien.getTenNV();
			
							 
							 String tencv = chucvuBUS.getChucVuByMaCV(nhanvien.getMaCV());
							 String cmnd = nhanvien.getCMND();
							 String sdt = nhanvien.getSdt();
							 String diachi = nhanvien.getDiachi();
							 String namsinh = ""+nhanvien.getNamsinh();
							 Object[] row = { manv, ho, lot, ten, tencv, cmnd,sdt,namsinh,diachi };
							 dtm.addRow(row);
						}
			 }
			 tblNV.setModel(dtm);
		 }
		 public void clear() {
			 txtmaNV.setText("");
	 		 txtHo.setText("");
	 		 txtLot.setText("");
	 		 txtTen.setText("");
	 		 txtcmnd.setText("");
	 		 txtsdt.setText("");
	 		 txtNamSinh.setText("");
	 		 txtdiachi.setText("");
	 		 txttaikhoan.setText("");
	 		 txtmk.setText("");
	 		 txtmk2.setText("");
	 		 
		 }
		 public boolean checkTrong() {
			 if(txtcmnd.getText().equals("")||txtHo.getText().equals("")||txtLot.getText().equals("")||txtTen.getText().equals("")
					 || txtsdt.getText().equals("")||txtdiachi.getText().equals("")||txtNamSinh.getText().equals("")) {
				 JOptionPane.showMessageDialog(panel,
						 "Chưa điền hết thông tin!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
				 return false;
			 }
				
			return true;
		 }
		 public boolean checkSo() {
				if(txtNamSinh.getText().matches("\\d+")&&txtsdt.getText().matches("\\d+")&&txtcmnd.getText().matches("\\d+")) {
					return true;
				}
				JOptionPane.showMessageDialog(panel,
						 "Thông tin chưa chính xác", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
				return false;
		}
		 public void addNV() {
			 if(checkSo()&&checkTrong()) {
				 NhanVien nhanvien = new NhanVien();
				 nhanvien.setHoNV(txtHo.getText());
				 nhanvien.setLotNV(txtLot.getText());
				 nhanvien.setTenNV(txtTen.getText());
				 ChucVuBUS cvB=new ChucVuBUS();
				 nhanvien.setMaCV(cvB.getMaCVbyTenCV((String) cmbCV.getSelectedItem()));
				 nhanvien.setCMND(txtcmnd.getText());
				 nhanvien.setSdt(txtsdt.getText());
				 nhanvien.setDiachi(txtdiachi.getText());
				 nhanvien.setNamsinh(Integer.parseInt(txtNamSinh.getText()));
				 NhanVienBUS nvBUS = new NhanVienBUS();
				 try {
					 int result = nvBUS.insertNhanVien(nhanvien);
					 if (result != 0) {
						 JOptionPane.showMessageDialog(panel,
						 "Thêm dữ liệu thành công!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
					 }
					 else
						 JOptionPane.showMessageDialog(panel,
								 "Thêm dữ liệu thất bại!", "Thông báo",
								 JOptionPane.INFORMATION_MESSAGE);
					 loadAllUsers();
				 } catch (Exception ex) {
				     ex.printStackTrace();
				 }
			 }
			 else
				 JOptionPane.showMessageDialog(panel,
						 "Thêm dữ liệu thất bại!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
			 
		 }
		 public void updateNV() {
			 if(checkSo()&&checkTrong()) {
				 NhanVien nhanvien = new NhanVien();
				 nhanvien.setHoNV(txtHo.getText());
				 nhanvien.setLotNV(txtLot.getText());
				 nhanvien.setTenNV(txtTen.getText());
				 ChucVuBUS cvB=new ChucVuBUS();
				 nhanvien.setMaCV(cvB.getMaCVbyTenCV((String) cmbCV.getSelectedItem()));
				 nhanvien.setCMND(txtcmnd.getText());
				 nhanvien.setSdt(txtsdt.getText());
				 nhanvien.setDiachi(txtdiachi.getText());
				 nhanvien.setNamsinh(Integer.parseInt(txtNamSinh.getText()));
				 nhanvien.setMaNV(Integer.parseInt(txtmaNV.getText()));
				 NhanVienBUS nvBUS = new NhanVienBUS();
				 
				 int result = nvBUS.updateNhanVien(nhanvien);
				 if (result != 0) {
					 JOptionPane.showMessageDialog(panel,
					 "Cập nhật dữ liệu thành công!", "Thông báo",
					 JOptionPane.INFORMATION_MESSAGE);
					 loadAllUsers();
				 }
				 else
					 JOptionPane.showMessageDialog(panel,
							 "Cập nhật liệu thất bại!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
			 }
			 else
				 JOptionPane.showMessageDialog(panel,
						 "Cập nhật liệu thất bại!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
		 }
		 public void deleteNV() {
			 NhanVien nhanvien = new NhanVien();
			 nhanvien.setMaNV(Integer.parseInt(txtmaNV.getText()));
			 nhanvien.setTT(0);
			 NhanVienBUS nvBUS = new NhanVienBUS();
			 int choice = JOptionPane.showConfirmDialog(panel,
			 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
			 JOptionPane.YES_NO_OPTION);
			 if (choice == JOptionPane.YES_OPTION) {
				 try {
				
				 int result = nvBUS.updateTT(nhanvien);
				 if(result !=0){
					 TaiKhoanBUS tkB=new TaiKhoanBUS();
					 TaiKhoan tk =new TaiKhoan();
					 tk.setID("NV"+txtmaNV.getText());
					 tkB.deleteTK(tk);
					 JOptionPane.showMessageDialog(panel,
							 "Xóa dữ liệu thành công!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
				 }	 
				 else
					 JOptionPane.showMessageDialog(panel,
							 "Xóa dữ liệu thất bại!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
				 loadAllUsers();
				 } catch (Exception ex) {
					 ex.printStackTrace();
				 }
			 }
		 }
		 public boolean checkMK() {

				if(!txtmk.getText().equals(txtmk2.getText())) {
					JOptionPane.showMessageDialog(panel,
							 "Mật khẩu sai!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
					return false;
				}
				return true;
			}
		 
		 public void createTK() {
				TaiKhoanBUS tkB=new TaiKhoanBUS();
				if(!tkB.checkTK(txttaikhoan.getText())) {
					if(!checkMK()) {
						return;
					}
					TaiKhoan tk =new TaiKhoan();
					tk.setID("NV"+txtmaNV.getText());
					tk.setMa(Integer.parseInt(txtmaNV.getText()));
					tk.setTk(txttaikhoan.getText());
					tk.setMk(txtmk.getText());
					tk.setRole(2);
					int result = tkB.creatTK(tk);	
					JOptionPane.showMessageDialog(panel,
							 "Tạo tài khoản thành công!!!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(panel,
							 "Trùng tên tài khoản!!!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
				
			}
		 public void updateTK(){
				TaiKhoanBUS tkB=new TaiKhoanBUS();
				if(tkB.checkTK(txttaikhoan.getText())) {
					if(!checkMK()) {
						return;
					}
					TaiKhoan tk =new TaiKhoan();
					tk.setID("NV"+txtmaNV.getText());
					tk.setTk(txttaikhoan.getText());
					tk.setMk(txtmk.getText());
					tk.setRole(1);
					int result = tkB.updateMK(tk);
					JOptionPane.showMessageDialog(panel,
							 "Cập nhật tài khoản thành công!!!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(panel,
							 "Sai tên tài khoản!!!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
			}
		 public void addTK() {
				if(!txtmaNV.getText().equals("")) {
					TaiKhoanBUS tkB=new TaiKhoanBUS();
					String id ="NV"+txtmaNV.getText();
					if(txttaikhoan.getText().equals("")||txtmk.getText().equals("")||txtmk2.getText().equals("")) {
						JOptionPane.showMessageDialog(panel,
								 "Chưa điền hết thông tin!!!", "Thông báo",
								 JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						if(tkB.checkID(id))
							createTK();
						else
							updateTK();
						
					}
				}
				else {
					JOptionPane.showMessageDialog(panel,
							 "Chưa chọn nhân viên !!!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
				}
		}
		 public void exportNV() {
		        try {
		            XSSFWorkbook workbook = new XSSFWorkbook();
		            XSSFSheet spreadsheet = workbook.createSheet("NhanVien");

		            XSSFRow row = null;
		            Cell cell = null;

		            row = spreadsheet.createRow((short) 0);
		            row.setHeight((short) 500);
		            cell = row.createCell(0, CellType.STRING);
		            cell.setCellValue("DANH SASCH NHAN VIEN");

		            row = spreadsheet.createRow((short) 3);
		            row.setHeight((short) 500);
		            cell = row.createCell(0, CellType.STRING);
		            cell.setCellValue("MA NV");
		            cell = row.createCell(1, CellType.STRING);
		            cell.setCellValue("HO VA TEN");
		            cell = row.createCell(2, CellType.STRING);
		            cell.setCellValue("NAM SINH");
		            cell = row.createCell(3, CellType.STRING);
		            cell.setCellValue("SDT");
		            cell = row.createCell(4, CellType.STRING);
		            cell.setCellValue("DIA CHI");
		            cell = row.createCell(5, CellType.STRING);
		            cell.setCellValue("CMND");
		            cell = row.createCell(6, CellType.STRING);
		            cell.setCellValue("MA CV");

		            NhanVienBUS nvb = new NhanVienBUS();

		            List<NhanVien> listItem = nvb.getAllNhanVien();

		            for (int i = 0; i < listItem.size(); i++) {
		            	NhanVien nhanvien = listItem.get(i);
		                row = spreadsheet.createRow((short) 4 + i);
		                row.setHeight((short) 400);
		                row.createCell(0).setCellValue(nhanvien.getMaNV());
		                row.createCell(1).setCellValue(nhanvien.getHoTen().trim());
		                row.createCell(2).setCellValue(nhanvien.getNamsinh());
		                row.createCell(3).setCellValue(nhanvien.getSdt().trim());
		                row.createCell(4).setCellValue(nhanvien.getDiachi().trim());
		                row.createCell(5).setCellValue(nhanvien.getCMND().trim());
		                row.createCell(6).setCellValue(nhanvien.getMaCV().trim());
		                
		            }

		            FileOutputStream out = new FileOutputStream(new File("./NhanVienOut.xlsx"));
		            workbook.write(out);
		            out.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		 }
		 public void importNV() throws IOException {
			 FileInputStream excelFile;
			try {
				excelFile = new FileInputStream(new File("./NhanVienIn.xlsx"));
				 XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
			      XSSFSheet sheet = workbook.getSheetAt(0);
			      int noofRow =sheet.getLastRowNum();
			      NhanVien nhanvien =new NhanVien();
			      NhanVienBUS nvb = new NhanVienBUS();
			      for(int i =0;i<=noofRow;i++) {
			    	  nhanvien.setHoNV(sheet.getRow(i).getCell(0).toString());
			    	  nhanvien.setLotNV(sheet.getRow(i).getCell(1).toString());
			    	  nhanvien.setTenNV(sheet.getRow(i).getCell(2).toString());
			    	  String namsinh=sheet.getRow(i).getCell(3).toString();
			    		 int result= (int)Integer.parseInt(namsinh);
			    		 nhanvien.setNamsinh(result);
			    		 nhanvien.setSdt(sheet.getRow(i).getCell(4).toString());
			    		 nhanvien.setDiachi(sheet.getRow(i).getCell(5).toString());
			    		 nhanvien.setCMND(sheet.getRow(i).getCell(6).toString());
			    		 nhanvien.setMaCV(sheet.getRow(i).getCell(7).toString());
			    		 result= nvb.insertNhanVien(nhanvien);
			      }
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		 }
		 
}
