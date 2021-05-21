package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import BUS.CTHDBUS;
import BUS.ChucVuBUS;
import BUS.HoaDonBUS;
import BUS.KMBUS;
import BUS.KhachHangBus;
import BUS.NhanVienBUS;
import BUS.VeBUS;
import DTO.CTHD;
import DTO.ChuyenBay;
import DTO.HoaDon;
import DTO.KM;
import DTO.KhachHang;
import DTO.NhanVien;
import DTO.Ve;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class HoaDonGUI extends JPanel {
	JPanel panel;
	private JTextField txtmahd;
	private JTextField txttra;
	private JComboBox txtmanv;
	private JTable tblNV;
	private JTextField txttennv;
	private JTextField txtmakh;
	private JTextField txttenkh;
	private JTextField txtsdt;
	JComboBox cbbFind;
	/**
	 * Create the panel.
	 */
	private JTextField txtFind;
	private JTextField txtmacb;
	private JTextField txtsl;
	private JTextField txtloai;
	private JTextField txtgia;
	private JTextField txttien;
	private JTable tblve;
	private JTextField txttt;
	private JTextField txttongtien;
	
	public HoaDonGUI() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 866, 627);
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
		 "HoaDon", TitledBorder.LEADING,
		 TitledBorder.TOP, null, Color.BLUE));
		 pnlInforUser.setBounds(10, 11, 846, 156);
		 
		 panel.add(pnlInforUser);
		 pnlInforUser.setLayout(null);

		 JLabel lblMa = new JLabel("Mã Hóa Đơn");
		 lblMa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblMa.setBounds(10, 33, 71, 14);
		 pnlInforUser.add(lblMa);

		 txtmahd = new JTextField();
		 txtmahd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtmahd.setBounds(91, 30, 90, 20);
		 pnlInforUser.add(txtmahd);
		 txtmahd.setColumns(10);
		 txtmahd.setEditable(false);

		 JLabel lblHo = new JLabel("Ngày trả");
		 lblHo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblHo.setBounds(10, 61, 71, 14);
		 pnlInforUser.add(lblHo);

		 txttra = new JTextField();
		 txttra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txttra.setColumns(10);
		 txttra.setBounds(91, 58, 90, 20);
		 pnlInforUser.add(txttra);

		 JLabel lblLot = new JLabel("Mã NV");
		 lblLot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblLot.setBounds(10, 89, 52, 14);
		 pnlInforUser.add(lblLot);
		 
		 NhanVienBUS nvBUS = new NhanVienBUS();
		 String[] cbnv= nvBUS.getMaNV();
		 txtmanv = new JComboBox(cbnv);
		 txtmanv.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		NhanVienBUS nvBus= new NhanVienBUS();
		 		txttennv.setText(""+nvBus.getTenbyMaNV(Integer.parseInt(txtmanv.getSelectedItem().toString())));
		 	}
		 });
		 txtmanv.setEditable(false);
		 txtmanv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtmanv.setBounds(91, 86, 90, 20);
		 pnlInforUser.add(txtmanv);

		 JButton btnAdd = new JButton("Check");
		 btnAdd.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_check_3890933 (1) (1).png"));
		 btnAdd.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 checkHD();
			 }
		 });
		 btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnAdd.setBounds(402, 112, 115, 31);
		 pnlInforUser.add(btnAdd);

		 JButton btnUpdate = new JButton("Cập nhật");
		 btnUpdate.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
			 updateHD();
			}
		 });
		 btnUpdate
		 .setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Add-Male-User-icon.png"));
		 btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnUpdate.setBounds(547, 112, 115, 31);
		 pnlInforUser.add(btnUpdate);

		 JButton btnDelete = new JButton("Xóa");
		 btnDelete.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 
				deleteHD();
			 }
		 });
		 btnDelete
		 .setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Remove-Male-User-icon.png"));
		 btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnDelete.setBounds(689, 112, 107, 31);
		 pnlInforUser.add(btnDelete);
		 
		 JLabel lblTen = new JLabel("Tên NV");
		 lblTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblTen.setBounds(10, 120, 52, 14);
		 pnlInforUser.add(lblTen);
		 
		 txttennv = new JTextField();
		 txttennv.setEditable(false);
		 txttennv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txttennv.setColumns(10);
		 txttennv.setBounds(91, 117, 90, 20);
		 pnlInforUser.add(txttennv);
		 
		 JLabel lblnamsinh = new JLabel("Mã KH");
		 lblnamsinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblnamsinh.setBounds(207, 33, 71, 14);
		 pnlInforUser.add(lblnamsinh);
		 
		 JLabel lblcmnd = new JLabel("Tên KH");
		 lblcmnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblcmnd.setBounds(207, 61, 52, 14);
		 pnlInforUser.add(lblcmnd);
		 
		 JLabel lblsdt = new JLabel("Số ĐT");
		 lblsdt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblsdt.setBounds(207, 89, 71, 14);
		 pnlInforUser.add(lblsdt);
		 
		 txtmakh = new JTextField();
		 txtmakh.setEditable(false);
		 txtmakh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtmakh.setColumns(10);
		 txtmakh.setBounds(278, 30, 90, 20);
		 pnlInforUser.add(txtmakh);
		 
		 txttenkh = new JTextField();
		 txttenkh.setEditable(false);
		 txttenkh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txttenkh.setColumns(10);
		 txttenkh.setBounds(278, 58, 90, 20);
		 pnlInforUser.add(txttenkh);
		 
		 txtsdt = new JTextField();
		 txtsdt.setEditable(false);
		 txtsdt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtsdt.setColumns(10);
		 txtsdt.setBounds(278, 86, 90, 20);
		 pnlInforUser.add(txtsdt);
		 
		 JButton btnGet = new JButton("Tìm kiếm");
		 btnGet.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_documents-07_1622836 (1).png"));
		 btnGet.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		JOptionPane.showMessageDialog(panel,
						 "Đang Tìm Kiếm", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
		 		loadFindNV();
		 	}
		 });
		 btnGet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnGet.setBounds(689, 25, 107, 31);
		 pnlInforUser.add(btnGet);
		 
		 txtFind = new JTextField();
		 txtFind.setBounds(547, 28, 115, 26);
		 pnlInforUser.add(txtFind);
		 txtFind.setColumns(9);
		 
		 cbbFind = new JComboBox();
		 cbbFind.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(cbbFind.getSelectedIndex()>1) {
		 			txtFind.setEnabled(false);
		 		}
		 		else
		 			txtFind.setEnabled(true);
		 	}
		 });
		 cbbFind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 cbbFind.setModel(new DefaultComboBoxModel(new String[] {"Mã HD", "Mã KH", "Check","unCheck"}));
		 cbbFind.setBounds(402, 27, 115, 26);
		 pnlInforUser.add(cbbFind);
		 
		 JButton btnclear = new JButton("Clear");
		 btnclear.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_ilustracoes_04-09_1519785 (1).png"));
		 btnclear.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		txtmahd.setText("");
		 		 txtmakh.setText("");
		 		 txttra.setText("");
		 		txttennv.setText("");
		 		 txttenkh.setText("");
		 		 txtsdt.setText("");
		 		txtmacb.setText("");
				 txtloai.setText("");
				 txtsl.setText("");
				 txtgia.setText("");
				 txttien.setText("");
				 txttongtien.setText("");
				 loadAllUsers();
		 	}
		 });
		 btnclear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 btnclear.setBounds(404, 80, 113, 23);
		 pnlInforUser.add(btnclear);
		 
		 txttt = new JTextField();
		 txttt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txttt.setEditable(false);
		 txttt.setColumns(10);
		 txttt.setBounds(278, 120, 90, 20);
		 pnlInforUser.add(txttt);
		 
		 JLabel lblTnhTrng = new JLabel("Tình trạng");
		 lblTnhTrng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblTnhTrng.setBounds(207, 120, 71, 14);
		 pnlInforUser.add(lblTnhTrng);

		 JPanel pnlDataUser = new JPanel();
		 pnlDataUser.setBackground(Color.WHITE);
		 pnlDataUser.setBorder(new TitledBorder(UIManager
		 .getBorder("TitledBorder.border"),
		 "",
		 TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		 pnlDataUser.setBounds(10, 178, 846, 145);
		 panel.add(pnlDataUser);
		 pnlDataUser.setLayout(null);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 11, 826, 123);
		 pnlDataUser.add(scrollPane);
		 
		 	tblNV = new JTable();
		 	scrollPane.setViewportView(tblNV);
		 	tblNV.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		 	tblNV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 	
		 	JPanel pnlDataUser_1 = new JPanel();
		 	pnlDataUser_1.setLayout(null);
		 	pnlDataUser_1.setBorder(new TitledBorder(UIManager
		 			 .getBorder("TitledBorder.border"),
		 			 "",
		 			 TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		 	pnlDataUser_1.setBackground(Color.WHITE);
		 	pnlDataUser_1.setBounds(10, 482, 846, 134);
		 	panel.add(pnlDataUser_1);
		 	
		 	JScrollPane scrollPane_1 = new JScrollPane();
		 	scrollPane_1.addMouseListener(new MouseAdapter() {
		 		@Override
		 		public void mouseClicked(MouseEvent e) {
		 		}
		 	});
		 	scrollPane_1.setBounds(10, 11, 826, 112);
		 	pnlDataUser_1.add(scrollPane_1);
		 	
		 	tblve = new JTable();
		 	scrollPane_1.setViewportView(tblve);
		 	
		 	JPanel pnlInforUser_1 = new JPanel();
		 	pnlInforUser_1.setLayout(null);
		 	pnlInforUser_1.setBorder(new TitledBorder(UIManager
		 			 .getBorder("TitledBorder.border"),
		 			 "Chi Tiet Hoa Don", TitledBorder.LEADING,
		 			 TitledBorder.TOP, null, Color.BLUE));
		 	pnlInforUser_1.setBackground(Color.WHITE);
		 	pnlInforUser_1.setBounds(10, 334, 846, 134);
		 	panel.add(pnlInforUser_1);
		 	
		 	JLabel lblMa_1 = new JLabel("Mã CB");
		 	lblMa_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 	lblMa_1.setBounds(10, 33, 71, 14);
		 	pnlInforUser_1.add(lblMa_1);
		 	
		 	txtmacb = new JTextField();
		 	txtmacb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 	txtmacb.setEditable(false);
		 	txtmacb.setColumns(10);
		 	txtmacb.setBounds(91, 30, 90, 20);
		 	pnlInforUser_1.add(txtmacb);
		 	
		 	JLabel lblHo_1 = new JLabel("Số lượng");
		 	lblHo_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 	lblHo_1.setBounds(10, 61, 71, 14);
		 	pnlInforUser_1.add(lblHo_1);
		 	
		 	txtsl = new JTextField();
		 	txtsl.setEditable(false);
		 	txtsl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 	txtsl.setColumns(10);
		 	txtsl.setBounds(91, 58, 90, 20);
		 	pnlInforUser_1.add(txtsl);
		 	
		 	JLabel lblnamsinh_1 = new JLabel("Loại vé");
		 	lblnamsinh_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 	lblnamsinh_1.setBounds(201, 33, 52, 14);
		 	pnlInforUser_1.add(lblnamsinh_1);
		 	
		 	JLabel lblcmnd_1 = new JLabel("Đơn giá");
		 	lblcmnd_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 	lblcmnd_1.setBounds(201, 61, 71, 14);
		 	pnlInforUser_1.add(lblcmnd_1);
		 	
		 	JLabel lblsdt_1 = new JLabel("Thành tiền");
		 	lblsdt_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 	lblsdt_1.setBounds(201, 92, 71, 14);
		 	pnlInforUser_1.add(lblsdt_1);
		 	
		 	txtloai = new JTextField();
		 	txtloai.setEditable(false);
		 	txtloai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 	txtloai.setColumns(10);
		 	txtloai.setBounds(278, 30, 90, 20);
		 	pnlInforUser_1.add(txtloai);
		 	
		 	txtgia = new JTextField();
		 	txtgia.setEditable(false);
		 	txtgia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 	txtgia.setColumns(10);
		 	txtgia.setBounds(278, 58, 90, 20);
		 	pnlInforUser_1.add(txtgia);
		 	
		 	txttien = new JTextField();
		 	txttien.setEditable(false);
		 	txttien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 	txttien.setColumns(10);
		 	txttien.setBounds(278, 89, 90, 20);
		 	pnlInforUser_1.add(txttien);
		 	
		 	txttongtien = new JTextField();
		 	txttongtien.setEditable(false);
		 	txttongtien.setBounds(735, 98, 101, 20);
		 	pnlInforUser_1.add(txttongtien);
		 	txttongtien.setColumns(10);
		 	
		 	JLabel lblNewLabel = new JLabel("Tổng Tiền :");
		 	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 	lblNewLabel.setBounds(654, 97, 71, 20);
		 	pnlInforUser_1.add(lblNewLabel);
		 	
		 	JTextField txtkm = new JTextField();
		 	txtkm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 	txtkm.setBounds(735, 45, 101, 24);
		 	pnlInforUser_1.add(txtkm);
		 	
		 	JLabel lblKhuynMi = new JLabel("Khuyến Mãi:");
		 	lblKhuynMi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 	lblKhuynMi.setBounds(654, 45, 71, 20);
		 	pnlInforUser_1.add(lblKhuynMi);
		 	
		 	JButton btnTT = new JButton("Tính Tiền");
		 	btnTT.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_67_5027861 (1).png"));
		 	btnTT.addActionListener(new ActionListener() {
		 		public void actionPerformed(ActionEvent e) {
		 			int tien=Integer.parseInt(txttien.getText());
		 			KMBUS kmB=new KMBUS();
		 			int km = kmB.getPhanTram(txtkm.getText());
		 			if(km>0) {
		 				KM khuyenmai = kmB.getKMbyMaKM(txtkm.getText());
			 			if(txttra.getText().equals(""))
			 				km=0;
			 			else {
			 				if(!ChuyenBay.checkNgay(khuyenmai.getBatdau(), txttra.getText())||!ChuyenBay.checkNgay(txttra.getText(), khuyenmai.getKetthuc()))
			 					km=0;
			 			}
		 			}
		 			int tong =tien -(tien*km)/100;
		 			HoaDon hd =new HoaDon();
		 			hd.setMaHD(txtmahd.getText());
		 			hd.setKM(km);
		 			hd.setTongTien(tong);
		 			HoaDonBUS hdB=new HoaDonBUS();
		 			tien=hdB.updateKM(hd);
		 			txttongtien.setText(""+tong);
		 			loadAllUsers();
		 		}
		 	});
		 	btnTT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 	btnTT.setBounds(497, 89, 126, 36);
		 	pnlInforUser_1.add(btnTT);
		 	tblNV.addMouseListener(new MouseAdapter() {
		 		public void mouseClicked(MouseEvent arg0) {
			 		 int row = tblNV.getSelectedRow();
			 		 if (row != -1) {
				 		 txtmahd.setText(tblNV.getValueAt(row, 0).toString().trim());
				 		 txtmakh.setText(tblNV.getValueAt(row, 1).toString());
				 		String temp =tblNV.getValueAt(row, 2).toString().trim();
				 		txtmanv.setSelectedItem(temp);
				 		 if(tblNV.getValueAt(row, 3)!=null)
				 			txttra.setText(tblNV.getValueAt(row, 3).toString());
				 		 KhachHang kh =new KhachHang();
				 		 KhachHangBus khB= new KhachHangBus();
				 		 kh= khB.getKhachHangbyMaKH(Integer.parseInt(txtmakh.getText()));
				 		 NhanVienBUS nvBus= new NhanVienBUS();
				 		txttennv.setText(""+nvBus.getTenbyMaNV(Integer.parseInt(tblNV.getValueAt(row, 2).toString())));
				 		 txttt.setText(tblNV.getValueAt(row,6).toString());
				 		 txttenkh.setText(kh.getHoTen());
				 		 txtsdt.setText(kh.getSdt());
				 		 
				 		loadAllCTHD(txtmahd.getText().toString());
	
			 		 }
		 		 }
		 	});
		 }

		 /**
		  * Get all user to display table.
		  */
		 public void loadAllUsers() {
			
			 String[] header = { "Mã HD", "Mã KH" ,"Mã NV", "Ngày Trả","Khuyến Mãi", "Tổng tiền","Tình Trạng"};
			 DefaultTableModel dtm = new DefaultTableModel(header, 0);
			 ArrayList<HoaDon> arr = new ArrayList<HoaDon>();
			 HoaDonBUS hdBUS = new HoaDonBUS();
			 HoaDon hd = new HoaDon();
			 arr = hdBUS.getAllHD();
			 
			 for (int i = 0; i < arr.size(); i++) {
				 hd = arr.get(i);
				if(hd.getTinhTrang()!=0) {
					String mahd=hd.getMaHD();
					 int mankh = hd.getMaKH();
					 int manv = hd.getMaNV();
					 String ngaytra = hd.getNgayMua();
					 String tong =""+ hd.getTongTien();
					 String tinhtrang;
					 String khuyenmai=""+hd.getKM();
					 if(hd.getTinhTrang()==2)
						 tinhtrang ="Check";
					 else 
						 tinhtrang ="Chưa trả";
					 Object[] row = { mahd, mankh, manv, ngaytra,khuyenmai, tong,tinhtrang };
					 dtm.addRow(row);
				}
			 }
			 tblNV.setModel(dtm);
		 }
		 public void loadFindNV() {
			 String[] header = { "Mã HD", "Mã KH" ,"Mã NV", "Ngày Trả","Khuyến Mãi", "Tổng tiền","Tình Trạng"};
			 DefaultTableModel dtm = new DefaultTableModel(header, 0);
			 ArrayList<HoaDon> arr = new ArrayList<HoaDon>();
			 HoaDonBUS hdBUS = new HoaDonBUS();
			 HoaDon hd = new HoaDon();
			 String temp = cbbFind.getSelectedItem().toString();
			 if(temp == "Mã HD") {
				 hd.setMaHD(txtFind.getText());
				 arr = hdBUS.getHDbyMaHD(hd);
			 }else {
				 if(temp == "Mã KH") {
					 String s=txtFind.getText();
					 
					 if (s.matches("\\d+"))
						 hd.setMaKH(Integer.parseInt(s));
					 else
						 hd.setMaKH(0);
					 arr= hdBUS.getHDbyMaKH(hd);
				 }
				 else {
						 if(temp =="Check")
							arr=hdBUS.getHDbyTT(2);
						 else
							 arr=hdBUS.getHDbyTT(1);
				 }
			 }		 
			 for (int i = 0; i < arr.size(); i++) {
				 hd = arr.get(i);
				 if(hd.getTinhTrang()!=0) {
						String mahd=hd.getMaHD();
						 int mankh = hd.getMaKH();
						 int manv = hd.getMaNV();
						 String ngaytra = hd.getNgayMua();
						 String tong =""+ hd.getTongTien();
						 String tinhtrang;
						 String khuyenmai=""+hd.getKM();
						 if(hd.getTinhTrang()==2)
							 tinhtrang ="Check";
						 else 
							 tinhtrang ="Chưa trả";
						 Object[] row = { mahd, mankh, manv, ngaytra,khuyenmai, tong,tinhtrang };
						 dtm.addRow(row);
					}
			 }
			 tblNV.setModel(dtm);
		 }
		 public void loadAllCTHD(String s) {
			 String[] header = { "Mã Vé", "Mã CB" ,"Mã KH", "Ngày Đặt", "Loại Vé","Giá Tiền"};
			 DefaultTableModel dtm = new DefaultTableModel(header, 0);
			
			 ArrayList<CTHD> arr = new ArrayList<CTHD>();
			 CTHDBUS hdBUS = new CTHDBUS();
			 CTHD hd = new CTHD();
			 VeBUS vB =new VeBUS();
			 Ve ve=new Ve();
			 hd.setMaHD(s);
			 int sl=0;
			 arr = hdBUS.getAllCTHDbyMaHD(hd);
			 for (int i = 0; i < arr.size(); i++) {
				 hd = arr.get(i);
				 
				 ve.setMaVe(hd.getMave().trim());
				
				 ArrayList<Ve> listVe =vB.getVebymaVe(ve);
				 
				 for(int j=0;j<listVe.size();j++) {
					 sl++;
					 ve=listVe.get(j);
					 txtmacb.setText(ve.getMaCB().trim());
					
					 txtloai.setText(""+ve.getLoaiGhe());
				 }
				 String mave, macb, makh, ngaydat, loaive,gia;
				 mave=ve.getMaVe();
				 macb=ve.getMaCB();
				 makh=""+ve.getMaKH();
				 ngaydat =ve.getNgayDat();
				 loaive =""+ve.getLoaiGhe();
				 gia=""+ve.getGiaTien();
				 Object[] row = { mave, macb, makh, ngaydat, loaive,gia };
				 dtm.addRow(row);
				 txtgia.setText(""+hd.getDonGia());
				
			 }
			 txtsl.setText(""+sl);
			 txttien.setText(""+(sl* hd.getDonGia()));
			 tblve.setModel(dtm);
		 }
		 public int getTT(String tt) {
			 if(tt.trim() =="check")
				 return 2;
			 return 1;
		 }
		 public void checkHD() {
			 HoaDonBUS hdB = new HoaDonBUS();
			 HoaDon hd = new HoaDon();
			 hd.setMaHD(txtmahd.getText().toString());
			 if(txtmanv.getSelectedItem()==null) {
				 JOptionPane.showMessageDialog(panel,
						 "Chưa chọn nhân viên !!!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
				 
				 JOptionPane.showMessageDialog(panel,
						 "Check HD thất bại!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
				 return;
			 }
			 hd.setMaNV(Integer.parseInt(txtmanv.getSelectedItem().toString()));
			 hd.setTinhTrangn(2);
			 if (ChuyenBay.checkNgay(txttra.getText().toString(), txttra.getText().toString())) {
				 hd.setNgayMua(txttra.getText().toString());
				 int result = hdB.updateHD(hd);
				 if(result != 0)
					 JOptionPane.showMessageDialog(panel,
							 "Check HD thành công!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
				 else
					 JOptionPane.showMessageDialog(panel,
							 "Check HD thất bại!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
							 
			 }
			 else
				 JOptionPane.showMessageDialog(panel,
						 "Check HD thất bại!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
			 loadAllUsers();
			
		 }
		 public void updateHD() {

			 HoaDonBUS hdB = new HoaDonBUS();
			 HoaDon hd = new HoaDon();
			 hd.setMaHD(txtmahd.getText().toString());
			 if(txtmanv.getSelectedItem()==null) {
				 JOptionPane.showMessageDialog(panel,
						 "Chưa chọn nhân viên !!!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
				 
				 JOptionPane.showMessageDialog(panel,
						 "Check HD thất bại!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
				 return;
			 }
			 hd.setMaNV(Integer.parseInt(txtmanv.getSelectedItem().toString()));
			 hd.setTinhTrangn(getTT(txttt.getText().toString()));
			 if (ChuyenBay.checkNgay(txttra.getText().toString(), txttra.getText().toString())) {
				 hd.setNgayMua(txttra.getText().toString());
				 int result = hdB.updateHD(hd);
				 if(result != 0)
					 JOptionPane.showMessageDialog(panel,
							 "Cập nhật dữ liệu thành công!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
				 else
					 JOptionPane.showMessageDialog(panel,
							 "Cập nhật dữ liệu thất bại!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
							 
			 }
			 else
				 JOptionPane.showMessageDialog(panel,
						 "Cập nhật dữ liệu thất bại!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
			 loadAllUsers();
		 }
		 public void deleteHD() {
			 HoaDonBUS hdB = new HoaDonBUS();
			 HoaDon hd = new HoaDon();
			 hd.setMaHD(txtmahd.getText().toString());
			 hd.setTinhTrangn(0);
				 int result = hdB.updateTT(hd);
				 if(result != 0)
					 JOptionPane.showMessageDialog(panel,
							 "Xóa dữ liệu thành công!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
				 else
					 JOptionPane.showMessageDialog(panel,
							 "Xóa dữ liệu thất bại!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);

			 loadAllUsers();
		 }
}
