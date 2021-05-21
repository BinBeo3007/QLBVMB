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

import BUS.DiaDiemBUS;
import DTO.DiaDiem;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DiaDiemGUI extends JPanel {

	 private JTextField txtMaDD;
	 private JTextField txtTenDD;
	 private JTextField txtGio;
	 private JTable tblcv;
	 JPanel panel;
	 JTextField txtFind;
	/**
	 * Create the panel.
	 */
	public DiaDiemGUI() {
		setLayout(null);
		
		panel= new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 856, 630);
		add(panel);
		initialize();
		 loadAllUsers();

	}
	private void initialize() { 
		 panel.setLayout(null);
		
		 JPanel pnlInforUser = new JPanel();
		 pnlInforUser.setBounds(10, 11, 842, 231);
		 pnlInforUser.setBackground(Color.WHITE);
		 pnlInforUser.setBorder(new TitledBorder(UIManager
		 .getBorder("TitledBorder.border"),
		 "Th\u00F4ng tin địa điểm", TitledBorder.LEADING,
		 TitledBorder.TOP, null, Color.BLUE));
		 panel.add(pnlInforUser);
		 pnlInforUser.setLayout(null);
	
		 JLabel lblmaDD = new JLabel("Mã địa điểm");
		 lblmaDD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblmaDD.setBounds(10, 61, 71, 14);
		 pnlInforUser.add(lblmaDD);
	
		 txtMaDD = new JTextField();
		 txtMaDD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtMaDD.setColumns(10);
		 txtMaDD.setBounds(91, 58, 235, 20);
		 pnlInforUser.add(txtMaDD);
	
		 JLabel lblTenDD = new JLabel("Tên địa điểm");
		 lblTenDD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblTenDD.setBounds(10, 89, 71, 14);
		 pnlInforUser.add(lblTenDD);
	
		 txtTenDD = new JTextField();
		 txtTenDD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtTenDD.setColumns(10);
		 txtTenDD.setBounds(91, 86, 235, 20);
		 pnlInforUser.add(txtTenDD);
	
		 JLabel lblMuiGio = new JLabel("Múi Giờ");
		 lblMuiGio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblMuiGio.setBounds(10, 114, 52, 14);
		 pnlInforUser.add(lblMuiGio);
	
		 JButton btnAdd = new JButton("Thêm mới");
		 btnAdd.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 addDD();
			 }
		 });
		 btnAdd.setIcon(new ImageIcon(
		 "C:\\Users\\Administrator\\workspace\\eProjects\\src\\images\\Actions-list-add-user-icon.png"));
		 btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnAdd.setBounds(20, 148, 115, 31);
		 pnlInforUser.add(btnAdd);
	
		 txtGio = new JTextField();
		 txtGio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtGio.setBounds(91, 117, 235, 20);
		 pnlInforUser.add(txtGio);
		 
		 txtFind = new JTextField("");
		 txtFind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtFind.setBounds(145, 148, 99, 31);
		 pnlInforUser.add(txtFind);
		 
		 JButton btnFind = new JButton("Tìm");
		 btnFind.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		JOptionPane.showMessageDialog(panel,
		 				 "Cập nhật dữ liệu thành công!", "Thông báo",
		 				 JOptionPane.INFORMATION_MESSAGE);
		 				 loadFindNV();
		 	}
		 });
		 btnFind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnFind.setBounds(254, 148, 99, 31);
		 pnlInforUser.add(btnFind);
		 
		 JButton btnClear = new JButton("Làm sạch");
		 btnClear.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		txtMaDD.setText("");
		 		txtTenDD.setText("");
		 		txtGio.setText("");
		 		loadAllUsers();
		 	}
		 });
		 btnClear.setBounds(363, 111, 99, 23);
		 pnlInforUser.add(btnClear);
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\fafaafa.png"));
		 lblNewLabel.setBounds(589, 11, 243, 209);
		 pnlInforUser.add(lblNewLabel);
	
		 JPanel pnlDataUser = new JPanel();
		 pnlDataUser.setBounds(10, 253, 836, 366);
		 pnlDataUser.setBackground(Color.WHITE);
		 pnlDataUser.setBorder(new TitledBorder(UIManager
		 .getBorder("TitledBorder.border"),
		 "",
		 TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		 panel.add(pnlDataUser);
		 pnlDataUser.setLayout(null);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 23, 816, 332);
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
					 txtMaDD.setText(tblcv.getValueAt(row, 0).toString());
					 txtTenDD.setText(tblcv.getValueAt(row, 1).toString());
					 txtGio.setText(tblcv.getValueAt(row, 2).toString()                                                                                                                                                                                                    .toString());
				 }
			 }
		 	 });
	 }

	 /**
	  * Get all user to display table.
	  */
	 public void loadAllUsers() {
		 String[] header = { "Mã Địa Điểm", "Tên Địa Điểm", "Múi Giờ" };
		 DefaultTableModel dtm = new DefaultTableModel(header, 0);
		 ArrayList<DiaDiem> arr = new ArrayList<DiaDiem>();
		 DiaDiemBUS ddBUS = new DiaDiemBUS();
		 arr = ddBUS.getAllDiaDiem();
		 DiaDiem dd = new DiaDiem();
		 for (int i = 0; i < arr.size(); i++) {
			 dd = arr.get(i);
			 String madd = dd.getMaDD();
			 String tendd = dd.getTenDD();
			 String gio = dd.getMuiGio();
			 Object[] row = { madd, tendd, gio };
			 dtm.addRow(row);
		 }
		 tblcv.setModel(dtm);
	 }
	 public void loadFindNV() {
		 String[] header = { "Mã Địa Điểm", "Tên Địa Điểm", "Múi Giờ" };
		 DefaultTableModel dtm = new DefaultTableModel(header, 0);
		 ArrayList<DiaDiem> arr = new ArrayList<DiaDiem>();
		 DiaDiemBUS ddBUS = new DiaDiemBUS();
		 arr = ddBUS.getDD(txtFind.getText());
		 DiaDiem dd = new DiaDiem();
		 for (int i = 0; i < arr.size(); i++) {
			 dd = arr.get(i);
			 String madd = dd.getMaDD();
			 String tendd = dd.getTenDD();
			 String gio = dd.getMuiGio();
			 Object[] row = { madd, tendd, gio };
			 dtm.addRow(row);
		 }
		 tblcv.setModel(dtm);
	 }
	 public boolean checkTrong() {
		 if(txtMaDD.getText().equals("")||txtTenDD.getText().equals("")||txtGio.getText().equals(""))
			 return false;
		 return true;
	 }
	 public void addDD() {
		 if(checkTrong()) {
			 DiaDiem dd = new DiaDiem();
			 dd.setMaDD(txtMaDD.getText());
			 dd.setTenDD(txtTenDD.getText());
			 dd.setMuiGio(txtGio.getText());
			 DiaDiemBUS ddBUS = new DiaDiemBUS();
			 try {
				 int result = ddBUS.insertDiaDiem(dd);
				 if (result != 0) {
					 JOptionPane.showMessageDialog(panel,
							 "Thêm dữ liệu thành công!", "Thông báo",
							 JOptionPane.INFORMATION_MESSAGE);
				 }
				 loadAllUsers();
			 } catch (Exception ex) {
			     ex.printStackTrace();
			 }
		 }
		 else
			 JOptionPane.showMessageDialog(panel,
					 "Chưa điền hết thông tin!", "Thông báo",
					 JOptionPane.INFORMATION_MESSAGE);

	 }
	 
	
	
	
	


}
