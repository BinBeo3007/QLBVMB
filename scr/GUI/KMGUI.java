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

import BUS.KMBUS;
import BUS.MayBayBUS;
import BUS.TaiKhoanBUS;
import DTO.ChuyenBay;
import DTO.KM;
import DTO.MayBay;
import DTO.TaiKhoan;

public class KMGUI extends JPanel {
	JPanel panel;
	private JTextField txtso;
	private JTable tblKH;
	private JTextField txtkt;
	private JTextField txtbd;
	private JTextField txtmakm;
	private JTextField txtFind;
	public KMGUI() {
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
		 "", TitledBorder.LEADING,
		 TitledBorder.TOP, null, Color.BLUE));
		 pnlInforUser.setBounds(10, 11, 846, 285);
		 
		 panel.add(pnlInforUser);
		 pnlInforUser.setLayout(null);

		 JLabel lblMa = new JLabel("Mã khuyến mãi");
		 lblMa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblMa.setBounds(10, 64, 96, 14);
		 pnlInforUser.add(lblMa);

		 JLabel lblLot = new JLabel("Phần Trăm");
		 lblLot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblLot.setBounds(10, 89, 71, 14);
		 pnlInforUser.add(lblLot);

		 txtso = new JTextField();
		 txtso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtso.setColumns(10);
		 txtso.setBounds(116, 86, 90, 20);
		 pnlInforUser.add(txtso);

		 JButton btnAdd = new JButton("Thêm");
		 btnAdd.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Actions-list-add-user-icon.png"));
		 btnAdd.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 addKM();
			 }
		 });
		 btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnAdd.setBounds(10, 158, 107, 31);
		 pnlInforUser.add(btnAdd);
		 
		 JLabel lblnamsinh = new JLabel("Ngày kết thúc");
		 lblnamsinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblnamsinh.setBounds(252, 89, 79, 14);
		 pnlInforUser.add(lblnamsinh);
		 
		 JLabel lblcmnd = new JLabel("Ngày bắt đầu");
		 lblcmnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblcmnd.setBounds(252, 61, 79, 14);
		 pnlInforUser.add(lblcmnd);
		 
		 txtkt = new JTextField();
		 txtkt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtkt.setColumns(10);
		 txtkt.setBounds(363, 86, 90, 20);
		 pnlInforUser.add(txtkt);
		 
		 txtbd = new JTextField();
		 txtbd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtbd.setColumns(10);
		 txtbd.setBounds(363, 58, 90, 20);
		 pnlInforUser.add(txtbd);
		 
		 txtmakm = new JTextField();
		 txtmakm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtmakm.setColumns(10);
		 txtmakm.setBounds(116, 58, 90, 20);
		 pnlInforUser.add(txtmakm);
		 
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
		 btnGet.setBounds(10, 216, 107, 31);
		 pnlInforUser.add(btnGet);
		 
		 txtFind = new JTextField();
		 txtFind.setBounds(135, 217, 107, 31);
		 pnlInforUser.add(txtFind);
		 txtFind.setColumns(10);
		 
		 JButton btnClear = new JButton("Clear");
		 btnClear.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\iconfinder_ilustracoes_04-09_1519785 (1).png"));
		 btnClear.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		 txtso.setText("");
		 		 txtbd.setText("");
		 		 txtmakm.setText("");
		 		 txtkt.setText("");
		 		loadAllUsers();
		 	}
		 });
		 btnClear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnClear.setBounds(364, 117, 89, 23);
		 pnlInforUser.add(btnClear);
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\hhhh.png"));
		 lblNewLabel.setBounds(576, 11, 260, 263);
		 pnlInforUser.add(lblNewLabel);
		 
		 JButton btnupdate = new JButton("Cập nhật");
		 btnupdate.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		updateKM();
		 	}
		 });
		 btnupdate.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Add-Male-User-icon.png"));
		 btnupdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnupdate.setBounds(135, 158, 107, 31);
		 pnlInforUser.add(btnupdate);
		 
		 JButton btnXa = new JButton("Xóa");
		 btnXa.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		deleteKM();
		 	}
		 });
		 btnXa.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\Remove-Male-User-icon.png"));
		 btnXa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnXa.setBounds(252, 158, 107, 31);
		 pnlInforUser.add(btnXa);

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
			 			 txtmakm.setText(tblKH.getValueAt(row, 0).toString().trim());
			 			 txtso.setText(tblKH.getValueAt(row, 1).toString());
			 			txtbd.setText(tblKH.getValueAt(row, 2).toString());
				 		 txtkt.setText(tblKH.getValueAt(row, 3).toString());
			 		 }
		 		 }
		 	});
		 }

		 /**
		  * Get all user to display table.
		  */
		 public void loadAllUsers() {
			 String[] header = {"Mã Khuyến Mãi","Phần Trăm",  "Ngày Bắt Đầu" ,"Ngày Kết Thúc"};
			 DefaultTableModel dtm = new DefaultTableModel(header,0);
			 ArrayList<KM> arr = new ArrayList<KM>();
			 KMBUS kmB = new KMBUS();
			 arr = kmB.getAllKM();
			 KM km = new KM();
			 for (int i = 0; i < arr.size(); i++) {
				 km = arr.get(i);
				 String makm =""+km.getMakm();
				 String bd = km.getBatdau();
				 String kt = km.getKetthuc();
				 String so = ""+km.getPhantram();
				 Object[] row = {makm, so, bd, kt};
				 dtm.addRow(row);
			 }
			 tblKH.setModel(dtm);
		 }
		 public void loadFindNV() {
			 String[] header = {"Mã Khuyến Mãi","Phần Trăm",  "Ngày Bắt Đầu" ,"Ngày Kết Thúc"};
			 DefaultTableModel dtm = new DefaultTableModel(header,0);
			 ArrayList<KM> arr = new ArrayList<KM>();
			 KMBUS kmB = new KMBUS();
			 KM km = new KM();
			 arr=kmB.getAllKMbyMaKM(txtFind.getText());
			 
			 for (int i = 0; i < arr.size(); i++) {
				 km = arr.get(i);
				 String makm =""+km.getMakm();
				 String bd = km.getBatdau();
				 String kt = km.getKetthuc();
				 String so = ""+km.getPhantram();
				 Object[] row = {makm, so, bd, kt};
				 dtm.addRow(row);
			 }
			 tblKH.setModel(dtm);
		 }
		 public boolean checkTrong() {
			 if(txtmakm.getText().equals("")||txtso.getText().equals("")||txtbd.getText().equals("")||txtkt.getText().equals(""))
				 return false;
			 return true;
		 }
		 public void addKM() {
			 if(checkTrong()) {
				 if(!(txtso.getText().matches("\\d+"))||!ChuyenBay.checkNgay(txtbd.getText(),txtkt.getText())) {
					 JOptionPane.showMessageDialog(panel,
							 "Thêm dữ liệu thất bại!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
					 return;
				 }
					 
				 KM km = new KM();
				 km.setMakm(txtmakm.getText());
				 km.setPhantram(Integer.parseInt(txtso.getText()));
				 km.setBatdau(txtbd.getText());
				 km.setKetthuc(txtkt.getText());
				 KMBUS kmB = new KMBUS();
				 try {
					 int result = kmB.insertKM(km);
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
		 public void updateKM() {
			 if(checkTrong()) {
				 if(!(txtso.getText().matches("\\d+"))||!ChuyenBay.checkNgay(txtbd.getText(),txtkt.getText())) {
					 JOptionPane.showMessageDialog(panel,
							 "Cập nhật dữ liệu thất bại!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
					 return;
				 }
					 
				 KM km = new KM();
				 km.setMakm(txtmakm.getText());
				 km.setPhantram(Integer.parseInt(txtso.getText()));
				 km.setBatdau(txtbd.getText());
				 km.setKetthuc(txtkt.getText());
				 KMBUS kmB = new KMBUS();
				 try {
					 int result = kmB.updateKM(km);
					 if (result != 0) {
						 JOptionPane.showMessageDialog(panel,
						 "Cập nhật dữ liệu thành công!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
					 }
					 else
						 JOptionPane.showMessageDialog(panel,
								 "Cập nhật dữ liệu thất bại!", "Thông báo",
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
		 
		 public void deleteKM() {
			 int choice = JOptionPane.showConfirmDialog(panel,
					 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
					 JOptionPane.YES_NO_OPTION);
			 if (choice == JOptionPane.YES_OPTION) {
				 if(!checkTrong()) {
					 JOptionPane.showMessageDialog(panel,
							 "Xóa dữ liệu thất bại!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
					 return;
				 }
				 try {
					 KMBUS kmB = new KMBUS();
					 int result = kmB.deleteKM(txtmakm.getText());
					 if (result != 0) {
						 JOptionPane.showMessageDialog(panel,
						 "Xóa liệu thành công!", "Thông báo",
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
}
