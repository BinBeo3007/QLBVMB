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

import BUS.KhachHangBus;
import BUS.VeBUS;
import DTO.ChuyenBay;
import DTO.KhachHang;
import DTO.Ve;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;


public class VeGUI extends JPanel {
	JPanel panel;
	private JTextField txtmacb;
	private JTable tblKH;
	private JTextField txtmaghe;
	private JTextField txtdat;
	private JTextField txtmave;
	JComboBox cbbFind;
	private JTextField txtFind;
	private JTextField txtmakh;
	private JTextField txtgia;

	public VeGUI() {
		setLayout(null);
		panel= new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 866, 633);
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
		 "Thông tin vé", TitledBorder.LEADING,
		 TitledBorder.TOP, null, Color.BLUE));
		 pnlInforUser.setBounds(10, 11, 846, 285);
		 
		 panel.add(pnlInforUser);
		 pnlInforUser.setLayout(null);

		 JLabel lblMa = new JLabel("Mã Chuyến Bay");
		 lblMa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblMa.setBounds(35, 60, 96, 14);
		 pnlInforUser.add(lblMa);

		 JLabel lblLot = new JLabel("M\u00E3 V\u00E9");
		 lblLot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblLot.setBounds(35, 35, 71, 14);
		 pnlInforUser.add(lblLot);

		 txtmacb = new JTextField();
		 txtmacb.setEditable(false);
		 txtmacb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtmacb.setColumns(10);
		 txtmacb.setBounds(153, 57, 90, 20);
		 pnlInforUser.add(txtmacb);
		 
		 JLabel lblTen = new JLabel("Loại Ghế");
		 lblTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblTen.setBounds(35, 91, 89, 14);
		 pnlInforUser.add(lblTen);
		 
		 txtmaghe = new JTextField();
		 txtmaghe.setEditable(false);
		 txtmaghe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtmaghe.setColumns(10);
		 txtmaghe.setBounds(153, 88, 90, 20);
		 pnlInforUser.add(txtmaghe);
		 
		 JLabel lblcmnd = new JLabel("Mã Khách Hàng");
		 lblcmnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblcmnd.setBounds(335, 60, 92, 14);
		 pnlInforUser.add(lblcmnd);
		 
		 JLabel lblsdt = new JLabel("Giá Tiền");
		 lblsdt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblsdt.setBounds(35, 120, 71, 14);
		 pnlInforUser.add(lblsdt);
		 
		 txtdat = new JTextField();
		 txtdat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtdat.setColumns(10);
		 txtdat.setBounds(454, 88, 90, 20);
		 pnlInforUser.add(txtdat);
		 
		 txtmave = new JTextField();
		 txtmave.setEditable(false);
		 txtmave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtmave.setColumns(10);
		 txtmave.setBounds(153, 32, 90, 20);
		 pnlInforUser.add(txtmave);
		 
		 JButton btnGet = new JButton("Tìm kiếm");
		 btnGet.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_documents-07_1622836 (1).png"));
		 btnGet.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		JOptionPane.showMessageDialog(panel,
		 				 "Đang tìm kiếm!", "Thông báo",
		 				 JOptionPane.INFORMATION_MESSAGE);
		 				 loadFindNV();
		 	}
		 });
		 btnGet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnGet.setBounds(116, 195, 107, 31);
		 pnlInforUser.add(btnGet);
		 
		 txtFind = new JTextField();
		 txtFind.setBounds(262, 238, 115, 31);
		 pnlInforUser.add(txtFind);
		 txtFind.setColumns(10);
		 
		 cbbFind = new JComboBox();
	
		 cbbFind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 cbbFind.setModel(new DefaultComboBoxModel(new String[] {"Mã Vé", "Mã CB", "Mã KH"}));
		 cbbFind.setBounds(262, 197, 115, 26);
		 pnlInforUser.add(cbbFind);
		 
		 JButton btnClear = new JButton("Clear");
		 btnClear.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_ilustracoes_04-09_1519785 (1).png"));
		 btnClear.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		 txtmacb.setText("");
		 		 txtmaghe.setText("");
		 		txtgia.setText("");
		 		 txtFind.setText("");
		 		 txtmave.setText("");
		 		 txtdat.setText("");
		 		 txtmakh.setText("");
		 		loadAllUsers();
		 	}
		 });
		 btnClear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnClear.setBounds(454, 116, 90, 23);
		 pnlInforUser.add(btnClear);
		 
		 txtmakh = new JTextField();
		 txtmakh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtmakh.setColumns(10);
		 txtmakh.setBounds(454, 57, 90, 20);
		 pnlInforUser.add(txtmakh);
		 
		 txtgia = new JTextField();
		 txtgia.setEditable(false);
		 txtgia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtgia.setColumns(10);
		 txtgia.setBounds(153, 117, 90, 20);
		 pnlInforUser.add(txtgia);
		 
		 JLabel lblNgyn = new JLabel("Ngày Đặt");
		 lblNgyn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblNgyn.setBounds(335, 91, 71, 14);
		 pnlInforUser.add(lblNgyn);
		 
		 JButton btnupdate = new JButton("Cập nhật");
		 btnupdate.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Add-Male-User-icon.png"));
		 btnupdate.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		updateVe();
		 		loadAllUsers();
		 	}
		 });
		 btnupdate.setBounds(405, 196, 107, 31);
		 pnlInforUser.add(btnupdate);
		 
		 JButton btnNewButton = new JButton("Xóa");
		 btnNewButton.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Remove-Male-User-icon.png"));
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Ve ve =new Ve();
		 		VeBUS vBUS =new VeBUS();
		 		ve.setMaVe(txtmave.getText());
		 		ve.setTinhTrang(0);
		 		int result = vBUS.deleteVebymave(ve);
		 		JOptionPane.showMessageDialog(panel,
						 "Xóa dữ liệu thành công!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
		 		loadAllUsers();
		 	}
		 });
		 btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 btnNewButton.setBounds(405, 237, 107, 31);
		 pnlInforUser.add(btnNewButton);
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\images.jpg"));
		 lblNewLabel.setBounds(609, 35, 227, 213);
		 pnlInforUser.add(lblNewLabel);

		 JPanel pnlDataUser = new JPanel();
		 pnlDataUser.setBackground(Color.WHITE);
		 pnlDataUser.setBorder(new TitledBorder(UIManager
		 .getBorder("TitledBorder.border"),
		 "D\u1EEF li\u1EC7u vé",
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
			 			 txtmave.setText(tblKH.getValueAt(row, 0).toString());
			 			 txtmacb.setText(tblKH.getValueAt(row, 1).toString());
				 		 txtmaghe.setText(tblKH.getValueAt(row, 2).toString());
				 		 txtgia.setText(tblKH.getValueAt(row, 3).toString());
			 			txtmakh.setText(tblKH.getValueAt(row, 4).toString());
				 		 txtdat.setText(tblKH.getValueAt(row, 5).toString());

			 		 }
		 		 }
		 	});
		 }

		 /**
		  * Get all user to display table.
		  */
		 public void loadAllUsers() {
			 String[] header = {"Mã Vé","Mã Chuyến Bay",  "Loại Vé" ,"Đơn Giá","Mã Khách Hàng","Ngày Đặt"};
			 DefaultTableModel dtm = new DefaultTableModel(header,0);
			 ArrayList<Ve> arr = new ArrayList<Ve>();
			 VeBUS veBUS = new VeBUS();
			 arr = veBUS.getAllVe();
			 Ve ve = new Ve();
			 for (int i = 0; i < arr.size(); i++) {
				 ve = arr.get(i);
				 if(ve.getTinhTrang()==1) {
					 String mave =ve.getMaVe();
					 String maCB =ve.getMaCB().trim();
					 String loaighe =""+ve.getLoaiGhe();
					 String gia =""+ ve.getGiaTien();
					 String makh =""+ ve.getMaKH();
					 String ngaydat =""+ve.getNgayDat();
					 Object[] row = {mave,maCB,loaighe, gia, makh,ngaydat};
					 dtm.addRow(row);
				 }
			 }
			 tblKH.setModel(dtm);
		 }
		 public void loadFindNV() {
			 String[] header = {"Mã Vé","Mã Chuyến Bay",  "Loại Vé" ,"Đơn Giá","Mã Khách Hàng","Ngày Đặt"};
			 DefaultTableModel dtm = new DefaultTableModel(header,0);
			 ArrayList<Ve> arr = new ArrayList<Ve>();
			 VeBUS veBUS = new VeBUS();
			 arr = veBUS.getAllVe();
			 Ve ve = new Ve();
			 String temp = cbbFind.getSelectedItem().toString();
			 if(temp == "Mã Vé") {
				 ve.setMaVe(txtFind.getText());
				 arr = veBUS.getVebymaVe(ve);
			 }
			 else{
				 if(temp == "Mã CB") {
				 ve.setMaCB(txtFind.getText());
				 arr = veBUS.getVebymaCB(ve);
			 	}
				 
				else 
					 if(temp=="Mã KH") {
						 ve.setMaKH(Integer.parseInt(txtFind.getText()));
						 arr = veBUS.getVebymaKH(ve);
				}
					 
			}
					 
			 for (int i = 0; i < arr.size(); i++) {
				 ve = arr.get(i);
				 if(ve.getTinhTrang()==1) {
					 String mave =ve.getMaVe();
					 String maCB =ve.getMaCB();
					 String loaighe =""+ve.getLoaiGhe();
					 String gia =""+ ve.getGiaTien();
					 String makh =""+ ve.getMaKH();
					 String ngaydat =""+ve.getNgayDat();
					 Object[] row = {mave,maCB,loaighe, gia, makh,ngaydat};
					 dtm.addRow(row);
				 }
			 }
			 tblKH.setModel(dtm);
		 }
		 public void updateVe() {
			 	Ve ve =new Ve();
		 		VeBUS vBUS =new VeBUS();
		 		String s=txtdat.getText();//ngaydat
		 		String ma=txtmakh.getText();
		 		KhachHangBus khBUS= new KhachHangBus();
		 		KhachHang kh =new KhachHang();
		 		int result=1;
		 		if(ma.matches("\\d+")) {
		 			kh.setMaKH(Integer.parseInt(ma));
		 			result=khBUS.checkTF(kh);
		 		}
		 		if(ChuyenBay.checkNgay(s, s) && result !=0) {
		 			ve.setMaVe(txtmave.getText());
		 			ve.setMaKH(Integer.parseInt(txtmakh.getText()));
			 		ve.setNgayDat(s);
			 		ve.setTinhTrang(1);
			 		result=vBUS.updateVe(ve);
			 		if(result !=0)
			 		JOptionPane.showMessageDialog(panel,
							 "Cập nhật dữ liệu thành công!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
			 		else
			 			JOptionPane.showMessageDialog(panel,
								 "Cập nhật dữ liệu thất bại!", "Thông báo",
								 JOptionPane.INFORMATION_MESSAGE);
		 		}else {
		 			JOptionPane.showMessageDialog(panel,
							 "Nhập thông tin sai!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
		 		}
		 }
}
