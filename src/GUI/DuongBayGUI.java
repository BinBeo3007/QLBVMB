package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import BUS.DuongBayBUS;
import BUS.SanBayBUS;
import DTO.DuongBay;

public class DuongBayGUI extends JPanel {

	private JTextField txtMaDB;
	 private JTextField txtMaSBDi;
	 private JTextField txtMaSBDen;
	 private JTable tblcv;
	 JPanel panel;
	 JTextField txtFind;
	/**
	 * Create the panel.
	 */
	public DuongBayGUI() {
		setLayout(null);
		
		panel= new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 866, 623);
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
		 "", TitledBorder.LEADING,
		 TitledBorder.TOP, null, Color.BLUE));
		 panel.add(pnlInforUser);
		 pnlInforUser.setLayout(null);
	
		 JLabel lblmaDB = new JLabel("Mã Đường Bay");
		 lblmaDB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblmaDB.setBounds(10, 61, 79, 14);
		 pnlInforUser.add(lblmaDB);
	
		 txtMaDB = new JTextField();
		 txtMaDB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtMaDB.setColumns(10);
		 txtMaDB.setBounds(112, 58, 106, 20);
		 pnlInforUser.add(txtMaDB);
	
		 JLabel lblTenSb = new JLabel("SB Đi");
		 lblTenSb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblTenSb.setBounds(10, 92, 71, 14);
		 pnlInforUser.add(lblTenSb);
	
		 txtMaSBDi = new JTextField();
		 txtMaSBDi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtMaSBDi.setColumns(10);
		 txtMaSBDi.setBounds(112, 89, 106, 20);
		 pnlInforUser.add(txtMaSBDi);
	
		 JLabel lblMuiGio = new JLabel("SB Đến");
		 lblMuiGio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblMuiGio.setBounds(10, 123, 71, 14);
		 pnlInforUser.add(lblMuiGio);
	
		 JButton btnAdd = new JButton("Thêm mới");
		 btnAdd.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 addDB();
			 }
		 });
		 btnAdd.setIcon(new ImageIcon(
		 "C:\\Users\\Administrator\\workspace\\eProjects\\src\\images\\Actions-list-add-user-icon.png"));
		 btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnAdd.setBounds(10, 148, 92, 31);
		 pnlInforUser.add(btnAdd);
	
		 txtMaSBDen = new JTextField();
		 txtMaSBDen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtMaSBDen.setBounds(112, 117, 106, 20);
		 pnlInforUser.add(txtMaSBDen);
		 
		 txtFind = new JTextField("");
		 txtFind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtFind.setBounds(112, 148, 106, 31);
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
		 btnFind.setBounds(228, 148, 99, 31);
		 pnlInforUser.add(btnFind);
		 
		 JButton btnClear = new JButton("Làm sạch");
		 btnClear.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		txtMaDB.setText("");
		 		txtMaSBDi.setText("");
		 		txtMaSBDen.setText("");
		 		loadAllUsers();
		 	}
		 });
		 btnClear.setBounds(228, 114, 99, 23);
		 pnlInforUser.add(btnClear);
		 
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Bin\\eclipse-workspace\\javaswingsgu\\src\\img\\adafaf.png"));
		 lblNewLabel.setBounds(595, 0, 241, 220);
		 pnlInforUser.add(lblNewLabel);
	
		 JPanel pnlDataUser = new JPanel();
		 pnlDataUser.setBounds(10, 253, 846, 359);
		 pnlDataUser.setBackground(Color.WHITE);
		 pnlDataUser.setBorder(new TitledBorder(UIManager
		 .getBorder("TitledBorder.border"),
		 "",
		 TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		 panel.add(pnlDataUser);
		 pnlDataUser.setLayout(null);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 23, 826, 325);
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
					 txtMaDB.setText(tblcv.getValueAt(row, 0).toString());
					 txtMaSBDi.setText(tblcv.getValueAt(row, 1).toString());
					 txtMaSBDen.setText(tblcv.getValueAt(row, 2).toString()                                                                                                                                                                                              .toString());
				 }
			 }
		 	 });
	 }

	 /**
	  * Get all user to display table.
	  */
	 public void loadAllUsers() {
		 String[] header = { "Mã Đường Bay", "Sân Bay Đi", "Sân Bay Đến" };
		 DefaultTableModel dtm = new DefaultTableModel(header, 0);
		 ArrayList<DuongBay> arr = new ArrayList<DuongBay>();
		 DuongBayBUS dbBUS = new DuongBayBUS();
		 arr = dbBUS.getAllDB();
		 DuongBay db = new DuongBay();
		 for (int i = 0; i < arr.size(); i++) {
			 db = arr.get(i);
			 String madb = db.getMaDB();
			 String sbdi = db.getMaSBdi();
			 String sbden = db.getMaSBDen();
			 Object[] row = { madb, sbdi, sbden };
			 dtm.addRow(row);
		 }
		 tblcv.setModel(dtm);
	 }
	 public void loadFindSB() {
		 String[] header = { "Mã Đường Bay", "Sân Bay Đi", "Sân Bay Đến" };
		 DefaultTableModel dtm = new DefaultTableModel(header, 0);
		 ArrayList<DuongBay> arr = new ArrayList<DuongBay>();
		 DuongBayBUS dbBUS = new DuongBayBUS();
		 arr = dbBUS.getDB(txtFind.getText());
		 DuongBay db = new DuongBay();
		 for (int i = 0; i < arr.size(); i++) {
			 db = arr.get(i);
			 String madb = db.getMaDB();
			 String sbdi = db.getMaSBdi();
			 String sbden = db.getMaSBDen();
			 Object[] row = { madb, sbdi, sbden };
			 dtm.addRow(row);
		 }
		 tblcv.setModel(dtm);
	 }
	 public boolean checkSB(DuongBay db) {
		 SanBayBUS sbB= new SanBayBUS();
		 if(db.getMaSBdi().equals(db.getMaSBDen())||sbB.getDDByMaSB(db.getMaSBdi()).equals("")||sbB.getDDByMaSB(db.getMaSBDen()).equals("")||db.getMaDB().equals(""))
			 return false;
		 return true;
	 }
	 
	 public void addDB() {
		 DuongBay db = new DuongBay();
		 db.setMaDB(txtMaDB.getText());
		 db.setMaSBdi(txtMaSBDi.getText());
		 db.setMaSBDen(txtMaSBDen.getText());
		 DuongBayBUS dbBUS = new DuongBayBUS();
		 int ktra = dbBUS.checkTF(txtMaDB.getText());
		
		 if(!checkSB(db)) 
		 {
			 JOptionPane.showMessageDialog(panel,
					 "Nhập đường bay sai", "Thông báo",
					 JOptionPane.INFORMATION_MESSAGE);
			 return;
		 }
		 try {
			
			 
			 if(ktra ==0 ) {
				 int result = dbBUS.insertDuongBay(db);
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

}
