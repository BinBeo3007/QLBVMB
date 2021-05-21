package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
import BUS.HoaDonBUS;
import BUS.VeBUS;
import BUS.Thongke.TKDBBUS;
import BUS.Thongke.TKHBUS;
import BUS.Thongke.TKNVBUS;
import DTO.ChuyenBay;
import DTO.HoaDon;
import DTO.Ve;
import DTO.Thongke.TKDB;
import DTO.Thongke.TKKH;
import DTO.Thongke.TKNV;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class thongke extends JPanel {
	private JTextField txtDT;
	private JTextField txttongDT;
	private JTextField txtDB;
	private JTextField txttongDB;
	private JTextField txtNV;
	private JTextField txttongNV;
	private JTextField txtKH;
	private JTextField txttongKH;
	JPanel panel;
	private JTable tblDB;
	private JTable tblNV;
	private JTable tblKH;
	private JTable tbldoanhthu;
	/**
	 * Create the panel.
	 */
	public thongke() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 417, 293);
		add(panel);
		panel.setLayout(null);
		
		init();
		loadALLDT();
		loadALLNV();
		loadALKH();
		loadALDB();

	}
	public void init() {
		JLabel lblNewLabel = new JLabel("Th\u1ED1ng k\u00EA doanh thu");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(62, 11, 274, 37);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 397, 155);
		panel.add(scrollPane);
		
		tbldoanhthu = new JTable();
		scrollPane.setViewportView(tbldoanhthu);
		
		JComboBox cmbdoanhthu = new JComboBox();
		cmbdoanhthu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cmbdoanhthu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbdoanhthu.getSelectedIndex()<1) {
					txtDT.setEnabled(true);
				}
				else
					txtDT.setEnabled(false);
			}
		});
		cmbdoanhthu.setModel(new DefaultComboBoxModel(new String[] {"Mã HD", "Giảm Dần", "Tăng Dần"}));
		cmbdoanhthu.setBounds(10, 62, 71, 22);
		panel.add(cmbdoanhthu);
		
		JButton btnFindDT = new JButton("Tìm");
		btnFindDT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbdoanhthu.getSelectedIndex()==0&&!txtDT.getText().equals(""))
					loadFindDTbyMaHD();
				else{
					if(cmbdoanhthu.getSelectedIndex() ==1)
						loadFindDTGiam();
					else
						loadFindDTTang();
				}

					
			}
		});
		btnFindDT.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_documents-07_1622836 (1).png"));
		btnFindDT.setBounds(211, 59, 103, 25);
		panel.add(btnFindDT);
		
		JButton btnResetDT = new JButton("Show");
		btnResetDT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadALLDT();
			}
		});
		btnResetDT.setBounds(326, 59, 81, 23);
		panel.add(btnResetDT);
		
		txtDT = new JTextField();
		txtDT.setBounds(91, 62, 103, 22);
		panel.add(txtDT);
		txtDT.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("T\u1ED5ng doanh thu :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(181, 261, 114, 21);
		panel.add(lblNewLabel_1);
		
		txttongDT = new JTextField();
		txttongDT.setEditable(false);
		txttongDT.setBounds(304, 261, 103, 21);
		panel.add(txttongDT);
		txttongDT.setColumns(10);
		
		JButton btnDT = new JButton("Print");
		btnDT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printDT();
			}
		});
		btnDT.setBounds(326, 21, 81, 23);
		panel.add(btnDT);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		panel_2.setBounds(437, 11, 417, 293);
		add(panel_2);
		
		JLabel lblThngKTuyn = new JLabel("Thống kê Đường Bay");
		lblThngKTuyn.setForeground(Color.BLUE);
		lblThngKTuyn.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKTuyn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThngKTuyn.setBounds(62, 11, 274, 37);
		panel_2.add(lblThngKTuyn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 95, 397, 155);
		panel_2.add(scrollPane_1);
		
		tblDB = new JTable();
		scrollPane_1.setViewportView(tblDB);
		
		JComboBox cmbDB = new JComboBox();
		cmbDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbDB.getSelectedIndex()==0) {
					txtDB.setEnabled(true);
				}
				else
					txtDB.setEnabled(false);
			}
		});
		cmbDB.setModel(new DefaultComboBoxModel(new String[] {"Mã DB", "Giảm Dần", "Tăng Dần"}));
		
		cmbDB.setBounds(10, 62, 76, 22);
		panel_2.add(cmbDB);
		
		JButton btnFindDB = new JButton("Tìm");
		btnFindDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbDB.getSelectedIndex()==0&&!txtDB.getText().equals(""))
					loadFindDBbyMaDB();
				else{
					if(cmbDB.getSelectedIndex() ==1)
						loadFindDBGiam();
					else
						loadFindDBTang();
				}
			}
		});
		btnFindDB.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_documents-07_1622836 (1).png"));
		btnFindDB.setBounds(211, 59, 97, 25);
		panel_2.add(btnFindDB);
		
		JButton btnResetDB = new JButton("Show");
		btnResetDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadALDB();
			}
		});
		btnResetDB.setBounds(318, 59, 89, 23);
		panel_2.add(btnResetDB);
		
		txtDB = new JTextField();
		txtDB.setColumns(10);
		txtDB.setBounds(96, 62, 97, 22);
		panel_2.add(txtDB);
		
		JLabel lblNewLabel_1_1 = new JLabel("T\u1ED5ng v\u00E9 :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(234, 259, 60, 21);
		panel_2.add(lblNewLabel_1_1);
		
		txttongDB = new JTextField();
		txttongDB.setEditable(false);
		txttongDB.setColumns(10);
		txttongDB.setBounds(304, 261, 103, 21);
		panel_2.add(txttongDB);
		
		JButton btnDT_1 = new JButton("Print");
		btnDT_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printDB();
			}
		});
		btnDT_1.setBounds(318, 21, 89, 23);
		panel_2.add(btnDT_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 315, 417, 293);
		add(panel_1);
		
		JLabel lblThngKNhn = new JLabel("Th\u1ED1ng k\u00EA Nh\u00E2n Vi\u00EAn");
		lblThngKNhn.setForeground(Color.BLUE);
		lblThngKNhn.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKNhn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThngKNhn.setBounds(62, 11, 274, 37);
		panel_1.add(lblThngKNhn);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 95, 397, 155);
		panel_1.add(scrollPane_2);
		
		tblNV = new JTable();
		scrollPane_2.setViewportView(tblNV);
		
		JComboBox cmbNV = new JComboBox();
		cmbNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbNV.getSelectedIndex()==0) {
					txtNV.setEnabled(true);
				}
				else
					txtNV.setEnabled(false);
				
			}
		});
		cmbNV.setModel(new DefaultComboBoxModel(new String[] {"Mã NV", "Giảm Dần", "Tăng Dần"}));
		cmbNV.setBounds(10, 62, 76, 22);
		panel_1.add(cmbNV);
		
		JButton btnFindNV = new JButton("Tìm");
		btnFindNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbNV.getSelectedIndex()==0&&!txtNV.getText().equals(""))
					loadFindNVbyMaNV();
				else{
					if(cmbNV.getSelectedIndex() ==1)
						loadFindNVGiam();
					else
						loadFindNVTang();
				}
			}
		});
		btnFindNV.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_documents-07_1622836 (1).png"));
		btnFindNV.setBounds(211, 59, 97, 25);
		panel_1.add(btnFindNV);
		
		JButton btnResetNV = new JButton("Show");
		btnResetNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadALLNV();
			}
		});
		btnResetNV.setBounds(318, 59, 89, 23);
		panel_1.add(btnResetNV);
		
		txtNV = new JTextField();
		txtNV.setColumns(10);
		txtNV.setBounds(96, 62, 97, 22);
		panel_1.add(txtNV);
		
		txttongNV = new JTextField();
		txttongNV.setEditable(false);
		txttongNV.setColumns(10);
		txttongNV.setBounds(304, 261, 103, 21);
		panel_1.add(txttongNV);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tổng HD :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(226, 259, 68, 21);
		panel_1.add(lblNewLabel_1_1_1);
		
		JButton btnDT_2 = new JButton("Print");
		btnDT_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printNV();
			}
		});
		btnDT_2.setBounds(318, 21, 89, 23);
		panel_1.add(btnDT_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		panel_3.setBounds(437, 315, 417, 293);
		add(panel_3);
		
		JLabel lblThngKKhch = new JLabel("Th\u1ED1ng k\u00EA Kh\u00E1ch H\u00E0ng");
		lblThngKKhch.setForeground(Color.BLUE);
		lblThngKKhch.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKKhch.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThngKKhch.setBounds(62, 11, 274, 37);
		panel_3.add(lblThngKKhch);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 95, 397, 155);
		panel_3.add(scrollPane_3);
		
		tblKH = new JTable();
		scrollPane_3.setViewportView(tblKH);
		
		JComboBox cmbKH = new JComboBox();
		cmbKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbKH.getSelectedIndex()==0) {
					txtKH.setEnabled(true);
				}
				else
					txtKH.setEnabled(false);
			}
		});
		cmbKH.setModel(new DefaultComboBoxModel(new String[] {"Mã KH", "Giảm Dần", "Tăng Dần"}));
		cmbKH.setBounds(10, 62, 76, 22);
		panel_3.add(cmbKH);
		
		JButton btnFindKH = new JButton("Tìm");
		btnFindKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbKH.getSelectedIndex()==0&&!txtKH.getText().equals(""))
					loadFindNVbyMaKH();
				else{
					if(cmbKH.getSelectedIndex() ==1)
						loadFindKHGiam();
					else
						loadFindKHTang();
				}
			}
		});
		btnFindKH.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_documents-07_1622836 (1).png"));
		btnFindKH.setBounds(211, 59, 97, 25);
		panel_3.add(btnFindKH);
		
		JButton btnResetKH = new JButton("Show");
		btnResetKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadALKH();
			}
		});
		btnResetKH.setBounds(318, 59, 89, 23);
		panel_3.add(btnResetKH);
		
		txtKH = new JTextField();
		txtKH.setColumns(10);
		txtKH.setBounds(96, 62, 97, 22);
		panel_3.add(txtKH);
		
		txttongKH = new JTextField();
		txttongKH.setEditable(false);
		txttongKH.setColumns(10);
		txttongKH.setBounds(304, 261, 103, 21);
		panel_3.add(txttongKH);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("T\u1ED5ng v\u00E9 :");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(235, 261, 60, 21);
		panel_3.add(lblNewLabel_1_1_2);
		
		JButton btnDT_3 = new JButton("Print");
		btnDT_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printKH();
			}
		});
		btnDT_3.setBounds(318, 21, 89, 23);
		panel_3.add(btnDT_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Bin\\Downloads\\plane-art-blue-sky-clouds-besthqwallpapers.com-1920x1080 (2).jpg"));
		lblNewLabel_2.setBounds(0, -13, 866, 665);
		add(lblNewLabel_2);
	}
	public void loadALLDT() {
		String[] header = {"Mã Hóa Đơn","Ngày Thanh Toán",  "Giá"};
		 DefaultTableModel dtm = new DefaultTableModel(header,0);
		 ArrayList<HoaDon> arr = new ArrayList<HoaDon>();
		 HoaDonBUS hdB = new HoaDonBUS();
		 arr = hdB.getAllDoanhThu();
		 HoaDon hd = new HoaDon();
		 int tong=0;
		 for (int i = 0; i < arr.size(); i++) {
			
			 hd = arr.get(i);
			 if(hd.getTinhTrang()!=0) {
				 String mahd =hd.getMaHD().trim();
				 String ngaydat =""+ hd.getNgayMua();
				 String tongtien =""+hd.getTongTien();
				 Object[] row = {mahd,ngaydat,tongtien};
				 dtm.addRow(row);
				 tong+=hd.getTongTien();
			 }
		 }
		 tbldoanhthu.setModel(dtm);
		txttongDT.setText(""+tong);
	}
	public void loadFindDTbyMaHD() {
		if(!txtDT.getText().equals("")){
			String[] header = {"Mã Hóa Đơn","Ngày Thanh Toán",  "Giá"};
			 DefaultTableModel dtm = new DefaultTableModel(header,0);
			 ArrayList<HoaDon> arr = new ArrayList<HoaDon>();
			 HoaDonBUS hdB = new HoaDonBUS();
			 HoaDon hd = new HoaDon();
			 hd.setMaHD(txtDT.getText());
			 arr = hdB.getHDbyMaHD(hd);
			 int tong=0;
			 for (int i = 0; i < arr.size(); i++) {
				 hd = arr.get(i);
				 
				 if(hd.getTinhTrang()!=0) {
					 String mahd =hd.getMaHD().trim();
					 String ngaydat =""+ hd.getNgayMua();
					 String tongtien =""+hd.getTongTien();
					 Object[] row = {mahd,ngaydat,tongtien};
					 dtm.addRow(row);
					 tong+=hd.getTongTien();
				 }
			 }
			 tbldoanhthu.setModel(dtm);
			 txttongDT.setText(""+tong);
		}
	}
	public void loadFindDTGiam() {
		String[] header = {"Mã Hóa Đơn","Ngày Thanh Toán",  "Giá"};
		 DefaultTableModel dtm = new DefaultTableModel(header,0);
		 ArrayList<HoaDon> arr = new ArrayList<HoaDon>();
		 HoaDonBUS hdB = new HoaDonBUS();
		 HoaDon hd = new HoaDon();
		 arr = hdB.getDoanhThuGiam();
		 int tong=0;
		 for (int i = 0; i < arr.size(); i++) {
			 hd = arr.get(i);
			 if(hd.getTinhTrang()!=0) {
				 String mahd =hd.getMaHD().trim();
				 String ngaydat =""+ hd.getNgayMua();
				 String tongtien =""+hd.getTongTien();
				 Object[] row = {mahd,ngaydat,tongtien};
				 dtm.addRow(row);
				 tong+=hd.getTongTien();
			 }
		 }
		 tbldoanhthu.setModel(dtm);
		 txttongDT.setText(""+tong);
	}
	public void loadFindDTTang() {
		String[] header = {"Mã Hóa Đơn","Ngày Thanh Toán",  "Giá"};
		 DefaultTableModel dtm = new DefaultTableModel(header,0);
		 ArrayList<HoaDon> arr = new ArrayList<HoaDon>();
		 HoaDonBUS hdB = new HoaDonBUS();
		 HoaDon hd = new HoaDon();
		 arr = hdB.getDoanhThuTang();

		 for (int i = 0; i < arr.size(); i++) {
			 hd = arr.get(i);
			 if(hd.getTinhTrang()!=0) {
				 String mahd =hd.getMaHD().trim();
				 String ngaydat =""+ hd.getNgayMua();
				 String tongtien =""+hd.getTongTien();
				 Object[] row = {mahd,ngaydat,tongtien};
				 dtm.addRow(row);
			 }
		 }
		 tbldoanhthu.setModel(dtm);
	}
	public void loadALLNV() {
		String[] header = {"Mã Nhân Viên","Họ Tên",  "Số Hóa Đơn"};
		 DefaultTableModel dtm = new DefaultTableModel(header,0);
		 ArrayList<TKNV> arr = new ArrayList<TKNV>();
		 TKNVBUS nvB = new TKNVBUS();
		 TKNV nv = new TKNV();
		 arr = nvB.getAll();
		 int tong=0;
		 for (int i = 0; i < arr.size(); i++) {
			 	nv = arr.get(i);
				 String manv =""+ nv.getManv();
				 String hoten =""+ nv.getHoten().replaceAll("\\s\\s+", " ").trim();
				 String sl =""+nv.getSlve();
				 Object[] row = {manv,hoten,sl};
				 dtm.addRow(row);
				 tong+=nv.getSlve();
		 }
		 tblNV.setModel(dtm);
		txttongNV.setText(""+tong);
	}
	public void loadFindNVbyMaNV() {
		if(!txtNV.getText().equals("")){
			if(!txtNV.getText().matches("\\d+"))
				return;
			String[] header = {"Mã Nhân Viên","Họ Tên",  "Số Hóa Đơn"};
			 DefaultTableModel dtm = new DefaultTableModel(header,0);
			 ArrayList<TKNV> arr = new ArrayList<TKNV>();
			 TKNVBUS nvB = new TKNVBUS();
			 TKNV nv = new TKNV();
			 arr=nvB.getAllbyma(Integer.parseInt(txtNV.getText()));
			 int tong=0;
			 for (int i = 0; i < arr.size(); i++) {
				 nv = arr.get(i);
				 String manv =""+ nv.getManv();
				 String hoten =""+ nv.getHoten().replaceAll("\\s\\s+", " ").trim();
				 String sl =""+nv.getSlve();
				 Object[] row = {manv,hoten,sl};
				 dtm.addRow(row);
				 tong+=nv.getSlve();
			 }
			 tblNV.setModel(dtm);
			 txttongNV.setText(""+tong);
		}
	}
	public void loadFindNVGiam() {
		String[] header = {"Mã Nhân Viên","Họ Tên",  "Số Hóa Đơn"};
		 DefaultTableModel dtm = new DefaultTableModel(header,0);
		 ArrayList<TKNV> arr = new ArrayList<TKNV>();
		 TKNVBUS nvB = new TKNVBUS();
		 TKNV nv = new TKNV();
		 arr = nvB.getAllGiam();
		 int tong=0;
		 for (int i = 0; i < arr.size(); i++) {
			 	nv = arr.get(i);
				 String manv =""+ nv.getManv();
				 String hoten =""+ nv.getHoten().replaceAll("\\s\\s+", " ").trim();
				 String sl =""+nv.getSlve();
				 Object[] row = {manv,hoten,sl};
				 dtm.addRow(row);
				 tong+=nv.getSlve();
		 }
		 tblNV.setModel(dtm);
		txttongNV.setText(""+tong);
	}
	public void loadFindNVTang() {
		String[] header = {"Mã Nhân Viên","Họ Tên",  "Số Hóa Đơn"};
		 DefaultTableModel dtm = new DefaultTableModel(header,0);
		 ArrayList<TKNV> arr = new ArrayList<TKNV>();
		 TKNVBUS nvB = new TKNVBUS();
		 TKNV nv = new TKNV();
		 arr = nvB.getAllTang();
		 int tong=0;
		 for (int i = 0; i < arr.size(); i++) {
			 	nv = arr.get(i);
				 String manv =""+ nv.getManv();
				 String hoten =""+ nv.getHoten().replaceAll("\\s\\s+", " ").trim();
				 String sl =""+nv.getSlve();
				 Object[] row = {manv,hoten,sl};
				 dtm.addRow(row);
				 tong+=nv.getSlve();
		 }
		 tblNV.setModel(dtm);
		txttongNV.setText(""+tong);
	}
	public void loadALKH() {
		String[] header = {"Mã Khách Hàng","Họ Tên",  "Số Vé"};
		 DefaultTableModel dtm = new DefaultTableModel(header,0);
		 ArrayList<TKKH> arr = new ArrayList<TKKH>();
		 TKHBUS khB = new TKHBUS();
		 TKKH kh = new TKKH();
		 arr = khB.getAll();
		 int tong=0;
		 for (int i = 0; i < arr.size(); i++) {
			 kh = arr.get(i);
				 String makh =""+ kh.getMakh();
				 String hoten =""+ kh.getHoten().replaceAll("\\s\\s+", " ").trim();
				 String sl =""+kh.getSlve();
				 Object[] row = {makh,hoten,sl};
				 dtm.addRow(row);
				 tong+=kh.getSlve();
		 }
		 tblKH.setModel(dtm);
		txttongKH.setText(""+tong);
	}
	public void loadFindNVbyMaKH() {
		if(!txtKH.getText().equals("")){
			if(!txtKH.getText().matches("\\d+"))
				return;
			String[] header = {"Mã Khách Hàng","Họ Tên",  "Số Vé"};
			 DefaultTableModel dtm = new DefaultTableModel(header,0);
			 ArrayList<TKKH> arr = new ArrayList<TKKH>();
			 TKHBUS khB = new TKHBUS();
			 TKKH kh = new TKKH();
			 arr=khB.getAllbyma(Integer.parseInt(txtKH.getText()));
			 int tong=0;
			 for (int i = 0; i < arr.size(); i++) {
				 kh = arr.get(i);
				 String makh =""+ kh.getMakh();
				 String hoten =""+ kh.getHoten().replaceAll("\\s\\s+", " ").trim();
				 String sl =""+kh.getSlve();
				 Object[] row = {makh,hoten,sl};
				 dtm.addRow(row);
				 tong+=kh.getSlve();
			 }
			 tblKH.setModel(dtm);
			txttongKH.setText(""+tong);
		}
	}
	public void loadFindKHGiam() {
		String[] header = {"Mã Khách Hàng","Họ Tên",  "Số Vé"};
		 DefaultTableModel dtm = new DefaultTableModel(header,0);
		 ArrayList<TKKH> arr = new ArrayList<TKKH>();
		 TKHBUS khB = new TKHBUS();
		 TKKH kh = new TKKH();
		 arr = khB.getAllGiam();
		 int tong=0;
		 for (int i = 0; i < arr.size(); i++) {
			 	kh = arr.get(i);
				 String makh =""+ kh.getMakh();
				 String hoten =""+ kh.getHoten().replaceAll("\\s\\s+", " ").trim();
				 String sl =""+kh.getSlve();
				 Object[] row = {makh,hoten,sl};
				 dtm.addRow(row);
				 tong+=kh.getSlve();
		 }
		 tblKH.setModel(dtm);
		txttongKH.setText(""+tong);
	}
	public void loadFindKHTang() {
		String[] header = {"Mã Khách Hàng","Họ Tên",  "Số Vé"};
		 DefaultTableModel dtm = new DefaultTableModel(header,0);
		 ArrayList<TKKH> arr = new ArrayList<TKKH>();
		 TKHBUS khB = new TKHBUS();
		 TKKH kh = new TKKH();
		 arr = khB.getAllTang();
		 int tong=0;
		 for (int i = 0; i < arr.size(); i++) {
			 kh = arr.get(i);
				 String makh =""+ kh.getMakh();
				 String hoten =""+ kh.getHoten().replaceAll("\\s\\s+", " ").trim();
				 String sl =""+kh.getSlve();
				 Object[] row = {makh,hoten,sl};
				 dtm.addRow(row);
				 tong+=kh.getSlve();
		 }
		 tblKH.setModel(dtm);
		txttongKH.setText(""+tong);
	}
	public void loadALDB() {
		String[] header = {"Mã Đường Bay",  "Số Vé"};
		 DefaultTableModel dtm = new DefaultTableModel(header,0);
		 ArrayList<TKDB> arr = new ArrayList<TKDB>();
		 TKDBBUS dbB = new TKDBBUS();
		 TKDB db = new TKDB();
		 arr = dbB.getAll();
		 int tong=0;
		 for (int i = 0; i < arr.size(); i++) {
			 db = arr.get(i);
				 String madb =""+ db.getMaDB();
				 String sl =""+db.getSlve();
				 Object[] row = {madb,sl};
				 dtm.addRow(row);
				 tong+=db.getSlve();
		 }
		 tblDB.setModel(dtm);
		txttongDB.setText(""+tong);
	}
	public void loadFindDBbyMaDB() {
		if(!txtDB.getText().equals("")){
			String[] header = {"Mã Đường Bay",  "Số Vé"};
			 DefaultTableModel dtm = new DefaultTableModel(header,0);
			 ArrayList<TKDB> arr = new ArrayList<TKDB>();
			 TKDBBUS dbB = new TKDBBUS();
			 TKDB db = new TKDB();
			 arr=dbB.getAllbyma(txtDB.getText());
			 int tong=0;
			 for (int i = 0; i < arr.size(); i++) {
				 db = arr.get(i);
				 String madb =""+ db.getMaDB();
				 String sl =""+db.getSlve();
				 Object[] row = {madb,sl};
				 dtm.addRow(row);
				 tong+=db.getSlve();
			 }
			 tblDB.setModel(dtm);
				txttongDB.setText(""+tong);
		}
	}
	public void loadFindDBGiam() {
		String[] header = {"Mã Đường Bay",  "Số Vé"};
		 DefaultTableModel dtm = new DefaultTableModel(header,0);
		 ArrayList<TKDB> arr = new ArrayList<TKDB>();
		 TKDBBUS dbB = new TKDBBUS();
		 TKDB db = new TKDB();
		 arr = dbB.getAllGiam();
		 int tong=0;
		 for (int i = 0; i < arr.size(); i++) {
			 db = arr.get(i);
				 String madb =""+ db.getMaDB();
				 String sl =""+db.getSlve();
				 Object[] row = {madb,sl};
				 dtm.addRow(row);
				 tong+=db.getSlve();
		 }
		 tblDB.setModel(dtm);
		txttongDB.setText(""+tong);
	}
	public void loadFindDBTang() {
		String[] header = {"Mã Đường Bay",  "Số Vé"};
		 DefaultTableModel dtm = new DefaultTableModel(header,0);
		 ArrayList<TKDB> arr = new ArrayList<TKDB>();
		 TKDBBUS dbB = new TKDBBUS();
		 TKDB db = new TKDB();
		 arr = dbB.getAllTang();
		 int tong=0;
		 for (int i = 0; i < arr.size(); i++) {
			 db = arr.get(i);
				 String madb =""+ db.getMaDB();
				 String sl =""+db.getSlve();
				 Object[] row = {madb,sl};
				 dtm.addRow(row);
				 tong+=db.getSlve();
		 }
		 tblDB.setModel(dtm);
		txttongDB.setText(""+tong);
	}
	public void printDT() {
		try {
			String filename="C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\DoanhThu.pdf";
			Document document =new Document();
			PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.open();
			Paragraph para =new Paragraph("Doanh Thu");
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			PdfPTable t = new PdfPTable(3);
			t.setSpacingBefore(25);
			t.setSpacingAfter(25);

			PdfPCell c1 = new PdfPCell(new Phrase("Ma HD"));
			t.addCell(c1);
			PdfPCell c2 = new PdfPCell(new Phrase("Ngay thanh toan"));
			t.addCell(c2);
			PdfPCell c3 = new PdfPCell(new Phrase("Gia"));
			t.addCell(c3);
			int tong=0;
			ArrayList<HoaDon> arr = new ArrayList<HoaDon>();
			 HoaDonBUS hdB = new HoaDonBUS();
			 arr = hdB.getAllDoanhThu();
			 HoaDon hd = new HoaDon();
			 for (int i = 0; i < arr.size(); i++) {
				 hd = arr.get(i);
				 
					 t.addCell(""+hd.getMaHD());
						t.addCell(""+hd.getNgayMua());
						t.addCell(""+hd.getTongTien());
						tong+=hd.getTongTien();
			 }
			 Chunk chunk =new Chunk("\nTong tien : "+tong);
			 document.add(chunk);
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
	public void printDB() {
		try {
			String filename="C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\ThongKeDuongBay.pdf";
			Document document =new Document();
			PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.open();
			Paragraph para =new Paragraph("Thong Ke Duong Bay");
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			PdfPTable t = new PdfPTable(2);
			t.setSpacingBefore(25);
			t.setSpacingAfter(25);

			PdfPCell c1 = new PdfPCell(new Phrase("Ma DB"));
			t.addCell(c1);
			PdfPCell c2 = new PdfPCell(new Phrase("So ve"));
			t.addCell(c2);
			ArrayList<TKDB> arr = new ArrayList<TKDB>();
			 TKDBBUS dbB = new TKDBBUS();
			 TKDB db = new TKDB();
			 arr = dbB.getAll();
			 int tong=0;
			 for (int i = 0; i < arr.size(); i++) {
				 		db = arr.get(i);
						t.addCell(""+db.getMaDB());
						t.addCell(""+db.getSlve());
						tong+=db.getSlve();
			 }
			 Chunk chunk =new Chunk("\nTong ve : "+tong);
			 document.add(chunk);
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
	
	public void printNV() {
		try {
			
			String filename="C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\ThongKeNhanVien.pdf";
			Document document =new Document();
			PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.open();
			Paragraph para =new Paragraph("Nhan Vien");
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			PdfPTable t = new PdfPTable(3);
			t.setSpacingBefore(25);
			t.setSpacingAfter(25);

			PdfPCell c1 = new PdfPCell(new Phrase("Ma NV"));
			t.addCell(c1);
			PdfPCell c2 = new PdfPCell(new Phrase("Ho va Ten"));
			t.addCell(c2);
			PdfPCell c3 = new PdfPCell(new Phrase("So ve"));
			t.addCell(c3);
			ArrayList<TKNV> arr = new ArrayList<TKNV>();
			 TKNVBUS nvB = new TKNVBUS();
			 TKNV nv = new TKNV();
			 arr = nvB.getAll();
			 int tong=0;			 
			 for (int i = 0; i < arr.size(); i++) {
				 nv = arr.get(i);
				 
					 t.addCell(""+nv.getManv());
						t.addCell(""+nv.getHoten());
						t.addCell(""+nv.getSlve());
						tong+=nv.getSlve();
			 }
			 Chunk chunk =new Chunk("\nTong HD : "+tong);
			 document.add(chunk);
			document.add(t);
			
			
			document.close();
			 JOptionPane.showMessageDialog(panel,
					 "OK!", "Thông báo",
					 JOptionPane.INFORMATION_MESSAGE);
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printKH() {
try {
			
			String filename="C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\ThongKeKhachHang.pdf";
			Document document =new Document();
			PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.open();
			Paragraph para =new Paragraph("Khach Hang");
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			PdfPTable t = new PdfPTable(3);
			t.setSpacingBefore(25);
			t.setSpacingAfter(25);

			PdfPCell c1 = new PdfPCell(new Phrase("Ma KH"));
			t.addCell(c1);
			PdfPCell c2 = new PdfPCell(new Phrase("Ho va ten"));
			t.addCell(c2);
			PdfPCell c3 = new PdfPCell(new Phrase("So ve"));
			t.addCell(c3);
			ArrayList<TKKH> arr = new ArrayList<TKKH>();
			 TKHBUS khB = new TKHBUS();
			 TKKH kh = new TKKH();
			 arr = khB.getAll();
			 int tong=0;			 
			 for (int i = 0; i < arr.size(); i++) {
				 kh = arr.get(i);
				 
					 t.addCell(""+kh.getMakh());
						t.addCell(""+kh.getHoten());
						t.addCell(""+kh.getSlve());
						tong+=kh.getSlve();
			 }
			 Chunk chunk =new Chunk("\nTong HD : "+tong);
			 document.add(chunk);
			document.add(t);
			
			
			document.close();
			 JOptionPane.showMessageDialog(panel,
					 "OK!", "Thông báo",
					 JOptionPane.INFORMATION_MESSAGE);
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}


	
}
