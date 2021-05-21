package GUI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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

import BUS.ChucVuBUS;
import BUS.DiaDiemBUS;
import BUS.SanBayBUS;
import DTO.ChucVu;
import DTO.SanBay;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SanBayGUI extends JPanel {

	 private JTextField txtMaSB;
	 private JTextField txtTenSB;
	 private JTextField txtMaDD;
	 private JTable tblcv;
	 JPanel panel;
	 JTextField txtFind;
	/**
	 * Create the panel.
	 */
	public SanBayGUI() {
		setLayout(null);
		
		panel= new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 866, 622);
		add(panel);
		initialize();
		 loadAllUsers();

	}
	private void initialize() { 
		 panel.setLayout(null);
		
		 JPanel pnlInforUser = new JPanel();
		 pnlInforUser.setBounds(10, 11, 846, 231);
		 pnlInforUser.setBackground(Color.WHITE);
		 pnlInforUser.setBorder(new TitledBorder(UIManager
		 .getBorder("TitledBorder.border"),
		 "Th\u00F4ng tin Sân Bay", TitledBorder.LEADING,
		 TitledBorder.TOP, null, Color.BLUE));
		 panel.add(pnlInforUser);
		 pnlInforUser.setLayout(null);
	
		 JLabel lblmaDD = new JLabel("Mã Sân Bay");
		 lblmaDD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblmaDD.setBounds(10, 61, 71, 14);
		 pnlInforUser.add(lblmaDD);
	
		 txtMaSB = new JTextField();
		 txtMaSB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtMaSB.setColumns(10);
		 txtMaSB.setBounds(91, 58, 235, 20);
		 pnlInforUser.add(txtMaSB);
	
		 JLabel lblTenSb = new JLabel("Tên sân bay");
		 lblTenSb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblTenSb.setBounds(10, 89, 71, 14);
		 pnlInforUser.add(lblTenSb);
	
		 txtTenSB = new JTextField();
		 txtTenSB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtTenSB.setColumns(10);
		 txtTenSB.setBounds(91, 86, 235, 20);
		 pnlInforUser.add(txtTenSB);
	
		 JLabel lblMuiGio = new JLabel("Mã địa điểm");
		 lblMuiGio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblMuiGio.setBounds(10, 114, 71, 14);
		 pnlInforUser.add(lblMuiGio);
	
		 JButton btnAdd = new JButton("Thêm mới");
		 btnAdd.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 addSB();
			 }
		 });
		 btnAdd.setIcon(new ImageIcon(
		 "C:\\Users\\Administrator\\workspace\\eProjects\\src\\images\\Actions-list-add-user-icon.png"));
		 btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnAdd.setBounds(10, 148, 99, 31);
		 pnlInforUser.add(btnAdd);
	
		 txtMaDD = new JTextField();
		 txtMaDD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtMaDD.setBounds(91, 117, 235, 20);
		 pnlInforUser.add(txtMaDD);
		 
		 txtFind = new JTextField("");
		 txtFind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtFind.setBounds(119, 148, 99, 31);
		 pnlInforUser.add(txtFind);
		 
		 JButton btnFind = new JButton("Tìm");
		 btnFind.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		JOptionPane.showMessageDialog(panel,
		 				 "Cập nhật dữ liệu thành công!", "Thông báo",
		 				 JOptionPane.INFORMATION_MESSAGE);
		 				 loadFindSB();
		 	}
		 });
		 btnFind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnFind.setBounds(227, 148, 99, 31);
		 pnlInforUser.add(btnFind);
		 
		 JButton btnClear = new JButton("Làm sạch");
		 btnClear.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		txtMaSB.setText("");
		 		txtTenSB.setText("");
		 		txtMaDD.setText("");
		 		loadAllUsers();
		 	}
		 });
		 btnClear.setBounds(361, 58, 99, 23);
		 pnlInforUser.add(btnClear);
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\agaagage.png"));
		 lblNewLabel.setBounds(553, 11, 283, 209);
		 pnlInforUser.add(lblNewLabel);
	
		 JPanel pnlDataUser = new JPanel();
		 pnlDataUser.setBounds(10, 253, 846, 358);
		 pnlDataUser.setBackground(Color.WHITE);
		 pnlDataUser.setBorder(new TitledBorder(UIManager
		 .getBorder("TitledBorder.border"),
		 "",
		 TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		 panel.add(pnlDataUser);
		 pnlDataUser.setLayout(null);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 23, 826, 324);
		 pnlDataUser.add(scrollPane);
		 
		 	 tblcv = new JTable();
		 	 tblcv.setBackground(Color.WHITE);
		 	 scrollPane.setViewportView(tblcv);
		 	 tblcv.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		 	 tblcv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 	 tblcv.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent arg0) {
				 int row = tblcv.getSelectedRow();
				 if (row != -1) {
					 txtMaSB.setText(tblcv.getValueAt(row, 0).toString());
					 txtTenSB.setText(tblcv.getValueAt(row, 1).toString());
					 DiaDiemBUS dd =new DiaDiemBUS();
					 String temp= dd.getMaDDByDD(tblcv.getValueAt(row, 2).toString().trim());
					 txtMaDD.setText(temp                                                                                                                                                                                                 .toString());
				 }
			 }
		 	 });
	 }

	 /**
	  * Get all user to display table.
	  */
	 public void loadAllUsers() {
		 String[] header = { "Mã Sân Bay", "Tên Sân Bay", "Tên Địa Điểm" };
		 DefaultTableModel dtm = new DefaultTableModel(header, 0);
		 ArrayList<SanBay> arr = new ArrayList<SanBay>();
		 SanBayBUS sbBUS = new SanBayBUS();
		 DiaDiemBUS ddBUS = new DiaDiemBUS();
		 arr = sbBUS.getAllSB();
		 SanBay sb = new SanBay();
		 for (int i = 0; i < arr.size(); i++) {
			 sb = arr.get(i);
			 String masb = sb.getMaSB();
			 String tensb = sb.getTenSB();
			 String tendd = ddBUS.getDDByMaDD(sb.getMaDD());
			 Object[] row = { masb, tensb, tendd };
			 dtm.addRow(row);
		 }
		 tblcv.setModel(dtm);
	 }
	 public void loadFindSB() {
		 String[] header = { "Mã Sân Bay", "Tên Sân Bay", "Tên Địa Điểm" };
		 DefaultTableModel dtm = new DefaultTableModel(header, 0);
		 ArrayList<SanBay> arr = new ArrayList<SanBay>();
		 SanBayBUS sbBUS = new SanBayBUS();
		 DiaDiemBUS ddBUS = new DiaDiemBUS();
		 SanBay sb = new SanBay();
		 arr = sbBUS.getSB(txtFind.getText());
		 for (int i = 0; i < arr.size(); i++) {
			 sb = arr.get(i);
			 String masb = sb.getMaSB();
			 String tensb = sb.getTenSB();
			 String tendd = ddBUS.getDDByMaDD(sb.getMaDD());
			 Object[] row = { masb, tensb, tendd };
			 dtm.addRow(row);
		 }
		 tblcv.setModel(dtm);
	 }
	 public boolean checkTrong() {
		 if(txtMaSB.getText().equals("")||txtTenSB.getText().equals("")||txtMaDD.getText().equals(""))
			 return false;
		 return true;
	 }
	 public void addSB() {
		 DiaDiemBUS ddB= new DiaDiemBUS();
		 if(checkTrong()) {
			 if(ddB.getDDByMaDD(txtMaDD.getText())!="") {
				 SanBay sb = new SanBay();
				 sb.setMaSB(txtMaSB.getText());
				 sb.setTenSB(txtTenSB.getText());
				 sb.setMaDD(txtMaDD.getText());
				 SanBayBUS sbBUS = new SanBayBUS();
				 try {
					 String ktra = sbBUS.getDDByMaSB(txtMaSB.getText());
					 if(ktra =="") {
						 int result = sbBUS.insertSanBay(sb);
						 if (result != 0) {
							 JOptionPane.showMessageDialog(panel,
									 "Thêm dữ liệu thành công!", "Thông báo",
									 JOptionPane.INFORMATION_MESSAGE);
						 }
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
			 else {
				 JOptionPane.showMessageDialog(panel,
						 "Không có mã địa điểm!", "Thông báo",
						 JOptionPane.INFORMATION_MESSAGE);
			 }
		 }
		 else
			 JOptionPane.showMessageDialog(panel,
					 "Chưa điền hết thông tin!", "Thông báo",
					 JOptionPane.INFORMATION_MESSAGE);
	 }
	 
	
	
	
	


}
