package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import BUS.ChucVuBUS;
import DTO.ChucVu;
import DTO.NhanVien;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;



public class ChucVuGUI {

	 private JFrame frame;
	 private JTextField txtmaCV;
	 private JTextField txtUserpass;
	 private JTextField txtLuong;
	 private JTable tblcv;

	
	 public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
		 public void run() {
			 try {
				 ChucVuGUI window = new ChucVuGUI();
				 window.frame.setVisible(true);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
			}
		 });
	 }


	 public ChucVuGUI() {
		 initialize();
		 loadAllUsers();
	 }

	 /**
	  * Initialize the contents of the frame.
	  */
	 private void initialize() {
		 frame = new JFrame();
		 frame.setBounds(100, 100, 513, 427);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.getContentPane().setLayout(null);
	
		 JPanel pnlInforUser = new JPanel();
		 pnlInforUser.setBorder(new TitledBorder(UIManager
		 .getBorder("TitledBorder.border"),
		 "Th\u00F4ng tin t\u00E0i kho\u1EA3n", TitledBorder.LEADING,
		 TitledBorder.TOP, null, Color.BLUE));
		 pnlInforUser.setBounds(0, 11, 497, 194);
		 frame.getContentPane().add(pnlInforUser);
		 pnlInforUser.setLayout(null);
	
		 JLabel lblUsername = new JLabel("Username");
		 lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblUsername.setBounds(10, 61, 71, 14);
		 pnlInforUser.add(lblUsername);
	
		 txtmaCV = new JTextField();
		 txtmaCV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtmaCV.setColumns(10);
		 txtmaCV.setBounds(91, 58, 235, 20);
		 pnlInforUser.add(txtmaCV);
	
		 JLabel lblUserpass = new JLabel("Userpass");
		 lblUserpass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblUserpass.setBounds(10, 89, 52, 14);
		 pnlInforUser.add(lblUserpass);
	
		 txtUserpass = new JTextField();
		 txtUserpass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtUserpass.setColumns(10);
		 txtUserpass.setBounds(91, 86, 235, 20);
		 pnlInforUser.add(txtUserpass);
	
		 JLabel lblUserrole = new JLabel("Userrole");
		 lblUserrole.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 lblUserrole.setBounds(10, 123, 52, 14);
		 pnlInforUser.add(lblUserrole);
	
		 JButton btnAdd = new JButton("Thêm mới");
		 btnAdd.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 ChucVu cv = new ChucVu();
				 cv.setMaCV(txtmaCV.getText());
				 cv.setTenCV(txtUserpass.getText());
				 cv.setLuong(Integer.parseInt(txtLuong.getText()));
				 ChucVuBUS cvBUS = new ChucVuBUS();
				 try {
					 String ktra = cvBUS.getChucVuByMaCV(txtmaCV.getText());
					 if(ktra =="") {
						 int result = cvBUS.insertChucVu(cv);
						 if (result != 0) {
							 JOptionPane.showMessageDialog(frame,
									 "Thêm dữ liệu thành công!", "Thông báo",
									 JOptionPane.INFORMATION_MESSAGE);
						 }
					 }
					 else
						 JOptionPane.showMessageDialog(frame,
								 "Thêm dữ liệu thất bại!", "Thông báo",
								 JOptionPane.INFORMATION_MESSAGE);
						 
					 loadAllUsers();
				 } catch (Exception ex) {
				     ex.printStackTrace();
				 }
			 }
		 });
		 btnAdd.setIcon(new ImageIcon(
		 "C:\\Users\\Administrator\\workspace\\eProjects\\src\\images\\Actions-list-add-user-icon.png"));
		 btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnAdd.setBounds(90, 152, 115, 31);
		 pnlInforUser.add(btnAdd);
	
		 JButton btnUpdate = new JButton("Cập nhật");
		 btnUpdate.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 ChucVu cv = new ChucVu();
				 cv.setMaCV(txtmaCV.getText());
				 cv.setTenCV(txtUserpass.getText());
				 cv.setLuong(Integer.parseInt(txtLuong.getText()));
				
				 ChucVuBUS cvBUS = new ChucVuBUS();
				 try {
							 @SuppressWarnings("unused")
							 int result = cvBUS.updateChucVu(cv);
							 if (result != 0) {
								 JOptionPane.showMessageDialog(frame,
										 "Cập nhật dữ liệu thành công!", "Thông báo",
										 JOptionPane.INFORMATION_MESSAGE);
							 }
							 else
								 JOptionPane.showMessageDialog(frame,
										 "Cập nhật dữ liệu thất bại!", "Thông báo",
										 JOptionPane.INFORMATION_MESSAGE);
				 	}catch (Exception ex) {
					     ex.printStackTrace();
					 }
				
				 loadAllUsers();
				 }
				 
		 });
		 btnUpdate
		 .setIcon(new ImageIcon(
		 "C:\\Users\\Administrator\\workspace\\eProjects\\src\\images\\Add-Male-User-icon.png"));
		 btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnUpdate.setBounds(208, 152, 107, 31);
		 pnlInforUser.add(btnUpdate);
	
		 JButton btnDelete = new JButton("Xóa");
		 btnDelete.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 ChucVu cv = new ChucVu();
				 cv.setMaCV(txtmaCV.getText());
				 ChucVuBUS cvBUS = new ChucVuBUS();
				 int choice = JOptionPane.showConfirmDialog(frame,
										 "Bạn có chắc chắn xóa dữ liệu!", "Xác nhận",
										 JOptionPane.YES_NO_OPTION);
				 if (choice == JOptionPane.YES_OPTION) {
					 try {
						 	try {
						 		int ktra = cvBUS.checkTF(txtmaCV.getText());
								 if(ktra ==0) {
									 @SuppressWarnings("unused")
									 int result = cvBUS.deleteChucVu(cv);
									 JOptionPane.showMessageDialog(frame,
											 "Xóa dữ liệu thành công!", "Thông báo",
											 JOptionPane.INFORMATION_MESSAGE);
								 }
								 else
									 JOptionPane.showMessageDialog(frame,
											 "Xóa dữ liệu thất bại!", "Thông báo",
											 JOptionPane.INFORMATION_MESSAGE);
						 	}catch (Exception ex) {
							     ex.printStackTrace();
							 }
					 		
							
						 loadAllUsers();
					 } catch (Exception ex) {
					     ex.printStackTrace();
					 }
				 }
			 }
		 });
		 btnDelete
		 .setIcon(new ImageIcon(
		 "C:\\Users\\Administrator\\workspace\\eProjects\\src\\images\\Remove-Male-User-icon.png"));
		 btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 btnDelete.setBounds(317, 152, 99, 31);
		 pnlInforUser.add(btnDelete);
	
		 txtLuong = new JTextField();
		 txtLuong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 txtLuong.setBounds(91, 118, 235, 20);
		 pnlInforUser.add(txtLuong);
		 
		 JButton btnClear = new JButton("Làm lại");
		 btnClear.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		txtmaCV.setText("");
				 txtUserpass.setText("");
				 txtLuong.setText("" );   
				 loadAllUsers();
		 	}
		 });
		 btnClear.setBounds(336, 114, 99, 23);
		 pnlInforUser.add(btnClear);
	
		 JPanel pnlDataUser = new JPanel();
		 pnlDataUser.setBorder(new TitledBorder(UIManager
		 .getBorder("TitledBorder.border"),
		 "D\u1EEF li\u1EC7u ng\u01B0\u1EDDi d\u00F9ng",
		 TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		 pnlDataUser.setBounds(0, 212, 497, 179);
		 frame.getContentPane().add(pnlDataUser);
		 pnlDataUser.setLayout(null);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 23, 477, 145);
		 pnlDataUser.add(scrollPane);
		 
		 	 tblcv = new JTable();
		 	 scrollPane.setViewportView(tblcv);
		 	 tblcv.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		 	 tblcv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 	 tblcv.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent arg0) {
				 int row = tblcv.getSelectedRow();
				 if (row != -1) {
					 txtmaCV.setText(tblcv.getValueAt(row, 0).toString());
					 txtUserpass.setText(tblcv.getValueAt(row, 1).toString());
					 txtLuong.setText(tblcv.getValueAt(row, 2).toString()                                                                                                                                                                                                    .toString());
				 }
			 }
		 	 });
	 }

	 /**
	  * Get all user to display table.
	  */
	 public void loadAllUsers() {
		 String[] header = { "MA_CV", "TEN_CV", "LUONG" };
		 DefaultTableModel dtm = new DefaultTableModel(header, 0);
		 ArrayList<ChucVu> arr = new ArrayList<ChucVu>();
		 ChucVuBUS cvBUS = new ChucVuBUS();
		 arr = cvBUS.getAllChucVu();
		 ChucVu cv = new ChucVu();
		 for (int i = 0; i < arr.size(); i++) {
			 cv = arr.get(i);
			 String macv = cv.getMaCV();
			 String tencv = cv.getTenCV();
			 int luong = cv.getLuong();
			 Object[] row = { macv, tencv, luong };
			 dtm.addRow(row);
		 }
		 tblcv.setModel(dtm);
	 }
	}