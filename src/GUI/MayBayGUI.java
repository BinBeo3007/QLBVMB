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

import BUS.MayBayBUS;
import DTO.MayBay;

public class MayBayGUI extends JPanel {
	JPanel panel;
	private JTextField txttenMB;
	private JTable tblKH;
	private JTextField txttong;
	private JTextField txtSX;
	private JTextField txtloai2;
	private JTextField txtloai1;
	private JTextField txtmaMB;
	JComboBox cbbFind;
	private JTextField txtFind;

	/**
	 * Create the panel.
	 */
	public MayBayGUI() {
		setLayout(null);
		panel = new JPanel();
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
		 "Th\u00F4ng tin Máy Bay", TitledBorder.LEADING,
		 TitledBorder.TOP, null, Color.BLUE));
		 pnlInforUser.setBounds(10, 11, 846, 285);
		 
		 panel.add(pnlInforUser);
		 pnlInforUser.setLayout(null);

		 JLabel lblMa = new JLabel("Mã máy bay");
		 lblMa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblMa.setBounds(10, 64, 96, 14);
		 pnlInforUser.add(lblMa);
		 
		 txttong = new JTextField();
		 txttong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txttong.setBounds(363, 117, 90, 20);
		 pnlInforUser.add(txttong);
		 txttong.setColumns(10);
		 txttong.setEditable(false);

		 JLabel lblLot = new JLabel("Tên máy bay");
		 lblLot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblLot.setBounds(10, 89, 71, 14);
		 pnlInforUser.add(lblLot);

		 txttenMB = new JTextField();
		 txttenMB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txttenMB.setColumns(10);
		 txttenMB.setBounds(116, 86, 90, 20);
		 pnlInforUser.add(txttenMB);

		 JButton btnAdd = new JButton("Thêm mới");
		 btnAdd.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Actions-list-add-user-icon.png"));
		 btnAdd.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 addMB();
			 }
		 });
		 btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnAdd.setBounds(10, 176, 115, 31);
		 pnlInforUser.add(btnAdd);
		 
		 JLabel lblTen = new JLabel("Hãng SX");
		 lblTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblTen.setBounds(10, 120, 71, 14);
		 pnlInforUser.add(lblTen);
		 
		 txtSX = new JTextField();
		 txtSX.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtSX.setColumns(10);
		 txtSX.setBounds(116, 117, 90, 20);
		 pnlInforUser.add(txtSX);
		 
		 JLabel lblnamsinh = new JLabel("Số ghế loại 2");
		 lblnamsinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblnamsinh.setBounds(274, 89, 71, 14);
		 pnlInforUser.add(lblnamsinh);
		 
		 JLabel lblcmnd = new JLabel("Số ghế loại 1");
		 lblcmnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblcmnd.setBounds(274, 61, 79, 14);
		 pnlInforUser.add(lblcmnd);
		 
		 JLabel lblsdt = new JLabel("Tổng ghế");
		 lblsdt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblsdt.setBounds(274, 120, 71, 14);
		 pnlInforUser.add(lblsdt);
		 
		 txtloai2 = new JTextField();
		 txtloai2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtloai2.setColumns(10);
		 txtloai2.setBounds(363, 86, 90, 20);
		 pnlInforUser.add(txtloai2);
		 
		 txtloai1 = new JTextField();
		 txtloai1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtloai1.setColumns(10);
		 txtloai1.setBounds(363, 58, 90, 20);
		 pnlInforUser.add(txtloai1);
		 
		 txtmaMB = new JTextField();
		 txtmaMB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtmaMB.setColumns(10);
		 txtmaMB.setBounds(116, 58, 90, 20);
		 pnlInforUser.add(txtmaMB);
		 
		 JButton btnGet = new JButton("Tìm kiếm");
		 btnGet.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		JOptionPane.showMessageDialog(panel,
		 				 "Cập nhật dữ liệu thành công!", "Thông báo",
		 				 JOptionPane.INFORMATION_MESSAGE);
		 				 loadFindNV();
		 	}
		 });
		 btnGet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnGet.setBounds(252, 216, 107, 31);
		 pnlInforUser.add(btnGet);
		 
		 txtFind = new JTextField();
		 txtFind.setBounds(135, 217, 107, 31);
		 pnlInforUser.add(txtFind);
		 txtFind.setColumns(10);
		 
		 cbbFind = new JComboBox();
		 cbbFind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 cbbFind.setModel(new DefaultComboBoxModel(new String[] {"Mã MB", "Hãng SX", "Tổng ghế"}));
		 cbbFind.setBounds(10, 218, 115, 26);
		 pnlInforUser.add(cbbFind);
		 
		 JButton btnClear = new JButton("Làm lại");
		 btnClear.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		 txttenMB.setText("");
		 		 txtSX.setText("");
		 		 txtloai1.setText("");
		 		 txtmaMB.setText("");
		 		 txtloai2.setText("");
		 		 txttong.setText("");
		 		loadAllUsers();
		 	}
		 });
		 btnClear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnClear.setBounds(364, 148, 89, 23);
		 pnlInforUser.add(btnClear);
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\ada.png"));
		 lblNewLabel.setBounds(576, 11, 260, 263);
		 pnlInforUser.add(lblNewLabel);

		 JPanel pnlDataUser = new JPanel();
		 pnlDataUser.setBackground(Color.WHITE);
		 pnlDataUser.setBorder(new TitledBorder(UIManager
		 .getBorder("TitledBorder.border"),
		 "D\u1EEF li\u1EC7u máy bay",
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
			 			 txtmaMB.setText(tblKH.getValueAt(row, 0).toString().trim());
			 			 txttenMB.setText(tblKH.getValueAt(row, 1).toString());
				 		 txtSX.setText(tblKH.getValueAt(row, 2).toString());
			 			txtloai1.setText(tblKH.getValueAt(row, 3).toString());
				 		 txtloai2.setText(tblKH.getValueAt(row, 4).toString());
				 		 txttong.setText(tblKH.getValueAt(row, 5).toString());
			 		 }
		 		 }
		 	});
		 }

		 /**
		  * Get all user to display table.
		  */
		 public void loadAllUsers() {
			 String[] header = {"Mã Máy Bay","Tên Máy Bay",  "Hãng SX" ,"Số ghế loại 1", "Số ghế loại 2", " Tổng ghế"};
			 DefaultTableModel dtm = new DefaultTableModel(header,0);
			 ArrayList<MayBay> arr = new ArrayList<MayBay>();
			 MayBayBUS mbBUS = new MayBayBUS();
			 arr = mbBUS.getALLMB();
			 MayBay maybay = new MayBay();
			 for (int i = 0; i < arr.size(); i++) {
				 maybay = arr.get(i);
				 String maMB =""+maybay.getMaMB();
				 String tenMB = maybay.getTenMB();
				 String sx = maybay.getHang_SX();
				 String loai1 = ""+maybay.getGheloai1();
				 String loai2 =""+ maybay.getGheloai2();
				 String tong =""+ maybay.getTongghe();
				 Object[] row = {maMB, tenMB, sx, loai1, loai2, tong};
				 dtm.addRow(row);
			 }
			 tblKH.setModel(dtm);
		 }
		 public void loadFindNV() {
			 String[] header = {"Mã Máy Bay","Tên Máy Bay",  "Hãng SX" ,"Số ghế loại 1", "Số ghế loại 2", " Tổng ghế"};
			 DefaultTableModel dtm = new DefaultTableModel(header, 0);
			 ArrayList<MayBay> arr = new ArrayList<MayBay>();
			 MayBayBUS mbBUS = new MayBayBUS();
			 MayBay maybay = new MayBay();
			 String temp = cbbFind.getSelectedItem().toString();
			 if(temp == "Mã MB") {
				 arr = mbBUS.getMBbyMaMB2(txtFind.getText());
			 }else if(temp == "Hãng SX")
				 arr= mbBUS.getMBbySX(txtFind.getText());
				 else
					 arr =mbBUS.getMBbyTongGhe(Integer.parseInt(txtFind.getText()));
			 
			 for (int i = 0; i < arr.size(); i++) {
				 maybay = arr.get(i);
				 String maMB =""+maybay.getMaMB();
				 String tenMB = maybay.getTenMB();
				 String sx = maybay.getHang_SX();
				 String loai1 = ""+maybay.getGheloai1();
				 String loai2 =""+ maybay.getGheloai2();
				 String tong =""+ maybay.getTongghe();
				 Object[] row = {maMB, tenMB, sx, loai1, loai2, tong};
				 dtm.addRow(row);
			 }
			 tblKH.setModel(dtm);
		 }
		 public boolean checkTrong() {
			 if(txtmaMB.getText().equals("")||txttenMB.getText().equals("")||txtSX.getText().equals("")||txtloai1.getText().equals("")||txtloai2.getText().equals(""))
				 return false;
			 return true;
		 }
		 public void addMB() {
			 if(checkTrong()) {
				 MayBay maybay = new MayBay();
				 maybay.setMaMB(txtmaMB.getText());
				 maybay.setTenMB(txttenMB.getText());
				 maybay.setHang_SX(txtSX.getText());
				 maybay.setGheloai1(Integer.parseInt(txtloai1.getText()));
				 maybay.setGheloai2(Integer.parseInt(txtloai2.getText()));
				 int temp= Integer.parseInt(txtloai1.getText()) +Integer.parseInt(txtloai2.getText());
				 maybay.setTongghe(temp);
				 MayBayBUS mbBUS = new MayBayBUS();
				 try {
					 int result = mbBUS.insertMayBay(maybay);
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
						 "Chưa nhập hết thông tin!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
				 
		 }
}
