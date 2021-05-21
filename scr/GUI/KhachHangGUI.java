package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.KhachHangBus;
import BUS.TaiKhoanBUS;
import DTO.KhachHang;
import DTO.TaiKhoan;

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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class KhachHangGUI extends JPanel {
	JPanel panel;
	private JTextField txtHo;
	private JTextField txtLot;
	private JTable tblKH;
	private JTextField txtmaKH;
	private JTextField txtTen;
	private JTextField txtNamSinh;
	private JTextField txtcmnd;
	private JTextField txtsdt;
	JComboBox cbbFind;
	private JTextField txtFind;
	private JTextField txtdiachi;
	private JTextField txttaikhoan;
	private JTextField txtmk;
	private JTextField txtmk2;

	/**
	 * Create the panel.
	 */
	
	
	
	public KhachHangGUI() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 866, 633);
		add(panel);
		panel.setLayout(null);
		initialize();
		loadAllUsers();
		clear();
	}
	private void initialize() {
		 JPanel pnlInforUser = new JPanel();
		 pnlInforUser.setBackground(Color.WHITE);
		 pnlInforUser.setBorder(new TitledBorder(UIManager
		 .getBorder("TitledBorder.border"),
		 "", TitledBorder.LEADING,
		 TitledBorder.TOP, null, Color.BLUE));
		 pnlInforUser.setBounds(10, 11, 846, 285);
		 
		 panel.add(pnlInforUser);
		 pnlInforUser.setLayout(null);

		 JLabel lblMa = new JLabel("Mã KH");
		 lblMa.setBounds(10, 14, 40, 14);
		 lblMa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlInforUser.add(lblMa);
		 
		 txtmaKH = new JTextField();
		 txtmaKH.setBounds(60, 11, 90, 20);
		 txtmaKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlInforUser.add(txtmaKH);
		 txtmaKH.setColumns(10);
		 txtmaKH.setEditable(false);
		 
		 JLabel lblHo = new JLabel("Họ");
		 lblHo.setBounds(10, 45, 40, 14);
		 lblHo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlInforUser.add(lblHo);

		 txtHo = new JTextField();
		 txtHo.setBounds(60, 42, 90, 20);
		 txtHo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtHo.setColumns(10);
		 pnlInforUser.add(txtHo);

		 JLabel lblLot = new JLabel("Lót");
		 lblLot.setBounds(10, 76, 40, 14);
		 lblLot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlInforUser.add(lblLot);

		 txtLot = new JTextField();
		 txtLot.setBounds(60, 73, 90, 20);
		 txtLot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtLot.setColumns(10);
		 pnlInforUser.add(txtLot);

		 JButton btnAdd = new JButton("Thêm mới");
		 btnAdd.setBounds(10, 191, 115, 31);
		 btnAdd.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Actions-list-add-user-icon.png"));
		 btnAdd.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 addKH();
			 }
		 });
		 btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlInforUser.add(btnAdd);

		 JButton btnUpdate = new JButton("Cập nhật");
		 btnUpdate.setBounds(135, 191, 107, 31);
		 btnUpdate.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
			 updateKH();
		 
		 }
		 });
		 btnUpdate
		 .setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Add-Male-User-icon.png"));
		 btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlInforUser.add(btnUpdate);

		 JButton btnDelete = new JButton("Xóa");
		 btnDelete.setBounds(252, 191, 107, 31);
		 btnDelete.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
			 deleteKH();
		}
		 });
		 btnDelete
		 .setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Remove-Male-User-icon.png"));
		 btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlInforUser.add(btnDelete);
		 
		 JLabel lblTen = new JLabel("Tên");
		 lblTen.setBounds(10, 107, 40, 14);
		 lblTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlInforUser.add(lblTen);
		 
		 txtTen = new JTextField();
		 txtTen.setBounds(60, 104, 90, 20);
		 txtTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtTen.setColumns(10);
		 pnlInforUser.add(txtTen);
		 
		 JLabel lblnamsinh = new JLabel("Năm sinh");
		 lblnamsinh.setBounds(178, 45, 64, 14);
		 lblnamsinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlInforUser.add(lblnamsinh);
		 
		 JLabel lblcmnd = new JLabel("CMND");
		 lblcmnd.setBounds(178, 14, 48, 14);
		 lblcmnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlInforUser.add(lblcmnd);
		 
		 JLabel lblsdt = new JLabel("Số ĐT");
		 lblsdt.setBounds(178, 76, 48, 14);
		 lblsdt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlInforUser.add(lblsdt);
		 
		 txtNamSinh = new JTextField();
		 txtNamSinh.setBounds(236, 42, 90, 20);
		 txtNamSinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtNamSinh.setColumns(10);
		 pnlInforUser.add(txtNamSinh);
		 
		 txtcmnd = new JTextField();
		 txtcmnd.setBounds(236, 11, 90, 20);
		 txtcmnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtcmnd.setColumns(10);
		 pnlInforUser.add(txtcmnd);
		 
		 txtsdt = new JTextField();
		 txtsdt.setBounds(236, 73, 90, 20);
		 txtsdt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtsdt.setColumns(10);
		 pnlInforUser.add(txtsdt);
		 
		 JButton btnGet = new JButton("Tìm kiếm");
		 btnGet.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_documents-07_1622836 (1).png"));
		 btnGet.setBounds(252, 233, 107, 31);
		 btnGet.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		JOptionPane.showMessageDialog(panel,
		 				 "Đang tìm kiếm...!", "Thông báo",
		 				 JOptionPane.INFORMATION_MESSAGE);
		 				 loadFindNV();
		 	}
		 });
		 btnGet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlInforUser.add(btnGet);
		 
		 txtFind = new JTextField();
		 txtFind.setBounds(135, 233, 107, 31);
		 pnlInforUser.add(txtFind);
		 txtFind.setColumns(10);
		 
		 cbbFind = new JComboBox();
		 cbbFind.setBounds(10, 233, 115, 26);
		 cbbFind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 cbbFind.setModel(new DefaultComboBoxModel(new String[] {"Tên", "Mã KH", "Họ"}));
		 pnlInforUser.add(cbbFind);
		 
		 JButton btnClear = new JButton("Clear");
		 btnClear.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_ilustracoes_04-09_1519785 (1).png"));
		 btnClear.setBounds(236, 134, 89, 23);
		 btnClear.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		clear();
		 		loadAllUsers();
		 	}
		 });
		 btnClear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 pnlInforUser.add(btnClear);
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setBounds(513, 11, 323, 263);
		 lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\ca.png"));
		 pnlInforUser.add(lblNewLabel);
		 
		 JLabel lblsdt_1 = new JLabel("Địa chỉ");
		 lblsdt_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblsdt_1.setBounds(178, 107, 48, 14);
		 pnlInforUser.add(lblsdt_1);
		 
		 txtdiachi = new JTextField();
		 txtdiachi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtdiachi.setColumns(10);
		 txtdiachi.setBounds(236, 104, 90, 20);
		 pnlInforUser.add(txtdiachi);
		 
		 JLabel lblsdt_1_1 = new JLabel("Tài khoản");
		 lblsdt_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblsdt_1_1.setBounds(343, 15, 57, 14);
		 pnlInforUser.add(lblsdt_1_1);
		 
		 JLabel lblsdt_1_2 = new JLabel("Mật khẩu");
		 lblsdt_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblsdt_1_2.setBounds(343, 46, 57, 14);
		 pnlInforUser.add(lblsdt_1_2);
		 
		 JLabel dada = new JLabel("Xác nhận");
		 dada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 dada.setBounds(343, 77, 57, 14);
		 pnlInforUser.add(dada);
		 
		 txttaikhoan = new JTextField();
		 txttaikhoan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txttaikhoan.setColumns(10);
		 txttaikhoan.setBounds(413, 11, 90, 20);
		 pnlInforUser.add(txttaikhoan);
		 
		 txtmk = new JTextField();
		 txtmk.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtmk.setColumns(10);
		 txtmk.setBounds(413, 42, 90, 20);
		 pnlInforUser.add(txtmk);
		 
		 txtmk2 = new JTextField();
		 txtmk2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtmk2.setColumns(10);
		 txtmk2.setBounds(413, 73, 90, 20);
		 pnlInforUser.add(txtmk2);
		 
		 JButton btnNewButton = new JButton("Create");
		 btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		 btnNewButton.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_tick_blue_619551 (1).png"));
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		addTK();
		 		
		 	}
		 });
		 btnNewButton.setBounds(413, 104, 90, 20);
		 pnlInforUser.add(btnNewButton);
		 
		 JButton btnex = new JButton("Export");
		 btnex.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		KhachHangBus khb= new KhachHangBus();
		 		exportKH();
		 		JOptionPane.showMessageDialog(panel,
						 "Loading...!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
		 	}
		 });
		 btnex.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\export (1).png"));
		 btnex.setBounds(413, 233, 100, 31);
		 pnlInforUser.add(btnex);
		 
		 JButton btnin = new JButton("Inport");
		 btnin.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		KhachHangBus khb= new KhachHangBus();
		 		try {
					importKH();
					JOptionPane.showMessageDialog(panel,
							 "Loading...!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 	}
		 });
		 btnin.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\import (1).png"));
		 btnin.setBounds(413, 191, 100, 31);
		 pnlInforUser.add(btnin);

		 JPanel pnlDataUser = new JPanel();
		 pnlDataUser.setBackground(Color.WHITE);
		 pnlDataUser.setBorder(new TitledBorder(UIManager
		 .getBorder("TitledBorder.border"),
		 "D\u1EEF li\u1EC7u khách hàng",
		 TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		 pnlDataUser.setBounds(10, 307, 846, 315);
		 panel.add(pnlDataUser);
		 pnlDataUser.setLayout(null);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 22, 826, 282);
		 pnlDataUser.add(scrollPane);
		 
		 	tblKH = new JTable();
		 	scrollPane.setViewportView(tblKH);
		 	tblKH.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		 	tblKH.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 	tblKH.addMouseListener(new MouseAdapter() {
		 		public void mouseClicked(MouseEvent arg0) {
			 		 int row = tblKH.getSelectedRow();
			 		 if (row != -1) {
			 			 txtmaKH.setText(tblKH.getValueAt(row, 0).toString());
			 			txtcmnd.setText(tblKH.getValueAt(row, 1).toString());
				 		 txtHo.setText(tblKH.getValueAt(row, 2).toString());
				 		 txtLot.setText(tblKH.getValueAt(row, 3).toString());
				 		 txtTen.setText(tblKH.getValueAt(row, 4).toString());
				 		 txtsdt.setText(tblKH.getValueAt(row, 5).toString());
				 		 txtNamSinh.setText(tblKH.getValueAt(row, 6).toString());
				 		 txtdiachi.setText(tblKH.getValueAt(row,7).toString());
			 		 }
		 		 }
		 	});
		 }

		 /**
		  * Get all user to display table.
		  */
		 public void loadAllUsers() {
			 String[] header = {"Mã Khách Hàng","CMND",  "Họ" ,"Lót", "Tên", " Số ĐT", "Năm sinh","Địa chỉ"};
			 DefaultTableModel dtm = new DefaultTableModel(header,0);
			 ArrayList<KhachHang> arr = new ArrayList<KhachHang>();
			 KhachHangBus khBUS = new KhachHangBus();
			 arr = khBUS.getAllKhachHang();
			 KhachHang khachhang = new KhachHang();
			 for (int i = 0; i < arr.size(); i++) {
				 khachhang = arr.get(i);
				if(khachhang.getTT()!=0) {
					String maKH =""+khachhang.getMaKH();
					 String cmnd = khachhang.getCmnd();
					 String ho = khachhang.getHoKH();
					 String lot = khachhang.getLotKH();
					 String ten = khachhang.getTenKH();
					 String sdt = khachhang.getSdt();
					 String namsinh = ""+khachhang.getNamSinh();
					 String diachi  = khachhang.getDiaChi();
					 Object[] row = {maKH, cmnd, ho, lot, ten, sdt,namsinh,diachi};
					 dtm.addRow(row);
				}
			 }
			 tblKH.setModel(dtm);
		 }
		 public void loadFindNV() {
			 String[] header = {"Mã Khách Hàng","CMND",  "Họ" ,"Lót", "Tên", " Số ĐT", "Năm sinh","Địa chỉ"};
			 DefaultTableModel dtm = new DefaultTableModel(header, 0);
			 ArrayList<KhachHang> arr = new ArrayList<KhachHang>();
			 KhachHangBus khBUS = new KhachHangBus();
			 KhachHang khachhang = new KhachHang();
			 String temp = cbbFind.getSelectedItem().toString();
			 if(temp == "Tên") {
				 arr = khBUS.getKhachHangbyTen(txtFind.getText());
			 }else {
				 if(temp == "Mã KH") {
					 String s =txtFind.getText();
					 if(s.matches("\\d+"))
						 khachhang.setMaKH(Integer.parseInt(txtFind.getText()));
					 arr= khBUS.getKhachHangbyMaKH(khachhang);
				 	}
					 
					 else {
						 arr =khBUS.getKhachHangbyHo(txtFind.getText());
					 }
						
			 }
				 
			 
			 for (int i = 0; i < arr.size(); i++) {
				 khachhang=arr.get(i);
				 if(khachhang.getTT()!=0) {
					 String maKH =""+khachhang.getMaKH();
					 String cmnd = khachhang.getCmnd();
					 String ho = khachhang.getHoKH();
					 String lot = khachhang.getLotKH();
					 String ten = khachhang.getTenKH();
					 String sdt = khachhang.getSdt();
					 String namsinh = ""+khachhang.getNamSinh();
					 String diachi  = khachhang.getDiaChi();
					 Object[] row = {maKH, cmnd, ho, lot, ten, sdt,namsinh,diachi};
						 dtm.addRow(row);
					}
			 }
			 tblKH.setModel(dtm);
		 }
		 public void clear() {
			 txtHo.setText("");
	 		 txtLot.setText("");
	 		 txtTen.setText("");
	 		 txtcmnd.setText("");
	 		 txtsdt.setText("");
	 		 txtNamSinh.setText("");
	 		 txtmaKH.setText("");
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
		public boolean checkMK() {

			if(!txtmk.getText().equals(txtmk2.getText())) {
				JOptionPane.showMessageDialog(panel,
						 "Mật khẩu sai!", "Thông báo",
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
		public void createTK() {
			TaiKhoanBUS tkB=new TaiKhoanBUS();
			if(!tkB.checkTK(txttaikhoan.getText())) {
				if(!checkMK()) {
					return;
				}
				TaiKhoan tk =new TaiKhoan();
				tk.setID("KH"+txtmaKH.getText());
				tk.setMa(Integer.parseInt(txtmaKH.getText()));
				tk.setTk(txttaikhoan.getText());
				tk.setMk(txtmk.getText());
				tk.setRole(1);
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
				tk.setID("KH"+txtmaKH.getText());
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
			if(!txtmaKH.getText().equals("")) {
				TaiKhoanBUS tkB=new TaiKhoanBUS();
				String id ="KH"+txtmaKH.getText();
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
						 "Chưa chọn khách hàng !!!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
			}
		}
		 public void addKH() {
			 try {
				 if(checkSo()&&checkTrong()) {
						KhachHang khachhang = new KhachHang();
						 khachhang.setCmnd(txtcmnd.getText());
						 khachhang.setHoKH(txtHo.getText());
						 khachhang.setLotKH(txtLot.getText());
						 khachhang.setTenKH(txtTen.getText());
						 khachhang.setSdt(txtsdt.getText());
						 khachhang.setDiaChi(txtdiachi.getText());
						 khachhang.setNamSinh(Integer.parseInt(txtNamSinh.getText()));
						 KhachHangBus khBUS = new KhachHangBus();
						 try {
							 int result = khBUS.insertKhachHang(khachhang);							 
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
				 }catch (Exception ex) {
					 ex.printStackTrace();
			 }
		 }
		 public void updateKH() {
			 if(checkSo()&&checkTrong()) {
				 KhachHang khachhang = new KhachHang();
				 khachhang.setMaKH(Integer.parseInt(txtmaKH.getText()));
				 khachhang.setCmnd(txtcmnd.getText());
				 khachhang.setHoKH(txtHo.getText());
				 khachhang.setLotKH(txtLot.getText());
				 khachhang.setTenKH(txtTen.getText());
				 khachhang.setSdt(txtsdt.getText());
				 khachhang.setDiaChi(txtdiachi.getText());
				 khachhang.setNamSinh(Integer.parseInt(txtNamSinh.getText()));
				 KhachHangBus khBUS = new KhachHangBus();
				 
				 int result = khBUS.updateKhachHang(khachhang);
				 if (result != 0 ) {
					 JOptionPane.showMessageDialog(panel,
						 "Cập nhật dữ liệu thành công!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
					 loadAllUsers();
				 }
			 }
			 else
				 JOptionPane.showMessageDialog(panel,
						 "Cập nhật dữ liệu thất bại!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
		 }
		 public void deleteKH() {
			 KhachHang khachhang = new KhachHang();
			 khachhang.setMaKH(Integer.parseInt(txtmaKH.getText()));
			 khachhang.setTT(0);
			 KhachHangBus khBUS = new KhachHangBus();
			 int choice = JOptionPane.showConfirmDialog(panel,
			 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
			 JOptionPane.YES_NO_OPTION);
			 if (choice == JOptionPane.YES_OPTION) {
				 try {
				 int result = khBUS.updateTT(khachhang);
				 if(result !=0){
					 TaiKhoanBUS tkB=new TaiKhoanBUS();
					 TaiKhoan tk =new TaiKhoan();
					 tk.setID("KH"+txtmaKH.getText());
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
		 public void exportKH() {
		        try {
		            XSSFWorkbook workbook = new XSSFWorkbook();
		            XSSFSheet spreadsheet = workbook.createSheet("KhachHang");

		            XSSFRow row = null;
		            Cell cell = null;

		            row = spreadsheet.createRow((short) 0);
		            row.setHeight((short) 500);
		            cell = row.createCell(0, CellType.STRING);
		            cell.setCellValue("DANH SASCH KHACH HANG");

		            row = spreadsheet.createRow((short) 3);
		            row.setHeight((short) 500);
		            cell = row.createCell(0, CellType.STRING);
		            cell.setCellValue("MA KH");
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

		            KhachHangBus kh = new KhachHangBus();

		            List<KhachHang> listItem = kh.getAllKhachHang();

		            for (int i = 0; i < listItem.size(); i++) {
		            	KhachHang khachhang = listItem.get(i);
		                row = spreadsheet.createRow((short) 4 + i);
		                row.setHeight((short) 400);
		                row.createCell(0).setCellValue(khachhang.getMaKH());
		                row.createCell(1).setCellValue(khachhang.getHoTen().trim());
		                row.createCell(2).setCellValue(khachhang.getNamSinh());
		                row.createCell(3).setCellValue(khachhang.getSdt().trim());
		                row.createCell(4).setCellValue(khachhang.getDiaChi().trim());
		                row.createCell(5).setCellValue(khachhang.getCmnd().trim());
		                
		            }

		            FileOutputStream out = new FileOutputStream(new File("./KhachHangOut.xlsx"));
		            workbook.write(out);
		            out.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		 }
		 public void importKH() throws IOException {
			 FileInputStream excelFile;
			try {
				excelFile = new FileInputStream(new File("./KhachHangIn.xlsx"));
				 XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
			      XSSFSheet sheet = workbook.getSheetAt(0);
			      int noofRow =sheet.getLastRowNum();
			      KhachHang kh=new KhachHang();
			      KhachHangBus khB = new KhachHangBus();
			      for(int i =0;i<=noofRow;i++) {
			    		 kh.setHoKH(sheet.getRow(i).getCell(0).toString());
			    		 kh.setLotKH(sheet.getRow(i).getCell(1).toString());
			    		 kh.setTenKH(sheet.getRow(i).getCell(2).toString());
			    		 String namsinh=sheet.getRow(i).getCell(3).toString();
			    		 int result= (int)Integer.parseInt(namsinh);
			    		 kh.setNamSinh(result);
			    		 kh.setSdt(sheet.getRow(i).getCell(4).toString());
			    		 kh.setDiaChi(sheet.getRow(i).getCell(5).toString());
			    		 kh.setCmnd(sheet.getRow(i).getCell(6).toString());
			    		 result= khB.insertKhachHang(kh);
			      }
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		 }

}
