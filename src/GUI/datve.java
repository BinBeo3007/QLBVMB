package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.swt.custom.CBanner;

import BUS.CTHDBUS;
import BUS.ChuyenBayBUS;
import BUS.DiaDiemBUS;
import BUS.DuongBayBUS;
import BUS.HoaDonBUS;
import BUS.KhachHangBus;
import BUS.SanBayBUS;
import BUS.VeBUS;
import DTO.CTHD;
import DTO.ChuyenBay;
import DTO.DiaDiem;
import DTO.DuongBay;
import DTO.HoaDon;
import DTO.KhachHang;
import DTO.SanBay;
import DTO.Ve;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class datve extends JPanel {
	private JTextField txtngaydi;
	private JTable tblCB;
	private JTextField txtCB;
	private JTextField txtGio;
	private JTextField txt1con;
	private JTextField txtgia1;
	private JTextField txt2con;
	private JTextField txtgia2;
	private JSpinner txtsl;
	private JTextField txtgia;
	private JTextField txtkh;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txttong;
	private JTextField txtdat;
	private JButton btndat;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JTextField txttien;
	private JLabel lblNewLabel_13;
	private JTextField txtngaydat;
	private JButton btnClear;
	private JComboBox cbkhoihanh;
	private JComboBox cbden;
	private JPanel panel;
	JRadioButton loai1,loai2;
	private JLabel lblNewLabel_14;
	/**
	 * Create the panel.
	 */
	public datve() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(Color.CYAN, 5));
		setLayout(null);
		
		init();
		loadAllUsers();
	}
	public void init() {
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 841, 580);
		add(panel);
		panel.setLayout(null);
		
		DiaDiemBUS ddBUS= new DiaDiemBUS();
		String[] s= ddBUS.getAllDiaDiem2();
		cbkhoihanh = new JComboBox(s);
		
		cbkhoihanh.setBounds(21, 37, 134, 30);
		panel.add(cbkhoihanh);
		
		cbden = new JComboBox(s);
		cbden.setBounds(182, 37, 134, 30);
		panel.add(cbden);
		
		JLabel lblNewLabel = new JLabel("N\u01A1i Kh\u1EDFi H\u00E0nh");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(21, 11, 99, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNin = new JLabel("N\u01A1i \u0110\u1EBFn");
		lblNin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNin.setBounds(182, 11, 99, 21);
		panel.add(lblNin);
		
		txtngaydi = new JTextField();
		txtngaydi.setBounds(340, 37, 134, 30);
		panel.add(txtngaydi);
		txtngaydi.setColumns(10);
		
		JLabel lblThiGian = new JLabel("Ng\u00E0y \u0110i");
		lblThiGian.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThiGian.setBounds(341, 11, 99, 21);
		panel.add(lblThiGian);
		
		JButton btnFind = new JButton("T\u00ECm");
		btnFind.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_documents-07_1622836 (1).png"));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findCB();
			}
		});
		btnFind.setBounds(516, 37, 89, 30);
		panel.add(btnFind);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 821, 138);
		panel.add(scrollPane);
		
		
		
		txtCB = new JTextField();
		txtCB.setEditable(false);
		txtCB.setColumns(10);
		txtCB.setBounds(21, 243, 99, 30);
		panel.add(txtCB);
		
		txtGio = new JTextField();
		txtGio.setEditable(false);
		txtGio.setColumns(10);
		txtGio.setBounds(144, 243, 99, 30);
		panel.add(txtGio);
		
		txt1con = new JTextField();
		txt1con.setEditable(false);
		txt1con.setColumns(10);
		txt1con.setBounds(264, 243, 99, 30);
		panel.add(txt1con);
		
		txtgia1 = new JTextField();
		txtgia1.setEditable(false);
		txtgia1.setColumns(10);
		txtgia1.setBounds(264, 314, 99, 30);
		panel.add(txtgia1);
		
		txt2con = new JTextField();
		txt2con.setEditable(false);
		txt2con.setColumns(10);
		txt2con.setBounds(386, 243, 99, 30);
		panel.add(txt2con);
		
		txtgia2 = new JTextField();
		txtgia2.setEditable(false);
		txtgia2.setColumns(10);
		txtgia2.setBounds(386, 314, 99, 30);
		panel.add(txtgia2);
		
		txtsl = new JSpinner();
		txtsl.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		txtsl.setBounds(130, 382, 99, 30);
		panel.add(txtsl);
		
		txtgia = new JTextField();
		txtgia.setEditable(false);
		txtgia.setColumns(10);
		txtgia.setBounds(264, 382, 99, 30);
		panel.add(txtgia);
		
		txtkh = new JTextField();
		txtkh.setColumns(10);
		txtkh.setBounds(506, 382, 99, 30);
		panel.add(txtkh);
		
		lblNewLabel_2 = new JLabel("Gi\u1EDD Kh\u1EDFi H\u00E0nh");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(144, 218, 99, 21);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("M\u00E3 Chuy\u1EBFn Bay");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(21, 218, 99, 21);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("S\u1ED1 v\u00E9 lo\u1EA1i 1 c\u00F2n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(264, 218, 99, 21);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Gi\u00E1");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(264, 282, 99, 21);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("S\u1ED1 v\u00E9 lo\u1EA1i 2 c\u00F2n");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(386, 218, 99, 21);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Gi\u00E1");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(386, 282, 99, 21);
		panel.add(lblNewLabel_6);
		
		ButtonGroup loaiVe = new ButtonGroup();
		
		loai1 = new JRadioButton("Lo\u1EA1i 1");
		loaiVe.add(loai1);
		loai1.setBackground(Color.WHITE);
		loai1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loai1.setBounds(15, 374, 109, 23);
		panel.add(loai1);
		
		loai2 = new JRadioButton("Lo\u1EA1i 2");
		loaiVe.add(loai2);
		loai2.setBackground(Color.WHITE);
		loai2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loai2.setBounds(15, 400, 109, 23);
		panel.add(loai2);
		
		lblNewLabel_7 = new JLabel("T\u1ED5ng v\u00E9");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(506, 218, 99, 21);
		panel.add(lblNewLabel_7);
		
		txttong = new JTextField();
		txttong.setEditable(false);
		txttong.setColumns(10);
		txttong.setBounds(506, 243, 99, 30);
		panel.add(txttong);
		
		txtdat = new JTextField();
		txtdat.setEditable(false);
		txtdat.setColumns(10);
		txtdat.setBounds(632, 243, 99, 30);
		panel.add(txtdat);
		
		btndat = new JButton("\u0110\u1EB7t V\u00E9");
		btndat.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_tick_blue_619551 (1).png"));
		btndat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datveMB();
			}
		});
		btndat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btndat.setBounds(518, 490, 123, 38);
		panel.add(btndat);
		
		lblNewLabel_8 = new JLabel("\u0110\u00E3 \u0111\u1EB7t v\u00E9");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(632, 218, 99, 21);
		panel.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(130, 350, 99, 21);
		panel.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("\u0110\u01A1n gi\u00E1");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_10.setBounds(264, 350, 99, 21);
		panel.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("M\u00E3 Kh\u00E1ch H\u00E0ng");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_11.setBounds(506, 350, 99, 21);
		panel.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Lo\u1EA1i v\u00E9");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_12.setBounds(21, 350, 99, 21);
		panel.add(lblNewLabel_12);
		
		txttien = new JTextField();
		txttien.setEditable(false);
		txttien.setColumns(10);
		txttien.setBounds(386, 382, 99, 30);
		panel.add(txttien);
		
		lblNewLabel_13 = new JLabel("Th\u00E0nh ti\u1EC1n");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_13.setBounds(386, 350, 99, 21);
		panel.add(lblNewLabel_13);
		
		tblCB = new JTable();
		scrollPane.setViewportView(tblCB);
		
		txtngaydat = new JTextField();
		txtngaydat.setColumns(10);
		txtngaydat.setBounds(632, 382, 99, 30);
		panel.add(txtngaydat);
		
		JLabel Ngay = new JLabel("Ngày Đặt");
		Ngay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Ngay.setBounds(632, 350, 99, 21);
		panel.add(Ngay);
		
		JButton btncheck = new JButton("Check");
		btncheck.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_check_3890933 (1) (1).png"));
		btncheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkTienVe();
				
			}
		});
		btncheck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btncheck.setBounds(264, 490, 123, 38);
		panel.add(btncheck);
		
		btnClear = new JButton("Clear");
		btnClear.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_ilustracoes_04-09_1519785 (1).png"));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setBounds(615, 37, 89, 30);
		panel.add(btnClear);
		
		lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\logomin.png"));
		lblNewLabel_14.setBounds(10, 430, 186, 139);
		panel.add(lblNewLabel_14);
		tblCB.addMouseListener(new MouseAdapter() {
	 		public void mouseClicked(MouseEvent arg0) {
		 		 int row = tblCB.getSelectedRow();
		 		 if (row != -1) {
		 			 txtCB.setText(tblCB.getValueAt(row, 0).toString());
		 			 txtGio.setText(tblCB.getValueAt(row, 3).toString());
		 			 int ghe1,ghe2;
		 			 ghe1=Integer.parseInt(tblCB.getValueAt(row, 6).toString());
		 			 ghe2=Integer.parseInt(tblCB.getValueAt(row, 7).toString());
			 		 txttong.setText(""+(ghe1+ghe2));
			 		 Ve ve =new Ve();
			 		int tongdat=0;
			 		 VeBUS vB=new VeBUS();
			 		 ve.setMaCB(tblCB.getValueAt(row, 0).toString());
			 		 ve.setLoaiGhe(1);
			 		 txtgia1.setText(""+vB.getGiabyLoai(ve));
			 		 txt1con.setText(""+(ghe1-vB.getsoghedadatByloaimaMB(ve)));
			 		 tongdat+=vB.getsoghedadatByloaimaMB(ve);
			 		ve.setLoaiGhe(2);
			 		txtgia2.setText(""+vB.getGiabyLoai(ve));
			 		txt2con.setText(""+(ghe2-vB.getsoghedadatByloaimaMB(ve)));
			 		 tongdat+=vB.getsoghedadatByloaimaMB(ve);
			 		 
			 		 txtdat.setText(""+tongdat);	
		 		 }
	 		 }
	 	});
	}
	public void loadAllUsers() {
		 String[] header = {"Mã Chuyễn Bay","Mã Máy Bay",  "Mã Đường Bay" ,"Giờ Bay","Ngày Đi","Ngày Đến ","Số ghế loại 1", "Số ghế loại 2"};
		 DefaultTableModel dtm = new DefaultTableModel(header,0);
		 ArrayList<ChuyenBay> arr = new ArrayList<ChuyenBay>();
		 ChuyenBayBUS cbBUS = new ChuyenBayBUS();
		 arr = cbBUS.getAllCB();
		 ChuyenBay chuyenbay = new ChuyenBay();
		 for (int i = 0; i < arr.size(); i++) {
			 chuyenbay = arr.get(i);
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
		 tblCB.setModel(dtm);
	 }
	public void clear() {
		txtngaydi.setText("");
		txtCB.setText("");
		txtGio.setText("");
		txt1con.setText("");
		txt2con.setText("");
		txttong.setText("");
		txtdat.setText("");
		txtgia1.setText("");
		txtgia2.setText("");
		txtgia.setText("");
		txttien.setText("");
		txtkh.setText("");
		txtngaydat.setText("");
		loadAllUsers();
	}
	public void findCB() {
		if(cbkhoihanh.getSelectedItem()!=cbden.getSelectedItem()) {
			ChuyenBay chuyenbay=new ChuyenBay();
			ChuyenBayBUS cbB= new ChuyenBayBUS();
			SanBayBUS sbB= new SanBayBUS();
		
			DiaDiemBUS ddB=new DiaDiemBUS();
			
			DuongBayBUS dbB =new DuongBayBUS();
			String di,den,sb1,sb2;
			DuongBay db=new DuongBay();
			di=ddB.getmaDD(cbkhoihanh.getSelectedItem().toString());
			den=ddB.getmaDD(cbden.getSelectedItem().toString());
			sb1=sbB.getSBByDD(di);
			sb2=sbB.getSBByDD(den);
			db=dbB.getDBbySB2(sb1, sb2);
			String[] header = {"Mã Chuyễn Bay","Mã Máy Bay",  "Mã Đường Bay" ,"Giờ Bay","Ngày Đi","Ngày Đến ","Số ghế loại 1", "Số ghế loại 2"};
			 DefaultTableModel dtm = new DefaultTableModel(header,0);
			 if(db!=null) {
				 	ArrayList<ChuyenBay> result=null;
				 	chuyenbay.setMaDB(db.getMaDB());
				 	String s=txtngaydi.getText();
				 	if(ChuyenBay.checkNgay(s, s)) {
				 		chuyenbay.setNgayDi(s);
				 		result = cbB.getAllCBbymaDBDi(chuyenbay);
				 	}
				 	else {
				 		if(s.equals(""))
				 			result = cbB.getAllCBbymaDB(chuyenbay);
				 		else
				 			result=null;
				 	}
				 		

				 	for(int i=0 ;i<result.size();i++) {
						chuyenbay=result.get(i);
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
				 	JOptionPane.showMessageDialog(panel,
							 "Đang Tìm Kiếm", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
			}
			 else
				JOptionPane.showMessageDialog(panel,
						 "Tìm Kiếm Thất Bại", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
			 
			 tblCB.setModel(dtm);
				
		}
		else
			JOptionPane.showMessageDialog(panel,
					 "Tìm Kiếm Thất Bại", "Thông báo",
					 JOptionPane.INFORMATION_MESSAGE);
		
	}
	public void datveMB() {
		if(txtCB.getText().equals("")) {
			JOptionPane.showMessageDialog(panel,
	 				 "Chưa chọn chuyến bay!", "Thông báo",
	 				 JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		ChuyenBayBUS cB =new ChuyenBayBUS();
		ChuyenBay cb= cB.getAllCBbymaCB(txtCB.getText());
		Ve ve =new Ve();
		VeBUS vB= new VeBUS();
		int sl=(int) txtsl.getValue();
		String dat=txtngaydat.getText();
		String maKH=txtkh.getText();
		int result=0,kq=0;
		if(ChuyenBay.checkNgay(dat, cb.getNgayDi())&&maKH.matches("\\d+")) {
			KhachHangBus khB=new KhachHangBus();
			KhachHang kh = new KhachHang();
			kh.setMaKH(Integer.parseInt(maKH));
			if(khB.checkTF(kh)==1) {
				int loai=0;
				int sldd=0;
				ve.setMaCB(cb.getMaCB());
				String s="";
				if(!loai1.isSelected()&&!loai2.isSelected()) {
					JOptionPane.showMessageDialog(panel,
			 				 "Chưa chọn loại vé!", "Thông báo",
			 				 JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if(loai1.isSelected()) {
					result=1;
					loai=1;
					ve.setLoaiGhe(loai);
					sldd=cb.getSogheloai1()-Integer.parseInt(txt1con.getText());
					HoaDonBUS hdB=new HoaDonBUS();
					HoaDon hd= new HoaDon();
					CTHDBUS cthdB =new CTHDBUS();
					CTHD cthd =new CTHD();
					
					String MaHD="HD"+hdB.getSLHD()+"_"+maKH+"_"+dat;
					hd.setMaHD(MaHD);
					hd.setMaKH(Integer.parseInt(maKH));
					hd.setTinhTrangn(1);
					kq = hdB.insertHD(hd);
					cthd.setMaHD(MaHD);
					cthd.setSl(1);
					cthd.setDonGia(vB.getGiabyLoai(ve));
					for (int i=1;i<=sl;i++) {
						if((sldd+i)<10) {
							s="0"+(sldd+i)+"_"+cb.getMaCB()+"_"+loai;
							ve.setMaVe(s);
							ve.setNgayDat(dat);
							ve.setTinhTrang(1);
						}
						else {
							s=""+(sldd+i)+"_"+cb.getMaCB()+"_"+loai;
							ve.setMaVe(s);
							ve.setNgayDat(dat);
							ve.setTinhTrang(1);
						}
						ve.setMaKH(Integer.parseInt(maKH));
						result= vB.updateVe(ve);
						cthd.setMave(s);	
						kq=cthdB.insertCTHD(cthd);
					}
				}
				if(loai2.isSelected()) {
					result=1;
					loai=2;
					ve.setLoaiGhe(loai);
					sldd=cb.getSogheloa2()-Integer.parseInt(txt2con.getText());
					HoaDonBUS hdB=new HoaDonBUS();
					HoaDon hd= new HoaDon();
					CTHDBUS cthdB =new CTHDBUS();
					CTHD cthd =new CTHD();
					
					String MaHD="HD"+hdB.getSLHD()+"_"+maKH+"_"+dat;
					hd.setMaHD(MaHD);
					hd.setMaKH(Integer.parseInt(maKH));
					hd.setTinhTrangn(1);
					kq = hdB.insertHD(hd);
					cthd.setMaHD(MaHD);
					cthd.setSl(1);
					cthd.setDonGia(vB.getGiabyLoai(ve));
					for (int i=1;i<=sl;i++) {
						if((sldd+i+cb.getSogheloa2())<10) {
							s="0"+(sldd+i+cb.getSogheloa2())+"_"+cb.getMaCB()+"_"+loai;
							ve.setMaVe(s);
							ve.setNgayDat(dat);
							ve.setTinhTrang(1);
						}
						else {
							s=""+(sldd+i+cb.getSogheloa2())+"_"+cb.getMaCB()+"_"+loai;
							ve.setMaVe(s);
							ve.setNgayDat(dat);
							ve.setTinhTrang(1);
						}
						ve.setMaKH(Integer.parseInt(maKH));
						result= vB.updateVe(ve);
						cthd.setMave(ve.getMaVe());	
						kq=cthdB.insertCTHD(cthd);
					}
					
				}
				
					
				if(result!=0) {
					JOptionPane.showMessageDialog(panel,
			 				 "Đặt vé Thành Công!", "Thông báo",
			 				 JOptionPane.INFORMATION_MESSAGE);
					clear();
				}
					
				else
					JOptionPane.showMessageDialog(panel,
			 				 "Đặt vé Thất Bại!", "Thông báo",
			 				 JOptionPane.INFORMATION_MESSAGE);
			 			
			}
			else {
				JOptionPane.showMessageDialog(panel,
		 				 "Mã khách hàng không hợp lệ!", "Thông báo",
		 				 JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(panel,
		 				 "Đặt vé Thất Bại!", "Thông báo",
		 				 JOptionPane.INFORMATION_MESSAGE);
			}
				
			
						
			
		}
		else
			JOptionPane.showMessageDialog(panel,
	 				 "Đặt vé Thất Bại!", "Thông báo",
	 				 JOptionPane.INFORMATION_MESSAGE);
		loadAllUsers();

	}
	public void checkTienVe() {
		if(!loai1.isSelected()&&!loai2.isSelected()) {
			JOptionPane.showMessageDialog(panel,
	 				 "Chưa chọn loại vé!", "Thông báo",
	 				 JOptionPane.INFORMATION_MESSAGE);
			return;

		}
		else {
			if(txtCB.getText().equals("")) {
				JOptionPane.showMessageDialog(panel,
		 				 "Chưa chọn chuyến bay!", "Thông báo",
		 				 JOptionPane.INFORMATION_MESSAGE);
				return;
			}else {
				if(loai1.isSelected()) {
					int gia= Integer.parseInt(txtgia1.getText());
					int sl= (int) txtsl.getValue();
					txtgia.setText(""+gia);
					txttien.setText(""+(sl*gia));
					JOptionPane.showMessageDialog(panel,
			 				 "Check", "Thông báo",
			 				 JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					int gia= Integer.parseInt(txtgia2.getText());
					int sl= (int) txtsl.getValue();
					txtgia.setText(""+gia);
					txttien.setText(""+(sl*gia));
					JOptionPane.showMessageDialog(panel,
			 				 "Check", "Thông báo",
			 				 JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		}
	}
}
